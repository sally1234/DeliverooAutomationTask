package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	protected WebDriverWait wait = new WebDriverWait(driver, 50);

	protected void ScollToElement(WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", element);
	}

	protected FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofMillis(200))
			.ignoring(NoSuchElementException.class);
	
	protected void ThreadSleep(int x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
