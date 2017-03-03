package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4Qualification extends Qualification<SCHO4Qualification> {

    public SCHO4Questionnaire questionnaire = new SCHO4Questionnaire(sh);
    public SCHO4Qualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4PolicyInfo next()
    {
        super.policyInfoNext();
        return new SCHO4PolicyInfo(sh, path);
    }
    public SCHO4Qualification setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public SCHO4Qualification setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public class SCHO4Questionnaire extends Questionnaire<SCHO4Questionnaire>
    {
        public SCHO4Questionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }

        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }

        public SCHO4Questionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }

        public SCHO4Questionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }
    }
}
