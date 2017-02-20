package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3AccountFileSummary extends AccountFileSummary<NCHO3AccountFileSummary>
{
	public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
	public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
	public NCHO3AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}

}
