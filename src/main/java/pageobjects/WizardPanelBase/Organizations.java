package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class Organizations<T extends Organizations> extends CenterPanelBase
{
    private OrganizationsBy by;

    public class OrganizationsBy extends CenterPanelBase.CenterPanelBy
    {
        final By organizationName = By.cssSelector("input[id='OrganizationSearchPopup:"
                + "OrganizationSearchPopupScreen:OrganizationSearchDV:GlobalContactNameInputSet:Name-inputEl']"),
                organizationType = By.cssSelector("[id='OrganizationSearchPopup:OrganizationSearchPopupScreen:"
                + "OrganizationSearchDV:Type-inputEl']"),
                searchButton = By.cssSelector("[id='OrganizationSearchPopup:OrganizationSearchPopupScreen:"
                + "OrganizationSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search']"),
                organizationSearchResult = By.cssSelector("a[id='OrganizationSearchPopup:"
                + "OrganizationSearchPopupScreen:OrganizationSearchResultsLV:0:_Select']");
    }

    public enum OrganizationTypes
    {
        AGENCY("Agency"),
        BROKER("Broker"),
        INSURER("Insurer"),
        MGA("Managing general agent");

        public String value;
        OrganizationTypes(String value)
        {
            this.value = value;
        }
    }

    public Organizations(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        by = new OrganizationsBy();
        expectedPanelTitle = "Organizations";
        waitForTitle(sh);
    }

    public T setOrganizationName(String name)
    {
        sh.setText(by.organizationName, name);
        sh.tab();
        return (T)this;
    }

    public T setOrganizationType(String type)
    {
        sh.setText(by.organizationType, type);
        sh.tab();
        return (T)this;
    }

    public T clickSearchButton()
    {
    	sh.waitForNoMask();
        sh.clickElement(by.searchButton);
        sh.waitForNoMask();
        return (T)this;
    }

    public T selectOrganizationButton()
    {
        sh.waitForElementToAppear(by.organizationSearchResult);
        sh.waitForNoMask();
        sh.clickElement(by.organizationSearchResult);
        return (T)this;
    }
}
