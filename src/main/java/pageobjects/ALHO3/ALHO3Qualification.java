package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

public class ALHO3Qualification extends Qualification<ALHO3Qualification>
{
	public ALHO3Qualification(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public ALHO3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3Questionnaire questionnaire = new ALHO3Questionnaire(sh);

	public ALHO3Qualification setOfferingSelection(String offeringSelection)
	{
		return super.setOfferingSelection(offeringSelection);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}

	public ALHO3Qualification setPolicyType(String policyType)
	{
		return super.setPolicyType(policyType);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}

	public ALHO3PolicyInfo next()
	{
		super.policyInfoNext();
		return new ALHO3PolicyInfo(sh, path);
	}

	public class ALHO3Questionnaire extends Questionnaire<ALHO3Questionnaire>
	{

		public ALHO3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}
		public ALHO3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}
		public ALHO3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}
	}
}