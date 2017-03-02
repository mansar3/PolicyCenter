package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Quote extends Quote<FLHO4Quote> {

    public FLHO4Quote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4RiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new FLHO4RiskAnalysis(sh,path);
    }
    public FLHO4PolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new FLHO4PolicyReview(sh,path);
    }
    public FLHO4RenewalBound renew()
    {
        super.clickRenew();
        return new FLHO4RenewalBound(sh, path);
    }
    public FLHO4RenewalBound issueNow()
    {
        super.clickIssueNow();
        return new FLHO4RenewalBound(sh, path);
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

    public FLHO4RatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new FLHO4RatingOverrides(sh, path);
    }

    public class FLHO4RatingOverrides extends RatingOverrides<FLHO4RatingOverrides>
    {
        public FLHO4RatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public FLHO4Quote clickRerate()
        {
            super.rerate();
            return new FLHO4Quote(sh,path);
        }
        public FLHO4Quote clickCancel()
        {
            super.cancel();
            return new FLHO4Quote(sh, path);
        }
    }
}
