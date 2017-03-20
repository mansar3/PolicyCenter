package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.Policy.Summary;

/**
 * Created by ssai on 3/20/2017.
 */
public class PolicyChangeBound extends CenterPanelBase {
    private PolicyChangeBoundBy by;

    public PolicyChangeBound(CenterSeleniumHelper sh) {
        this.sh = sh;
        expectedPanelTitle = "Policy Change Bound";
        waitForTitle(sh);
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }

    static class PolicyChangeBoundBy {
        final static By viewyourpolicy = By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl");
    }

    public Summary clickViewYourPolicy()
    {
        sh.waitForNoMask();
        sh.clickElement(by.viewyourpolicy);
        return new Summary(sh);
    }

}