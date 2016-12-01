package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.CenterPanel.InitiateManualRenewal;
import pageobjects.CenterPanel.NewSubmission;

public class AccountFileSummaryWestPanel extends WestPanelBase
{
	public AccountFileSummaryActions actions;
	public AccountFileSummaryWestPanel(CenterSeleniumHelper sh)
	{
		super(sh);
		actions = new AccountFileSummaryActions(sh);
	}


	public static class AccountFileSummaryActions extends ActionsBase{
		private AccountFileSummaryActionsBy by;
		private AccountFileSummaryActions(CenterSeleniumHelper sh)
		{
			this.sh = sh;
		}

		public static class AccountFileSummaryActionsBy{
			public static By	submission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"),
								convertManualPolicy = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_ConvertManualPolicy-textEl");
		}

		public NewSubmission newSubmission()
		{
			clickActions();
			sh.clickElement(by.submission);
			return new NewSubmission(sh);
		}
		public InitiateManualRenewal convertManualPolicy()
		{
			clickActions();
			sh.clickElement(by.convertManualPolicy);
			return new InitiateManualRenewal(sh);
		}
	}
}