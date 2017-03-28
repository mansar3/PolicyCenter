package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/28/2017.
 */
public class FLHO3BatchProcessInfo extends BatchProcessInfo<FLHO3BatchProcessInfo> {

    public FLHO3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
