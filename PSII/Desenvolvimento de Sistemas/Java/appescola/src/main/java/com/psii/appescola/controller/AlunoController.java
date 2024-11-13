package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String editarAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        return "editarAlunoModal"; // Página/modal de edição (pode ser o mesmo template)
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarAluno(@PathVariable Long id, Aluno aluno) {
        aluno.setId(id);  // Certifique-se de manter o ID para atualizar corretamente.
        alunoService.save(aluno);
        return "redirect:/alunos";
    }

    @PostMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deleteById(id);
        return "redirect:/alunos";
    }
}
