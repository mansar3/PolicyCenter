package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Organizations extends Organizations<FLHO6Organizations>
{
	public FLHO6Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new FLHO6CreateAccount(sh);
	}
}
