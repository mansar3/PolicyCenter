package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenterSeleniumHelper
{
	public WebDriver driver;
	public CenterSeleniumHelper(WebDriver driver)
	{
		this.driver = driver;
	}

	public void clickElement(By byLocator)
	{
		wait(5).until(ExpectedConditions.elementToBeClickable(byLocator));
		driver.findElement(byLocator).click();
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
	public void setText(By byLocator, String text)
	{
		wait(5).until(ExpectedConditions.refreshed(driver1 -> {
			driver1.findElement(byLocator).sendKeys("");
			if(!driver1.findElement(byLocator).getAttribute("class").contains("focus"))
				return false;
			driver1.findElement(byLocator).clear();
			driver1.findElement(byLocator).sendKeys(text);
			return getValue(byLocator).equals(text);
		}));
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
	public CenterSeleniumHelper tab()
	{
		Actions tab = new Actions(driver);
		tab.sendKeys(Keys.TAB).perform();

		return this;
	}
}