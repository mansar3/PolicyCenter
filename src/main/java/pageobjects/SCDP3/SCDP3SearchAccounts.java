package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCDP3SearchAccounts extends SearchAccounts<SCDP3SearchAccounts> {

    public SCDP3SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCDP3SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public SCDP3SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public SCDP3SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public SCDP3AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new SCDP3AccountFileSummary(sh);
    }
}
