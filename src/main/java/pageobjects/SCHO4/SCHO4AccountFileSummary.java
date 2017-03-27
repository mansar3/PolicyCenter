package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4AccountFileSummary extends AccountFileSummary<SCHO4AccountFileSummary> {

    public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
    public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
    public SCHO4AccountFileSummary(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public String getAccountNumber()
    {
        return super.getAccountNumber();
    }
    public Summary clickInforcedAccountNumber()
    {
        sh.waitForNoMask();
        super.clickInforceAccountNumber();
        return new Summary(sh);

    }
}
