package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlySelectStandardizedAddress <T extends NCWindOnlySelectStandardizedAddress> extends SelectStandardizedAddress<NCWindOnlySelectStandardizedAddress> {
    public NCWindOnlySelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public NCWindOnlySelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlyCreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCWindOnlyCreateAccount(sh);
    }
    public NCWindOnlyNewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCWindOnlyNewAdditionalInterest(sh,path);
    }

    public NCWindOnlyLocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCWindOnlyLocationInformation(sh,path);
    }

    public NCWindOnlyNewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new NCWindOnlyNewAdditionalNamedInsured(sh,path);
    }

    public NCWindOnlyNewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new NCWindOnlyNewAdditionalInterest(sh,path);
    }

    public NCWindOnlyNewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new NCWindOnlyNewAdditionalNamedInsured(sh,path);
    }
}
