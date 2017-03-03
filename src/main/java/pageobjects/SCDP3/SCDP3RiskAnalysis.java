package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3RiskAnalysis extends RiskAnalysis<SCDP3RiskAnalysis>
{
		public SCDP3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3Quote quote()
	{
		super.riskAnalysisQuote();
		return new SCDP3Quote(sh,path);
	}

	public SCDP3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new SCDP3Quote(sh, path);
	}
	public SCDP3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new SCDP3Contingencies(sh, path);
	}

	public SCDP3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new SCDP3UWActivity(sh, path);
	}
	public SCDP3RiskAnalysis.SCDP3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new SCDP3RiskAnalysis.SCDP3CreateNewUWIssue(sh, path);

	}
	public SCDP3UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new SCDP3UnderwritingQuestions(sh,path);
	}
	public SCDP3RiskAnalysis back(){
		return  super.coveragesback();
	}
	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

	public SCDP3RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public SCDP3RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}
	public class SCDP3Contingencies extends Contingencies<SCDP3Contingencies>
	{

		public SCDP3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public SCDP3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new SCDP3Quote(sh,path);
		}

	}
	public class SCDP3CreateNewUWIssue extends CreateNewUWIssue<SCDP3CreateNewUWIssue>
	{

		public SCDP3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public SCDP3RiskAnalysis.SCDP3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public SCDP3RiskAnalysis.SCDP3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public SCDP3RiskAnalysis.SCDP3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public SCDP3CreateNewUWIssue clickOk()
		{
			super.riskAnalysisOk();
			return new SCDP3CreateNewUWIssue(sh, path);
		}
		public SCDP3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new SCDP3CreateNewUWIssue(sh, path);
		}
		public SCDP3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new SCDP3CreateNewUWIssue(sh, path);
		}


	}
	public class SCDP3UnderwritingQuestions extends UnderwritingQuestions<SCDP3UnderwritingQuestions>
	{

		public SCDP3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public SCDP3Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new SCDP3Quote(sh, path);
		}

	}
}
