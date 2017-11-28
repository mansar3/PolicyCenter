package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.EnterAccountInformation;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3EnterAccountInformation extends EnterAccountInformation<FLHO3EnterAccountInformation>
{
	public FLHO3EnterAccountInformation(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3CreateAccount createCompanyAccount()
	{
		super.createNewCompanyAccount();
		return new FLHO3CreateAccount(sh);
	}
	public FLHO3CreateAccount createPersonAccount()
	{
		super.createNewPersonAccount();
		return new FLHO3CreateAccount(sh);
	}

	public FLHO3CreateAccount createNewPersonAccountFLHO3()
	{
		super.createNewPersonAccount();
		return new FLHO3CreateAccount(sh);
	}

	public FLHO3SearchAddressBook createFromAddressBook()
	{
		super.searchFromAddressBookAccount();
		return new FLHO3SearchAddressBook(sh);
	}

	public FLHO3AccountFileSummary clickAccountNumberFLHO3()
	{
		super.clickAccountNumber();
		return new FLHO3AccountFileSummary(sh);
	}
	public FLHO3AccountFileSummary selectAccountNumber(int oneBasedRow)
	{
		super.selectAccount(oneBasedRow);
		return new FLHO3AccountFileSummary(sh);
	}
}
