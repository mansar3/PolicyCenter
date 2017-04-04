package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

public class FLHO3PolicyInfo extends PolicyInfo<FLHO3PolicyInfo>
{
	public FLHO3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new FLHO3NewAdditionalNamedInsured(sh, path);
	}
	public FLHO3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new FLHO3NewAdditionalNamedInsured(sh,path);
	}
	public FLHO3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new FLHO3SearchAddressBook(sh,path);
	}
	public FLHO3Dwelling next()
	{
		super.dwellingNext();
		return new FLHO3Dwelling(sh,path);
	}
	public FLHO3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public FLHO3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public String getErrorMessage()
	{
		return super.policyInfoErrorMessage();
	}
	public FLHO3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public FLHO3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}
	public FLHO3PolicyInfo Enter(){
		return super.Enter();
	}
	public String getTermType()
	{
		return super.getTermType();
	}
	public FLHO3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public FLHO3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public FLHO3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public FLHO3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public FLHO3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public FLHO3PolicyInfo setOccupation(String text)
	 {
	 	return super.setOccupation(text);
	 }


	public FLHO3Quote  quote()
	{
		super.PolicyInfoQuote();
		return new FLHO3Quote(sh, path);
	}

	public FLHO3PreQuoteIssues  quoteWithIssues()
	{
		super.PolicyInfoQuote();
		return new FLHO3PreQuoteIssues(sh, path);
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