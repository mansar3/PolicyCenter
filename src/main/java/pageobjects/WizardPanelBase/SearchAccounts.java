package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WestPanel.AccountFileSummaryWestPanel;

public class SearchAccounts<T extends SearchAccounts> extends CenterPanelBase
{

    private SearchAccountsBy by = new SearchAccountsBy();
    private AccountFileSummaryWestPanel westPanel;

    public SearchAccounts(CenterSeleniumHelper sh)
    {
        this.sh = sh;
        expectedPanelTitle = "Search Accounts";
        waitForTitle(sh);
        System.out.println("Navigated to page: " + expectedPanelTitle);
        westPanel = new AccountFileSummaryWestPanel(sh);
    }
    public class SearchAccountsBy extends CenterPanelBy
    {
        final By _firstname = By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:GlobalPersonNameInputSet:FirstName-inputEl"),
                 _lastname = By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:GlobalPersonNameInputSet:LastName-inputEl"),
                 searchButton = By.id("AccountSearch:AccountSearchScreen:AccountSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search"),
                 accountNumber = By.id("AccountSearch:AccountSearchScreen:AccountSearchResultsLV:0:AccountNumber");
    }

    protected T setFirstName(String firstname)
    {
        sh.getElement(by._firstname).sendKeys(firstname);
        return (T)this;
    }

    protected T setLastName(String lastname)
    {
        sh.getElement(by._lastname).sendKeys(lastname);
        return (T)this;
    }

    protected T clickSearchButton()
    {
        sh.waitForNoMask(5);
        sh.getElement(by.searchButton).click();
        return (T)this;
    }

    protected T selectFirstAccountNumber()
    {
        sh.waitForNoMask();
        sh.clickElement(by.accountNumber);
        return (T)this;
    }
}
