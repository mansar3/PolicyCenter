package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3SelectStandardizedAddress extends SelectStandardizedAddress<FLMH3SelectStandardizedAddress> {

    public FLMH3SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public FLMH3SelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLMH3CreateAccount(sh);
    }
    public FLMH3NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLMH3NewAdditionalInterest(sh,path);
    }

    public FLMH3LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLMH3LocationInformation(sh,path);
    }

    public FLMH3NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLMH3NewAdditionalNamedInsured(sh,path);
    }

    public FLMH3NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new FLMH3NewAdditionalInterest(sh,path);
    }

    public FLMH3NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new FLMH3NewAdditionalNamedInsured(sh,path);
    }
}
