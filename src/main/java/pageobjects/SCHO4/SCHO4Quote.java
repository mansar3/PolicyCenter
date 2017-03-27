package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Quote extends Quote<SCHO4Quote> {

    public SCHO4Quote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4RiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new SCHO4RiskAnalysis(sh,path);
    }
    public SCHO4PolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new SCHO4PolicyReview(sh,path);
    }
    public SCHO4RenewalBound renew()
    {
        super.clickRenew();
        return new SCHO4RenewalBound(sh, path);
    }
    public SCHO4RenewalBound issueNow()
    {
        super.clickIssueNow();
        return new SCHO4RenewalBound(sh, path);
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
    public SCHO4Quote acceptyes()
    {
        return super.accept();
    }
    public String getAnnualizedTotalCostIncludingWhenSafe()
    {
        return super.getAnnualizedTotalCostIncludingWhenSafe();
    }

    public SCHO4RatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new SCHO4RatingOverrides(sh, path);
    }

    public class SCHO4RatingOverrides extends RatingOverrides<SCHO4RatingOverrides>
    {
        public SCHO4RatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public SCHO4Quote clickRerate()
        {
            super.rerate();
            return new SCHO4Quote(sh,path);
        }
        public SCHO4Quote clickCancel()
        {
            super.cancel();
            return new SCHO4Quote(sh, path);
        }
    }
}
