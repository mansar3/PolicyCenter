package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4UWActivity extends UWActivity<FLHO4UWActivity> {

    public FLHO4UWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4RiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new FLHO4RiskAnalysis(sh,path);
    }
}
