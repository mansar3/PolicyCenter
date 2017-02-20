package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3PolicyReview extends PolicyReview<SCHO3PolicyReview>
{
	public SCHO3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new SCHO3RiskAnalysis(sh,path);
	}
}
