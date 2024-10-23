#language: pt

Funcionalidade: Obter informações sobre localizações Pokémon

  Contexto: Como um treinador
            Quero recuperar informações sobre localizações Pokémon
            Para que eu possa entender onde os Pokémon aparecem

  Cenário: Obter informações usando o ID da localização
    Dado que eu quero buscar informações sobre a localização com ID 1
    Quando eu envio uma requisição GET para o endpoint da localização
    Então a resposta deve conter o nome da localização "canalave-city"
    E o ID da localização deve ser 1

  Cenário: Obter informações usando o nome da localização
    Dado que eu quero buscar informações sobre a localização chamada "pastoria-city"
    Quando eu envio uma requisição GET para o endpoint da localização
    Então a resposta deve conter o nome da localização "pastoria-city"
    E o ID da localização deve ser 3

  Cenário: Verificar que a resposta contém a lista de áreas
    Dado que eu quero buscar informações sobre a localização com ID 2
    Quando eu envio uma requisição GET para o endpoint da localização
    Então a resposta deve conter uma lista de áreas

  Cenário: Validar informações de uma localização específica
    Dado que eu quero buscar informações sobre a localização com ID 3
    Quando eu envio uma requisição GET para o endpoint da localização
    Então a resposta deve conter a região "sinnoh"
    E a localização deve ter um campo de "names"

