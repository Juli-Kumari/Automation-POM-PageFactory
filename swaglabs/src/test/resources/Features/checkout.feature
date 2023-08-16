@Checkout
Feature: Check the Checkout functionality

  Background: 
    Given User is on login page
    And User is logged in with username "standard_user" and password "secret_sauce"
    When User on the products page
    And User click on add to cart button for one product
    Then Click on shopping cart
    And Click on checkout

  @chcekout_form
  Scenario Outline: Checkout Informations should present and user able to enter the information
    Then user can see and enter the "<first_name>" "<last_name>" "<postal_code>"

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    |      854301 |

  @checkout_unsuccessful
  Scenario Outline: User Not Able to Complete the checkout process without entering the last name
    When user enter the first name as "<first_name>" and postal code as "<postal_code>"
    And user click on continue
    Then user see the error message as "<error_message>"

    Examples: 
      | first_name | postal_code | error_message                |
      | Juli       |      854301 | Error: Last Name is required |

  @checkout_unsuccessful
  Scenario Outline: User Not Able to Complete the checkout process without entering the first name
    When user enter the last name as "<last_name>" and postal code as "<postal_code>"
    And user click on continue
    Then user see the error message as "<error_message>"

    Examples: 
      | last_name | postal_code | error_message                 |
      | Kumari    |      854301 | Error: First Name is required |

  @checkout_unsuccessful
  Scenario Outline: User Not Able to Complete the checkout process without entering the postal code
    When user enter the "<first_name>" "<last_name>"
    And user click on continue
    Then user see the error message as "<error_message>"

    Examples: 
      | first_name | last_name | error_message                  |
      | Juli       | Kumari    | Error: Postal Code is required |

  @checkout_successful
  Scenario Outline: Complete the checkout process successfully with enter valid credential
    Then user enter the "<first_name>" "<last_name>" "<postal_code>"
    And user click on continue
    Then user can see the checkout overview
    When user click on finish
    Then user see the order confirmation message "<message>" should displayed

    Examples: 
      | first_name | last_name | postal_code | message                   |
      | Juli       | Kumari    |      854301 | Thank you for your order! |

  @check_postalCode_With_stringValue
  Scenario Outline: Verify Postal Code field takes only number
    Then user enter the "<first_name>" "<last_name>" "<postal_code>"
    Then user not able to see the continue button is enable with "<postal_code>"

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    | abcd        |

  @total_price
  Scenario Outline: Total price value is displayed correctly
    Then user enter the "<first_name>" "<last_name>" "<postal_code>"
    And user click on continue
    Then user can see the checkout overview
    And User is able to see the total price for the product

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    |      854301 |

  @continue_button_in_checkout_information
  Scenario Outline: Verify the continue button present on the checkout-information page
    Then user enter the "<first_name>" "<last_name>" "<postal_code>"
    And user click on continue

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    |      854301 |

  @cancle_button_in_checkout_information
  Scenario Outline: Verify the cancle button present on the checkout-information page
    When user click on cancle button in checkout-information page
    Then user redirect to the cart page again

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    |      854301 |

  @cancle_button_in_checkout_overview
  Scenario Outline: Verify the cancle button present on the checkout-overview page
    Then user enter the "<first_name>" "<last_name>" "<postal_code>"
    And user click on continue
    Then user can see the checkout overview
    When user click on cancle button in checkout-overview page
    Then user redirect to the product page again

    Examples: 
      | first_name | last_name | postal_code |
      | Juli       | Kumari    |      854301 |
