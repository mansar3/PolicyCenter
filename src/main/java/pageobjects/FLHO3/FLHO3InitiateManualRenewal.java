package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3InitiateManualRenewal extends InitiateManualRenewal<FLHO3InitiateManualRenewal>
{
	public FLHO3InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public FLHO3InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public FLHO3InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public FLHO3InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public FLHO3InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public FLHO3InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLHO3InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public FLHO3InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public FLHO3InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public FLHO3InitiateManualRenewal setLastInspectionCompletionDate(String text)
	{
		return super.setLastInspectionCompletionDate(text);
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}
	public FLHO3InitiateManualRenewal setInflationGuard(String text)
	{
		return super.setInflationGuard(text);
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}

	public FLHO3InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
	{
		return super.clickExcludeLossOfUseCoverage(bool);

	}
	public FLHO3InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public FLHO3Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new FLHO3Offerings(sh,path);
	}





}
