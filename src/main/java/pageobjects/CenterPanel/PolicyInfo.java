package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class PolicyInfo extends CenterPanelBase
{

	private PolicyInfoBy by;
	protected String policyBase;
	public PolicyInfo(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Policy Info";
		waitForTitle(sh);
		setID(path);
		by = new PolicyInfoBy();

		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				this.policyBase = "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:";
				break;
			case POLICYRENEWAL:
				this.policyBase = "RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:RenewalWizard_PolicyInfoDV:";
				break;
			case POLICYCHANGE:
				this.policyBase = "PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:PolicyChangeWizard_PolicyInfoDV:";
				break;


		}
	}

	public class PolicyInfoBy
	{

		// REPLACE policyBase with enum value here
		final  String	//policyBase = "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:",
						addressBase = policyBase +"AccountInfoInputSet:PolicyAddressDisplayInputSet:globalAddressContainer:GlobalAddressInputSet:";

		final  By	termType = By.id(policyBase + "PolicyInfoInputSet:TermType-inputEl"),
						effectiveDate = By.id(policyBase + "PolicyInfoInputSet:EffectiveDate-inputEl"),
						organization = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:Producer-inputEl"),
						producerCode = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:ProducerCode-inputEl"),
						policyWriter = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:PolicyWriter-inputEl"),
						underwritingCompanies = By.id(policyBase + "UWCompanyInputSet:UWCompany-inputEl"),
						doesInsuredOwnOtherResidenceYes = By.id(policyBase + "AccountInfoInputSet:otherresidences_true-inputEl"),
						doesInsuredOwnOtherResidenceNo = By.id(policyBase + "AccountInfoInputSet:otherresidences_false-inputEl"),
						occupation = By.id(policyBase + "AccountInfoInputSet:occupation-inputEl"),
						addAdditionalNameInsureds = By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton"),
						removeAdditionalNameInsureds = By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:Remove"),
						name = By.id(policyBase + "AccountInfoInputSet:Name-inputEl"),
						mailingAddress = By.id(addressBase + "AddressSummary-inputEl"),
						verificationStatus = By.id(addressBase + "verificationfli-inputEl"),
						policyType = By.id(policyBase + "PolicyInfoInputSet:HOPolicyType-inputEl"),
						expirationDate = By.id(policyBase + "PolicyInfoInputSet:ExpirationDate-inputEl"),
						writtenDate = By.id(policyBase + "PolicyInfoInputSet:WrittenDate-inputEl"),
						baseState = By.id(policyBase + "PolicyInfoInputSet:BaseState-inputEl");




	}

	public Dwelling next()
	{
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new Dwelling(sh,path);
	}
	public void clickDoesInsuredOwnOtherResidence(boolean option)
	{
		if(option)
			sh.clickElement(by.doesInsuredOwnOtherResidenceYes);
		else
			sh.clickElement(by.doesInsuredOwnOtherResidenceNo);

	}
	public void clickAddNewCompany()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton:0:ContactType"));

	}
	public void clickAddNewPerson()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton:1:ContactType"));
	}
	public void clickAddFromAddressBook()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:AddContactsButton:AddFromSearch"));
	}
	public void clickRemoveAdditionalNameInsureds()
	{
		sh.clickElement(by.removeAdditionalNameInsureds);
	}

	public String getTermType()
	{
		return sh.getValue(by.termType);
	}
	
	public PolicyInfo setTermType(String termType)
	{
		sh.setText(by.termType, termType);
		sh.tab();
		return this;
	}
	public String getEffectiveDate()
	{
		return sh.getValue(by.effectiveDate);
	}

	public PolicyInfo setEffectiveDate(String effectiveDate)
	{
		sh.setText(by.effectiveDate, effectiveDate);
		return this;
	}
	public String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	public PolicyInfo setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		return this;
	}
	public String getProducerCode()
	{
		return sh.getValue(by.producerCode);
	}

	public PolicyInfo setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		return this;
	}
	public String getPolicyWriter()
	{
		return sh.getValue(by.policyWriter);
	}

	public PolicyInfo setPolicyWriter(String policyWriter)
	{
		sh.setText(by.policyWriter, policyWriter);
		sh.tab();
		return this;
	}
	public String getUnderwritingCompanies()
	{
		return sh.getValue(by.underwritingCompanies);
	}

	public PolicyInfo setUnderwritingCompanies(String underwritingCompanies)
	{
		sh.setText(by.underwritingCompanies, underwritingCompanies);
		sh.tab();
		return this;
	}
	public String getOccupation()
	{
		return sh.getValue(by.occupation);
	}

	public PolicyInfo setOccupation(String occupation)
	{
		sh.setText(by.occupation, occupation);
		return this;
	}
	public String getName()
	{
		return sh.getText(by.name);
	}
	public String getMailingAddress()
	{
		return sh.getText(by.mailingAddress);
	}
	public String getVerificationStatus()
	{
		return sh.getText(by.verificationStatus);
	}
	public String getPolicyType()
	{
		return sh.getText(by.policyType);
	}
	public String getExpirationDate()
	{
		return sh.getText(by.expirationDate);
	}
	public String getWrittenDate()
	{
		return sh.getText(by.writtenDate);
	}
	public String getBaseState()
	{
		return sh.getText(by.baseState);
	}
}