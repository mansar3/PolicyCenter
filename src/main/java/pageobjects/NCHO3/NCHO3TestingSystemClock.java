package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.NCHO3.NCHO3TestingSystemClock;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/15/2017.
 */
public class NCHO3TestingSystemClock extends TestingSystemClock<NCHO3TestingSystemClock> {

    public NCHO3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }

    public NCHO3TestingSystemClock setDate(String date)
    {
        return   super.setDate(date);
    }

    public NCHO3TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }
}
