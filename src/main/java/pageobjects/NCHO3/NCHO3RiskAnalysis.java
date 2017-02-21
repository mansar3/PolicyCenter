package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3RiskAnalysis extends RiskAnalysis<NCHO3RiskAnalysis>
{
		public NCHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3Quote quote()
	{
		super.riskAnalysisQuote();
		return new NCHO3Quote(sh,path);
	}

	public NCHO3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new NCHO3Quote(sh, path);
	}
	public NCHO3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new NCHO3Contingencies(sh, path);
	}

	public NCHO3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new NCHO3UWActivity(sh, path);
	}
	public NCHO3RiskAnalysis.NCHO3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new NCHO3RiskAnalysis.NCHO3CreateNewUWIssue(sh, path);

	}
	public class NCHO3Contingencies extends Contingencies<NCHO3Contingencies>
	{

		public NCHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public NCHO3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new NCHO3Quote(sh,path);
		}

	}
	public class NCHO3CreateNewUWIssue extends CreateNewUWIssue<NCHO3CreateNewUWIssue>
	{

		public NCHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public NCHO3RiskAnalysis.NCHO3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public NCHO3RiskAnalysis.NCHO3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public NCHO3RiskAnalysis.NCHO3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public NCHO3CreateNewUWIssue clickOk()
		{
			super.riskAnalysisOk();
			return new NCHO3CreateNewUWIssue(sh, path);
		}
		public NCHO3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new NCHO3CreateNewUWIssue(sh, path);
		}
		public NCHO3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new NCHO3CreateNewUWIssue(sh, path);
		}


	}
}