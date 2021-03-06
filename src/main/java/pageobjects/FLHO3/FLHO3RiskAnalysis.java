package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3RiskAnalysis extends RiskAnalysis<FLHO3RiskAnalysis>
{
	public FLHO3WestPanel westPanel;
	public FLHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new FLHO3WestPanel(sh,path);
	}

	public FLHO3Quote next()
	{
		super.clickNext();
		return new FLHO3Quote(sh,path);
	}
	public FLHO3Quote quote()
	{
		super.riskAnalysisQuote();
		return new FLHO3Quote(sh,path);
	}
	public FLHO3PreQuoteIssues Issuequote()
	{
		super.riskAnalysisIssueQuote();
		return new FLHO3PreQuoteIssues(sh,path);
	}
	public FLHO3Quote qualifiesForAdditionalProtectionQuote()
	{
		super.raQualifiesForAdditionalProtectionQuote();
		//super.riskAnalysisClickContingencies().riskAnalysisQuote();
		return new FLHO3Quote(sh, path);
	}

	public FLHO3RiskAnalysis back(){
		return  super.coveragesback();
	}

	public FLHO3Contingencies clickContingencies()
	{
		super.riskAnalysisClickContingencies();
		return new FLHO3Contingencies(sh, path);
	}
	public FLHO3UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new FLHO3UnderwritingQuestions(sh,path);
	}
	public FLHO3UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new FLHO3UWActivity(sh, path);
	}
	public FLHO3PriorLosses clickPriorLosses()
	{
		super.riskAnalysisClickPriorLosses();
		return new FLHO3PriorLosses(sh, path);
	}
	public FLHO3PriorLosses clickOrderAreport()
	{
		super.orderAReport1();
		return new FLHO3PriorLosses(sh, path);
	}

	public FLHO3RiskAnalysis.FLHO3CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new FLHO3RiskAnalysis.FLHO3CreateNewUWIssue(sh, path);

	}

	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}
	public FLHO3RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public FLHO3RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}

	public String getusIssueblockingbind1()
	{
		return super.getusIssueblockingbind1();
	}

	public FLHO3RiskAnalysis clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}

	public FLHO3RiskAnalysis acceptYes()
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

	public class FLHO3Contingencies extends Contingencies<FLHO3Contingencies>
	{

		public FLHO3Contingencies(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLHO3Quote quote()
		{
			super.contingenciesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLHO3Quote(sh,path);
		}

	}

	public class FLHO3PriorLosses extends PriorLosses<FLHO3PriorLosses>
	{

		public FLHO3PriorLosses(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLHO3Quote quote()
		{
			super.PriorLossesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLHO3Quote(sh,path);
		}

		protected FLHO3RiskAnalysis clickOrderAReport()
		{
			super.orderAReport();
			return new FLHO3RiskAnalysis(sh, path);
		}
	}

	public class FLHO3CreateNewUWIssue extends CreateNewUWIssue<FLHO3CreateNewUWIssue>
	{

		public FLHO3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
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
		public FLHO3RiskAnalysis clickOk()
		{
			super.riskAnalysisOk();
			return new FLHO3RiskAnalysis(sh, path);
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


	public class FLHO3UnderwritingQuestions extends UnderwritingQuestions<FLHO3UnderwritingQuestions>
	{

		public FLHO3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public FLHO3Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new FLHO3Quote(sh, path);
		}

	}

}
