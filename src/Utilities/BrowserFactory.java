package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {


	// This class contains every browser functions that is used in the project
	public static WebDriver startBrowser(String browser, String url) {

		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					".\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					".\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
