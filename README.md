# 📚 Aplicação de Busca de Livros com API Gutendex

Este é um projeto Java com interação via console e integração com banco de dados que permite buscar livros e autores utilizando a API pública do **[Projeto Gutendex](https://gutendex.com/)**.

---
### 🔧 Tecnologias Utilizadas

- Java 17
- Maven
- Bibliotecas:
  - Lombok 
  - Jackson (para conversão JSON)
  - HttpClient (para chamadas HTTP)
- API Externa:
  - Gutendex API
- Banco de Dados
  - PostgreSQL

---
### 📌 Funcionalidades

- Integração com banco de dados

- Buscar livro na API pelo título e salvar na base de dados
- (extra) Buscar autor na base de dados pelo nome
- (extra) Buscar livro e seu resumo, pelo autor
- Listar livros cadastrados no banco de dados
- Listar autores cadastrados no banco de dados
- Listar autores vivos em algum ano
- Listar os livros em algum idioma que estejam cadastrados no banco de dados
- (extra) Listar Top 10 livros mais baixados, cadastrados no banco de dados

---
### 🧱 Estrutura de Pacotes

```bash
src/

    ├── dto/                      
    │   └──AutorDTO
    │   └──LivroDTO
    │   └──ResponseAPI
    ├── exceptions/  
    │   └──EntradaInvalidaException
    ├── mapper/
    │   └──AutorMapper
    │   └──LivroMapper
    ├── model/                     
    │   └── Autor
    │   └── Livro
    ├── principal/
    │   └── Principal
    ├── repository/
    │   └── AutorRepository
    │   └── LivroRepository 
    ├── service/                  
    │   ├── ConsumoApi
    │   ├── ConverteDados  
    │   └── IConverteDados
    │   └── LivroService
    │── LiterAluraApplication 

```
---
### 🖥️ Exemplo de uso

``` bash

========================================
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

3

Digite o nome do autor que deseja: 
shakespeare

Autor: shakespeare, livros: 
- Romeo and Juliet
- The Complete Works of William Shakespeare

Digite o título do livro que deseja ver o resumo:
Romeo

Resumo do livro: "Romeo and Juliet" by William Shakespeare is a tragedy likely written during the late 16th century. The play centers on the intense love affair between two young lovers, Romeo Montague and Juliet Capulet, whose families are embroiled in a bitter feud. Their love, while passionate and profound, is met with adversities that ultimately lead to tragic consequences.  At the start of the play, a Prologue delivered by the Chorus sets the stage for the tale of forbidden love, revealing the familial conflict that surrounds Romeo and Juliet. The opening scenes depict a public brawl ignited by the feud between the Montagues and Capulets, showcasing the hostility that envelops their lives. As we are introduced to various characters such as Benvolio, Tybalt, and Mercutio, we learn of Romeo's unrequited love for Rosaline. However, this quickly changes when Romeo encounters Juliet at the Capulet ball, where they share a famous and romantic exchange, unwittingly falling in love with each other despite their families' bitter enmity. This initial encounter foreshadows the obstacles they will face as their love story unfolds amidst chaos and conflict. (This is an automatically generated summary.)

...
```
---
### 🧪 Possíveis Melhorias

- Implementar cache local com TTL para não repetir chamadas de API
- Salvar resumos preferidos em banco local
- Tradução do resumo 
- Interface gráfica
- Integração com outras APIs de livros

---
### 🧾 Licença

- Este projeto é de uso livre para fins educativos. Se inspirou ou reutilizou? Considere deixar uma ⭐ no repositório!
 
---
### 🧑‍💻 Autor

Desenvolvido por Daniela Medeiro Mota em realização do Challenge: LiterAlura ONE - Oracle Next Education

📧 Email: danielamedeiromota@hotmail.com

[🔗 LinkedIn](https://www.linkedin.com/in/danielammota/)