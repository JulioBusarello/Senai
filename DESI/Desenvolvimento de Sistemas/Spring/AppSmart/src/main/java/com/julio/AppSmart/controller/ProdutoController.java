package com.julio.AppSmart.controller;

import java.io.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.julio.AppSmart.model.Produto;

@Controller
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>(); // Lista de produtos

    // Carrega a tabela de produtos e exibe a página inicial
    @GetMapping("/tabela")
    public String exibirTabela(Model model) {
        if (produtos.isEmpty()) {
            carregarProdutos();
        }

        model.addAttribute("produtos", produtos); // Passa os produtos para o modelo
        model.addAttribute("produto", new Produto()); // Passa um objeto vazio para o formulário
        return "tabela"; // Retorna para a página 'tabela'
    }

    // Método para carregar produtos do arquivo
    private void carregarProdutos() {
        produtos.clear(); // Limpa a lista para garantir que não haja duplicação
        try (BufferedReader br = new BufferedReader(new FileReader("produtos.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    try {
                        String codigo = dados[0].trim();
                        String desc = dados[1].trim();
                        int quantidade = Integer.parseInt(dados[2].trim());
                        double preco = Double.parseDouble(dados[3].trim());

                        Produto produto = new Produto();
                        produto.setCodigo(codigo);
                        produto.setDescricao(desc);
                        produto.setQuantidade(quantidade);
                        produto.setPreco(preco);

                        produtos.add(produto); // Adiciona o produto à lista
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao processar linha: " + linha + " - " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro de leitura de arquivo: " + e.getMessage());
        }
    }

    // Método para adicionar ou editar um produto
    @PostMapping("/adicionar")
    public String salvarProduto(Produto produto, Model model) {
        if (produto.getCodigo() != null && !produto.getCodigo().trim().isEmpty()) {
            // Verifica se é um produto novo ou edição
            if (produtos.stream().anyMatch(p -> p.getCodigo().equals(produto.getCodigo()))) {
                // Editar produto
                Produto produtoExistente = produtos.stream()
                        .filter(p -> p.getCodigo().equals(produto.getCodigo()))
                        .findFirst()
                        .orElse(null);
                if (produtoExistente != null) {
                    produtoExistente.setDescricao(produto.getDescricao());
                    produtoExistente.setQuantidade(produto.getQuantidade());
                    produtoExistente.setPreco(produto.getPreco());
                }
            } else {
                // Adicionar produto
                produtos.add(produto);
            }

            salvarProdutosNoArquivo(); // Atualiza o arquivo
            model.addAttribute("produtos", produtos);
            return "redirect:/tabela"; // Redireciona para a tabela
        } else {
            model.addAttribute("produtos", produtos);
            model.addAttribute("produto", produto);
            model.addAttribute("error", "Produto não pode ser adicionado, código inválido.");
            return "tabela"; // Exibe a página com a mensagem de erro
        }
    }

    // Método para exibir o formulário de edição
    @GetMapping("/editar/{codigo}")
    public String exibirFormularioEdicao(@PathVariable String codigo, Model model) {
        Produto produto = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (produto != null) {
            model.addAttribute("produto", produto); // Passa o produto para o formulário
            model.addAttribute("produtos", produtos); // Passa a lista de produtos para a tabela
            return "tabela"; // A página 'tabela' agora serve para editar e criar
        } else {
            return "redirect:/tabela"; // Se não encontrar, redireciona para a tabela
        }
    }

    // Método para deletar um produto
    @GetMapping("/deletar/{codigo}")
    public String deletarProduto(@PathVariable String codigo, Model model) {
        Produto produto = produtos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (produto != null) {
            produtos.remove(produto); // Remove o produto da lista
            salvarProdutosNoArquivo(); // Atualiza o arquivo após a remoção
        }

        return "redirect:/tabela"; // Redireciona para a tabela
    }

    // Método para salvar os produtos no arquivo
    private void salvarProdutosNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt"))) {
            for (Produto produto : produtos) {
                String linha = produto.getCodigo() + ";" + produto.getDescricao() + ";" + produto.getQuantidade() + ";"
                        + produto.getPreco();
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os produtos no arquivo: " + e.getMessage());
        }
    }
}
