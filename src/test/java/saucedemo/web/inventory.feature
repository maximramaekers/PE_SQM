Feature: Inventory Management

  Scenario: User can select a product and land on the detail page
    Given the user is logged in
    And the user navigates to the inventory page
    When the user selects a product to view its details
    Then the user should land on the product detail page

  Scenario: User can add an item to the cart from the detail page
    Given the user is logged in and on a product detail page
    When the user adds the product to the cart
    Then the product should be in the cart

  Scenario: User can navigate back to inventory page from the detail page
    Given the user is logged in and on a product detail page
    When the user navigates back to the inventory page from the detail page
    Then the user should be on the inventory page from inventory actions

  Scenario: User can navigate to the cart page
    Given the user is logged in and on the inventory page
    When the user navigates to the cart page
    Then the user should be on the cart page
