package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Organizations extends Organizations<SCDP3Organizations>
{
	public SCDP3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCDP3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new SCDP3CreateAccount(sh);
	}
}
