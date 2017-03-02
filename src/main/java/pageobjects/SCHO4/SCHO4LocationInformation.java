package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4LocationInformation extends LocationInformation<SCHO4LocationInformation> {

    public SCHO4LocationInformation(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new SCHO4SelectStandardizedAddress(sh,path);
    }
    public SCHO4Dwelling clickOk()
    {
        super.ok();
        return new SCHO4Dwelling(sh,path);
    }
    public SCHO4Dwelling clickCancel()
    {
        super.cancel();
        return new SCHO4Dwelling(sh,path);
    }
}
