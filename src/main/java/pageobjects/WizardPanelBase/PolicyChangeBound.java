package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.ALHO3.ALHO3PolicyInfo;
import pageobjects.FLHO3.FLHO3Offerings;
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
        log("Navigated to page: " + expectedPanelTitle);
    }

    public class PolicyChangeBoundBy {
        final By viewyourpolicy = By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"),
        viewlaterboundperios = By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ResolveWithFutureBoundPeriods-inputEl");
    }

    public Summary clickViewYourPolicy()
    {
        sh.waitForNoMask();
        sh.clickElement(by.viewyourpolicy);
        return new Summary(sh);
    }

    public ALHO3PolicyInfo clickViewLaterBound()
    {
        sh.waitForNoMask();
        sh.clickElement(by.viewlaterboundperios);
        return new ALHO3PolicyInfo(sh, path);
    }

    public FLHO3Offerings clickViewLaterbound()
    {
        sh.waitForNoMask();
        sh.clickElement(by.viewlaterboundperios);
        return new FLHO3Offerings(sh, path);
    }

}