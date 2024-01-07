Feature: Checkout Process

  Scenario: User can navigate back to the shopping cart from checkout
    Given the user is logged in and has an item in the cart
    When the user navigates to checkout and clicks back to shopping cart
    Then the user should land on the shopping cart page

  Scenario: User can fill in personal information and proceed to overview
    Given the user is logged in and on the inventory page
    And the user is on the checkout step one page
    When the user fills in the information and continues to checkout step two
    Then the user should see the item in the overview on checkout step two