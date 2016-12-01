package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by aansari on 11/21/16.
 */
public class Quote extends CenterPanelBase
{
	public WestPanelBase westPanel;
	public Quote(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Quote";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
		westPanel = new WestPanelBase(sh);
	}
}
