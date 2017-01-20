package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by aansari on 11/21/16.
 */
public class Quote extends CenterPanelBase
{
	public WestPanelBase westPanel;
	protected String quoteBase;
	private QuoteBy by ;
	public Quote(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = setExpectedTitle();
		waitToBeQuoted(sh);
		setID(path);
		by = new QuoteBy();
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
	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				quoteBase = "SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:";
				break;
			case POLICYRENEWAL:
				quoteBase = "RenewalWizard:RenewalWizard_QuoteScreen:Quote_SummaryDV:";

		}
	}
	public class QuoteBy
	{
		By	totalPremium = By.id(quoteBase + "TotalPremium-inputEl"),
			annualizedTotalCost = By.id(quoteBase + "TotalAnnualCost-inputEl");


	}
	public int getTotalPremium()
	{
		return Integer.parseInt(sh.getText(by.totalPremium));
	}
	public String getAnnualizedTotalCost()
	{
		return sh.getText(by.annualizedTotalCost);
	}
	public RiskAnalysis back()
	{
		clickBack();
		return new RiskAnalysis(sh,path);
	}
}
