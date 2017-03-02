package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4PolicyReview extends PolicyReview<SCHO4PolicyReview> {

    public SCHO4PolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4RiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new SCHO4RiskAnalysis(sh,path);
    }
}
