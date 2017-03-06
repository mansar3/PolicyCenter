package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyLocationInformation extends LocationInformation<NCWindOnlyLocationInformation> {
    public NCWindOnlyLocationInformation(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlySelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCWindOnlySelectStandardizedAddress(sh,path);
    }
    public NCWindOnlyDwelling clickOk()
    {
        super.ok();
        return new NCWindOnlyDwelling(sh,path);
    }
    public NCWindOnlyDwelling clickCancel()
    {
        super.cancel();
        return new NCWindOnlyDwelling(sh,path);
    }
}
