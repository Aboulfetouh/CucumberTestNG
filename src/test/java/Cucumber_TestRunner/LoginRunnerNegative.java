package Cucumber_TestRunner;

import OrangehrmLive_Pageclass.baseclass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Cucumber_Features", glue = {
		"Cucumber_StepDefinitions" }, tags = "@negative", plugin = { "pretty", "html:target/cucumber-reports.html" })
public class LoginRunnerNegative extends baseclass {
}