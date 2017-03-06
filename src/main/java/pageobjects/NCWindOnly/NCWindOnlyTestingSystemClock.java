package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/6/2017.
 */
public class NCWindOnlyTestingSystemClock extends TestingSystemClock<NCWindOnlyTestingSystemClock>{

    public NCWindOnlyTestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
}
