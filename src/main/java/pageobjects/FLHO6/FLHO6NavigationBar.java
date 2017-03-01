package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6NavigationBar extends NavigationBar<FLHO6NavigationBar>
{
	public FLHO6NavigationBar(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6SearchAccounts clickSearchAccount() {
		super.clickSearchAccountNavBar();
		return new  FLHO6SearchAccounts(sh);
	}
}
