package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonAbilitySteps {

    private Response response;
    private static final String BASE_URL = "https://pokeapi.co/api/v2/ability/";

    @Given("I have the Pokemon ability ID {int}")
    public void i_have_the_pokemon_ability_id(int id) {
        // Armazenar o ID da habilidade se necessário
    }

    @When("I send a GET request to the ability API")
    public void i_send_a_get_request_to_the_ability_api() {
        response = RestAssured.get(BASE_URL + "1");
    }

    @Then("the response should have the ability name as {string}")
    public void the_response_should_have_the_ability_name_as(String expectedName) {
        String actualName = response.jsonPath().getString("name");
        assertEquals(expectedName, actualName);
    }

    @Then("the ability should be a main series")
    public void the_ability_should_be_a_main_series() {
        boolean isMainSeries = response.jsonPath().getBoolean("is_main_series");
        assertEquals(true, isMainSeries);
    }

    @Then("the effect entries should contain {string}")
    public void the_effect_entries_should_contain(String expectedEffect) {
        String actualEffect = response.jsonPath().getString("effect_entries[0].short_effect");
        assertEquals(expectedEffect, actualEffect);
    }
}
