package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class MyActivities extends CenterPanelBase
{
    private MyActivitiesBy by;
    public NavigationBar navbar;

    public class MyActivitiesBy extends CenterPanelBase.CenterPanelBy
    {
    }

    public MyActivities(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new MyActivitiesBy();
        expectedPanelTitle = "My Activities";
        waitForTitle(sh);
        navbar = new NavigationBar(sh);
    }
    public void test()
    {
        System.out.println("test");
    }
}
