package com.psii.appescola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psii.appescola.model.Aluno;
import com.psii.appescola.repository.AlunoRepository;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno findById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
