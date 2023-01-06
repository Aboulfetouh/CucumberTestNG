@LoginFunctionality
Feature: Testing the Login functionality

  Scenario Outline: Checking login with valid credentials
    Given User opened the Home <URL>
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User is directed to the DashBoard page and its <Elements> are present
    And Takes a <Screenshot>

    @positive
    Examples: 
      | URL                                        | username | password | Elements | Screenshot                   |
      | https://opensource-demo.orangehrmlive.com/ | Admin    | admin123 |        6 | Positive Login Functionality |

  Scenario Outline: Checking login with invalid credentials
    Given User opened the Home <URL>
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User gets the validation <Error-Message>
    And Takes a <Screenshot>

    @negative
    Examples: 
      | URL                                        | username | password | Error-Message       | Screenshot                     |
      | https://opensource-demo.orangehrmlive.com/ | admin123 | Admin    | Invalid credentials | Invalid Credentials Screenshot |
      | https://opensource-demo.orangehrmlive.com/ |          |          | Required            | Required Fields Screenshot     |
