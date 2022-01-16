package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResturantListPage extends BasePage {

	WebElement lnkResurant;
	WebElement btnTermsAndConfditiotnsOK;
	WebElement btnAcceptAllCookies;
	WebElement lblResutrantName;

	public void DeliverooForWorkClick() {

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//*[@class='HomeFeed-9f88579959faeb0c']//*[@class='HomeFeedUICard-a765383cf099108b']"),
				1));

		lnkResurant = driver
				.findElements(
						By.xpath("//*[@class='HomeFeed-9f88579959faeb0c']//*[@class='HomeFeedUICard-a765383cf099108b']"))
				.get(0);

		wait.until(ExpectedConditions.visibilityOf(lnkResurant));
		lnkResurant.click();
	}

	public String GetResturantName() {

		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
				By.xpath("//*[@class='ccl-19882374e640f487 ccl-1daa0367dee37c3b ccl-a5fb02a1085896d3 ccl-dd90031787517421 ccl-9d0a5327c911d0f3']"),
				1));

		lblResutrantName = driver
				.findElements(
						By.xpath("//*[@class='ccl-19882374e640f487 ccl-1daa0367dee37c3b ccl-a5fb02a1085896d3 ccl-dd90031787517421 ccl-9d0a5327c911d0f3']"))
				.get(0);
		return lblResutrantName.getText();
	}

	public void ConfirmTermsAndCondition() {

		btnTermsAndConfditiotnsOK = driver
				.findElement(By
						.xpath("//*[@class='ccl-d0484b0360a2b432 ccl-233931c277401e86 ccl-ed9aadeaa18a9f19 ccl-a97a150ddadaa172']//*[@class ='ccl-cce251427bbe4ec4']"));

		ScollToElement(btnTermsAndConfditiotnsOK);

		wait.until(ExpectedConditions
				.elementToBeClickable(btnTermsAndConfditiotnsOK));
		btnTermsAndConfditiotnsOK.click();
	}

	public void AcceptCookies()

	{
		btnAcceptAllCookies = driver.findElement(By
				.xpath("//*[@id='onetrust-accept-btn-handler']"));
		btnAcceptAllCookies.click();
	}

}
