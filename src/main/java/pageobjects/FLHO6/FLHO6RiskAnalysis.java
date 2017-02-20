package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6RiskAnalysis extends RiskAnalysis<FLHO6RiskAnalysis>
{
	public FLHO6RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6Quote quote()
	{
		super.riskAnalysisQuote();
		return new FLHO6Quote(sh,path);
	}

	public FLHO6Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new FLHO6Quote(sh, path);
	}
	public FLHO6Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new FLHO6Contingencies(sh, path);
	}

	public FLHO6UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new FLHO6UWActivity(sh, path);
	}
	public FLHO6RiskAnalysis.FLHO6CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new FLHO6RiskAnalysis.FLHO6CreateNewUWIssue(sh, path);

	}
	public class FLHO6Contingencies extends Contingencies<FLHO6Contingencies>
	{

		public FLHO6Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLHO6Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLHO6Quote(sh,path);
		}

	}
	public class FLHO6CreateNewUWIssue extends CreateNewUWIssue<FLHO6CreateNewUWIssue>
	{

		public FLHO6CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public FLHO6RiskAnalysis.FLHO6CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public FLHO6RiskAnalysis.FLHO6CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public FLHO6RiskAnalysis.FLHO6CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public FLHO6RiskAnalysis clickOk()
		{
			super.riskAnalysisOk();
			return new FLHO6RiskAnalysis(sh, path);
		}
		public FLHO6CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new FLHO6CreateNewUWIssue(sh, path);
		}
		public FLHO6CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new FLHO6CreateNewUWIssue(sh, path);
		}


	}
}
