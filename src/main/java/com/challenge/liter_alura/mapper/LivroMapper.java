package com.challenge.liter_alura.mapper;

import com.challenge.liter_alura.dto.LivroDTO;
import com.challenge.liter_alura.model.Autor;
import com.challenge.liter_alura.model.Livro;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class LivroMapper {


    public static Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setIdiomas(dto.idiomas());
        livro.setNumeroDownloads(dto.numeroDownloads());

        // Mapeamento do autor
        List<Autor> autores = dto.autores().stream().map(AutorMapper::toEntity).toList();
        livro.setAutores(autores);

        return livro;
    }

    public static LivroDTO toDto(Livro livro) {
        return new LivroDTO(
                livro.getTitulo(),
                livro.getAutores().stream().map(AutorMapper::toDto).toList(),
                livro.getIdiomas(),
                livro.getNumeroDownloads(),
                null
        );
    }

    public static List<LivroDTO> toDtoList(List<Livro> livros) {
        return livros.stream()
                .map(LivroMapper::toDto)
                .toList();
    }

}
