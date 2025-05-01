package com.senai.mikajuca.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.mikajuca.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    List<Contrato> findByCriadoPor(String criadoPor);
}