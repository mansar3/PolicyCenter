package pageobjects.Policy;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.CenterPanelBase;


/**
 * Created by ssai on 3/20/2017.
 */
abstract class PolicyBase {

    protected CenterSeleniumHelper sh;
    public WestPanel westPanel;
    public NorthPanel northPanel;
    public Actions actions;
    protected String expectedPanelTitle = "Policy Base";
    protected CenterPanelBase.Path path = CenterPanelBase.Path.POLICYCHANGE;

    public class WestPanel extends PolicyBase
    {
        public Actions actions;
        private WestPanelBy by;
        public WestPanel(CenterSeleniumHelper sh, CenterPanelBase.Path path)
        {
            this.sh = sh;
            this.path = path;
            by = new WestPanelBy();
        }
        public class WestPanelBy
        {
            //By
        }
        // Setters and getters
    }
    public class Actions extends PolicyBase
    {
        private ActionsBy by;
        public Actions(CenterSeleniumHelper sh)
        {
            this.sh = sh;
            by = new ActionsBy();
        }
        public class ActionsBy
        {
            //By

            public  By  actions = By.id("PolicyFile:PolicyFileMenuActions-btnInnerEl"),
                    changepolicy = By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_ChangePolicy-textEl"),
                    cancelpolicy = By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_CancelPolicy-textEl"),
                    renewpolicy = By.id("PolicyFile:PolicyFileMenuActions:PolicyFileMenuActions_NewWorkOrder:PolicyFileMenuActions_RenewPolicy-textEl");

        }
        // Setters and getters
        private void clickActions()
        {
            sh.waitForNoMask();
            sh.clickElement(by.actions);
        }
        public StartPolicyChange clickChangePolicy()
        {
            sh.waitForNoMask();
            clickActions();
            sh.clickElement(by.changepolicy);
            return  new StartPolicyChange(sh);

        }

        public void clickCancelPolicy()
        {
            sh.waitForNoMask();
            clickActions();
            sh.clickElement(by.cancelpolicy);

        }

        public void clickRenewPolicy()
        {
            sh.waitForNoMask();
            clickActions();
            sh.clickElement(by.renewpolicy);
        }


    }
}
