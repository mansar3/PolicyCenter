package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Qualification extends Qualification<SCHO3Qualification>
{
		public SCHO3Questionnaire questionnaire = new SCHO3Questionnaire(sh);
	public SCHO3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCHO3PolicyInfo(sh, path);
	}
	public SCHO3Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCHO3Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class SCHO3Questionnaire extends Questionnaire<SCHO3Questionnaire>
	{
		public SCHO3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}

		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}

		public SCHO3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}

		public SCHO3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}
	}
}
