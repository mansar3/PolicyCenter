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
		public By	accountNumber = By.id(screen + "AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl");
	}

	protected String getAccountNumber()
	{
		return sh.getText(by.accountNumber);
	}
}