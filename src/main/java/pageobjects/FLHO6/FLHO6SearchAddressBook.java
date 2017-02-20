package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6SearchAddressBook extends SearchAddressBook<FLHO6SearchAddressBook>
{
	public FLHO6SearchAddressBook(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}
	public FLHO6SearchAddressBook(CenterSeleniumHelper sh)
	{
		super(sh);
	}

	public FLHO6PolicyInfo selectFirstSearchResultPolicyInfo()
	{
		super.clickFirstSearchResultPolicyInfo();
		return new FLHO6PolicyInfo(sh, path);
	}
	public FLHO6Dwelling.FLHO6AdditionalInterests selectFirstSearchResultAdditionalInterests()
	{
		super.clickFirstSearchResultAdditionalInterest();
		return new FLHO6Dwelling(sh, path).new FLHO6AdditionalInterests(sh, path);
	}
	public boolean areThereSearchResults()
	{
		return super.areThereSearchResults();
	}
	public boolean areThereMoreThanOneSearchResult()
	{
		return super.areThereMoreThanOneSearchResult();
	}
	public FLHO6PolicyInfo clickReturnToPolicyInfo()
	{
		super.returnToPolicyInfo();
		return new FLHO6PolicyInfo(sh, path);
	}
	public FLHO6Dwelling.FLHO6AdditionalInterests clickReturnToDwelling()
	{
		super.returnToDwelling();
		return new FLHO6Dwelling(sh, path).new FLHO6AdditionalInterests(sh, path);
	}

	public FLHO6SearchAddressBook clickSearch()
	{
		return super.clickSearch();
		//return this;
	}
	public FLHO6SearchAddressBook clickReset()
	{
		return super.clickReset();
	}
	public FLHO6SearchAddressBook clickPrintExport()
	{
		return super.clickPrintExport();
	}



	public String getWorkPhone()
	{
		return super.getWorkPhone();
	}

	public FLHO6SearchAddressBook setWorkPhone(String workPhone)
	{
		return super.setWorkPhone(workPhone);
	}

	public FLHO6SearchAddressBook clickFirstNameExactMatch()
	{
		return super.clickFirstNameExactMatch();
	}

	public FLHO6SearchAddressBook clickLastNameExactMatch()
	{
		return super.clickLastNameExactMatch();
	}

	public FLHO6SearchAddressBook clickCompanyNameExactMatch()
	{
		return super.clickCompanyNameExactMatch();
	}

	public String getType()
	{
		return super.getType();
	}

	public FLHO6SearchAddressBook setType(String type)
	{
		return super.setType(type);
	}
	public String getCompanyName()
	{
		return super.getCompanyName();
	}

	public FLHO6SearchAddressBook setCompanyName(String companyName)
	{
		return super.setCompanyName(companyName);
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}

	public FLHO6SearchAddressBook setFirstName(String firstName)
	{
		return super.setFirstName(firstName);
	}

	public String getLastName()
	{
		return super.getLastName();
	}

	public FLHO6SearchAddressBook setLastName(String lastName)
	{
		return super.setLastName(lastName);
	}

	public String getCountry()
	{
		return super.getCountry();
	}

	public FLHO6SearchAddressBook setCountry(String country)
	{
		return super.setCountry(country);
	}

	public String getCity()
	{
		return super.getCity();
	}

	public FLHO6SearchAddressBook setCity(String city)
	{
		return super.setCity(city);
	}
	public String getState()
	{
		return super.getState();
	}

	public FLHO6SearchAddressBook setState(String state)
	{
		return super.setState(state);
	}
	public String getCounty()
	{
		return super.getCounty();
	}

	public FLHO6SearchAddressBook setCounty(String county)
	{
		return super.setCounty(county);
	}
	public String getZipCode()
	{
		return super.getZipCode();
	}

	public FLHO6SearchAddressBook setZipCode(String zipCode)
	{
		return super.setZipCode(zipCode);
	}
	public String getTaxID()
	{
		return super.getTaxID();
	}

	public FLHO6SearchAddressBook setTaxID(String taxID)
	{
		return super.setTaxID(taxID);
	}
	public String getPhone()
	{
		return super.getPhone();
	}

	public FLHO6SearchAddressBook setPhone(String phone)
	{
		return super.setPhone(phone);
	}
}
