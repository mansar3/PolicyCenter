package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssuePolicyInfo extends PolicyInfo<ALHO3UWIssuePolicyInfo> {

    public ALHO3UWIssuePolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public ALHO3UWIssueNewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new ALHO3UWIssueNewAdditionalNamedInsured(sh, path);
    }
    public ALHO3UWIssueNewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new ALHO3UWIssueNewAdditionalNamedInsured(sh,path);
    }
    public ALHO3UWIssueSearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new ALHO3UWIssueSearchAddressBook(sh,path);
    }
    public ALHO3UWIssueDwelling next()
    {
        super.dwellingNext();
        return new ALHO3UWIssueDwelling(sh,path);
    }
    public ALHO3UWIssuePolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public ALHO3UWIssuePolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public ALHO3UWIssuePolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public ALHO3UWIssuePolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public String getTermType()
    {
        return super.getTermType();
    }
    public ALHO3UWIssuePolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public ALHO3UWIssuePolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public ALHO3UWIssuePolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public ALHO3UWIssuePolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public ALHO3UWIssuePolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }

    public ALHO3UWIssuePolicyInfo setOccupation(String text)
    {
        return super.setOccupation(text);
    }

    public String getOccupation()
    {
        return super.getOccupation();
    }
    public String getMailingAddress()
    {
        return super.getMailingAddress();
    }

    public String getVerificationStatus()
    {
        return super.getVerificationStatus();
    }

    public String getPolicyType()
    {
        return super.getPolicyType();
    }

    public String getExpirationDate()
    {
        return super.getExpirationDate();
    }

    public String getWrittenDate()
    {
        return super.getWrittenDate();
    }


    public String getBaseState()
    {
        return super.getBaseState();
    }




}
