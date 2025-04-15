package com.julio.clpmonitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.julio.clpmonitor.model.TagWriteRequest;
import com.julio.clpmonitor.service.ClpSimulatorService;
import com.julio.clpmonitor.util.TagValueParser;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClpController {

    @Autowired
    private ClpSimulatorService simulatorService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tag", new TagWriteRequest());
        return "index";
    }

    @GetMapping("/clp-data-stream")

    public SseEmitter streamClpData() {

        return simulatorService.subscribe();
    }

    @PostMapping("/write-tag")
    public String writeTag(@ModelAttribute TagWriteRequest request, Model model) {
        try {
            Object typedValue = TagValueParser.parseValue(request.getValue(), request.getType());

            System.out.println("\nEscrevendo no CLP: " + request.getIp() + "\n"
                    + " | DB: " + request.getDb() + "\n"
                    + " | Offset: " + request.getOffset() + "\n"
                    + " | Type: " + request.getType() + "\n"
                    + " | Valor convertido: " + typedValue + "\n");

            model.addAttribute("message", "Valor escrito com sucesso!");
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao escrever valor: " + e.getMessage());
        }

        model.addAttribute("tag", new TagWriteRequest());

        return "index";
    }

    @GetMapping("/fragmento-formulario")
    public String carregarFragmentoFormulario(Model model) {
        model.addAttribute("tag", new TagWriteRequest());
        return "fragments/formulario :: clp-write-fragment";
    }

    @PostMapping("/update-stock")
    public String updateEstoque() {
        simulatorService.sendClp1Update();

        return "index";
    }

    @PostMapping("/update-expedition")
    public String updateExpedicao() {
        simulatorService.sendExpeditionUpdate();

        return "index";
    }

}