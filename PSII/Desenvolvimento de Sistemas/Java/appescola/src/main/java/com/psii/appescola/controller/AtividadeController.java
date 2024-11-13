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
    public String deletarAtividade(@PathVariable Long id) {
        atividadeService.deletarPorId(id);
        return "redirect:/atividades";
    }

    @GetMapping("/editar/{id}")
    public String editarAtividade(@PathVariable("id") Long id, Model model) {
        Atividade atividade = atividadeService.buscarPorId(id);
        model.addAttribute("atividade", atividade);
        model.addAttribute("professores", professorService.findAll());
        return "atividade";  // Retorna a página de edição com a atividade
    }

    @PostMapping("/atualizar/{id}")
    public String editarAtividade(@PathVariable Long id, Atividade atividade) {
        Atividade atividadeExistente = atividadeService.buscarPorId(id);
        if (atividadeExistente != null) {
            atividadeExistente.setNome(atividade.getNome());
            atividadeExistente.setLocalizacao(atividade.getLocalizacao());
            atividadeExistente.setTipo(atividade.getTipo());
            atividadeExistente.setDescricao(atividade.getDescricao());
            atividadeExistente.setProfessor(atividade.getProfessor());
            atividadeService.save(atividadeExistente);
        }
        return "redirect:/atividades";
    }

}
