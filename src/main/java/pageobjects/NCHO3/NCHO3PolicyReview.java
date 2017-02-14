package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3PolicyReview extends PolicyReview<NCHO3PolicyReview>
{
	public NCHO3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new NCHO3RiskAnalysis(sh,path);
	}
}
