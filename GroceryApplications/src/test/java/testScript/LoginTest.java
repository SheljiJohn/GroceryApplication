package testScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base

{
	
	public HomePage homepage;
	
	@Test(description = "Login to Grocery application with valid username and password", groups = {
			"Regression Testing" })
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {

		// String username = "admin";
		// String password = "admin";
		// Reading user name and password from excel
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username).enterThePassword(password);
		// login.enterThePassword(password);
		login.clickOnSignIn();

		// Assertion
		boolean visibilty = login.isHomePageLoaded();
		Assert.assertTrue(visibilty, Constant.VALIDCREDENTIALS);

	}

	@Test(description = "Login to Grocery application with invalid username and valid password")
	public void verifyTheUserIsUnableToLoginwithInvalidUsernameandValidPassword() {

		String username = "username";
		String password = "admin";
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username);
		login.enterThePassword(password);
		login.clickOnSignIn();

		// Assertion
		boolean alert = login.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDUSERNAME);

	}

	@Test(description = "Login to Grocery application with valid username and invalid password")
	public void verifyTheUserIsUnableToLoginwithValidUsernameandInvalidPassword() {

		String username = "admin";
		String password = "password";
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username);
		login.enterThePassword(password);
		login.clickOnSignIn();

		// Assertion
		boolean alert = login.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDPASSWORD);

	}

	@Test(description = "Login to Grocery application with invalid username and password")
	public void verifyTheUserIsUnableToLoginwithInValidUsernameandInvalidPassword() {

		String username = "username";
		String password = "password";
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username);
		login.enterThePassword(password);
		login.clickOnSignIn();

		// Assertion
		boolean alert = login.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.INVALIDCREDENTIALS);

	}

}
