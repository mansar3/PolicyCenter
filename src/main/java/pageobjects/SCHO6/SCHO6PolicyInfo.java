package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6PolicyInfo extends PolicyInfo<SCHO6PolicyInfo>
{
	public SCHO6PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new SCHO6NewAdditionalNamedInsured(sh, path);
	}
	public SCHO6NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new SCHO6NewAdditionalNamedInsured(sh,path);
	}
	public SCHO6SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new SCHO6SearchAddressBook(sh,path);
	}
	public SCHO6Dwelling next()
	{
		super.dwellingNext();
		return new SCHO6Dwelling(sh,path);
	}
	public SCHO6PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public SCHO6PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public SCHO6PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public SCHO6PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public SCHO6PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCHO6PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCHO6PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCHO6PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public SCHO6PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public SCHO6PolicyInfo setOccupation(String text)
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
