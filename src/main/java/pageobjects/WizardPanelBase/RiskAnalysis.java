package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract abstract class RiskAnalysis extends CenterPanelBase
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
		if(getTitle().equals("Risk Analysis"))
		{
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
	}
	public Quote qualifiesForAdditionalProtectionQuote()
	{
		warningQuote();
		sh.waitForNoMask();
		sh.waitForElementToAppear(By.className("warning_icon"));
		sh.clickElement(By.className("warning_icon"));
//		for(int i = 0; i < 5; i++)
//		{
//			if(sh.isDisplayed(By.className("warning_icon")) && (sh.isDisplayed(by.submissionQuote) || sh.isDisplayed(by.renewalQuote)))
//			{
//				warningQuote();
//				sh.waitForPageLoad();
//			}
//			else
//				break;
//		}
		return clickContingencies().quote();
	}
	public Contingencies clickContingencies()
	{
		sh.clickElement(by.contingencies);
		return new Contingencies(sh, path);
	}

	public UWActivity requestApproval()
	{
		sh.clickElement(by.requestApproval);
		sh.waitForNoMask();
		return new UWActivity(sh,path);
	}
	public CreateNewUWIssue addUWIssue()
	{
		sh.clickElement(by.addUWIssue);
		sh.waitForNoMask();
		return new CreateNewUWIssue(sh, path);

	}

	public class RiskAnalysisBy{

		public final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
							renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
							requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl"),
							addUWIssue = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:AddManualIssue-btnInnerEl"),

							contingencies = By.id(riskAnalysisBase + "RiskAnalysisCV:ContingenciesCardTab-btnInnerEl");
	}

	public class Contingencies extends CenterPanelBase
	{
		private ContingenciesBy by;
		public Contingencies(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new ContingenciesBy();
		}

		public class ContingenciesBy
		{
			public final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
							renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
							requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl");
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

	}
	public class CreateNewUWIssue extends CenterPanelBase
	{

		private CreateNewUWIssueBy by;
		public CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			expectedPanelTitle = "Create New UW Issue";
			waitForTitle(sh);
			by = new CreateNewUWIssueBy();

		}
		public class CreateNewUWIssueBy
		{
			final String 	buttonBase = "NewManualUWIssuePopup:",
							CNUIBase  = "WIssueDelegateDV:";

			final By 	issueType = By.id(CNUIBase + "IssueType-inputEl"),
						shortDescription = By.id(CNUIBase + "ShortDescription-inputEl"),
						longDescription = By.id(CNUIBase + "LongDescription-inputEl"),

						ok = By.id(buttonBase + "Update-btnInnerEl"),
						cancel = By.id(buttonBase + "Cancel-btnInnerEl"),

						returnToRiskAnalysis = By.id(buttonBase+ "__crumb__");


		}
		public String getIssueType()
		{
			return sh.getValue(by.issueType);
		}

		public CreateNewUWIssue setIssueType(String issueType)
		{
			sh.setText(by.issueType, issueType);
			sh.tab();
			sh.waitForNoMask();
			return this;
		}
		public String getShortDescription()
		{
			return sh.getValue(by.shortDescription);
		}

		public CreateNewUWIssue setShortDescription(String shortDescription)
		{
			sh.setText(by.shortDescription, shortDescription);
			sh.tab();
			//sh.waitForNoMask();
			return this;
		}
		public String getLongDescription()
		{
			return sh.getValue(by.longDescription);
		}

		public CreateNewUWIssue setLongDescription(String longDescription)
		{
			sh.setText(by.longDescription, longDescription);
			sh.tab();
			//sh.waitForNoMask();
			return this;
		}
		public RiskAnalysis clickOk()
		{
			sh.clickElement(by.ok);
			return new RiskAnalysis(sh, path);
		}
		public RiskAnalysis clickCancel()
		{
			sh.clickElement(by.cancel);
			return new RiskAnalysis(sh, path);
		}
		public RiskAnalysis clickReturnToRiskAnalysis()
		{
			sh.clickElement(by.returnToRiskAnalysis);
			return new RiskAnalysis(sh, path);
		}


	}
}