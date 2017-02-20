package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3SearchAddressBook extends SearchAddressBook<NCHO3SearchAddressBook>
{	public NCHO3SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public NCHO3SearchAddressBook(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public NCHO3PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		super.clickFirstSearchResultPolicyInfo();
		return new NCHO3PolicyInfo(sh, path);
	}
	public NCHO3Dwelling.NCHO3AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		super.clickFirstSearchResultAdditionalInterest();
		return new NCHO3Dwelling(sh, path).new NCHO3AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return super.areThereSearchResults();
	}
	public boolean areThereMoreThanOneSearchResult()
	{
		return super.areThereMoreThanOneSearchResult();
	}
	public NCHO3PolicyInfo clickReturnToPolicyInfo()
	{
		super.returnToPolicyInfo();
		return new NCHO3PolicyInfo(sh, path);
	}
	public NCHO3Dwelling.NCHO3AdditionalInterests clickReturnToDwelling()
	{
		super.returnToDwelling();
		return new NCHO3Dwelling(sh, path).new NCHO3AdditionalInterests(sh, path);
	}

	public NCHO3SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public NCHO3SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public NCHO3SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public NCHO3SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public NCHO3SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public NCHO3SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public NCHO3SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public NCHO3SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public NCHO3SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public NCHO3SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public NCHO3SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public NCHO3SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public NCHO3SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public NCHO3SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public NCHO3SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public NCHO3SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public NCHO3SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public NCHO3SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
