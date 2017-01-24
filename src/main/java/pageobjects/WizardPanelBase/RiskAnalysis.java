package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class RiskAnalysis extends CenterPanelBase
{
	private RiskAnalysisBy by;
	protected String riskAnalysisBase;
	public RiskAnalysis(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Risk Analysis";
		waitForTitle(sh);
		setID(path);
		by = new RiskAnalysisBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				this.riskAnalysisBase = "SubmissionWizard:Job_RiskAnalysisScreen:";
				break;
			case POLICYRENEWAL:
				this.riskAnalysisBase = "RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:";
				break;
			case POLICYCHANGE:
				//this.dwellingBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				break;

		}
	}

	public Quote quote()
	{
		sh.waitForNoMask();
		switch(path)
		{
			case SUBMISSION:
				sh.clickElement(by.submissionQuote);
				break;
			case POLICYRENEWAL:
				sh.clickElement(by.renewalQuote);
				break;
		}
		//sh.clickElement(by.submissionQuote);
		//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
		return new Quote(sh,path);
	}
	private void warningQuote()
	{
		sh.waitForNoMask();
		switch(path)
		{
			case SUBMISSION:
				sh.clickElement(by.submissionQuote);
				break;
			case POLICYRENEWAL:
				sh.clickElement(by.renewalQuote);
				break;
		}
	}
	public Quote qualifiesForAdditionalProtectionQuote()
	{
		warningQuote();
		sh.waitForNoMask();
		sh.waitForElementToAppear(By.className("warning_icon"));
		sh.waitForPageLoad();
		warningQuote();

		return new Quote(sh,path);
	}
	public UWActivity requestApproval()
	{
		sh.clickElement(by.requestApproval);
		return new UWActivity(sh,path);
	}

	public class RiskAnalysisBy{

		public final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
							renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
							requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl");
	}
}