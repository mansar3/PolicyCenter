package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3AccountFileSummary extends AccountFileSummary<FLHO3AccountFileSummary>
{
	public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
	public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
	public FLHO3AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}

	public FLHO3Quote clickTransactionNumber()
	{
		super.clickTransactionNumber();
		return new FLHO3Quote(sh, path);
	}
}