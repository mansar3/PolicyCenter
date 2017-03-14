package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/14/2017.
 */
public class FLHO6TestingSystemClock extends TestingSystemClock<FLHO6TestingSystemClock> {

    public FLHO6TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
}
