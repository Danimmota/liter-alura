package com.challenge.liter_alura.mapper;

import com.challenge.liter_alura.dto.AutorDTO;
import com.challenge.liter_alura.model.Autor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorMapper {

    public static Autor toEntity(AutorDTO dto){
        Autor autor = new Autor();
        autor.setNome(dto.nome());
        autor.setAnoNascimento(dto.anoNascimento());
        autor.setAnoFalecimento(dto.anoFalecimento());

        return autor;
    }

    public static AutorDTO toDto(Autor autor) {
        return new AutorDTO(autor.getNome(), autor.getAnoNascimento(), autor.getAnoFalecimento());
    }

    public static List<AutorDTO> toDtoList(List<Autor> autors) {
        return autors.stream()
                .map(AutorMapper::toDto)
                .toList();
    }
}
