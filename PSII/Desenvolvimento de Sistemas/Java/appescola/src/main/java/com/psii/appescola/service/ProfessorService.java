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

    // Buscar todos os professores
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    // Salvar ou atualizar professor
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    // Buscar um professor pelo ID
    public Professor findById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElse(null); // Retorna null se o professor não for encontrado
    }

    // Excluir um professor pelo ID
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
