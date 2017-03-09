package pageobjects.Account;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by ssai on 3/8/2017.
 */
public class AccountFilePolicyTransactions extends AccountBase {

    protected CenterSeleniumHelper sh;
    private  AccountFilePolicyTransactionsBy by;
    public AccountFilePolicyTransactions (CenterSeleniumHelper sh)
    {
        this.sh = sh;
        expectedPanelTitle = "Account File Policy Transactions";
        sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);
        by = new AccountFilePolicyTransactionsBy();

    }

    public  class AccountFilePolicyTransactionsBy
    {
        public By  clickTransactionNumber = By.id("AccountFile_WorkOrders:AccountFile_WorkOrdersScreen:AccountWorkOrdersLV:0:WorkOrderNumber");
    }

    public AccountFilePolicyTransactions clickTransactionNumber (){
        sh.waitForNoMask();
        sh.clickElement(by.clickTransactionNumber);
        return this;
    }
}
