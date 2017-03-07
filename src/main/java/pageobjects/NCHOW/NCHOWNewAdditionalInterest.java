package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWNewAdditionalInterest extends NewAdditionalInterest<NCHOWNewAdditionalInterest> {
    public NCHOWNewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWSelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCHOWSelectStandardizedAddress(sh,path);
    }
    public NCHOWDwelling.NCHOWAdditionalInterests clickCancel()
    {
        super.cancel();
        return new NCHOWDwelling(sh,path).new NCHOWAdditionalInterests(sh,path);
    }
    public NCHOWDwelling.NCHOWAdditionalInterests clickOk()
    {
        super.ok();
        return new NCHOWDwelling(sh,path).new NCHOWAdditionalInterests(sh,path);
    }
}
