package com.psii.appescola.service;

import java.util.List;

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
}
