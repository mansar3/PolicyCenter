package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Qualification extends Qualification<FLHO6Qualification>
{
	public FLHO6Questionnaire questionnaire = new FLHO6Questionnaire(sh);
	public FLHO6Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLHO6PolicyInfo(sh, path);
	}
	public FLHO6Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLHO6Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public class FLHO6Questionnaire extends Questionnaire<FLHO6Questionnaire>
	{
		public FLHO6Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}
		public FLHO6Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}
		public FLHO6Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}

	}



}
