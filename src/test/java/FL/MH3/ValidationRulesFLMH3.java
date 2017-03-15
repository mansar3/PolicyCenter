package FL.MH3;

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
import pageobjects.FLMH3.*;
import pageobjects.Logon;

/**
 * Created by ssai on 3/3/2017.
 */
public class ValidationRulesFLMH3 extends BaseTest {
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

    @Test(description = "Creates Account for FLMH3")
    public void CreatePersonalAccountforFLMH3(ITestContext itc) {
        String firstname = "FLMH3";
        String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "3546 Egret Dr";
        String city = "Melbourne";
        String state = "Florida";
        String zip = "32901";
        String addrestype = "Home";
        String orgname = "4";
        FLMH3NavigationBar nb = new FLMH3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

        FLMH3EnterAccountInformation eai = new FLMH3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountFLMH3();

        FLMH3CreateAccount ca = new FLMH3CreateAccount(sh);
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
        FLMH3Organizations org = new FLMH3Organizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
//after filling the form clicking on the update button in create account page
        ca.update();

    }


    @Test(description = "Validating the MH3")
    public void ValidatingFLMH3() {

        String firstname = "FLMH3";
        String lastname = "Validationrule";
        String policyType = "Mobile Home (MH3)";
        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
        String futureYear = new DateTime().plusYears(1).toString("yyyy");
        String yearBuilt = new DateTime().minusYears(16).toString("yyyy");
        String yearBuilt1 = new DateTime().minusYears(17).toString("yyyy");

        String county = "Brevard";
        String mobilehomepark = "1 - Aberdeen at Ormond Beach";
        String distanceToFireHydrant = "200";
        String mobileHomeWidth= "7",
                mobileHomeWidth1 = "10";
        String isthehomefullyskirted = "true";
        String pool = "false",
                poolTrue = "true";
        String poolLocation = "Above-Ground",
                poolFensed = "false",
                poolFenseTrue = "true",
                fenceType = "Approved Fence",
                divingBoard = "false",
                divingBoardTrue = "true",
                poolSlide = "false",
                poolslideTrue = "true",
                houseKeepingCondBelow = "Below Average",
                houseKeepingCondGood = "Good";
        String primaryHeatingfire = "Fireplace",
                primaryHeatingspace = "Space Heater",
                primaryHeatingwood = "Wood Stove",
                primaryHeatingwoodf = "Wood Furnace",
                primaryHeatingelectric = "Electric";
        String dwellinglimit = "300,000",
                dwellinglimit1 = "19,000",
                dwellinglimit2 = "50,000";
        String personalpropertylimit = "150,000",
                personalpropertylimit1 = "10,000",
                personalpropertylimit2 = "52,000",
                personalpropertylimit3 = "48,000";

        String yearerrormessage, expectedyearerrormessage = "Please enter a valid 4 digit year: Year Built.";
        String mobilehomewidth, expectedmobilehomewidth = "Mobile home cannot be less than 8 feet wide: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String poolerror1, expectedpoolerror1 = "Pools without approved security do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String divingerror, expecteddivingerror = "Diving Boards do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String slideerror, expectedslideerror = "Slides do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String housekeepingerror, expectedhousekeepingwrror = "Below average housekeeping is ineligible for coverage: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String primaryheating, expectedpprimaryheating = "Fireplaces, Space Heaters, Wood Stoves, and Wood Furnaces do not meet eligibility guidelines.: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";
        String combinedlimit, expectedcombinedlimit = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";

        FLMH3NavigationBar nav = new FLMH3NavigationBar(sh);
        FLMH3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        FLMH3AccountFileSummary afs = new FLMH3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        FLMH3NewSubmission ns = new FLMH3NewSubmission(sh);
        FLMH3Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        FLMH3Dwelling dwe = qua.next()
                .setEffectiveDate(effectiveDate)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setMobileHomePark(mobilehomepark)
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(futureYear)
                .Enter();

        yearerrormessage = dwe.getdwellingErrorMessage();

        if (expectedyearerrormessage.equals(yearerrormessage)) {
            System.out.println(" Expected Roof Year should be " + expectedyearerrormessage + " and it is " + yearerrormessage);
            dwe.setYearBuilt(yearBuilt1);


        } else {

            System.out.println("verification failed ");
        }

        //goes to the dwelling construction

   FLMH3DwellingConstruction dwellingConstruction = dwe.next()
                .setIsTheMobileHomeFullySkirted(isthehomefullyskirted)
                .setMobileHomeWidth(mobileHomeWidth)
                .dwellingConstructionEnter();

        //verify the message for mobile home width
        mobilehomewidth = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedmobilehomewidth.equals(mobilehomewidth));
        System.out.println(" Expected Roof Year should be " + expectedmobilehomewidth + " and it is " + mobilehomewidth);

        //sets the mobile home to 10
        //takes to coverages page and sets the dwelling and personal property limit value and comes back to dwelling.

        dwellingConstruction.setMobileHomeWidth(mobileHomeWidth1)
                .next()
                .setDwellingLimit(dwellinglimit)
                .setPersonalPropertyLimit(personalpropertylimit)
                .back();

           dwellingConstruction.back();



        //changing the pool settings

        dwe.setSwimmingPool(poolTrue)
                .setPoolLocation(poolLocation)
                .setPoolFenced(poolFensed)
                .setDivingBoard(divingBoard)
                .setPoolSlide(poolSlide)
                .Enter();
        poolerror1 = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedpoolerror1.equals(poolerror1));
        System.out.println(" Expected error message is " + expectedpoolerror1 + " but it was " + poolerror1);

        //changing the pool options again

        dwe.setPoolFenced(poolFenseTrue)
                .setFenceType(fenceType)
                .setDivingBoard(divingBoardTrue)
                .Enter();

        divingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expecteddivingerror.equals(divingerror));
        System.out.println(" Expected error message is " + expecteddivingerror + " but it was " + divingerror);

        //changing the slides in dwelling page
        dwe.setDivingBoard(divingBoard)
                .setPoolSlide(poolslideTrue)
                .Enter();

        slideerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedslideerror.equals(slideerror));
        System.out.println(" Expected error message is " + expectedslideerror + " but it was " + slideerror);

        //changing the HOUSEKEEPING CONDITION

        dwe.setPoolSlide(poolSlide)
                .setHousekeepingCondition(houseKeepingCondBelow)
                .Enter();

        housekeepingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedhousekeepingwrror.equals(housekeepingerror));
        System.out.println(" Expected error message is " + expectedhousekeepingwrror + " but it was " + housekeepingerror);

        dwe.setSwimmingPool(pool)
                .setHousekeepingCondition(houseKeepingCondGood)
                .next();


        //changing the values of primary heating

        dwellingConstruction.setPrimaryHeating(primaryHeatingfire)
                .dwellingConstructionEnter();
        sh.waitForNoMask();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        System.out.println(primaryheating);
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);


        //changing to space heater
        dwellingConstruction.setPrimaryHeating(primaryHeatingspace)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is  " + expectedpprimaryheating + " but it was " + primaryheating);

        //changing to woodstove
        dwellingConstruction.setPrimaryHeating(primaryHeatingwood)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);


        //changing to wood furnace
        dwellingConstruction.setPrimaryHeating(primaryHeatingwoodf)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);

        //changing to electric
       FLMH3Coverages coverages =  dwellingConstruction.setPrimaryHeating(primaryHeatingelectric)
                .next()
                .setDwellingLimit(dwellinglimit1)
                .coveragesEnter();

        //verifies dwelling coverage limit is below
        dwellinglimiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expecteddwellinglimiterror.equals(dwellinglimiterror));
        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);



        coverages.setDwellingLimit(dwellinglimit2)
                .setPersonalPropertyLimit(personalpropertylimit1)
                .coveragesEnter();

        //verifies the personal property limit below

        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);

        coverages.setPersonalPropertyLimit(personalpropertylimit2)
                .coveragesEnter();

        //verifies the personal property limit is above

        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimitaboveerror.equals(personalpropertylimitaboveerror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);

        coverages.setPersonalPropertyLimit(personalpropertylimit3)
                .next()
                .back();

        //clicks on the property endorsements
        coverages.clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresAttachedDetached(1, "Attached")
                .setSpecificOtherStructuresDescription(1, "Test")
                .setSpecificOtherStructuresLimit(1, "80,000")
                .coveragespropertyendorsementsEnter();

        combinedlimit = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedcombinedlimit.equals(combinedlimit));
        System.out.println("  Expected error message is " + expectedcombinedlimit + " and it is " + combinedlimit);


        FLMH3RiskAnalysis riskanalysis = coverages.clickCoverages()
                .clickPropertyEndorsements()
                .setSpecificOtherStructuresLimit(1,"8,000")
                .next();

        //goes to underwriting questions
        riskanalysis.clickUnderWritingQuestions();

        //sets everything to no
        for (int i = 0; i < 14; i++) {
            riskanalysis.answerNo(i + 1);
        }

        for (int j = 9; j <= 9; j++) {
            riskanalysis.answerYes(j);
        }
        riskanalysis.back();

        convitederror = riskanalysis.getErrorMessage();
        Assert.assertTrue(expectedconvitederror.equals(convitederror));
        System.out.println("  Expected error message is " + expectedconvitederror + " and it is " + convitederror);

        for (int z = 9; z <= 9; z++) {
            riskanalysis.answerNo(z);
        }
        riskanalysis.back();

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
