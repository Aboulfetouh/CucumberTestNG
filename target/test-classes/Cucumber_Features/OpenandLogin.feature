@BackgroundFunctionality
Feature: Testing the Login using Background Steps

  Background: 
    Given We open our home URL

  Scenario Outline: Login using Background Steps
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then User is directed to the DashBoard page and its <Elements> are present
    And Takes a <Screenshot>

    Examples: 
      | username | password | Elements | Screenshot               |
      | Admin    | admin123 |        6 | Background Functionality |