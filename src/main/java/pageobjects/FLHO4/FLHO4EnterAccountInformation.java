package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4EnterAccountInformation extends EnterAccountInformation<FLHO4EnterAccountInformation> {
    public FLHO4EnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4CreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new FLHO4CreateAccount(sh);
    }
    public FLHO4CreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new FLHO4CreateAccount(sh);
    }

    public FLHO4CreateAccount createNewPersonAccountFLHO4()
    {
        super.createNewPersonAccount();
        return new FLHO4CreateAccount(sh);
    }

    public FLHO4SearchAddressBook createFromAddressBook()
    {
        super.searchFromAddressBookAccount();
        return new FLHO4SearchAddressBook(sh);
    }
}
