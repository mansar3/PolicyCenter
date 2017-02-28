package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

public class FLDP3PolicyInfo extends PolicyInfo<FLDP3PolicyInfo>
{
	public FLDP3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new FLDP3NewAdditionalNamedInsured(sh, path);
	}
	public FLDP3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new FLDP3NewAdditionalNamedInsured(sh,path);
	}
	public FLDP3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new FLDP3SearchAddressBook(sh,path);
	}
	public FLDP3Dwelling next()
	{
		super.dwellingNext();
		return new FLDP3Dwelling(sh,path);
	}
	public FLDP3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public FLDP3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public FLDP3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public FLDP3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public FLDP3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public FLDP3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public FLDP3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public FLDP3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public FLDP3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public FLDP3PolicyInfo setOccupation(String text)
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