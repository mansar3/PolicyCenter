package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4SearchAddressBook extends SearchAddressBook<FLHO4SearchAddressBook> {

    public FLHO4SearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public FLHO4SearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public FLHO4PolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new FLHO4PolicyInfo(sh, path);
    }
    public FLHO4Dwelling.FLHO4AdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new FLHO4Dwelling(sh, path).new FLHO4AdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public FLHO4PolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new FLHO4PolicyInfo(sh, path);
    }
    public FLHO4Dwelling.FLHO4AdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new FLHO4Dwelling(sh, path).new FLHO4AdditionalInterests(sh, path);
    }

    public FLHO4SearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public FLHO4SearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public FLHO4SearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public FLHO4SearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public FLHO4SearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public FLHO4SearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public FLHO4SearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public FLHO4SearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public FLHO4SearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public FLHO4SearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public FLHO4SearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public FLHO4SearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public FLHO4SearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public FLHO4SearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public FLHO4SearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public FLHO4SearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public FLHO4SearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public FLHO4SearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
