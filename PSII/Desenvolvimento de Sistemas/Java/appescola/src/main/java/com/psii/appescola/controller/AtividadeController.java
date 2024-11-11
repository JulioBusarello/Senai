package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("atividades", atividadeService.findAll());
        model.addAttribute("atividade", new Atividade());
        return "atividade";
    }

    @PostMapping
    public String adicionarAtividade(Atividade atividade) {
        atividadeService.save(atividade);
        return "redirect:/atividades";
    }

    @PostMapping("/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        atividadeService.deletarPorId(id);
        return "redirect:/atividades";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Atividade atividade = atividadeService.buscarPorId(id);
        if (atividade != null) {
            model.addAttribute("atividade", atividade);
            model.addAttribute("professores", professorService.findAll());
            return "atividade";
        } else {
            return "redirect:/atividades";
        }
    }

}
