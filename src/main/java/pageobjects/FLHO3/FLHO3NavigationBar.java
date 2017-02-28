package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3NavigationBar extends NavigationBar<FLHO3NavigationBar>
{
	public FLHO3NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3SearchAccounts clickSearchAccount()
	{
		super.clickSearchAccountNavBar();
		return new FLHO3SearchAccounts(sh);
	}
}
