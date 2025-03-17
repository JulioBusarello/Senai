package com.julio.app_cad_pro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.julio.app_cad_pro.model.Produto;
import com.julio.app_cad_pro.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            produto.setImageBytes(file.getBytes());
        }
        produtoService.saveProduct(produto);
        return "redirect:/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produto", produtoService.listProducts());
        return "listar";
    }

    @GetMapping("/produto/imagem/{id}")
    public ResponseEntity<byte[]> obterImagemProduto(@PathVariable Long id) {
        Produto produto = produtoService.findById(id);
        byte[] imagem = produto.getImageBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }

    @PostMapping("/produto/deletar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Produto produto = produtoService.findById(id);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "editar_produto";
        } else {
            return "redirect:/produto/lista";
        }
    }

    @PostMapping("/produto/editar")
    public String editarProduto(@ModelAttribute Produto produto) {
        produtoService.saveProduct(produto);
        return "redirect:/listar";
    }

    @PostMapping("/produto/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, @RequestParam("imagem") MultipartFile imagem) {
        if (!imagem.isEmpty()) {
            produto.setImagem(imagem);
        }
        produtoService.saveProduct(produto);
        return "redirect:/listar";
    }

}
