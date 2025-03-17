package com.julio.app_cad_pro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.app_cad_pro.model.Produto;
import com.julio.app_cad_pro.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto saveProduct(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listProducts() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}
