package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class WestPanelBase
{
	protected CenterSeleniumHelper sh;
	private WestPanelBaseBy by;

	public WestPanelBase(CenterSeleniumHelper sh)
	{
		this.sh = sh;

	}

	public class WestPanelBaseBy
	{
		final By  riskAnalysis = By.xpath(".//*[text()= 'Risk Analysis']");
	}


}