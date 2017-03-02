package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4NewAdditionalNamedInsured extends NewAdditionalNameInsured<FLHO4NewAdditionalNamedInsured> {


    public FLHO4NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4PolicyInfo clickOk()
    {
        super.ok();
        return new FLHO4PolicyInfo(sh,path);
    }
    public FLHO4PolicyInfo clickCancel()
    {
        super.cancel();
        return new FLHO4PolicyInfo(sh,path);
    }
    public FLHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLHO4SelectStandardizedAddress(sh,path);
    }
}
