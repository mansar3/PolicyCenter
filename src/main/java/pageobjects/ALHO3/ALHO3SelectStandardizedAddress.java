package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3SelectStandardizedAddress extends SelectStandardizedAddress<ALHO3SelectStandardizedAddress>
{
	public ALHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public ALHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public ALHO3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new ALHO3CreateAccount(sh);
	}
	public ALHO3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new ALHO3NewAdditionalInterest(sh,path);
	}

	public ALHO3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new ALHO3LocationInformation(sh,path);
	}

	public ALHO3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new ALHO3NewAdditionalNamedInsured(sh,path);
	}

	public ALHO3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new ALHO3NewAdditionalInterest(sh,path);
	}

	public ALHO3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new ALHO3NewAdditionalNamedInsured(sh,path);
	}
}
