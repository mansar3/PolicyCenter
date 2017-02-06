package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

public abstract class EnterAccountInformation<E extends EnterAccountInformation> extends CenterPanelBase
{

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
		System.out.println("Navigated to: " + expectedPanelTitle);
	}

	public E setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		return (E)this;
	}

	public E  setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		return (E)this;
	}

	public E  setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		return (E)this;
	}
	
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}
	
	public E  setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		return (E)this;
	}
	
	public String getState()
	{
		return sh.getValue(by.state);
	}
	
	public E  setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		return (E)this;
	}
	
	public String getCity()
	{
		return sh.getValue(by.city);
	}
	
	public E  setCity(String city)
	{
		sh.setText(by.city, city);
		return (E)this;
	}
	
	public String getCounty()
	{
		return sh.getValue(by.county);
	}
	
	public E  setCounty(String county)
	{
		sh.setText(by.county, county);
		return (E)this;
	}
	
	public String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	public E  setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		return (E)this;
	}

	public E  clickSearch()
	{
		sh.waitForNoMask();
		sh.clickElement(by.searchBtn);
		return (E)this;
	}
	public E  clickCompanyNameExactMatch()
	{
		sh.clickElement(by.companyExactMatch);
		return (E)this;
	}

	public E  clickFirstNameExactMatch()
	{
		sh.clickElement(by.firstNameExactMatch);
		return (E)this;
	}
	public E  clickLastNameExactMatch()
	{
		sh.clickElement(by.lastNameExactMatch);
		return (E)this;
	}
	
	public void clickResetBtn()
	{
		sh.clickElement(by.resetBtn);
	}
	


	public E  clickCreateNewAccount()
	{
		sh.waitForNoMask();
		sh.clickElement(by.createNewAcctBtn);
		return (E)this;
	}

	private E newAccount(String accountType)
	{
		clickCreateNewAccount();
		sh.clickElement(By.id("NewAccount:NewAccountScreen:NewAccountButton:NewAccount_"+accountType+"-itemEl"));
		return (E)this;
	}

	protected E createNewCompanyAccount()
	{
		return newAccount("Company");
	}

	protected E createNewPersonAccount()
	{
		return newAccount("Person");
	}

	protected E searchFromAddressBookAccount()
	{
		return newAccount("FromAB");
	}
}