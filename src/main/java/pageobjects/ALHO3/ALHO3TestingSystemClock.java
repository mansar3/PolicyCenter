package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.TestingSystemClock;

/**
 * Created by ssai on 3/8/2017.
 */
public class ALHO3TestingSystemClock extends TestingSystemClock<ALHO3TestingSystemClock> {

    public ALHO3TestingSystemClock(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public String  getCurrentDate()
    {
        return super.getCurrentDate();
    }

    public ALHO3TestingSystemClock setDate(String date)
    {
     return   super.setDate(date);
    }

    public ALHO3TestingSystemClock clickchangedate()
    {
        return super.clickchangeDate();
    }

}
