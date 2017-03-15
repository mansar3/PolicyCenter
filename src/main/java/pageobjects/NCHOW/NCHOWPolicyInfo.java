package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWPolicyInfo extends PolicyInfo<NCHOWPolicyInfo> {
    public NCHOWPolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public NCHOWNewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new NCHOWNewAdditionalNamedInsured(sh, path);
    }
    public NCHOWNewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new NCHOWNewAdditionalNamedInsured(sh,path);
    }
    public NCHOWSearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new NCHOWSearchAddressBook(sh,path);
    }
    public NCHOWDwelling next()
    {
        super.dwellingNext();
        return new NCHOWDwelling(sh,path);
    }

    public NCHOWPolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public NCHOWPolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public NCHOWPolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public NCHOWPolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public String getTermType()
    {
        return super.getTermType();
    }
    public NCHOWPolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public NCHOWPolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public NCHOWPolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public NCHOWPolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public NCHOWPolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }

    public NCHOWPolicyInfo setOccupation(String text)
    {
        return super.setOccupation(text);
    }
    public NCHOWQuote  quote()
    {
        super.PolicyInfoQuote();
        return new NCHOWQuote(sh, path);
    }

    public NCHOWPreQuoteIssues  quoteWithIssues()
    {
        super.PolicyInfoQuote();
        return new NCHOWPreQuoteIssues(sh, path);
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
