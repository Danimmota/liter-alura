package com.challenge.liter_alura.principal;

public class principal {

    public void menu(){
        var opcao = -1;
        var menu = """
                =====================================
                
                Escolha o número referente a sua opção:
                1- Buscar livro pelo título //consultar a API diretamente e salva a consulta no banco de dados
                2- Listar livros registrados //dados de todos os livros inseridos no banco de dados
                3- Listar autores registrados //dados de cada autor registrado
                4- Listar autores vivos em algum ano
                5- Listar livros em algum idioma
                
                0- Sair
                
                """;
    }
}

//---------- Livro ----------
//Título: Dom Casmurro
//Autor: Machado de Assis
//Idioma: pt
//Número de downloads: 1011.0
//----------------------------

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