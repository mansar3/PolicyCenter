package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.RiskAnalysis;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyRiskAnalysis extends RiskAnalysis<NCWindOnlyRiskAnalysis> {
    public NCWindOnlyRiskAnalysis(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyQuote quote()
    {
        super.riskAnalysisQuote();
        return new NCWindOnlyQuote(sh,path);
    }

    public NCWindOnlyQuote qualifiesForAdditionalProtectionQuote()
    {
        super.raQualifiesForAdditionalProtectionQuote();
        //super.riskAnalysisClickContingencies().riskAnalysisQuote();
        return new NCWindOnlyQuote(sh, path);
    }
    public NCWindOnlyContingencies clickContingencies()
    {
        super.riskAnalysisClickContingencies();
        return new NCWindOnlyContingencies(sh, path);
    }

    public NCWindOnlyUWActivity riskAnalysisRequestApproval()
    {
        super.requestApproval();
        return new NCWindOnlyUWActivity(sh, path);
    }
    public NCWindOnlyRiskAnalysis.NCWindOnlyCreateNewUWIssue addUWIssue()
    {
        super.riskAnalysisAddUWIssue();
        return new NCWindOnlyRiskAnalysis.NCWindOnlyCreateNewUWIssue(sh, path);
    }
    public String getErrorMessage(){return super.riskAnalysisErrorMessage();}

    public NCWindOnlyUnderwritingQuestions clickUnderWritingQuestions()
    {
        super.riskAnalysisClickUnderwritingquestion();
        return new NCWindOnlyUnderwritingQuestions(sh,path);
    }
    public NCWindOnlyRiskAnalysis answerYes(int questionNum){
        return super.answerYes(questionNum);
    }

    public NCWindOnlyRiskAnalysis answerNo(int questionNum){
        return super.answerNo(questionNum);
    }
    public NCWindOnlyRiskAnalysis back(){
        return  super.coveragesback();
    }
    public class NCWindOnlyContingencies extends Contingencies<NCWindOnlyContingencies>
    {

        public NCWindOnlyContingencies(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }

        public NCWindOnlyQuote quote()
        {
            super.contingenciesQuote();
            //sh.clickElement(by.submissionQuote);
            //sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
            return new NCWindOnlyQuote(sh,path);
        }

    }
    public class NCWindOnlyCreateNewUWIssue extends CreateNewUWIssue<NCWindOnlyCreateNewUWIssue>
    {

        public NCWindOnlyCreateNewUWIssue(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public String getIssueType()
        {
            return super.getIssueType();
        }

        public NCWindOnlyRiskAnalysis.NCWindOnlyCreateNewUWIssue setIssueType(String issueType)
        {
            super.setIssueType(issueType);
            return this;
        }

        public String getShortDescription()
        {
            return super.getShortDescription();
        }

        public NCWindOnlyRiskAnalysis.NCWindOnlyCreateNewUWIssue setShortDescription(String shortDescription)
        {
            super.setShortDescription(shortDescription);
            return this;
        }
        public String getLongDescription()
        {
            return super.getLongDescription();
        }

        public NCWindOnlyRiskAnalysis.NCWindOnlyCreateNewUWIssue setLongDescription(String longDescription)
        {
            super.setLongDescription(longDescription);
            return this;
        }
        public NCWindOnlyCreateNewUWIssue clickOk()
        {
            super.riskAnalysisOk();
            return new NCWindOnlyCreateNewUWIssue(sh, path);
        }
        public NCWindOnlyCreateNewUWIssue clickCancel()
        {
            super.clickCancel();
            return new NCWindOnlyCreateNewUWIssue(sh, path);
        }
        public NCWindOnlyCreateNewUWIssue clickReturnToRiskAnalysis()
        {
            super.clickReturnToRiskAnalysis();
            return new NCWindOnlyCreateNewUWIssue(sh, path);
        }


    }

    public class NCWindOnlyUnderwritingQuestions extends UnderwritingQuestions<NCWindOnlyUnderwritingQuestions>
    {

        public NCWindOnlyUnderwritingQuestions(CenterSeleniumHelper sh, Path path) { super(sh, path);}

        public NCWindOnlyQuote quote()

        {
            super.UnderwritingQuestionsQuote();
            return new NCWindOnlyQuote(sh, path);
        }

    }
}
