package com.psii.appescola.service;

import java.util.List;

import com.psii.appescola.model.Professor;
import com.psii.appescola.repository.ProfessorRepository;

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
}
