package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Organizations extends Organizations<FLHO3Organizations>
{
	public FLHO3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new FLHO3CreateAccount(sh);
	}
}
