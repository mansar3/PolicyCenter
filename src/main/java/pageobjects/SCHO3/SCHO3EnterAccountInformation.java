package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3EnterAccountInformation extends EnterAccountInformation<SCHO3EnterAccountInformation>
{
	public SCHO3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new SCHO3CreateAccount(sh);
	}
	public SCHO3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new SCHO3CreateAccount(sh);
	}
	public SCHO3SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new SCHO3SearchAddressBook(sh);
	}

	public SCHO3CreateAccount createNewPersonAccountSCHO3()
	{
		super.createNewPersonAccount();
		return new SCHO3CreateAccount(sh);
	}
}
