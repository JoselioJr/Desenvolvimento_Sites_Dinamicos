package com.exemplo.produtos.controller;

import com.exemplo.produtos.model.Cliente;
import com.exemplo.produtos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente-lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente-form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }
}