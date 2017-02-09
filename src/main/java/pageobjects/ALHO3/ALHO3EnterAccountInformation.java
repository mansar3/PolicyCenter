package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3EnterAccountInformation extends EnterAccountInformation<ALHO3EnterAccountInformation>
{
	public ALHO3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new ALHO3CreateAccount(sh);
	}
	public ALHO3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new ALHO3CreateAccount(sh);
	}

	public ALHO3CreateAccount createNewPersonAccountALHO3()
	{
		super.createNewPersonAccount();
		return new ALHO3CreateAccount(sh);
	}
//	public ALHO3SearchAddressBook createFromAddressBook()
//	{
//		super.searchFromAddressBookAccount();
//		return new ALHO3SearchAddressBook(sh);
//	}
}
