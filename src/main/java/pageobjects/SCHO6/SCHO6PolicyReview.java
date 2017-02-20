package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6PolicyReview extends PolicyReview<SCHO6PolicyReview>
{
	public SCHO6PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new SCHO6RiskAnalysis(sh,path);
	}
}
