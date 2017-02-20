package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class CreateAccount<T extends CreateAccount> extends CenterPanelBase
{
	private CreateAccountBy by;
	public String streetAddress, city, state;

	public class CreateAccountBy extends CenterPanelBase.CenterPanelBy{
		private String	base_id = "CreateAccount:CreateAccountScreen:",
						createAccountDiv = base_id + "CreateAccountDV:",
						accountInputSet = createAccountDiv +"CreateAccountContactInputSet:",
						baseContactInputSet = createAccountDiv + "CreateAccountContactInputSet:GlobalPersonNameInputSet:",
						baseAddressId = createAccountDiv + "AddressInputSet:globalAddressContainer:GlobalAddressInputSet:",
						baseProducerId = createAccountDiv + "ProducerSelectionInputSet:";

		final public By	updateBtn = By.id(base_id + "ForceDupCheckUpdate-btnInnerEl"),
						firstName = By.id(baseContactInputSet + "FirstName-inputEl"),
						lastName = By.id(baseContactInputSet + "LastName-inputEl"),
						address1 = By.id(baseAddressId + "AddressLine1-inputEl"),
						country = By.id(baseAddressId + "Country-inputEl"),
						address2 = By.id(baseAddressId + "AddressLine2-inputEl"),
						address3 = By.id(baseAddressId + "AddressLine3-inputEl"),
						city = By.id(baseAddressId + "City-inputEl"),
						county = By.id(baseAddressId + "County-inputEl"),
						state = By.id(baseAddressId + "State-inputEl"),
						zip = By.id(baseAddressId + "PostalCode-inputEl"),
						verifyAddress = By.id(baseAddressId + "VerifyAddressPickerButton"),
						addressType = By.id(createAccountDiv + "AddressType-inputEl"),
						organization = By.id(baseProducerId + "Producer-inputEl"),
						producerCode = By.id(baseProducerId + "ProducerCode-inputEl"),
						dateOfBirth = By.id(accountInputSet + "DateOfBirth-inputEl"),
						homePhone = By.id(accountInputSet + "HomePhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
						workPhone = By.id(accountInputSet + "Phone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
						mobilePhone = By.id(accountInputSet + "CellPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
						faxPhone = By.id(accountInputSet + "FaxPhone:GlobalPhoneInputSet:NationalSubscriberNumber-inputEl"),
						primaryPhone = By.id(accountInputSet + "PrimaryPhone-inputEl"),
						primaryEmail = By.id(accountInputSet + "EmailAddress1-inputEl"),
						secondaryEmail = By.id(accountInputSet + "EmailAddress2-inputEl"),
						description = By.id(createAccountDiv + "AddressDescription-inputEl"),
						ssn = By.id(createAccountDiv + "OfficialIDInputSet:OfficialIDDV_Input-inputEl"),
						preferredLanguage = By.id(createAccountDiv + "PrimaryLanguage-inputEl"),
						organizationSearchButton = By.id(baseProducerId + "Producer:SelectOrganization"),
						producerCodeDropdown = By.id(base_id + baseProducerId + "ProducerCode-trigger-picker");
	}

	public CreateAccount(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new CreateAccountBy();
		expectedPanelTitle = "Create account";
		waitForTitle(sh);
		System.out.println("Navigated to page: "+ expectedPanelTitle);
	}

	public String getHomePhone()
	{
		return sh.getValue(by.homePhone);
	}
	
	public T setHomePhone(String homePhone)
	{
		sh.setText(by.homePhone, homePhone);
		return (T)this;
	}
	
	public String getPreferredLanguage()
	{
		return sh.getValue(by.preferredLanguage);
	}
	
	public T setPreferredLanguage(String preferredLanguage)
	{
		sh.setText(by.preferredLanguage, preferredLanguage);
		return (T)this;
	}
	
	public String getSsn()
	{
		return sh.getValue(by.ssn);
	}
	
	public T setSsn(String ssn)
	{
		sh.setText(by.ssn, ssn);
		return (T)this;
	}
	
	public String getDescription()
	{
		return sh.getValue(by.description);
	}
	
	public T setDescription(String description)
	{
		sh.setText(by.description, description);
		return (T)this;
	}
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public T setCounty(String county)
	{
		sh.setText(by.county, county);
		return (T)this;
	}
	public String getPrimaryPhone()
	{
		return sh.getValue(by.primaryPhone);
		
	}
	public String getPrimaryEmail()
	{
		return sh.getValue(by.primaryEmail);
	}
	public String getSecondaryEmail()
	{
		return sh.getValue(by.secondaryEmail);
	}
	
	public T setSecondaryEmail(String secondaryEmail)
	{
		sh.setText(by.secondaryEmail, secondaryEmail);
		return (T)this;
	}
	public T setPrimaryEmail(String primaryEmail)
	{
		sh.setText(by.primaryEmail, primaryEmail);
		return (T)this;
	}
	public T setPrimaryPhone(String primaryPhone)
	{
		sh.setText(by.primaryPhone, primaryPhone);
		sh.tab();
		return (T)this;
	}
	
	public String getFaxPhone()
	{
		return sh.getValue(by.faxPhone);
	}
	
	
	
	public T setFaxPhone(String faxPhone)
	{
		sh.setText(by.faxPhone, faxPhone);
		return (T)this;
	}
	public String getMobilePhone()
	{
		return sh.getValue(by.mobilePhone);
	}
	
	public T setMobilePhone(String mobilePhone)
	{
		sh.setText(by.mobilePhone, mobilePhone);
		return (T)this;
	}
	
	public String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	public T setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		return (T)this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}

	public T setCountry(String country)
	{
		sh.setText(by.country, country);
		return (T)this;
	}
	
	public String getAddressLine2()
	{
		return sh.getValue(by.address2);
	}
	
	public T setAddressLine2(String address2)
	{
		sh.setText(by.address2, address2);
		return (T)this;
	}
	
	public String getAddressLine3()
	{
		return sh.getValue(by.address3);
	}
	
	public T setAddressLine3(String address3)
	{
		sh.setText(by.address3, address3);
		return (T)this;
	}
	
	public String getDateOfBirth()
	{
		return sh.getValue(by.dateOfBirth);
	}
	
	public T setDateOfBirth(String dateOfBirth)
	{
		sh.setText(by.dateOfBirth, dateOfBirth);
		sh.tab();
		return (T)this;
	}
	
	
	public T update()
	{
		sh.waitForNoMask();
		sh.clickElement(by.updateBtn);
		return (T)this;
	}

	//region Contact Input Set

	public T setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return (T)this;
	}
	public String getFirstName()
	{
		return sh.getValue(by.firstName);
	}


	public T setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return (T)this;
	}
	public String getLastName()
	{
		return sh.getValue(by.lastName);
	}

	//endregion

	public T setAddressLine1(String address)
	{
		sh.setText(by.address1, address);
//		sh.tab();
		return (T)this;
	}
	public String getAddressLine1()
	{
		return sh.getValue(by.address1);
	}



	public T  setCity(String city)
	{
		sh.setText(by.city, city);
//		sh.tab();
		return (T)this;
	}
	public String getCity()
	{
		return sh.getValue(by.city);
	}

	public T setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		return (T)this;
	}
	public String getState()
	{
		return sh.getValue(by.state);
	}


	public T setZipCode(String zip)
	{
		sh.setText(by.zip, zip);
		sh.tab();
		sh.waitForNoMask();
		sh.waitForPageLoad();
		return (T)this;
	}
	public String getZipCode()
	{
		return sh.getValue(by.zip);
	}


	public T verifyAddress()
	{
		for(int i = 0;i<5;i++)
		{
			sh.waitForNoMask();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(!sh.isMaskPresent())
				break;

		}
		sh.waitForNoMask();
		sh.waitForPageLoad();
		sh.clickElement(by.verifyAddress);
		return (T)this;
	}

	public T setAddressType(String addressType)
	{
		sh.setText(by.addressType, addressType);
		sh.tab();
		return (T)this;
	}
	public String getAddressType()
	{
		return sh.getValue(by.addressType);
	}

	public T setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.tab();
		return (T)this;
	}
	public String getOrganization()
	{
		return sh.getValue(by.organization);
	}

	public T setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		return (T)this;
	}
	public String getProducerCode()
	{
		return sh.getValue(by.producerCode);
	}

	public T clickProducerCode()
	{
		sh.clickElement(By.cssSelector(".x-boundlist-selected"));
		return (T)this;
	}
	public T organizationSearch()
	{
		sh.clickElement(by.organizationSearchButton);
		return (T)this;
	}

	public T clickProducerCodeDropdown()
	{
		sh.clickElement(by.producerCodeDropdown);
		return (T)this;
	}
}