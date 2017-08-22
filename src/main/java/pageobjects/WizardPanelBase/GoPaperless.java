package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 4/10/17.
 */
public class GoPaperless<T extends CenterPanelBase> extends CenterPanelBase
{
	private GoPaperlessBy by;
	protected String gpBase;
	public GoPaperless(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Go Paperless";
		waitForTitle(sh);
		setID(path);
		by = new GoPaperlessBy();
		log("Navigated to page: " + expectedPanelTitle);
	}
	private void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				gpBase = "SubmissionWizard:JobWizardToolsMenuWizardStepSet:";
				break;
			case POLICYRENEWAL:
				gpBase = "RenewalWizard:JobWizardToolsMenuWizardStepSet:";
		}
	}

	public class GoPaperlessBy
	{
		String pageBase = "EditGoPaperless_fliPopup:";
		By	edit = By.id(gpBase + "GoPaperless_fliScreen:UpdateButton-btnInnerEl"),
			paperless = By.id(pageBase + "IsPaperless_fli-inputEl"),
			emailAddress = By.id(pageBase  + "PaperlessEmailAddress_fli-inputEl"),
			confirmEmailAddress   = By.id(pageBase + "ConfirmPaperlessEmailAddress_fli-inputEl"),

			cancel = By.id(pageBase + "Cancel-btnInnerEl"),
			update = By.id(pageBase + "UpdateButton-btnInnerEl");



	}
	public T clickEdit()
	{
		sh.clickElement(by.edit);
		sh.waitForNoMask();
		return (T)this;
	}
	public boolean isEditButtonDisplayed()
	{
		return sh.isDisplayed(by.edit);
	}
	public String getEmailAddress()
	{
		return sh.getValue(by.emailAddress);
	}
	public T checkPaperless()
	{
		sh.checkboxHelper.checkElement(by.paperless);
		sh.waitForNoMask();
		return (T)this;
	}
	public T unCheckPaperless()
	{
		sh.checkboxHelper.unCheckElement(by.paperless);
		sh.waitForNoMask();
		return (T)this;
	}
	public boolean isPaperlessChecked()
	{
		return sh.checkboxHelper.isChecked(by.paperless);
	}

	public GoPaperless setEmailAddress(String emailAddress)
	{
		sh.setText(by.emailAddress, emailAddress);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getConfirmEmailAddress()
	{
		return sh.getValue(by.confirmEmailAddress);
	}

	public GoPaperless setConfirmEmailAddress(String confirmEmailAddress)
	{
		sh.setText(by.confirmEmailAddress, confirmEmailAddress);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public GoPaperless clickCancel()
	{
		sh.clickElement(by.cancel);
		sh.waitForNoMask();
		return this;
	}
	public GoPaperless clickUpdate()
	{
		sh.clickElement(by.update);
		sh.waitForNoMask();
		return this;
	}



}
