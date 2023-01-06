package Cucumber_TestRunner;

import org.testng.annotations.DataProvider;

import OrangehrmLive_Pageclass.baseclass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Cucumber_Features", glue = { "Cucumber_StepDefinitions" }, plugin = {
		"pretty", "html:target/cucumber-reports.html" })

public class parallelRun extends baseclass {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}