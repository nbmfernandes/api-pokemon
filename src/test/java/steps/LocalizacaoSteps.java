package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;

public class LocalizacaoSteps {

    private String endpoint;
    private Response response;
    private final String BASE_URI = "https://pokeapi.co/api/v2/location/";

    @Dado("que eu quero buscar informações sobre a localização com ID {int}")
    public void que_eu_quero_buscar_informacoes_sobre_a_localizacao_com_id(int id) {
        response = get(BASE_URI + id);
    }

    @Dado("que eu quero buscar informações sobre a localização chamada {string}")
    public void que_eu_quero_buscar_informacoes_sobre_a_localizacao_chamada(String name) {
        response = get(BASE_URI + name);
    }

    @Quando("eu envio uma requisição GET para o endpoint da localização")
    public void eu_envio_uma_requisicao_get_para_o_endpoint_da_localizacao() {
        // A requisição já foi enviada nos passos anteriores
    }

    @Então("a resposta deve conter o nome da localização {string}")
    public void a_resposta_deve_conter_o_nome_da_localizacao(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assertions.assertEquals(expectedName, actualName);
    }

    @E("o ID da localização deve ser {int}")
    public void o_id_da_localizacao_deve_ser(int expectedId) {
        int actualId = response.jsonPath().getInt("id");
        Assertions.assertEquals(expectedId, actualId);
    }

    @Então("a resposta deve conter uma lista de áreas")
    public void a_resposta_deve_conter_uma_lista_de_areas() {
        Assertions.assertTrue(response.jsonPath().getList("areas").size() > 0);
    }

    @Então("a resposta deve conter a região {string}")
    public void a_resposta_deve_conter_a_regiao(String expectedRegion) {
        String actualRegion = response.jsonPath().getString("region.name");
        Assertions.assertEquals(expectedRegion, actualRegion);
    }

    @E("a localização deve ter um campo de {string}")
    public void a_localizacao_deve_ter_um_campo_de_names_com_informacoes_em_portugues(String field) {
        Assertions.assertNotNull(response.jsonPath().getList(field).size());
    }


}

