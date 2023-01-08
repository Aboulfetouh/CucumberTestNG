package OrangehrmLive_Pageclass;

import static Readerclass.configReader.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass extends AbstractTestNGCucumberTests {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		baseclass.driver.set(driver);
	}

	@BeforeMethod
	public void browserSetup() throws Exception {
		setupDriver(getBrowser(), getHeadlessMode());
		System.out.println("@BeforeMethod Has Started.");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}

	public void getURL(String URL) throws Exception {
		System.out.println("Opening the following URL >> [" + URL + "]");
		getDriver().get(URL);
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	void setupDriver(String BrowserName, boolean headless) throws Exception {
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			// Creating an object of ChromeDriver
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions().setHeadless(headless);
			setDriver(new ChromeDriver(options));
			System.out.println("Lunching '" + BrowserName + "' as a web-browser");
			System.out.println("Headless-Mode property value is >> " + headless);
		} else if (BrowserName.equalsIgnoreCase("Firefox")) {
			// Creating an object of FirefoxDriver
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions().setHeadless(headless);
			setDriver(new FirefoxDriver(options));
			System.out.println("Lunching '" + BrowserName + "' as a web-browser");
			System.out.println("Headless-Mode property value is >> " + headless);
		}
		// Exception handling in case both of the above conditions are not met
		else {
			throw new Exception(
					"\n" + "**WARRNING** The value of the browser in the 'Configuration File' is not filled properly"
							+ "\n" + "Please set the value to either 'Chrome' or 'Firefox' and try again :)");
		}
	}

	@AfterMethod
	public void tearDown() throws IOException {
		getDriver().quit();
		System.out.println("Closing the web-browser");
	}
}
