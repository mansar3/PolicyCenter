package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.PolicyInfo;

public class ALHO3PolicyInfo extends PolicyInfo<ALHO3PolicyInfo>
{
	public ALHO3PolicyInfo(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3NewAdditionalNamedInsured clickAddNewCompany()
	{
		super.addNewCompany();
		return new ALHO3NewAdditionalNamedInsured(sh, path);
	}
	public ALHO3NewAdditionalNamedInsured clickAddNewPerson()
	{
		super.addNewPerson();
		return new ALHO3NewAdditionalNamedInsured(sh,path);
	}
	public String getPolicyInfoErrorMessage()
	{
		return super.getErrorMessage();
	}

	public String getErrorMessage()
	{
		return super.policyInfoErrorMessage();
	}


	public ALHO3PolicyInfo clickEditPolicyTransaction(){
		return super.editPolicyTransaction();
	}


	public ALHO3PolicyInfo clickEditPolicyTransactionRenewal(){
		return super.editPolicyTransactionrenewal();
	}

	public ALHO3PolicyInfo acceptYes()
	{
		return super.accept();
	}

	public ALHO3PolicyInfo Enter(){
		return super.Enter();
	}
	public ALHO3SearchAddressBook searchFromAddressBook()
	{
		super.addFromAddressBook();
		return new ALHO3SearchAddressBook(sh,path);
	}
	public ALHO3Dwelling next()
	{
		super.dwellingNext();
		return new ALHO3Dwelling(sh,path);
	}
	public ALHO3PolicyInfo setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		return super.setDoesInsuredOwnOtherResidenceWithFrontline(flag);
	}
	public ALHO3PolicyInfo setNoPriorInsuranceSurcharge(String flag)
	{
		return super.setNoPriorInsuranceSurcharge(flag);
	}
	public ALHO3PolicyInfo clickRemoveAdditionalNameInsureds()
	{
		return super.clickRemoveAdditionalNameInsureds();
	}
	public ALHO3PolicyInfo setTermType(String text)
	{
		return super.setTermType(text);
	}

	public String getTermType()
	{
		return super.getTermType();
	}
	public ALHO3PolicyInfo setEffectiveDate(String text)
	{
		return super.setEffectiveDate(text);
	}

	public String getEffectiveDate()
	{
		return super.getEffectiveDate();
	}
	public ALHO3PolicyInfo setOrganization(String text)
	{
		return super.setOrganization(text);
	}

	public String getOrganization()
	{
		return super.getOrganization();
	}
	public ALHO3PolicyInfo setProducerCode(String text)
	{
		return super.setProducerCode(text);
	}

	public String getProducerCode()
	{
		return super.getProducerCode();
	}
	public ALHO3PolicyInfo setPolicyWriter(String text)
	{
		return super.setPolicyWriter(text);
	}

	public String getPolicyWriter()
	{
		return super.getPolicyWriter();
	}
	 public ALHO3PolicyInfo setUnderwritingCompanies(String text)
	 {
	 	return super.setUnderwritingCompanies(text);
	 }

	 public String getUnderwritingCompanies()
	 {
	 	return super.getUnderwritingCompanies();
	 }

	 public ALHO3PolicyInfo setOccupation(String text)
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

	public ALHO3Quote  quote()
	{
		super.PolicyInfoQuote();
		return new ALHO3Quote(sh, path);
	}

	public ALHO3Quote  quoteRenewal()
	{
		super.PolicyInfoRenewalQuote();
		return new ALHO3Quote(sh, path);
	}
	public ALHO3PreQuoteIssues  quoteWithIssues()
	{
		super.PolicyInfoQuote();
		return new ALHO3PreQuoteIssues(sh, path);
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