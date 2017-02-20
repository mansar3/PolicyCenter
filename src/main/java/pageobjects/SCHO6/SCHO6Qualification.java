package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Qualification extends Qualification<SCHO6Qualification>
{
		public SCHO6Questionnaire questionnaire = new SCHO6Questionnaire(sh);
	public SCHO6Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCHO6PolicyInfo(sh, path);
	}
	public SCHO6Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCHO6Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class SCHO6Questionnaire extends Questionnaire<SCHO6Questionnaire>
	{
		public SCHO6Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}

		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}

		public SCHO6Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}

		public SCHO6Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}
	}
}
