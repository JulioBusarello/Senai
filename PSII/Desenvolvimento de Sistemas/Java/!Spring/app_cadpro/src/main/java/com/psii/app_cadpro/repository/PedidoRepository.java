package com.psii.app_cadpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psii.app_cadpro.model.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {
    
}
