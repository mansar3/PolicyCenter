package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/16/2017.
 */
public class SCHO6PreQuoteIssues extends PreQuoteIssues<SCHO6PreQuoteIssues> {

    public SCHO6PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public SCHO6RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new SCHO6RiskAnalysis(sh, path);
    }
}
