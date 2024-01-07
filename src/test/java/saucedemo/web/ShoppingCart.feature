Feature: Shopping Cart Tests

  Background:
    Given the user is logged in the website

  Scenario: User can navigate from shopping cart to inventory
    When the user navigates to the shopping cart page
    And the user clicks on the "Back To Inventory" Button
    Then the user should be on the inventory page

  Scenario: User can navigate from shopping cart to checkout
    When the user navigates to the shopping cart page
    And the user clicks on the "Checkout" Button
    Then the user should be on the Checkout page
