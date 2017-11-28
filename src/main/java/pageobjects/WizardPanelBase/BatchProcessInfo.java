package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class BatchProcessInfo <T extends BatchProcessInfo> extends CenterPanelBase {

    private BatchProcessInfoBy by;

    public BatchProcessInfo (CenterSeleniumHelper sh){

        this.sh = sh;
        expectedPanelTitle = "Batch Process Info";
        waitForTitle(sh);
        by = new BatchProcessInfoBy();
        log("Navigated to page: " + expectedPanelTitle);
    }

    public class BatchProcessInfoBy
    {
        public By workflowrun = By.xpath(".//*[@id='BatchProcessInfo:BatchProcessScreen:BatchProcessesLV-body']//div[text() = 'Workflow']/../following-sibling::td[2]/div/a[1]"),
                   policyrenewalstart = By.xpath(".//*[@id='BatchProcessInfo:BatchProcessScreen:BatchProcessesLV-body']//div[text() = 'Policy Renewal Start']/../following-sibling::td[2]/div/a[1]");
    }

    protected T clickRunworkflow()
    {
        sh.waitForNoMask();
        sh.clickElement(by.workflowrun);
        return (T) this;
    }

    protected T clickPolicyRenewalStart()
    {
        sh.waitForNoMask();
        sh.clickElement(by.policyrenewalstart);
        return (T) this;
    }


}
