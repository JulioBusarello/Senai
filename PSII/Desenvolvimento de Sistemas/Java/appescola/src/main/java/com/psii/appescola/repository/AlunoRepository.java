package com.psii.appescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.appescola.model.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Long>{
    
}
