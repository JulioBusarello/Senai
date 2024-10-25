package com.psii.app_cadpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psii.app_cadpro.model.Pedido;
import com.psii.app_cadpro.repository.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido salvarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public void deletarPorId(Long id){
        pedidoRepository.deleteById(id);
    }
}
