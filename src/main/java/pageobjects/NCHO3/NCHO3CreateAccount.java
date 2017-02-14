package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3CreateAccount extends CreateAccount<NCHO3CreateAccount>
{
	public NCHO3CreateAccount(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public NCHO3AccountFileSummary clickUpdate()
	{
		super.update();
		return new NCHO3AccountFileSummary(sh);
	}
	public NCHO3SelectStandardizedAddress clickVerifyAddress()
	{
		super.verifyAddress();
		return new NCHO3SelectStandardizedAddress(sh);
	}
	public NCHO3Organizations clickOrganizationSearch()
	{
		super.organizationSearch();
		return new NCHO3Organizations(sh);
	}
}
