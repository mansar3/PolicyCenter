package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.FLHO3.FLHO3Dwelling;
import pageobjects.FLHO3.FLHO3PolicyInfo;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3SearchAddressBook extends SearchAddressBook<ALHO3SearchAddressBook>
{
	public ALHO3SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public ALHO3SearchAddressBook(CenterSeleniumHelper sh)
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

	public ALHO3SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public ALHO3SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public ALHO3SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public ALHO3SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public ALHO3SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public ALHO3SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public ALHO3SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public ALHO3SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public ALHO3SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public ALHO3SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public ALHO3SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public ALHO3SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public ALHO3SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public ALHO3SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public ALHO3SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public ALHO3SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public ALHO3SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public ALHO3SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
