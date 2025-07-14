package com.challenge.liter_alura.repository;

import com.challenge.liter_alura.model.Idioma;
import com.challenge.liter_alura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTituloContainingIgnoreCase (String titulo);

    List<Livro> findTop10ByOrderByNumeroDownloadsDesc();

    @Query("SELECT l FROM Livro l WHERE :idioma MEMBER OF l.idiomas")
    List<Livro> findByIdioma(String idioma);
}
