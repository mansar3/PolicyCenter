package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PreQuoteIssues;

/**
 * Created by ssai on 3/8/2017.
 */
public class ALHO3PreQuoteIssues extends PreQuoteIssues<ALHO3PreQuoteIssues>
{
    public ALHO3PreQuoteIssues(CenterSeleniumHelper sh, Path path)
    {
       super(sh,path);
    }

    public ALHO3RiskAnalysis clickDetailsTab(){
        super.detailsTab();
        return new ALHO3RiskAnalysis(sh, path);
    }
}
