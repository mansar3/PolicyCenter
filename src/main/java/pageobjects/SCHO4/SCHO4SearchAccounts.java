package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4SearchAccounts extends SearchAccounts<SCHO4SearchAccounts> {

    public SCHO4SearchAccounts(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public SCHO4SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public SCHO4SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public SCHO4AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new SCHO4AccountFileSummary(sh);
    }
}
