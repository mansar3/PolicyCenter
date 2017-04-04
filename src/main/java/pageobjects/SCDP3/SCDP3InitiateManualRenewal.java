package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3InitiateManualRenewal extends InitiateManualRenewal<SCDP3InitiateManualRenewal>
{
	public SCDP3InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public SCDP3InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCDP3InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCDP3InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public SCDP3InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public SCDP3InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public SCDP3InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public SCDP3InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}
	public SCDP3InitiateManualRenewal setTheftCoverage(String theftCoverage)
	{
		return super.setTheftCoverage(theftCoverage);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public SCDP3InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCDP3InitiateManualRenewal setLastInspectionCompletionDate(String text)
	{
		return super.setLastInspectionCompletionDate(text);
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}
	public SCDP3InitiateManualRenewal setInflationGuard(String text)
	{
		return super.setInflationGuard(text);
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}

	public SCDP3InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
	{
		return super.clickExcludeLossOfUseCoverage(bool);

	}
	public SCDP3InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public SCDP3Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new SCDP3Offerings(sh,path);
	}

}
