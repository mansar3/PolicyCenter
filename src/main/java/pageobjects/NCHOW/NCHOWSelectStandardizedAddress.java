package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWSelectStandardizedAddress<T extends NCHOWSelectStandardizedAddress> extends SelectStandardizedAddress<NCHOWSelectStandardizedAddress> {
    public NCHOWSelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public NCHOWSelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWCreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCHOWCreateAccount(sh);
    }
    public NCHOWNewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCHOWNewAdditionalInterest(sh,path);
    }

    public NCHOWNewAdditionalInterest selectUserOverride()
	{
		super.clickUserOverride();
		return new NCHOWNewAdditionalInterest(sh,path);
	}

    public NCHOWLocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCHOWLocationInformation(sh,path);
    }

    public NCHOWNewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCHOWNewAdditionalNamedInsured(sh,path);
    }

    public NCHOWNewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new NCHOWNewAdditionalInterest(sh,path);
    }

    public NCHOWNewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new NCHOWNewAdditionalNamedInsured(sh,path);
    }
}
