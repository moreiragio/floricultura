package com.floricultura.model;

public class Flor {

    private String nome;
    private String descricao;
    private String cor;
    private double valor;

    public Flor() {
    }

    public Flor(String nome, String descricao, String cor, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.cor = cor;
        this.valor = valor;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
