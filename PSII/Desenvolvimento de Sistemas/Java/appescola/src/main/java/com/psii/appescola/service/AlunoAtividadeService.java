package com.psii.appescola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psii.appescola.model.AlunoAtividade;
import com.psii.appescola.repository.AlunoAtividadeRepository;

@Service
public class AlunoAtividadeService {
    @Autowired
    private AlunoAtividadeRepository alunoAtividadeRepository;

    public void save(AlunoAtividade alunoAtividade) {
        alunoAtividadeRepository.save(alunoAtividade);
    }
}
