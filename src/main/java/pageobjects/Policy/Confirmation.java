package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class Confirmation extends PolicyBase {

    private  ConfirmationBy  by;

    public Confirmation(CenterSeleniumHelper sh){

        this.sh = sh;
        westPanel = new WestPanel(sh, path);
        northPanel = new NorthPanel(sh);
        actions = new Actions(sh);
        by = new ConfirmationBy();
        expectedPanelTitle = "Confirmation";
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }

    public class ConfirmationBy {

        public By  scheduledcancellation = By.id("CancellationWizard:CancellationWizard_QuoteScreen:JobWizardToolbarButtonSet:SubmitCancellation-btnInnerEl");
    }

    public Confirmation clickScheduleCancellation()
    {
        sh.waitForNoMask();
        sh.clickElement(by.scheduledcancellation);
        return this;
    }

    public Confirmation  dismiss()
    {
        sh.clickElement(By.xpath(".//*[text()= 'Cancel']"));
        return this;
    }
    public Confirmation accept()
    {
        sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
        sh.clickElement(By.xpath(".//*[text()= 'OK']"));
        return this;

    }
}
