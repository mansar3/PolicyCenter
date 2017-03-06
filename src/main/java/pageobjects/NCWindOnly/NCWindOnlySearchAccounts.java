package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlySearchAccounts extends SearchAccounts<NCWindOnlySearchAccounts> {
    public NCWindOnlySearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlySearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public NCWindOnlySearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public NCWindOnlySearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public NCWindOnlyAccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new NCWindOnlyAccountFileSummary(sh);
    }
}
