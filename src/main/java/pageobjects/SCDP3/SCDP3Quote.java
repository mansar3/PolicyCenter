package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Quote extends Quote<SCDP3Quote>
{
		public SCDP3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	
	public SCDP3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new SCDP3RiskAnalysis(sh,path);
	}
	public SCDP3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new SCDP3PolicyReview(sh,path);
	}
		public SCDP3RenewalBound renew()
	{
		super.clickRenew();
		return new SCDP3RenewalBound(sh, path);
	}
	public SCDP3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new SCDP3RenewalBound(sh, path);
	}
	public boolean isUnderWritingApprovalNeeded()
	{
		return super.isUnderWritingApprovalNeeded();
	}

	public SCDP3Quote acceptyes()
	{
		return super.accept();
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

	public SCDP3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new SCDP3RatingOverrides(sh, path);
	}

	public class SCDP3RatingOverrides extends RatingOverrides<SCDP3RatingOverrides>
	{
		public SCDP3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public SCDP3Quote clickRerate()
		{
			super.rerate();
			return new SCDP3Quote(sh,path);
		}
		public SCDP3Quote clickCancel()
		{
			super.cancel();
			return new SCDP3Quote(sh, path);
		}
	}
}
