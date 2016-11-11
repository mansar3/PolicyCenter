package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

public class RiskAnalysis extends CenterPanelBase
{
	private RiskAnalysisBy by;
	public RiskAnalysis(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Risk Analysis";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
	}

	public void quote()
	{
		sh.clickElement(by.quote);
	}

	public static class RiskAnalysisBy{
		public static final By	quote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl");
	}
}