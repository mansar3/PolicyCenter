package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3SearchAddressBook extends SearchAddressBook<SCHO3SearchAddressBook>
{	public SCHO3SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public SCHO3SearchAddressBook(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public SCHO3PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		super.clickFirstSearchResultPolicyInfo();
		return new SCHO3PolicyInfo(sh, path);
	}
	public SCHO3Dwelling.SCHO3AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		super.clickFirstSearchResultAdditionalInterest();
		return new SCHO3Dwelling(sh, path).new SCHO3AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return super.areThereSearchResults();
	}
	public boolean areThereMoreThanOneSearchResult()
	{
		return super.areThereMoreThanOneSearchResult();
	}
	public SCHO3PolicyInfo clickReturnToPolicyInfo()
	{
		super.returnToPolicyInfo();
		return new SCHO3PolicyInfo(sh, path);
	}
	public SCHO3Dwelling.SCHO3AdditionalInterests clickReturnToDwelling()
	{
		super.returnToDwelling();
		return new SCHO3Dwelling(sh, path).new SCHO3AdditionalInterests(sh, path);
	}

	public SCHO3SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public SCHO3SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public SCHO3SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public SCHO3SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public SCHO3SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public SCHO3SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public SCHO3SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public SCHO3SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public SCHO3SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public SCHO3SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public SCHO3SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public SCHO3SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public SCHO3SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public SCHO3SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public SCHO3SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public SCHO3SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public SCHO3SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public SCHO3SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
