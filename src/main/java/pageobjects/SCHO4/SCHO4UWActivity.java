package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4UWActivity extends UWActivity<SCHO4UWActivity> {

    public SCHO4UWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4RiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new SCHO4RiskAnalysis(sh,path);
    }
    public SCHO4RiskAnalysis clickCancel()
    {
        super.clickcancel();
        return new SCHO4RiskAnalysis(sh,path);
    }
}
