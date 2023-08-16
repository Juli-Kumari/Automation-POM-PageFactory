@Login
Feature: Login Functionality of Swag Labs

  Background: 
    Given User is on login page

  @LoginValidCredentials
  Scenario Outline: Successful login with valid credential
    When User enter username as "<username>" and password as "<password>"
    And Click on login button
    Then "Swag Labs" title displayed after succesfully login

    Examples: 
      | username      |  | password     |
      | standard_user |  | secret_sauce |

  @LoginInValidCredentials
  Scenario Outline: Unsuccessful login with invalid credential
    When User enter username as "<username>" and password as "<password>"
    And Click on login button
    Then Error Message as "<Error message>" is displayed after unsuccessful login

    Examples: 
      | username      |  | password | Error message                                                             |
      | standard_user |  | sauce    | Epic sadface: Username and password do not match any user in this service |

  @LoginWithoutCredentials
  Scenario Outline: Unsuccessful login without entering username and password
    And Click on login button
    Then Error Message as "<Error message>" is displayed 

    Examples: 
      | Error message                      |
      | Epic sadface: Username is required |

  @LoginOnlyWithUsername
  Scenario Outline: Unsuccessful login with valid username and blank password field
    When User enter username as "<username>"
    And Click on login button
    Then Error Message as "<Error message>" is displayed after enter only username

    Examples: 
      | username      | Error message                      |
      | standard_user | Epic sadface: Password is required |
