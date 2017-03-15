package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/15/2017.
 */
public class NCHO3PreQuoteIssues extends PreQuoteIssues<NCHO3PreQuoteIssues> {

    public NCHO3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public NCHO3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new NCHO3RiskAnalysis(sh, path);
    }
}
