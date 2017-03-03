package pageobjects.SCHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/2/2017.
 */
public class SCHO4SearchAddressBook extends SearchAddressBook<SCHO4SearchAddressBook> {

    public SCHO4SearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public SCHO4SearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public SCHO4PolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new SCHO4PolicyInfo(sh, path);
    }
    public SCHO4Dwelling.SCHO4AdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new SCHO4Dwelling(sh, path).new SCHO4AdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public SCHO4PolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new SCHO4PolicyInfo(sh, path);
    }
    public SCHO4Dwelling.SCHO4AdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new SCHO4Dwelling(sh, path).new SCHO4AdditionalInterests(sh, path);
    }

    public SCHO4SearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public SCHO4SearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public SCHO4SearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public SCHO4SearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public SCHO4SearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public SCHO4SearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public SCHO4SearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public SCHO4SearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public SCHO4SearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public SCHO4SearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public SCHO4SearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public SCHO4SearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public SCHO4SearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public SCHO4SearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public SCHO4SearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public SCHO4SearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public SCHO4SearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public SCHO4SearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
