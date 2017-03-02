package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4NavigationBar extends NavigationBar<FLHO4NavigationBar> {
    public FLHO4NavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4SearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new FLHO4SearchAccounts(sh);
    }
    
}
