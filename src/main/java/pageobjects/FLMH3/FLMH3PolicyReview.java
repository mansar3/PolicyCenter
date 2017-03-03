package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3PolicyReview extends PolicyReview<FLMH3PolicyReview> {
    public FLMH3PolicyReview(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3RiskAnalysis back()
    {
        super.riskAnalysisBack();
        return new FLMH3RiskAnalysis(sh,path);
    }
}
