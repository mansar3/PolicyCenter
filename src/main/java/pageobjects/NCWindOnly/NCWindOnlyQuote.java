package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyQuote extends Quote<NCWindOnlyQuote> {
    public NCWindOnlyQuote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyQuote clickissuePolicy()
    {
        return super.clickissuePolicy();
    }

    public NCWindOnlyQuote acceptyes()
    {
        return super.accept();
    }

    public NCWindOnlyQuote clickEditPolicyTransaction(){
        return super.clickEditPolicyTransaction();
    }
    public NCWindOnlyRiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new NCWindOnlyRiskAnalysis(sh,path);
    }


    public NCWindOnlyPolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new NCWindOnlyPolicyReview(sh,path);
    }
    public NCWindOnlyRenewalBound renew()
    {
        super.clickRenew();
        return new NCWindOnlyRenewalBound(sh, path);
    }
    public NCWindOnlyRenewalBound issueNow()
    {
        super.clickIssueNow();
        return new NCWindOnlyRenewalBound(sh, path);
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

    public NCWindOnlyRatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new NCWindOnlyRatingOverrides(sh, path);
    }

    public class NCWindOnlyRatingOverrides extends RatingOverrides<NCWindOnlyRatingOverrides>
    {
        public NCWindOnlyRatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public NCWindOnlyQuote clickRerate()
        {
            super.rerate();
            return new NCWindOnlyQuote(sh,path);
        }
        public NCWindOnlyQuote clickCancel()
        {
            super.cancel();
            return new NCWindOnlyQuote(sh, path);
        }
    }
}
