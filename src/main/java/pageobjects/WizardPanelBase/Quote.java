package pageobjects.WizardPanelBase;

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
		waitToBeQuoted(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
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
