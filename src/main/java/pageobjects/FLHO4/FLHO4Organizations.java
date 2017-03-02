package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Organizations extends Organizations<FLHO4Organizations> {

    public FLHO4Organizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4CreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new FLHO4CreateAccount(sh);
    }
}
