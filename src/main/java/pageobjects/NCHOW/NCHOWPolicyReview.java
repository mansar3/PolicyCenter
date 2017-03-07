package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWPolicyReview extends PolicyReview<NCHOWPolicyReview> {
    public NCHOWPolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWRiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new NCHOWRiskAnalysis(sh,path);
    }
}
