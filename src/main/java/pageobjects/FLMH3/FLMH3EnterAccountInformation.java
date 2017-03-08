package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3EnterAccountInformation extends EnterAccountInformation<FLMH3EnterAccountInformation> {

    public FLMH3EnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3CreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new FLMH3CreateAccount(sh);
    }
    public FLMH3CreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new FLMH3CreateAccount(sh);
    }

    public FLMH3CreateAccount createNewPersonAccountFLMH3()
    {
        super.createNewPersonAccount();
        return new FLMH3CreateAccount(sh);
    }

    public FLMH3SearchAddressBook createFromAddressBook()
    {
        super.searchFromAddressBookAccount();
        return new FLMH3SearchAddressBook(sh);
    }

    public FLMH3AccountFileSummary clickAccountNumberFLMH3()
    {
        super.clickAccountNumber();
        return new FLMH3AccountFileSummary(sh);
    }
}
