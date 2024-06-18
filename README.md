# Desafio Técnico: Gestão de Funcionários

## Introdução

Este projeto foi desenvolvido como parte de um desafio técnico para uma vaga de desenvolvedor júnior. O objetivo é criar um sistema simples de gestão de funcionários utilizando Java e demonstrar habilidades básicas de programação orientada a objetos, manipulação de coleções e formatação de dados.

## Funcionalidades Implementadas

- **Cadastro de Funcionários**: Criação de objetos do tipo `Funcionario`, estendendo a classe `Pessoa` para armazenar informações como nome, data de nascimento, salário e função.

- **Operações de Listagem e Manipulação de Dados**:
  - Listagem de todos os funcionários cadastrados.
  - Remoção de um funcionário específico da lista.
  - Aumento salarial de todos os funcionários em um percentual fixo.
  - Agrupamento dos funcionários por função.
  - Listagem dos funcionários que fazem aniversário em determinados meses.
  - Identificação do funcionário mais velho e cálculo da sua idade.

- **Exibição de Informações**:
  - Exibição dos dados formatados (nome, data de nascimento, salário, função) dos funcionários em diferentes cenários (listagem geral, agrupamento por função, etc.).
  - Ordenação alfabética dos funcionários.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Bibliotecas**: JDK 21 (Java Development Kit), Java Standard Library

## Instruções de Uso

1. **Configuração do Ambiente**:
   - Certifique-se de ter o JDK 21 instalado em seu sistema.
   - Importe o projeto para sua IDE de preferência (por exemplo, Eclipse, IntelliJ IDEA).

2. **Execução do Projeto**:
   - Abra a classe `Principal` que contém o método `main`.
   - Execute o projeto a partir desta classe.

3. **Funcionalidades Disponíveis**:
   - Ao executar o projeto, você verá a saída no console com as informações dos funcionários, conforme especificado nas funcionalidades implementadas.

## Estrutura do Projeto

- **`com.example.model.Pessoa`**: Classe base para representar uma pessoa com nome e data de nascimento.
  
- **`com.example.model.Funcionario`**: Subclasse de `Pessoa` que adiciona atributos específicos de funcionário como salário e função, e métodos para operar sobre esses atributos.

- **`com.example.Main`**: Classe de entrada do programa (`main`), onde são criados os funcionários, realizadas operações sobre eles e exibidas as saídas no console.

## Observações

Este projeto foi desenvolvido como um exercício para demonstrar conhecimentos básicos em Java e não inclui tratamento de erros avançado ou validações extensivas. É recomendado utilizar em ambiente de teste para explorar e entender melhor as operações implementadas.
