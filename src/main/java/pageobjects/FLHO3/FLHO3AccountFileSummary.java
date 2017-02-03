package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3AccountFileSummary extends AccountFileSummary<FLHO3AccountFileSummary>
{
	public FLHO3AccountFileSummary(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public String getAccountNumber()
	{
		return super.getAccountNumber();
	}
}
