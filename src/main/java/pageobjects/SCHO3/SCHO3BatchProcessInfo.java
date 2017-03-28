package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/28/2017.
 */
public class SCHO3BatchProcessInfo extends BatchProcessInfo<SCHO3BatchProcessInfo> {

    public SCHO3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
    
}
