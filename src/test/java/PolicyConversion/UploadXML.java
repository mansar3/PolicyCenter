package PolicyConversion;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobjects.NorthPanel;

import java.io.File;

/**
 * Created by aansari on 5/23/17.
 */
public class UploadXML extends BaseTest
{
	// POC test to see if xml upload is possible
	@Test
	public void uploadXML()
	{

		String filepath = policyFolder + "//GW - Control File_2017_05_02_1921.xml//";
		File file = new File(filepath);
		if(!file.exists())
			Assert.fail("XML File does not exist here, please check the path.");


		// Get Driver and Instantiate Helper
		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		new NorthPanel(sh).administration.clickImportLegacyRenewalData().uploadFile(filepath).clickFinish();
	}

	@AfterMethod
	public void afterMethod()
	{
		LocalDriverManager.getDriver().quit();
	}
}
