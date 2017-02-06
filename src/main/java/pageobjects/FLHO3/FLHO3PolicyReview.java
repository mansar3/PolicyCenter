package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3PolicyReview extends PolicyReview<FLHO3PolicyReview>
{
	public FLHO3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new FLHO3RiskAnalysis(sh,path);
	}
}
