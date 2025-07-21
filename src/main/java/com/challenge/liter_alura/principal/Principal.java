package com.challenge.liter_alura.principal;

import com.challenge.liter_alura.dto.AutorDTO;
import com.challenge.liter_alura.dto.LivroDTO;
import com.challenge.liter_alura.exceptions.EntradaInvalidaException;
import com.challenge.liter_alura.model.Livro;
import com.challenge.liter_alura.service.LivroService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final LivroService livroService;

    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    private Scanner sc = new Scanner(System.in);

    public void menu(){
        var opcao = -1;

        while (opcao!= 0) {
            var menu = """
                \n========================================
                Escolha o número referente a sua opção:
                
                1- Buscar livro pelo título
                2- Buscar autor pelo nome
                3- Buscar livro e seu resumo, pelo autor
                4- Listar livros cadastrados
                5- Listar autores cadastrados
                6- Listar autores vivos em algum ano
                7- Listar livros em algum idioma
                8- Listar Top 10 livros cadastrados
                
                0- Sair
                =========================================
                """;
            System.out.println(menu);

            try{
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Entrada inválida! Digite o número referente ao que deseja.");
                continue;
            }

            try {
                switch (opcao) {
                    case 1 -> buscarLivroPeloTitulo();
                    case 2 -> buscarAutorPeloNome();
                    case 3 -> buscarLivroPeloAutor();
                    case 4 -> listarLivrosCadastrados();
                    case 5 -> listarAutoresCadastrados();
                    case 6 -> listarAutoresVivosAno();
                    case 7 -> listarLivrosEmIdioma();
                    case 8 -> listarTop10Livros();
                    case 0 -> System.out.println("Encerrando a aplicação!");
                    default -> System.out.println("Opção inválida");
                }
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

    private void buscarLivroPeloTitulo() {
        System.out.println("\nDigite o nome do livro que deseja buscar: ");
        String titulo = sc.nextLine();
        List<Livro> livros = livroService.buscarLivrosAPI(titulo);

        if (livros.isEmpty()){
            System.out.println("Nenhum livro encontrado");
        }

        Livro primeiroLivro = livros.get(0);
        System.out.println(primeiroLivro);

        System.out.println("Deseja salvar o livro encontrado? (s/n)");
        String opcaoSalvarLivro = sc.nextLine();

        if (opcaoSalvarLivro.equalsIgnoreCase("s")) {
            Livro livroSalvo = livroService.salvarLivro(primeiroLivro);
            System.out.println("\nLivro salvo com sucesso:\n" + livroSalvo);
        }

    }

    private void buscarAutorPeloNome() {
        System.out.println("\nDigite o nome do autor que deseja buscar: ");
        String nomeAutor = sc.nextLine();

        Optional<AutorDTO> autor = livroService.buscarAutorPeloNome(nomeAutor);

        if (autor.isEmpty()){
            System.out.println("\nNenhum autor encontrado com este nome.");
        } System.out.println("\nDados do autor: " + autor.get());

    }

    private void buscarLivroPeloAutor() {
        System.out.println("\nDigite o nome do autor que deseja: ");
        String nomeAutor = sc.nextLine();
        List<LivroDTO> livroPeloAutor = livroService.buscarLivroPeloAutor(nomeAutor);
        if (livroPeloAutor.isEmpty()){
            System.out.println("\nNenhum autor encontrado com este nome!");
            return;
        }
        System.out.println("\nAutor: " + nomeAutor + ", livros: ");
        livroPeloAutor.forEach(livro -> System.out.println("- " + livro.titulo()));

        System.out.println("\nDigite o título do livro que deseja ver o resumo: ");
        String titulo = sc.nextLine();

        try {
            String resumo = livroService.buscarResumoPorTitulo(titulo);
            System.out.println("\nResumo do livro: " + resumo);
        } catch (RuntimeException e) {
            System.out.println("\nErro ao encontrar o resumo!");
        }
    }

    private void listarLivrosCadastrados() {
        List<LivroDTO> listaLivros = livroService.listarLivrosCadastrados();
        listaLivros.forEach(System.out::println);
    }

    private void listarAutoresCadastrados() {
       List<AutorDTO> listaAutores = livroService.listarAutoresCadastrados();
       listaAutores.forEach(System.out::println);
    }

    private void listarAutoresVivosAno() {
        System.out.println("\nDigite o ano em que deseja listar os autores cadastrados que se encontravam vivos: ");
        Integer ano = sc.nextInt();
        List<AutorDTO> autoresVivos = livroService.listarAutoresVivosAno(ano);

        if(autoresVivos.isEmpty()) {
            System.out.println("\nNenhum autor vivo encontrado para o ano: " + ano);
        }
        autoresVivos.forEach(System.out::println);
    }

    private void listarLivrosEmIdioma() {
        livroService.menuIdioma();
        String idioma = sc.nextLine();
        List<LivroDTO> livrosPorIdioma = livroService.listarLivrosEmIdioma(idioma);

        if (livrosPorIdioma.isEmpty()) {
            System.out.println("\nIdioma escolhido: " + idioma +
                                "\nNenhum idioma encontrado!");
        } else {
            System.out.println("\nIdioma escolhido: " + idioma +
                                "\nLivros cadastrados neste idioma: " + livrosPorIdioma);
        }
    }

    private void listarTop10Livros() {
        List<LivroDTO> top10Livros = livroService.listarTop10Livros();
        top10Livros.forEach(System.out::println);
    }
}