package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3EnterAccountInformation extends EnterAccountInformation<NCHO3EnterAccountInformation>
{
	public NCHO3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new NCHO3CreateAccount(sh);
	}
	public NCHO3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new NCHO3CreateAccount(sh);
	}
	public NCHO3SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new NCHO3SearchAddressBook(sh);
	}

	public NCHO3CreateAccount createNewPersonAccountNCHO3()
	{
		super.createNewPersonAccount();
		return new NCHO3CreateAccount(sh);
	}
}
