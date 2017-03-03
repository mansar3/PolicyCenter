package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Organizations extends Organizations<FLMH3Organizations> {

    public FLMH3Organizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3CreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new FLMH3CreateAccount(sh);
    }
}
