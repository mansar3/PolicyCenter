package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4AccountFileSummary extends AccountFileSummary<FLHO4AccountFileSummary> {

    public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
    public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
    public FLHO4AccountFileSummary(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public String getAccountNumber()
    {
        return super.getAccountNumber();
    }

    public FLHO4Quote clickTransactionNumber()
    {
        super.clickTransactionNumber();
        return new FLHO4Quote(sh, path);
    }

    public Summary clickInforcedAccountNumber()
    {
        sh.waitForNoMask();
        super.clickInforceAccountNumber();
        return new Summary(sh);

    }
}
