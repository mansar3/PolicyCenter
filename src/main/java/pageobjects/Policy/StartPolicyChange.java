package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.PolicyInfo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ssai on 3/20/2017.
 */
public class StartPolicyChange <T extends StartPolicyChange> extends PolicyBase {

    private StartPolicyChangeBy by;

    public StartPolicyChange(CenterSeleniumHelper sh) {
        this.sh = sh;
        westPanel = new WestPanel(sh, path);
        northPanel = new NorthPanel(sh);
        actions = new Actions(sh);
        by = new StartPolicyChangeBy();
        expectedPanelTitle = "Start Policy Change";
        sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);

    }

    public class StartPolicyChangeBy {
        // By
        private String policyChangeBase_id = "StartPolicyChange:StartPolicyChangeScreen:";


        public By next = By.id(policyChangeBase_id + "NewPolicyChange-btnInnerEl"),
                effectivedate = By.id(policyChangeBase_id + "StartPolicyChangeDV:EffectiveDate_date-inputEl"),
                reason = By.id(policyChangeBase_id + "StartPolicyChangeDV:reason-inputEl"),
                cancel = By.id(policyChangeBase_id + "Cancel-btnInnerEl"),
                dropdownlist = By.xpath("//li"),
                reasonlabel = By.xpath(".//*[@id='StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:reason-labelEl']/span"),
                date = By.id("StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:EffectiveDate_date-inputEl"),
                effectivedatelabel = By.xpath(".//*[@id='StartPolicyChange:StartPolicyChangeScreen:StartPolicyChangeDV:EffectiveDate_date-labelEl']/span");


    }


    // setters and getters
    public void next() {
        sh.waitForNoMask();
        sh.clickElement(by.next);

    }

    protected T accept()
    {
        sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
        sh.clickElement(By.xpath(".//*[text()= 'OK']"));
        return (T) this;
    }

    public List<String> getTextInReasonList()
    {

        sh.clickElement(by.reason);
        sh.waitForNoMask();
//        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(by.reason));

//        Select select = new Select(sh.getElement(By.xpath("//ul")));
//        List<WebElement> list = select.getOptions();
        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(by.dropdownlist));
        List<WebElement> list = sh.getElements(By.xpath("//li"));
        sh.waitForNoMask();
        List<String> listText = null;
        return  list.stream().map(WebElement::getText).collect(Collectors.toList());

//        for(WebElement lst: list)
//            listText.add(lst.getText());
//        return listText;
    }

    public StartPolicyChange setEffectiveDate(String effectiveDate)
    {
        sh.waitForNoMask();
        sh.setText(by.effectivedate, effectiveDate);
        return  this;
    }

    public StartPolicyChange setReason(String reason){
        sh.waitForNoMask();
        sh.setText(by.reason, reason);
        return this;
    }

     public String getReasonLabel(){
        sh.waitForNoMask();
     return  sh.getText(by.reasonlabel);

     }

    public String getEffectiveDateLabel(){
        sh.waitForNoMask();
        return  sh.getText(by.effectivedatelabel);

    }

     public String getSPCDate(){
         sh.waitForNoMask();
         return sh.getValue(by.date);
     }

}
