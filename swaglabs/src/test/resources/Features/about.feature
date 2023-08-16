@about_page_functionality
Feature: About page functionality

  Background: 
    Given User is on login page
    And User is logged in with username "standard_user" and password "secret_sauce"
    When User on the products page
    When User click on menu
    When User click on About tab
    Then User is able to see the tabs "Products" "Solutions" "Pricing" "Resources"

  @pricing_page
  Scenario: Verify the Pricing Page
    When User click on pricing
    Then user navigate to the pricing page

  @signIn_button
  Scenario: Verify the Sign In button is Enable on pricing page
    When User click on pricing
    Then user navigate to the pricing page
    Then User is able to click on sign in button

  @search_functionlity
  Scenario: Verify the Search functionality on pricing page
    When User click on pricing
    Then user navigate to the pricing page
    When User click on search button
    And user enter "selenium" on the search field

  @closing_serach_page
  Scenario: User able to close the serach page on pricing page
    When User click on pricing
    Then user navigate to the pricing page
    When User click on search button
    And user click on the close tab
    Then user navigate to the pricing page
