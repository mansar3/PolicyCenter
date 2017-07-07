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
				dwelling = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:HomeownersDwelling']"),
		        inforceAccountnumber = By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_PolicyTermsLV-body']//div[text() = 'In Force']/../preceding-sibling::td[2]//a"),
		        cancelledPolicyNumber = By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_PolicyTermsLV-body']//div[text() = 'Canceled']/../preceding-sibling::td[2]//a"),
		        scheduledpolicynumber = By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_PolicyTermsLV-body']//div[text() = 'Scheduled']/../preceding-sibling::td[2]//a"),
		        transactionnumberrenewal = By.xpath(".//*[@id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_WorkOrdersLV-body']//div[text() = 'Renewal']/../preceding-sibling::td[4]//a");
	}

	protected String getAccountNumber()
	{
		sh.waitForNoMask();
		return sh.getText(by.accountNumber);
	}

	public void clickTransactionNumber()
	{
		sh.clickElement(by.transactionNumber);
		return;
	}

	protected T clickCoverages()
	{
		sh.waitForNoMask();
		sh.clickElement(by.coverages);
		return (T)this;
	}

	public T clickInforceAccountNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.inforceAccountnumber);
		return (T) this;
	}
	public T clickTransactionNumberRenewalPen()
	{
		sh.waitForNoMask();
		sh.clickElement(by.transactionnumberrenewal);
		return (T) this;
	}

	public T clickCanceledPolicyNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.cancelledPolicyNumber);
		return (T) this;
	}

	public T clickScheduledPolicyNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.scheduledpolicynumber);
		return (T) this;
	}
}