package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CenterSeleniumHelper
{
	public WebDriver driver;
	public CheckboxHelper checkboxHelper = new CheckboxHelper();
	public CenterSeleniumHelper(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickElement(By byLocator)
	{
		wait(20).until(ExpectedConditions.elementToBeClickable(byLocator));
		driver.findElement(byLocator).click();
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
	public void setText(By byLocator, String text)
	{
		if(text != null)
			wait(25).until(ExpectedConditions.refreshed(driver1 ->
			{
				driver1.findElement(byLocator).sendKeys("");
				if(!driver1.findElement(byLocator).getAttribute("class").contains("focus"))
					return false;
				driver1.findElement(byLocator).clear();
				driver1.findElement(byLocator).sendKeys(text);
				return getValue(byLocator).equals(text);
			}));
	}

	public void waitForPageLoad()
	{
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public String getText(By byLocator)
	{
		return driver.findElement(byLocator).getText();
	}

	public String getValue(By byLocator)
	{
		return driver.findElement(byLocator).getAttribute("value");
	}

	public WebDriverWait wait(int time)
	{
		return new WebDriverWait(driver, time);
	}

	public CenterSeleniumHelper getURL(String url)
	{
		driver.get(url);
		waitForURLToContain(url, 20);
		return this;
	}

	public void waitForURLToContain(String expectedURL, int waitTime)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.urlContains(expectedURL));
	}

	public void waitForNoMask(int waitTime)
	{
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.numberOfElementsToBe(By.className("x-mask-fixed"), 0));
	}
	public void waitForNoMask()
	{
		new WebDriverWait(driver, 27).until(ExpectedConditions.numberOfElementsToBe(By.className("x-mask-fixed"), 0));
	}
	public void waitForValue(By bylocator, int waitTime)
	{
		(new WebDriverWait(driver, 25)).until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver d)
			{
				return d.findElement(bylocator).getAttribute("value").length() != 0;
			}

			@Override
			public String toString() {return String.format("No value for element: ('%s')",bylocator );}
		});
	}
	public CenterSeleniumHelper tab()
	{
		Actions tab = new Actions(driver);
		tab.sendKeys(Keys.TAB).perform();

		return this;
	}
	public boolean isDisplayed(By by)
	{
		List<WebElement> elements = driver.findElements(by);
		try
		{
			return !elements.isEmpty() && elements.get(0).isDisplayed();
		}
		catch(StaleElementReferenceException e)
		{
			return false;
		}
	}
	public void waitForElementToAppear(By by)
	{
		new WebDriverWait(driver, 45).until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver d)
			{
				return isDisplayed(by);
			}

			@Override
			public String toString()
			{
				return String.format("Element located by ('%s') is visible.", by);
			}

		});
	}
	public WebElement getElement(By by)
	{
		return driver.findElement(by);
	}
	public class CheckboxHelper
	{
		public boolean isChecked(By by)
		{
			return driver.findElement(by).isSelected();
		}

		public void checkElement(By by)
		{
			if (!getElement(by).isSelected())
			{
				clickElement(by);
			}

			//assert isChecked(by);
		}

		public void unCheckElement(By by)
		{
			if (getElement(by).isSelected())
			{
				clickElement(by);
			}

			assert !isChecked(by);
		}
	}
}