package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	public HomePage homepage;
	public AdminUsersPage adminusers;

	@Test(description = "To add admin users with user type", groups = { "Regression Testing" }) // (retryAnalyzer =
																								// retry.Retry.class,)
	public void VerifyTheUserIsAbleToAddAdminUsers() throws IOException {
		// reading user name and password from excel
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username).enterThePassword(password);
		// login.enterThePassword(password);
		// once clicked on signIn the page will redirect from login page to Home page.
		homepage = login.clickOnSignIn();

		// AdminUsersPage adminuser = new AdminUsersPage(driver);
		// once clicked on Manage Category More Info link the page will redirect from home page to admin users page.
		adminusers = homepage.clickOnAdminUsersMoreInfo();
		adminusers.clickOnNew();
		/*
		 * String adminusername = ExcelUtility.getStringData(3, 0, "AdminUsers"); /
		 * String adminpassword = ExcelUtility.getStringData(3, 1, "AdminUsers");
		 */
		// using faker to generate user name and password
		FakerUtility faker = new FakerUtility();
		String adminusername = faker.creatARandomFirstName();
		String adminpassword = faker.creatARandomFirstName();
		// reading user name from excel
		String usertype = ExcelUtility.getStringData(3, 2, "AdminUsers");
		adminusers.enterTheUserName(adminusername).enterThePassword(adminpassword).selectUserType(usertype)
				.clickOnSave();
		/*
		 * adminuser.enterThePassword(adminpassword);
		 * adminuser.selectUserType(usertype); 
		 * adminuser.clickOnSave();
		 */

		// Assertion
		boolean visibilityAlert = adminusers.isAlertDisplayed();
		Assert.assertTrue(visibilityAlert, Constant.ADMINUSER);

	}

}
