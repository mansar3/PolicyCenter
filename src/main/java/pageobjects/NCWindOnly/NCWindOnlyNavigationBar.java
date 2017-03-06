package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyNavigationBar extends NavigationBar<NCWindOnlyNavigationBar> {

    public NCWindOnlyNavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlySearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new NCWindOnlySearchAccounts(sh);
    }
}
