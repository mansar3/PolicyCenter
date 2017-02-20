package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6EnterAccountInformation extends EnterAccountInformation<FLHO6EnterAccountInformation>
{
	public FLHO6EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new FLHO6CreateAccount(sh);
	}
	public FLHO6CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new FLHO6CreateAccount(sh);
	}
	public FLHO6SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new FLHO6SearchAddressBook(sh);
	}
}
