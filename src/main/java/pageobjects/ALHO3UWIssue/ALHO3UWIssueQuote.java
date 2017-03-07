package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueQuote extends Quote<ALHO3UWIssueQuote> {

    public ALHO3UWIssueQuote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueRiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new ALHO3UWIssueRiskAnalysis(sh,path);
    }
    public ALHO3UWIssuePolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new ALHO3UWIssuePolicyReview(sh,path);
    }
    public ALHO3UWIssueRenewalBound renew()
    {
        super.clickRenew();
        return new ALHO3UWIssueRenewalBound(sh, path);
    }
    public ALHO3UWIssueRenewalBound issueNow()
    {
        super.clickIssueNow();
        return new ALHO3UWIssueRenewalBound(sh, path);
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

    public ALHO3UWIssueRatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new ALHO3UWIssueRatingOverrides(sh, path);
    }

    public class ALHO3UWIssueRatingOverrides extends RatingOverrides<ALHO3UWIssueRatingOverrides>
    {
        public ALHO3UWIssueRatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public ALHO3UWIssueQuote clickRerate()
        {
            super.rerate();
            return new ALHO3UWIssueQuote(sh,path);
        }
        public ALHO3UWIssueQuote clickCancel()
        {
            super.cancel();
            return new ALHO3UWIssueQuote(sh, path);
        }
    }
}
