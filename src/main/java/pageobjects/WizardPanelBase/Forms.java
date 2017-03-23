package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class Forms <T extends Forms> extends CenterPanelBase {

    public FormsBy by;

    public Forms(CenterSeleniumHelper sh){

        this.sh = sh;
        by = new FormsBy();
        expectedPanelTitle = "Forms";
        waitForTitle(sh);
        System.out.println("Navigated to page: "+ expectedPanelTitle);

    }

    public class FormsBy {
        public By   noticeofcancellationdescription = By.xpath(".//*[@id='PolicyFileFormsHOE:PolicyFile_PolicyLine_FormsScreen:FormsDV:FormsLV-body']//div[text() = 'Notice of Cancellation']");
    }

    public String getnoticeofcancellationdescription()
    {
        sh.waitForNoMask();
        return  sh.getText(by.noticeofcancellationdescription);
    }


}
