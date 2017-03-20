package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.PolicyInfo;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by ssai on 3/20/2017.
 */
public class StartPolicyChange extends PolicyBase {

    private StartPolicyChangeBy by;

    public StartPolicyChange(CenterSeleniumHelper sh) {
        this.sh = sh;
        westPanel = new WestPanel(sh);
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
                cancel = By.id(policyChangeBase_id + "Cancel-btnInnerEl");


    }


    // setters and getters
    public void next() {
        sh.waitForNoMask();
        sh.clickElement(by.next);

    }



    public List<String> getTextInReasonList()
    {
        sh.clickElement(by.reason);
//        Select select = new Select(sh.getElement(By.xpath("//ul")));
//        List<WebElement> list = select.getOptions();
        List<WebElement> list = sh.getElements(By.xpath("//li"));
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
}
