package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4RiskAnalysis extends RiskAnalysis<FLHO4RiskAnalysis> {


    public FLHO4RiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4Quote quote()
    {
        super.riskAnalysisQuote();
        return new FLHO4Quote(sh,path);
    }

    public FLHO4PreQuoteIssues Issuequote()
    {
        super.riskAnalysisQuote();
        //sh.clickElement(by.submissionQuote);
        //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
        return new FLHO4PreQuoteIssues(sh,path);
    }
    public FLHO4Quote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new FLHO4Quote(sh, path);
    }

    public FLHO4RiskAnalysis back(){
        return  super.coveragesback();
    }

    public FLHO4Contingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new FLHO4Contingencies(sh, path);
    }
    public FLHO4UnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new FLHO4UnderwritingQuestions(sh,path);
    }
    public FLHO4UWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new FLHO4UWActivity(sh, path);
    }
    public FLHO4PriorLosses clickPriorLosses()
    {
        super.riskAnalysisClickPriorLosses();
        return new FLHO4PriorLosses(sh, path);
    }
    public FLHO4PriorLosses clickOrderAreport()
    {
        super.orderAReport1();
        return new FLHO4PriorLosses(sh, path);
    }
    public FLHO4RiskAnalysis.FLHO4CreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new FLHO4RiskAnalysis.FLHO4CreateNewUWIssue(sh, path);

    }

    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}
    public FLHO4RiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public FLHO4RiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }

    public String getusIssueblockingbind1()
    {
        return super.getusIssueblockingbind1();
    }

    public FLHO4RiskAnalysis clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }

    public FLHO4RiskAnalysis acceptYes()
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
    public String getusIssueblockingbind4()
    {
        return super.getusIssueblockingbind4();
    }
    public String getusIssueblockingbind5()
    {
        return super.getusIssueblockingbind5();
    }
    public String getusIssueblockingbind6()
    {
        return super.getusIssueblockingbind6();
    }
    public String getusIssueblockingbind7()
    {
        return super.getusIssueblockingbind7();
    }
    public String getusIssueblockingbind8()
    {
        return super.getusIssueblockingbind8();
    }
    public class FLHO4Contingencies extends Contingencies<FLHO4Contingencies>
    {

        public FLHO4Contingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public FLHO4Quote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new FLHO4Quote(sh,path);
        }


    }
    public class FLHO4PriorLosses extends PriorLosses<FLHO4PriorLosses>
    {

        public FLHO4PriorLosses(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public FLHO4Quote quote()
        {
            super.PriorLossesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new FLHO4Quote(sh,path);
        }

        protected FLHO4RiskAnalysis clickOrderAReport()
        {
            super.orderAReport();
            return new FLHO4RiskAnalysis(sh, path);
        }
    }
    public class FLHO4CreateNewUWIssue extends CreateNewUWIssue<FLHO4CreateNewUWIssue>
    {

        public FLHO4CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public FLHO4RiskAnalysis.FLHO4CreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public FLHO4RiskAnalysis.FLHO4CreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public FLHO4RiskAnalysis.FLHO4CreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }
        public FLHO4RiskAnalysis clickOk()
        {
            super.riskAnalysisOk();
            return new FLHO4RiskAnalysis(sh, path);
        }
        public FLHO4CreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new FLHO4CreateNewUWIssue(sh, path);
        }
        public FLHO4CreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new FLHO4CreateNewUWIssue(sh, path);
        }


    }


    public class FLHO4UnderwritingQuestions extends UnderwritingQuestions<FLHO4UnderwritingQuestions>
    {

        public FLHO4UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public FLHO4Quote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new FLHO4Quote(sh, path);
        }

    }

}
