package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class NavigationBar<T extends NavigationBar> extends CenterPanelBase
{
    private NavigationBarBy by;

    public class NavigationBarBy
    {
        final private By navbar = By.cssSelector("[id='northPanel']"),
                         accountTab = By.id("TabBar:AccountTab");

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
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
        return (T)this;
    }
}
