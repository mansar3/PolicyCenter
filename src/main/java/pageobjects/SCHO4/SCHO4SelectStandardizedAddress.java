package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4SelectStandardizedAddress extends SelectStandardizedAddress<SCHO4SelectStandardizedAddress> {

    public SCHO4SelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public SCHO4SelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4CreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new SCHO4CreateAccount(sh);
    }
    public SCHO4NewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new SCHO4NewAdditionalInterest(sh,path);
    }

    public SCHO4LocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new SCHO4LocationInformation(sh,path);
    }

    public SCHO4NewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new SCHO4NewAdditionalNamedInsured(sh,path);
    }

    public SCHO4NewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new SCHO4NewAdditionalInterest(sh,path);
    }

    public SCHO4NewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new SCHO4NewAdditionalNamedInsured(sh,path);
    }
}
