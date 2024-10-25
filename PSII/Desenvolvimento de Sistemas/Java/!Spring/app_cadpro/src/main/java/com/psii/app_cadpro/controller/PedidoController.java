package com.psii.app_cadpro.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psii.app_cadpro.model.Pedido;
import com.psii.app_cadpro.service.PedidoService;

@Controller
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedido/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "cadastrar";
    }

    @PostMapping("/pedido/cadastrar")
    public String cadastrarPedido(Pedido pedido) throws IOException {
        pedidoService.salvarPedido(pedido);
        return "redirect:/pedido/listar";
    }

    @GetMapping("/pedido/listar")
    public String listarPedidos(Model model) {
        model.addAttribute("pedido", pedidoService.listarPedidos());
        return "listar_pedido";
    }

    @PostMapping("/pedido/deletar/{id}")
    public String deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPorId(id);

        return "redirect:/listar_pedido";
    }

    @GetMapping("/pedido/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "editar_pedido";
        } else {
            return "redirect:/pedido/lista";
        }
    }

    @PostMapping("/pedido/editar")
    public String editarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        return "redirect:/listar_pedido";
    }

    @PostMapping("/pedido/salvar")
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        pedidoService.salvarPedido(pedido);
        return "redirect:/listar_pedido";
    }
}
