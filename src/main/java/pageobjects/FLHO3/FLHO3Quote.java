package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
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

	
	
	
}
