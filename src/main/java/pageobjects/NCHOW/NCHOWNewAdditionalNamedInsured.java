package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWNewAdditionalNamedInsured extends NewAdditionalNameInsured<NCHOWNewAdditionalNamedInsured> {
    public NCHOWNewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWPolicyInfo clickOk()
    {
        super.ok();
        return new NCHOWPolicyInfo(sh,path);
    }
    public NCHOWPolicyInfo clickCancel()
    {
        super.cancel();
        return new NCHOWPolicyInfo(sh,path);
    }
    public NCHOWSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCHOWSelectStandardizedAddress(sh,path);
    }
    
}
