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

	public  ALHO3Quote quote()
	{
		super.policyreviewpolicyChangeQuote();
				return new ALHO3Quote(sh, path);
	}

	public ALHO3PolicyReview checkPolicyReview()
	{
		 super.getPolicyReviewChange();
		 return new ALHO3PolicyReview(sh, path);
	}
}
