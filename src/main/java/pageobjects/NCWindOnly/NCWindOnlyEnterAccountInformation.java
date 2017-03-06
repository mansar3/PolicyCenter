package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyEnterAccountInformation extends EnterAccountInformation<NCWindOnlyEnterAccountInformation> {
    public NCWindOnlyEnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlyCreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new NCWindOnlyCreateAccount(sh);
    }
    public NCWindOnlyCreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new NCWindOnlyCreateAccount(sh);
    }
    public NCWindOnlySearchAddressBook createFromAddressBook()
    {
        super.searchFromAddressBookAccount();
        return new NCWindOnlySearchAddressBook(sh);
    }

    public NCWindOnlyCreateAccount createNewPersonAccountNCWindOnly()
    {
        super.createNewPersonAccount();
        return new NCWindOnlyCreateAccount(sh);
    }
}
