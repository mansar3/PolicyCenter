package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/1/2017.
 */
public class SCHO6SearchAccounts extends SearchAccounts<SCHO6SearchAccounts> {
    public SCHO6SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO6SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public SCHO6SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public SCHO6SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public SCHO6AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new SCHO6AccountFileSummary(sh);
    }
}
