package com.challenge.liter_alura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") Integer anoNascimento,
        @JsonAlias("death_year") Integer anoFalecimento) {

    @Override
    public String toString() {
        return "\n------------- Autor -------------" +
                "\nNome: " + nome +
                "\nAno de Nascimento: " + anoNascimento +
                "\nAno de Falecimento: " + (anoFalecimento != null ? anoFalecimento : "Atualmente vivo") +
                "\n---------------------------------";
    }
}

