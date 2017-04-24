package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Qualification;

/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Qualification extends Qualification<FLDP3Qualification>
{
	public FLDP3Questionnaire questionnaire = new FLDP3Questionnaire(sh);
	public FLDP3Qualification(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3PolicyInfo next()
	{
		super.policyInfoNext();
		return new FLDP3PolicyInfo(sh, path);
	}
	public FLDP3Qualification setOfferingSelection(String text)
	{
		return super.setOfferingSelection(text);
	}

	public String getOfferingSelection()
	{
		return super.getOfferingSelection();
	}
	public FLDP3Qualification setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLDP3PreQuoteIssues clickQuote()
	{
		super.clickQuote();
		return new FLDP3PreQuoteIssues(sh, path);
	}

	public class FLDP3Questionnaire extends Questionnaire<FLDP3Questionnaire>
	{
		public FLDP3Questionnaire(CenterSeleniumHelper sh)
		{
			super(sh);
		}
		public String getQuestionText(int questionNum)
		{
			return super.getQuestionText(questionNum);
		}
		public FLDP3Questionnaire answerYes(int questionNum)
		{
			return super.answerYes(questionNum);
		}
		public FLDP3Questionnaire answerNo(int questionNum)
		{
			return super.answerNo(questionNum);
		}

	}



}
