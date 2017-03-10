
package NC.HO3.NC.WindOnly;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Logon;

import pageobjects.NCHOW.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ssai on 3/4/2017.
 */
public class ValidationRulesNCWind extends BaseTest {
    private String dateString;
    private WebDriver driver;
    private Logon logon;
    private CenterSeleniumHelper sh;


    @BeforeMethod
    public void beforeMethod() {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        logon = new Logon(sh, sessionInfo);
        logon.load();
        logon.isLoaded();
        String user = "Su", password = "";
        logon.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for NC WindOnly")
    public void CreatePersonalAccountforNCHOW(ITestContext itc) {
        String firstname = "NCHOW";
        String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "128 Waxwing Ln";
        String city = "Duck";
        String state = "North Carolina";
        String zip = "27949";
        String addrestype = "Home";
        String orgname = "SFI";
        String producercode = "523-23-30007 C.T. Lowndes & Co. - Charleston";
        NCHOWNavigationBar nb = new NCHOWNavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

        NCHOWEnterAccountInformation eai = new NCHOWEnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountNCHOW();

        NCHOWCreateAccount ca = new NCHOWCreateAccount(sh);
        ca.setDateOfBirth(date);
        ca.setHomePhone(homephone);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress();
        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
        ca.setAddressType(addrestype);
        ca.organizationSearch();
        NCHOWOrganizations org = new NCHOWOrganizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
        ca.setProducerCode(producercode);
//after filling the form clicking on the update button in create account page
        ca.update();

    }

    @Test(description = "Validating the WindOnly")
    public void ValidatingNCHOW() {


        String firstname = "NCHOW";
        String lastname = "Validationrule";
        String policyType = "Wind Only";
//        String futureEffectiveDate = new DateTime().plusDays(120).toString("MM/dd/yyyy");
//        // String effectiveDate = new DateTime().toString("MM/dd/yyyy");
//        String futureYear = new DateTime().plusYears(5).toString("yyyy");
//        String yearBuilt = new DateTime().minusYears(17).toString("yyyy");
        String roofshapetype = "Gable";
        String windhail = "1000";
        String dwellinglimit = "140,000",
                dwellinglimit1 = "160,000";
        String territorycode = "170",
                territorycode2 = "110";

        String personalpropertylimit = "5000",
                personalpropertylimit1 = "135000",
                personalpropertylimit2 = "80000";
        String namedstorm, expectednamedstorm = "2%";
        String yearbuilt, expectedyearbuilt = "Please enter a valid 4 digit year: Year Built.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
        String otherstructureserror, expectedotherstructureserror = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";
        String structurecoverage, expectedstructurecoverage = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String territorycodeerror, expectedterritorycodeerrror = "This risk is not located within the approved binding territory for your agency. Please contact your Sales Representative should you have any questions.: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String Aplusreport, expectedAplusreport = "A+ plus report must be ordered before binding: Unassigned, 11/20/2021, 11/20/2022, 0033210282.";
        String quotedwellingcon, expectedquotedwellingcon = "The following Dwelling Construction fields are required prior to bind: [Square Footage, Roof Type].";
        String quotedwellling, expectedquotedwellling = "The following Dwelling fields are required prior to bind: [Distance to Coast (ft)].";
        String quoteresidenceheld, expectedquoteresidenceheld = "In order to select the coverage Residence Held in Trust a trust must be added to the additional interest page: Residence Held in Trust.";
        String errormessage, errormessage1, errormessage2, errormessage3;

        NCHOWNavigationBar nav = new NCHOWNavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();

        NCHOWTestingSystemClock tsc = new NCHOWTestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        System.out.println(tsc.getCurrentDate());

        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String effectiveDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        //String effectiveDate  = (String)currentdate.subSequence(0,10);
        String futureYear = dateTime.plusYears(1).format(DateTimeFormatter.ofPattern("yyyy"));//gets the plus one year of the time travel date
        String yearBuilt = dateTime.minusYears(21).format(DateTimeFormatter.ofPattern("yyyy"));
        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();


//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
//        LocalDate date = LocalDate.parse(currentDate, formatter);
//        System.out.println(date);

//        DateTimeFormatter dateString = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        LocalDateTime dateTime = LocalDateTime.parse(currentDate, dateString);
//        String myString = dateTime.toString();
//        System.out.println(myString);

        //DateTime date = DateTime.parse(currentDate, DateTimeFormat.forPattern("MM/dd/yyyy"));
//        String effectiveDate = date.toString();
//        date.plusYears(10).toString();
//        String futureYear = date.plusYears(1).toString("yyyy");
//        String yearBuilt = date.minusYears(17).toString("yyyy");


        NCHOWSearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        NCHOWAccountFileSummary afs = new NCHOWAccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        NCHOWNewSubmission ns = new NCHOWNewSubmission(sh);
        NCHOWQualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }


        NCHOWPolicyInfo pi = qua.next();

        NCHOWDwelling dwe = pi.setEffectiveDate(effectiveDate)
                .next()
                .setYearBuilt(futureYear)
                .Enter();
//        NCHOWDwelling dwe = qua.next()
//                //  .setEffectiveDate(futureEffectiveDate)
//                .setEffectiveDate(effectiveDate)
//                .next();

        //setting the year built date
//        pi.setYearBuilt(futureYear)
//                .Enter();

        //verify the error message

        yearbuilt = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedyearbuilt.equals(yearbuilt));
        System.out.println(" Expected Roof Year should be " + expectedyearbuilt + " and it is " + yearbuilt);

        NCHOWCoverages coverages = dwe.setYearBuilt(yearBuilt)
                .next()
                .clickWindMitigation()
                .setRoofShapeType(roofshapetype)
                .next();

        coverages.setDwellingLimit(dwellinglimit)
                .setWindHail(windhail);

        //vselect and verify 2% from named strom from dropdowns
        namedstorm = coverages.getNamedStorm();
        Assert.assertTrue(expectednamedstorm.equals(namedstorm));
        System.out.println(" The expected Named strom is " + expectednamedstorm + " and it is " + namedstorm);


        coverages.coveragesEnter();
        //verifes
        dwellinglimiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expecteddwellinglimiterror.equals(dwellinglimiterror));
        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);

        coverages.setDwellingLimit(dwellinglimit1)
                .next()
                .back();

        coverages.setPersonalPropertyLimit(personalpropertylimit)
                .coveragesEnter();

        //personal property is below
        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);

        coverages.setPersonalPropertyLimit(personalpropertylimit1)
                .coveragesEnter();


        //personal property above
        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimitaboveerror.equals(personalpropertylimitaboveerror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);

        coverages.setPersonalPropertyLimit(personalpropertylimit2)
                .next()
                .back();

        coverages.clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresDescription(1, "Example")
                .setSpecificOtherStructuresLimit(1, "150,000")
                .coveragesPropertyEnter();

        //verifies
        otherstructureserror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedotherstructureserror.equals(otherstructureserror));
        System.out.println("The expected Message is " + expectedotherstructureserror + " and it is " + otherstructureserror);

        NCHOWRiskAnalysis ra = coverages.clickCoverages()
                .clickPropertyEndorsements()
                .setSpecificOtherStructuresLimit(1, "5000")
                .next()
                .back().back().back();

        //sets the territory code
        dwe.setTerritoryCode(territorycode)
                .Enter();

        //verify messages comes in
        territorycodeerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedterritorycodeerrror.equals(territorycodeerror));
        System.out.println("Then expected message is " + expectedterritorycodeerrror + " and it is " + territorycodeerror);

        dwe.setTerritoryCode(territorycode2)
                .next()
                .next();

        coverages.clickPropertyEndorsements()
                .checkResidenceHeldInTrust()
                .next();
        //  .clickCoveragespropertyendorsementsQuote();


        NCHOWQuote quote = ra.quote()
                .clickissuePolicy()
                .acceptyes();

        //verifies the error messages
//        Aplusreport = quote.quoteErrorMessage();
//        Assert.assertTrue(expectedAplusreport.equals(Aplusreport));
//        System.out.println("Then expected message is " + expectedAplusreport + " and it is " + Aplusreport);

//        quotedwellingcon = quote.quoteErrorMessage();
//        Assert.assertTrue(expectedquotedwellingcon.equals(quotedwellingcon));
//        System.out.println("Then expected message is " + expectedquotedwellingcon + " and it is " + quotedwellingcon);
//
//        quotedwellling = quote.quoteErrorMessage();
//        Assert.assertTrue(expectedquotedwellling.equals(quotedwellling));
//        System.out.println("Then expected message is " + expectedquotedwellling + " and it is " + quotedwellling);
//
//        quoteresidenceheld = quote.quoteErrorMessage();
//        Assert.assertTrue(expectedquoteresidenceheld.equals(quoteresidenceheld));
//        System.out.println("Then expected message is " + expectedquoteresidenceheld + " and it is " + quoteresidenceheld);

        errormessage = quote.quoteErrorMessage();
        System.out.println(errormessage);

        errormessage = quote.quoteErrorMessage2();
        System.out.println(errormessage);

        errormessage = quote.quoteErrorMessage3();
        System.out.println(errormessage);

        errormessage = quote.quoteErrorMessage4();
        System.out.println(errormessage);

        //edit the policy transaction

        quote.clickEditPolicyTransaction()
                .acceptyes();

        //goes to the coverages page

        pi.next()
                .next()
                .next()
                .clickPropertyEndorsements()
                .checkResidenceHeldInTrust()
                .next();

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult, ITestContext itc) {
        WebDriver driver = LocalDriverManager.getDriver();
        if (testResult.getStatus() != ITestResult.SUCCESS) {
            takeScreenShot(driver);
            System.out.println(String.format("\n'%s' Failed.\n", testResult.getMethod().getMethodName()));
        }
        if (driver != null)
            driver.quit();
    }
}

