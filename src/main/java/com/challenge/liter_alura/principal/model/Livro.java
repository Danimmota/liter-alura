package com.challenge.liter_alura.principal.model;

import jakarta.persistence.OneToMany;

public class Livro {

    private Long id;

    private String titulo;

    private String idioma;

    private Double numeroDownloads;

    @OneToMany
    private Autor autor;

}
