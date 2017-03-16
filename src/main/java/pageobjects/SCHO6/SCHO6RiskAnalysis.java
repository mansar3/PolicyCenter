package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6RiskAnalysis extends RiskAnalysis<SCHO6RiskAnalysis>
{
		public SCHO6RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6Quote quote()
	{
		super.riskAnalysisQuote();
		return new SCHO6Quote(sh,path);
	}
	public SCHO6PreQuoteIssues Issuequote()
	{
		super.riskAnalysisIssueQuote();
		return new SCHO6PreQuoteIssues(sh,path);
	}
	public SCHO6Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new SCHO6Quote(sh, path);
	}
	public SCHO6Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new SCHO6Contingencies(sh, path);
	}

	public SCHO6UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new SCHO6UWActivity(sh, path);
	}
	public SCHO6RiskAnalysis.SCHO6CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new SCHO6RiskAnalysis.SCHO6CreateNewUWIssue(sh, path);

	}
	public SCHO6UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new SCHO6UnderwritingQuestions(sh,path);
	}
	public SCHO6RiskAnalysis back(){
		return  super.coveragesback();
	}
	public SCHO6RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public SCHO6RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}
	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}
	public String getusIssueblockingbind1()
	{
		return super.getusIssueblockingbind1();
	}

	public SCHO6RiskAnalysis clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}

	public SCHO6RiskAnalysis acceptYes()
	{
		return super.accept();
	}

	public String getusIssueblockingbind2()
	{
		return super.getusIssueblockingbind2();
	}

	public String getusIssueblockingbind3()
	{
		return super.getusIssueblockingbind3();
	}

	public class SCHO6Contingencies extends Contingencies<SCHO6Contingencies>
	{

		public SCHO6Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public SCHO6Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new SCHO6Quote(sh,path);
		}

	}
	public class SCHO6CreateNewUWIssue extends CreateNewUWIssue<SCHO6CreateNewUWIssue>
	{

		public SCHO6CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public SCHO6RiskAnalysis.SCHO6CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public SCHO6RiskAnalysis.SCHO6CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public SCHO6RiskAnalysis.SCHO6CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}
		public SCHO6CreateNewUWIssue clickOk()
		{
			super.riskAnalysisOk();
			return new SCHO6CreateNewUWIssue(sh, path);
		}
		public SCHO6CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new SCHO6CreateNewUWIssue(sh, path);
		}
		public SCHO6CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new SCHO6CreateNewUWIssue(sh, path);
		}
	}

	public class SCHO6UnderwritingQuestions extends UnderwritingQuestions<SCHO6UnderwritingQuestions>
	{

		public SCHO6UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public SCHO6Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new SCHO6Quote(sh, path);
		}

	}
}
