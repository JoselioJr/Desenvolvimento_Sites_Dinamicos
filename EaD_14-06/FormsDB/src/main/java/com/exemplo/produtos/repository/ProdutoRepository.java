package com.exemplo.produtos.repository;

import com.exemplo.produtos.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository {
    
    private final List<Produto> produtos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    public ProdutoRepository() {
        inicializarProdutos();
    }
    
    private void inicializarProdutos() {
        for (int i = 1; i <= 12; i++) {
            Produto produto = new Produto();
            produto.setId((long) i);
            produto.setNome("Produto " + i);
            produto.setDescricao("Descrição do produto " + i);
            produto.setPreco(10.0 * i);
            produtos.add(produto);
        }
        idGenerator.set(13);
    }
    
    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(idGenerator.getAndIncrement());
        }
        produtos.add(produto);
        return produto;
    }
    
    public List<Produto> findAll() {
        return new ArrayList<>(produtos);
    }
    
    public List<Produto> findByNomeContainingIgnoreCase(String nome, int page, int size) {
        return produtos.stream()
            .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }
    
    public List<Produto> findByFiltros(String nome, Double precoMin, Double precoMax, int page, int size) {
        return produtos.stream()
            .filter(p -> nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase()))
            .filter(p -> precoMin == null || p.getPreco() >= precoMin)
            .filter(p -> precoMax == null || p.getPreco() <= precoMax)
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }
    
    public long countByFiltros(String nome, Double precoMin, Double precoMax) {
        return produtos.stream()
            .filter(p -> nome == null || p.getNome().toLowerCase().contains(nome.toLowerCase()))
            .filter(p -> precoMin == null || p.getPreco() >= precoMin)
            .filter(p -> precoMax == null || p.getPreco() <= precoMax)
            .count();
    }
}