package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/15/2017.
 */
public class SCDP3TestingSystemClock extends TestingSystemClock<SCDP3TestingSystemClock> {

    public SCDP3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }

    public SCDP3TestingSystemClock setDate(String date)
    {
        return   super.setDate(date);
    }

    public SCDP3TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }
}
