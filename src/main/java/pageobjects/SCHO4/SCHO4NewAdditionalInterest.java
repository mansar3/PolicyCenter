package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4NewAdditionalInterest extends NewAdditionalInterest<SCHO4NewAdditionalInterest> {

    public SCHO4NewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new SCHO4SelectStandardizedAddress(sh,path);
    }
    public SCHO4Dwelling.SCHO4AdditionalInterests clickCancel()
    {
        super.cancel();
        return new SCHO4Dwelling(sh,path).new SCHO4AdditionalInterests(sh,path);
    }
    public SCHO4Dwelling.SCHO4AdditionalInterests clickOk()
    {
        super.ok();
        return new SCHO4Dwelling(sh,path).new SCHO4AdditionalInterests(sh,path);
    }
}
