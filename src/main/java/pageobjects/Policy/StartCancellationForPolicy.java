package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;

/**
 * Created by ssai on 3/22/2017.
 */
public class StartCancellationForPolicy <T extends StartPolicyChange> extends PolicyBase {

    private StartCancellationForPolicyBy by;

    public StartCancellationForPolicy(CenterSeleniumHelper sh){

        this.sh = sh;
        westPanel = new WestPanel(sh, path);
        northPanel = new NorthPanel(sh);
        actions = new Actions(sh);
        by = new StartCancellationForPolicyBy();
        expectedPanelTitle = "Start Cancellation For Policy";
        //String actualTitle = sh.driver.getTitle();
       // sh.waitForTitle(expectedPanelTitle);
        System.out.println("Navigated to page: " + expectedPanelTitle);
    }

    public class StartCancellationForPolicyBy {

        public String policyCancelBase_Id = "StartCancellation:StartCancellationScreen:";

        public By

                startcancellation = By.id(policyCancelBase_Id + "NewCancellation-btnInnerEl"),
                clickcancel = By.id(policyCancelBase_Id + "Cancel-btnInnerEl"),
                setsource = By.id(policyCancelBase_Id + "CancelPolicyDV:Source-inputEl"),
                setreason = By.id(policyCancelBase_Id + "CancelPolicyDV:Reason-inputEl"),
                setreasondescription = By.id(policyCancelBase_Id + "CancelPolicyDV:ReasonDescription-inputEl"),
                getrefundmethod = By.id(policyCancelBase_Id + "CancelPolicyDV:CalcMethod-inputEl"),
                setcancellationeffectivedate = By.id(policyCancelBase_Id + "CancelPolicyDV:CancelDate_date-inputEl"),
                getcancellationeffectivedate = By.id(policyCancelBase_Id + "CancelPolicyDV:CancelDate_date-inputEl"),
                sourcelabelrequired = By.xpath(".//*[@id='StartCancellation:StartCancellationScreen:CancelPolicyDV:Source-labelEl']//span[text() = 'Source']/../..//input"),
                reasonlabelrequired = By.xpath(".//*[@id='StartCancellation:StartCancellationScreen:CancelPolicyDV:Reason-labelEl']//span[text() = 'Reason']/../..//input"),
                reasondescriptionlabelrequired = By.xpath(".//*[@id='StartCancellation:StartCancellationScreen:CancelPolicyDV:ReasonDescription-labelEl']//span[text() ='Reason Description']/../..//textarea"),
                cancelEffectivedatelabelrequired = By.xpath(".//*[@id='StartCancellation:StartCancellationScreen:CancelPolicyDV:CancelDate_date-labelEl']//span[text() ='Cancellation Effective Date']/../..//input");


    }

    public Confirmation clickStartCancellation()
    {
        sh.waitForNoMask();
         sh.clickElement(by.startcancellation);
         return  new Confirmation(sh);
    }

    public void clickCancel()
    {
        sh.waitForNoMask();
        sh.clickElement(by.clickcancel);
    }

    public StartCancellationForPolicy setSource(String source)
    {
        sh.waitForNoMask();
        sh.setText(by.setsource, source);
        return this;
    }

    public StartCancellationForPolicy setReason(String reason )
    {
        sh.waitForNoMask();
        sh.setText(by.setreason, reason);
        return this;
    }

    public StartCancellationForPolicy setReasonDescription(String description)
    {
        sh.waitForNoMask();
        sh.setText(by.setreasondescription, description);
        return this;
    }

    public String getRefundMethod()
    {
        sh.waitForNoMask();
      return  sh.getText(by.getrefundmethod);
    }

    public StartCancellationForPolicy setCancellationEffectiveDate(String date)
    {
        sh.waitForNoMask();
        sh.setText(by.setcancellationeffectivedate, date);
        sh.tab();
        return this;
    }

    public String getCancellationEffectiveDate()
    {
        sh.waitForNoMask();
        return  sh.getText(by.getcancellationeffectivedate);
    }


    public String getCancellationEffectiveDateEdi()
    {
        sh.waitForNoMask();
        return  sh.getValue(by.getcancellationeffectivedate);
    }

    public boolean isCancellationEffectiveDateEditable()
    {
        sh.waitForNoMask();
        return (sh.isElementEditable(by.setcancellationeffectivedate));
       /* {
//            System.out.println("The Cancellation Effective Date is editable");
            return true;

        }else{

//            System.out.println("The Cancellation Effective Date is not editable");
        return false;
    }*/
    }


    public boolean isRefundMethodEditable()
    {
        sh.waitForNoMask();
        return (sh.isElementEditable(by.getrefundmethod));
//        {
//            System.out.println("The Refund Method is editable");
//
//        }else{
//
//            System.out.println("The Refund Method is not editable");
//        }
//        return this;
    }
    public boolean isSourceLabelRequired()
    {
        return sh.isFieldMarkedRequired(by.sourcelabelrequired);
    }

    public boolean isReasonLabelRequired()
    {
        return sh.isFieldMarkedRequired(by.reasonlabelrequired);
    }

    public boolean isReasonDescriptionLabelRequired()
    {
        return sh.isFieldMarkedRequired(by.reasondescriptionlabelrequired);
    }

    public boolean isCancellationEffectiveDateLabelRequired()
    {
        return sh.isFieldMarkedRequired(by.cancelEffectivedatelabelrequired);
    }


}
