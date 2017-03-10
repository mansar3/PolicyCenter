package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/10/2017.
 */
public class FLDP3PreQuoteIssues extends PreQuoteIssues<FLDP3PreQuoteIssues> {

    public FLDP3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
        super(sh,path);
    }

    public FLDP3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new FLDP3RiskAnalysis(sh, path);
    }
}
