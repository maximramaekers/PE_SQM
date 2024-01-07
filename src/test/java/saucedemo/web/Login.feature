Feature: Login functionality for SauceDemo web application

  Scenario: User successfully logs out from the application
    Given the user is on the SauceDemo login page
    And the user logs in with username "standard_user" and password "secret_sauce"
    When the user logs out
    Then the user should be redirected to the login page

  Scenario: User successfully logs in to the application
    Given the user is on the SauceDemo login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the logout button should be present on the inventory page