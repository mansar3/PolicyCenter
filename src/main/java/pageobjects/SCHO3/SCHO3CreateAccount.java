package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3CreateAccount extends CreateAccount<SCHO3CreateAccount>
{
	public SCHO3CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCHO3AccountFileSummary clickUpdate()
	{
		super.update();
		return new SCHO3AccountFileSummary(sh);
	}
	public SCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new SCHO3SelectStandardizedAddress(sh);
	}
	public SCHO3Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new SCHO3Organizations(sh);
	}
}
