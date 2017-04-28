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

	public void waitForTitle(String expectedPanelTitle)
	{
		wait(90).until(ExpectedConditions.textToBe(By.cssSelector("#centerPanel .g-title"), expectedPanelTitle));
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
	public void setTextUntil(By byLocator, String text)
	{
		if(text != null)
			wait(25).until(ExpectedConditions.refreshed(driver1 ->
			{
				driver1.findElement(byLocator).sendKeys("");
				if(!driver1.findElement(byLocator).getAttribute("class").contains("focus"))
					return false;
				driver1.findElement(byLocator).clear();
				driver1.findElement(byLocator).sendKeys(text);
				return text.equals(getValue(byLocator) == null ? getText(byLocator) : getValue(byLocator));
			}));
		tab();
		waitForNoMask();
	}

	public void setTextAndTab(By byLocator, String text)
	{
		waitForNoMask();
		if(text != null)
		{
			wait(50).until(ExpectedConditions.refreshed(driver1 ->
			{
				driver1.findElement(byLocator).sendKeys("");
				if(!driver1.findElement(byLocator).getAttribute("class").contains("focus"))
					return false;
				driver.findElement(byLocator).clear();
				driver.findElement(byLocator).sendKeys(text);
				return true;

			}));

			try
			{
				Thread.sleep(5000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			tab();
			waitForNoMask();
			Assert.assertEquals(text, getValue(byLocator) == null ? getText(byLocator) : getValue(byLocator));

		}
	}

	public void selectFromDropDown(By by, String text)
	{
		clickElement(by);
		waitForNoMask();
		if(!isDisplayed(By.xpath("//li[text() = '" + text + "']")))
		{
			clickElement(by);
		}
		waitForNoMask();
		List<WebElement> list = driver.findElements(By.xpath("//li[text() = '" + text + "']"));
		for(WebElement we: list)
		{
			if(we.isDisplayed())
				we.click();

		}
//		clickElement(By.xpath("//li[text() = '" + text + "']"));
	}

	public boolean getItemsFromDropDown(By by, String item)
	{
		waitForElementToAppear(by);
		clickElement(by);
		for (WebElement element : driver.findElements(By.xpath("//ul/li")))
		{
			if (element.getText().equals(item))
				return true;
		}
		return false;
	}

	public void waitForPageLoad()
	{
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public String getText(By byLocator)
	{
		wait(20).until(ExpectedConditions.presenceOfElementLocated(byLocator));
		return driver.findElement(byLocator).getText();
	}

    /**
     * Gets value for locators pointing to an INPUT tag
     * @param byLocator locator
     * @return String contained in byLocator, if byLocator
     */
	public String getValue(By byLocator)
	{
		if (isDisplayed(byLocator))
			return driver.findElement(byLocator).getAttribute("value");
		else
			return "";
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
		new WebDriverWait(driver, 60).until(new ExpectedCondition<Boolean>()
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
			return isRadioButtonSelected(by);
		}

		public void checkElement(By by)
		{
			if (!isRadioButtonSelected(by))
			{
				waitForNoMask();
				clickElement(by);
			}
			tab();
			waitForNoMask();
			try
			{
				new WebDriverWait(driver,5).until(ExpectedConditions.refreshed(driver -> isRadioButtonSelected(by)));
			}
			catch(Exception e)
			{
				waitForNoMask();
				clickElement(by);
			}
//			// Added because sometimes it takes two clicks to check
//			// an element.
//			if (!isRadioButtonSelected(by))
//			{
//				waitForNoMask();
//				clickElement(by);
//			}

			assert isChecked(by);
		}

		public void unCheckElement(By by)
		{
			if (isRadioButtonSelected(by))
			{
				waitForNoMask();
				clickElement(by);
			}
			tab();
			waitForNoMask();
			// Added because sometimes it takes two clicks
			// to uncheck an element.
			if (isRadioButtonSelected(by))
			{
				waitForNoMask();
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
		return driver.findElement(by).findElement(By.xpath("../../../..")).getAttribute("class").contains("g-required")
				|| driver.findElement(by).findElement(By.xpath("../..")).getAttribute("class").contains("g-required");
	}

	public boolean yesOrNoSelected(By by)
	{
		boolean yesButton = driver.findElement(by).findElement(By.xpath("../..//label[text()='Yes']")).findElement(By.xpath("../../..")).getAttribute("class").contains("x-form-cb-checked");
		boolean noButton = driver.findElement(by).findElement(By.xpath("../..//label[text()='No']")).findElement(By.xpath("../../..")).getAttribute("class").contains("x-form-cb-checked");
		if (yesButton && noButton)
			throw new WebDriverException("Both 'Yes' and 'No' button were selected");
		else if (!yesButton && !noButton)
			throw new WebDriverException("Neither 'Yes' or 'No' button were selected");
		return yesButton;
	}

	public boolean isElementEnabled(By by)
	{
		return driver.findElement(by).isEnabled();
	}

	public boolean isElementEditable(By by)
	{
		return (driver.findElement(by).getTagName().equals("input") && driver.findElement(by).isEnabled());
	}

	/**
	 * Verifies if checkbox/radio button is checked
	 * @param by Locator for the checkbox/radio button itself
	 */
	public boolean isRadioButtonSelected(By by)
	{
		return driver.findElement(by).findElement(By.xpath("../../..")).getAttribute("class").contains("x-form-cb-checked");
	}
}