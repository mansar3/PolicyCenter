package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/6/17.
 */
public class ALHO3PolicyReview extends PolicyReview<ALHO3PolicyReview>
{
	public ALHO3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new ALHO3RiskAnalysis(sh,path);
	}
}
