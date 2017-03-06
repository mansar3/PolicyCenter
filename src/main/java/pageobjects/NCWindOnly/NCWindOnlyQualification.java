package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyQualification extends Qualification<NCWindOnlyQualification> {
    public NCWindOnlyQuestionnaire questionnaire = new NCWindOnlyQuestionnaire(sh);
    public NCWindOnlyQualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyPolicyInfo next()
    {
        super.policyInfoNext();
        return new NCWindOnlyPolicyInfo(sh, path);
    }
    public NCWindOnlyQualification setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public NCWindOnlyQualification setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public class NCWindOnlyQuestionnaire extends Questionnaire<NCWindOnlyQuestionnaire>
    {
        public NCWindOnlyQuestionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }

        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }

        public NCWindOnlyQuestionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }

        public NCWindOnlyQuestionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }
    }
}
