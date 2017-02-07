package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class AccountFileSummaryWestPanel<T extends AccountFileSummaryWestPanel> extends WestPanelBase
{
	public AccountFileSummaryActions actions = new AccountFileSummaryActions(sh);
	public AccountFileSummaryWestPanel(CenterSeleniumHelper sh)
	{
		super(sh);
		actions = new AccountFileSummaryActions(sh);
	}


	public static class AccountFileSummaryActions<T extends AccountFileSummaryActions> extends ActionsBase{
		private AccountFileSummaryActionsBy by;
		private AccountFileSummaryActions(CenterSeleniumHelper sh)
		{
			this.sh = sh;
		}

		public static class AccountFileSummaryActionsBy{
			public static By	submission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"),
								convertManualPolicy = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_ConvertManualPolicy-textEl");
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
	}
}