package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

public class FLHO6PolicyInfo extends PolicyInfo<FLHO6PolicyInfo>
{
	public FLHO6PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new FLHO6NewAdditionalNamedInsured(sh, path);
	}
	public FLHO6NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new FLHO6NewAdditionalNamedInsured(sh,path);
	}
	public FLHO6Quote  quote()
	{
		super.PolicyInfoQuote();
		return new FLHO6Quote(sh, path);
	}

	public FLHO6PreQuoteIssues  quoteWithIssues()
	{
		super.PolicyInfoQuote();
		return new FLHO6PreQuoteIssues(sh, path);
	}

	public FLHO6PolicyInfo clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}
	public FLHO6PolicyInfo acceptYes()
	{
		return super.accept();
	}
	public FLHO6SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new FLHO6SearchAddressBook(sh,path);
	}
	public FLHO6Dwelling next()
	{
		super.dwellingNext();
		return new FLHO6Dwelling(sh,path);
	}
	public FLHO6PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public FLHO6PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public FLHO6PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public FLHO6PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public FLHO6PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public FLHO6PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public FLHO6PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public FLHO6PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public FLHO6PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public FLHO6PolicyInfo setOccupation(String text)
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