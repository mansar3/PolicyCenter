package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.CenterPanelBase;

/**
 * Created by ssai on 3/20/2017.
 */
public class Summary extends PolicyBase {

    private SummaryBy by;
    public Summary(CenterSeleniumHelper sh)
    {
      this.sh = sh;
        westPanel = new WestPanel(sh);
        northPanel = new NorthPanel(sh);
        actions = new Actions(sh);
        by = new SummaryBy();
        expectedPanelTitle = "Summary";
        sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);

    }
    public class SummaryBy
    {
        final public By transeffdate = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']//div[text() = 'Policy Change']/../preceding-sibling::td[2]"),
                         type = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']//div[text() = 'Amend Coverage']/../preceding-sibling::td[3]"),
                         premium = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']//div[text() = 'Policy Change']/../following-sibling::td[2]"),
                         comment= By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']//div[text() = 'Policy Change']/../following-sibling::td[3]");
    }

    public String getTransEffDate()
    {
        return sh.getText(by.transeffdate);
    }

    public String getCompletedPolicyTranType()
    {
        return sh.getText(by.type);
    }

    public String getCompletedPolicyTranPremium()
    {
        return sh.getText(by.premium);
    }

    public String getCompletedPolicyTranComment()
    {
        return sh.getText(by.comment);
    }

}
