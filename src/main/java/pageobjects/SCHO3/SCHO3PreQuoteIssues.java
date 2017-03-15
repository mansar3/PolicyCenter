package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/15/2017.
 */
public class SCHO3PreQuoteIssues extends PreQuoteIssues<SCHO3PreQuoteIssues> {

    public SCHO3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public SCHO3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new SCHO3RiskAnalysis(sh, path);
    }
}
