package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.LocationInformation;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWLocationInformation extends LocationInformation<NCHOWLocationInformation> {
    public NCHOWLocationInformation(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCHOWSelectStandardizedAddress(sh,path);
    }
    public NCHOWDwelling clickOk()
    {
        super.ok();
        return new NCHOWDwelling(sh,path);
    }
    public NCHOWDwelling clickCancel()
    {
        super.cancel();
        return new NCHOWDwelling(sh,path);
    }
}
