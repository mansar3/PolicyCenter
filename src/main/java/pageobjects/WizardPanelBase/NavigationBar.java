package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class NavigationBar<T extends NavigationBar> extends CenterPanelBase
{
    private NavigationBarBy by;

    public class NavigationBarBy
    {
        final private By navbar = By.cssSelector("[id='northPanel']"),
                         accountTab = By.id("TabBar:AccountTab"),
                         newAccount = By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"),
                         searchButton = By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button");
    }

    public NavigationBar(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new NavigationBarBy();
        sh.waitForElementToAppear(by.navbar);
    }

    public T clickAccountTab()
    {
        sh.clickElement(by.accountTab);
        return (T)this;
    }

    public T clickNewAccountDropdown()
    {
        sh.clickRightOfElement(by.accountTab);
        sh.clickElement(by.newAccount);
        return (T)this;
    }

    public T clickSearchAccountNavBar()
    {
        sh.clickRightOfElement(by.accountTab);
        sh.clickElement(by.searchButton);
        return (T)this;
    }
}
