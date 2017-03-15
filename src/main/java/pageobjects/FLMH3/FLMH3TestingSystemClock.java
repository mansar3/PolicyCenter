package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/14/2017.
 */
public class FLMH3TestingSystemClock extends TestingSystemClock<FLMH3TestingSystemClock> {
    
    public FLMH3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
}
