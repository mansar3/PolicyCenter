package pageobjects.FLHO6;


import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAccounts;

/**
 * Created by ssai on 3/1/2017.
 */
public class FLHO6SearchAccounts  extends SearchAccounts<FLHO6SearchAccounts> {

    public FLHO6SearchAccounts(CenterSeleniumHelper sh) {super(sh);}

    public FLHO6SearchAccounts setFirstName(String firstname)
    {
        return super.setFirstName(firstname);
    }

    public FLHO6SearchAccounts setLastName(String lastname)
    {
        return super.setLastName(lastname);
    }

    public FLHO6SearchAccounts clickSearchButton()
    {
        return super.clickSearchButton();
    }

    public FLHO6AccountFileSummary clickAccountNumberSearchAccount()
    {
        super.selectFirstAccountNumber();
        return new FLHO6AccountFileSummary(sh);
    }

}
