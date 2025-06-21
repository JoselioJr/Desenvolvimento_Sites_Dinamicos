package com.exemplo.produtos.model;

import java.util.List;

public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private List<Produto> produtos;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
