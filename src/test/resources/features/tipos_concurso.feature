# language: pt

Funcionalidade: Obter informações sobre os Tipos de Contest Pokémon
  Como um treinador
  Eu quero recuperar informações sobre os tipos de contest Pokémon
  Para que eu possa entender como os contests funcionam

  Cenário: Obter informações usando o ID do tipo de contest
    Dado que eu quero buscar informações sobre o tipo de contest com ID 1
    Quando eu envio uma requisição GET para o endpoint do tipo de contest
    Então a resposta deve conter o nome do tipo de contest "cool"
    E o ID do tipo de contest deve ser 1

  Cenário: Obter informações usando o nome do tipo de contest
    Dado que eu quero buscar informações sobre o tipo de contest chamado "cute"
    Quando eu envio uma requisição GET para o endpoint do tipo de contest
    Então a resposta deve conter o nome do tipo de contest "cute"
    E o ID do tipo de contest deve ser 3

#  Cenário: Tentar obter informações sobre um tipo de contest inexistente
#    Dado que eu quero buscar informações sobre o tipo de contest com ID 99999
#    Quando eu envio uma requisição GET para o endpoint do tipo de contest
#    Então a resposta deve ter um código de status 404
#    E a mensagem de erro deve indicar que o recurso não foi encontrado

#  Cenário: Verificar se a resposta contém a lista de nomes de movimentos associados
#    Dado que eu quero buscar informações sobre o tipo de contest com ID 3
#    Quando eu envio uma requisição GET para o endpoint do tipo de contest
#    Então a resposta deve conter uma lista de nomes de movimentos associados

#  Cenário: Validar o número total de tipos de contest
#    Dado que eu recupero os tipos de contest da API Pokémon
#    Então a contagem total de tipos de contest deve ser 5
#
#  Cenário: Validar nomes e URLs dos tipos de contest na lista
#    Dado que eu recupero os tipos de contest da API Pokémon
#    Quando eu verifico os tipos de contest
#    Então os tipos de contest devem incluir "<name>" e "<url>"
#    Exemplos:
#    | name   | url                                       |
#    | cool   | https://pokeapi.co/api/v2/contest-type/1/ |
#    | beauty | https://pokeapi.co/api/v2/contest-type/2/ |
#    | cute   | https://pokeapi.co/api/v2/contest-type/3/ |
#    | smart  | https://pokeapi.co/api/v2/contest-type/4/ |
#    | tough  | https://pokeapi.co/api/v2/contest-type/5/ |
