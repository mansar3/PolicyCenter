package pageobjects.WizardPanelBase;


import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class CenterPanelBase
{
	protected CenterSeleniumHelper sh;
	protected String expectedPanelTitle = "Center Panel Base";
	private CenterPanelBy by = new CenterPanelBy();
	protected Path path = Path.SUBMISSION;
	protected String firstName, lastName;
	public WestPanel westPanel;


	public enum Path
	{
		SUBMISSION, POLICYRENEWAL,
		POLICYCHANGE, POLICYCANCEL;
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
								notTaken = By.cssSelector("[id*='NotTakenJob-textEl']"),
		                        centerPanel = By.id("centerPanel");

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
		sh.waitForNoMask();
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
	public void waitForContent(CenterSeleniumHelper sh)
	{
		sh.wait(20).until(ExpectedConditions.visibilityOfElementLocated(by.centerPanel));
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
	public static class WestPanel<T extends CenterPanelBase> extends CenterPanelBase
	{

		private WestPanelBy by;
		public WestPanel(CenterSeleniumHelper sh)
		{
			this.sh = sh;
			by = new WestPanelBy();
		}
		public WestPanel(CenterSeleniumHelper sh,Path path)
		{
			this.sh = sh;
			this.path = path;
			by = new WestPanelBy();
		}
		public class WestPanelBy
		{
			String 	preString = ".//*[@id='westPanel']//span[text()='",
					postString = "']";

			By	goPaperless = By.xpath(preString + "Go Paperless" + postString),
				viewQuote = By.xpath(preString + "View Quote" + postString);
		}
		protected T clickGoPaperless()
		{
			sh.waitForNoMask();
			sh.clickElement(by.goPaperless);
			return (T)this;
		}
		protected T clickViewQuote()
		{
			sh.waitForNoMask();
			sh.clickElement(by.viewQuote);
			return (T)this;
		}


	}
}