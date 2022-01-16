package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeliverooForWorkPage extends BasePage{
	
	
	@FindBy(how = How.XPATH, using = "//*[@class='DFWButton-b80fb713bd1e6b97']")
	@CacheLookup
	WebElement btnContactUs;

	public void ContactUsClick()
	{
		btnContactUs.click();
	}
	
	

}
