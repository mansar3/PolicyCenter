package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6SelectStandardizedAddress extends SelectStandardizedAddress<SCHO6SelectStandardizedAddress>
{
		public SCHO6SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO6SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO6CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO6CreateAccount(sh);
	}
	public SCHO6NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO6NewAdditionalInterest(sh,path);
	}

	public SCHO6LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO6LocationInformation(sh,path);
	}

	public SCHO6NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO6NewAdditionalNamedInsured(sh,path);
	}

	public SCHO6NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new SCHO6NewAdditionalInterest(sh,path);
	}

	public SCHO6NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new SCHO6NewAdditionalNamedInsured(sh,path);
	}
}
