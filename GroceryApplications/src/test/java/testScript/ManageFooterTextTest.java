package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

	public HomePage homepage;
	public ManageFooterTextPage managefooter;

	@Test(description = " To update footer text", groups = { "Regression Testing" })
	public void VerifyTheUserIsAbleToUpdateFooterText() throws IOException {

		// Reading user name and password from excel
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username).enterThePassword(password);
		// login.enterThePassword(password);
		// once clicked on signIn the page will redirect from login page to Home page.
		homepage = login.clickOnSignIn();

		// ManageFooterTextPage footer = new ManageFooterTextPage(driver);
		// once clicked on Manage Category More Info link the page will redirect from home page to manage footer text page.
		managefooter = homepage.manageFooterTextMoreInfo();
		managefooter.clickOnAction();
		// String address = "abcdefg";
		// Reading address from excel
		String address = ExcelUtility.getStringData(1, 0, "ManageFooter");
		// String email = "absxyz@gmail.com";
		// Reading email from excel
		String email = ExcelUtility.getStringData(1, 1, "ManageFooter");
		// String phone = "01299456789";
		// Reading phone number from excel
		String phone = ExcelUtility.getStringData(1, 2, "ManageFooter");
		managefooter.updateAddress(address).updateEmail(email).updatePhone(phone);
		/*
		 * footer.updateEmail(email); footer.updatePhone(phone);
		 */
		managefooter.clickOnUpdate();

		// Assertion
		boolean visibilityAlert = managefooter.isAlertDisplayed();
		Assert.assertTrue(visibilityAlert, Constant.UPDATEFOOTER);

	}
}
