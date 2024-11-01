package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appescola.model.Professor;
import com.psii.appescola.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("professor", new Professor());
        return "professor";
    }

    @PostMapping
    public String adicionarProfessor(Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    }
}
