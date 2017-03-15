package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWUWActivity extends UWActivity<NCHOWUWActivity> {
    public NCHOWUWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWRiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new NCHOWRiskAnalysis(sh,path);
    }
    public NCHOWRiskAnalysis clickCancel()
    {
        super.clickcancel();
        return new NCHOWRiskAnalysis(sh,path);
    }
}
