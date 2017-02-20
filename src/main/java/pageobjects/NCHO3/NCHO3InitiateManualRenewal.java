package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3InitiateManualRenewal extends InitiateManualRenewal<NCHO3InitiateManualRenewal>
{
	public NCHO3InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public NCHO3InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public NCHO3InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public NCHO3InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public NCHO3InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public NCHO3InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public NCHO3InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public NCHO3InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public NCHO3InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public NCHO3InitiateManualRenewal setLastInspectionCompletionDate(String text)
	{
		return super.setLastInspectionCompletionDate(text);
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}
	public NCHO3InitiateManualRenewal setInflationGuard(String text)
	{
		return super.setInflationGuard(text);
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}
	public NCHO3InitiateManualRenewal setTheftCoverage(String text)
	{
		return super.setTheftCoverage(text);
	}

	public String getTheftCoverage()
	{
		return super.getTheftCoverage();
	}
	public NCHO3InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
	{
		return super.clickExcludeLossOfUseCoverage(bool);

	}
	public NCHO3InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public NCHO3Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new NCHO3Offerings(sh,path);
	}

}
