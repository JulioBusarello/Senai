package com.psii.appescola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.psii.appescola.model.Professor;
import com.psii.appescola.repository.ProfessorRepository;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
