package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4PolicyReview extends PolicyReview<FLHO4PolicyReview> {

    public FLHO4PolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4RiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new FLHO4RiskAnalysis(sh,path);
    }
}
