package com.challenge.liter_alura.model;

public enum Idioma {
    ESPANHOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGUES("pt");

    private String idiomaGutendex;

    Idioma (String idiomaGutendex) {
        this.idiomaGutendex = idiomaGutendex;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaGutendex.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string fornecida: " + text);
    }
}