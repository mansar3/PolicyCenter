package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Organizations extends Organizations<SCHO3Organizations>
{
	public SCHO3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new SCHO3CreateAccount(sh);
	}
}
