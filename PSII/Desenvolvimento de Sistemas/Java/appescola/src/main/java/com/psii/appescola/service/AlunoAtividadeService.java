package com.psii.appescola.service;

import java.util.Optional;

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

    public AlunoAtividade findById(Long id) {
        Optional<AlunoAtividade> alunoAtividade = alunoAtividadeRepository.findById(id);
        System.out.println(id);
        return alunoAtividade.orElseThrow(() -> new RuntimeException("AlunoAtividade não encontrado"));
    }
}
