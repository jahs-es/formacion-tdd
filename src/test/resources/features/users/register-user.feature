Feature: Register a new user in the application

  Scenario: An admin can register a new user in the application
    Given an admin
    And an username "liam"
    When the user is registered
    Then the user is successfully registered

  Scenario: An user can not register a new user in the application
    Given an user
    And an username "noel"
    When the user is registered
    Then a forbidden error is returned