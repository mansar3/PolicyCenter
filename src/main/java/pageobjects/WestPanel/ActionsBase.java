package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

abstract public class ActionsBase
{
	protected CenterSeleniumHelper sh;
	private ActionsBaseBy by;
	abstract static class ActionsBaseBy
	{
		public static final By actions = By.cssSelector("#westPanel .x-btn-button"),
				               newSubmission = By.id("AccountFile:AccountFileMenuActions:AccountFileMenuActions_Create:AccountFileMenuActions_NewSubmission-textEl"),
				               copySubmission = By.id("SubmissionWizard:WizardMenuActions:WizardMenuActions_Create:WizardMenuActions_CopySubmission-itemEl");
	}

	public void clickActions()
	{
		sh.waitForNoMask();
		sh.clickElement(by.actions);
	}

	public void clickNewSubmission()
	{
		sh.clickElement(by.newSubmission);
	}

	public void clickCopySubmission()
	{
		sh.clickElement(by.copySubmission);
	}
}