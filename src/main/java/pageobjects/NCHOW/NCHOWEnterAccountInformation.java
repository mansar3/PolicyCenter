package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWEnterAccountInformation extends EnterAccountInformation<NCHOWEnterAccountInformation> {
    public NCHOWEnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWCreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new NCHOWCreateAccount(sh);
    }
    public NCHOWCreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new NCHOWCreateAccount(sh);
    }
    public NCHOWSearchAddressBook createFromAddressBook()
    {
        super.searchFromAddressBookAccount();
        return new NCHOWSearchAddressBook(sh);
    }

    public NCHOWCreateAccount createNewPersonAccountNCHOW()
    {
        super.createNewPersonAccount();
        return new NCHOWCreateAccount(sh);
    }
}
