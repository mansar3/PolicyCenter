package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3PolicyInfo extends PolicyInfo<NCHO3PolicyInfo>
{
	public NCHO3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new NCHO3NewAdditionalNamedInsured(sh, path);
	}
	public NCHO3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new NCHO3NewAdditionalNamedInsured(sh,path);
	}
	public NCHO3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new NCHO3SearchAddressBook(sh,path);
	}
	public NCHO3Dwelling next()
	{
		super.dwellingNext();
		return new NCHO3Dwelling(sh,path);
	}
	public NCHO3PolicyInfo setSeniorCitizenDiscount(String flag)
	{
		return super.setSeniorCitizenDiscount(flag);
	}
	public NCHO3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public NCHO3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public NCHO3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public NCHO3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public NCHO3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public NCHO3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public NCHO3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public NCHO3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public NCHO3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }
	public NCHO3Quote  quote()
	{
		super.PolicyInfoQuote();
		return new NCHO3Quote(sh, path);
	}

	public NCHO3PreQuoteIssues  quoteWithIssues()
	{
		super.PolicyInfoQuote();
		return new NCHO3PreQuoteIssues(sh, path);
	}

	 public NCHO3PolicyInfo setOccupation(String text)
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
