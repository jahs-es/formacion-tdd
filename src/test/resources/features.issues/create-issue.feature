Feature: Create a issue in the application

  Scenario: An user can create an issue and is linked to him
    Given an user
    When he creates an issue
    Then the issue is successfully created as open and linked to him