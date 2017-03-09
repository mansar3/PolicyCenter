package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.ALHO3.ALHO3RiskAnalysis;

/**
 * Created by ssai on 3/8/2017.
 */
public class PreQuoteIssues<T extends PreQuoteIssues> extends CenterPanelBase {

    private PreQuoteIssuesBy by;

    public PreQuoteIssues (CenterSeleniumHelper sh, Path path)
    {
        this.sh = sh;
        this.path = path;
        expectedPanelTitle = "Pre-Quote Issues";
        waitForTitle(sh);
        by = new PreQuoteIssuesBy();
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }

    public class PreQuoteIssuesBy{

        final By details = By.id("UWBlockProgressIssuesPopup:IssuesScreen:DetailsButton-btnInnerEl");
    }

    protected T detailsTab()
    {
        sh.waitForNoMask();
        sh.clickElement(by.details);
        return (T)this;
    }
}

