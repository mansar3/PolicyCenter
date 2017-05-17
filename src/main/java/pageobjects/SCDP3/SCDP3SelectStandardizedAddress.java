package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3SelectStandardizedAddress extends SelectStandardizedAddress<SCDP3SelectStandardizedAddress>
{
		public SCDP3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCDP3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCDP3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCDP3CreateAccount(sh);
	}
	public SCDP3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCDP3NewAdditionalInterest(sh,path);
	}
	public SCDP3NewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new SCDP3NewAdditionalInterest(sh,path);
	}

	public SCDP3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCDP3LocationInformation(sh,path);
	}

	public SCDP3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new SCDP3NewAdditionalNamedInsured(sh,path);
	}

	public SCDP3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new SCDP3NewAdditionalInterest(sh,path);
	}

	public SCDP3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new SCDP3NewAdditionalNamedInsured(sh,path);
	}
}
