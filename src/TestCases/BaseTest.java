package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Utilities.BrowserFactory;
import Utilities.ExcelUtils;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public String FileDateTime = new SimpleDateFormat("yyyyMMddHHmm")
			.format(new Date());

	@BeforeClass
	public void setup() {

		if (prop == null)
			ReadConfigFile();

		driver = BrowserFactory.startBrowser(prop.getProperty("browser"),
				prop.getProperty("url"));

	}

	// Read the config file
	public void ReadConfigFile() {
		prop = new Properties();
		try {
			InputStream input = null;
			input = new FileInputStream("Resources/Configs/Configs.properties");
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();

	}

	@DataProvider
	public Object[][] dpAdaptor(String FileName, String SheetName, int numOfCol)
			throws Exception {

		if (prop == null)
			ReadConfigFile();

		Object[][] testObjArray = ExcelUtils.getTableArray(FileName, SheetName,
				numOfCol);

		return (testObjArray);

	}

	public void getScreenShot(String testName) {
		String filename = testName + FileDateTime + ".png";

		File screenshotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("Screenshots/"
					+ filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[][] decart(Object[][] a1, Object[][] a2) {
		List<Object[]> rez = new LinkedList();
		for (Object[] o : a1) {
			for (Object[] o2 : a2) {
				rez.add(concatAll(o, o2));
			}
		}
		return rez.toArray(new Object[0][0]);
	}

	// in future, probably, I will need do decart for varargs two.
	public <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

}
