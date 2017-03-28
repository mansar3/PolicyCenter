package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.BatchProcessInfo;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class ALHO3BatchProcessInfo extends BatchProcessInfo <ALHO3BatchProcessInfo> {


    public ALHO3BatchProcessInfo(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3BatchProcessInfo clickrunworkflow()
    {
        return super.clickRunworkflow();
    }
}
