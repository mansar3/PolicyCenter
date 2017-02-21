package Helpers;

import junit.framework.Assert;
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
	public void setTextAndTab(By byLocator, String text)
	{

		if(text != null)
		{
			wait(50).until(ExpectedConditions.refreshed(driver1 ->
			{
				driver1.findElement(byLocator).sendKeys("");
				if(!driver1.findElement(byLocator).getAttribute("class").contains("focus"))
					return false;
				return true;

			}));
			driver.findElement(byLocator).sendKeys("");
			driver.findElement(byLocator).clear();
			driver.findElement(byLocator).sendKeys(text);
			tab();
			waitForNoMask();
			Assert.assertEquals("Expected value: '" +text+ "'\t Actual value: '" + getValue(byLocator) + "'",text, getValue(byLocator));

		}
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
		new WebDriverWait(driver, 70).until(ExpectedConditions.numberOfElementsToBe(By.className("x-mask-fixed"), 0));
	}
	public boolean isMaskPresent()
	{
		return isDisplayed(By.className("x-mask-fixed"));
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

	/**
	 * Waits until the value in the input box defined
	 * by 'by' matches 'val'
	 * @param by    locator for input field
	 * @param val   value to match
	 */
	public void waitForValueToBeVal(By by, String val)
	{
		new WebDriverWait(driver, 10).until( (WebDriver d) ->
		{
			try
			{
				String currentValue = d.findElement(by).getAttribute("value");
				return currentValue.equals(val);
			}
			catch (Exception e)
			{
				return false;
			}
		});
	}

	public void waitForValueToBeNotEmpty(By by)
	{
		new WebDriverWait(driver, 10).until( (WebDriver d) ->
		{
			try
			{
				String currentValue = driver.findElement(by).getText();
				return !currentValue.equals("");
			} catch (Exception e) {
				return false;
			}
		});
	}
	public WebElement getElement(By by)
	{
		return driver.findElement(by);
	}
	public List<WebElement> getElements(By by)
	{
		return driver.findElements(by);
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

	public void clickRightOfElement(By by)
	{
		WebElement actionTab = getElement(by);
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
	}

	public boolean isFieldMarkedRequired(By by)
	{
		return driver.findElement(by).findElement(By.xpath("../../../..")).getAttribute("class").contains("g-required");
	}

	public boolean isElementEnabled(By by)
	{
		return driver.findElement(by).isEnabled();
	}

	public boolean isElementEditable(By by)
	{
		return (driver.findElement(by).getTagName().equals("input") && driver.findElement(by).isEnabled());
	}
}