package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by ssai on 3/21/2017.
 */
public class SubmissionBound extends CenterPanelBase {

    private SubmissionBoundBy by;
    public SubmissionBound(CenterSeleniumHelper sh, Path path)
    {
        this.sh = sh;
        this.path = path;
        expectedPanelTitle = "Submission Bound";
        waitForTitle(sh);
        log("Navigated to page: " + expectedPanelTitle);
        by = new SubmissionBoundBy();

    }
    public class SubmissionBoundBy
    {

        By viewYourPolicy = By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl");
    }

    public void clickViewYourPolicy()
    {
        sh.waitForNoMask();
        sh.clickElement(by.viewYourPolicy);

    }

}
