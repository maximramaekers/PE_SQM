Feature: Checkout Process

  Scenario: User can go back to shopping cart from checkout step one
    Given the user is logged in and has an item in the cart
    When the user navigates to checkout step one and goes back to the shopping cart
    Then the user should be on the shopping cart page

  Scenario: User can fill in info and continue to overview and see item is in cart
    Given the user is on the checkout step one page
    When the user fills in information and continues to checkout step two
    Then the user should see the item in the cart on checkout step two

  Scenario: User can go back from step two to step one checkout
    Given the user is on the checkout step two page with item in cart
    When the user goes back to checkout step one
    Then the user should be on the checkout step one page

  Scenario: User can finish order
    Given the user is on the checkout step two page with item in cart
    When the user finishes the order from checkout step two
    Then the user should be on the finish page

  Scenario: User can go back to home after finishing order
    Given the user has completed the order and is on the finish page
    When the user goes back to the inventory page from finish page
    Then the user should be on the inventory page after he goes back
