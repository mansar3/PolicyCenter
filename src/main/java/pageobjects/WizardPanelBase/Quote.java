package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by aansari on 11/21/16.
 */
public abstract class Quote extends CenterPanelBase
{
	public WestPanelBase westPanel;
	protected String quoteBase, errorBase;
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
				quoteBase = "RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:Quote_SummaryDV:";
				errorBase = "RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:";

		}
	}
	public class QuoteBy
	{
		By	totalPremium = By.id(quoteBase + "TotalPremium-inputEl"),
			annualizedTotalCost = By.id(quoteBase + "TotalAnnualCost-inputEl"),
			annualizedTotalCostIncludingWhenSafe = By.id(quoteBase + "TotalAnnualCostPlusWhenSafe-inputEl"),
			underWritingApprovalError = By.id(errorBase + "WarningsPanelSet:0:PanelSet:Warning");


	}
	public int getTotalPremium()
	{
		return Integer.parseInt(sh.getText(by.totalPremium));
	}
	public String getAnnualizedTotalCost()
	{
		return sh.getText(by.annualizedTotalCost);
	}
	public String getAnnualizedTotalCostIncludingWhenSafe()
	{
		return sh.getText(by.annualizedTotalCostIncludingWhenSafe);
	}
	public RiskAnalysis backToRiskAnalysis()
	{
		clickBack();
		return new RiskAnalysis(sh,path);
	}
	public PolicyReview backToPolicyReview()
	{
		clickBack();
		return new PolicyReview(sh,path);
	}
	public boolean isUnderWritingApprovalNeeded()
	{
		String message = "This quote will require underwriting approval prior to binding.";
		if(sh.isDisplayed(by.underWritingApprovalError) && sh.getText(by.underWritingApprovalError).equals(message))
			return true;
		return false;
	}
}
