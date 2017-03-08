package pageobjects.Account;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by ssai on 3/7/2017.
 */
public class Actions extends AccountBase
{
    private ActionsBy by;
    public Actions(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new ActionsBy();
    }
    public class ActionsBy
    {
        public By submission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"),
                convertManualPolicy = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_ConvertManualPolicy-textEl"),
                actions = By.cssSelector("#westPanel .x-btn-button");
    }
    private void clickActions()
    {
        sh.waitForNoMask();
        sh.clickElement(by.actions);
    }
    protected void clickSubmission()
    {
        sh.waitForNoMask();
        clickActions();
        sh.clickElement(by.submission);

    }

}
