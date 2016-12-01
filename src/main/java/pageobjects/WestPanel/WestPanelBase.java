package pageobjects.WestPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.CenterPanel.RiskAnalysis;

public class WestPanelBase
{
	protected CenterSeleniumHelper sh;
	private WestPanelBaseBy by;
	public WestPanelBase(CenterSeleniumHelper sh)
	{
		this.sh = sh;
	}

	static class WestPanelBaseBy
	{
		static final By  riskAnalysis = By.xpath(".//*[text()= 'Risk Analysis']");
	}

	public RiskAnalysis clickRiskAnalysis()
	{
		sh.waitForNoMask();
		sh.clickElement(by.riskAnalysis);
		return new RiskAnalysis(sh);
	}
}