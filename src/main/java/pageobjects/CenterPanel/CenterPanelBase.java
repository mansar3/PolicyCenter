package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract public class CenterPanelBase
{
	protected CenterSeleniumHelper sh;
	protected String expectedPanelTitle = "Center Panel Base";
	protected String address;
	private CenterPanelBy by;
	protected Path path = Path.SUBMISSION;


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
		sh.waitForNoMask(10);
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
		return sh.getText(CenterPanelBy.title);
	}

	public void waitForTitle(CenterSeleniumHelper sh)
	{
		sh.wait(45).until(ExpectedConditions.textToBe(CenterPanelBy.title, expectedPanelTitle));
	}
}