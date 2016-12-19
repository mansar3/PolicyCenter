package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class PolicyInfo extends CenterPanelBase
{

	private PolicyInfoBy by;
	protected String policyBase,insuredBase;
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
				policyBase = "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:SubmissionWizard_PolicyInfoDV:";
				insuredBase = "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:";
				break;
			case POLICYRENEWAL:
				policyBase = "RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:RenewalWizard_PolicyInfoDV:";
				insuredBase = "RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:";
				break;
			case POLICYCHANGE:
				policyBase = "PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:PolicyChangeWizard_PolicyInfoDV:";
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
						originalEffectiveDate = By.id(policyBase + "PolicyInfoInputSet:PolicyOrigEffDate-inputEl"),
						organization = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:Producer-inputEl"),
						producerCode = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:ProducerCode-inputEl"),
						policyWriter = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:PolicyWriter-inputEl"),
						underwritingCompanies = By.id(policyBase + "UWCompanyInputSet:UWCompany-inputEl"),
						doesInsuredOwnOtherResidenceYes = By.id(policyBase + "AccountInfoInputSet:otherresidences_true-inputEl"),
						doesInsuredOwnOtherResidenceNo = By.id(policyBase + "AccountInfoInputSet:otherresidences_false-inputEl"),
						occupation = By.id(policyBase + "AccountInfoInputSet:occupation-inputEl"),
						addAdditionalNameInsureds = By.id(insuredBase + "AddContactsButton"),
						removeAdditionalNameInsureds = By.id(insuredBase + "Remove"),
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
		sh.waitForNoMask();
		return new Dwelling(sh,path);
	}
	public PolicyInfo clickDoesInsuredOwnOtherResidence(boolean flag)
	{
		if(flag)
			sh.clickElement(by.doesInsuredOwnOtherResidenceYes);
		else
			sh.clickElement(by.doesInsuredOwnOtherResidenceNo);

		sh.waitForNoMask();
		return this;

	}
	public NewAdditionalNameInsured clickAddNewCompany()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id(insuredBase + "AddContactsButton:0:ContactType"));
		return new NewAdditionalNameInsured(sh, path);

	}
	public NewAdditionalNameInsured clickAddNewPerson()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id(insuredBase + "AddContactsButton:1:ContactType"));
		return new NewAdditionalNameInsured(sh, path);
	}
	public void clickAddFromAddressBook()
	{
		sh.clickElement(by.addAdditionalNameInsureds);
		sh.clickElement(By.id(insuredBase + "AddContactsButton:AddFromSearch"));
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
		sh.waitForNoMask();
		return this;
	}
	public String getEffectiveDate()
	{
		return sh.getValue(by.effectiveDate);
	}

	public PolicyInfo setEffectiveDate(String effectiveDate)
	{
		sh.setText(by.effectiveDate, effectiveDate);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	public PolicyInfo setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.tab();
		sh.waitForNoMask();
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
		sh.waitForNoMask();
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