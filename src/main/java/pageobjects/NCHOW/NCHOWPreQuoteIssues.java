package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/15/2017.
 */
public class NCHOWPreQuoteIssues extends PreQuoteIssues<NCHOWPreQuoteIssues> {

    public NCHOWPreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public NCHOWRiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new NCHOWRiskAnalysis(sh, path);
    }
}
