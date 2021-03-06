package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWRiskAnalysis extends RiskAnalysis<NCHOWRiskAnalysis> {
	public NCHOWWestPanel westPanel;
    public NCHOWRiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
		westPanel = new NCHOWWestPanel(sh, path);
	}

    public NCHOWQuote quote()
    {
        super.riskAnalysisQuote();
        return new NCHOWQuote(sh,path);
    }
	public NCHOWQuote next()
	{
		super.clickNext();
		return new NCHOWQuote(sh,path);
	}

    public NCHOWQuote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new NCHOWQuote(sh, path);
    }
    public NCHOWContingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new NCHOWContingencies(sh, path);
    }

    public NCHOWUWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new NCHOWUWActivity(sh, path);
    }
    public NCHOWRiskAnalysis.NCHOWCreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new NCHOWRiskAnalysis.NCHOWCreateNewUWIssue(sh, path);
    }
    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

    public NCHOWUnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new NCHOWUnderwritingQuestions(sh,path);
    }
    public NCHOWPriorLosses clickPriorLosses()
    {
        super.riskAnalysisClickPriorLosses();
        return new NCHOWPriorLosses(sh, path);
    }
    public NCHOWPriorLosses clickOrderAreport()
    {
        super.orderAReport1();
        return new NCHOWPriorLosses(sh, path);
    }
    public NCHOWRiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public NCHOWRiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }
    public NCHOWRiskAnalysis back(){
        return  super.coveragesback();
    }
    public String getusIssueblockingbind1()
    {
        return super.getusIssueblockingbind1();
    }

    public NCHOWRiskAnalysis clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }

    public NCHOWRiskAnalysis acceptYes()
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
    public class NCHOWContingencies extends Contingencies<NCHOWContingencies>
    {

        public NCHOWContingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCHOWQuote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new NCHOWQuote(sh,path);
        }

    }
    public class NCHOWCreateNewUWIssue extends CreateNewUWIssue<NCHOWCreateNewUWIssue>
    {

        public NCHOWCreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public NCHOWRiskAnalysis.NCHOWCreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public NCHOWRiskAnalysis.NCHOWCreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public NCHOWRiskAnalysis.NCHOWCreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }
        public NCHOWCreateNewUWIssue clickOk()
        {
            super.riskAnalysisOk();
            return new NCHOWCreateNewUWIssue(sh, path);
        }
        public NCHOWCreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new NCHOWCreateNewUWIssue(sh, path);
        }
        public NCHOWCreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new NCHOWCreateNewUWIssue(sh, path);
        }


    }

    public class NCHOWPriorLosses extends PriorLosses<NCHOWPriorLosses>
    {

        public NCHOWPriorLosses(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCHOWQuote quote()
        {
            super.PriorLossesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new NCHOWQuote(sh,path);
        }

        protected NCHOWRiskAnalysis clickOrderAReport()
        {
            super.orderAReport();
            return new NCHOWRiskAnalysis(sh, path);
        }
    }
    public class NCHOWUnderwritingQuestions extends UnderwritingQuestions<NCHOWUnderwritingQuestions>
    {

        public NCHOWUnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public NCHOWQuote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new NCHOWQuote(sh, path);
        }

    }
}
