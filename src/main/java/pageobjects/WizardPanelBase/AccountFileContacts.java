package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by ssai on 3/7/2017.
 */
public class AccountFileContacts  {

    protected CenterSeleniumHelper sh;
    private  AccountFileContactsBy by;

    public AccountFileContacts (CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new AccountFileContactsBy();
    }
    public class AccountFileContactsBy
    {
        public   By  clickNameAFC = By.id("AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV:0:Name");
                //.//*[@id='AccountFile_Contacts:AccountFile_ContactsScreen:AccountContactsLV-body']/div/div/table/tbody/tr/td[3]/div/a
    }

    public AccountFileContacts clickNameAccountFileContacts()
    {
        sh.waitForNoMask();
        sh.clickElement(by.clickNameAFC);
        return this;
    }

}
