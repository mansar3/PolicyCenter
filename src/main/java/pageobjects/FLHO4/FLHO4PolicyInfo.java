package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4PolicyInfo extends PolicyInfo<FLHO4PolicyInfo> {

    public FLHO4PolicyInfo(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }

    public FLHO4NewAdditionalNamedInsured clickAddNewCompany()
    {
        super.addNewCompany();
        return new FLHO4NewAdditionalNamedInsured(sh, path);
    }
    public FLHO4NewAdditionalNamedInsured clickAddNewPerson()
    {
        super.addNewPerson();
        return new FLHO4NewAdditionalNamedInsured(sh,path);
    }
    public FLHO4SearchAddressBook searchFromAddressBook()
    {
        super.addFromAddressBook();
        return new FLHO4SearchAddressBook(sh,path);
    }
    public FLHO4Dwelling next()
    {
        super.dwellingNext();
        return new FLHO4Dwelling(sh,path);
    }
    public String getErrorMessage()
    {
        return super.policyInfoErrorMessage();
    }
    public FLHO4PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
    {
        return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
    }
    public FLHO4PolicyInfo setNoPriorInsuranceSurcharge(String flag)
    {
        return super.setNoPriorInsuranceSurcharge(flag);
    }
    public FLHO4PolicyInfo Enter(){
        return super.Enter();
    }
    public FLHO4PolicyInfo clickEditPolicyTransaction(){
        return super.editPolicyTransaction();
    }
    public FLHO4PolicyInfo acceptYes()
    {
        return super.accept();
    }
    public FLHO4PolicyInfo clickRemoveAdditionalNameInsureds()
    {
        return super.clickRemoveAdditionalNameInsureds();
    }
    public FLHO4PolicyInfo setTermType(String text)
    {
        return super.setTermType(text);
    }

    public String getTermType()
    {
        return super.getTermType();
    }
    public FLHO4PolicyInfo setEffectiveDate(String text)
    {
        return super.setEffectiveDate(text);
    }

    public String getEffectiveDate()
    {
        return super.getEffectiveDate();
    }
    public FLHO4PolicyInfo setOrganization(String text)
    {
        return super.setOrganization(text);
    }

    public String getOrganization()
    {
        return super.getOrganization();
    }
    public FLHO4PolicyInfo setProducerCode(String text)
    {
        return super.setProducerCode(text);
    }

    public String getProducerCode()
    {
        return super.getProducerCode();
    }
    public FLHO4PolicyInfo setPolicyWriter(String text)
    {
        return super.setPolicyWriter(text);
    }

    public String getPolicyWriter()
    {
        return super.getPolicyWriter();
    }
    public FLHO4PolicyInfo setUnderwritingCompanies(String text)
    {
        return super.setUnderwritingCompanies(text);
    }

    public String getUnderwritingCompanies()
    {
        return super.getUnderwritingCompanies();
    }

    public FLHO4PolicyInfo setOccupation(String text)
    {
        return super.setOccupation(text);
    }

    public FLHO4Quote  quote()
    {
        super.PolicyInfoQuote();
        return new FLHO4Quote(sh, path);
    }

    public FLHO4PreQuoteIssues  quoteWithIssues()
    {
        super.PolicyInfoQuote();
        return new FLHO4PreQuoteIssues(sh, path);
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
