package OrangehrmLive_Pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class landingPage {

	WebDriverWait wait = new WebDriverWait(baseclass.getDriver(), 15);

	public void fillUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']")))
				.sendKeys(username);
		Reporter.log("The ‘Username’ used for this test run is:>> " + "[" + username + "]",true);}

	public void fillPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
				.sendKeys(password);
		Reporter.log("The ‘Password’ used for this test run is:>> " + "[" + password + "]",true);}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();}
	
	public boolean usernameErrorMessageIsDisplayed() {
		boolean usernameErrorMessageIsPresent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")))
				.isDisplayed();return usernameErrorMessageIsPresent;}

	public String getUsernameErrorMessage() {
		String usernameMessage = baseclass.getDriver().findElement(By.xpath(
				"(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]"))
				.getText().toString();return usernameMessage;}
	
	public boolean invalidCredentialsIsDisplayed() {
		boolean InvalidCredentialsErrorMessageIsPresent = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-alert-content-text'])[1]")))
				.isDisplayed();return InvalidCredentialsErrorMessageIsPresent;}

	public String getInvalidCredentialsErrorMessage() {
		String invalidCredentialsErrorMessage = baseclass.getDriver()
				.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p oxd-alert-content-text'])[1]")).getText()
				.toString();return invalidCredentialsErrorMessage;}
}