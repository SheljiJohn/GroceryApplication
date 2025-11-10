package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	public HomePage homepage;
	public ManageNewsPage managenews;

	@Test(description = "To publish News", groups = { "Regression Testing" })
	public void VerifyTheUserIsAbleToPublishNews() throws IOException {
		
		// String username = "admin";
		// String password = "admin";
		// Reading user name and password from excel
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login = new LoginPage(driver);
		login.enterTheUserName(username).enterThePassword(password);
		// login.enterThePassword(password);
		// once clicked on signIn the page will redirect from login page to Home page.
		homepage = login.clickOnSignIn();

		// ManageNewsPage news = new ManageNewsPage(driver);
		// once clicked on Manage Category More Info link the page will redirect from home page to manage news page.
		managenews = homepage.clickOnManageNewsMoreInfo();
		managenews.clickOnNew();
		// Reading news from excel
		String newsInfo = ExcelUtility.getStringData(1, 0, "ManageNews");
		managenews.addNews(newsInfo).clickOnSave();

		// Assertion
		boolean visibilityAlert = managenews.isAlertDisplayed();
		Assert.assertTrue(visibilityAlert, Constant.CREATENEWS);

	}
}
