package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3SelectStandardizedAddress<T extends NCHO3SelectStandardizedAddress> extends SelectStandardizedAddress<NCHO3SelectStandardizedAddress>
{
		public NCHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public NCHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new NCHO3CreateAccount(sh);
	}
	public NCHO3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new NCHO3NewAdditionalInterest(sh,path);
	}
	public NCHO3NewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new NCHO3NewAdditionalInterest(sh,path);
	}

	public NCHO3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new NCHO3LocationInformation(sh,path);
	}

	public NCHO3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new NCHO3NewAdditionalNamedInsured(sh,path);
	}

	public NCHO3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new NCHO3NewAdditionalInterest(sh,path);
	}

	public NCHO3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new NCHO3NewAdditionalNamedInsured(sh,path);
	}
}
