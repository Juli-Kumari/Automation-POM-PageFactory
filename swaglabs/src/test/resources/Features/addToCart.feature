@addToCart
Feature: Check the Add To Cart functionality

  Background:
    Given User is on login page 
    And User is logged in with username "standard_user" and password "secret_sauce"
    When User on the products page

  @single_item_added_to_cart
  Scenario: User is able to Add single item to cart
    When User click on add to cart button for one product
    Then Confirm the cart updated item count to one
    When Click on shopping cart
    Then User see that one Product is added to the cart
  
  @multiple_item_added_to_cart
  Scenario: User is able to Add multiple item to cart
    When User click on add to cart button for more than one product
    Then Confirm the cart updated item count should increase
    When Click on shopping cart
    Then User see that multiple product is added to the cart

  @remove_product_from_cart-page
  Scenario: User is able to remove the product from the cart page
    When User click on add to cart button for one product
    Then Confirm the cart updated item count to one
    When Click on shopping cart
    Then User see that one Product is added to the cart
    When user click on remove button
    Then the product is remove

  @continue_shopping
  Scenario: Verify Continue Shopping button on Cart Page
    When User click on add to cart button for one product
    Then Confirm the cart updated item count to one
    When Click on shopping cart
    Then User see that one Product is added to the cart
    When user click on the continue shopping button
    Then user redirect to the product page again
