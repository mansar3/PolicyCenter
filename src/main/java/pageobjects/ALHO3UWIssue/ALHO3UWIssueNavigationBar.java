package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NavigationBar;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueNavigationBar extends NavigationBar<ALHO3UWIssueNavigationBar> {

    public ALHO3UWIssueNavigationBar(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueSearchAccounts clickSearchAccount()
    {
        super.clickSearchAccountNavBar();
        return new ALHO3UWIssueSearchAccounts(sh);
    }
}
