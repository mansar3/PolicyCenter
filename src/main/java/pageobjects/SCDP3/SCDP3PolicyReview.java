package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3PolicyReview extends PolicyReview<SCDP3PolicyReview>
{
	public SCDP3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new SCDP3RiskAnalysis(sh,path);
	}
}
