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

	public  ALHO3Quote quoteRenewal()
	{
		super.policyreviewRenewalQuote();
		return new ALHO3Quote(sh, path);
	}

	public String checkPolicyReview()
	{
		return  super.getPolicyReviewChange();

	}
	public ALHO3PolicyReview clickEditPolicyTransactionRenewal(){
		return super.editPolicyTransactionrenewal();
	}

	public ALHO3PolicyReview acceptYes()
	{
		return super.accept();
	}

	public ALHO3ChangeConflits clickChangeConflits()
	{
		super.clickChangeConflicts();
		return new ALHO3ChangeConflits(sh,path);
	}

	public class ALHO3ChangeConflits extends ChangeConflits<ALHO3ChangeConflits>
	{

		public ALHO3ChangeConflits(CenterSeleniumHelper sh, Path path) { super(sh, path);}


	}
}
