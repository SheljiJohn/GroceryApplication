package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtilities {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //// OutputScreenShot"-the screenshot
																					//// is generated in this folder ie
																					//// the loctn only
		if (!f1.exists()) {
			f1.mkdirs(); // if dir not exists,make it
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); 
	}

}
