Feature: Shopping Cart Interactions

  Scenario: User can navigate from shopping cart to inventory
    Given the user is logged in and at the shopping cart
    When the user clicks back to inventory
    Then the user should land on the inventory page

  Scenario: User can navigate from shopping cart to checkout
    Given the user is logged in with an item in the cart
    When the user clicks to checkout
    Then the user should land on the checkout step one page
