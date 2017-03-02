package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Organizations extends Organizations<SCHO4Organizations> {

    public SCHO4Organizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4CreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new SCHO4CreateAccount(sh);
    }
}
