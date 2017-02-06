package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;

public abstract class MyActivities<T extends MyActivities> extends CenterPanelBase
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

    }
    public void test()
    {
        System.out.println("test");
    }
}
