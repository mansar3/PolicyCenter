package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6AccountFileSummary extends AccountFileSummary<FLHO6AccountFileSummary>
{
	public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
	public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
	public FLHO6AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}

	public FLHO6Quote clickTransactionNumber()
	{
		super.clickTransactionNumber();
		return new FLHO6Quote(sh, path);
	}
}