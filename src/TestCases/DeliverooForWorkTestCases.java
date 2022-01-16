package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.DeliverooContactUsPage;
import Pages.DeliverooForWorkPage;
import Pages.DeliverooPage;

public class DeliverooForWorkTestCases extends BaseTest

{
	@DataProvider
	public Object[][] dpContactUsInput() throws Exception {

		return dpAdaptor(prop.getProperty("Inputdatafilepath") + "ContactUsTestData.xlsx", "DliverooForWork", 9);

	}

	@DataProvider
	public Object[][] dpContactUsOutput() throws Exception {

		return dpAdaptor(prop.getProperty("expectedoutputfile") + "Messages.xlsx", "ContactUs", 2);

	}
	
	@DataProvider
	public Object[][] dpContactUs() throws Exception{
	    return decart(dpContactUsInput(),  dpContactUsOutput());
	}


	
	@Test
	(dataProvider = "dpContactUs")
	public void DliverooFailedContactUs(String firstName, String lastName, String email,
			String phone, String companyName, String city, String teamSizeIndex,
			String industryIndex, String reasonOfUseIndex, String HeaderMessage, String ErrorMessage) throws Exception {
		
		String fileSuffix;
		
		try {
			BasePage.driver = driver;
			DeliverooPage home_page = PageFactory.initElements(driver,
					DeliverooPage.class);
			home_page.PartnerWithUsClick();
			home_page.DeliverooForWorkClick();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			DeliverooForWorkPage dliverooForWork_page = PageFactory
					.initElements(driver, DeliverooForWorkPage.class);
			dliverooForWork_page.ContactUsClick();

			DeliverooContactUsPage dliverooContactUs_page = PageFactory
					.initElements(driver, DeliverooContactUsPage.class);
			String str = dliverooContactUs_page.getPageHeader();

			Assert.assertEquals(str, HeaderMessage);

		
			dliverooContactUs_page.SubmitContact(firstName, lastName,email,phone,companyName,city,
					Integer.parseInt(teamSizeIndex),Integer.parseInt(industryIndex),Integer.parseInt(reasonOfUseIndex));
			str = dliverooContactUs_page.getErrorMessage();

			
			Assert.assertTrue(str
					.contains(ErrorMessage));

		} catch (Exception e) {
			fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date());
			getScreenShot("DliverooFailedContactUs_" + fileSuffix);
			throw e;
		}
	}
}
