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
        westPanel = new WestPanel(sh, path);
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
                         comment= By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_TransactionsLV-body']//div[text() = 'Policy Change']/../following-sibling::td[3]"),
                         pendingeffedate = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_JobsInProgressLV-body']//div[text() = 'Policy Change']/../preceding-sibling::td[2]"),
                         pendingstatus = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_JobsInProgressLV-body']//div[text() = 'Policy Change']/../preceding-sibling::td[1]"),
                         pendingtype = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_JobsInProgressLV-body']//div[text() = 'Quoted']/../following-sibling::td[1]"),
                         policyeffectivedate = By.id("PolicyFile_Summary:Policy_SummaryScreen:Policy_Summary_DatesDV:PolicyPerEffDate-inputEl"),
                         whensafepolicynumber = By.id("PolicyFile_Summary:Policy_SummaryScreen:WhenSafePolicyNumber-inputEl"),
                         message = By.xpath(".//*[@id = 'PolicyFile_Summary:Policy_SummaryScreen:_msgs']/div[1]");
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
    public String getpolicyEffectiveDate()
    {
        return sh.getText(by.policyeffectivedate);
    }

    public String getCompletedPolicyTranComment()
    {
        return sh.getText(by.comment);
    }

    public void accept()
    {
        sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
        sh.clickElement(By.xpath(".//*[text()= 'OK']"));

    }
    public String getPendingPolicyTranEffecDate()
    {
        return sh.getText(by.pendingeffedate);
    }

    public String getPendingPolicyTranStatus()
    {
        return sh.getText(by.pendingstatus);
    }

    public String getPendingPolicyTranType()
    {
        return sh.getText(by.pendingtype);
    }

    public Summary clickwhensafepolicynumber()
    {
        sh.waitForNoMask();
        sh.clickElement(by.whensafepolicynumber);
        return this;
    }

    public String getSummaryMessage()
    {
        return sh.getText(by.message);
    }
}


