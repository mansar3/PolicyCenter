package pageobjects.ALHO3UWIssueUWIssue;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueActionsBase <T extends ALHO3UWIssueActionsBase> {
    protected CenterSeleniumHelper sh;
    private ActionsBaseBy by = new ActionsBaseBy();
    static class ActionsBaseBy
    {
        public final By actions = By.cssSelector("#westPanel .x-btn-button"),
                newSubmission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl");
    }

    public void clickActions()
    {
        sh.waitForNoMask();
        sh.clickElement(by.actions);
    }

    public T clickNewSubmission()
    {
        sh.clickElement(by.newSubmission);
        return (T)this;
    }
}
