@menu
Feature: Check the Menu Bar Functionality

  Background: 
    Given User is on login page
    And User is logged in with username "standard_user" and password "secret_sauce"
    When User on the products page
    When User click on menu

  @menu_options
  Scenario: User is able to open the menu tab
    Then User is able to see the options "All Items" "About" "Logout" "Reset App State"

  @about
  Scenario: User is able to see the About tab information
    When User click on About tab
    Then User is able to see the tabs "Products" "Solutions" "Pricing" "Resources"

  @logout
  Scenario: User should logout successfully and redirect to the login page again
    When User click on logout option
    Then Redirect to the login page again
