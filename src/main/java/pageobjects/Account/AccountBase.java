package pageobjects.Account;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.*;

/**
 * Created by ssai on 3/7/2017.
 */
abstract class AccountBase
{
    CenterSeleniumHelper sh;
    public WestPanel westPanel;
    public NorthPanel northPanel;
    public Actions actions;
    protected String expectedPanelTitle = "Center Panel Base";


    public class WestPanel extends AccountBase
    {
        public Actions actions;
        private WestPanelBy by;
        public WestPanel(CenterSeleniumHelper sh)
        {
            this.sh = sh;
            actions = new Actions(sh);
            by = new WestPanelBy();

        }
        public class WestPanelBy
        {
            By  clickContacts = By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_Contacts']/div/span"),
                clickPolicyTransaction = By.xpath(".//*[@id='AccountFile:MenuLinks:AccountFile_AccountFile_WorkOrders']/div/span");
        }
        public AccountFileContacts clickContacts()
        {
            sh.clickElement(by.clickContacts);
            return new AccountFileContacts(sh);
        }
        public AccountFilePolicyTransactions clickPolicyTransaction()
        {
            sh.clickElement(by.clickPolicyTransaction);
            return new AccountFilePolicyTransactions(sh);
        }
    }
}
