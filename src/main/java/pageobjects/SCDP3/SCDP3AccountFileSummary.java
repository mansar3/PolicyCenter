package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3AccountFileSummary extends AccountFileSummary<SCDP3AccountFileSummary>
{
	public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
	public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
	public SCDP3AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}
	public Summary clickInforcedAccountNumber()
	{
		sh.waitForNoMask();
		super.clickInforceAccountNumber();
		return new Summary(sh);

	}

}
