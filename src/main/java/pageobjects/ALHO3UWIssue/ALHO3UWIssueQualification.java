package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueQualification extends Qualification<ALHO3UWIssueQualification> {

    public ALHO3UWIssueQualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueQuestionnaire questionnaire = new ALHO3UWIssueQuestionnaire(sh);

    public ALHO3UWIssueQualification setOfferingSelection(String offeringSelection)
    {
        return super.setOfferingSelection(offeringSelection);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }

    public ALHO3UWIssueQualification setPolicyType(String policyType)
    {
        return super.setPolicyType(policyType);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public ALHO3UWIssuePolicyInfo next()
    {
        super.policyInfoNext();
        return new ALHO3UWIssuePolicyInfo(sh, path);
    }

    public class ALHO3UWIssueQuestionnaire extends Questionnaire<ALHO3UWIssueQuestionnaire>
    {

        public ALHO3UWIssueQuestionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }
        public ALHO3UWIssueQuestionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }
        public ALHO3UWIssueQuestionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }
    }
}
