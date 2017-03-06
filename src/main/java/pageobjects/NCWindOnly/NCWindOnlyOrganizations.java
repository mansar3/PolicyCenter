package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyOrganizations extends Organizations<NCWindOnlyOrganizations> {
    public NCWindOnlyOrganizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlyCreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new NCWindOnlyCreateAccount(sh);
    }
}
