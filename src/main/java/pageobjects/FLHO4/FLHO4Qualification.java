package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Qualification  extends Qualification<FLHO4Qualification> {

    public FLHO4Questionnaire questionnaire = new FLHO4Questionnaire(sh);
    public FLHO4Qualification(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4PolicyInfo next()
    {
        super.policyInfoNext();
        return new FLHO4PolicyInfo(sh, path);
    }
    public FLHO4Qualification setOfferingSelection(String text)
    {
        return super.setOfferingSelection(text);
    }

    public String getOfferingSelection()
    {
        return super.getOfferingSelection();
    }
    public FLHO4Qualification setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public class FLHO4Questionnaire extends Questionnaire<FLHO4Questionnaire>
    {
        public FLHO4Questionnaire(CenterSeleniumHelper sh)
        {
            super(sh);
        }
        public String getQuestionText(int questionNum)
        {
            return super.getQuestionText(questionNum);
        }
        public FLHO4Questionnaire answerYes(int questionNum)
        {
            return super.answerYes(questionNum);
        }
        public FLHO4Questionnaire answerNo(int questionNum)
        {
            return super.answerNo(questionNum);
        }

    }
}
