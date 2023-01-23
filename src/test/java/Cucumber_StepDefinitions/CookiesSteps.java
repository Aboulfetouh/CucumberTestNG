package Cucumber_StepDefinitions;

import java.io.IOException;
import org.testng.Assert;
import OrangehrmLive_Pageclass.baseclass;
import OrangehrmLive_Pageclass.dashboardPage;
import static Readerclass.configReader.*;
import UtilitiesClass.CookiesManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CookiesSteps {

	baseclass base = new baseclass();
	dashboardPage dash = new dashboardPage();
	CookiesManager manager = new CookiesManager();

	@Then("Was directed to the DashBoard page {int}")
	public void was_directed_to_the_dash_board_page(int size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("DashBoard Assertion Before Cookies Passed");
	}

	@And("^Stores the session (.*)$")
	public void stores_the_session_cookies(String Cookies) throws IOException {
		manager.storeCookiesToText(getStringValue("TestoOutputDir") + getStringValue("cookiesDir"), Cookies);
	}

	@And("^User opens the (.*)$")
	public void user_opens_the_dashurl(String DashURL) throws Exception {
		base.getURL(DashURL);
	}

	@When("^User loads the session (.*)$")
	public void user_loads_the_session_cookies(String Cookies) throws IOException {
		manager.loadCookies(getStringValue("TestoOutputDir") + getStringValue("cookiesDir"), Cookies);
	}

	@Then("User should be able to see the DashBoard page {int}")
	public void user_should_be_able_to_see_the_dash_board_page(Integer size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("DashBoard Assertion After Cookies Passed");
	}
}