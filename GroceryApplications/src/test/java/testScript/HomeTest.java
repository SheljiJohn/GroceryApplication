package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class HomeTest extends Base {

	@Test(description = " To logout from grocery application", groups = { "Regression Testing" })
	public void VerifyTheUserIsAbleToLogout() throws IOException {
		
		// Read user name and password from excel
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username).enterThePassword(password);
		// login.enterThePassword(password);
		login.clickOnSignIn();

		HomePage logout = new HomePage(driver);
		logout.clickOnUserProfile();
		logout.clickOnLogout();

		// Assertion
		boolean visibility = logout.isLoginPageDisplayed();
		Assert.assertTrue(visibility, Constant.LOGOUT);

	}

}
