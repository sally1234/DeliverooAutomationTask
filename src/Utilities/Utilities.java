package Utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public void takeScreenshots(WebDriver driver) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// FileUtils.copyFile(screenshot, new File(fileSource));

	}

}
