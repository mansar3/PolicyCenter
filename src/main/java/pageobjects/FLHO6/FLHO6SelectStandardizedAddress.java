package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6SelectStandardizedAddress extends SelectStandardizedAddress<FLHO6SelectStandardizedAddress>
{
	public FLHO6SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO6SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLHO6CreateAccount(sh);
	}
	public FLHO6NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLHO6NewAdditionalInterest(sh,path);
	}
	public FLHO6NewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new FLHO6NewAdditionalInterest(sh,path);
	}

	public FLHO6LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLHO6LocationInformation(sh,path);
	}

	public FLHO6NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLHO6NewAdditionalNamedInsured(sh,path);
	}

	public FLHO6NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new FLHO6NewAdditionalInterest(sh,path);
	}

	public FLHO6NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new FLHO6NewAdditionalNamedInsured(sh,path);
	}
}
