package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.AccountFileContacts;

public class AccountFileSummaryWestPanel<T extends AccountFileSummaryWestPanel> extends WestPanelBase
{
	public AccountFileSummaryActions actions = new AccountFileSummaryActions(sh);
	public AccountFileContacts AFC;
	public AccountFileSummaryWestPanelBy by;
	public AccountFileSummaryWestPanel(CenterSeleniumHelper sh)
	{
		super(sh);
		actions = new AccountFileSummaryActions(sh);
		AFC = new AccountFileContacts(sh);
	}

	private static class AccountFileSummaryWestPanelBy
	{
		public static By dwelling = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:HomeownersDwelling']");
	}

	public T clickDwelling()
	{
		sh.waitForNoMask();
		sh.clickElement(by.dwelling);
		return (T)this;
	}

	public static class AccountFileSummaryActions<T extends AccountFileSummaryActions> extends ActionsBase{
		private AccountFileSummaryActionsBy by;
		private AccountFileSummaryActions(CenterSeleniumHelper sh)
		{
			this.sh = sh;
		}

		public static class AccountFileSummaryActionsBy
		{
			public static By	submission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"),
								convertManualPolicy = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_ConvertManualPolicy-textEl"),
			                    clickContacts = By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Contacts']/div/span");
		}

		public T newSubmission()
		{
			clickActions();
			sh.clickElement(by.submission);
			return (T)this;
		}
		public T convertManualPolicy()
		{
			clickActions();
			sh.clickElement(by.convertManualPolicy);
			return (T)this;
		}
		public T clickContacts()
		{
			sh.clickElement(by.clickContacts);
			return (T)this;
		}
	}
}