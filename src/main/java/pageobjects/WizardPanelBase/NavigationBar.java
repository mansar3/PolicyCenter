package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public abstract class NavigationBar<T extends NavigationBar> extends CenterPanelBase
{
    private NavigationBarBy by;

    public class NavigationBarBy
    {
        final private By navbar = By.cssSelector("[id='northPanel']"),
                         accountTab = By.id("TabBar:AccountTab"),
                         newAccount = By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"),
                         searchButton = By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"),
                    //     internalTools = By.id("InternalToolsTabBar:UnsupportedToolsTab-btnInnerEl"),
                         internalTools = By.id("InternalToolsTabBar:UnsupportedToolsTab-btnWrap"),
                         servertools = By.id("InternalToolsTabBar:ServerToolsTab-btnWrap"),
                         testingTimeClock = By.id("InternalToolsTabBar:UnsupportedToolsTab:UnsupportedTools_SystemClock-textEl"),
                         batchprocesstools = By.id("InternalToolsTabBar:ServerToolsTab:ServerTools_BatchProcessInfo-textEl"),
                         settings = By.id(":TabLinkMenuButton-btnIconEl"),
                         returnpolicycenter = By.id("InternalToolsTabBar:ReturnTabBarLink-itemEl"),
                         policytab = By.id("TabBar:PolicyTab"),
                         policylatestacc = By.id("TabBar:PolicyTab:0:PolicyMenuPolicy-textEl");


    }

    public NavigationBar(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new NavigationBarBy();
        sh.waitForElementToAppear(by.navbar);
    }

    public T clickAccountTab()
    {
        sh.waitForNoMask();
        sh.clickElement(by.accountTab);
        return (T)this;
    }

    public T clickNewAccountDropdown()
    {
    	sh.waitForNoMask();
        sh.clickRightOfElement(by.accountTab);
        sh.clickElement(by.newAccount);
        return (T)this;
    }

    public T clickPolicyTab()
    {
        sh.waitForNoMask();
        sh.clickElement(by.policytab);
        return (T) this;
    }

    public T clickLatestTran()
    {
        sh.waitForNoMask();
        sh.clickRightOfElement(by.policytab);
        sh.waitForNoMask();
        sh.clickElement(by.policylatestacc);
        return (T) this;
    }
    public T clickSearchAccountNavBar()
    {
        sh.waitForNoMask();
        sh.clickRightOfElement(by.accountTab);
        sh.clickElement(by.searchButton);
        return (T)this;
    }

    public T clickInternalToolTab()
    {
        //shift+alt+T
        Actions keyactions = new Actions(sh.driver);
        keyactions.keyDown(Keys.SHIFT).keyDown(Keys.ALT).sendKeys("T").keyUp(Keys.SHIFT).keyUp(Keys.ALT).perform();
        sh.clickElement(by.internalTools);
        return (T) this;
    }

    public T clickTestingTimeClock()
    {
        sh.waitForNoMask();
        sh.clickRightOfElement(by.internalTools);
        sh.clickElement(by.testingTimeClock);
        return (T) this;
    }

    public T clickServerTools()
    {
        sh.clickElement(by.servertools);
        return (T)this;
    }

    public T clickBatchProcessInfo()
    {
        sh.waitForNoMask();
        sh.clickRightOfElement(by.servertools);
        sh.clickElement(by.batchprocesstools);
        return (T) this;
    }

    public T clickSettings()
    {
        sh.waitForNoMask();
        sh.clickElement(by.settings);
        return (T) this;
    }

    public T clickReturntoPolicyCenter()
    {
        sh.waitForNoMask();
        sh.clickElement(by.returnpolicycenter);
        return (T) this;
    }
}
