package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

public class ALHO3SearchAccounts extends SearchAccounts<ALHO3SearchAccounts>
{
    public ALHO3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3SearchAccounts setFirstname(String firstname)
    {
        return super.setFirstname(firstname);
    }

    public ALHO3SearchAccounts setLastname(String lastname)
    {
        return super.setLastname(lastname);
    }

    public ALHO3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public ALHO3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.clickAccountNumber();
        return new ALHO3AccountFileSummary(sh);
    }
}
