package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueNewAdditionalNamedInsured extends NewAdditionalNameInsured<ALHO3UWIssueNewAdditionalNamedInsured> {

    public ALHO3UWIssueNewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssuePolicyInfo clickOk()
    {
        super.ok();
        return new ALHO3UWIssuePolicyInfo(sh,path);
    }
    public ALHO3UWIssuePolicyInfo clickCancel()
    {
        super.cancel();
        return new ALHO3UWIssuePolicyInfo(sh,path);
    }
    public ALHO3UWIssueSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new ALHO3UWIssueSelectStandardizedAddress(sh,path);
    }
}
