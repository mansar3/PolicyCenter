package pageobjects.NCWindOnly;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCWindOnlySearchAddressBook  extends SearchAddressBook<NCWindOnlySearchAddressBook> {
    public NCWindOnlySearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public NCWindOnlySearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCWindOnlyPolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new NCWindOnlyPolicyInfo(sh, path);
    }
    public NCWindOnlyDwelling.NCWindOnlyAdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new NCWindOnlyDwelling(sh, path).new NCWindOnlyAdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public NCWindOnlyPolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new NCWindOnlyPolicyInfo(sh, path);
    }
    public NCWindOnlyDwelling.NCWindOnlyAdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new NCWindOnlyDwelling(sh, path).new NCWindOnlyAdditionalInterests(sh, path);
    }

    public NCWindOnlySearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public NCWindOnlySearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public NCWindOnlySearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public NCWindOnlySearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public NCWindOnlySearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public NCWindOnlySearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public NCWindOnlySearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public NCWindOnlySearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public NCWindOnlySearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public NCWindOnlySearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public NCWindOnlySearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public NCWindOnlySearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public NCWindOnlySearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public NCWindOnlySearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public NCWindOnlySearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public NCWindOnlySearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public NCWindOnlySearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public NCWindOnlySearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
