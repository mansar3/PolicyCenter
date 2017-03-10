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
    public ContactDetail cd;
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

    public ContactDetail clickNameAccountFileContacts()
    {
        sh.waitForNoMask();
        sh.clickElement(by.clickNameAFC);
        return new ContactDetail(sh);
    }

    public class ContactDetail<T extends ContactDetail>  extends AccountBase
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

            final public By
                    dateOfBirth = By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:ContactNameInputSet:DateOfBirth-inputEl"),
                    ssn   = By.id("EditAccountContactPopup:ContactDetailScreen:AccountContactCV:AccountContactDV:OfficialIDInputSet:OfficialIDDV_Input-inputEl"),
                    update = By.id("EditAccountContactPopup:ContactDetailScreen:verifyAndUpdate-btnInnerEl");

        }

        public T setSsn(String ssn)
        {
            sh.waitForNoMask();
            sh.setText(by.ssn, ssn);
            return (T)this;
        }
        public T setDateOfBirth(String dateOfBirth)
        {
            sh.waitForNoMask();
            sh.setText(by.dateOfBirth, dateOfBirth);
            sh.tab();
            return (T)this;
        }

        public T clickupdate()
        {

            sh.waitForNoMask();
            sh.clickElement(by.update);
            return (T) this;
        }
    }
}
