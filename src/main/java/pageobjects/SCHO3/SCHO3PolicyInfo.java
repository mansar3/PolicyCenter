package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3PolicyInfo extends PolicyInfo<SCHO3PolicyInfo>
{
	public SCHO3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new SCHO3NewAdditionalNamedInsured(sh, path);
	}
	public SCHO3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new SCHO3NewAdditionalNamedInsured(sh,path);
	}
	public SCHO3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new SCHO3SearchAddressBook(sh,path);
	}
	public SCHO3Dwelling next()
	{
		super.dwellingNext();
		return new SCHO3Dwelling(sh,path);
	}
	public SCHO3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public SCHO3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public SCHO3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public SCHO3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}
	public String getErrorMessage()
	{
		return super.policyInfoErrorMessage();
	}
	public String getTermType()
	{
		return super.getTermType();
	}
	public SCHO3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}
	public SCHO3PolicyInfo Enter(){
		return super.Enter();
	}
	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCHO3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCHO3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCHO3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public SCHO3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public SCHO3PolicyInfo setOccupation(String text)
	 {
	 	return super.setOccupation(text);
	 }
	public SCHO3Quote  quote()
	{
		super.PolicyInfoQuote();
		return new SCHO3Quote(sh, path);
	}

	public SCHO3PreQuoteIssues  quoteWithIssues()
	{
		super.PolicyInfoQuote();
		return new SCHO3PreQuoteIssues(sh, path);
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
