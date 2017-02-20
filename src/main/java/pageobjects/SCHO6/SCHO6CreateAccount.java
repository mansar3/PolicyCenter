package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6CreateAccount extends CreateAccount<SCHO6CreateAccount>
{
	public SCHO6CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCHO6AccountFileSummary clickUpdate()
	{
		super.update();
		return new SCHO6AccountFileSummary(sh);
	}
	public SCHO6SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO6SelectStandardizedAddress(sh);
	}
	public SCHO6Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new SCHO6Organizations(sh);
	}
}
