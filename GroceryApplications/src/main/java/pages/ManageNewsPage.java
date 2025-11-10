package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageNewsPage {

	/*
	 * @FindBy(xpath =
	 * "//p[text() = 'Manage News']//following::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']"
	 * ) WebElement manageNewsMoreInfolink;
	 */
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement addNews;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement inputNews;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alerts;

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods for Manage News page

	/*
	 * public void clickOnManageNewsMoreInfo() { manageNewsMoreInfolink.click(); }
	 */

	public ManageNewsPage clickOnNew() {
		addNews.click();
		return this;
	}

	public ManageNewsPage addNews(String newsinfo) {
		inputNews.sendKeys(newsinfo);
		return this;
	}

	public ManageNewsPage clickOnSave() {
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
