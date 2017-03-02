package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4LocationInformation extends LocationInformation<FLHO4LocationInformation> {
    public FLHO4LocationInformation(CenterSeleniumHelper sh, CenterPanelBase.Path path)
    {
        super(sh, path);
    }

    public FLHO4SelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new FLHO4SelectStandardizedAddress(sh,path);
    }
    public FLHO4Dwelling clickOk()
    {
        super.ok();
        return new FLHO4Dwelling(sh,path);
    }
    public FLHO4Dwelling clickCancel()
    {
        super.cancel();
        return new FLHO4Dwelling(sh,path);
    }
}
