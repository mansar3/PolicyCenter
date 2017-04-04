package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/28/2017.
 */
public class SCDP3BatchProcessInfo extends BatchProcessInfo<SCDP3BatchProcessInfo> {

    public SCDP3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCDP3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
