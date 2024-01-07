Feature: Login Tests

  Scenario: User can log in with valid credentials
    Given the user is currently on the login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be logged in

  Scenario: User cannot log in with invalid credentials
    Given the user is currently on the login page
    When the user logs in with username "locked_out_user" and password "invalid_password"
    Then the user should not be logged in
