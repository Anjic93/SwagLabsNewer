Feature: Adding products testing

  Background:
    Given user is already logged in and it is on products page

  Scenario: Verify that user can add all products from products page to the cart with add to cart button
    When user add all products to the cart with add to cart button
    Then remove button appears instead of add to cart button
    And number of added products is same as number on cart badge

  Scenario: Verify that user can remove added product from products page from the cart with remove button
    When user add one product with add to cart button
    Then remove button appears instead of add to cart button
    When user click on remove button from products page
    Then add to cart button appears instead of remove button


  Scenario: Verify that product is already added
    When user add one product with add to cart button
    And user click on added item title
    Then user is redirected to the added item page
    And user verify that remove button is displayed instead of add to cart button
