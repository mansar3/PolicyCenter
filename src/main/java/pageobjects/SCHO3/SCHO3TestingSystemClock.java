package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/15/2017.
 */
public class SCHO3TestingSystemClock extends TestingSystemClock<SCHO3TestingSystemClock> {

    public SCHO3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }

    public SCHO3TestingSystemClock setDate(String date)
    {
        return   super.setDate(date);
    }

    public SCHO3TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }
}
