package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public class EnterAccountInformation extends CenterPanelBase
{
	CenterSeleniumHelper sh;
	EnterAccountInformationBy by;

	public class EnterAccountInformationBy extends CenterPanelBase.CenterPanelBy{
		private String 	base_id = "NewAccount:NewAccountScreen:NewAccountSearchDV:",
						addressBase = base_id +"AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:";

		final public By companyName = By.id(base_id + "GlobalContactNameInputSet:Name-inputEl"),
						companyExactMatch = By.id(base_id + "CompanyNameExact-inputEl"),
						firstName = By.id(base_id + "GlobalPersonNameInputSet:FirstName-inputEl"),
						lastName = By.id(base_id + "GlobalPersonNameInputSet:LastName-inputEl"),
						firstNameExactMatch =By.id(base_id + "FirstNameExact-inputEl"),
						lastNameExactMatch = By.id(base_id + "LastNameExact-inputEl"),
						country = By.id(addressBase + "Country-inputEl"),
						city = By.id(addressBase + "City-inputEl"),
						county = By.id(addressBase + "County-inputEl"),
						state = By.id(addressBase + "State-inputEl"),
						zipCode = By.id(addressBase + "PostalCode-inputEl"),
						searchBtn = By.id(base_id + "SearchAndResetInputSet:SearchLinksInputSet:Search"),
						resetBtn = By.id(base_id + "SearchAndResetInputSet:SearchLinksInputSet:Reset"),
						createNewAcctBtn = By.id("NewAccount:NewAccountScreen:NewAccountButton");

	}
	public EnterAccountInformation(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		by = new EnterAccountInformationBy();
		expectedPanelTitle = "Enter Account Information";
		waitForTitle(sh);
	}

	public EnterAccountInformation setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		return this;
	}

	public EnterAccountInformation setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return this;
	}

	public EnterAccountInformation setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return this;
	}
	
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}
	
	public EnterAccountInformation setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		return this;
	}
	
	public String getState()
	{
		return sh.getValue(by.state);
	}
	
	public EnterAccountInformation setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		return this;
	}
	
	public String getCity()
	{
		return sh.getValue(by.city);
	}
	
	public EnterAccountInformation setCity(String city)
	{
		sh.setText(by.city, city);
		return this;
	}
	
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public EnterAccountInformation setCounty(String county)
	{
		sh.setText(by.county, county);
		return this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	public EnterAccountInformation setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		return this;
	}

	public EnterAccountInformation clickSearch()
	{
		sh.waitForNoMask();
		sh.clickElement(by.searchBtn);
		return this;
	}
	public EnterAccountInformation clickCompanyNameExactMatch()
	{
		sh.clickElement(by.companyExactMatch);
		return this;
	}

	public EnterAccountInformation clickFirstNameExactMatch()
	{
		sh.clickElement(by.firstNameExactMatch);
		return this;
	}
	public EnterAccountInformation clickLastNameExactMatch()
	{
		sh.clickElement(by.lastNameExactMatch);
		return this;
	}
	
	public void clickResetBtn()
	{
		sh.clickElement(by.resetBtn);
	}
	


	public EnterAccountInformation clickCreateNewAccount()
	{
		sh.waitForNoMask();
		sh.clickElement(by.createNewAcctBtn);
		return this;
	}

	private CreateAccount createNewAccount(String accountType)
	{
		clickCreateNewAccount();
		sh.clickElement(By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_"+accountType+"-itemEl"));
		return new CreateAccount(sh);
	}

	public CreateAccount CreateCompanyAccount()
	{
		return createNewAccount("Company");
	}

	public CreateAccount CreatePersonAccount()
	{
		return createNewAccount("Person");
	}

	public CreateAccount CreateFromAddressBookAccount()
	{
		return createNewAccount("FromAB");
	}
}