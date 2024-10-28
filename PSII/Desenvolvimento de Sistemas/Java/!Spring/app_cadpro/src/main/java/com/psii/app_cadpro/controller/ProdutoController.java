package com.psii.app_cadpro.controller;

import java.io.IOException;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.psii.app_cadpro.model.Produto;
import com.psii.app_cadpro.service.ProdutoService;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /*
     * @GetMapping("/produto/cadastrar")
     * public String mostrarFormularioCadastro(Model model) {
     * model.addAttribute("produto", new Produto());
     * return "cadastrar";
     * }
     */

    @PostMapping("/produto/cadastrar")
    public String cadastrarProduto(Produto produto, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            produto.setImagemBytes(file.getBytes());
        }
        produtoService.salvarProduto(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/produto/listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produto", produtoService.listarProdutos());
        return "listar_produto";
    }

    @GetMapping("/produto/imagem/{id}")
    public ResponseEntity<byte[]> obterImagemProduto(@PathVariable Long id) {
        Produto produto = produtoService.buscarPorId(id);
        byte[] imagem = produto.getImagemBytes();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }

    @PostMapping("/produto/deletar/{id}")
    public String deletarProduto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            produtoService.deletarPorId(id);
            redirectAttributes.addFlashAttribute("mensagem", "Produto deletado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "O produto está cadastrado em um pedido!");
        }

        return "redirect:/produto/listar";
    }

    @GetMapping("/produto/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            model.addAttribute("produto", produto);
            return "editar_produto";
        } else {
            return "redirect:/produto/listar";

        }
    }

    @PostMapping("/produto/editar")
    public String editarProduto(@ModelAttribute Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/produto/listar";
    }

    @PostMapping("/produto/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, @RequestParam("imagem") MultipartFile imagem) {
        if (!imagem.isEmpty()) {
            produto.setImagem(imagem);
        }
        produtoService.salvarProduto(produto);
        return "redirect:/produto/listar";
    }

}
