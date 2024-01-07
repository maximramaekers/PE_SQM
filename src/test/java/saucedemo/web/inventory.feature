Feature: Inventory Page Interactions

  Scenario: User can navigate to product detail page
    Given the user is logged in
    And the user is on the inventory page
    When the user clicks on the first product
    Then the product detail page is displayed

  Scenario: User can add item to cart from detail page
    Given the user is logged in
    And the user is on the detail page of the first item
    When the user adds the item to the cart
    Then the item should be in the cart

  Scenario: User can navigate back to inventory page from detail page
    Given the user is logged in
    And the user is on the detail page of the first item
    When the user navigates back to the inventory page
    Then the user should land on the inventory page

  Scenario: User can navigate to the cart page from inventory
    Given the user is logged in
    And the user is on the inventory page
    When the user navigates to the cart page
    Then the user should land on the cart page