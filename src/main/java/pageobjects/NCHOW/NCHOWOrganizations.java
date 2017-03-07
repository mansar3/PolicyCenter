package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWOrganizations extends Organizations<NCHOWOrganizations> {
    public NCHOWOrganizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWCreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new NCHOWCreateAccount(sh);
    }
}
