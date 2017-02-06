package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class RiskAnalysis<T extends RiskAnalysis> extends CenterPanelBase
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

	protected T riskAnalysisQuote()
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
		return (T)this;
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
	protected T raQualifiesForAdditionalProtectionQuote()
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
		riskAnalysisClickContingencies().riskAnalysisQuote();
		return (T)this;
	}
	protected T riskAnalysisClickContingencies()
	{
		sh.clickElement(by.contingencies);
		return (T)this;
	}

	protected T requestApproval()
	{
		sh.clickElement(by.requestApproval);
		sh.waitForNoMask();
		return (T)this;
	}
	protected T riskAnalysisAddUWIssue()
	{
		sh.clickElement(by.addUWIssue);
		sh.waitForNoMask();
		return (T)this;

	}

	protected class RiskAnalysisBy{

		protected final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
							renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
							requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl"),
							addUWIssue = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:AddManualIssue-btnInnerEl"),

							contingencies = By.id(riskAnalysisBase + "RiskAnalysisCV:ContingenciesCardTab-btnInnerEl");
	}

	protected class Contingencies<T extends Contingencies> extends CenterPanelBase
	{
		private ContingenciesBy by;
		protected Contingencies(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new ContingenciesBy();
		}

		protected class ContingenciesBy
		{
			protected final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
							renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
							requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl");
		}
		protected T quote()
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
			return (T)this;
		}

	}
	protected class CreateNewUWIssue<T extends CreateNewUWIssue> extends CenterPanelBase
	{

		private CreateNewUWIssueBy by;
		protected CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			expectedPanelTitle = "Create New UW Issue";
			waitForTitle(sh);
			by = new CreateNewUWIssueBy();

		}
		protected class CreateNewUWIssueBy
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
		protected String getIssueType()
		{
			return sh.getValue(by.issueType);
		}

		protected T setIssueType(String issueType)
		{
			sh.setText(by.issueType, issueType);
			sh.tab();
			sh.waitForNoMask();
			return (T)this;
		}
		protected String getShortDescription()
		{
			return sh.getValue(by.shortDescription);
		}

		protected T setShortDescription(String shortDescription)
		{
			sh.setText(by.shortDescription, shortDescription);
			sh.tab();
			//sh.waitForNoMask();
			return (T)this;
		}
		protected String getLongDescription()
		{
			return sh.getValue(by.longDescription);
		}

		protected T setLongDescription(String longDescription)
		{
			sh.setText(by.longDescription, longDescription);
			sh.tab();
			//sh.waitForNoMask();
			return (T)this;
		}
		protected T clickOk()
		{
			sh.clickElement(by.ok);
			return (T)this;
		}
		protected T clickCancel()
		{
			sh.clickElement(by.cancel);
			return (T)this;
		}
		protected T clickReturnToRiskAnalysis()
		{
			sh.clickElement(by.returnToRiskAnalysis);
			return (T)this;
		}


	}
}