package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class ALHO3RiskAnalysis extends RiskAnalysis<ALHO3RiskAnalysis>
{
	public ALHO3WestPanel westPanel;
	public ALHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new ALHO3WestPanel(sh,path);
	}

	public ALHO3Quote quote()
	{
		super.riskAnalysisQuote();
		return new ALHO3Quote(sh,path);
	}
	public ALHO3PreQuoteIssues Issuequote()
	{
		super.riskAnalysisIssueQuote();
		return new ALHO3PreQuoteIssues(sh,path);
	}

	public ALHO3PolicyReview next()
	{
		super.riskAnalysispolicyReviewNext();
		return new ALHO3PolicyReview(sh, path);
	}

	public ALHO3RiskAnalysis back(){
		return  super.coveragesback();
	}


	public ALHO3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new ALHO3Quote(sh, path);
	}
	public ALHO3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new ALHO3Contingencies(sh, path);
	}

	public ALHO3PriorLosses clickPriorLosses()
	{
		super.riskAnalysisClickPriorLosses();
		return new ALHO3PriorLosses(sh, path);
	}

	public ALHO3PriorLosses clickOrderAreport()
	{
		super.orderAReport1();
		return new ALHO3PriorLosses(sh, path);
	}


	public ALHO3UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new ALHO3UnderwritingQuestions(sh,path);
	}

	public ALHO3RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public ALHO3RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}

	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

	public String getusIssueblockingbind1()
	{
		return super.getusIssueblockingbind1();
	}

	public ALHO3RiskAnalysis clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}

	public ALHO3RiskAnalysis acceptYes()
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



	public ALHO3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new ALHO3UWActivity(sh, path);
	}

	public ALHO3RiskAnalysis.ALHO3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new ALHO3RiskAnalysis.ALHO3CreateNewUWIssue(sh, path);

	}
	public class ALHO3Contingencies extends Contingencies<ALHO3Contingencies>
	{

		public ALHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public ALHO3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new ALHO3Quote(sh,path);
		}
	}

	public class ALHO3PriorLosses extends PriorLosses<ALHO3PriorLosses>
	{

		public ALHO3PriorLosses(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public ALHO3Quote quote()
		{
			super.PriorLossesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new ALHO3Quote(sh,path);
		}

		protected ALHO3RiskAnalysis clickOrderAReport()
		{
			super.orderAReport();
			return new ALHO3RiskAnalysis(sh, path);
		}
}


	public class ALHO3CreateNewUWIssue extends CreateNewUWIssue<ALHO3CreateNewUWIssue>
	{

		public ALHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public String getIssueType()
		{
			return super.getIssueType();
		}

		public ALHO3RiskAnalysis.ALHO3CreateNewUWIssue setIssueType(String issueType)
		{
			super.setIssueType(issueType);
			return this;
		}

		public String getShortDescription()
		{
			return super.getShortDescription();
		}

		public ALHO3RiskAnalysis.ALHO3CreateNewUWIssue setShortDescription(String shortDescription)
		{
			super.setShortDescription(shortDescription);
			return this;
		}
		public String getLongDescription()
		{
			return super.getLongDescription();
		}

		public ALHO3RiskAnalysis.ALHO3CreateNewUWIssue setLongDescription(String longDescription)
		{
			super.setLongDescription(longDescription);
			return this;
		}

		public ALHO3CreateNewUWIssue clickOk()
		{
			super.riskAnalysisOk();
			return new ALHO3CreateNewUWIssue(sh, path);
		}
		public ALHO3CreateNewUWIssue clickCancel()
		{
			super.clickCancel();
			return new ALHO3CreateNewUWIssue(sh, path);
		}
		public ALHO3CreateNewUWIssue clickReturnToRiskAnalysis()
		{
			super.clickReturnToRiskAnalysis();
			return new ALHO3CreateNewUWIssue(sh, path);
		}


	}


	public class ALHO3UnderwritingQuestions extends UnderwritingQuestions<ALHO3UnderwritingQuestions>
	{

		public ALHO3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public ALHO3Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new ALHO3Quote(sh, path);
		}

	}

}
