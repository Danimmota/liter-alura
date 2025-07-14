package com.challenge.liter_alura.principal;

import com.challenge.liter_alura.dto.AutorDTO;
import com.challenge.liter_alura.model.Autor;
import com.challenge.liter_alura.model.Livro;
import com.challenge.liter_alura.service.LivroService;

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
                3- Listar livros cadastrados //dados de todos os livros inseridos no banco de dados
                4- Listar autores cadastrados //dados de cada autor registrado
                5- Listar autores vivos em algum ano
                6- Listar livros em algum idioma
                7- Listar Top 10 livros cadastrados
                
                0- Sair
                =========================================
                """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroPeloTitulo();
                case 2 -> buscarAutorPeloNome();
                case 3 -> listarLivrosCadastrados();
                case 4 -> listarAutoresCadastrados();
                case 5 -> listarAutoresVivosAno();
                case 6 -> listarLivrosEmIdioma();
                case 7 -> listarTop10Livros();
                case 0 -> System.out.println("Encerrando a aplicação!");
                default -> System.out.println("Opção inválida");
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
            System.out.println("Nenhum autor encontrado com este nome.");
        }

//        AutorDTO autorDTO = autor.get(0);
//        System.out.println(autorDTO);
//
//        System.out.println("Deseja salvar o livro encontrado? (s/n)");
//        String opcaoSalvarLivro = sc.nextLine();
//
//        if (opcaoSalvarLivro.equalsIgnoreCase("s")) {
//            Livro livroSalvo = livroService.salvarLivro(primeiroLivro);
//            System.out.println("\nLivro salvo com sucesso:\n" + livroSalvo);
        }

    }

    private void listarLivrosCadastrados() {
    }

    private void listarAutoresCadastrados() {
    }

    private void buscarLivroPeloAutor() {
    }

    private void listarAutoresVivosAno() {
    }

    private void listarLivrosEmIdioma() {
    }

    private void listarTop10Livros() {
    }
}


//---------- Autor ----------
//Nome: Machado de Assis
//Ano de nascimento: 1839
//Ano de falecimento: 1908
//Livros: [Dom Casmurro]
//----------------------------

//5
//Insira o idioma para realizar a busca:
//es- espanhol
//en-inglês
//fr-francês
//pt- português