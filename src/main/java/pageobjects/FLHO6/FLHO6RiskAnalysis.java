package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6RiskAnalysis extends RiskAnalysis<FLHO6RiskAnalysis>
{
	public FLHO6WestPanel westPanel;
	public FLHO6RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new FLHO6WestPanel(sh,path);
	}

	public FLHO6Quote quote()
	{
		super.riskAnalysisQuote();
		return new FLHO6Quote(sh,path);
	}
	public FLHO6PreQuoteIssues Issuequote()
	{
		super.riskAnalysisIssueQuote();
		return new FLHO6PreQuoteIssues(sh,path);
	}
		public FLHO6Quote next()
	{
		super.clickNext();
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
	public FLHO6RiskAnalysis back(){
		return  super.coveragesback();
	}

	public FLHO6UWActivity riskAnalysisRequestApproval()
	{
		super.requestApproval();
		return new FLHO6UWActivity(sh, path);
	}
	public FLHO6PriorLosses clickPriorLosses()
	{
		super.riskAnalysisClickPriorLosses();
		return new FLHO6PriorLosses(sh, path);
	}
	public FLHO6PriorLosses clickOrderAreport()
	{
		super.orderAReport1();
		return new FLHO6PriorLosses(sh, path);
	}
	public FLHO6UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new FLHO6UnderwritingQuestions(sh,path);
	}
	public FLHO6RiskAnalysis.FLHO6CreateNewUWIssue addUWIssue()
	{
		super.riskAnalysisAddUWIssue();
		return new FLHO6RiskAnalysis.FLHO6CreateNewUWIssue(sh, path);

	}

	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}
	public FLHO6RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public FLHO6RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}
	public String getusIssueblockingbind1()
	{
		return super.getusIssueblockingbind1();
	}

	public FLHO6RiskAnalysis clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}

	public FLHO6RiskAnalysis acceptYes()
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
	public class FLHO6PriorLosses extends PriorLosses<FLHO6PriorLosses>
	{

		public FLHO6PriorLosses(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public FLHO6Quote quote()
		{
			super.PriorLossesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new FLHO6Quote(sh,path);
		}

		protected FLHO6RiskAnalysis clickOrderAReport()
		{
			super.orderAReport();
			return new FLHO6RiskAnalysis(sh, path);
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

	public class FLHO6UnderwritingQuestions extends UnderwritingQuestions<FLHO6UnderwritingQuestions>
	{

		public FLHO6UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public FLHO6Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new FLHO6Quote(sh, path);
		}

	}
}
