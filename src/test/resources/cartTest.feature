Feature: Cart testing

  Background:
    Given user is already logged in and it is on products page

  Scenario: Verify that user can add product to the cart
    When user add one product with add to cart button
    Then remove button appears instead of add to cart button
    And number of added products is same as number on cart badge

  @important
  Scenario: Verify that user can remove added products from the cart
    When user add one product with add to cart button
    And user click on cart icon
    Then user is on cart page
    When user click on remove button
    Then cart is empty

  Scenario: Verify that user can go back on products page from the your cart page
    When user click on cart icon
    Then user is on cart page
    When user click on continue shopping button
    Then user is redirected back on products page