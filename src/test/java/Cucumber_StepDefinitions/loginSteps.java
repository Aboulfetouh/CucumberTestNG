package Cucumber_StepDefinitions;

import org.testng.Assert;
import org.testng.Reporter;
import OrangehrmLive_Pageclass.dashboardPage;
import OrangehrmLive_Pageclass.landingPage;
import io.cucumber.java.en.Then;

public class loginSteps {

	landingPage landing = new landingPage();
	dashboardPage dash = new dashboardPage();

	@Then("User is directed to the DashBoard page and its {int} are present")
	public void user_is_at_the_dash_board_page(int size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("Assertion Passed");
	}

	@Then("^User gets the validation (.*)$")
	public void user_gets_the_validation_ErrorMessage(String errormessage) {
		switch (errormessage) {
		case "Required":
			if (landing.usernameErrorMessageIsDisplayed()) {
				Assert.assertEquals(landing.getUsernameErrorMessage(), errormessage);
				Reporter.log("All fields error message were displayed and has been asserted || Test case passed", true);
			} else {
				System.out.println("Fields error message were not displayed || Test case failed");
			}
			break;
		case "Invalid credentials":
			if (landing.invalidCredentialsIsDisplayed()) {
				Assert.assertEquals(landing.getInvalidCredentialsErrorMessage(), errormessage);
				Reporter.log(
						"The invalid credentials error message was displayed and has been asserted || Test case passed",
						true);
			} else {
				System.out.println("The invalid credentials error message was not displayed || Test case failed");
			}
			break;
		}
	}
}
