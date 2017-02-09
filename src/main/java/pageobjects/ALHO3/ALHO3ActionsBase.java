package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class ALHO3ActionsBase<T extends ALHO3ActionsBase>
{
	protected CenterSeleniumHelper sh;
	private ActionsBaseBy by = new ActionsBaseBy();
	static class ActionsBaseBy
    {
		public final By actions = By.cssSelector("#westPanel .x-btn-button"),
							   newSubmission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl");
	}

	public void clickActions()
	{
		sh.waitForNoMask();
		sh.clickElement(by.actions);
	}

	public T clickNewSubmission()
	{
		sh.clickElement(by.newSubmission);
		return (T)this;
	}
}