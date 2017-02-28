package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyReview;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3PolicyReview extends PolicyReview<FLDP3PolicyReview>
{
	public FLDP3PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3RiskAnalysis back()
	{
		super.riskAnalysisBack();
		return new FLDP3RiskAnalysis(sh,path);
	}
}
