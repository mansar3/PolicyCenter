package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;

/**
 * Created by aansari on 12/21/16.
 */
public abstract class SearchAddressBook<T extends CenterPanelBase> extends CenterPanelBase
{
	private  SearchAddressBookBy by;
	public SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Search Address Book";
		waitForTitle(sh);
		by = new SearchAddressBookBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
	}
	public SearchAddressBook(CenterSeleniumHelper sh)
	{
		this.sh = sh;
		expectedPanelTitle = "Search Address Book";
		waitForTitle(sh);
		by = new SearchAddressBookBy();
		System.out.println("Navigated to page: " + expectedPanelTitle);
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
	private void selectSearchResult(int row)
	{
		sh.clickElement(By.id(by.addressBookBase + "ContactSearchResultsLV:" + String.valueOf(row) + ":_Select"));
	}
	protected T clickFirstSearchResultPolicyInfo()
	{
		selectSearchResult(0);
		System.out.println("Result found in Address Book: " + this.firstName + " " + this.lastName);
		return (T)this;
	}
	protected T clickFirstSearchResultAdditionalInterest()
	{
		selectSearchResult(0);
		System.out.println("Result found in Address Book: " + this.firstName + " " + this.lastName);
		return (T)this;
	}
	protected boolean areThereSearchResults()
	{
		sh.waitForNoMask();
		return sh.isDisplayed(By.id(by.addressBookBase + "ContactSearchResultsLV:0:_Select"));
	}
	protected boolean areThereMoreThanOneSearchResult()
	{
		sh.waitForNoMask();
		return sh.isDisplayed(By.id(by.addressBookBase + "ContactSearchResultsLV:1:_Select"));
	}
	protected T returnToPolicyInfo()
	{
		sh.clickElement(by.returnTo);
		sh.waitForNoMask();
		return (T)this;
	}
	protected T returnToDwelling()
	{
		sh.clickElement(by.returnTo);
		sh.waitForNoMask();
		return (T)this;
	}
	
	protected T clickSearch()
	{
		// Added because even after waitForNoMask sometimes "click at point.."
		// would still occur.
		sh.waitForPageLoad();
		for(int i = 0; i < 5;i++)
		{
			sh.waitForNoMask();
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(!sh.isMaskPresent())
				break;

		}
		sh.waitForNoMask();
		sh.clickElement(by.search);
		return (T)this;
	}

	protected T clickReset()
	{
		sh.clickElement(by.reset);
		sh.waitForNoMask();
		return (T)this;
	}

	protected T clickPrintExport()
	{
		sh.clickElement(by.printExport);
		return (T)this;
	}
	
	protected String getWorkPhone()
	{
		return sh.getValue(by.workPhone);
	}
	
	protected T setWorkPhone(String workPhone)
	{
		sh.setText(by.workPhone, workPhone);
		sh.tab();
		return (T)this;
	}

	protected T clickFirstNameExactMatch()
	{
		sh.clickElement(by.firstNameExactMatch);
		return (T)this;
	}
	protected T clickLastNameExactMatch()
	{
		sh.clickElement(by.lastNameExactMatch);
		return (T)this;
	}

	protected T clickCompanyNameExactMatch()
	{
		sh.clickElement(by.companyNameExactMatch);
		return (T)this;
	}

	protected String getType()
	{
		return sh.getValue(by.type);
	}
	
	protected T setType(String type)
	{
		sh.setText(by.type, type);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getCompanyName()
	{
		return sh.getValue(by.companyName);
	}

	protected T setCompanyName(String companyName)
	{
		sh.setText(by.companyName, companyName);
		sh.tab();
		return (T)this;
	}
	protected String getFirstName()
	{
		return sh.getValue(by.firstName);
	}

	protected T setFirstName(String firstName)
	{
		sh.setText(by.firstName, firstName);
		sh.tab();
		this.firstName = firstName;
		return (T)this;
	}
	protected String getLastName()
	{
		return sh.getValue(by.lastName);
	}

	protected T setLastName(String lastName)
	{
		sh.setText(by.lastName, lastName);
		sh.tab();
		this.lastName = lastName;
		return (T)this;
	}
	protected String getCountry()
	{
		return sh.getValue(by.country);
	}
	
	protected T setCountry(String country)
	{
		sh.setText(by.country, country);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getCity()
	{
		return sh.getValue(by.city);
	}

	protected T setCity(String city)
	{
		sh.setText(by.city, city);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getState()
	{
		return sh.getValue(by.state);
	}

	protected T setState(String state)
	{
		sh.setText(by.state, state);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getCounty()
	{
		return sh.getValue(by.county);
	}

	protected T setCounty(String county)
	{
		sh.setText(by.county, county);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getZipCode()
	{
		return sh.getValue(by.zipCode);
	}

	protected T setZipCode(String zipCode)
	{
		sh.setText(by.zipCode, zipCode);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getTaxID()
	{
		return sh.getValue(by.taxID);
	}

	protected T setTaxID(String taxID)
	{
		sh.setText(by.taxID, taxID);
		sh.tab();
		return (T)this;
	}

	protected String getPhone()
	{
		return sh.getValue(by.phone);
	}
	
	protected T setPhone(String phone)
	{
		sh.setText(by.phone, phone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
}
