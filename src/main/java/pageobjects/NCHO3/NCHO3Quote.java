package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Quote extends Quote<NCHO3Quote>
{
	public NCHO3WestPanel westPanel;
		public NCHO3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new NCHO3WestPanel(sh,path);
	}

	public NCHO3RenewalBound getRenewalBoundObject()
	{
		return new NCHO3RenewalBound(sh, path);
	}

	public NCHO3Quote acceptyes()
	{
		return super.accept();
	}


	public NCHO3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new NCHO3RiskAnalysis(sh,path);
	}
	public NCHO3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new NCHO3PolicyReview(sh,path);
	}
	public NCHO3RenewalBound renew()
	{
		super.clickRenew();
		return new NCHO3RenewalBound(sh, path);
	}
	public void renewVoid()
	{
		super.clickRenew();
	}
	public NCHO3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new NCHO3RenewalBound(sh, path);
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

	public NCHO3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new NCHO3RatingOverrides(sh, path);
	}

	public class NCHO3RatingOverrides extends RatingOverrides<NCHO3RatingOverrides>
	{
		public NCHO3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public NCHO3Quote clickRerate()
		{
			super.rerate();
			return new NCHO3Quote(sh,path);
		}
		public NCHO3Quote clickCancel()
		{
			super.cancel();
			return new NCHO3Quote(sh, path);
		}
	}
}
