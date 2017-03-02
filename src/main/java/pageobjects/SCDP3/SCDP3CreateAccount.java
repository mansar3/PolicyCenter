package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3CreateAccount extends CreateAccount<SCDP3CreateAccount>
{
	public SCDP3CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCDP3AccountFileSummary clickUpdate()
	{
		super.update();
		return new SCDP3AccountFileSummary(sh);
	}
	public SCDP3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCDP3SelectStandardizedAddress(sh);
	}
	public SCDP3Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new SCDP3Organizations(sh);
	}
}
