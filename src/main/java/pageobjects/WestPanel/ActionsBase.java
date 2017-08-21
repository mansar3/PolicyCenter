package pageobjects.WestPanel;

import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.CenterPanelBase;

abstract public class ActionsBase extends CenterPanelBase
{

	public ActionsBaseBy by = new ActionsBaseBy();
	public class ActionsBaseBy
	{
		public final By actions = By.cssSelector("#westPanel .x-btn-button"),
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