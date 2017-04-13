package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3InitiateManualRenewal extends InitiateManualRenewal<FLMH3InitiateManualRenewal> {

    public FLMH3InitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public FLMH3InitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public FLMH3InitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public FLMH3InitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public FLMH3InitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public FLMH3InitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public FLMH3InitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public FLMH3InitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public FLMH3InitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }
	public FLMH3InitiateManualRenewal setMobileHomePark(String text)
	{
		return super.setMobileHomePark(text);
	}

	public String getMobileHomePark()
	{
		return super.getMobileHomePark();
	}

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
//    public FLMH3InitiateManualRenewal setLastInspectionCompletionDate(String text)
//    {
//        return super.setLastInspectionCompletionDate(text);
//    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
//    public FLMH3InitiateManualRenewal setInflationGuard(String text)
//    {
//        return super.setInflationGuard(text);
//    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }

//    public FLMH3InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
//    {
//        return super.clickExcludeLossOfUseCoverage(bool);
//
//    }
    public FLMH3InitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public FLMH3Offerings nextAndAccept()
    {
        super.nextANDAccept();
        return new FLMH3Offerings(sh,path);
    }

}
