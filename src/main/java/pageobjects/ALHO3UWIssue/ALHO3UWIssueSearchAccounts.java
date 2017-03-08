package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueSearchAccounts extends SearchAccounts<ALHO3UWIssueSearchAccounts> {

    public ALHO3UWIssueSearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueSearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public ALHO3UWIssueSearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public ALHO3UWIssueSearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public ALHO3UWIssueAccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new ALHO3UWIssueAccountFileSummary(sh);
    }
}
