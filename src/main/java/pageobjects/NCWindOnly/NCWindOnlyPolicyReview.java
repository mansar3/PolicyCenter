package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyPolicyReview extends PolicyReview<NCWindOnlyPolicyReview> {
    public NCWindOnlyPolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyRiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new NCWindOnlyRiskAnalysis(sh,path);
    }
}
