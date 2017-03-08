package pageobjects.ALHO3UWIssue;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.SearchAddressBook;

/**
 * Created by ssai on 3/7/2017.
 */
public class ALHO3UWIssueSearchAddressBook extends SearchAddressBook<ALHO3UWIssueSearchAddressBook> {

    public ALHO3UWIssueSearchAddressBook(CenterSeleniumHelper sh, Path path)
    {
        super(sh, path);
    }
    public ALHO3UWIssueSearchAddressBook(CenterSeleniumHelper sh)
    {
        super(sh);
    }

    public ALHO3UWIssuePolicyInfo selectFirstSearchResultPolicyInfo()
    {
        super.clickFirstSearchResultPolicyInfo();
        return new ALHO3UWIssuePolicyInfo(sh, path);
    }
    public ALHO3UWIssueDwelling.ALHO3UWIssueAdditionalInterests selectFirstSearchResultAdditionalInterests()
    {
        super.clickFirstSearchResultAdditionalInterest();
        return new ALHO3UWIssueDwelling(sh, path).new ALHO3UWIssueAdditionalInterests(sh, path);
    }
    public boolean areThereSearchResults()
    {
        return super.areThereSearchResults();
    }
    public boolean areThereMoreThanOneSearchResult()
    {
        return super.areThereMoreThanOneSearchResult();
    }
    public ALHO3UWIssuePolicyInfo clickReturnToPolicyInfo()
    {
        super.returnToPolicyInfo();
        return new ALHO3UWIssuePolicyInfo(sh, path);
    }
    public ALHO3UWIssueDwelling.ALHO3UWIssueAdditionalInterests clickReturnToDwelling()
    {
        super.returnToDwelling();
        return new ALHO3UWIssueDwelling(sh, path).new ALHO3UWIssueAdditionalInterests(sh, path);
    }

    public ALHO3UWIssueSearchAddressBook clickSearch()
    {
        return super.clickSearch();
        //return this;
    }
    public ALHO3UWIssueSearchAddressBook clickReset()
    {
        return super.clickReset();
    }
    public ALHO3UWIssueSearchAddressBook clickPrintExport()
    {
        return super.clickPrintExport();
    }



    public String getWorkPhone()
    {
        return super.getWorkPhone();
    }

    public ALHO3UWIssueSearchAddressBook setWorkPhone(String workPhone)
    {
        return super.setWorkPhone(workPhone);
    }

    public ALHO3UWIssueSearchAddressBook clickFirstNameExactMatch()
    {
        return super.clickFirstNameExactMatch();
    }

    public ALHO3UWIssueSearchAddressBook clickLastNameExactMatch()
    {
        return super.clickLastNameExactMatch();
    }

    public ALHO3UWIssueSearchAddressBook clickCompanyNameExactMatch()
    {
        return super.clickCompanyNameExactMatch();
    }

    public String getType()
    {
        return super.getType();
    }

    public ALHO3UWIssueSearchAddressBook setType(String type)
    {
        return super.setType(type);
    }
    public String getCompanyName()
    {
        return super.getCompanyName();
    }

    public ALHO3UWIssueSearchAddressBook setCompanyName(String companyName)
    {
        return super.setCompanyName(companyName);
    }
    public String getFirstName()
    {
        return super.getFirstName();
    }

    public ALHO3UWIssueSearchAddressBook setFirstName(String firstName)
    {
        return super.setFirstName(firstName);
    }

    public String getLastName()
    {
        return super.getLastName();
    }

    public ALHO3UWIssueSearchAddressBook setLastName(String lastName)
    {
        return super.setLastName(lastName);
    }

    public String getCountry()
    {
        return super.getCountry();
    }

    public ALHO3UWIssueSearchAddressBook setCountry(String country)
    {
        return super.setCountry(country);
    }

    public String getCity()
    {
        return super.getCity();
    }

    public ALHO3UWIssueSearchAddressBook setCity(String city)
    {
        return super.setCity(city);
    }
    public String getState()
    {
        return super.getState();
    }

    public ALHO3UWIssueSearchAddressBook setState(String state)
    {
        return super.setState(state);
    }
    public String getCounty()
    {
        return super.getCounty();
    }

    public ALHO3UWIssueSearchAddressBook setCounty(String county)
    {
        return super.setCounty(county);
    }
    public String getZipCode()
    {
        return super.getZipCode();
    }

    public ALHO3UWIssueSearchAddressBook setZipCode(String zipCode)
    {
        return super.setZipCode(zipCode);
    }
    public String getTaxID()
    {
        return super.getTaxID();
    }

    public ALHO3UWIssueSearchAddressBook setTaxID(String taxID)
    {
        return super.setTaxID(taxID);
    }
    public String getPhone()
    {
        return super.getPhone();
    }

    public ALHO3UWIssueSearchAddressBook setPhone(String phone)
    {
        return super.setPhone(phone);
    }
}
