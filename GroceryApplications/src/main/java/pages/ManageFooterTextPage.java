package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageFooterTextPage {

	/*
	 * @FindBy(xpath =
	 * "//p[text() = 'Manage News']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']"
	 * ) WebElement manageFooterTextMoreInfolink;
	 */
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	WebElement actionEdit;
	@FindBy(xpath = "//textarea[@id='content' and @name='address']")
	WebElement addressInput;
	@FindBy(xpath = "//input[@id='email' and @name='email']")
	WebElement emailInput;
	@FindBy(xpath = "//input[@id='phone' and @name='phone']")
	WebElement phoneInput;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement alerts;

	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods for Manage Footer Text page

	/*
	 * public void manageFooterTextMoreInfo() {
	 * manageFooterTextMoreInfolink.click(); }
	 */

	public ManageFooterTextPage clickOnAction() {
		actionEdit.click();
		return this;
	}

	public ManageFooterTextPage updateAddress(String address) {
		addressInput.clear();
		addressInput.sendKeys(address);
		return this;
	}

	public ManageFooterTextPage updateEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
		return this;
	}

	public ManageFooterTextPage updatePhone(String phone) {
		phoneInput.clear();
		phoneInput.sendKeys(phone);
		return this;
	}

	public ManageFooterTextPage clickOnUpdate() {
		WaitUtilities wait = new WaitUtilities();
		wait.waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		return this;
	}

	// Assertion

	public boolean isAlertDisplayed() {
		return alerts.isDisplayed();

	}

	// to be implemented

	public void clickOnReset() {
		WaitUtilities wait = new WaitUtilities();
		wait.waitForElementToBeClickable(driver, resetButton);
		resetButton.click();
	}

}
