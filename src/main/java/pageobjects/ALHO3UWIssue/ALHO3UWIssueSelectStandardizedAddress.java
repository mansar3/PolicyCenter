package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SelectStandardizedAddress;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueSelectStandardizedAddress extends SelectStandardizedAddress<ALHO3UWIssueSelectStandardizedAddress> {

    public ALHO3UWIssueSelectStandardizedAddress(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public ALHO3UWIssueSelectStandardizedAddress(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssueCreateAccount selectSuccessfulVerificationIfPossibleForCreateAccount()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new ALHO3UWIssueCreateAccount(sh);
    }
    public ALHO3UWIssueNewAdditionalInterest selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new ALHO3UWIssueNewAdditionalInterest(sh,path);
    }

    public ALHO3UWIssueLocationInformation selectSuccessfulVerificationIfPossibleForLocationInformation()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new ALHO3UWIssueLocationInformation(sh,path);
    }

    public ALHO3UWIssueNewAdditionalNamedInsured selectSuccessfulVerificationIfPossibleForNewAdditionalNamedInsured()
    {
        super.clickSuccessfulVerificationIfPossible();
        return new ALHO3UWIssueNewAdditionalNamedInsured(sh,path);
    }

    public ALHO3UWIssueNewAdditionalInterest selectAddressForNewAdditionalInterests(int row)
    {
        super.clickAddressForNewAdditionalInterests(row);
        return new ALHO3UWIssueNewAdditionalInterest(sh,path);
    }

    public ALHO3UWIssueNewAdditionalNamedInsured selectAddressForNewAdditionalNamedInsured(int row)
    {
        super.clickAddressForNewAdditionalNamedInsured(row);
        return new ALHO3UWIssueNewAdditionalNamedInsured(sh,path);
    }
}
