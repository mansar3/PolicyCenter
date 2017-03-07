package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWInitiateManualRenewal extends InitiateManualRenewal<NCHOWInitiateManualRenewal> {
    public NCHOWInitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public NCHOWInitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public NCHOWInitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public NCHOWInitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public NCHOWInitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public NCHOWInitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public NCHOWInitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public NCHOWInitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public NCHOWInitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public NCHOWInitiateManualRenewal setLastInspectionCompletionDate(String text)
    {
        return super.setLastInspectionCompletionDate(text);
    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
    public NCHOWInitiateManualRenewal setInflationGuard(String text)
    {
        return super.setInflationGuard(text);
    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }

    public NCHOWInitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
    {
        return super.clickExcludeLossOfUseCoverage(bool);

    }
    public NCHOWInitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public NCHOWOfferings nextAndAccept()
    {
        super.nextANDAccept();
        return new NCHOWOfferings(sh,path);
    }

}
