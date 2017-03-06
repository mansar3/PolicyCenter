package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyNewAdditionalNamedInsured extends NewAdditionalNameInsured<NCWindOnlyNewAdditionalNamedInsured> {
    public NCWindOnlyNewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyPolicyInfo clickOk()
    {
        super.ok();
        return new NCWindOnlyPolicyInfo(sh,path);
    }
    public NCWindOnlyPolicyInfo clickCancel()
    {
        super.cancel();
        return new NCWindOnlyPolicyInfo(sh,path);
    }
    public NCWindOnlySelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCWindOnlySelectStandardizedAddress(sh,path);
    }
    
}
