package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;

public abstract class AccountFileSummary<T extends AccountFileSummary> extends CenterPanelBase
{
	private AccountFileSummaryBy by = new AccountFileSummaryBy();
	public AccountFileSummaryWestPanel westPanel;

	public AccountFileSummary(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Account File Summary";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
		westPanel = new AccountFileSummaryWestPanel(sh);
	}

	public class AccountFileSummaryBy extends CenterPanelBy
	{
		private  String	screen = "AccountFile_Summary:AccountFile_SummaryScreen:";
		public By coverages = By.xpath(".//*[@id='westPanel']//span[text()='Coverages']"),
				accountNumber = By.id(screen + "AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"),
				transactionNumber = By.id(screen + "AccountFile_Summary_WorkOrdersLV:0:WorkOrderNumber"),
				dwelling = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:HomeownersDwelling']");
	}

	protected String getAccountNumber()
	{
		sh.waitForNoMask();
		return sh.getText(by.accountNumber);
	}

	public <T extends CenterPanelBase> T clickTransactionNumber()
	{
		sh.clickElement(by.transactionNumber);
		return (T)this;
	}

	protected T clickCoverages()
	{
		sh.waitForNoMask();
		sh.clickElement(by.coverages);
		return (T)this;
	}
}