package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4PolicyInfo extends PolicyInfo<SCHO4PolicyInfo> {

    public SCHO4PolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public SCHO4NewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new SCHO4NewAdditionalNamedInsured(sh, path);
    }
    public SCHO4NewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new SCHO4NewAdditionalNamedInsured(sh,path);
    }
    public SCHO4SearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new SCHO4SearchAddressBook(sh,path);
    }
    public SCHO4Dwelling next()
    {
        super.dwellingNext();
        return new SCHO4Dwelling(sh,path);
    }
    public SCHO4PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public SCHO4PolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public SCHO4PolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public SCHO4PolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public String getTermType()
    {
        return super.getTermType();
    }
    public SCHO4PolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public SCHO4PolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public SCHO4PolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public SCHO4PolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public SCHO4PolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }

    public SCHO4PolicyInfo setOccupation(String text)
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
