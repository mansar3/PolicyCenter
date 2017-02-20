package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6InitiateManualRenewal extends InitiateManualRenewal<SCHO6InitiateManualRenewal>
{
	public SCHO6InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCHO6InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCHO6InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCHO6InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public SCHO6InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public SCHO6InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCHO6InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public SCHO6InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public SCHO6InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCHO6InitiateManualRenewal setLastInspectionCompletionDate(String text)
	{
		return super.setLastInspectionCompletionDate(text);
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}
	public SCHO6InitiateManualRenewal setInflationGuard(String text)
	{
		return super.setInflationGuard(text);
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}
	public SCHO6InitiateManualRenewal setTheftCoverage(String text)
	{
		return super.setTheftCoverage(text);
	}

	public String getTheftCoverage()
	{
		return super.getTheftCoverage();
	}
	public SCHO6InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
	{
		return super.clickExcludeLossOfUseCoverage(bool);

	}
	public SCHO6InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public SCHO6Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new SCHO6Offerings(sh,path);
	}

}
