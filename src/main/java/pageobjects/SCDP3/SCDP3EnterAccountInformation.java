package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3EnterAccountInformation extends EnterAccountInformation<SCDP3EnterAccountInformation>
{
	public SCDP3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCDP3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new SCDP3CreateAccount(sh);
	}
	public SCDP3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new SCDP3CreateAccount(sh);
	}
	public SCDP3SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new SCDP3SearchAddressBook(sh);
	}

	public SCDP3CreateAccount createNewPersonAccountSCDP3()
	{
		super.createNewPersonAccount();
		return new SCDP3CreateAccount(sh);
	}
}
