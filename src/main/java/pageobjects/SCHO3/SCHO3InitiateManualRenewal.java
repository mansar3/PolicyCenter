package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3InitiateManualRenewal extends InitiateManualRenewal<SCHO3InitiateManualRenewal>
{
	public SCHO3InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCHO3InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCHO3InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCHO3InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public SCHO3InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public SCHO3InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCHO3InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public SCHO3InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public SCHO3InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCHO3InitiateManualRenewal setLastInspectionCompletionDate(String text)
	{
		return super.setLastInspectionCompletionDate(text);
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}
	public SCHO3InitiateManualRenewal setInflationGuard(String text)
	{
		return super.setInflationGuard(text);
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}

	public SCHO3InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
	{
		return super.clickExcludeLossOfUseCoverage(bool);

	}
	public SCHO3InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public SCHO3Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new SCHO3Offerings(sh,path);
	}

}
