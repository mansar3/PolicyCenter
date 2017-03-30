package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import pageobjects.NorthPanel;

public abstract class PolicyInfo<T extends PolicyInfo> extends CenterPanelBase
{

	private PolicyInfoBy by;
	protected String policyBase,insuredBase,discountsBase;
	public NorthPanel np;
	public PolicyInfo(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Policy Info";
		waitForTitle(sh);
		setID(path);
		by = new PolicyInfoBy();
		np = new NorthPanel(sh);
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				discountsBase = "SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:";
				policyBase = discountsBase + "SubmissionWizard_PolicyInfoDV:";
				insuredBase = discountsBase + "AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:";
				break;
			case POLICYRENEWAL:
				discountsBase = "RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:";
				policyBase = discountsBase + "RenewalWizard_PolicyInfoDV:";
				insuredBase = discountsBase + "AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:";

				break;
			case POLICYCHANGE:
				discountsBase = "PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:";
				policyBase = discountsBase + "PolicyChangeWizard_PolicyInfoDV:";
				insuredBase = discountsBase + "AdditionalNamedInsuredsDV:NamedInsuredInputSet:NamedInsuredsLV_tb:";
				break;


		}
	}

	public class PolicyInfoBy
	{

		// REPLACE policyBase with enum value here
		final  String	addressBase = policyBase +"AccountInfoInputSet:PolicyAddressDisplayInputSet:globalAddressContainer:GlobalAddressInputSet:";

		final  By		termType = By.id(policyBase + "PolicyInfoInputSet:TermType-inputEl"),
						effectiveDate = By.id(policyBase + "PolicyInfoInputSet:EffectiveDate-inputEl"),
						originalEffectiveDate = By.id(policyBase + "PolicyInfoInputSet:PolicyOrigEffDate-inputEl"),
						organization = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:Producer-inputEl"),
						producerCode = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:ProducerCode-inputEl"),
						policyWriter = By.id(policyBase + "PolicyInfoProducerOfRecordInputSet:PolicyWriter-inputEl"),
						underwritingCompanies = By.id(policyBase + "UWCompanyInputSet:UWCompany-inputEl"),
						occupation = By.id(policyBase + "AccountInfoInputSet:occupation-inputEl"),
						addAdditionalNameInsureds = By.id(insuredBase + "AddContactsButton"),
						removeAdditionalNameInsureds = By.id(insuredBase + "Remove"),
						name = By.id(policyBase + "AccountInfoInputSet:Name-inputEl"),
						mailingAddress = By.id(addressBase + "AddressSummary-inputEl"),
						verificationStatus = By.id(addressBase + "verificationfli-inputEl"),
						policyType = By.id(policyBase + "PolicyInfoInputSet:HOPolicyType-inputEl"),
						expirationDate = By.id(policyBase + "PolicyInfoInputSet:ExpirationDate-inputEl"),
						writtenDate = By.id(policyBase + "PolicyInfoInputSet:WrittenDate-inputEl"),
						baseState = By.id(policyBase + "PolicyInfoInputSet:BaseState-inputEl"),
		                quote = By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
		                renewalquote = By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:RenewalQuote-btnInnerEl"),
			        	editPolicyTransaction = By.id("SubmissionWizard:LOBWizardStepGroup:SubmissionWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"),
		                renewaleditpolicytransaction = By.id("RenewalWizard:LOBWizardStepGroup:RenewalWizard_PolicyInfoScreen:JobWizardToolbarButtonSet:EditPolicyWorkflow-btnInnerEl");
		               // errormessage = By.id("PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:OOSEPanelSet:WarningsPanelSet:0:PanelSet:Warning");




	}

	protected String getErrorMessage()

	{
		sh.waitForNoMask();
		String Error = sh.driver.findElement(By.id("PolicyChangeWizard:LOBWizardStepGroup:PolicyChangeWizard_PolicyInfoScreen:OOSEPanelSet:WarningsPanelSet:0:PanelSet:Warning")).getText();
		return Error;
	}

	protected T editPolicyTransaction(){
		sh.waitForNoMask();
		sh.clickElement(by.editPolicyTransaction);
		return (T) this;
	}

	protected T editPolicyTransactionrenewal(){
		sh.waitForNoMask();
		sh.clickElement(by.renewaleditpolicytransaction);
		return (T) this;
	}
	protected T accept()
	{
		sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		return (T) this;

	}


	protected T PolicyInfoQuote()
	{
		sh.waitForNoMask();
		sh.clickElement(by.quote);
		return (T) this;
	}

	protected T PolicyInfoRenewalQuote()
	{
		sh.waitForNoMask();
		sh.clickElement(by.renewalquote);
		return (T) this;
	}


	protected T dwellingNext()
	{
		sh.waitForNoMask();
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return (T)this;
	}
	protected T setDoesInsuredOwnOtherResidenceWithFrontline(String flag)
	{
		sh.clickElement(By.id(policyBase + "AccountInfoInputSet:otherresidences_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;

	}

	protected T setSeniorCitizenDiscount(String flag)
	{
		sh.clickElement(By.xpath("//*[@id='" + discountsBase + "Modifiers_fliPanelSet:aRateModifierListView:0-body']//div[text() = 'Senior Citizens Discount']/../..//input[@inputvalue = '" + flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setNoPriorInsuranceSurcharge(String flag)
	{
		sh.clickElement(By.xpath("//*[@id='" + discountsBase + "Modifiers_fliPanelSet:aRateModifierListView:0-body']//input[@inputvalue = '" + flag.toLowerCase() + "']"));
		sh.waitForNoMask();
		return (T)this;
	}

	protected T addNewCompany()
	{
		System.out.println("Adding a new company...");
		for(int i= 0 ;i < 10;i++)
		{
			sh.clickElement(by.addAdditionalNameInsureds);
			sh.waitForNoMask();
			if(sh.isDisplayed(By.id(insuredBase + "AddContactsButton:0:ContactType")))
				break;
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
			sh.clickElement(By.id(insuredBase + "AddContactsButton:0:ContactType"));

		return (T)this;

	}
	protected T addNewPerson()
	{
		System.out.println("~~~~~~~~Adding a new person for Additional Named Insured~~~~~~~~~");
		for(int i= 0 ;i < 10;i++)
		{
			sh.clickElement(by.addAdditionalNameInsureds);
			sh.waitForNoMask();
			if(sh.isDisplayed(By.id(insuredBase + "AddContactsButton:1:ContactType")))
				break;
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}

		}
			sh.clickElement(By.id(insuredBase + "AddContactsButton:1:ContactType"));
		return (T)this;
	}
	protected T addFromAddressBook()
	{
		for(int i= 0 ;i < 10;i++)
		{
			sh.clickElement(by.addAdditionalNameInsureds);
			sh.waitForPageLoad();
			if(sh.isDisplayed(By.id(insuredBase + "AddContactsButton:AddFromSearch")))
				break;
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
			sh.clickElement(By.id(insuredBase + "AddContactsButton:AddFromSearch"));
		return (T)this;
	}
	protected T clickRemoveAdditionalNameInsureds()
	{
		sh.clickElement(by.removeAdditionalNameInsureds);
		return (T)this;
	}

	protected String getTermType()
	{
		return sh.getValue(by.termType);
	}
	
	protected T setTermType(String termType)
	{
		sh.setText(by.termType, termType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getEffectiveDate()
	{
		return sh.getValue(by.effectiveDate);
	}

	protected T setEffectiveDate(String effectiveDate)
	{
		sh.setText(by.effectiveDate, effectiveDate);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	protected T setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getProducerCode()
	{
		return sh.getValue(by.producerCode);
	}

	protected T setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getPolicyWriter()
	{
		return sh.getValue(by.policyWriter);
	}

	protected T setPolicyWriter(String policyWriter)
	{
		sh.setText(by.policyWriter, policyWriter);
		sh.tab();
		return (T)this;
	}
	protected String getUnderwritingCompanies()
	{
		return sh.getValue(by.underwritingCompanies);
	}

	protected T setUnderwritingCompanies(String underwritingCompanies)
	{
		sh.setText(by.underwritingCompanies, underwritingCompanies);
		sh.tab();
		return (T)this;
	}
	protected String getOccupation()
	{
		return sh.getValue(by.occupation);
	}

	protected T setOccupation(String occupation)
	{
		sh.setText(by.occupation, occupation);
		return (T)this;
	}
	protected String getName()
	{
		return sh.getText(by.name);
	}
	protected String getMailingAddress()
	{
		return sh.getText(by.mailingAddress);
	}
	protected String getVerificationStatus()
	{
		return sh.getText(by.verificationStatus);
	}
	protected String getPolicyType()
	{
		return sh.getText(by.policyType);
	}
	protected String getExpirationDate()
	{
		return sh.getText(by.expirationDate);
	}
	protected String getWrittenDate()
	{
		return sh.getText(by.writtenDate);
	}
	protected String getBaseState()
	{
		return sh.getText(by.baseState);
	}
}