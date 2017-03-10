package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/21/16.
 */
public abstract class UWActivity<T extends UWActivity> extends CenterPanelBase
{
	private UWActivityBy by;
	public UWActivity(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "UW Activity";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}


	static class UWActivityBy
	{
		final  static By	sendRequest = By.id("UWActivityPopup:Update-btnInnerEl"),
				        getAssignTo = By.id("UWActivityPopup:NewActivityDV:SelectFromList-inputEl"),
		                Cancel = By.id("UWActivityPopup:Cancel-btnInnerEl"),
		                description = By.id("UWActivityPopup:NewActivityDV:Description-inputEl");
	}

	public String getAssignTo(){
		return sh.getValue(by.getAssignTo);
	}
	public String getDescription() { return sh.getValue(by.description);}

	public T clickSendRequest()
	{
		sh.getValue(by.sendRequest);
		return (T)this;
	}
	public  T clickcancel()
	{
		sh.waitForNoMask();
		sh.clickElement(by.Cancel);
		return (T) this;
	}

}
