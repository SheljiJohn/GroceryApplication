package pages;

import java.awt.AWTException;
import java.lang.invoke.ConstantBootstraps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtilities;

public class ManageCategoryPage {

	/*
	 * @FindBy(xpath =
	 * "//p[text() = 'Manage Category']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']"
	 * ) WebElement manageCategoryMoreInfo;
	 */
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement addNewCategory;
	@FindBy(xpath = "//input[@id = 'category']")
	WebElement inputCategory;
	@FindBy(xpath = "//li[@id = '134-selectable']//parent::span[text() = 'discount']")
	WebElement dragObj;
//	@FindBy(xpath = "//ul[@class= 'ms-list']//following::li[@id='134-selection']")WebElement dropObj;
	@FindBy(xpath = "//input[@id = 'main_img']")
	WebElement image;
	@FindBy(xpath = "//input[@value='yes' and @name='top_menu']")
	WebElement topMenu;
	@FindBy(xpath = "//input[@value='no' and @name='show_home']")
	WebElement leftMenu;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//following::h5[text()=' Alert!']")
	WebElement alerts;

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Methods for Manage Category Page

	/*
	 * public void clickOnManageCategoryMoreInfo() { manageCategoryMoreInfo.click();
	 * //return this; }
	 */

	public ManageCategoryPage clickOnNew() {
		addNewCategory.click();
		return this;
	}

	public ManageCategoryPage addCategory(String categories) {
		inputCategory.sendKeys(categories);
		return this;
	}

	public ManageCategoryPage selectGroup() {
		PageUtilities actionobj = new PageUtilities();
		actionobj.click(dragObj, driver);
		return this;
	}

	public ManageCategoryPage uploadImage() throws AWTException {
		FileUploadUtility fileupload = new FileUploadUtility();
		// image.sendKeys(Constant.IMAGEFILETOYS);
		fileupload.fileUploadUsingSendKeys(image, Constant.IMAGEFILETOYS);
		// fileupload.fileUploadUsingRobotClass(image, Constant.IMAGEFILETOYS);
		return this;
	}

	public ManageCategoryPage javaScriptScroll(WebDriver driver) {
		PageUtilities js = new PageUtilities();
		js.scroll(driver);
		return this;
	}

	public ManageCategoryPage selectTopMenuOption() {
		topMenu.click();
		return this;
	}

	public ManageCategoryPage selectLeftMenuOption() {
		leftMenu.click();
		return this;
	}

	public ManageCategoryPage clickOnSave() {
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
