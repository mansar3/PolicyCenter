package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class CancellationBound <T extends CancellationBound> extends CenterPanelBase {

    private CancellationBoundBy by;
    public CancellationBound(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        expectedPanelTitle = "Cancellation Bound";
      //  waitForTitle(sh);
        System.out.println("Navigated to page: " + expectedPanelTitle);
        by = new CancellationBoundBy();

    }

    public class CancellationBoundBy {

        public By clickviewyourpolicy = By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl");
    }

    public T clickViewYourPolicy()
    {
        sh.waitForNoMask();
        sh.clickElement(by.clickviewyourpolicy);
        return (T)this;
    }
}
