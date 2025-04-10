package com.julio.clpmonitor.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.julio.clpmonitor.clp.PlcConnector;
import com.julio.clpmonitor.model.ClpData;

import jakarta.annotation.PostConstruct;

@Service
public class ClpSimulatorService {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    private PlcConnector plcConnectorEstoque;
    public static byte[] indexColorEst = new byte[28];

    private PlcConnector plcConnectorExpedicao;
    public static byte[] indexColorExp = new byte[28];

    @PostConstruct

    public void startSimulation() {
        // Agendamento separado para CLP 1 (800ms)
        executor.scheduleAtFixedRate(this::sendClp1Update, 0, 40, TimeUnit.SECONDS);

        // Agendamento para CLPs 2 a 4 (1 segundo)
        executor.scheduleAtFixedRate(this::sendClp2to4Updates, 0, 3, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(this::sendExpeditionUpdate, 0, 40, TimeUnit.SECONDS);
    }

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(0L);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        return emitter;
    }

    private void sendClp1Update() {
        plcConnectorEstoque = new PlcConnector("10.74.241.10", 102);
        List<Integer> byteArray = new ArrayList<>();

        try {
            plcConnectorEstoque.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            indexColorEst = plcConnectorEstoque.readBlock(9, 68, 28);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 28; i++) {
            byteArray.add((int) indexColorEst[i]);
        }

        ClpData clp1 = new ClpData(1, byteArray);
        sendToEmitters("clp1-data", clp1);

    }

    private void sendExpeditionUpdate() {
        plcConnectorExpedicao = new PlcConnector("10.74.241.10", 102);
        List<Integer> byteArray = new ArrayList<>();
        int returns[] = new int[12];

        try {
            plcConnectorExpedicao.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int j = 0;
            for (int i = 6; i <= 28; i += 2) {
                returns[j] = plcConnectorExpedicao.readInt(9, i);
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 12; i++) {
            byteArray.add(returns[i]);
        }

        ClpData expeditionData = new ClpData(5, byteArray);
        sendToEmitters("expedition-data", expeditionData);
    }

    private void sendClp2to4Updates() {
        Random rand = new Random();

        sendToEmitters("clp2-data", new ClpData(2, rand.nextInt(100)));
        sendToEmitters("clp3-data", new ClpData(3, rand.nextInt(100)));
        sendToEmitters("clp4-data", new ClpData(4, rand.nextInt(100)));
    }

    // sendToEmitters() – Envia um evento SSE para todos os clientes
    private void sendToEmitters(String eventName, ClpData clpData) {
        // Percorre todos os SseEmitters conectados.
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().name(eventName).data(clpData));
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        }
    }

}