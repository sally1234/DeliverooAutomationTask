package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.DeliverooPage;
import Pages.ResturantDetailsPage;
import Pages.ResturantListPage;

public class DeliverooResturantTestCases extends BaseTest {

	@Test
	public void CheckResturantDetails() throws Exception {

		String fileSuffix;
		String restNameFromList;
		String restName;
		try {
			BasePage.driver = driver;
			DeliverooPage home_page = PageFactory.initElements(driver,
					DeliverooPage.class);		
			home_page.SetLocation("lo");

			Thread.sleep(3000);
			
			ResturantListPage resturantListPage = new ResturantListPage();
			resturantListPage.AcceptCookies();
			resturantListPage.ConfirmTermsAndCondition();
			restNameFromList = resturantListPage.GetResturantName();
			resturantListPage.DeliverooForWorkClick();
			
				
			ResturantDetailsPage resturantDetailsPage = new ResturantDetailsPage();
			restName = resturantDetailsPage.GetResturantName();
			Boolean res = false;
			
			if (restName.trim().contains(restNameFromList.trim()) || restName.trim().equals(restNameFromList.trim()))
				res = true;
			Assert.assertTrue(res);

		} catch (Exception e) {
			fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date());
			getScreenShot("CheckResturantDetails_" + fileSuffix);
			throw e;
		}
	}
}
