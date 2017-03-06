package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyInitiateManualRenewal extends InitiateManualRenewal<NCWindOnlyInitiateManualRenewal> {
    public NCWindOnlyInitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public NCWindOnlyInitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public NCWindOnlyInitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public NCWindOnlyInitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public NCWindOnlyInitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public NCWindOnlyInitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public NCWindOnlyInitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public NCWindOnlyInitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public NCWindOnlyInitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public NCWindOnlyInitiateManualRenewal setLastInspectionCompletionDate(String text)
    {
        return super.setLastInspectionCompletionDate(text);
    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
    public NCWindOnlyInitiateManualRenewal setInflationGuard(String text)
    {
        return super.setInflationGuard(text);
    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }

    public NCWindOnlyInitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
    {
        return super.clickExcludeLossOfUseCoverage(bool);

    }
    public NCWindOnlyInitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public NCWindOnlyOfferings nextAndAccept()
    {
        super.nextANDAccept();
        return new NCWindOnlyOfferings(sh,path);
    }

}
