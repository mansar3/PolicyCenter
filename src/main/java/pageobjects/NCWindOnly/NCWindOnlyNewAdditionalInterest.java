package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.NewAdditionalInterest;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyNewAdditionalInterest extends NewAdditionalInterest<NCWindOnlyNewAdditionalInterest> {
    public NCWindOnlyNewAdditionalInterest(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlySelectStandardizedAddress clickVerifyAddress()
    {
        super.verifyAddress();
        return new NCWindOnlySelectStandardizedAddress(sh,path);
    }
    public NCWindOnlyDwelling.NCWindOnlyAdditionalInterests clickCancel()
    {
        super.cancel();
        return new NCWindOnlyDwelling(sh,path).new NCWindOnlyAdditionalInterests(sh,path);
    }
    public NCWindOnlyDwelling.NCWindOnlyAdditionalInterests clickOk()
    {
        super.ok();
        return new NCWindOnlyDwelling(sh,path).new NCWindOnlyAdditionalInterests(sh,path);
    }
}
