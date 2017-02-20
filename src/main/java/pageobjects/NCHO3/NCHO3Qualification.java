package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Qualification extends Qualification<NCHO3Qualification>
{
		public NCHO3Questionnaire questionnaire = new NCHO3Questionnaire(sh);
	public NCHO3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new NCHO3PolicyInfo(sh, path);
	}
	public NCHO3Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public NCHO3Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class NCHO3Questionnaire extends Questionnaire<NCHO3Questionnaire>
	{
		public NCHO3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}

		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}

		public NCHO3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}

		public NCHO3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}
	}
}
