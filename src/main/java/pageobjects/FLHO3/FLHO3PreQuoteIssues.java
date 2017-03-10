package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/10/2017.
 */
public class FLHO3PreQuoteIssues extends PreQuoteIssues<FLHO3PreQuoteIssues> {

    public FLHO3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public FLHO3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new FLHO3RiskAnalysis(sh, path);
    }
}
