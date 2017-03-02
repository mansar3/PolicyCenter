package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4NewAdditionalInterest extends NewAdditionalInterest<FLHO4NewAdditionalInterest> {

    public FLHO4NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLHO4SelectStandardizedAddress(sh,path);
    }
    public FLHO4Dwelling.FLHO4AdditionalInterests clickCancel()
    {
        super.cancel();
        return new FLHO4Dwelling(sh,path).new FLHO4AdditionalInterests(sh,path);
    }
    public FLHO4Dwelling.FLHO4AdditionalInterests clickOk()
    {
        super.ok();
        return new FLHO4Dwelling(sh,path).new FLHO4AdditionalInterests(sh,path);
    }
}
