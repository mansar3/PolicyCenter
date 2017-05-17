package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3SelectStandardizedAddress extends SelectStandardizedAddress<SCHO3SelectStandardizedAddress>
{
		public SCHO3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO3CreateAccount(sh);
	}
	public SCHO3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO3NewAdditionalInterest(sh,path);
	}
	public SCHO3NewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new SCHO3NewAdditionalInterest(sh,path);
	}

	public SCHO3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO3LocationInformation(sh,path);
	}

	public SCHO3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCHO3NewAdditionalNamedInsured(sh,path);
	}

	public SCHO3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new SCHO3NewAdditionalInterest(sh,path);
	}

	public SCHO3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new SCHO3NewAdditionalNamedInsured(sh,path);
	}
}
