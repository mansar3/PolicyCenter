package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import Helpers.TableBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Qualification<T extends Qualification> extends CenterPanelBase
{
	private QualificationBy by = new QualificationBy();
	public Questionnaire questionnaire;
	public Qualification(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Qualification";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
		questionnaire = new Questionnaire(sh);
	}

	protected String getOfferingSelection()
	{
		return sh.getValue(by.offeringSelection);
	}

	protected T setOfferingSelection(String offeringSelection)
	{
		sh.setText(by.offeringSelection, offeringSelection);
		sh.tab();
		return (T)this;
	}
	protected T setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}

	protected T policyInfoNext()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return (T)this;
	}

	public static class Questionnaire<T extends Questionnaire> extends TableBase
	{
		protected Questionnaire(CenterSeleniumHelper sh)
		{
			super(By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:PreQualQuestionSetsDV:QuestionSetsDV:0:QuestionSetLV-body"), sh);
			sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(tableId));
		}

		protected String getQuestionText(int questionNum)
		{
			return getTextTableElement(questionNum, 1);
		}

		private T answerQuestion(int questionNum, Boolean bool)
		{
			By answerBy = By.xpath("//*[@id='SubmissionWizard:SubmissionWizard_PreQualificationScreen:PreQualQuestionSetsDV:QuestionSetsDV:0:QuestionSetLV-body']//table["
			+ questionNum + "]//table[1]//input[@inputvalue = '" + String.valueOf(bool).toLowerCase() +"']");
//			By answerBy = new ByChained(getTableBy(questionNum, 3), By.cssSelector("tbody input[inputvalue='"+bool+"']"));
//			if(sh.driver.findElements(answerBy).size() > 1)
//			{
//				System.out.println("Found too many elements on question: " + questionNum);
//				answerBy = By.cssSelector("[id='SubmissionWizard:SubmissionWizard_PreQualificationScreen:PreQualQuestionSetsDV:QuestionSetsDV:0:QuestionSetLV-body'] tbody tr:nth-of-type(" + questionNum + ") td:nth-of-type(3) tbody input[inputvalue='false']");
//			}
			sh.waitForNoMask();
			sh.clickElement(answerBy);
			return (T)this;
		}


		protected T answerYes(int questionNum)
		{
			return answerQuestion(questionNum, true);
		}

		protected T answerNo(int questionNum)
		{
			return answerQuestion(questionNum, false);
		}
	}

	private class QualificationBy{
		final String qualificationBase = "SubmissionWizard:SubmissionWizard_PreQualificationScreen:";
		final By		policyType = By.id(qualificationBase + "PolicyTypeDV:HOPolicyType-inputEl"),
							offeringSelection = By.id(qualificationBase + "OfferingSelection-inputEl");
	}
}