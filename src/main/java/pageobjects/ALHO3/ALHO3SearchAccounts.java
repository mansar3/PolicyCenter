package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

public class ALHO3SearchAccounts extends SearchAccounts<ALHO3SearchAccounts>
{
    public ALHO3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public ALHO3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public ALHO3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public ALHO3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new ALHO3AccountFileSummary(sh);
    }
}
