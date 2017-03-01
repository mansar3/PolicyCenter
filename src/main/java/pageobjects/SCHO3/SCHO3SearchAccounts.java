package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.ALHO3.ALHO3AccountFileSummary;
import pageobjects.ALHO3.ALHO3SearchAccounts;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 2/28/2017.
 */
public class SCHO3SearchAccounts extends SearchAccounts<SCHO3SearchAccounts>
{
    public SCHO3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public SCHO3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public SCHO3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public SCHO3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new SCHO3AccountFileSummary(sh);
    }

}
