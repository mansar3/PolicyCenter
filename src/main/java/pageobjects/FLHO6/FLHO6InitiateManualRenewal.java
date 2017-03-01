package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6InitiateManualRenewal extends InitiateManualRenewal<FLHO6InitiateManualRenewal>
{
	public FLHO6InitiateManualRenewal(CenterSeleniumHelper sh)
	{
		super(sh);
	}
	public FLHO6InitiateManualRenewal setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public FLHO6InitiateManualRenewal setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public FLHO6InitiateManualRenewal setBaseState(String text)
	{
		return super.setBaseState(text);
	}

	public String getBaseState()
	{
		return super.getBaseState();
	}
	public FLHO6InitiateManualRenewal setProduct(String text)
	{
		return super.setProduct(text);
	}

	public String getProduct()
	{
		return super.getProduct();
	}
	public FLHO6InitiateManualRenewal setPolicyType(String text)
	{
		return super.setPolicyType(text);
	}

	public String getPolicyType()
	{
		return super.getPolicyType();
	}
	public FLHO6InitiateManualRenewal setLegacyPolicyNumber(String text)
	{
		return super.setLegacyPolicyNumber(text);
	}

	public String getLegacyPolicyNumber()
	{
		return super.getLegacyPolicyNumber();
	}
	public FLHO6InitiateManualRenewal setOriginalEffectiveDate(String text)
	{
		return super.setOriginalEffectiveDate(text);
	}

	public String getOriginalEffectiveDate()
	{
		return super.getOriginalEffectiveDate();
	}
	public FLHO6InitiateManualRenewal setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}

	public String getLastInspectionCompletionDate()
	{
		return super.getLastInspectionCompletionDate();
	}

	public String getInflationGuard()
	{
		return super.getInflationGuard();
	}


	public FLHO6InitiateManualRenewal nextAndDismiss()
	{
		return super.nextANDDismiss();

	}
	public FLHO6Offerings nextAndAccept()
	{
		super.nextANDAccept();
		return new FLHO6Offerings(sh,path);
	}





}
