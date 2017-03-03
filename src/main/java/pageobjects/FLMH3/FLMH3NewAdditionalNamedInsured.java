package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalNameInsured;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3NewAdditionalNamedInsured extends NewAdditionalNameInsured<FLMH3NewAdditionalNamedInsured> {

    public FLMH3NewAdditionalNamedInsured(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3PolicyInfo clickOk()
    {
        super.ok();
        return new FLMH3PolicyInfo(sh,path);
    }
    public FLMH3PolicyInfo clickCancel()
    {
        super.cancel();
        return new FLMH3PolicyInfo(sh,path);
    }
    public FLMH3SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLMH3SelectStandardizedAddress(sh,path);
    }
}
