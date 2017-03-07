package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.InitiateManualRenewal;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueInitiateManualRenewal extends InitiateManualRenewal<ALHO3UWIssueInitiateManualRenewal> {

    public ALHO3UWIssueInitiateManualRenewal(CenterSeleniumHelper sh)
    {
        super(sh);
    }
    public ALHO3UWIssueInitiateManualRenewal setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public ALHO3UWIssueInitiateManualRenewal setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public ALHO3UWIssueInitiateManualRenewal setBaseState(String text)
    {
        return super.setBaseState(text);
    }

    public String getBaseState()
    {
        return super.getBaseState();
    }
    public ALHO3UWIssueInitiateManualRenewal setProduct(String text)
    {
        return super.setProduct(text);
    }

    public String getProduct()
    {
        return super.getProduct();
    }
    public ALHO3UWIssueInitiateManualRenewal setPolicyType(String text)
    {
        return super.setPolicyType(text);
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }
    public ALHO3UWIssueInitiateManualRenewal setLegacyPolicyNumber(String text)
    {
        return super.setLegacyPolicyNumber(text);
    }

    public String getLegacyPolicyNumber()
    {
        return super.getLegacyPolicyNumber();
    }
    public ALHO3UWIssueInitiateManualRenewal setOriginalEffectiveDate(String text)
    {
        return super.setOriginalEffectiveDate(text);
    }

    public String getOriginalEffectiveDate()
    {
        return super.getOriginalEffectiveDate();
    }
    public ALHO3UWIssueInitiateManualRenewal setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public ALHO3UWIssueInitiateManualRenewal setLastInspectionCompletionDate(String text)
    {
        return super.setLastInspectionCompletionDate(text);
    }

    public String getLastInspectionCompletionDate()
    {
        return super.getLastInspectionCompletionDate();
    }
    public ALHO3UWIssueInitiateManualRenewal setInflationGuard(String text)
    {
        return super.setInflationGuard(text);
    }

    public String getInflationGuard()
    {
        return super.getInflationGuard();
    }
    public ALHO3UWIssueInitiateManualRenewal setTheftCoverage(String text)
    {
        return super.setTheftCoverage(text);
    }

    public String getTheftCoverage()
    {
        return super.getTheftCoverage();
    }
    public ALHO3UWIssueInitiateManualRenewal clickExcludedLossOfUseCoverage(String bool)
    {
        return super.clickExcludeLossOfUseCoverage(bool);

    }
    public ALHO3UWIssueInitiateManualRenewal nextAndDismiss()
    {
        return super.nextANDDismiss();

    }
    public ALHO3UWIssueOfferings nextAndAccept()
    {
        super.nextANDAccept();
        return new ALHO3UWIssueOfferings(sh,path);
    }



}
