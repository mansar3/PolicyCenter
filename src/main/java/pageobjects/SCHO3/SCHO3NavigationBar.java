package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3NavigationBar extends NavigationBar<SCHO3NavigationBar>
{
	public SCHO3NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3SearchAccounts clickSearchAccount()
	{
		super.clickSearchAccountNavBar();
		return new SCHO3SearchAccounts(sh);
	}
}
