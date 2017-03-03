package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3NavigationBar extends NavigationBar<FLMH3NavigationBar> {

    public FLMH3NavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3SearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new FLMH3SearchAccounts(sh);
    }
}
