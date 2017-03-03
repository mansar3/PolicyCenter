package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;
import pageobjects.WizardPanelBase.AccountFileSummary;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3AccountFileSummary extends AccountFileSummary<FLMH3AccountFileSummary> {

    public AccountFileSummaryWestPanel westPanel = new AccountFileSummaryWestPanel(sh);
    public AccountFileSummaryWestPanel.AccountFileSummaryActions actions;
    public FLMH3AccountFileSummary(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public String getAccountNumber()
    {
        return super.getAccountNumber();
    }

    public FLMH3Quote clickTransactionNumber()
    {
        super.clickTransactionNumber();
        return new FLMH3Quote(sh, path);
    }
}
