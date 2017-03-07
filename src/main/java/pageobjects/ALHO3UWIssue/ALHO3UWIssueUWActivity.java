package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueUWActivity extends UWActivity<ALHO3UWIssueUWActivity> {


    public ALHO3UWIssueUWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public String getAssignTo( ){ return super.getAssignTo();}

    public ALHO3UWIssueRiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new ALHO3UWIssueRiskAnalysis(sh,path);
    }
    public ALHO3UWIssueUWActivity clickCancel()
    {
        super.clickCancel();
        return new ALHO3UWIssueUWActivity(sh,path);
    }
}
