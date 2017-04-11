package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Quote extends Quote<FLHO6Quote>
{
	public FLHO6WestPanel westPanel;
	public FLHO6Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new FLHO6WestPanel(sh,path);
	}
	public FLHO6Quote acceptyes()
	{
		return super.accept();
	}

	public FLHO6RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new FLHO6RiskAnalysis(sh,path);
	}
	public FLHO6PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new FLHO6PolicyReview(sh,path);
	}
	public FLHO6RenewalBound renew()
	{
		super.clickRenew();
		return new FLHO6RenewalBound(sh, path);
	}
	public FLHO6RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new FLHO6RenewalBound(sh, path);
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
	
	public FLHO6RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new FLHO6RatingOverrides(sh, path);
	}

	public class FLHO6RatingOverrides extends RatingOverrides<FLHO6RatingOverrides>
	{
		public FLHO6RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public FLHO6Quote clickRerate()
		{
			super.rerate();
			return new FLHO6Quote(sh,path);
		}
		public FLHO6Quote clickCancel()
		{
			super.cancel();
			return new FLHO6Quote(sh, path);
		}
	}
	
	
	
}
