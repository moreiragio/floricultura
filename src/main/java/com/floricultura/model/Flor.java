package com.floricultura.model;

import jakarta.persistence.*;

@Entity
public class Flor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private String nome;
    private int quantidade;
    private double valor;
    private String cor;
    private String descricao;
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

}
