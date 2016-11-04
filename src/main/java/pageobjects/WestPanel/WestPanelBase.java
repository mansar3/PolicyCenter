package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.WebDriver;

abstract public class WestPanelBase
{
	protected CenterSeleniumHelper sh;

	public WestPanelBase(CenterSeleniumHelper sh)
	{
		this.sh = sh;
	}
}