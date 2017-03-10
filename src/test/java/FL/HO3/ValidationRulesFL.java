package FL.HO3;

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
import pageobjects.FLHO3.*;
import pageobjects.Logon;

/**
 * Created by ssai on 2/27/2017.
 */
public class ValidationRulesFL extends BaseTest {

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

    @Test(description = "Creates Account for FLHO3")
    public void CreatePersonalAccountforFLHO3(ITestContext itc) {
        String firstname = "FLHO3";
        String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "3546 Egret Dr";
        String city = "Melbourne";
        String state = "Florida";
        String zip = "32901";
        String addrestype = "Home";
        String orgname = "4";
        FLHO3NavigationBar nb = new FLHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

        FLHO3EnterAccountInformation eai = new FLHO3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountFLHO3();

        FLHO3CreateAccount ca = new FLHO3CreateAccount(sh);
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
        FLHO3Organizations org = new FLHO3Organizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
//after filling the form clicking on the update button in create account page
        ca.update();

    }

    @Test(description = "Validating the Ho3")
    public void ValidatingHO3FL() {

        String firstname = "FLHO3";
        String lastname = "Validationrule";
        String policyType = "Homeowners (HO3)";
        String futureEffectiveDate = new DateTime().plusDays(56).toString("MM/dd/yyyy");
        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
        String futureYear = new DateTime().plusYears(1).toString("yyyy");
        String currentYear = new DateTime().toString("yyyy");
        String plumbingYear = new DateTime().minusYears(18).toString("yyyy");
        String waterHeaterYear = new DateTime().minusYears(18).toString("yyyy");
        String roofYear = new DateTime().minusYears(18).toString("yyyy");
        String yearBuiltde, yearBuilt = "2001";
        String distanceToFireHydrant = "200";
        String protectionclasscode = "10",
                protectionclasscode1 = "10W",
                protectionclasscode2 = "6";

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
        String burglarbaronwindowstrue = "true",
                burglarbaronwindowno = "false";
        String safetylatches = "false";
        String primaryHeatingfire = "Fireplace",
                primaryHeatingspace = "Space Heater",
                primaryHeatingwood = "Wood Stove",
                primaryHeatingwoodf = "Wood Furnace",
                primaryHeatingelectric = "Electric";
        String dwellinglimit = "250,000";
        String roofshapetype = "Gable",
                openingprotectiontype = "Hurricane";
        String electricalsystemFuses = "Fuses",
                electricalsystemcircuitbreaker = "Circuit Breaker";
        String conditionofroof = "Below Average",
                conditionofroof1 = "Good";
        String dwellinglimit1 = "140,000",
                dwellinglimit2 = "150,000",
                dwellinglimit3 = "160,000";
        String personalpropertylimit = "24000",
                personalpropertylimit1 = "33,000",
                personalpropertylimit2 = "128,000",
                personalpropertylimit3 = "112,000";
        String otherstructurepercentage = "10%";
        String Permittedlimit = "10,000";

        String yearerrormessage, expectedyearerrormessage = "Please enter a valid 4 digit year: Year Built.";
        String protectionclasserror, expectedprotectionclasserror = "Property with a protection class of 10 or 10W are ineligible for coverage: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String poolerror1, expectedpoolerror1 = "Pools without approved security do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String divingerror, expecteddivingerror = "Diving Boards do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String slideerror, expectedslideerror = "Slides do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String housekeepingerror, expectedhousekeepingwrror = "Below average housekeeping is ineligible for coverage: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String burgularbars, expectedburgularbars = "Burglar bars without safety release latches are ineligible for coverage: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String primaryheating, expectedpprimaryheating = "Fireplaces, Space Heaters, Wood Stoves, and Wood Furnaces do not meet eligibility guidelines.: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String electricsystemfuse, expectedelectricsystemfuse = "Fuse panels do not meet eligibility guidelines: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String conditionrooferror, expectedconditionroof = "Below Average roofs do not meet eligibility guidelines.: Dwelling at 3546 EGRET DR, MELBOURNE, FL.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
        String combinedlimit, expectedcombinedlimit = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";


        FLHO3NavigationBar nav = new FLHO3NavigationBar(sh);
        FLHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        FLHO3AccountFileSummary afs = new FLHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        FLHO3NewSubmission ns = new FLHO3NewSubmission(sh);
        FLHO3Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        FLHO3Dwelling dwe = qua.next()
                //.setEffectiveDate(futureEffectiveDate)
                .setEffectiveDate(effectiveDate)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant);

        yearBuiltde = dwe.getYearBuilt();
        Assert.assertTrue(yearBuilt.equals(yearBuiltde));
        System.out.println(" Expected Roof Year should be " + yearBuilt + " and it is " + yearBuiltde);

        dwe.setYearBuilt(futureYear)
                .Enter();
        yearerrormessage = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedyearerrormessage.equals(yearerrormessage));
        System.out.println(" Expected error message " + expectedyearerrormessage + " but it was " + yearerrormessage);

        dwe.setYearBuilt(currentYear)
                .next()
                .clickWindMitigation()
                .setRoofShapeType(roofshapetype)
                .setOpeningProtectionType(openingprotectiontype)
                .winddwellingback();

        //setting the protection code to 10 and 10W
        dwe.setProtectionClassCode(protectionclasscode)
                .Enter();

        protectionclasserror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedprotectionclasserror.equals(protectionclasserror));
        System.out.println(" Expected error messsage  " + expectedprotectionclasserror + " but it was " + protectionclasserror);

        dwe.setProtectionClassCode(protectionclasscode1)
                .Enter();
        protectionclasserror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedprotectionclasserror.equals(protectionclasserror));
        System.out.println(" Expected error message is " + expectedprotectionclasserror + " but it was " + protectionclasserror);

        //setting the protectionclasscode
        dwe.setProtectionClassCode(protectionclasscode2)
                .next()
                .back();
//                .dwellingConstructionEnter();
//
//        dwe.clickDwellingBack();
//

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
                .next()
                .back();

        //changing to yes and no to safety latches and burgular bars
        dwe.clickProtectionDetails()
                .setBurglarBarsOnWindows(burglarbaronwindowstrue)
                .safetyLatchesPresent(safetylatches)
                .clickProtectionDetailsenter();

        burgularbars = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedburgularbars.equals(burgularbars));
        System.out.println(" Expected error message is " + expectedburgularbars + " but it was " + burgularbars);

        FLHO3DwellingConstruction dwellingConstruction = dwe.clickProtectionDetails()
                .setBurglarBarsOnWindows(burglarbaronwindowno)
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
        dwellingConstruction.setPrimaryHeating(primaryHeatingelectric)
                .next()
                .setDwellingLimit(dwellinglimit)
                .back();

        //setting the plumbing year to one future year
        dwellingConstruction.setPlumbingYear(futureYear)
                .next()
                .back();

        dwellingConstruction.setPlumbingYear(plumbingYear)
                .setWaterHeaterYear(futureYear)
                .next()
                .back();

        dwellingConstruction.setWaterHeaterYear(waterHeaterYear)
                .next()
                .back();

        //now changes in Electrical System in dwelling construction
        dwellingConstruction.setElectricalSystem(electricalsystemFuses)
                .dwellingConstructionEnter();

        electricsystemfuse = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedelectricsystemfuse.equals(electricsystemfuse));
        System.out.println(" Expected Error message is " + expectedelectricsystemfuse + "and it is " + electricsystemfuse);

        dwellingConstruction.setElectricalSystem(electricalsystemcircuitbreaker)
                .next()
                .back();

        //setting the roof year to one future year

        dwellingConstruction.setRoofYear(futureYear)
                .next()
                .back();

        //setting the roof year to 1999


        dwellingConstruction.setRoofYear(roofYear)
                .next()
                .back();

        //entering the condition of the roof

        dwellingConstruction.setConditionOfRoof(conditionofroof)
                .dwellingConstructionEnter();

        conditionrooferror = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedconditionroof.equals(conditionrooferror));
        System.out.println(" Expected error message is " + expectedconditionroof + "and it is " + conditionrooferror);

        FLHO3Coverages coverages = dwellingConstruction
                .setConditionOfRoof(conditionofroof1)
                .next();

        //now goes to the Coverages
        coverages
                .setDwellingLimit(dwellinglimit1)
                .coveragesEnter();
        dwellinglimiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expecteddwellinglimiterror.equals(dwellinglimiterror));
        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);

        //changing the dwelling limit
        coverages.setDwellingLimit(dwellinglimit2)
                .next()
                .back();

        //setting the personal property limit
        coverages.setDwellingLimit(dwellinglimit3)
                .setPersonalPropertyLimit(personalpropertylimit)
                .coveragesEnter();

        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);


        coverages.setPersonalPropertyLimit(personalpropertylimit1)
                .setDwellingLimit(dwellinglimit3)
                .setPersonalPropertyLimit(personalpropertylimit2)
                .coveragesEnter();

        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimitaboveerror.equals(personalpropertylimitaboveerror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);


        coverages.setPersonalPropertyLimit(personalpropertylimit3)
                .setDwellingLimit(dwellinglimit3)
                .setOtherStructuresPercentage(otherstructurepercentage)
                .clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresDescription(1, "Example")
                .setSpecificOtherStructuresLimit(1, "113,000")
                .checkOtherStructuresIncreasedCoverageRentedToOthers()
                .addOtherStructures()
                .setOtherStructuresDescription(1, "Example")
                .setOtherStructuresLimit(1, "10,000")
                .clickLiabilityEndorsements()
                .checkPermittedIncidentalOccupancyLiability()
                .clickPropertyEndorsements()
                .checkPermittedIncidentalOccupancy();
//setting the premittedlimit t0 10,000
        //driver.findElement(By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HOCoveragesHOEScreen:HOClauses_fliPanelSet:dwellingOptionalPropertyCovsPanel:ClausesInCategories_fliPanelSet:coveragesDV:0:Coverage_fliInputSet:CovPatternInputGroup:CovTermIterator:0:CovTermInputSet:DirectTermInput-inputEl")).sendKeys("10,000");
        coverages.setPermittedIncidentalOccupalimit(Permittedlimit)
                .coveragesEnter();
        combinedlimit = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedcombinedlimit.equals(combinedlimit));
        System.out.println("  Expected error message is " + expectedcombinedlimit + " and it is " + combinedlimit);

        //going back to the liablity and unchecking
        FLHO3RiskAnalysis riskanalysis = coverages.clickLiabilityEndorsements()
                .unCheckPermittedIncidentalOccupancyLiability()
                .clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .checkOtherStructuresIncreasedCoverageRentedToOthers()
                .next();

        //lands on  rick analysis page.

        riskanalysis.clickUnderWritingQuestions();
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
