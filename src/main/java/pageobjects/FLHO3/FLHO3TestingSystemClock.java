package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/10/2017.
 */
public class FLHO3TestingSystemClock extends TestingSystemClock<FLHO3TestingSystemClock> {

    public FLHO3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
    public FLHO3TestingSystemClock setDate(String date)
    {
        return   super.setDate(date);
    }

    public FLHO3TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }
}
