package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeliverooPage extends BasePage{
	

	@FindBy(how = How.XPATH, using = "//*[@class='ccl-96b19cfbe8b53b1f']")
	@CacheLookup
	WebElement btnPartnerWithUs;
				
	@FindBy(how = How.XPATH, using = "//*[@id='location-search']")
	@CacheLookup
	WebElement txtLocation;
	
	WebElement menuItemDeliverooForWork;
	WebElement ddlLocations;
	
	public void PartnerWithUsClick()
	{
		btnPartnerWithUs.click();
	}
	
	public void DeliverooForWorkClick()
	{			
		menuItemDeliverooForWork =driver.findElements(By.xpath("//*[@class='ccl-8895c83ac1a67a9f']//*[@class ='ccl-c7e8470a1e905a95 ccl-2b95b58eee016846']//*[@class='ccl-19882374e640f487 ccl-417df52a76832172 ccl-deab34eb04186352 ccl-d20a5732188988de ccl-6a536dee6972c57c']")).get(1);
		menuItemDeliverooForWork.click();
	}
	
	public void SetLocation(String location) 
	{
		txtLocation.sendKeys(location);
		
		ScollToElement(txtLocation);
		
		ThreadSleep(3000);
		
		ddlLocations = driver.findElements(By.xpath("//*[@class='ccl-208b296b2fcd108c ccl-bce792ee73ed1239']//*[@class='ccl-0f24ac4b87ce1f67 ccl-abe5c41af1b9498e ccl-94235a1794a6d4be']")).get(0);
		ddlLocations.click();

	}
}
