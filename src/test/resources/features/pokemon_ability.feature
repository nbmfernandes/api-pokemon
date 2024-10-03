Feature: Pokemon Ability API

  Scenario: Validate Pokemon ability details
    Given I have the Pokemon ability ID 1
    When I send a GET request to the ability API
    Then the response should have the ability name as "stench"
    And the ability should be a main series
    And the effect entries should contain "Mit jedem Treffer besteht eine 10% Chance das Ziel zurückschrecken zu lassen."
