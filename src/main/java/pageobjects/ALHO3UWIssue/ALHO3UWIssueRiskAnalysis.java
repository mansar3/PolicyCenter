package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueRiskAnalysis extends RiskAnalysis<ALHO3UWIssueRiskAnalysis> {




    public ALHO3UWIssueRiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }


    public ALHO3UWIssueQuote quote()
    {
        super.riskAnalysisQuote();
        return new ALHO3UWIssueQuote(sh,path);
    }

    public ALHO3UWIssueRiskAnalysis back(){
        return  super.coveragesback();
    }


    public ALHO3UWIssueQuote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new ALHO3UWIssueQuote(sh, path);
    }
    public ALHO3UWIssueContingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new ALHO3UWIssueContingencies(sh, path);
    }

    public ALHO3UWIssueUnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new ALHO3UWIssueUnderwritingQuestions(sh,path);
    }

    public String getusIssueblockingbind1()
    {
        return super.getusIssueblockingbind1();
    }

    public String getusIssueblockingbind2()
    {
        return super.getusIssueblockingbind2();
    }

    public String getusIssueblockingbind3()
    {
        return super.getusIssueblockingbind3();
    }


    public ALHO3UWIssueRiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public ALHO3UWIssueRiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }

    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}


    public ALHO3UWIssueUWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new ALHO3UWIssueUWActivity(sh, path);
    }
    public ALHO3UWIssueRiskAnalysis.ALHO3UWIssueCreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new ALHO3UWIssueRiskAnalysis.ALHO3UWIssueCreateNewUWIssue(sh, path);

    }
    public class ALHO3UWIssueContingencies extends Contingencies<ALHO3UWIssueContingencies>
    {

        public ALHO3UWIssueContingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public ALHO3UWIssueQuote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new ALHO3UWIssueQuote(sh,path);
        }


    }
    public class ALHO3UWIssueCreateNewUWIssue extends CreateNewUWIssue<ALHO3UWIssueCreateNewUWIssue>
    {

        public ALHO3UWIssueCreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public ALHO3UWIssueRiskAnalysis.ALHO3UWIssueCreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public ALHO3UWIssueRiskAnalysis.ALHO3UWIssueCreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public ALHO3UWIssueRiskAnalysis.ALHO3UWIssueCreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }

        public ALHO3UWIssueCreateNewUWIssue clickOk()
        {
            super.riskAnalysisOk();
            return new ALHO3UWIssueCreateNewUWIssue(sh, path);
        }
        public ALHO3UWIssueCreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new ALHO3UWIssueCreateNewUWIssue(sh, path);
        }
        public ALHO3UWIssueCreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new ALHO3UWIssueCreateNewUWIssue(sh, path);
        }


    }


    public class ALHO3UWIssueUnderwritingQuestions extends UnderwritingQuestions<ALHO3UWIssueUnderwritingQuestions>
    {

        public ALHO3UWIssueUnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public ALHO3UWIssueQuote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new ALHO3UWIssueQuote(sh, path);
        }

    }
}
