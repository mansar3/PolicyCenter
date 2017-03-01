package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3RiskAnalysis extends RiskAnalysis<SCHO3RiskAnalysis>
{
		public SCHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3Quote quote()
	{
		super.riskAnalysisQuote();
		return new SCHO3Quote(sh,path);
	}

	public SCHO3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new SCHO3Quote(sh, path);
	}
	public SCHO3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new SCHO3Contingencies(sh, path);
	}

	public SCHO3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new SCHO3UWActivity(sh, path);
	}
	public SCHO3RiskAnalysis.SCHO3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new SCHO3RiskAnalysis.SCHO3CreateNewUWIssue(sh, path);

	}
	public SCHO3UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new SCHO3UnderwritingQuestions(sh,path);
	}
	public SCHO3RiskAnalysis back(){
		return  super.coveragesback();
	}
	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

	public SCHO3RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public SCHO3RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}
	public class SCHO3Contingencies extends Contingencies<SCHO3Contingencies>
	{

		public SCHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public SCHO3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new SCHO3Quote(sh,path);
		}

	}
	public class SCHO3CreateNewUWIssue extends CreateNewUWIssue<SCHO3CreateNewUWIssue>
	{

		public SCHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public SCHO3RiskAnalysis.SCHO3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public SCHO3RiskAnalysis.SCHO3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public SCHO3RiskAnalysis.SCHO3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public SCHO3CreateNewUWIssue clickOk()
		{
			super.riskAnalysisOk();
			return new SCHO3CreateNewUWIssue(sh, path);
		}
		public SCHO3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new SCHO3CreateNewUWIssue(sh, path);
		}
		public SCHO3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new SCHO3CreateNewUWIssue(sh, path);
		}


	}

	public class SCHO3UnderwritingQuestions extends UnderwritingQuestions<SCHO3UnderwritingQuestions>
	{

		public SCHO3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public SCHO3Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new SCHO3Quote(sh, path);
		}

	}
}
