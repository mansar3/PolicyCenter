package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3SelectStandardizedAddress extends SelectStandardizedAddress<FLDP3SelectStandardizedAddress>
{
	public FLDP3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLDP3SelectStandardizedAddress(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLDP3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLDP3CreateAccount(sh);
	}
	public FLDP3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLDP3NewAdditionalInterest(sh,path);
	}
	public FLDP3NewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new FLDP3NewAdditionalInterest(sh,path);
	}

	public FLDP3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLDP3LocationInformation(sh,path);
	}

	public FLDP3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
	{
		super.clickSuccessfulVerificationIfPossible();
		return new FLDP3NewAdditionalNamedInsured(sh,path);
	}

	public FLDP3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
	{
		super.clickAddressForNewAdditionalInterests(row);
		return new FLDP3NewAdditionalInterest(sh,path);
	}

	public FLDP3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
	{
		super.clickAddressForNewAdditionalNamedInsured(row);
		return new FLDP3NewAdditionalNamedInsured(sh,path);
	}
}
