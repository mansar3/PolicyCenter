package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 11/23/16.
 */
public class InitiateManualRenewal extends CenterPanelBase
{
	private InitiateManualRenewalBy by;
	public InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Initiate Manual Renewal";
		path = Path.POLICYRENEWAL;
		by = new InitiateManualRenewalBy();
		waitForTitle(sh);
	}
	static class InitiateManualRenewalBy
	{

		static final String manualBase = "InitManualRenewalPage:",
							producerBase = manualBase+"ProducerSelection_fliInputSet:";

		static final By		organization = By.id(producerBase + "Producer-inputEl"),
							producerCode = By.id(producerBase + "ProducerCode-inputEl"),
							baseState = By.id(manualBase + "StateSelection_fliInputSet:DefaultBaseState-inputEl"),
							product = By.id(manualBase + "products-inputEl"),
							policyType = By.id(manualBase + "policytypes-inputEl"),
							legacyPolicyNumber = By.id(manualBase + "policyNumber-inputEl"),
							originalEffectiveDate = By.id(manualBase + "PolicyOrigEffDate-inputEl"),
							effectiveDate = By.id(manualBase + "ExtEffDate-inputEl"),
							inspectionDate = By.id(manualBase + "LastInspectionDate-inputEl"),
							inflationGuard = By.id(manualBase + "inflationGuard-inputEl"),
							excludeLossOfUseCoverageNo = By.id(manualBase + "excludeLossOfUse_false-inputEl"),
							excludeLossOfUseCoverageYes = By.id(manualBase + "excludeLossOfUse_true-inputEl"),
							theftCoverage = By.id(manualBase + "theft-inputEl");
	}
	
	public String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	public InitiateManualRenewal setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.waitForNoMask();
		return this;
	}
	public String getProducerCode()
	{
		return sh.getValue(by.producerCode);
	}
	
	public InitiateManualRenewal setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getBaseState()
	{
		return sh.getValue(by.baseState);
	}
	
	public InitiateManualRenewal setBaseState(String baseState)
	{
		sh.setText(by.baseState, baseState);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getProduct()
	{
		return sh.getValue(by.product);
	}
	
	public InitiateManualRenewal setProduct(String product)
	{
		sh.setText(by.product, product);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getPolicyType()
	{
		return sh.getValue(by.policyType);
	}
	
	public InitiateManualRenewal setPolicyType(String policyType)
	{
		sh.setText(by.policyType, policyType);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getLegacyPolicyNumber()
	{
		return sh.getValue(by.legacyPolicyNumber);
	}
	
	public InitiateManualRenewal setLegacyPolicyNumber(String legacyPolicyNumber)
	{
		sh.setText(by.legacyPolicyNumber, legacyPolicyNumber);
		return this;
	}
	public String getOriginalEffectiveDate()
	{
		return sh.getValue(by.originalEffectiveDate);
	}
	
	public InitiateManualRenewal setOriginalEffectiveDate(String originalEffectiveDate)
	{
		sh.setText(by.originalEffectiveDate, originalEffectiveDate);
		sh.waitForNoMask();
		return this;
	}
	public String getEffectiveDate()
	{
		return sh.getValue(by.effectiveDate);
	}

	public InitiateManualRenewal setEffectiveDate(String effectiveDate)
	{
		sh.setText(by.effectiveDate, effectiveDate);
		sh.waitForNoMask();
		return this;
	}
	public String getLastInspectionCompletionDate()
	{
		return sh.getValue(by.inspectionDate);
	}
	
	public InitiateManualRenewal setLastInspectionCompletionDate(String inspectionDate)
	{
		sh.setText(by.inspectionDate, inspectionDate);
		sh.waitForNoMask();
		return this;
	}
	public String getInflationGuard()
	{
		return sh.getValue(by.inflationGuard);
	}
	
	public InitiateManualRenewal setInflationGuard(String inflationGuard)
	{
		sh.setText(by.inflationGuard, inflationGuard);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public String getTheftCoverage()
	{
		return sh.getValue(by.theftCoverage);
	}
	
	public InitiateManualRenewal setTheftCoverage(String theftCoverage)
	{
		sh.setText(by.theftCoverage, theftCoverage);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	
	public InitiateManualRenewal clickExcludeLossOfUseCoverage(String bool)
	{

		if(bool.toLowerCase() == "true")
			sh.clickElement(by.excludeLossOfUseCoverageYes);
		else
			sh.clickElement(by.excludeLossOfUseCoverageNo);
		sh.waitForNoMask();

		return this;
	}

	public InitiateManualRenewal nextAndDismiss()
	{
		sh.clickElement(By.id("InitManualRenewalPage:NewManualConvertRenewal-btnInnerEl"));
		sh.waitForNoMask();
		dismiss();
		return this;

	}
	public Offerings nextAndAccept()
	{
		sh.clickElement(By.id("InitManualRenewalPage:NewManualConvertRenewal-btnInnerEl"));
		sh.waitForNoMask();
		accept();
		return new Offerings(sh,path);
	}

	private void accept()
	{
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
	}
	private InitiateManualRenewal dismiss()
	{
		sh.clickElement(By.xpath(".//*[text()= 'Cancel']"));
		return this;
	}
}
