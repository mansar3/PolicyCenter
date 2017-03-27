package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Quote extends Quote<SCHO6Quote>
{
		public SCHO6Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	
	public SCHO6RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new SCHO6RiskAnalysis(sh,path);
	}
	public SCHO6Quote acceptyes()
	{
		return super.accept();
	}

	public SCHO6PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new SCHO6PolicyReview(sh,path);
	}
		public SCHO6RenewalBound renew()
	{
		super.clickRenew();
		return new SCHO6RenewalBound(sh, path);
	}
	public SCHO6RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new SCHO6RenewalBound(sh, path);
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

	public SCHO6RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new SCHO6RatingOverrides(sh, path);
	}

	public class SCHO6RatingOverrides extends RatingOverrides<SCHO6RatingOverrides>
	{
		public SCHO6RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public SCHO6Quote clickRerate()
		{
			super.rerate();
			return new SCHO6Quote(sh,path);
		}
		public SCHO6Quote clickCancel()
		{
			super.cancel();
			return new SCHO6Quote(sh, path);
		}
	}
}
