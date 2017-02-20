package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.WestPanel.WestPanelBase;

/**
 * Created by aansari on 11/21/16.
 */
public abstract class Quote<T extends Quote> extends CenterPanelBase
{
	public WestPanelBase westPanel;
	protected String quoteBase, errorBase,tabBase;
	private QuoteBy by ;
	public Quote(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = setExpectedTitle();
		waitToBeQuoted(sh);
		setID(path);
		by = new QuoteBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
		westPanel = new WestPanelBase(sh);
	}
	private String setExpectedTitle()
	{
		switch(path)
		{
			case POLICYRENEWAL:
				return "View Quote";

				default:
				return "Quote";
		}
	}
	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				quoteBase = "SubmissionWizard:SubmissionWizard_QuoteScreen:Quote_SummaryDV:";
				errorBase = "SubmissionWizard:SubmissionWizard_QuoteScreen:";

				break;
			case POLICYRENEWAL:
				quoteBase = "RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:Quote_SummaryDV:";
				errorBase = "RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:";


		}
	}
	public class QuoteBy
	{
		By	totalPremium = By.id(quoteBase + "TotalPremium-inputEl"),
			annualizedTotalCost = By.id(quoteBase + "TotalAnnualCost-inputEl"),
			annualizedTotalCostIncludingWhenSafe = By.id(quoteBase + "TotalAnnualCostPlusWhenSafe-inputEl"),
			underWritingApprovalError = By.id(errorBase + "WarningsPanelSet:0:PanelSet:Warning"),
			overrideRating = By.id(errorBase + "RatingCumulDetailsPanelSet:RatingOverrideButtonDV:RatingOverrideButtonDV:OverrideRating"),

			bindOptions = By.id(errorBase + "JobWizardToolbarButtonSet:BindOptions-btnInnerEl"),
			bindOptionsRenew = By.id(errorBase + "JobWizardToolbarButtonSet:BindOptions:SendToRenewal-itemEl"),
			bindOptionsIssueNow = By.id(errorBase + "JobWizardToolbarButtonSet:BindOptions:IssueNow-itemEl");


	}
	public T clickRenew()
	{
		sh.clickElement(by.bindOptions);
		sh.clickElement(by.bindOptionsRenew);
		accept();
		return (T)this;

	}
	public T clickIssueNow()
	{
		sh.clickElement(by.bindOptions);
		sh.clickElement(by.bindOptionsIssueNow);
		accept();
		return(T)this;
	}
	private T  dismiss()
	{
		sh.clickElement(By.xpath(".//*[text()= 'Cancel']"));
		return (T)this;
	}
	private void accept()
	{
		sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
	}

	protected int getTotalPremium()
	{
		return Integer.parseInt(sh.getText(by.totalPremium));
	}
	protected String getAnnualizedTotalCost()
	{
		return sh.getText(by.annualizedTotalCost);
	}
	protected String getAnnualizedTotalCostIncludingWhenSafe()
	{
		return sh.getText(by.annualizedTotalCostIncludingWhenSafe);
	}
	protected T backRiskAnalysis()
	{
		clickBack();
		return (T)this;
	}
	protected T backPolicyReview()
	{
		clickBack();
		return (T)this;
	}
	protected boolean isUnderWritingApprovalNeeded()
	{
		String message = "This quote will require underwriting approval prior to binding.";
		if(sh.isDisplayed(by.underWritingApprovalError) && sh.getText(by.underWritingApprovalError).equals(message))
			return true;
		return false;
	}
	protected T overrideRating()
	{
		sh.clickElement(by.overrideRating);
		return (T)this;
	}
	
	
	public class RatingOverrides<T extends RatingOverrides> extends CenterPanelBase
	{
		RatingOverridesBy by;

		public RatingOverrides(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			expectedPanelTitle = "Rating Overrides";
			waitForTitle(sh);
			System.out.println("Navigated to page: " + expectedPanelTitle);
			by = new RatingOverridesBy();

		}

		public class RatingOverridesBy
		{
			By termAmountReadOnly = By.xpath(".//*[@id='RatingOverridePopup:RatingOverridePanelSet:1-body']//div[text() = 'CTR']/../following-sibling::td[2]/div"),
			termAmountInput = By.name("c2"),
			reasonReadOnly = By.xpath(".//*[@id='RatingOverridePopup:RatingOverridePanelSet:1-body']//div[text() = 'CTR']/../following-sibling::td[3]/div"),
			reasonInput = By.name("c3"),
			rerate = By.id("RatingOverridePopup:Update-btnInnerEl"),
			cancel = By.id("RatingOverridePopup:Cancel"),
			clearAll = By.id("RatingOverridePopup:ClearAllButton-btnInnerEl");

		}
		protected T rerate()
		{
			sh.clickElement(by.rerate);
			return (T)this;
		}
		protected T cancel()
		{
			sh.clickElement(by.cancel);
			return (T)this;
		}
		public T clickClearAll()
		{
			sh.clickElement(by.clearAll);
			return (T)this;
		}
		
		
		
		public String getTermAmountReadOnly()
		{
			return sh.getText(by.termAmountReadOnly);
		}

		public String getTermAmountInput()
		{
			return sh.getValue(by.termAmountInput);
		}

		public T setTermAmount(String termAmount)
		{
			sh.clickElement(by.termAmountReadOnly) ;
			sh.waitForElementToAppear(by.termAmountInput);
			sh.setText(by.termAmountInput, termAmount);
			return (T) this;
		}

		public String getReasonReadOnly()
		{
			return sh.getText(by.reasonReadOnly);
		}
		public String getReasonInput()
		{
			return sh.getText(by.reasonInput);
		}
		public T setReason(String reason)
		{
			sh.clickElement(by.reasonReadOnly);
			sh.waitForElementToAppear(by.reasonInput);
			sh.setText(by.reasonInput,reason);
			return (T)this;
		}

	}
}
