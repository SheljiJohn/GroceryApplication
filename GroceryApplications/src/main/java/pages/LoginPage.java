package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "//button[@data-dismiss = 'alert']")
	WebElement alert;
	@FindBy(xpath = "//p[text()= 'Dashboard']")
	WebElement dashboard;

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterTheUserName(String username2) {
		username.sendKeys(username2);
		return this;
	}

	public LoginPage enterThePassword(String password2) {
		password.sendKeys(password2);
		return this;
	}

	public HomePage clickOnSignIn() {
		signIn.click();
		return new HomePage(driver);
	}

	// Assertion

	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
