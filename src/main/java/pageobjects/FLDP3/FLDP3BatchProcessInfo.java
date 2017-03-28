package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/28/2017.
 */
public class FLDP3BatchProcessInfo extends BatchProcessInfo<FLDP3BatchProcessInfo> {

    public FLDP3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLDP3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
