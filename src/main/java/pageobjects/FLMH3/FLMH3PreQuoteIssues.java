package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/14/2017.
 */
public class FLMH3PreQuoteIssues extends PreQuoteIssues<FLMH3PreQuoteIssues> {

    public FLMH3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public FLMH3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new FLMH3RiskAnalysis(sh, path);
    }
}
