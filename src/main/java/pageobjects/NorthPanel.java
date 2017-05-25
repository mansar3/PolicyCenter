package pageobjects;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.Account.AccountFileSummary;
import pageobjects.Administration.ImportLegacyRenewalData;

/**
 * Created by aansari on 3/7/17.
 */
public class NorthPanel
{
	protected  CenterSeleniumHelper sh;
	private NorthPanelBy by;
	public Administration administration;
	public NorthPanel(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new NorthPanelBy();
		administration = new Administration(sh);

	}
	public class NorthPanelBy
	{
		public   By    clickaccountNumber = By.xpath(".//*[@id='SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl']/span[2]"),
		               clickrenewalaccountnumber = By.xpath(".//*[@id='RenewalWizard:JobWizardInfoBar:AccountNumber-btnInnerEl']/span[2]");


	}

	public AccountFileSummary clickAccountNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.clickaccountNumber);
		return new AccountFileSummary(sh);
	}


	public AccountFileSummary clickAccountNumberRenewal()
	{
		sh.waitForNoMask();
		sh.clickElement(by.clickrenewalaccountnumber);
		return new AccountFileSummary(sh);
	}

	public class Administration
	{
		private CenterSeleniumHelper sh;
		public AdministrationBy by;
		public Administration(CenterSeleniumHelper sh)
		{
			this.sh = sh;
			by = new AdministrationBy();
		}
		public class AdministrationBy
		{
			By 	adminTab = By.id("TabBar:AdminTab"),
				utilities = By.id("TabBar:AdminTab:Admin_Utilities-textEl"),
				importLegacyRenewalData =By.id("TabBar:AdminTab:Admin_Utilities:Utilities_ImportLegacyRenewalWizard-textEl");

		}
		public void clickAdministration()
		{
			sh.clickElement(by.adminTab);
			sh.waitForNoMask();
		}
		public ImportLegacyRenewalData clickImportLegacyRenewalData()
		{
			sh.waitForElementToAppear(by.adminTab);


			hover(by.utilities);

			sh.waitForElementToAppear(by.importLegacyRenewalData);
			sh.clickElement(by.importLegacyRenewalData);
			return new ImportLegacyRenewalData(sh);
		}
		private void hover(By byElement)
		{

			WebElement actionTab = sh.driver.findElement(by.adminTab);
			Actions build = new Actions(sh.driver);
			build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();

			WebElement hoverElement = sh.driver.findElement(byElement);
			build.moveToElement(hoverElement).build().perform();
		}

	}
}
