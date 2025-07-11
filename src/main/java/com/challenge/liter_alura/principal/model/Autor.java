package com.challenge.liter_alura.principal.model;

import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

public class Autor {

    private String nome;

    private LocalDate dataNascimento;

    private LocalDate dataFalecimento;

    @ManyToOne
    private List<Livro> livrosPublicados;
}
