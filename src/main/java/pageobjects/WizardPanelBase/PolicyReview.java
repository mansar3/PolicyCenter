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
		By	back = By.id(buttonBase + "Prev-btnInnerEl");
	}

	public RiskAnalysis back()
	{
		sh.clickElement(by.back);
		return new RiskAnalysis(sh,path);
	}

}
