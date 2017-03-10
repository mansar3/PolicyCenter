package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/10/2017.
 */
public class FLDP3TestingSystemClock extends TestingSystemClock<FLDP3TestingSystemClock> {
    public FLDP3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
}
