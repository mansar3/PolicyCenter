package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4NewAdditionalNamedInsured extends NewAdditionalNameInsured<SCHO4NewAdditionalNamedInsured> {

    public SCHO4NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4PolicyInfo clickOk()
    {
        super.ok();
        return new SCHO4PolicyInfo(sh,path);
    }
    public SCHO4PolicyInfo clickCancel()
    {
        super.cancel();
        return new SCHO4PolicyInfo(sh,path);
    }
    public SCHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new SCHO4SelectStandardizedAddress(sh,path);
    }
}
