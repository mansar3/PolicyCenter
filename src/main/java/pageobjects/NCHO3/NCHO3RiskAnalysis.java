package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3RiskAnalysis extends RiskAnalysis<NCHO3RiskAnalysis>
{
	public NCHO3WestPanel westPanel;
		public NCHO3RiskAnalysis(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
		westPanel = new NCHO3WestPanel(sh, path);
	}

	public NCHO3Quote quote()
	{
		super.riskAnalysisQuote();
		return new NCHO3Quote(sh,path);
	}
	public NCHO3Quote next()
	{
		super.clickNext();
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
	public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

	public NCHO3UnderwritingQuestions clickUnderWritingQuestions()
	{
		super.riskAnalysisClickUnderwritingquestion();
		return new NCHO3UnderwritingQuestions(sh,path);
	}
	public NCHO3RiskAnalysis answerYes(int questionNum){
		return super.answerYes(questionNum);
	}

	public NCHO3RiskAnalysis answerNo(int questionNum){
		return super.answerNo(questionNum);
	}
	public NCHO3RiskAnalysis back(){
		return  super.coveragesback();
	}

	public NCHO3PriorLosses clickPriorLosses()
	{
		super.riskAnalysisClickPriorLosses();
		return new NCHO3PriorLosses(sh, path);
	}
	public NCHO3PriorLosses clickOrderAreport()
	{
		super.orderAReport1();
		return new NCHO3PriorLosses(sh, path);
	}
	public String getusIssueblockingbind1()
	{
		return super.getusIssueblockingbind1();
	}

	public NCHO3RiskAnalysis clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}

	public NCHO3RiskAnalysis acceptYes()
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

	public class NCHO3PriorLosses extends PriorLosses<NCHO3PriorLosses>
	{

		public NCHO3PriorLosses(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}

		public NCHO3Quote quote()
		{
			super.PriorLossesQuote();
			//sh.clickElement(by.submissionQuote);
			//sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
			return new NCHO3Quote(sh,path);
		}

		protected NCHO3RiskAnalysis clickOrderAReport()
		{
			super.orderAReport();
			return new NCHO3RiskAnalysis(sh, path);
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

	public class NCHO3UnderwritingQuestions extends UnderwritingQuestions<NCHO3UnderwritingQuestions>
	{

		public NCHO3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

		public NCHO3Quote quote()

		{
			super.UnderwritingQuestionsQuote();
			return new NCHO3Quote(sh, path);
		}

	}
}
