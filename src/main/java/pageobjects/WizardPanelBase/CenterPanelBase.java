package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.NorthPanel;

abstract public class CenterPanelBase
{
	protected CenterSeleniumHelper sh;
	protected String expectedPanelTitle = "Center Panel Base";
	private CenterPanelBy by = new CenterPanelBy();
	protected Path path = Path.SUBMISSION;
	protected String firstName, lastName;


	public enum Path
	{
		SUBMISSION, POLICYRENEWAL,
		POLICYCHANGE;
	}


	public static class CenterPanelBy{
		final static public By 	title = By.cssSelector("#centerPanel .g-title"),
								back = By.cssSelector("[id*='Prev-btnInnerEl']"),
								next = By.cssSelector("[id*='Next-btnInnerEl']"),
								quote = By.cssSelector("[id*='QuoteOrReview-btnInnerEl']"),
								saveDraft = By.cssSelector("[id*='Draft-btnInnerEl']"),
								closeOptions =  By.cssSelector("[id*='CloseOptions-btnInnerEl']"),
								withdrawTransaction = By.cssSelector("[id*='WithdrawJob-textEl']"),
								decline = By.cssSelector("[id*='Decline-textEl']"),
								notTaken = By.cssSelector("[id*='NotTakenJob-textEl']");

	}

	protected void clickNext()
	{
		sh.waitForNoMask();
		sh.clickElement(by.next);
	}
	protected void clickBack()
	{
		sh.clickElement(by.back);
	}
	
	protected void clickQuote()
	{
		sh.waitForNoMask();
		sh.clickElement(by.quote);
	}
	protected void clickSaveDraft()
	{
		sh.clickElement(by.saveDraft);
	}
	protected void clickWithdrawTransactions()
	{
		sh.clickElement(by.closeOptions);
		sh.waitForElementToAppear(by.withdrawTransaction);
		sh.clickElement(by.withdrawTransaction);
	}
	protected void clickDecline()
	{
		sh.clickElement(by.closeOptions);
		sh.waitForElementToAppear(by.decline);
		sh.clickElement(by.decline);

	}
	protected void clickNotTaken()
	{
		sh.clickElement(by.closeOptions);
		sh.waitForElementToAppear(by.notTaken);
		sh.clickElement(by.notTaken);
	}



	public String getTitle()
	{
		return sh.getText(by.title);
	}

	public void waitForTitle(CenterSeleniumHelper sh)
	{
		sh.wait(90).until(ExpectedConditions.textToBe(by.title, expectedPanelTitle));
	}
	public void waitForTitleToContain(CenterSeleniumHelper sh)
	{
		sh.waitForNoMask();
		(new WebDriverWait(sh.driver, 30)).until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver d)
			{
				return d.findElement(by.title).getText().contains(expectedPanelTitle);
			}

			@Override
			public String toString() {return String.format("Current page is not: %s ",expectedPanelTitle);}
		});
	}
	public void waitToBeQuoted(CenterSeleniumHelper sh)
	{
		sh.wait(180).until(ExpectedConditions.textToBe(by.title, expectedPanelTitle));
	}
}