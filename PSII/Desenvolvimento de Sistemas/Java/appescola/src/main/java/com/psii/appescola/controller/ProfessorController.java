package com.psii.appescola.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psii.appescola.model.Professor;
import com.psii.appescola.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("professor", new Professor());
        return "professor";
    }

    @PostMapping("/salvar")
    public String adicionarProfessor(Professor professor) {
        professorService.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<Professor> editarProfessor(@PathVariable("id") Long id) {
        Optional<Professor> professorOpt = professorService.findById(id);
        return professorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarProfessor(@PathVariable Long id, Professor professor) {
        professor.setId(id);
        professorService.save(professor);
        return "redirect:/professores";
    }

    @PostMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable Long id, Model model) {
        try {
            professorService.delete(id);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return "redirect:/professores";
    }
}
            
            
        
    
