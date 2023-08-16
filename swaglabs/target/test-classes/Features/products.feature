@products
Feature: Check the Products page functionality

  Background: 
    Given User is on login page
    And User is logged in with username "standard_user" and password "secret_sauce"
    When User on the products page

  @products_price
  Scenario: User should see the Products price in doller($) format
    Then user see the products price should be present with a "$" sign

  @product_sorting_by_name_in_descending
  Scenario: Sort products by Name in descending order
    When User click on sorting option by name in descending order
    Then user see the products are sorted by name in descending order

  @product_sorting_by_name_in_ascending
  Scenario: Sort products by Name in ascending order
    When User click on sorting option by name in ascending order
    Then user see the products are sorted by name in ascending order

  @product_sorting_by_price_in_ascending
  Scenario: Sort products by Price (low to high) in ascending order
    When User click on sorting option by price in ascending order
    Then user see the products are sorted by price in ascending order

  @product_sorting_by_price_in_descending
  Scenario: Sort products by price in descending order
    When User click on sorting option by price in descending order
    Then user see the products are sorted by price in descending order
