package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3NavigationBar extends NavigationBar<FLDP3NavigationBar>
{
	public FLDP3NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public FLDP3SearchAccounts clickSearchAccount()
	{
		super.clickSearchAccountNavBar();
		return new FLDP3SearchAccounts(sh);
	}
}
