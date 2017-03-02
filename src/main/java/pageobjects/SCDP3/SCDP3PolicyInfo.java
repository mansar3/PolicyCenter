package pageobjects.SCDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by aansari on 2/6/17.
 */
public class SCDP3PolicyInfo extends PolicyInfo<SCDP3PolicyInfo>
{
	public SCDP3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCDP3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new SCDP3NewAdditionalNamedInsured(sh, path);
	}
	public SCDP3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new SCDP3NewAdditionalNamedInsured(sh,path);
	}
	public SCDP3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new SCDP3SearchAddressBook(sh,path);
	}
	public SCDP3Dwelling next()
	{
		super.dwellingNext();
		return new SCDP3Dwelling(sh,path);
	}
	public SCDP3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public SCDP3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public SCDP3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public SCDP3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public SCDP3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public SCDP3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public SCDP3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public SCDP3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public SCDP3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public SCDP3PolicyInfo setOccupation(String text)
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
