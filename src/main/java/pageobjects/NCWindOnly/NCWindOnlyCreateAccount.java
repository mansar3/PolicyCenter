package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyCreateAccount extends CreateAccount<NCWindOnlyCreateAccount> {

    public NCWindOnlyCreateAccount(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public NCWindOnlyAccountFileSummary clickUpdate()
    {
        super.update();
        return new NCWindOnlyAccountFileSummary(sh);
    }
    public NCWindOnlySelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCWindOnlySelectStandardizedAddress(sh);
    }
    public NCWindOnlyOrganizations clickOrganizationSearch()
    {
        super.organizationSearch();
        return new NCWindOnlyOrganizations(sh);
    }
}
