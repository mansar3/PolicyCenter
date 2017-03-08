package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueOrganizations extends Organizations<ALHO3UWIssueOrganizations> {

    public ALHO3UWIssueOrganizations(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueCreateAccount clickSelectOrganizationButton()
    {
        super.selectOrganizationButton();
        return new ALHO3UWIssueCreateAccount(sh);
    }
}
