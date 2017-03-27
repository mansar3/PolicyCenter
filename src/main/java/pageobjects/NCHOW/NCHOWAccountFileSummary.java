package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.Policy.Summary;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWAccountFileSummary extends AccountFileSummary<NCHOWAccountFileSummary> {
    public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
    public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
    public NCHOWAccountFileSummary(CenterSeleniumHelper sh)
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
