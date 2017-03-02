package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3Qualification extends Qualification<SCDP3Qualification>
{
		public SCDP3Questionnaire questionnaire = new SCDP3Questionnaire(sh);
	public SCDP3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3PolicyInfo next()
	{
		super.policyInfoNext();
		return new SCDP3PolicyInfo(sh, path);
	}
	public SCDP3Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public SCDP3Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class SCDP3Questionnaire extends Questionnaire<SCDP3Questionnaire>
	{
		public SCDP3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}

		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}

		public SCDP3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}

		public SCDP3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}
	}
}
