package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Offerings;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueOfferings extends Offerings<ALHO3UWIssueOfferings> {


    public ALHO3UWIssueOfferings(CenterSeleniumHelper sh , Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueOfferings setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public ALHO3UWIssueOfferings setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public ALHO3UWIssuePolicyInfo next()
    {
        super.policyInfoNext();
        return new ALHO3UWIssuePolicyInfo(sh,path);
    }
}
