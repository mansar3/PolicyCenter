package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.Quote;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3RiskAnalysis extends RiskAnalysis<FLHO3RiskAnalysis>
{
	public FLHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3Quote quote()
	{
		super.quote();
		return new FLHO3Quote(sh,path);
	}

	public void warningQuote()
	{
		super.warningQuote();
	}
	public FLHO3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.qualifiesForAdditionalProtectionQuote();
		return clickContingencies().quote();
	}
	public RiskAnalysis.Contingencies clickContingencies()
	{
		sh.clickElement(by.contingencies);
		return new RiskAnalysis.Contingencies(sh, path);
	}

	public T requestApproval()
	{
		sh.clickElement(by.requestApproval);
		sh.waitForNoMask();
		return (T)this;
	}
	public RiskAnalysis.CreateNewUWIssue addUWIssue()
	{
		sh.clickElement(by.addUWIssue);
		sh.waitForNoMask();
		return new RiskAnalysis.CreateNewUWIssue(sh, path);

	}

	public class FLHO3RiskAnalysisBy{

		public final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
				renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
				requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl"),
				addUWIssue = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:AddManualIssue-btnInnerEl"),

		contingencies = By.id(riskAnalysisBase + "RiskAnalysisCV:ContingenciesCardTab-btnInnerEl");
	}

	public class FLHO3Contingencies extends Contingencies<FLHO3Contingencies>
	{
		private RiskAnalysis.Contingencies.ContingenciesBy by;
		public FLHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new FLHO3RiskAnalysis.FLHO3Contingencies.FLHO3ContingenciesBy();
		}

		public class FLHO3ContingenciesBy
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
	public class FLHO3CreateNewUWIssue extends CreateNewUWIssue
	{

		private RiskAnalysis.CreateNewUWIssue.CreateNewUWIssueBy by;
		public FLHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			expectedPanelTitle = "Create New UW Issue";
			waitForTitle(sh);
			by = new RiskAnalysis.CreateNewUWIssue.CreateNewUWIssueBy();

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

		public RiskAnalysis.CreateNewUWIssue setIssueType(String issueType)
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

		public RiskAnalysis.CreateNewUWIssue setShortDescription(String shortDescription)
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

		public RiskAnalysis.CreateNewUWIssue setLongDescription(String longDescription)
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
