package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3SelectStandardizedAddress extends SelectStandardizedAddress<FLHO3SelectStandardizedAddress>
{
	public FLHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossibleForCreateAccount();
		return new FLHO3CreateAccount(sh);
	}
	public FLHO3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossibleForNewAdditionalInterests();
		return new FLHO3NewAdditionalInterest(sh,path);
	}

	public FLHO3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossibleForLocationInformation();
		return new FLHO3LocationInformation(sh,path);
	}

	public FLHO3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured();
		return new FLHO3NewAdditionalNamedInsured(sh,path);
	}

	public FLHO3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new FLHO3NewAdditionalInterest(sh,path);
	}

	public FLHO3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new FLHO3NewAdditionalNamedInsured(sh,path);
	}
}
