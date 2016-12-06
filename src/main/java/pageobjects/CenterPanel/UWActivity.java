package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/21/16.
 */
public class UWActivity extends CenterPanelBase
{
	private UWActivityBy by;
	public UWActivity(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "UW Activity";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
	}

	static class UWActivityBy
	{
		final static By	sendRequest = By.id("UWActivityPopup:Update-btnInnerEl");
	}

	public RiskAnalysis sendRequest()
	{
		sh.clickElement(by.sendRequest);
		return new RiskAnalysis(sh,path);
	}

}
