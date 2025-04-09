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

import com.julio.clpmonitor.model.ClpData;

import jakarta.annotation.PostConstruct;

@Service
public class ClpSimulatorService {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    @PostConstruct

    public void startSimulation() {
        // Agendamento separado para CLP 1 (800ms)
        executor.scheduleAtFixedRate(this::sendClp1Update, 0, 3800, TimeUnit.MILLISECONDS);

        // Agendamento para CLPs 2 a 4 (1 segundo)
        executor.scheduleAtFixedRate(this::sendClp2to4Updates, 0, 3, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(this::sendExpeditionUpdate, 0, 2, TimeUnit.SECONDS);
    }

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(0L);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        return emitter;
    }

    private void sendClp1Update() {
        Random rand = new Random();
        List<Integer> byteArray = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            byteArray.add(rand.nextInt(4));
        }

        ClpData clp1 = new ClpData(1, byteArray);
        sendToEmitters("clp1-data", clp1);
    }

    private void sendExpeditionUpdate() {
        Random rand = new Random();
        List<Integer> expeditionArray = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            expeditionArray.add(rand.nextInt(2)); // 0 a 3
        }

        ClpData expeditionData = new ClpData(5, expeditionArray);
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