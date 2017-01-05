package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 12/21/16.
 */
public class SearchAddressBook extends CenterPanelBase
{
	private  SearchAddressBookBy by;
	public SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Search Address Book";
		waitForTitle(sh);
		by = new SearchAddressBookBy();
		System.out.println("Navigated to page: " + getTitle());
	}

	public class SearchAddressBookBy
	{
		String 	addressBookBase = "ContactSearchPopup:ContactSearchScreen:",
				basicInfoBase = addressBookBase + "BasicContactInfoInputSet:",
				addressBase = addressBookBase + "AddressOwnerAddressInputSet:globalAddressContainer:GlobalAddressInputSet:";

		By		type = By.id(addressBookBase + "ContactType-inputEl"),
				firstName = By.id(basicInfoBase + "GlobalPersonNameInputSet:FirstName-inputEl"),
				lastName = By.id(basicInfoBase + "GlobalPersonNameInputSet:LastName-inputEl"),
				firstNameExactMatch = By.id(basicInfoBase + "FirstNameExact-inputEl"),
				lastNameExactMatch = By.id(basicInfoBase + "LastNameExact-inputEl"),
				companyName = By.id(basicInfoBase + "GlobalContactNameInputSet:Name-inputEl"),
				companyNameExactMatch = By.id(basicInfoBase + "CompanyNameExact-inputEl"),
				taxID = By.id(basicInfoBase + "TaxID-inputEl"),
				phone = By.id(basicInfoBase + "Phone-inputEl"),
				workPhone = By.id(basicInfoBase + "PhoneNumber-inputEl"),
				country = By.id(addressBase + "Country-inputEl"),
				city = By.id(addressBase + "City-inputEl"),
				county = By.id(addressBase + "County-inputEl"),
				state = By.id(addressBase + "State-inputEl"),
				zipCode = By.id(addressBase + "PostalCode-inputEl"),


				// Buttons
				returnTo = By.id("ContactSearchPopup:__crumb__"),
				search = By.id(addressBookBase + "SearchAndResetInputSet:SearchLinksInputSet:Search"),
				reset = By.id(addressBookBase + "SearchAndResetInputSet:SearchLinksInputSet:Reset"),
				printExport = By.id(addressBookBase + "ContactSearchResultsLV_tb:PrintMe-btnInnerEl"); 


	}
	public void selectSearchResult(int row)
	{
		sh.clickElement(By.id(by.addressBookBase + "ContactSearchResultsLV:" + String.valueOf(row) + ":_Select"));
	}
	public PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		selectSearchResult(0);
		return new PolicyInfo(sh, path);
	}
	public Dwelling.AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		selectSearchResult(0);
		return new Dwelling(sh, path).new AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return sh.isDisplayed(By.id(by.addressBookBase + "ContactSearchResultsLV:0:_Select"));
	}
	public PolicyInfo clickReturnToPolicyInfo()
	{
		sh.clickElement(by.returnTo);
		sh.waitForNoMask();
		return new PolicyInfo(sh, path);
	}
	public Dwelling.AdditionalInterests clickReturnToDwelling()
	{
		sh.clickElement(by.returnTo);
		sh.waitForNoMask();
		return new Dwelling(sh, path).new AdditionalInterests(sh, path);
	}
	
	public SearchAddressBook clickSearch()
	{
		sh.clickElement(by.search);
		sh.waitForNoMask();
		return this;
	}
	public SearchAddressBook clickReset()
	{
		sh.clickElement(by.reset);
		sh.waitForNoMask();
		return this;
	}
	public SearchAddressBook clickPrintExport()
	{
		sh.clickElement(by.printExport);
		return this;
	}
	

	
	public String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	public SearchAddressBook setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		sh.tab();

		return this;
	}
	public SearchAddressBook clickFirstNameExactMatch()
	{
		sh.clickElement(by.firstNameExactMatch);
		return this;
	}
	public SearchAddressBook clickLastNameExactMatch()
	{
		sh.clickElement(by.lastNameExactMatch);
		return this;
	}
	public SearchAddressBook clickCompanyNameExactMatch()
	{
		sh.clickElement(by.companyNameExactMatch);
		return this;
	}
	public String getType()
	{
		return sh.getValue(by.type);
	}
	
	public SearchAddressBook setType(String type)
	{
		sh.setText(by.type, type);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getCompanyName()
	{
		return sh.getValue(by.companyName);
	}

	public SearchAddressBook setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		sh.tab();

		return this;
	}
	public String getFirstName()
	{
		return sh.getValue(by.firstName);
	}

	public SearchAddressBook setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		sh.tab();

		return this;
	}
	public String getLastName()
	{
		return sh.getValue(by.lastName);
	}

	public SearchAddressBook setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		sh.tab();

		return this;
	}
	public String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	public SearchAddressBook setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getCity()
	{
		return sh.getValue(by.city);
	}

	public SearchAddressBook setCity(String city)
	{
		sh.setText(by.city, city);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getState()
	{
		return sh.getValue(by.state);
	}

	public SearchAddressBook setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getCounty()
	{
		return sh.getValue(by.county);
	}

	public SearchAddressBook setCounty(String county)
	{
		sh.setText(by.county, county);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}

	public SearchAddressBook setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getTaxID()
	{
		return sh.getValue(by.taxID);
	}

	public SearchAddressBook setTaxID(String taxID)
	{
		sh.setText(by.taxID, taxID);
		sh.tab();

		return this;
	}
	public String getPhone()
	{
		return sh.getValue(by.phone);
	}
	
	public SearchAddressBook setPhone(String phone)
	{
		sh.setText(by.phone, phone);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
}
