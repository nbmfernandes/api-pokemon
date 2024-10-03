# Pokémon API Test Suite

Este é um projeto de testes automatizados para a API pública Pokémon usando Java, Cucumber e RestAssured. O objetivo é garantir que a API funcione corretamente, validando os detalhes dos Pokémon e o tratamento de casos inválidos.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação
- **Maven**: Gerenciador de dependências e build
- **Cucumber**: Framework para testes baseados em comportamento (BDD)
- **RestAssured**: Biblioteca para testes de APIs REST
- **JUnit**: Framework de testes
- **k6**: Ferramenta para testes de carga e performance

## Pré-requisitos

Antes de executar este projeto, verifique se você possui os seguintes pré-requisitos:

- Java 8 ou superior
- Maven 3.6.0 ou superior
- IntelliJ IDEA (opcional, mas recomendado)
- k6 (siga as instruções de instalação em [k6.io](https://k6.io/docs/getting-started/installation))


## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/pokemon-api-test-suite.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
    cd pokemon-api-test-suite
   ```
3. Compile o projeto e baixe as dependências com Maven:
   ```bash
    mvn clean install
   ```

## Estrutura do Arquivo de Feature
Os testes estão organizados em um arquivo .feature que contém cenários para verificar:

A recuperação de um Pokémon existente.
O tratamento de uma solicitação para um Pokémon não existente.

## Testes de Performance com k6
Os testes de performance podem ser realizados utilizando o k6. Um script de exemplo está disponível em k6/pokemon_performance_test.js. 
Siga os passos abaixo para executar os testes de carga:

Navegue até a pasta onde o script está localizado:

  ```bash
  cd k6
  ```
Execute o teste de carga com k6:

  ```bash
  k6 run pokemon_performance_test.js
  ```


