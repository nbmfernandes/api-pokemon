package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;

public class PokemonSteps {
    private Response response;
    public static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
    private int pokemonId;

    @Given("I want to fetch details for Pokémon {string}")
    public void i_want_to_fetch_details_for_pokemon(String pokemonName) {
        baseURI = BASE_URL;
        response = get(pokemonName);  // Faz a requisição diretamente aqui
    }

    @When("I send a GET request to the Pokémon API")
    public void i_send_a_get_request_to_the_pokemon_api() {
        // Esta etapa pode ser removida, pois a requisição já é feita no passo anterior.
    }

    @Then("the response should contain the name {string}")
    public void the_response_should_contain_the_name(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        Assertions.assertEquals(expectedName, actualName);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int statusCode) {
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }

    @Given("I have a non-existent Pokémon ID {int}")
    public void i_have_a_non_existent_pokemon_id(int id) {
        this.pokemonId = id;
    }

    @When("I send a GET request to the Pokémon API invalid")
    public void i_send_a_get_request_to_the_pokemon_api_invalid() {
        response = get(BASE_URL + pokemonId);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assertions.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response message should contain {string}")
    public void the_response_message_should_contain(String expectedMessage) {
        String actualMessage = response.asString();
        Assertions.assertTrue(actualMessage.contains(expectedMessage),
                "Response message should contain: " + expectedMessage);
    }
}
