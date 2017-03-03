package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3UWActivity extends UWActivity<FLMH3UWActivity> {

    public FLMH3UWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3RiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new FLMH3RiskAnalysis(sh,path);
    }
}
