package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/15/2017.
 */
public class SCDP3PreQuoteIssues extends PreQuoteIssues<SCDP3PreQuoteIssues> {

    public SCDP3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public SCDP3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new SCDP3RiskAnalysis(sh, path);
    }
}
