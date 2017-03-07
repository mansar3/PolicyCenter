package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWQualification extends Qualification<NCHOWQualification> {
    public NCHOWQuestionnaire questionnaire = new NCHOWQuestionnaire(sh);
    public NCHOWQualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWPolicyInfo next()
    {
        super.policyInfoNext();
        return new NCHOWPolicyInfo(sh, path);
    }
    public NCHOWQualification setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public NCHOWQualification setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public class NCHOWQuestionnaire extends Questionnaire<NCHOWQuestionnaire>
    {
        public NCHOWQuestionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }

        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }

        public NCHOWQuestionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }

        public NCHOWQuestionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }
    }
}
