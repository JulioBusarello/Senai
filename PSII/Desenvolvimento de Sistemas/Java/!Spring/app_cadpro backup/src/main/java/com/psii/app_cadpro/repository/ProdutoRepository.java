package com.psii.app_cadpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.app_cadpro.model.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    
}
