package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4InitiateManualRenewal extends InitiateManualRenewal<SCHO4InitiateManualRenewal> {

    public SCHO4InitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public SCHO4InitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public SCHO4InitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public SCHO4InitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public SCHO4InitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public SCHO4InitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public SCHO4InitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public SCHO4InitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public SCHO4InitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public SCHO4InitiateManualRenewal setLastInspectionCompletionDate(String text)
    {
        return super.setLastInspectionCompletionDate(text);
    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
    public SCHO4InitiateManualRenewal setInflationGuard(String text)
    {
        return super.setInflationGuard(text);
    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }

    public SCHO4InitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
    {
        return super.clickExcludeLossOfUseCoverage(bool);

    }
    public SCHO4InitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public SCHO4Offerings nextAndAccept()
    {
        super.nextANDAccept();
        return new SCHO4Offerings(sh,path);
    }

}
