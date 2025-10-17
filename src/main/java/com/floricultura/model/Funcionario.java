package com.floricultura.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String numero;
    private String complemento;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ativo;

    public enum Status { ativo, inativo }

    // getters e setters
}
