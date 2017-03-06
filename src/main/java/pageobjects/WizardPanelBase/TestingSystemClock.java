package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by ssai on 3/6/2017.
 */
public class TestingSystemClock <T extends TestingSystemClock> extends CenterPanelBase {

    private TestingSystemClockBy by = new TestingSystemClockBy();

    public TestingSystemClock(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        expectedPanelTitle = "Testing System Clock";
        waitForTitle(sh);
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }


    public class TestingSystemClockBy extends CenterPanelBy
    {
        final By changeDate = By.id("SystemClock:SystemClockScreen:ChangeDate-btnInnerEl"),
                 date = By.id("SystemClock:SystemClockScreen:Date-inputEl");
    }

    protected String getCurrentDate()
    {
        sh.waitForNoMask();
        return  sh.getValue(by.date);
    }

}