package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3Organizations extends Organizations<ALHO3Organizations>
{
	public ALHO3Organizations(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3CreateAccount clickSelectOrganizationButton()
	{
		super.selectOrganizationButton();
		return new ALHO3CreateAccount(sh);
	}
}
