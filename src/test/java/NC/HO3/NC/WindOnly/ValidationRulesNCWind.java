//package NC.HO3.NC.WindOnly;
//
//import Helpers.CenterSeleniumHelper;
//import base.BaseTest;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.Login;
//import pageobjects.NCHO3.NCHO3DwellingConstruction;
//import pageobjects.NCWindOnly.*;
//
///**
// * Created by ssai on 3/4/2017.
// */
//public class ValidationRulesNCWind extends BaseTest {
//    private String dateString;
//    private WebDriver driver;
//    private Login login;
//    private CenterSeleniumHelper sh;
//
//
//    @BeforeMethod
//    public void beforeMethod() {
//        DateTime date = new DateTime();
//        dateString = date.toString("MMddhhmmss");
//        System.out.println(new DateTime().toString());
//
//        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
//        sh = new CenterSeleniumHelper(driver);
//        login = new Login(sh, sessionInfo);
//        login.load();
//        login.isLoaded();
//        String user = "Su", password = "";
//        login.login(user, password);
//        log(String.format("Logged in as: %s\nPassword: %s", user, password));
//    }
//
//    @Test(description = "Creates Account for NC WindOnly")
//    public void CreatePersonalAccountforNCWindOnly(ITestContext itc) {
//        String firstname = "NCWindOnly";
//        String lastname = "Validationrule";
//        String date = "03/30/1985";
//        String homephone = "8501112222";
//        String homeaddress = "128 Waxwing Ln";
//        String city = "Duck";
//        String state = "North Carolina";
//        String zip = "27949";
//        String addrestype = "Home";
//        String orgname = "SFI";
//        String producercode = "523-23-30007 C.T. Lowndes & Co. - Charleston";
//        NCWindOnlyNavigationBar nb = new NCWindOnlyNavigationBar(sh);
//        nb.clickAccountTab();
//        nb.clickNewAccountDropdown();
//
//        NCWindOnlyEnterAccountInformation eai = new NCWindOnlyEnterAccountInformation(sh);
//        eai.setFirstName(firstname);
//        eai.setLastName(lastname);
//        eai.clickSearch();
//        eai.createNewPersonAccountNCWindOnly();
//
//        NCWindOnlyCreateAccount ca = new NCWindOnlyCreateAccount(sh);
//        ca.setDateOfBirth(date);
//        ca.setHomePhone(homephone);
//        ca.setAddressLine1(homeaddress);
//        ca.setCity(city);
//        ca.setState(state);
//        ca.setZipCode(zip);
//        ca.clickVerifyAddress();
//        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
//        ca.setAddressType(addrestype);
//        ca.organizationSearch();
//        NCWindOnlyOrganizations org = new NCWindOnlyOrganizations(sh);
//
//        org.setOrganizationName(orgname);
//        org.clickSearchButton();
//        org.selectOrganizationButton();
//        ca.setProducerCode(producercode);
////after filling the form clicking on the update button in create account page
//        ca.update();
//
//    }
//
//    @Test(description = "Validating the WindOnly")
//    public void ValidatingNCWindOnly() {
//
//        String firstname = "NCWindOnly";
//        String lastname = "Validationrule";
//        String policyType = "Wind Only";
//        String futureEffectiveDate = new DateTime().plusDays(120).toString("MM/dd/yyyy");
//        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
//        String futureYear = new DateTime().plusYears(1).toString("yyyy");
//        String yearBuilt = new DateTime().minusYears(17).toString("yyyy");
//        String roofshapetype = "Gable";
//        String  windhail = "1000";
//        String dwellinglimit = "140,000",
//                dwellinglimit1 = "160,000";
//        String territorycode = "170",
//                territorycode2 = "110";
//
//        String personalpropertylimit = "5000",
//                personalpropertylimit1 = "135000",
//                personalpropertylimit2 = "80000";
//        String namedstorm, expectednamedstorm = "2%";
//        String yearbuilt, expectedyearbuilt = "Please enter a valid 4 digit year: Year Built.";
//        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
//        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
//        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
//        String otherstructureserror, expectedotherstructureserror = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
//        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";
//        String structurecoverage, expectedstructurecoverage = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
//        String territorycodeerror, expectedterritorycodeerrror = "This risk is not located within the approved binding territory for your agency. Please contact your Sales Representative should you have any questions.: Dwelling at 128 WAXWING LN, DUCK, NC.";
//
//        NCWindOnlyNavigationBar nav = new NCWindOnlyNavigationBar(sh);
//        NCWindOnlySearchAccounts sa = nav.clickSearchAccount();
//        sa.setFirstName(firstname);
//        sa.setLastName(lastname);
//        sa.clickSearchButton();
//        sa.clickAccountNumberSearchAccount();
//
//        NCWindOnlyAccountFileSummary afs = new NCWindOnlyAccountFileSummary(sh);
//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();
//
//        NCWindOnlyNewSubmission ns = new NCWindOnlyNewSubmission(sh);
//        NCWindOnlyQualification qua = ns.productTable.selectHomeowners();
//        qua.setPolicyType(policyType);
//        qua.getOfferingSelection();
//        // to select no for all the blanks
//        for (int i = 0; i < 8; i++) {
//            qua.questionnaire.answerNo(i + 1);
//        }
//
//
//        NCWindOnlyDwelling dwe = qua.next()
//                //  .setEffectiveDate(futureEffectiveDate)
//                .setEffectiveDate(effectiveDate)
//                .next();
//
//        //setting the year built date
//        dwe.setYearBuilt(futureYear)
//                .Enter();
//
//        //verify the error message
//
//        yearbuilt = dwe.getdwellingErrorMessage();
//        Assert.assertTrue(expectedyearbuilt.equals(yearbuilt));
//        System.out.println(" Expected Roof Year should be " + expectedyearbuilt + " and it is " + yearbuilt);
//
//        NCWindOnlyCoverages coverages =    dwe.setYearBuilt(yearBuilt)
//                .next()
//                .clickWindMitigation()
//                .setRoofShapeType(roofshapetype)
//                .next();
//
//        coverages.setDwellingLimit(dwellinglimit)
//                .setWindHail(windhail);
//
//        //vselect and verify 2% from named strom from dropdowns
//        namedstorm = coverages.getNamedStorm();
//        Assert.assertTrue(expectednamedstorm.equals(namedstorm));
//        System.out.println(" The expected Named strom is " + expectednamedstorm + " and it is " + namedstorm );
//
//
//        coverages.coveragesEnter();
//        //verifes
//        dwellinglimiterror = coverages.coveragesErrorMessage();
//        Assert.assertTrue(expecteddwellinglimiterror.equals(dwellinglimiterror));
//        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);
//
//        coverages.setDwellingLimit(dwellinglimit1)
//                .next()
//                .back();
//
//        coverages.setPersonalPropertyLimit(personalpropertylimit)
//                .coveragesEnter();
//
//        //personal property is below
//        personalpropertylimmiterror = coverages.coveragesErrorMessage();
//        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
//        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);
//
//        coverages.setPersonalPropertyLimit(personalpropertylimit1)
//                .coveragesEnter();
//
//
//        //personal property above
//        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
//        Assert.assertTrue(expectedpersonalpropertylimitaboveerror.equals(personalpropertylimitaboveerror));
//        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);
//
//        coverages.setPersonalPropertyLimit(personalpropertylimit2 )
//                .next()
//                .back();
//
//        coverages.clickPropertyEndorsements()
//                .checkSpecificOtherStructures()
//                .addSpecificOtherStructures()
//                .setSpecificOtherStructuresDescription(1, "Example")
//                .setSpecificOtherStructuresLimit(1, "150,000")
//                .coveragesPropertyEnter();
//
//        //verifies
//        otherstructureserror = coverages.coveragesErrorMessage();
//        Assert.assertTrue(expectedotherstructureserror.equals(otherstructureserror));
//        System.out.println("The expected Message is " + expectedotherstructureserror + " and it is " + otherstructureserror );
//
//        coverages.clickCoverages()
//                .clickPropertyEndorsements()
//                .setSpecificOtherStructuresLimit(1, "5000")
//                .next()
//                .back().back().back();
//
//        //sets the territory code
//        dwe.setTerritoryCode(territorycode)
//                .Enter();
//
//        //verify messages comes in
//        territorycodeerror = dwe.getdwellingErrorMessage();
//        Assert.assertTrue(expectedterritorycodeerrror.equals(territorycodeerror));
//        System.out.println("Theh expected message is " + expectedterritorycodeerrror + " and it is " + territorycodeerror);
//
//        dwe.setTerritoryCode(territorycode2)
//                .next()
//                .next()
//                .clickPropertyEndorsements()
//                .checkResidenceHeldinTrust();
//
//    }
//    }
