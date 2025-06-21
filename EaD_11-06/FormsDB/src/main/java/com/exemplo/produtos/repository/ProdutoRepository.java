package com.exemplo.produtos.repository;

import com.exemplo.produtos.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
}