package com.floricultura.model;

import jakarta.persistence.*;

@Entity
public class OutroProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantidade;
    private double valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    private Integer idCategoriaProduto; // caso queira adicionar FK depois

    // getters e setters
}
