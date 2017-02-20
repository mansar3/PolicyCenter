package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3SearchAddressBook extends SearchAddressBook<FLHO3SearchAddressBook>
{
	public FLHO3SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO3SearchAddressBook(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO3PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		super.clickFirstSearchResultPolicyInfo();
		return new FLHO3PolicyInfo(sh, path);
	}
	public FLHO3Dwelling.FLHO3AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		super.clickFirstSearchResultAdditionalInterest();
		return new FLHO3Dwelling(sh, path).new FLHO3AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return super.areThereSearchResults();
	}
	public boolean areThereMoreThanOneSearchResult()
	{
		return super.areThereMoreThanOneSearchResult();
	}
	public FLHO3PolicyInfo clickReturnToPolicyInfo()
	{
		super.returnToPolicyInfo();
		return new FLHO3PolicyInfo(sh, path);
	}
	public FLHO3Dwelling.FLHO3AdditionalInterests clickReturnToDwelling()
	{
		super.returnToDwelling();
		return new FLHO3Dwelling(sh, path).new FLHO3AdditionalInterests(sh, path);
	}

	public FLHO3SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public FLHO3SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public FLHO3SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public FLHO3SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public FLHO3SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public FLHO3SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public FLHO3SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public FLHO3SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public FLHO3SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public FLHO3SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public FLHO3SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public FLHO3SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public FLHO3SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public FLHO3SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public FLHO3SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public FLHO3SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public FLHO3SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public FLHO3SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
