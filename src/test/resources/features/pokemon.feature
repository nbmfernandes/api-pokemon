#language: pt
Funcionalidade: Testes da API Pokémon

  Cenário: Recuperar um Pokémon existente
    Dado que eu quero buscar detalhes para o ID Pokémon 1
    Quando eu envio uma requisição GET para a API Pokémon
    Então a resposta deve conter o nome "bulbasaur"
    E o status deve ser 200

  Cenário: Tentar recuperar um Pokémon inexistente
    Dado que eu tenho um ID de Pokémon inexistente 99999
    Quando eu envio uma requisição GET para a API Pokémon inválida
    Então o código de status deve ser 404
    E a mensagem da resposta deve conter "Not Found"
