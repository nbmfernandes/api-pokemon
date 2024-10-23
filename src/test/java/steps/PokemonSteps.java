package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;

public class PokemonSteps {

    private Response response;
    private String baseUri;

    // Cenario 01: Recuperar um Pokemon existente
    @Dado("que eu quero buscar detalhes para o ID Pokémon {int}")
    public void que_eu_quero_buscar_detalhes_para_o_pokemon(int pokemonID) {
        baseUri = "https://pokeapi.co/api/v2/pokemon/" + pokemonID;  // Inicializa a URL base corretamente
    }

    @Quando("eu envio uma requisição GET para a API Pokémon")
    public void eu_envio_uma_requisicao_get_para_a_api_pokemon() {
        response = get(baseUri);
    }

    @Então("a resposta deve conter o nome {string}")
    public void a_resposta_deve_conter_o_nome(String expectedName) {
        String actualName = response.jsonPath().getString("name");

        // Verifica se a resposta contém o campo 'name'
        if (actualName == null) {
            System.out.println("Resposta JSON: " + response.asString());  // Imprime o corpo da resposta para ajudar no debug
        }

        Assertions.assertEquals(expectedName, actualName, "O nome do Pokémon não corresponde.");
    }

    @E("o status deve ser {int}")
    public void o_codigo_de_status_deve_ser(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assertions.assertEquals(expectedStatusCode, actualStatusCode, "O código de status não corresponde.");
    }

    // Cenario 02: Tentar recuperar um Pokémon inexistente
    @Dado("que eu tenho um ID de Pokémon inexistente {int}")
    public void que_eu_tenho_um_id_de_pokemon_inexistente(int idInexistente) {
        baseUri = "https://pokeapi.co/api/v2/pokemon/" + idInexistente;  // Inicializa corretamente a URL base
    }

    @Quando("eu envio uma requisição GET para a API Pokémon inválida")
    public void eu_envio_uma_requisicao_get_para_a_api_pokemon_invalida() {
        response = get(baseUri);  // Envia a requisição GET para o Pokémon inexistente
    }

    @Então("o código de status deve ser {int}")
    public void o_codigo_de_status_da_resposta_deve_ser(int statusCodeEsperado) {
        int statusCodeAtual = response.getStatusCode();
        Assertions.assertEquals(statusCodeEsperado, statusCodeAtual, "O código de status não corresponde.");
    }

    @E("a mensagem da resposta deve conter {string}")
    public void a_mensagem_da_resposta_deve_conter(String mensagemEsperada) {
        String corpoDaResposta = response.asString();
        Assertions.assertTrue(corpoDaResposta.contains(mensagemEsperada), "A mensagem de erro não contém o esperado.");
    }
}
