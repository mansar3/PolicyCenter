package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4SearchAccounts extends SearchAccounts<FLHO4SearchAccounts> {

    public FLHO4SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public FLHO4SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public FLHO4SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public FLHO4AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new FLHO4AccountFileSummary(sh);
    }
}
