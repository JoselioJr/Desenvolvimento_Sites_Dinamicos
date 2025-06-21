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
        model.addAttribute("produto", new Produto());
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
    
    @GetMapping("/produtos/filtrados")
    public String listarFiltrados(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) Double precoMin,
        @RequestParam(required = false) Double precoMax,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        Model model
    ) {
        List<Produto> produtos = produtoRepo.findByFiltros(nome, precoMin, precoMax, page, size);
        long totalItens = produtoRepo.countByFiltros(nome, precoMin, precoMax);
        int totalPaginas = (int) Math.ceil((double) totalItens / size);
        
        model.addAttribute("produtos", produtos);
        model.addAttribute("paginaAtual", page + 1);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("nome", nome);
        model.addAttribute("precoMin", precoMin);
        model.addAttribute("precoMax", precoMax);
        
        return "filtros";
    }
    
    @GetMapping("/filtros")
    public String filtros(Model model) {
        return "filtros";
    }
}