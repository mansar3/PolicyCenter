package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWCreateAccount extends CreateAccount<NCHOWCreateAccount> {

    public NCHOWCreateAccount(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public NCHOWAccountFileSummary clickUpdate()
    {
        super.update();
        return new NCHOWAccountFileSummary(sh);
    }
    public NCHOWSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCHOWSelectStandardizedAddress(sh);
    }
    public NCHOWOrganizations clickOrganizationSearch()
    {
        super.organizationSearch();
        return new NCHOWOrganizations(sh);
    }
}
