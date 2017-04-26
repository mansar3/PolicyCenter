package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by aansari on 4/20/17.
 */
public class Payment<T extends CenterPanelBase> extends CenterPanelBase
{
	private PaymentBy by;
	protected String paymentBase;
	public Payment(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Payment";
		waitForTitle(sh);
		setID(path);
		by = new PaymentBy();
	}
	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				paymentBase = "SubmissionWizard:SubmissionWizard_PaymentScreen:BillingAdjustmentsDV:";
				break;
			case POLICYRENEWAL:
				paymentBase = "RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_PaymentScreen:BillingAdjustmentsDV:";
		}
	}
	public class PaymentBy
	{
		String psBase = paymentBase + "PlanInputSet:PaymentsPlanDV:PaymentsPlanInputSet:InstallmentPlan-tbody";
		By	twoPay = By.xpath("//*[@id = '" + psBase + "']//div[text() = '2 Pay']/../..//td[1]/div/div"),
			fourPay = By.xpath("//*[@id = '" + psBase + "']//div[text() = '4 Pay']/../..//td[1]/div/div"),
			fullPay = By.xpath("//*[@id = '" + psBase + "']//div[text() = 'Full Pay']/../..//td[1]/div/div"),
			billingContactButton = By.id(paymentBase + "AccountContactBillingInputSet:ChangeBillingContactButton:ChangeBillingContactButtonMenuIcon"),
			mortgagePremiumFinance = By.id(paymentBase + "AccountContactBillingInputSet:ChangeBillingContactButton:MortgagePFC-itemEl");
			//Mortgagee
	}
	public T clickTwoPay()
	{
		sh.clickElement(by.twoPay);
		sh.waitForNoMask();
		return (T)this;
	}
	public T clickFourPay()
	{
		sh.clickElement(by.fourPay);
		sh.waitForNoMask();
		return (T)this;
	}
	public T clickFullPay()
	{
		sh.clickElement(by.fullPay);
		sh.waitForNoMask();
		return (T)this;
	}
	public T selectMortgagePremiumFinance(int index)
	{
		sh.clickElement(by.billingContactButton);
		sh.waitForNoMask();
		//sh.clickElement(by.mortgagePremiumFinance);
		WebElement mpf = sh.driver.findElement(by.mortgagePremiumFinance);

		Actions build  = new Actions(sh.driver);
		build.moveToElement(mpf).build().perform();

		sh.waitForElementToAppear(By.id(paymentBase + "AccountContactBillingInputSet:ChangeBillingContactButton:MortgagePFC:"
		+ String.valueOf(index) + ":UnassignedMortgageContact-itemEl"));

		sh.clickElement(By.id(paymentBase + "AccountContactBillingInputSet:ChangeBillingContactButton:MortgagePFC:"
		+ String.valueOf(index) + ":UnassignedMortgageContact-itemEl"));
		sh.waitForNoMask();
		return (T)this;

	}



}
