package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

abstract public class ActionsBase
{
	protected CenterSeleniumHelper sh;
	private ActionsBaseBy by;
	abstract static class ActionsBaseBy{
		public static final By actions = By.cssSelector("#westPanel .x-btn-button");
	}

	public void clickActions()
	{
		sh.waitForNoMask(5);
		sh.clickElement(by.actions);
	}
}