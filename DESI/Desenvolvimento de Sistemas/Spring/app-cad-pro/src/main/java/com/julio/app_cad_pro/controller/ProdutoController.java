package com.julio.app_cad_pro.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.julio.app_cad_pro.model.Produto;
import com.julio.app_cad_pro.service.ProdutoService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    // Método para exibir o formulário de cadastro
    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    // Método para cadastrar um novo produto
    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            produto.setImageBytes(file.getBytes());
        }
        produtoService.saveProduct(produto);
        return "redirect:/listar";
    }

    // Método para listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produto", produtoService.listProducts());
        return "listar";
    }

    // Método para obter a imagem de um produto
    @GetMapping("/produto/imagem/{id}")
    public ResponseEntity<byte[]> obterImagemProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        byte[] imagem = produto.getImageBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }

    // Método para exibir o formulário de edição
    @GetMapping("/produto/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "editar_produto";
        } else {
            return "redirect:/listar";
        }
    }

    // Método para editar o produto
    @PostMapping("/produto/editar")
    public String editarProduto(@ModelAttribute Produto produto, @RequestParam("image") MultipartFile imagem)
            throws IOException {
        if (!imagem.isEmpty()) {
            produto.setImageBytes(imagem.getBytes()); // Atualiza a imagem do produto
        }
        produtoService.saveProduct(produto);
        return "redirect:/listar";
    }

    // Método para deletar um produto
    @PostMapping("/produto/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return "redirect:/listar";
    }
}
