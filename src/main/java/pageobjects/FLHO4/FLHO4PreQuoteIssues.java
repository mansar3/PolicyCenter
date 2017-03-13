package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/13/2017.
 */
public class FLHO4PreQuoteIssues extends PreQuoteIssues<FLHO4PreQuoteIssues> {

    public FLHO4PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public FLHO4RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new FLHO4RiskAnalysis(sh, path);
    }
}
