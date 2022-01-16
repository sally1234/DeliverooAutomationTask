package Pages;

import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResturantDetailsPage extends BasePage {

	// WebElement lblResutrantName;

	WebElement lblResutrantName = wait
			.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return lblResutrantName = driver.findElement(By
							.xpath("//*[@class='ccl-2a4b5924e2237093 ccl-21bead492ce4ada2 ccl-9ff886da4b0592ae ccl-3fa5b2e17742d58a']"));

				}
			});

	public String GetResturantName() {

		return lblResutrantName.getText();
	}

}
