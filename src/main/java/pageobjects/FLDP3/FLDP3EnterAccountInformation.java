package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3EnterAccountInformation extends EnterAccountInformation<FLDP3EnterAccountInformation>
{
	public FLDP3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLDP3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new FLDP3CreateAccount(sh);
	}
	public FLDP3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new FLDP3CreateAccount(sh);
	}

	public FLDP3CreateAccount createNewPersonAccountFLDP3()
	{
		super.createNewPersonAccount();
		return new FLDP3CreateAccount(sh);
	}

	public FLDP3SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new FLDP3SearchAddressBook(sh);
	}
}
