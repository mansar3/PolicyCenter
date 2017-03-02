package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4InitiateManualRenewal  extends InitiateManualRenewal<FLHO4InitiateManualRenewal> {
    public FLHO4InitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public FLHO4InitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public FLHO4InitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public FLHO4InitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public FLHO4InitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public FLHO4InitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public FLHO4InitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public FLHO4InitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public FLHO4InitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public FLHO4InitiateManualRenewal setLastInspectionCompletionDate(String text)
    {
        return super.setLastInspectionCompletionDate(text);
    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
    public FLHO4InitiateManualRenewal setInflationGuard(String text)
    {
        return super.setInflationGuard(text);
    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }

    public FLHO4InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
    {
        return super.clickExcludeLossOfUseCoverage(bool);

    }
    public FLHO4InitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public FLHO4Offerings nextAndAccept()
    {
        super.nextANDAccept();
        return new FLHO4Offerings(sh,path);
    }
}
