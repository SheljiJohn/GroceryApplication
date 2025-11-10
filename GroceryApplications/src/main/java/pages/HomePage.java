package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class HomePage {
	@FindBy(xpath = "//img[contains(@src,'https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png')]")
	WebElement userProfile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logout;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement loginpage;

	@FindBy(xpath = "//p[text() = 'Admin Users']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersMoreInfolink;
	@FindBy(xpath = "//p[text() = 'Manage Category']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement manageCategoryMoreInfo;
	@FindBy(xpath = "//p[text() = 'Manage Contact']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageContactMoreInfo;
	@FindBy(xpath = "//p[text() = 'Manage News']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	WebElement manageFooterTextMoreInfolink;
	@FindBy(xpath = "//p[text() = 'Manage News']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement manageNewsMoreInfolink;

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminUsersMoreInfolink.click();
		return new AdminUsersPage(driver);
	}

	public ManageCategoryPage clickOnManageCategoryMoreInfo() {
		manageCategoryMoreInfo.click();
		// return this;
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage manageContactMoreInfo() {
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

	public ManageFooterTextPage manageFooterTextMoreInfo() {
		manageFooterTextMoreInfolink.click();
		return new ManageFooterTextPage(driver);
	}

	public ManageNewsPage clickOnManageNewsMoreInfo() {
		manageNewsMoreInfolink.click();
		return new ManageNewsPage(driver);
	}

	public void clickOnUserProfile() {
		userProfile.click();
	}

	public void clickOnLogout() {
		logout.click();
	}

	// Assertion

	public boolean isLoginPageDisplayed() {
		return loginpage.isDisplayed();

	}
}
