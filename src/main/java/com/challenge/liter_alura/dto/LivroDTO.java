package com.challenge.liter_alura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDTO> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Double numeroDownloads,
        @JsonAlias("summaries") List<String> resumo
       ) {

       @Override
       public String toString() {
              String autoresFormatados = autores().stream()
                      .map(autor -> {
                             String falecimento = autor.anoFalecimento() != null ? autor.anoFalecimento().toString() : "Atualmente vivo";
                             return autor.nome() + " (" + autor.anoNascimento() + " - " + falecimento + ")";
                      })
                      .collect(Collectors.joining(", "));

              if (autoresFormatados.isBlank()) {
                     autoresFormatados = "Nenhum autor disponível";
              }

              return "\n------------- Livro -------------" +
                      "\nTítulo: " + titulo() +
                      "\nIdiomas: " + String.join(", ", idiomas()) +
                      "\nNúmero de Downloads: " + numeroDownloads() +
                      "\nAutores: " + autoresFormatados;
       }
}
