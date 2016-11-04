package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class PolicyInfo extends CenterPanelBase
{
	public PolicyInfo(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Policy Info";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
	}

	public Dwelling next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new Dwelling(sh);
	}
}