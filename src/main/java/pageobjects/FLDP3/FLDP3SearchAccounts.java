package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

public class FLDP3SearchAccounts extends SearchAccounts<FLDP3SearchAccounts>
{
    public FLDP3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLDP3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public FLDP3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public FLDP3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public FLDP3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new FLDP3AccountFileSummary(sh);
    }
}
