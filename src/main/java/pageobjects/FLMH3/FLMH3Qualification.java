package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3Qualification extends Qualification<FLMH3Qualification> {

    public FLMH3Questionnaire questionnaire = new FLMH3Questionnaire(sh);
    public FLMH3Qualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3PolicyInfo next()
    {
        super.policyInfoNext();
        return new FLMH3PolicyInfo(sh, path);
    }
    public FLMH3Qualification setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public FLMH3Qualification setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public class FLMH3Questionnaire extends Questionnaire<FLMH3Questionnaire>
    {
        public FLMH3Questionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }
        public FLMH3Questionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }
        public FLMH3Questionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }

    }
}
