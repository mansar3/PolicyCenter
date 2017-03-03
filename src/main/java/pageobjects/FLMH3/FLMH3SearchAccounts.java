package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3SearchAccounts extends SearchAccounts<FLMH3SearchAccounts> {

    public FLMH3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public FLMH3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public FLMH3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public FLMH3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new FLMH3AccountFileSummary(sh);
    }
}
