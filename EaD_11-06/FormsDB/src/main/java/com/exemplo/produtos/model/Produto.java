package com.exemplo.produtos.model;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String nomeArquivo;
    private Cliente cliente;
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getNomeArquivo() { return nomeArquivo; }
    public void setNomeArquivo(String nomeArquivo) { this.nomeArquivo = nomeArquivo; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}