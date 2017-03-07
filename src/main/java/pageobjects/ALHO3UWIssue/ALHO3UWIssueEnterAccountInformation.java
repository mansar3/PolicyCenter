package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueEnterAccountInformation extends EnterAccountInformation<ALHO3UWIssueEnterAccountInformation> {
    public ALHO3UWIssueEnterAccountInformation(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueCreateAccount createCompanyAccount()
    {
        super.createNewCompanyAccount();
        return new ALHO3UWIssueCreateAccount(sh);
    }
    public ALHO3UWIssueCreateAccount createPersonAccount()
    {
        super.createNewPersonAccount();
        return new ALHO3UWIssueCreateAccount(sh);
    }

    public ALHO3UWIssueCreateAccount createNewPersonAccountALHO3UWIssue()
    {
        super.createNewPersonAccount();
        return new ALHO3UWIssueCreateAccount(sh);
    }
//	public ALHO3SearchAddressBook createFromAddressBook()
//	{
//		super.searchFromAddressBookAccount();
//		return new ALHO3SearchAddressBook(sh);
//	}
}

