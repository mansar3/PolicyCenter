package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Quote extends Quote<FLHO3Quote>
{
	public FLHO3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3Quote acceptyes()
	{
		return super.accept();
	}

	public FLHO3Quote clickEditPolicyTransaction(){
		return super.clickEditPolicyTransaction();
	}

	public Summary clicktopPolicyNumber()
	{
		super.clickTopPolicyNumber();
		return new Summary(sh);
	}
	public FLHO3Quote clickPolicyChangeIssuePolicy()
	{
		return super.clickPolicyChangeIssuePolicy();
	}

	public FLHO3Quote clickPolicyChangePrint()
	{
		return  super.clickPolicyIssuePolicyPrint();
	}
	public FLHO3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new FLHO3RiskAnalysis(sh,path);
	}
	public FLHO3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new FLHO3PolicyReview(sh,path);
	}
	public FLHO3RenewalBound renew()
	{
		super.clickRenew();
		return new FLHO3RenewalBound(sh, path);
	}
	public FLHO3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new FLHO3RenewalBound(sh, path);
	}

	public boolean isUnderWritingApprovalNeeded()
	{
		return super.isUnderWritingApprovalNeeded();
	}
	
	public int getTotalPremium()
	{
		return super.getTotalPremium();
	}
	public String getAnnualizedTotalCost()
	{
		return super.getAnnualizedTotalCost();
	}

	public String getAnnualizedTotalCostIncludingWhenSafe()
	{
		return super.getAnnualizedTotalCostIncludingWhenSafe();
	}
	
	public FLHO3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new FLHO3RatingOverrides(sh, path);
	}

	public class FLHO3RatingOverrides extends RatingOverrides<FLHO3RatingOverrides>
	{
		public FLHO3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public FLHO3Quote clickRerate()
		{
			super.rerate();
			return new FLHO3Quote(sh,path);
		}
		public FLHO3Quote clickCancel()
		{
			super.cancel();
			return new FLHO3Quote(sh, path);
		}
	}
	
	
	
}
