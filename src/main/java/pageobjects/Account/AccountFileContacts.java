package pageobjects.Account;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by ssai on 3/7/2017.
 */
public class AccountFileContacts extends AccountBase
{
    protected CenterSeleniumHelper sh;
    private  AccountFileContactsBy by;

    public AccountFileContacts(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        expectedPanelTitle = "Account File Summary";
        sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);
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

    public class ContactDetail<T extends ContactDetail>  extends CenterPanelBase
    {
        private ContactDetailBy by;

        public ContactDetail (CenterSeleniumHelper sh)
        {
            this.sh = sh;
            by = new ContactDetailBy();
            System.out.println("Navigated to page: Contact Detail");
        }

        public class ContactDetailBy
        {


        }
    }
}
