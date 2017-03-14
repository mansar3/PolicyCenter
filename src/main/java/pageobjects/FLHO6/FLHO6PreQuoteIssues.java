package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/14/2017.
 */
public class FLHO6PreQuoteIssues extends PreQuoteIssues<FLHO6PreQuoteIssues> {
    public FLHO6PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public FLHO6RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new FLHO6RiskAnalysis(sh, path);
    }
}
