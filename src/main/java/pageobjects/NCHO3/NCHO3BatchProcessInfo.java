package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/28/2017.
 */
public class NCHO3BatchProcessInfo extends BatchProcessInfo<NCHO3BatchProcessInfo> {

    public NCHO3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHO3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
