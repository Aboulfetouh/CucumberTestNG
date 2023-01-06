@CookiesChallenge
Feature: Testing the Login functionality using cookies

  @loginAndStoreCookies
  Scenario Outline: Checking login and storing Cookies
    Given User opened the Home <URL>
    When User enters "<username>" and "<password>"
    And Clicks on the login button
    Then Was directed to the DashBoard page <Elements>
    And Stores the session <Cookies>
    And Takes a <Screenshot>

    Examples: 
      | URL                                        | username | password | Elements | Cookies            | DashURL                                                                 | Screenshot                      |
      | https://opensource-demo.orangehrmlive.com/ | Admin    | admin123 |        6 | SessionCookies.txt | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index | loginAndStoreCookies Screenshot |

  @loginThroughCookies
  Scenario Outline: Checking login using stored Cookies
    Given User opened the Home <URL>
    When User loads the session <Cookies>
    And User opens the <DashURL>
    Then User should be able to see the DashBoard page <Elements>
    And Takes a <Screenshot>

    Examples: 
      | URL                                        | Elements | Cookies            | DashURL                                                                 | Screenshot                     |
      | https://opensource-demo.orangehrmlive.com/ |        6 | SessionCookies.txt | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index | loginThroughCookies Screenshot |