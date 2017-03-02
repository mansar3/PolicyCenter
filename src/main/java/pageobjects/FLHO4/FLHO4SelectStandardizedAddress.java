package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4SelectStandardizedAddress extends SelectStandardizedAddress<FLHO4SelectStandardizedAddress> {

    public FLHO4SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public FLHO4SelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLHO4CreateAccount(sh);
    }
    public FLHO4NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLHO4NewAdditionalInterest(sh,path);
    }

    public FLHO4LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLHO4LocationInformation(sh,path);
    }

    public FLHO4NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new FLHO4NewAdditionalNamedInsured(sh,path);
    }

    public FLHO4NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new FLHO4NewAdditionalInterest(sh,path);
    }

    public FLHO4NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new FLHO4NewAdditionalNamedInsured(sh,path);
    }
}
