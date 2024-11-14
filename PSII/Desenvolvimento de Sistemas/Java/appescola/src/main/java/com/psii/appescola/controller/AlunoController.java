package com.psii.appescola.controller;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psii.appescola.model.Aluno;
import com.psii.appescola.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("aluno", new Aluno());
        return "aluno";
    }

    @PostMapping
    public String adicionarAluno(Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<Aluno> editarAluno(@PathVariable("id") Long id) {
        Optional<Aluno> alunoOpt = alunoService.findById(id);
        return alunoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarAluno(@PathVariable Long id, Aluno aluno) {
        aluno.setId(id);  // Certifique-se de manter o ID para atualizar corretamente.
        alunoService.save(aluno);
        return "redirect:/alunos";
    }

    @PostMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        try {
            alunoService.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return "redirect:/alunos";
    }
}
