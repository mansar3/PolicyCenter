package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import Helpers.TableBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Qualification extends CenterPanelBase
{
	private QualificationBy by;
	public Questionnaire questionnaire;
	public Qualification(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Qualification";
		waitForTitle(sh);
		System.out.println("Navigated to page: " + getTitle());
		questionnaire = new Questionnaire(sh);
	}

	public Qualification setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		return this;
	}

	public String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}

	public PolicyInfo next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new PolicyInfo(sh);
	}

	public static class Questionnaire extends TableBase
	{
		private Questionnaire(CenterSeleniumHelper sh)
		{
			super(By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:PreQualQuestionSetsDV:QuestionSetsDV:0:QuestionSetLV-body"), sh);
			sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(tableId));
		}

		public String getQuestionText(int questionNum)
		{
			return getTextTableElement(questionNum, 1);
		}

		private Questionnaire answerQuestion(int questionNum, Boolean bool)
		{
			By answerBy = new ByChained(getTableBy(questionNum, 3), By.cssSelector("tbody input[inputvalue='"+bool+"']"));
			if(sh.driver.findElements(answerBy).size() > 1)
			{
				System.out.println("Found too many elements on question: " + questionNum);
				answerBy = By.cssSelector("[id='SubmissionWizard:SubmissionWizard_PreQualificationScreen:PreQualQuestionSetsDV:QuestionSetsDV:0:QuestionSetLV-body'] tbody tr:nth-of-type(" + questionNum + ") td:nth-of-type(3) tbody input[inputvalue='false']");
			}
			sh.waitForNoMask(5);
			sh.clickElement(answerBy);
			return this;
		}

		public Questionnaire answerYes(int questionNum)
		{
			return answerQuestion(questionNum, true);
		}

		public Questionnaire answerNo(int questionNum)
		{
			return answerQuestion(questionNum, false);
		}
	}

	public static class QualificationBy{
		public static final By	policyType = By.id("SubmissionWizard:SubmissionWizard_PreQualificationScreen:PolicyTypeDV:HOPolicyType-inputEl");
	}
}