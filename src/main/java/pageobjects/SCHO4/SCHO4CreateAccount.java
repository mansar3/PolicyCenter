package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CreateAccount;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4CreateAccount extends CreateAccount<SCHO4CreateAccount> {

    public SCHO4CreateAccount(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public SCHO4AccountFileSummary clickUpdate()
    {
        super.update();
        return new SCHO4AccountFileSummary(sh);
    }
    public SCHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new SCHO4SelectStandardizedAddress(sh);
    }
    public SCHO4Organizations clickOrganizationSearch()
    {
        super.organizationSearch();
        return new SCHO4Organizations(sh);
    }
}
