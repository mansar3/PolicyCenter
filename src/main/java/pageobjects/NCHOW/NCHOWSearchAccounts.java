package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWSearchAccounts extends SearchAccounts<NCHOWSearchAccounts> {
    public NCHOWSearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWSearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public NCHOWSearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public NCHOWSearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public NCHOWAccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new NCHOWAccountFileSummary(sh);
    }
}
