package pageobjects;

import Helpers.CenterSeleniumHelper;

/**
 * Created by aansari on 3/7/17.
 */
public class NorthPanel
{
	protected  CenterSeleniumHelper sh;
	private NorthPanelBy by;
	public NorthPanel(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new NorthPanelBy();
	}
	public class NorthPanelBy
	{
			// Add locators here;
	}
	// setters and getters

}
