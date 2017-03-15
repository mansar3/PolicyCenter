package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/15/2017.
 */
public class SCHO4PreQuoteIssues extends PreQuoteIssues<SCHO4PreQuoteIssues> {

    public SCHO4PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public SCHO4RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new SCHO4RiskAnalysis(sh, path);
    }
}
