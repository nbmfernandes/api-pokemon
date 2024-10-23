package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TiposConcursoSteps {
    public Response response;
    public String baseURI;
    private String contestTypeName;


    @Dado("que eu quero buscar informações sobre o tipo de contest com ID {int}")
    public void i_want_to_fetch_information_about_the_contest_type_with_id(int id) {
        baseURI = "https://pokeapi.co/api/v2/contest-type/" + id;
    }

    @Dado("que eu quero buscar informações sobre o tipo de contest chamado {string}")
    public void i_want_to_fetch_information_about_the_contest_type_named(String name) {
        baseURI = "https://pokeapi.co/api/v2/contest-type/" + name;
    }

    @Quando("eu envio uma requisição GET para o endpoint do tipo de contest")
    public void i_send_a_get_request_to_the_contest_type_endpoint() {
        response = get(baseURI);
    }

    @Então("a resposta deve conter o nome do tipo de contest {string}")
    public void the_response_should_contain_the_contest_type_name(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        assertEquals(expectedName, actualName);
    }

    @E("o ID do tipo de contest deve ser {int}")
    public void o_id_do_tipo_de_contest_deve_ser(int expectedId) {
        int actualId = response.jsonPath().getInt("id");
        assertEquals(expectedId, actualId);
    }







}