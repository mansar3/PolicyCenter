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
		return super.clickContingencies().quote();
	}
	public FLHO3RiskAnalysis.FLHO3Contingencies clickContingencies()
	{
		super.clickContingencies();
		return new FLHO3RiskAnalysis.FLHO3Contingencies(sh, path);
	}

	public FLHO3UWActivity requestApproval()
	{
		super.requestApproval();
		return new FLHO3UWActivity(sh, path);
	}
	public FLHO3RiskAnalysis.FLHO3CreateNewUWIssue addUWIssue()
	{
		super.addUWIssue();
		return new FLHO3RiskAnalysis.FLHO3CreateNewUWIssue(sh, path);

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
		private FLHO3RiskAnalysis.FLHO3Contingencies.FLHO3ContingenciesBy by;
		public FLHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public class FLHO3ContingenciesBy
		{
			public final By		submissionQuote = By.id("SubmissionWizard:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
					renewalQuote = By.id("RenewalWizard:LOBWizardStepGroup:Job_RiskAnalysisScreen:JobWizardToolbarButtonSet:RenewalQuote"),
					requestApproval = By.id(riskAnalysisBase + "RiskAnalysisCV_tb:RequestApproval-btnInnerEl");
		}
		public FLHO3Contingencies quote()
		{
			super.quote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLHO3Contingencies(sh,path);
		}

	}
	public class FLHO3CreateNewUWIssue extends CreateNewUWIssue<FLHO3CreateNewUWIssue>
	{

		public FLHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
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
			return super.getIssueType();
		}

		public FLHO3RiskAnalysis.FLHO3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public FLHO3RiskAnalysis.FLHO3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public FLHO3RiskAnalysis.FLHO3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public FLHO3CreateNewUWIssue clickOk()
		{
			super.clickOk();
			return new FLHO3CreateNewUWIssue(sh, path);
		}
		public FLHO3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new FLHO3CreateNewUWIssue(sh, path);
		}
		public FLHO3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new FLHO3CreateNewUWIssue(sh, path);
		}


	}
}
