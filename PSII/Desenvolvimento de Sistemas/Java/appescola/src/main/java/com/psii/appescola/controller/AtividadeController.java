package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appescola.model.Atividade;
import com.psii.appescola.service.AtividadeService;
import com.psii.appescola.service.ProfessorService;

@Controller
@RequestMapping("/atividades")
public class AtividadeController {
    private final AtividadeService atividadeService;
    private final ProfessorService professorService;

    public AtividadeController(AtividadeService atividadeService, ProfessorService professorService) {
        this.atividadeService = atividadeService;
        this.professorService = professorService;
    }

    @GetMapping
    public String listarAtividades(Model model) {
        model.addAttribute("atividades", atividadeService.findAll());
        model.addAttribute("atividade", new Atividade());
        model.addAttribute("professores", professorService.findAll());
        return "atividade";
    }

    @PostMapping
    public String adicionarAtividade(Atividade atividade) {
        atividadeService.save(atividade);
        return "redirect:/atividades";
    }

}
