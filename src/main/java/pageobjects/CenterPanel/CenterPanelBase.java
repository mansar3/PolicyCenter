package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract public class CenterPanelBase
{
	protected CenterSeleniumHelper sh;
	protected String expectedPanelTitle = "Center Panel Base";
	private CenterPanelBy by;

	public static class CenterPanelBy{
		final static public By title = By.cssSelector("#centerPanel .g-title");
	}

	protected void clickNext()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
	}

	public String getTitle()
	{
		return sh.getText(CenterPanelBy.title);
	}

	public void waitForTitle(CenterSeleniumHelper sh)
	{
		sh.wait(5).until(ExpectedConditions.textToBe(CenterPanelBy.title, expectedPanelTitle));
	}
}