package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Organizations extends Organizations<NCHO3Organizations>
{
	public NCHO3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new NCHO3CreateAccount(sh);
	}
}
