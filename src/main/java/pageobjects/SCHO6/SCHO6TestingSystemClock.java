package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/16/2017.
 */
public class SCHO6TestingSystemClock extends TestingSystemClock<SCHO6TestingSystemClock> {

    public SCHO6TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }
    public SCHO6TestingSystemClock setDate(String date)
    {
        return   super.setDate(date);
    }

    public SCHO6TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }
}
