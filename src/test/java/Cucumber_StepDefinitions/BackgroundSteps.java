package Cucumber_StepDefinitions;

import static Readerclass.directorySourceReader.*;
import static Readerclass.configReader.*;
import java.io.IOException;
import OrangehrmLive_Pageclass.baseclass;
import OrangehrmLive_Pageclass.landingPage;
import UtilitiesClass.TakeScreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps {

	baseclass base = new baseclass();
	TakeScreenShot screenshot = new TakeScreenShot();
	landingPage landing = new landingPage();

	@Given("^User opened the Home (.*)$")
	public void user_opened_the_home_url(String URL) throws IOException, Exception {
		base.getURL(URL);
	}

	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String user, String pass) {
		landing.fillUsername(user);
		landing.fillPassword(pass);
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() throws InterruptedException {
		landing.clickLogin();
	}

	@Then("^Takes a (.*)$")
	public void takes_a_screenshot(String ScreenshotName) throws Exception {
		screenshot.takeFullScreenshot(baseclass.getDriver(), getScreeshotsDirectory(), ScreenshotName);
	}
}
