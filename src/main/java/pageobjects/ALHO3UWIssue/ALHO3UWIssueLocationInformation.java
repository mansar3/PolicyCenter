package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueLocationInformation extends LocationInformation<ALHO3UWIssueLocationInformation> {

    public ALHO3UWIssueLocationInformation(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new ALHO3UWIssueSelectStandardizedAddress(sh,path);
    }

    public ALHO3UWIssueLocationInformation setCounty(String county)
    {
        super.setCounty(county);
        return this;
    }

    public ALHO3UWIssueDwelling clickOk()
    {
        super.ok();
        return new ALHO3UWIssueDwelling(sh,path);
    }
    public ALHO3UWIssueDwelling clickCancel()
    {
        super.cancel();
        return new ALHO3UWIssueDwelling(sh,path);
    }
}
