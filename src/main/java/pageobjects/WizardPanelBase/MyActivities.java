package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class MyActivities<T extends MyActivities> extends CenterPanelBase
{
    private MyActivitiesBy by;
    public NavigationBar navbar;

    public class MyActivitiesBy extends CenterPanelBase.CenterPanelBy
    {
        final public By username = By.cssSelector("[id='AccountFile_Summary:AccountFile_SummaryScreen:AccountFile_Summary_BasicInfoDV:Name-inputEl']");
    }

    public MyActivities(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new MyActivitiesBy();
        expectedPanelTitle = "My Activities";
        waitForTitle(sh);

    }
    public MyActivities getFirstname()
    {
        return this;
    }

    public MyActivities getLastname()
    {
        return this;
    }
}
