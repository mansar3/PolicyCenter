package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Quote;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWQuote extends Quote<NCHOWQuote> {
    public NCHOWQuote(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWQuote clickIssuePolicy()
    {
        return super.clickIssuePolicy();
    }

    public NCHOWQuote acceptyes()
    {
        return super.accept();
    }

    public NCHOWQuote clickEditPolicyTransaction(){
        return super.clickEditPolicyTransaction();
    }
    public NCHOWRiskAnalysis backToRiskAnalysis()
    {
        super.backRiskAnalysis();
        return new NCHOWRiskAnalysis(sh,path);
    }
    public String quoteErrorMessage(){return super.quoteErrorMessage();}
    public String quoteErrorMessage2(){return super.quoteErrorMessage2();}
    public String quoteErrorMessage3(){return super.quoteErrorMessage3();}
    public String quoteErrorMessage4(){return super.quoteErrorMessage4();}


    public NCHOWPolicyReview backToPoliycReview()
    {
        super.backPolicyReview();
        return new NCHOWPolicyReview(sh,path);
    }
    public NCHOWRenewalBound renew()
    {
        super.clickRenew();
        return new NCHOWRenewalBound(sh, path);
    }
    public NCHOWRenewalBound issueNow()
    {
        super.clickIssueNow();
        return new NCHOWRenewalBound(sh, path);
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

    public NCHOWRatingOverrides clickOverrideRating()
    {
        super.overrideRating();
        return new NCHOWRatingOverrides(sh, path);
    }

    public class NCHOWRatingOverrides extends RatingOverrides<NCHOWRatingOverrides>
    {
        public NCHOWRatingOverrides(CenterSeleniumHelper sh, Path path)
        {
            super(sh,path);
        }
        public NCHOWQuote clickRerate()
        {
            super.rerate();
            return new NCHOWQuote(sh,path);
        }
        public NCHOWQuote clickCancel()
        {
            super.cancel();
            return new NCHOWQuote(sh, path);
        }
    }
}
