package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class CreateAccount extends CenterPanelBase
{
	private CreateAccountBy by;
	public String streetAddress, city, state;

	public static class CreateAccountBy extends CenterPanelBase.CenterPanelBy{
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
						preferredLanguage = By.id(createAccountDiv + "PrimaryLanguage-inputEl");





	}

	public CreateAccount(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new CreateAccountBy();
		expectedPanelTitle = "Create account";
		waitForTitle(sh);
	}
	
	public String getHomePhone()
	{
		return sh.getValue(by.homePhone);
	}
	
	public CreateAccount setHomePhone(String homePhone)
	{
		sh.setText(by.homePhone, homePhone);
		return this;
	}
	
	public String getPreferredLanguage()
	{
		return sh.getValue(by.preferredLanguage);
	}
	
	public CreateAccount setPreferredLanguage(String preferredLanguage)
	{
		sh.setText(by.preferredLanguage, preferredLanguage);
		return this;
	}
	
	public String getSsn()
	{
		return sh.getValue(by.ssn);
	}
	
	public CreateAccount setSsn(String ssn)
	{
		sh.setText(by.ssn, ssn);
		return this;
	}
	
	public String getDescription()
	{
		return sh.getValue(by.description);
	}
	
	public CreateAccount setDescription(String description)
	{
		sh.setText(by.description, description);
		return this;
	}
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public CreateAccount setCounty(String county)
	{
		sh.setText(by.county, county);
		return this;
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
	
	public CreateAccount setSecondaryEmail(String secondaryEmail)
	{
		sh.setText(by.secondaryEmail, secondaryEmail);
		return this;
	}
	public CreateAccount setPrimaryEmail(String primaryEmail)
	{
		sh.setText(by.primaryEmail, primaryEmail);
		return this;
	}
	public CreateAccount setPrimaryPhone(String primaryPhone)
	{
		sh.setText(by.primaryPhone, primaryPhone);
		sh.tab();
		return this;
	}
	
	public String getFaxPhone()
	{
		return sh.getValue(by.faxPhone);
	}
	
	
	
	public CreateAccount setFaxPhone(String faxPhone)
	{
		sh.setText(by.faxPhone, faxPhone);
		return this;
	}
	public String getMobilePhone()
	{
		return sh.getValue(by.mobilePhone);
	}
	
	public CreateAccount setMobilePhone(String mobilePhone)
	{
		sh.setText(by.mobilePhone, mobilePhone);
		return this;
	}
	
	public String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	public CreateAccount setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		return this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}

	public CreateAccount setCountry(String country)
	{
		sh.setText(by.country, country);
		return this;
	}
	
	public String getAddressLine2()
	{
		return sh.getValue(by.address2);
	}
	
	public CreateAccount setAddressLine2(String address2)
	{
		sh.setText(by.address2, address2);
		return this;
	}
	
	public String getAddressLine3()
	{
		return sh.getValue(by.address3);
	}
	
	public CreateAccount setAddressLine3(String address3)
	{
		sh.setText(by.address3, address3);
		return this;
	}
	
	public String getDateOfBirth()
	{
		return sh.getValue(by.dateOfBirth);
	}
	
	public CreateAccount setDateOfBirth(String dateOfBirth)
	{
		sh.setText(by.dateOfBirth, dateOfBirth);
		sh.tab();
		return this;
	}
	
	
	public AccountFileSummary clickUpdate()
	{
		sh.waitForNoMask();
		sh.clickElement(by.updateBtn);
		return new AccountFileSummary(sh);
	}

	//region Contact Input Set

	public CreateAccount setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return this;
	}

	public CreateAccount setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return this;
	}

	//endregion

	public CreateAccount setAddressLine1(String address)
	{
		sh.setText(by.address1, address);
//		sh.tab();
		return this;
	}
	public String getAddressLine1()
	{
		return sh.getValue(by.address1);
	}



	public CreateAccount  setCity(String city)
	{
		sh.setText(by.city, city);
//		sh.tab();
		return this;
	}

	public CreateAccount setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		return this;
	}
	public String getState()
	{
		return sh.getValue(by.state);
	}


	public CreateAccount setZipCode(String zip)
	{
		sh.setText(by.zip, zip);
//		sh.tab();
		return this;
	}

	public SelectStandardizedAddress clickVerifyAddress()
	{
		sh.waitForNoMask(5);
		sh.clickElement(by.verifyAddress);
		return new SelectStandardizedAddress(sh);
	}

	public CreateAccount setAddressType(String addressType)
	{
		sh.setText(by.addressType, addressType);
		sh.tab();
		return this;
	}
	public String getAddressType()
	{
		return sh.getValue(by.addressType);
	}

	public CreateAccount setOrganization(String organization)
	{
		sh.setText(by.organization, organization);
		sh.tab();
		return this;
	}

	public CreateAccount setProducerCode(String producerCode)
	{
		sh.setText(by.producerCode, producerCode);
		sh.tab();
		return this;
	}
}