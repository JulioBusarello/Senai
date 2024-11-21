package com.psii.appescola.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psii.appescola.model.Aluno;
import com.psii.appescola.model.AlunoAtividade;
import com.psii.appescola.model.Atividade;
import com.psii.appescola.service.AlunoAtividadeService;
import com.psii.appescola.service.AlunoService;
import com.psii.appescola.service.AtividadeService;
import com.psii.appescola.service.ProfessorService;

@Controller
@RequestMapping("/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;
    private final ProfessorService professorService;
    private final AlunoService alunoService;

    @Autowired
    private AlunoAtividadeService alunoAtividadeService;

    public AtividadeController(AtividadeService atividadeService, ProfessorService professorService, AlunoService alunoService) {
        this.atividadeService = atividadeService;
        this.professorService = professorService;
        this.alunoService = alunoService;
    }

    @GetMapping
    public String listarAtividades(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("professores", professorService.findAll());
        model.addAttribute("atividade", new Atividade());
        model.addAttribute("atividades", atividadeService.findAll());
        return "atividade";
    }

    @PostMapping("/salvar")
    public String salvarAtividade(Atividade atividade, @RequestParam Long[] alunoIds, Model model) {
        atividadeService.save(atividade);

        atividade.getAlunoAtividade().clear();

        for (int i = 0; i < alunoIds.length; i++) {
            Aluno aluno = alunoService.findById(alunoIds[i])
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            AlunoAtividade alunoAtividade = new AlunoAtividade();
            alunoAtividade.setAtividade(atividade);
            alunoAtividade.setAluno(aluno);

            alunoAtividadeService.save(alunoAtividade);
        }

        atividadeService.save(atividade);

        return "redirect:/atividades";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAtividade(@PathVariable Long id) {
        try {
            atividadeService.delete(id);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
        }
        return "redirect:/atividades";
    }

    @GetMapping("/editar/{id}")
    @ResponseBody
    public ResponseEntity<?> editarAtividade(@PathVariable Long id) {
        Atividade atividade = atividadeService.findById(id).orElseThrow(() -> new RuntimeException("Atividade não encontrada"));

        Map<String, Object> response = new HashMap<>();
        response.put("id", atividade.getId());
        response.put("nome", atividade.getNome());
        response.put("descricao", atividade.getDescricao());
        response.put("tipo", atividade.getTipo());
        response.put("localizacao", atividade.getLocalizacao());

        response.put("professor", Map.of("id", atividade.getProfessor().getId(), "nome", atividade.getProfessor().getNome()));
        response.put("alunoAtividade", atividade.getAlunoAtividade().stream().map(pp -> Map.of(
                "alunoId", pp.getAluno().getId())));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarAtividade(@PathVariable Long id, Atividade atividade) {
        atividade.setId(id);
        atividadeService.save(atividade);
        return "redirect:/atividades";
    }

}
