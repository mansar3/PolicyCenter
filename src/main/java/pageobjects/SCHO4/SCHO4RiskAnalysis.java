package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4RiskAnalysis extends RiskAnalysis<SCHO4RiskAnalysis> {

    public SCHO4RiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4Quote quote()
    {
        super.riskAnalysisQuote();
        return new SCHO4Quote(sh,path);
    }

    public SCHO4Quote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new SCHO4Quote(sh, path);
    }
    public SCHO4PreQuoteIssues Issuequote()
    {
        super.riskAnalysisQuote();
        //sh.clickElement(by.submissionQuote);
        //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
        return new SCHO4PreQuoteIssues(sh,path);
    }
    public SCHO4Contingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new SCHO4Contingencies(sh, path);
    }

    public SCHO4UWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new SCHO4UWActivity(sh, path);
    }
    public SCHO4RiskAnalysis.SCHO4CreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new SCHO4RiskAnalysis.SCHO4CreateNewUWIssue(sh, path);

    }
    public SCHO4PriorLosses clickPriorLosses()
    {
        super.riskAnalysisClickPriorLosses();
        return new SCHO4PriorLosses(sh, path);
    }

    public SCHO4PriorLosses clickOrderAreport()
    {
        super.orderAReport1();
        return new SCHO4PriorLosses(sh, path);
    }
    public SCHO4UnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new SCHO4UnderwritingQuestions(sh,path);
    }
    public SCHO4RiskAnalysis back(){
        return  super.coveragesback();
    }
    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

    public SCHO4RiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public SCHO4RiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }

    public String getusIssueblockingbind1()
    {
        return super.getusIssueblockingbind1();
    }

    public SCHO4RiskAnalysis clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }

    public SCHO4RiskAnalysis acceptYes()
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
    public class SCHO4Contingencies extends Contingencies<SCHO4Contingencies>
    {

        public SCHO4Contingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public SCHO4Quote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new SCHO4Quote(sh,path);
        }

    }
    public class SCHO4PriorLosses extends PriorLosses<SCHO4PriorLosses>
    {

        public SCHO4PriorLosses(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public SCHO4Quote quote()
        {
            super.PriorLossesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new SCHO4Quote(sh,path);
        }

        protected SCHO4RiskAnalysis clickOrderAReport()
        {
            super.orderAReport();
            return new SCHO4RiskAnalysis(sh, path);
        }
    }
    public class SCHO4CreateNewUWIssue extends CreateNewUWIssue<SCHO4CreateNewUWIssue>
    {

        public SCHO4CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public SCHO4RiskAnalysis.SCHO4CreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public SCHO4RiskAnalysis.SCHO4CreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public SCHO4RiskAnalysis.SCHO4CreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }
        public SCHO4CreateNewUWIssue clickOk()
        {
            super.riskAnalysisOk();
            return new SCHO4CreateNewUWIssue(sh, path);
        }
        public SCHO4CreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new SCHO4CreateNewUWIssue(sh, path);
        }
        public SCHO4CreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new SCHO4CreateNewUWIssue(sh, path);
        }


    }

    public class SCHO4UnderwritingQuestions extends UnderwritingQuestions<SCHO4UnderwritingQuestions>
    {

        public SCHO4UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public SCHO4Quote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new SCHO4Quote(sh, path);
        }

    }
}
