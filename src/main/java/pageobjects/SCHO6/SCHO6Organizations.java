package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Organizations extends Organizations<SCHO6Organizations>
{
	public SCHO6Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO6CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new SCHO6CreateAccount(sh);
	}
}
