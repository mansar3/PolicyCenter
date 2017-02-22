package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

public class FLHO3SearchAccounts extends SearchAccounts<FLHO3SearchAccounts>
{
    public FLHO3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public FLHO3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public FLHO3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public FLHO3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new FLHO3AccountFileSummary(sh);
    }
}
