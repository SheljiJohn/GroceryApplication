package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	// Drop down Handling

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public void selectByIndex(WebElement element, String index) {
		Select select = new Select(element);
		select.selectByVisibleText(index);

	}

	// Alert Handling

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	// Action class

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}

	public void rightClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public void click(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(element).perform();

	}

	public void draganddrop(WebElement dragelement, WebElement dropelement, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragelement, dropelement).perform();

	}

	public void mouseOver(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	// JavaScript

	public void javaScriptExecuter(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Hello World';", element);

		WebElement button = driver.findElement(By.id("button-one"));
		js.executeScript("arguments[0].click();", element);

	}

	public void scroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

}
