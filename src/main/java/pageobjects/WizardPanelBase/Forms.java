package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.Policy.Summary;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class Forms <T extends Forms> extends CenterPanelBase {

    public FormsBy by;
    public WestPanelBase westPanel;

    public Forms(CenterSeleniumHelper sh){

        this.sh = sh;
        by = new FormsBy();
        expectedPanelTitle = "Forms";
        waitForTitle(sh);
        log("Navigated to page: "+ expectedPanelTitle);
        westPanel = new WestPanelBase(sh);


    }

    public class FormsBy {
        public By   noticeofcancellationdescription = By.xpath(".//*[@id='PolicyFileFormsHOE:PolicyFile_PolicyLine_FormsScreen:FormsDV:FormsLV-body']//div[text() = 'Notice of Cancellation']"),
                    summary =By.xpath(".//*[@id='PolicyFile:MenuLinks:PolicyFile_PolicyFile_Summary']/div/span");
    }

    public String getnoticeofcancellationdescription()
    {
        sh.waitForNoMask();
        return  sh.getText(by.noticeofcancellationdescription);
    }

    public Summary clickSummary()
    {
        sh.waitForNoMask();
        sh.clickElement(by.summary);
        return new Summary(sh);
    }

}
