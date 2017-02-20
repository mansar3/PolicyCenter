package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6EnterAccountInformation extends EnterAccountInformation<SCHO6EnterAccountInformation>
{
	public SCHO6EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO6CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new SCHO6CreateAccount(sh);
	}
	public SCHO6CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new SCHO6CreateAccount(sh);
	}
	public SCHO6SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new SCHO6SearchAddressBook(sh);
	}
}
