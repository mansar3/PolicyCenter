package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlyPolicyInfo extends PolicyInfo<NCWindOnlyPolicyInfo> {
    public NCWindOnlyPolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCWindOnlyNewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new NCWindOnlyNewAdditionalNamedInsured(sh, path);
    }
    public NCWindOnlyNewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new NCWindOnlyNewAdditionalNamedInsured(sh,path);
    }
    public NCWindOnlySearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new NCWindOnlySearchAddressBook(sh,path);
    }
    public NCWindOnlyDwelling next()
    {
        super.dwellingNext();
        return new NCWindOnlyDwelling(sh,path);
    }
    public NCWindOnlyPolicyInfo setSeniorCitizenDiscount(String flag)
    {
        return super.setSeniorCitizenDiscount(flag);
    }
    public NCWindOnlyPolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public NCWindOnlyPolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public NCWindOnlyPolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public NCWindOnlyPolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public String getTermType()
    {
        return super.getTermType();
    }
    public NCWindOnlyPolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public NCWindOnlyPolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public NCWindOnlyPolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public NCWindOnlyPolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public NCWindOnlyPolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }

    public NCWindOnlyPolicyInfo setOccupation(String text)
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
