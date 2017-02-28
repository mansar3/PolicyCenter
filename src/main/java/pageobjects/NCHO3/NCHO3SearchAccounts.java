package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

public class NCHO3SearchAccounts extends SearchAccounts<NCHO3SearchAccounts>
{
    public NCHO3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHO3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public NCHO3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public NCHO3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public NCHO3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new NCHO3AccountFileSummary(sh);
    }
}
