package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3RiskAnalysis extends RiskAnalysis<FLMH3RiskAnalysis> {

    public FLMH3RiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3Quote quote()
    {
        super.riskAnalysisQuote();
        return new FLMH3Quote(sh,path);
    }

    public FLMH3PreQuoteIssues Issuequote()
    {
        super.riskAnalysisQuote();
        //sh.clickElement(by.submissionQuote);
        //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
        return new FLMH3PreQuoteIssues(sh,path);
    }
    public FLMH3Quote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new FLMH3Quote(sh, path);
    }

    public FLMH3RiskAnalysis back(){
        return  super.coveragesback();
    }

    public FLMH3Contingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new FLMH3Contingencies(sh, path);
    }
    public FLMH3UnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new FLMH3UnderwritingQuestions(sh,path);
    }
    public FLMH3UWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new FLMH3UWActivity(sh, path);
    }
    public FLMH3RiskAnalysis.FLMH3CreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new FLMH3RiskAnalysis.FLMH3CreateNewUWIssue(sh, path);

    }

    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}
    public FLMH3RiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public FLMH3RiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }

    public String getusIssueblockingbind1()
    {
        return super.getusIssueblockingbind1();
    }

    public FLMH3RiskAnalysis clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }

    public FLMH3RiskAnalysis acceptYes()
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
    public class FLMH3Contingencies extends Contingencies<FLMH3Contingencies>
    {

        public FLMH3Contingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public FLMH3Quote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new FLMH3Quote(sh,path);
        }

    }
    public class FLMH3CreateNewUWIssue extends CreateNewUWIssue<FLMH3CreateNewUWIssue>
    {

        public FLMH3CreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public FLMH3RiskAnalysis.FLMH3CreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public FLMH3RiskAnalysis.FLMH3CreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public FLMH3RiskAnalysis.FLMH3CreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }
        public FLMH3RiskAnalysis clickOk()
        {
            super.riskAnalysisOk();
            return new FLMH3RiskAnalysis(sh, path);
        }
        public FLMH3CreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new FLMH3CreateNewUWIssue(sh, path);
        }
        public FLMH3CreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new FLMH3CreateNewUWIssue(sh, path);
        }


    }


    public class FLMH3UnderwritingQuestions extends UnderwritingQuestions<FLMH3UnderwritingQuestions>
    {

        public FLMH3UnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public FLMH3Quote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new FLMH3Quote(sh, path);
        }

    }
}
