package pageobjects.Account;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by ssai on 3/7/2017.
 */
public class AccountFileSummary<T extends CenterPanelBase> extends AccountBase
{
    private AccountFileSummaryBy by = new AccountFileSummaryBy();

    public AccountFileSummary(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        westPanel = new WestPanel(sh);
        northPanel = new NorthPanel(sh);
        actions = new Actions(sh);
        expectedPanelTitle = "Account File Summary";
        sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }



    public class AccountFileSummaryBy
    {
        private  String	screen = "AccountFile_Summary:AccountFile_SummaryScreen:";
        public By accountNumber = By.id(screen + "AccountFile_Summary_BasicInfoDV:AccountNumber-inputEl"),
                transactionNumber = By.id(screen + "AccountFile_Summary_WorkOrdersLV:0:WorkOrderNumber");
    }

    public String getAccountNumber()
    {
        sh.waitForNoMask();
        return sh.getText(by.accountNumber);
    }

    protected void clickTransactionNumber()
    {
        sh.clickElement(by.transactionNumber);
    }
}
