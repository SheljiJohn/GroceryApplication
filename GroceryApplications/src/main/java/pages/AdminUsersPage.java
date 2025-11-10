package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class AdminUsersPage {

	/*
	 * @FindBy(xpath =
	 * "//p[text() = 'Admin Users']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']"
	 * ) WebElement adminUsersMoreInfolink;
	 */
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @class = 'btn btn-rounded btn-danger']")
	WebElement newAdminuser;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement adminUserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alerts;

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// method for AdminUser Page

	/*
	 * public void clickOnAdminUsersMoreInfo() { adminUsersMoreInfolink.click(); }
	 */
	public AdminUsersPage clickOnNew() {
		newAdminuser.click();
		return this;
	}

	public AdminUsersPage enterTheUserName(String adminusername) {
		adminUserName.sendKeys(adminusername);
		return this;
	}

	public AdminUsersPage enterThePassword(String adminpassword) {
		adminPassword.sendKeys(adminpassword);
		return this;
	}

	public AdminUsersPage selectUserType(String adminpassword) throws IOException {
		String userType = ExcelUtility.getStringData(1, 2, "AdminUsers");
		PageUtilities usertype = new PageUtilities();
		usertype.selectByVisibleText(adminUserType, userType);
		return this;
	}

	public AdminUsersPage clickOnSave() {
		WaitUtilities wait = new WaitUtilities();
		wait.waitForElementToBeClickable(driver, save);
		save.click();
		return this;

	}

	// Assertion

	public boolean isAlertDisplayed() {
		return alerts.isDisplayed();
	}
}
