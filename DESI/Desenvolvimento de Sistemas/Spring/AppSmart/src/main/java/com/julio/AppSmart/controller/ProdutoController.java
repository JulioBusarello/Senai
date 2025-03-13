package com.julio.AppSmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
    @GetMapping("/produto")
    public String mostrarProduto(Model model) {
        int id = 12;
        String produto = "Camisa Polo";
        double preco = 149.99;
        int quantidade = 15;

        String fornecedor = "JS Malharia";
        String lote = "CX21-2025";
        String dataFabricacao = "25-01-2024";

        model.addAttribute("id", id);
        model.addAttribute("produto", produto);
        model.addAttribute("preco", preco);
        model.addAttribute("quantidade", quantidade);
        model.addAttribute("fornecedor", fornecedor);
        model.addAttribute("lote", lote);
        model.addAttribute("dataFabricacao", dataFabricacao);

        return "produto";
    }

}
