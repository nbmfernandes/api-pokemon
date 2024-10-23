package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.jupiter.api.Assertions;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

    public class EvolucaoSteps {

    private Response response;

    // Step para o Dado
    @Dado("que eu recupero a cadeia de evolução para o Pokémon com ID {int}")
    public void que_eu_recupero_a_cadeia_de_evolucao_para_o_pokemon_com_id(int id) {
        String url = "https://pokeapi.co/api/v2/evolution-chain/" + id + "/";
        response = given().get(url);
    }

    // Step para o Quando
    @Quando("eu envio uma requisição GET para a API de Cadeia de Evolução")
    public void eu_envio_uma_requisicao_get_para_a_api_de_cadeia_de_evolucao() {
        // A requisição já foi enviada no step anterior (Dado), então aqui não é necessário ação adicional
    }

    // Step para o Então
    @Então("a espécie inicial deve ser {string}")
    public void a_especie_inicial_deve_ser(String especieEsperada) {
        String especieInicial = response.jsonPath().getString("chain.species.name");
        Assertions.assertEquals(especieEsperada, especieInicial, "A espécie inicial não é a esperada.");
    }

    // Step para o E
    @Então("a URL para a espécie inicial deve ser {string}")
    public void a_url_para_a_especie_inicial_deve_ser(String urlEsperada) {
        String urlInicial = response.jsonPath().getString("chain.species.url");
        Assertions.assertEquals(urlEsperada, urlInicial, "A URL da espécie inicial não é a esperada.");
    }
}
