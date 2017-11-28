package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/23/16.
 */
public class InitiateManualRenewal<T extends InitiateManualRenewal> extends CenterPanelBase
{
	private InitiateManualRenewalBy by;
	public InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Initiate Manual Renewal";
		path = Path.POLICYRENEWAL;
		by = new InitiateManualRenewalBy();
		waitForTitle(sh);
		log("Navigated to page: " + expectedPanelTitle );
	}
	public class InitiateManualRenewalBy
	{

		final String manualBase = "InitManualRenewalPage:",
							producerBase = manualBase+"ProducerSelection_fliInputSet:";

		final By		organization = By.id(producerBase + "Producer-inputEl"),
							producerCode = By.id(producerBase + "ProducerCode-inputEl"),
							baseState = By.id(manualBase + "StateSelection_fliInputSet:DefaultBaseState-inputEl"),
							product = By.id(manualBase + "products-inputEl"),
							policyType = By.id(manualBase + "policytypes-inputEl"),
							legacyPolicyNumber = By.id(manualBase + "policyNumber-inputEl"),
							originalEffectiveDate = By.id(manualBase + "PolicyOrigEffDate-inputEl"),
							effectiveDate = By.id(manualBase + "ExtEffDate-inputEl"),
							mobileHomePark = By.id(manualBase + "ManHomeParkCode_fli-inputEl"),
							inspectionDate = By.id(manualBase + "LastInspectionDate-inputEl"),
							inflationGuard = By.id(manualBase + "inflationGuard-inputEl"),
							excludeLossOfUseCoverageNo = By.id(manualBase + "excludeLossOfUse_false-inputEl"),
							excludeLossOfUseCoverageYes = By.id(manualBase + "excludeLossOfUse_true-inputEl"),
							theftCoverage = By.id(manualBase + "theft-inputEl");
	}
	protected String getMobileHomePark()
	{
		return sh.getValue(by.mobileHomePark);
	}
	
	protected T setMobileHomePark(String mobileHomePark)
	{
		sh.setText(by.mobileHomePark, mobileHomePark);
		return (T)this;
	}
	protected String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	protected T  setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getProducerCode()
	{
		return sh.getValue(by.producerCode);
	}
	
	protected T  setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getBaseState()
	{
		return sh.getValue(by.baseState);
	}
	
	protected T  setBaseState(String baseState)
	{
		sh.setText(by.baseState, baseState);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getProduct()
	{
		return sh.getValue(by.product);
	}
	
	protected T  setProduct(String product)
	{
		sh.setText(by.product, product);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}
	
	protected T  setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getLegacyPolicyNumber()
	{
		return sh.getValue(by.legacyPolicyNumber);
	}
	
	protected T  setLegacyPolicyNumber(String legacyPolicyNumber)
	{
		sh.setText(by.legacyPolicyNumber, legacyPolicyNumber);
		return (T)this;
	}
	protected String getOriginalEffectiveDate()
	{
		return sh.getValue(by.originalEffectiveDate);
	}
	
	protected T  setOriginalEffectiveDate(String originalEffectiveDate)
	{
		sh.setText(by.originalEffectiveDate, originalEffectiveDate);
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getEffectiveDate()
	{
		return sh.getValue(by.effectiveDate);
	}

	protected T  setEffectiveDate(String effectiveDate)
	{
		sh.setText(by.effectiveDate, effectiveDate);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getLastInspectionCompletionDate()
	{
		return sh.getValue(by.inspectionDate);
	}
	
	protected T  setLastInspectionCompletionDate(String inspectionDate)
	{
		sh.setText(by.inspectionDate, inspectionDate);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getInflationGuard()
	{
		return sh.getValue(by.inflationGuard);
	}
	
	protected T  setInflationGuard(String inflationGuard)
	{
		sh.setText(by.inflationGuard, inflationGuard);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	protected String getTheftCoverage()
	{
		return sh.getValue(by.theftCoverage);
	}
	
	protected T setTheftCoverage(String theftCoverage)
	{
		sh.setText(by.theftCoverage, theftCoverage);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	
	protected T  clickExcludeLossOfUseCoverage(String bool)
	{

		if(bool.toLowerCase() == "true")
			sh.clickElement(by.excludeLossOfUseCoverageYes);
		else
			sh.clickElement(by.excludeLossOfUseCoverageNo);
		sh.waitForNoMask();

		return (T)this;
	}

	protected T  nextANDDismiss()
	{
		sh.clickElement(By.id("InitManualRenewalPage:NewManualConvertRenewal-btnInnerEl"));
		sh.waitForNoMask();
		dismiss();
		return (T)this;

	}
	protected T nextANDAccept()
	{
		sh.waitForPageLoad();
		sh.clickElement(By.id("InitManualRenewalPage:NewManualConvertRenewal-btnInnerEl"));
		sh.waitForNoMask();
		accept();
		return (T)this;
	}
	protected T nextRefreshAndAccept()
	{
		sh.waitForPageLoad();
		sh.clickElement(By.id("InitManualRenewalPage:NewManualConvertRenewal-btnInnerEl"));
		sh.waitForNoMask();
		sh.driver.navigate().refresh();
		nextANDAccept();
		return (T)this;
	}

	private void accept()
	{
		sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
	}
	private T  dismiss()
	{
		sh.clickElement(By.xpath(".//*[text()= 'Cancel']"));
		return (T)this;
	}
}
