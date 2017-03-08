package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssuePolicyReview extends PolicyReview<ALHO3UWIssuePolicyReview> {

    public ALHO3UWIssuePolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueRiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new ALHO3UWIssueRiskAnalysis(sh,path);
    }
}
