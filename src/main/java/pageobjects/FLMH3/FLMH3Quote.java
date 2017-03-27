package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Quote extends Quote<FLMH3Quote> {

    public FLMH3Quote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3Quote acceptyes()
    {
        return super.accept();
    }

    public FLMH3RiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new FLMH3RiskAnalysis(sh,path);
    }
    public FLMH3PolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new FLMH3PolicyReview(sh,path);
    }
    public FLMH3RenewalBound renew()
    {
        super.clickRenew();
        return new FLMH3RenewalBound(sh, path);
    }
    public FLMH3RenewalBound issueNow()
    {
        super.clickIssueNow();
        return new FLMH3RenewalBound(sh, path);
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

    public FLMH3RatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new FLMH3RatingOverrides(sh, path);
    }

    public class FLMH3RatingOverrides extends RatingOverrides<FLMH3RatingOverrides>
    {
        public FLMH3RatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public FLMH3Quote clickRerate()
        {
            super.rerate();
            return new FLMH3Quote(sh,path);
        }
        public FLMH3Quote clickCancel()
        {
            super.cancel();
            return new FLMH3Quote(sh, path);
        }
    }
}
