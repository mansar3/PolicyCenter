package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Quote extends Quote<FLDP3Quote>
{
	public FLDP3WestPanel westPanel;
	public FLDP3Quote(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new FLDP3WestPanel(sh,path);
	}
	
	public FLDP3RiskAnalysis backToRiskAnalysis()
	{
		super.backRiskAnalysis();
		return new FLDP3RiskAnalysis(sh,path);
	}
	public FLDP3PolicyReview backToPoliycReview()
	{
		super.backPolicyReview();
		return new FLDP3PolicyReview(sh,path);
	}
	public FLDP3RenewalBound renew()
	{
		super.clickRenew();
		return new FLDP3RenewalBound(sh, path);
	}
	public FLDP3RenewalBound issueNow()
	{
		super.clickIssueNow();
		return new FLDP3RenewalBound(sh, path);
	}

	public boolean isUnderWritingApprovalNeeded()
	{
		return super.isUnderWritingApprovalNeeded();
	}

	public FLDP3Quote clickPolicyChangePrint()
	{
		return  super.clickPolicyIssuePolicyPrint();
	}
	public FLDP3Quote acceptyes()
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
	
	public FLDP3RatingOverrides clickOverrideRating()
	{
		super.overrideRating();
		return new FLDP3RatingOverrides(sh, path);
	}

	public class FLDP3RatingOverrides extends RatingOverrides<FLDP3RatingOverrides>
	{
		public FLDP3RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			super(sh,path);
		}
		public FLDP3Quote clickRerate()
		{
			super.rerate();
			return new FLDP3Quote(sh,path);
		}
		public FLDP3Quote clickCancel()
		{
			super.cancel();
			return new FLDP3Quote(sh, path);
		}
	}
	
	
	
}
