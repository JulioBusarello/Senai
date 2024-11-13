package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appescola.model.Professor;
import com.psii.appescola.service.AtividadeService;
import com.psii.appescola.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;
    private final AtividadeService atividadeService;

    public ProfessorController(ProfessorService professorService, AtividadeService atividadeService) {
        this.professorService = professorService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("professor", new Professor());
        model.addAttribute("atividades", atividadeService.findAll());
        return "professor";
    }

    // Método para adicionar um professor
    @PostMapping
    public String adicionarProfessor(Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    }

    // Método para buscar um professor pelo ID para edição (via AJAX)
    @GetMapping("/editar/{id}")
    public String editarProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.findById(id);
        if (professor != null) {
            model.addAttribute("professor", professor);
            return "professor :: editarProfessorModal"; // Retorna o fragmento HTML do modal de edição
        }
        return "redirect:/professores"; // Caso não encontre, redireciona para a lista de professores
    }

    // Método para atualizar as informações de um professor
    @PostMapping("/atualizar/{id}")
    public String atualizarProfessor(@PathVariable Long id, Professor professor) {
        professor.setId(id);  // Garante que o ID será atualizado corretamente
        professorService.save(professor);
        return "redirect:/professores";
    }

    // Método para excluir um professor
    @PostMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.delete(id);
        return "redirect:/professores";
    }
}