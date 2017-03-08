package pageobjects;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.Account.AccountFileSummary;

/**
 * Created by aansari on 3/7/17.
 */
public class NorthPanel
{
	protected  CenterSeleniumHelper sh;
	private NorthPanelBy by;

	public NorthPanel(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new NorthPanelBy();
	}
	public class NorthPanelBy
	{
		public   By    clickaccountNumber = By.xpath(".//*[@id='SubmissionWizard:JobWizardInfoBar:AccountNumber-btnInnerEl']/span[2]");


	}

	public AccountFileSummary clickAccountNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.clickaccountNumber);
		return new AccountFileSummary(sh);
	}

}
