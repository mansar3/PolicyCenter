package pageobjects.Administration;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by aansari on 5/24/17.
 */
public class ImportLegacyRenewalData
{
	private CenterSeleniumHelper sh;
	private ImportLegacyRenewalDataBy by;
	public ImportLegacyRenewalData(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by= new ImportLegacyRenewalDataBy();
		waitForTitle();

	}
	public class ImportLegacyRenewalDataBy
	{
		String ilrBase = "ImportLegacyRenewalWizard:";
		By	title = By.id(ilrBase + "ImportLegacyRenewalWizard_UploadScreen:ttlBar"),
			browse =By.cssSelector("input[id*=fileInputEl]"),
			finish = By.id(ilrBase + "Finish-btnInnerEl");
	}
	private void waitForTitle()
	{
		sh.waitForElementToAppear(by.title);
	}
	public ImportLegacyRenewalData uploadFile(String filePath)
	{

		WebElement browseElement = sh.driver.findElement(by.browse);
		JavascriptExecutor je =(JavascriptExecutor)sh.driver;


		je.executeScript("arguments[0].setAttribute('name','browseButton')", browseElement);
		sh.driver.findElement(By.name("browseButton")).sendKeys(filePath);
		sh.waitForElementToAppear(by.finish);
		return this;
	}
	public ImportResults clickFinish()
	{
		sh.clickElement(by.finish);
		sh.waitForNoMask();
		return new ImportResults(sh);
	}
}
