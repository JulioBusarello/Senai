package com.psii.app_cadpro.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psii.app_cadpro.model.Pedido;
import com.psii.app_cadpro.model.Produto;
import com.psii.app_cadpro.service.PedidoService;
import com.psii.app_cadpro.service.ProdutoService;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "cadastrar";
    }

    @PostMapping("/pedido/cadastrar")
    public String cadastrarPedido(@ModelAttribute Pedido pedido, @RequestParam Long idProduto, @RequestParam Date dataPedido) {
        Produto produto = produtoService.buscarPorId(idProduto);
        pedido.setProduto(produto);
        pedido.setDataPedido(dataPedido);
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/pedido/listar")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "listar_pedido";
    }

    @PostMapping("/pedido/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPorId(id);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/pedido/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("produtos", produtoService.listarProdutos());
            return "editar_pedido";
        } else {
            return "redirect:/pedido/listar";
        }
    }

    @PostMapping("/pedido/editar")
    public String editarPedido(@ModelAttribute Pedido pedido, @RequestParam Long produtoId) {
        pedido.setProduto(produtoService.buscarPorId(produtoId));
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedido/listar";
    }

    @PostMapping("/pedido/salvar")
    public String salvarProduto(@ModelAttribute Pedido pedido, @RequestParam Long idProduto, @RequestParam Date dataPedido) {
        Produto produto = produtoService.buscarPorId(idProduto);
        pedido.setProduto(produto);
        pedido.setDataPedido(dataPedido);
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedido/listar";
    }
}
