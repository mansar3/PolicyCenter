package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Quote extends Quote<SCHO3Quote>
{
		public SCHO3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	
	public SCHO3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new SCHO3RiskAnalysis(sh,path);
	}
	public SCHO3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new SCHO3PolicyReview(sh,path);
	}
		public SCHO3RenewalBound renew()
	{
		super.clickRenew();
		return new SCHO3RenewalBound(sh, path);
	}
	public SCHO3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new SCHO3RenewalBound(sh, path);
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

	public SCHO3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new SCHO3RatingOverrides(sh, path);
	}

	public class SCHO3RatingOverrides extends RatingOverrides<SCHO3RatingOverrides>
	{
		public SCHO3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public SCHO3Quote clickRerate()
		{
			super.rerate();
			return new SCHO3Quote(sh,path);
		}
		public SCHO3Quote clickCancel()
		{
			super.cancel();
			return new SCHO3Quote(sh, path);
		}
	}
}
