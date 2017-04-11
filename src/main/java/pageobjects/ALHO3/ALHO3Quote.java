package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/6/17.
 */
public class ALHO3Quote extends Quote<ALHO3Quote>
{
	public ALHO3WestPanel westPanel;
	public ALHO3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new ALHO3WestPanel(sh,path);
	}
	
	public ALHO3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new ALHO3RiskAnalysis(sh,path);
	}
	public ALHO3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new ALHO3PolicyReview(sh,path);
	}
		public ALHO3RenewalBound renew()
	{
		super.clickRenew();
		return new ALHO3RenewalBound(sh, path);
	}
	public ALHO3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new ALHO3RenewalBound(sh, path);
	}

	public ALHO3Quote clickPolicyChangeIssuePolicy()
	{
		return super.clickPolicyChangeIssuePolicy();
	}

	public ALHO3Quote clickPolicyChangePrint()
	{
	  return  super.clickPolicyIssuePolicyPrint();
	}
	public ALHO3Quote acceptyes()
	{
		return super.accept();
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

	public ALHO3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new ALHO3RatingOverrides(sh, path);
	}

	public class ALHO3RatingOverrides extends RatingOverrides<ALHO3RatingOverrides>
	{
		public ALHO3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public ALHO3Quote clickRerate()
		{
			super.rerate();
			return new ALHO3Quote(sh,path);
		}
		public ALHO3Quote clickCancel()
		{
			super.cancel();
			return new ALHO3Quote(sh, path);
		}
	}
}
