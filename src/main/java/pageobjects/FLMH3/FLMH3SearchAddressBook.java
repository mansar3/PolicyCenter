package pageobjects.FLMH3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/3/2017.
 */
public class FLMH3SearchAddressBook extends SearchAddressBook<FLMH3SearchAddressBook> {

    public FLMH3SearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public FLMH3SearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLMH3PolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new FLMH3PolicyInfo(sh, path);
    }
    public FLMH3Dwelling.FLMH3AdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new FLMH3Dwelling(sh, path).new FLMH3AdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public FLMH3PolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new FLMH3PolicyInfo(sh, path);
    }
    public FLMH3Dwelling.FLMH3AdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new FLMH3Dwelling(sh, path).new FLMH3AdditionalInterests(sh, path);
    }

    public FLMH3SearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public FLMH3SearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public FLMH3SearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public FLMH3SearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public FLMH3SearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public FLMH3SearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public FLMH3SearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public FLMH3SearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public FLMH3SearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public FLMH3SearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public FLMH3SearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public FLMH3SearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public FLMH3SearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public FLMH3SearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public FLMH3SearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public FLMH3SearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public FLMH3SearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public FLMH3SearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
