package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 1/30/17.
 */
public abstract class PolicyReview<T extends PolicyReview> extends CenterPanelBase
{
	private PolicyReviewBy by;
	protected String buttonBase;
	public PolicyReview(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Policy Review";
		waitForTitle(sh);
		setID(path);
		by = new PolicyReviewBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}
	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				buttonBase = "SubmissionWizard:";
				break;
			case POLICYRENEWAL:
				buttonBase = "RenewalWizard:";
				break;


		}
	}
	public class PolicyReviewBy
	{
		By	back = By.id(buttonBase + "Prev-btnInnerEl"),
		    quote = By.id("PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
		    policychangereview = By.xpath(".//*[@id = 'PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:DifferencesPanelSet:DiffTreePanelSet:DiffTreePanelLV-body']//div[text() = 'No']/../following-sibling::td[1]"),
		    clickhangeconflicts = By.id("PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:OOSConflictsTab-btnInnerEl");
	}

	protected T clickChangeConflicts()
	{
		sh.clickElement(by.clickhangeconflicts);
		sh.waitForNoMask();
		return  (T)this;
	}

	protected T riskAnalysisBack()
	{
		sh.clickElement(by.back);
		return (T)this;
	}

	public T policyreviewpolicyChangeQuote()
	{
		sh.clickElement(by.quote);
		return (T) this;
	}

	public String getPolicyReviewChange()
	{
		return sh.getText(by.policychangereview);
	}

	protected class ChangeConflits<T extends ChangeConflits> extends CenterPanelBase
	{
		private ChangeConflitsBy by;
		protected ChangeConflits(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new ChangeConflitsBy();
		}

		protected class ChangeConflitsBy
		{
			protected final By changeConflits = By.id("PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:OOSConflictsTab-btnInnerEl");
			//underwritingquestions= By.xpath(".//*[@id='SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:UWQuestionsTab-btnInnerEl']");
		}

	}

}
