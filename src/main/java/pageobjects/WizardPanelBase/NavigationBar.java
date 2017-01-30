package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar extends CenterPanelBase
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

    public NavigationBar clickAccountTab()
    {
        sh.clickElement(by.accountTab);
        return this;
    }

    public NavigationBar clickNewAccountDropdown()
    {
        sh.clickRightOfElement(by.accountTab);
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
        return this;
    }
}
