package com.exemplo.produtos.controller;

import com.exemplo.produtos.model.Produto;
import com.exemplo.produtos.repository.ProdutoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProdutoController {

    private final ProdutoRepository produtoRepo;
    private static final String UPLOAD_DIR = "uploads";

    public ProdutoController(ProdutoRepository produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    @GetMapping
    public String form(Model model) {
        model.addAttribute("produto", new Produto());
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto,
                         @RequestParam("file") MultipartFile file,
                         Model model) {
        try {
            if (!file.isEmpty()) {
                Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
                Files.createDirectories(path.getParent()); // Cria a pasta, se necessário
                Files.write(path, file.getBytes());
                produto.setNomeArquivo(file.getOriginalFilename());
            }

            produtoRepo.save(produto);
            return "redirect:/produtos";

        } catch (IOException e) {
            model.addAttribute("erro", "Erro ao salvar arquivo: " + e.getMessage());
            return "cadastro";
        }
    }

    @GetMapping("/cadastro")
    public String cadastrar(Model model) {
        return "cadastro";
    }
    
    @GetMapping("/produtos")
    public String listar(@RequestParam(value = "pagina", defaultValue = "1") int pagina, Model model) {
        int itensPorPagina = 5;
        int offset = (pagina - 1) * itensPorPagina;
        
        List<Produto> todosProdutos = produtoRepo.findAll();
        int totalItens = todosProdutos.size();
        int totalPaginas = (int) Math.ceil((double) totalItens / itensPorPagina);
        
        List<Produto> produtos = todosProdutos.stream()
            .skip(offset)
            .limit(itensPorPagina)
            .toList();
        
        model.addAttribute("produtos", produtos);
        model.addAttribute("paginaAtual", pagina);
        model.addAttribute("totalPaginas", totalPaginas);
        return "lista";
    }
}