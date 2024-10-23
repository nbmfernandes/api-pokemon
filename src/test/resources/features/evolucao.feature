#language: pt
Funcionalidade: Testar a Cadeia de Evolução do Pokémon

  Cenário: Verificar a espécie inicial da cadeia de evolução
    Dado que eu recupero a cadeia de evolução para o Pokémon com ID 1
    Quando eu envio uma requisição GET para a API de Cadeia de Evolução
    Então a espécie inicial deve ser "bulbasaur"
    E a URL para a espécie inicial deve ser "https://pokeapi.co/api/v2/pokemon-species/1/"
