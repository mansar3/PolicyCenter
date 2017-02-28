package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3NavigationBar extends NavigationBar<NCHO3NavigationBar>
{
	public NCHO3NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3SearchAccounts clickSearchAccount()
	{
		super.clickSearchAccountNavBar();
		return new NCHO3SearchAccounts(sh);
	}
}
