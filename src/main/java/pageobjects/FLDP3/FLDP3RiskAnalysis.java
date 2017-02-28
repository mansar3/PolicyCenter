package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3RiskAnalysis extends RiskAnalysis<FLDP3RiskAnalysis>
{
	public FLDP3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3Quote quote()
	{
		super.riskAnalysisQuote();
		return new FLDP3Quote(sh,path);
	}

	public FLDP3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new FLDP3Quote(sh, path);
	}
	public FLDP3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new FLDP3Contingencies(sh, path);
	}

	public FLDP3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new FLDP3UWActivity(sh, path);
	}
	public FLDP3RiskAnalysis.FLDP3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new FLDP3RiskAnalysis.FLDP3CreateNewUWIssue(sh, path);

	}
	public class FLDP3Contingencies extends Contingencies<FLDP3Contingencies>
	{

		public FLDP3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLDP3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLDP3Quote(sh,path);
		}

	}
	public class FLDP3CreateNewUWIssue extends CreateNewUWIssue<FLDP3CreateNewUWIssue>
	{

		public FLDP3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public FLDP3RiskAnalysis.FLDP3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public FLDP3RiskAnalysis.FLDP3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public FLDP3RiskAnalysis.FLDP3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public FLDP3RiskAnalysis clickOk()
		{
			super.riskAnalysisOk();
			return new FLDP3RiskAnalysis(sh, path);
		}
		public FLDP3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new FLDP3CreateNewUWIssue(sh, path);
		}
		public FLDP3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new FLDP3CreateNewUWIssue(sh, path);
		}


	}
}
