package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6SearchAddressBook extends SearchAddressBook<SCHO6SearchAddressBook>
{	public SCHO6SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO6SearchAddressBook(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO6PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		super.clickFirstSearchResultPolicyInfo();
		return new SCHO6PolicyInfo(sh, path);
	}
	public SCHO6Dwelling.SCHO6AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		super.clickFirstSearchResultAdditionalInterest();
		return new SCHO6Dwelling(sh, path).new SCHO6AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return super.areThereSearchResults();
	}
	public boolean areThereMoreThanOneSearchResult()
	{
		return super.areThereMoreThanOneSearchResult();
	}
	public SCHO6PolicyInfo clickReturnToPolicyInfo()
	{
		super.returnToPolicyInfo();
		return new SCHO6PolicyInfo(sh, path);
	}
	public SCHO6Dwelling.SCHO6AdditionalInterests clickReturnToDwelling()
	{
		super.returnToDwelling();
		return new SCHO6Dwelling(sh, path).new SCHO6AdditionalInterests(sh, path);
	}

	public SCHO6SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public SCHO6SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public SCHO6SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public SCHO6SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public SCHO6SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public SCHO6SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public SCHO6SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public SCHO6SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public SCHO6SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public SCHO6SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public SCHO6SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public SCHO6SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public SCHO6SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public SCHO6SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public SCHO6SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public SCHO6SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public SCHO6SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public SCHO6SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
