package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6PolicyReview extends PolicyReview<FLHO6PolicyReview>
{
	public FLHO6PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new FLHO6RiskAnalysis(sh,path);
	}
}
