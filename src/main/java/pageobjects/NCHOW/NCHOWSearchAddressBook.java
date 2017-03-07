package pageobjects.NCHOW;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/4/2017.
 */
public class NCHOWSearchAddressBook extends SearchAddressBook<NCHOWSearchAddressBook> {
    public NCHOWSearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public NCHOWSearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public NCHOWPolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new NCHOWPolicyInfo(sh, path);
    }
    public NCHOWDwelling.NCHOWAdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new NCHOWDwelling(sh, path).new NCHOWAdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public NCHOWPolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new NCHOWPolicyInfo(sh, path);
    }
    public NCHOWDwelling.NCHOWAdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new NCHOWDwelling(sh, path).new NCHOWAdditionalInterests(sh, path);
    }

    public NCHOWSearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public NCHOWSearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public NCHOWSearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public NCHOWSearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public NCHOWSearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public NCHOWSearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public NCHOWSearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public NCHOWSearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public NCHOWSearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public NCHOWSearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public NCHOWSearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public NCHOWSearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public NCHOWSearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public NCHOWSearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public NCHOWSearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public NCHOWSearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public NCHOWSearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public NCHOWSearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
