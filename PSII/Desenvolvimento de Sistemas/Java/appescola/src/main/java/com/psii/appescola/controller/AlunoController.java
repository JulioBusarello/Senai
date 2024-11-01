package com.psii.appescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appescola.model.Aluno;
import com.psii.appescola.service.AlunoService;
import com.psii.appescola.service.AtividadeService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;
    private final AtividadeService atividadeService;

    public AlunoController(AlunoService alunoService, AtividadeService atividadeService) {
        this.alunoService = alunoService;
        this.atividadeService = atividadeService;
    }

    @GetMapping
    public String listarAlunos(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("artista", new Aluno());
        return "aluno";
    }

    @PostMapping
    public String adicionarAluno(Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos";
    }
    
    @GetMapping("/{id}/atividades")
    public String listarAtividadesDoAluno(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.findById(id));
        model.addAttribute("atividades", atividadeService.findByAlunoId(id));
        return "atividades-aluno"; // A view para listar atividades do aluno
    }
}
