Feature: Login Error Handling

  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user attempts to login with "invalid_user" and "secret_sauce"
    Then the login page is displayed again
    And an error message "Epic sadface: Username and password do not match any user in this service" is shown

  Scenario: Login with incorrect password
    Given the user is on the login page
    When the user attempts to login with "standard_user" and "incorrect_password"
    Then the login page is displayed again
    And an error message "Epic sadface: Username and password do not match any user in this service" is shown

  Scenario: Login with incorrect username
    Given the user is on the login page
    When the user attempts to login with "invalid_user" and "secret_sauce"
    Then the login page is displayed again
    And an error message "Epic sadface: Username and password do not match any user in this service" is shown

  Scenario: Login as locked out user
    Given the user is on the login page
    When the user attempts to login with "locked_out_user" and "secret_sauce"
    Then the login page is displayed again
    And an error message "Epic sadface: Sorry, this user has been locked out." is shown

