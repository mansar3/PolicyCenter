package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3PolicyInfo extends PolicyInfo<FLMH3PolicyInfo> {

    public FLMH3PolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLMH3NewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new FLMH3NewAdditionalNamedInsured(sh, path);
    }
    public FLMH3NewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new FLMH3NewAdditionalNamedInsured(sh,path);
    }
    public FLMH3SearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new FLMH3SearchAddressBook(sh,path);
    }
    public FLMH3Dwelling next()
    {
        super.dwellingNext();
        return new FLMH3Dwelling(sh,path);
    }
    public FLMH3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public FLMH3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public FLMH3PolicyInfo clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }
    public FLMH3PolicyInfo acceptYes()
    {
        return super.accept();
    }
    public String getErrorMessage()
    {
        return super.policyInfoErrorMessage();
    }
    public FLMH3PolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public FLMH3PolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public FLMH3PolicyInfo Enter(){
        return super.Enter();
    }
    public String getTermType()
    {
        return super.getTermType();
    }
    public FLMH3PolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public FLMH3PolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public FLMH3PolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public FLMH3PolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public FLMH3PolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }
    public FLMH3Quote  quote()
    {
        super.PolicyInfoQuote();
        return new FLMH3Quote(sh, path);
    }

    public FLMH3PreQuoteIssues  quoteWithIssues()
    {
        super.PolicyInfoQuote();
        return new FLMH3PreQuoteIssues(sh, path);
    }


    public FLMH3PolicyInfo setOccupation(String text)
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
