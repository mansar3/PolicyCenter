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
		log("Navigated to page: " + expectedPanelTitle);
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
		    issuePolicy = By.id( errorBase + "JobWizardToolbarButtonSet:BindAndIssue-btnInnerEl"),
		    editpolicytransaction = By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"),
			bindOptionsIssueNow = By.id(errorBase + "JobWizardToolbarButtonSet:BindOptions:IssueNow-itemEl"),
		    policychangeIssuePolicy = By.id("PolicyChangeWizard:PolicyChangeWizard_QuoteScreen:JobWizardToolbarButtonSet:Issuance-btnInnerEl"),
		    policychangeIssuePolicyPrint = By.id("PolicyChangeWizard:PolicyChangeWizard_QuoteScreen:JobWizardToolbarButtonSet:Issuance:issuancePrint-textEl"),
	     	policychangeWithdrawTransaction = By.id("PolicyChangeWizard:PolicyChangeWizard_QuoteScreen:JobWizardToolbarButtonSet:WithdrawJob-btnInnerEl"),
		    clickpolicynumber = By.xpath(".//*[@id='PolicyChangeWizard:JobWizardInfoBar:PolicyNumber-btnInnerEl']/span[2]");



	}

	public T clickTopPolicyNumber()
	{
		sh.waitForNoMask();
		sh.clickElement(by.clickpolicynumber);
		return (T) this;
	}

	public T clickIssuePolicy(){
		sh.waitForNoMask();
		sh.clickElement(by.issuePolicy);
		return (T) this;
	}

	public T clickPolicyChangeIssuePolicy(){
		sh.waitForNoMask();
		sh.clickElement(by.policychangeIssuePolicy);
		return (T) this;
	}

	public T clickPolicyIssuePolicyPrint(){
		sh.waitForNoMask();
		sh.clickElement(by.policychangeIssuePolicyPrint);
		return (T) this;
	}


	public T clickPolicyChangeWithdrawTransaction(){
		sh.waitForNoMask();
		sh.clickElement(by.policychangeWithdrawTransaction);
		return (T) this;
	}

	public T clickEditPolicyTransaction(){
		sh.waitForNoMask();
		sh.clickElement(by.editpolicytransaction);
		return (T) this;

	}

	protected String quoteErrorMessage()
	{
		sh.waitForNoMask();
		String Error = sh.driver.findElement(By.xpath(".//*[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']/div[1]")).getText();
		return Error;
	}
	protected String quoteErrorMessage2()
	{
		sh.waitForNoMask();
		String Error = sh.driver.findElement(By.xpath(".//*[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']/div[2]")).getText();
		return Error;
	}
	protected String quoteErrorMessage3()
	{
		sh.waitForNoMask();
		String Error = sh.driver.findElement(By.xpath(".//*[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']/div[3]")).getText();
		return Error;
	}
	protected String quoteErrorMessage4()
	{
		sh.waitForNoMask();
		String Error = sh.driver.findElement(By.xpath(".//*[@id='WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs']/div[4]")).getText();
		return Error;
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
	protected T accept()
	{
		sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		return (T) this;

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
			log("Navigated to page: " + expectedPanelTitle);
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
			sh.waitForNoMask();
			log("Consenting to rate...");
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
