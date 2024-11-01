package com.psii.appescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.appescola.model.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {
    
}
