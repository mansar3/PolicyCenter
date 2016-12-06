package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by aansari on 11/21/16.
 */
public class Quote extends CenterPanelBase
{
	public WestPanelBase westPanel;
	public Quote(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = setExpectedTitle();
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
		westPanel = new WestPanelBase(sh);
	}
	private String setExpectedTitle()
	{
		switch(path)
		{
			case POLICYRENEWAL:
				return "View Quote";

				default:
				return "Quote";
		}
	}
	public RiskAnalysis back()
	{
		clickBack();
		return new RiskAnalysis(sh,path);
	}
}
