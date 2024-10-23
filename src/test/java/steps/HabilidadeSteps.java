package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;

public class HabilidadeSteps {

    private Response response;
    private String baseURI = "https://pokeapi.co/api/v2/ability/";

    @Dado("que eu tenho o ID da habilidade do Pokémon {int}")
    public void que_eu_tenho_o_ID_da_habilidade_do_pokemon(int abilityId) {
        baseURI = baseURI + abilityId;
    }

    @Quando("eu envio uma requisição GET para a API de habilidades")
    public void eu_envio_uma_requisicao_GET_para_a_API_de_habilidades() {
        response = get(baseURI);
    }

    @Então("a resposta deve conter o nome da habilidade como {string}")
    public void a_resposta_deve_conter_o_nome_da_habilidade_como(String expectedAbilityName) {
        String actualAbilityName = response.jsonPath().getString("name");
        Assertions.assertEquals(expectedAbilityName, actualAbilityName);
    }

    @Então("a habilidade deve ser da série principal")
    public void a_habilidade_deve_ser_da_serie_principal() {
        boolean isMainSeries = response.jsonPath().getBoolean("is_main_series");
        Assertions.assertTrue(isMainSeries);
    }

    @Então("as entradas de efeito devem conter {string}")
    public void as_entradas_de_efeito_devem_conter(String expectedEffectEntry) {
        String actualEffectEntry = response.jsonPath().getString("effect_entries[0].effect");
        Assertions.assertTrue(actualEffectEntry.contains(expectedEffectEntry));
    }
}
