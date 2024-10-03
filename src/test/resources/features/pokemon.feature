Feature: Pokémon API Tests

  Background:
    Given I want to fetch details for Pokémon "pikachu"

  Scenario: Retrieve an existing Pokémon
    When I send a GET request to the Pokémon API
    Then the response should contain the name "pikachu"
    And the status code should be 200

  Scenario: Attempt to retrieve a non-existent Pokémon
    Given I have a non-existent Pokémon ID 99999
    When I send a GET request to the Pokémon API invalid
    Then the response status code should be 404
    And the response message should contain "Not Found"
