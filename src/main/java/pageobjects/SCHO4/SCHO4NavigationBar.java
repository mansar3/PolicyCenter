package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4NavigationBar extends NavigationBar<SCHO4NavigationBar> {

    public SCHO4NavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4SearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new SCHO4SearchAccounts(sh);
    }
}
