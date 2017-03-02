package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4EnterAccountInformation extends EnterAccountInformation<SCHO4EnterAccountInformation> {

    public SCHO4EnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4CreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new SCHO4CreateAccount(sh);
    }
    public SCHO4CreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new SCHO4CreateAccount(sh);
    }
    public SCHO4SearchAddressBook createFromAddressBook()
    {
        super.searchFromAddressBookAccount();
        return new SCHO4SearchAddressBook(sh);
    }

    public SCHO4CreateAccount createNewPersonAccountSCHO4()
    {
        super.createNewPersonAccount();
        return new SCHO4CreateAccount(sh);
    }
}
