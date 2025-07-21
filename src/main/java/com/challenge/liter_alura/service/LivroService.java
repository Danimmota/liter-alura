package com.challenge.liter_alura.service;

import com.challenge.liter_alura.dto.AutorDTO;
import com.challenge.liter_alura.dto.LivroDTO;
import com.challenge.liter_alura.dto.ResponseAPI;
import com.challenge.liter_alura.mapper.AutorMapper;
import com.challenge.liter_alura.mapper.LivroMapper;
import com.challenge.liter_alura.model.Autor;
import com.challenge.liter_alura.model.Livro;
import com.challenge.liter_alura.repository.AutorRepository;
import com.challenge.liter_alura.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    private final ConsumoApi consumoApi;

    public LivroService(AutorRepository autorRepository, LivroRepository livroRepository, ConsumoApi consumoApi) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
        this.consumoApi = consumoApi;
    }

    public List<Livro> buscarLivrosAPI(String titulo) {
        ResponseAPI responseAPI = consumoApi.obterDados(titulo);
        List<LivroDTO> livrosDTO = responseAPI.livros();

        return livrosDTO.stream().map(LivroMapper::toEntity)
                .collect(Collectors.toList());
    }

    public Livro salvarLivro(Livro livro) {

        List<Autor> autores = livro.getAutores().stream().map(autor -> {
            return autorRepository.findByNomeContainingIgnoreCase(autor.getNome())
                    .orElseGet(() -> autorRepository.save(autor));
        }).toList();

        livro.setAutores(autores);
        return livroRepository.save(livro);

    }

    public Optional<AutorDTO> buscarAutorPeloNome(String nomeAutor) {
        return autorRepository.findByNomeContainingIgnoreCase(nomeAutor)
                .map(AutorMapper::toDto);
    }

    public List<LivroDTO> listarLivrosCadastrados() {

        List<Livro> livros = livroRepository.findAllComAutores();
        return LivroMapper.toDtoList(livros);

    }

    public List<AutorDTO> listarAutoresCadastrados() {
        List<Autor> autores = autorRepository.findAll();
        return AutorMapper.toDtoList(autores);

    }

    public List<LivroDTO> buscarLivroPeloAutor (String nomeAutor){

            return autorRepository.findByNomeContainingIgnoreCase(nomeAutor)
                    .map(Autor::getLivros)
                    .map(LivroMapper::toDtoList)
                    .orElse(Collections.emptyList());
    }

    public List<AutorDTO> listarAutoresVivosAno(Integer ano) {
        List<Autor> autores = autorRepository.findAutoresVivosEmAno(ano);
        return autores.stream()
                .map(AutorMapper::toDto)
                .toList();
    }

    public void menuIdioma() {
        var menu = """
                \n========================================
                Digite a abreviação referente ao idioma desejado:
                
                es - espanhol
                en - inglês
                fr - francês
                pt - português
                
                =========================================
                """;

        System.out.println(menu);
    }

    public List<LivroDTO> listarLivrosEmIdioma(String idioma) {
        List<Livro> livros = livroRepository.findAll();

        return livros.stream()
                .filter(livro -> livro.getIdiomas() != null &&
                        livro.getIdiomas().stream()
                                .anyMatch(id -> id.equalsIgnoreCase(idioma)))
                .map(LivroMapper::toDto)
                .toList();
    }

    public List<LivroDTO> listarTop10Livros () {

        return LivroMapper.toDtoList(livroRepository.findTop10ByOrderByNumeroDownloadsDesc());
    }

}
