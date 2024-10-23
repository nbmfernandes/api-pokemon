# language: pt

Funcionalidade: API de Habilidades do Pokémon

  Cenário: Validar detalhes da habilidade do Pokémon
    Dado que eu tenho o ID da habilidade do Pokémon 200
    Quando eu envio uma requisição GET para a API de habilidades
    Então a resposta deve conter o nome da habilidade como "steelworker"
    E a habilidade deve ser da série principal
    E as entradas de efeito devem conter "This Pokémon's Steel moves have 1.5× power."
