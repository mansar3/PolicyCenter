package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueNewAdditionalInterest extends NewAdditionalInterest<ALHO3UWIssueNewAdditionalInterest> {

    public ALHO3UWIssueNewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new ALHO3UWIssueSelectStandardizedAddress(sh,path);
    }
    public ALHO3UWIssueDwelling.ALHO3UWIssueAdditionalInterests clickCancel()
    {
        super.cancel();
        return new ALHO3UWIssueDwelling(sh,path).new ALHO3UWIssueAdditionalInterests(sh,path);
    }
    public ALHO3UWIssueDwelling.ALHO3UWIssueAdditionalInterests clickOk()
    {
        super.ok();
        return new ALHO3UWIssueDwelling(sh,path).new ALHO3UWIssueAdditionalInterests(sh,path);
    }
}
