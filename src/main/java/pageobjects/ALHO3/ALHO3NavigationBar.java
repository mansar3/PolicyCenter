package pageobjects.ALHO3;


import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

public class ALHO3NavigationBar extends NavigationBar<ALHO3NavigationBar>
{

    public ALHO3NavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3SearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new ALHO3SearchAccounts(sh);
    }
}
