package com.psii.appescola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psii.appescola.model.Atividade;
import com.psii.appescola.repository.AtividadeRepository;

@Service
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public Atividade buscarPorId(Long id){
        Optional<Atividade> atividade = atividadeRepository.findById(id);
        return atividade.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Optional<Atividade> findById(Long id) {
        return atividadeRepository.findById(id);
    }

    public void deletarPorId(Long id){
        atividadeRepository.deleteById(id);
    }
}
