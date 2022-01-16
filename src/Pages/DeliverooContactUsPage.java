package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DeliverooContactUsPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@class='ccl-2a4b5924e2237093 ccl-29aecca02620e7cc ccl-a1841d8ca69cee4a ccl-4be034de38ffc86c']")
	@CacheLookup
	WebElement lblHeader;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_3']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_11']")
	@CacheLookup
	WebElement txteMail;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_5']")
	@CacheLookup
	WebElement txtPhone;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_4']")
	@CacheLookup
	WebElement txtCompanyName;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_4728']")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.XPATH, using = "//*[@id='submit_button']")
	@CacheLookup
	WebElement btnSumbit;

	@FindBy(how = How.XPATH, using = "//*[@class='goBackButton']")
	@CacheLookup
	WebElement btnGoBack;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_16']")
	@CacheLookup
	WebElement ddlTeamSize;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_20']")
	@CacheLookup
	WebElement ddlIndustry;

	@FindBy(how = How.XPATH, using = "//*[@id='tfa_40']")
	@CacheLookup
	WebElement ddlReasonOfUse;

	WebElement popupError;
	Select slcTeamSize;
	Select slcIndustry;
	Select slcReasonOfUse;
	WebElement txtFirstName;

	
	void SetFirstName(String firstName) {
		txtFirstName = driver.findElement(By.id("tfa_2"));
		txtFirstName.sendKeys(firstName);
	}

	void SetLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	void SeteMail(String email) {
		txteMail.sendKeys(email);
	}

	void SetPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	void SetCompanyName(String companyName) {
		txtCompanyName.sendKeys(companyName);
	}

	void SetCity(String city) {
		txtCity.sendKeys(city);
	}

	void SetTeamSize(int i) {
		slcTeamSize = new Select(ddlTeamSize);
		slcTeamSize.selectByIndex(i);
	}

	void SetIndustry(int i) {
		slcIndustry = new Select(ddlIndustry);
		slcIndustry.selectByIndex(i);
	}

	void SetReasonOfUse(int i) {
		slcReasonOfUse = new Select(ddlReasonOfUse);
		slcReasonOfUse.selectByIndex(i);
	}

	void SendClick() {
		btnSumbit.click();
	}

	public String getPageHeader() {
		return lblHeader.getText();

	}
	
	public String getErrorMessage() {
		return driver.switchTo().alert().getText();
	}

	public void SubmitContact(String firstName, String lastName, String email,
			String phone, String companyName, String city, int teamSizeIndex,
			int industryIndex, int reasonOfUseIndex) {

		driver.switchTo().frame("deliverooIframe");
		SetFirstName(firstName);
		SetLastName(lastName);
		SeteMail(email);
		SetPhone(phone);
		SetCompanyName(companyName);
		SetCity(city);
		SetTeamSize(teamSizeIndex);
		SetIndustry(industryIndex);
		SetReasonOfUse(reasonOfUseIndex);
		SendClick();

	}

}
