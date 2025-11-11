package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.WaitUtilities;

public class Base {

	public WebDriver driver;

	// to fetch the url from config.properties file
	public Properties properties;
	public FileInputStream fileinput;

	@BeforeMethod(alwaysRun = true)

	@Parameters("browser")

	public void initializeBrowser(String browser) throws Exception {
		 driver = new ChromeDriver();

		// fetching url
		try {

			properties = new Properties();

			fileinput = new FileInputStream(Constant.CONFIGFILE);

			properties.load(fileinput);
		} catch (Exception e) {
			System.out.println(e);
		} 

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		/*
		 * else if(browser.equalsIgnoreCase("Edge")) { driver = new EdgeDriver(); }
		 */
		else {
			throw new Exception("Browser not defined!!!!!!");
		}

		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		// fetching url from file
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICITWAIT));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void windowCloseAndQuit() throws IOException {
		System.out.println("Closing browser...");
		driver.quit();
	}

}
