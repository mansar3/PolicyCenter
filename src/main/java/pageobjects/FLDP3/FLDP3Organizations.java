package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Organizations extends Organizations<FLDP3Organizations>
{
	public FLDP3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLDP3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new FLDP3CreateAccount(sh);
	}
}
