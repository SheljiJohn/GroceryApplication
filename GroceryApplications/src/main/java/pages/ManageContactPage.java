package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageContactPage {

	/*
	 * @FindBy(xpath =
	 * "//p[text() = 'Manage Contact']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']"
	 * ) WebElement manageContactMoreInfo;
	 */
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement actionEdit;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneInput;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressInput;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTimeInput;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryChargeLimitInput;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset' and @href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement resetButton;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement alerts;

	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods for Manage Contact Page

	/*
	 * public void manageContactMoreInfo() { manageContactMoreInfo.click(); }
	 */

	public ManageContactPage clickOnAction() {
		actionEdit.click();
		return this;
	}

	public ManageContactPage updatePhone(String phone) {
		phoneInput.clear();
		phoneInput.sendKeys(phone);
		return this;
	}

	public ManageContactPage updateEmail(String email) {
		emailInput.clear();
		emailInput.sendKeys(email);
		return this;
	}

	public ManageContactPage updateAddress(String address) {
		addressInput.clear();
		addressInput.sendKeys(address);
		return this;
	}

	public ManageContactPage updateDeliveryTime(String deliveryTime) {
		deliveryTimeInput.clear();
		// String deliveryTime =Integer.toString(deliveryTime2);
		deliveryTimeInput.sendKeys(deliveryTime);
		return this;
	}

	public ManageContactPage updateDeliveryChargeLimit(String deliveryCharge) {
		deliveryChargeLimitInput.clear();
		// String deliveryChargeLimit =Integer.toString(deliveryCharge);
		deliveryChargeLimitInput.sendKeys(deliveryCharge);
		return this;
	}

	public ManageContactPage clickOnUpdate() {
		WaitUtilities wait = new WaitUtilities();
		wait.waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		return this;
	}

	// Assertion

	public boolean isAlertDisplayed() {
		return alerts.isDisplayed();

	}

	// to be implement

	public void clickOnReset() {
		WaitUtilities wait = new WaitUtilities();
		wait.waitForElementToBeClickable(driver, resetButton);
		resetButton.click();
	}

}
