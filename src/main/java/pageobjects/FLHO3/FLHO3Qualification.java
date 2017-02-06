package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Qualification extends Qualification<FLHO3Qualification>
{
	public FLHO3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLHO3PolicyInfo(sh, path);
	}
	public FLHO3Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLHO3Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class FLHO3Questionnaire extends Questionnaire<FLHO3Questionnaire>
	{
		public FLHO3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}
		protected FLHO3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}
		protected FLHO3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}

	}



}
