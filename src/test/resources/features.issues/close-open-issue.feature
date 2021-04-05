Feature: Close an open an issue

  Scenario: An user can't reopen an issue
    Given an user
    When he creates an issue
    When he closes the issue
    When he reopen the issue
    Then he gets a forbidden

  Scenario: An admin can reopen an issue
    Given an user
    When he creates an issue
    When he closes the issue
    Given an admin
    When he reopen the issue
    Then he gets a no content

  Scenario: An admin can't reopen an already opened issue
    Given an user
    When he creates an issue
    Given an admin
    When he reopen the issue
    Then he gets a server error