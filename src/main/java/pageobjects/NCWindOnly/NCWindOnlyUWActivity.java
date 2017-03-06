package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.UWActivity;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyUWActivity extends UWActivity<NCWindOnlyUWActivity> {
    public NCWindOnlyUWActivity(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyRiskAnalysis sendRequest()
    {
        super.clickSendRequest();
        return new NCWindOnlyRiskAnalysis(sh,path);
    }
}
