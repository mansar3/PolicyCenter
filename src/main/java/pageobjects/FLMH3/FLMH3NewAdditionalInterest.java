package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3NewAdditionalInterest extends NewAdditionalInterest<FLMH3NewAdditionalInterest> {

    public FLMH3NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLMH3SelectStandardizedAddress(sh,path);
    }
    public FLMH3Dwelling.FLMH3AdditionalInterests clickCancel()
    {
        super.cancel();
        return new FLMH3Dwelling(sh,path).new FLMH3AdditionalInterests(sh,path);
    }
    public FLMH3Dwelling.FLMH3AdditionalInterests clickOk()
    {
        super.ok();
        return new FLMH3Dwelling(sh,path).new FLMH3AdditionalInterests(sh,path);
    }
}
