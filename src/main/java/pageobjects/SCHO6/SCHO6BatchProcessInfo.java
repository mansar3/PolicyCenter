package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/29/2017.
 */
public class SCHO6BatchProcessInfo extends BatchProcessInfo<SCHO6BatchProcessInfo> {

    public SCHO6BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO6BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
