package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3NavigationBar extends NavigationBar<SCDP3NavigationBar>
{
	public SCDP3NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCDP3SearchAccounts clickSearchAccount()
	{
		super.clickSearchAccountNavBar();
		return new SCDP3SearchAccounts(sh);
	}
}
