package NC.HO3;

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
import pageobjects.NCHO3.*;

import java.util.Random;

/**
 * Created by ssai on 2/28/2017.
 */
public class ValidationRulesNC extends BaseTest {

    private String dateString;
    private WebDriver driver;
    private Logon logon;
    private CenterSeleniumHelper sh;
    String firstname = "NCHO3";
    Random rand = new Random();
    int num  = rand.nextInt(99 - 10 + 1)+10;
    String lastname = "ValidationRuleTest"+num;

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

    @Test(description = "Creates Account for NCHO3")
    public void CreatePersonalAccountforNCHO3(ITestContext itc) {
    //    String firstname = "NCHO3";
    //    String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "128 Waxwing Ln";
        String city = "Duck";
        String state = "North Carolina";
        String zip = "27949";
        String addrestype = "Home";
        String orgname = "SFI";
        String producercode = "523-23-30007 C.T. Lowndes & Co. - Charleston";
        NCHO3NavigationBar nb = new NCHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

        NCHO3EnterAccountInformation eai = new NCHO3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountNCHO3();

        NCHO3CreateAccount ca = new NCHO3CreateAccount(sh);
        ca.setDateOfBirth(date);
        ca.setHomePhone(homephone);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress()
                .selectSuccessfulVerificationIfPossibleForCreateAccount();
        ca.setAddressType(addrestype);
        ca.organizationSearch();
        NCHO3Organizations org = new NCHO3Organizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
        ca.setProducerCode(producercode);
//after filling the form clicking on the update button in create account page
        ca.update();

    }

    @Test(description = "Validating the Ho3")
    public void ValidatingNCH03() {

       // String firstname = "NCHO3";
     //   String lastname = "Validationrule";
        String policyType = "Homeowners (HO3)";
        String futureEffectiveDate = new DateTime().plusDays(120).toString("MM/dd/yyyy");
        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
        String futureYear = new DateTime().plusYears(1).toString("yyyy");
        String currentYear = new DateTime().toString("yyyy");
        String plumbingYear = new DateTime().minusYears(18).toString("yyyy");
        String waterHeaterYear = new DateTime().minusYears(18).toString("yyyy");
        String roofYear = new DateTime().minusYears(18).toString("yyyy");
        String yearBuilt1 = new DateTime().minusYears(18).toString("yyyy");
        String yearBuilt = "2001";
        String distanceToFireHydrant = "200",
                territorycode = "110",
                protectionclass = "4";
        String county = "Dell",
                county1 = "Charleston";
        String roofshapetype = "Gable";
        String roofyear;
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
        String dwellinglimit = "250,000",
                dwellinglimit1 = "140,000",
                dwellinglimit2 = "210,000",
                dwellinglimit3 = "220000";

        String personalpropertylimit = "24000",
                personalpropertylimit1 = "120,000",
                personalpropertylimit2 = "176000",
                personalpropertylimit3 = "112000";
        String dwellingfinal,
                expecteddwellingfinal = "220,000";
        String personalpropertylimitval,
                expectedpersonalpersonallimit = "112,000";
        String otherstructurepercentage,
                expectedothersstructurepercentage = "10%";
        String electricalsystemFuses = "Fuses",
                electricalsystemcircuitbreaker = "Circuit Breaker";
        String conditionofroof = "Below Average",
                conditionofroof1 = "Good";
        String Tcode = "190",
                Tcode1 = "110";

        String specificotherstructuresdescription = ", Example";
        String effectiveyear, expectedeffectiveyear = "Policy effective date is outside of the agent’s binding authority:";
        String yearbuilt, expectedyearbuilt = "Please enter a valid 4 digit year: Year Built.";
        String Countyrisk, expectedcountyrisk = "This risk is not located within the approved binding territory for your agency. Please contact your Sales Representative should you have any questions.: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String expectederrormessagesafetylatches = " Burglar bars without safety release latches are ineligible for coverage";
        String yearerrormessage, expectedyearerrormessage = "Please enter a valid 4 digit year: Year Built.";
        String protectionclasserror, expectedprotectionclasserror = "Property with a protection class of 10 or 10W are ineligible for coverage: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String poolerror1, expectedpoolerror1 = "Pools without approved security do not meet eligibility guidelines: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String divingerror, expecteddivingerror = "Diving Boards do not meet eligibility guidelines: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String slideerror, expectedslideerror = "Slides do not meet eligibility guidelines: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String housekeepingerror, expectedhousekeepingwrror = "Below average housekeeping is ineligible for coverage: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String burgularbars, expectedburgularbars = "Burglar bars without safety release latches are ineligible for coverage: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String primaryheating, expectedpprimaryheating = "Fireplaces, Space Heaters, Wood Stoves, and Wood Furnaces do not meet eligibility guidelines.: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String electricsystemfuse, expectedelectricsystemfuse = "Fuse panels do not meet eligibility guidelines: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String conditionrooferror, expectedconditionroof = "Below Average roofs do not meet eligibility guidelines.: Dwelling at 128 WAXWING LN, DUCK, NC.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
        String otherstructureserror, expectedotherstructureserror = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";
        String structurecoverage, expectedstructurecoverage = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String territorycodeerror, expectedterritorycodeerrror = "This risk is not located within the approved binding territory for your agency. Please contact your Sales Representative should you have any questions.: Dwelling at 128 WAXWING LN, DUCK, NC.";

        NCHO3NavigationBar nav = new NCHO3NavigationBar(sh);
        NCHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        NCHO3AccountFileSummary afs = new NCHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        NCHO3NewSubmission ns = new NCHO3NewSubmission(sh);
        NCHO3Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        NCHO3PolicyInfo pi = qua.next();

        pi.setEffectiveDate(futureEffectiveDate)
                .Enter();

        //Verify the error message

        effectiveyear =  pi.getErrorMessage();

        Assert.assertTrue(effectiveyear.startsWith(expectedeffectiveyear), "The Policy effective date should is supposed to be shown but it is not");

        pi.setEffectiveDate(effectiveDate);
        NCHO3Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode(territorycode)
                .setProtectionClassCode(protectionclass)
                .next()
                .clickWindMitigation()
                .setRoofShapeType(roofshapetype)
                .winddwellingback();

        //setting the year built date
        dwe.setYearBuilt(futureYear)
                .Enter();

        //verify the error message

        yearbuilt = dwe.getdwellingErrorMessage();
        Assert.assertTrue(yearbuilt.startsWith(expectedyearbuilt));
        System.out.println(" Expected Roof Year should be " + expectedyearbuilt + " and it is " + yearbuilt);

        dwe.setYearBuilt(currentYear)
                .next()
                .back();


        //setting the protection code to 10 and 10W
        dwe.setProtectionClassCode(protectionclasscode)
                .Enter();

        protectionclasserror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(protectionclasserror.startsWith(expectedprotectionclasserror));
        System.out.println(" Expected error messsage  " + expectedprotectionclasserror + " but it was " + protectionclasserror);

        dwe.setProtectionClassCode(protectionclasscode1)
                .Enter();
        protectionclasserror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(protectionclasserror.startsWith(expectedprotectionclasserror));
        System.out.println(" Expected error messsage  " + expectedprotectionclasserror + " but it was " + protectionclasserror);

        //setting the protectionclasscode
        dwe.setProtectionClassCode(protectionclasscode2)
                .next()
                .back();

        dwe.setSwimmingPool(poolTrue)
                .setPoolLocation(poolLocation)
                .setPoolFenced(poolFensed)
                .setDivingBoard(divingBoard)
                .setPoolSlide(poolSlide)
                .Enter();
        poolerror1 = dwe.getdwellingErrorMessage();
        Assert.assertTrue(poolerror1.startsWith(expectedpoolerror1));
        System.out.println(" Expected error message is " + expectedpoolerror1 + " but it was " + poolerror1);

        //changing the pool options again

        dwe.setPoolFenced(poolFenseTrue)
                .setFenceType(fenceType)
                .setDivingBoard(divingBoardTrue)
                .Enter();

        divingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(divingerror.startsWith(expecteddivingerror));
        System.out.println(" Expected error message is " + expecteddivingerror + " but it was " + divingerror);

        //changing the slides in dwelling page
        dwe.setDivingBoard(divingBoard)
                .setPoolSlide(poolslideTrue)
                .Enter();

        slideerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(slideerror.startsWith(expectedslideerror));
        System.out.println(" Expected error message is " + expectedslideerror + " but it was " + slideerror);


        //changing the HOUSEKEEPING CONDITION

        dwe.setPoolSlide(poolSlide)
                .setHousekeepingCondition(houseKeepingCondBelow)
                .Enter();

        housekeepingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(housekeepingerror.startsWith(expectedhousekeepingwrror));
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
        Assert.assertTrue(burgularbars.startsWith(expectedburgularbars));
        System.out.println(" Expected error message is " + expectedburgularbars + " but it was " + burgularbars);


        NCHO3DwellingConstruction dwellingConstruction = dwe.clickProtectionDetails()
                .setBurglarBarsOnWindows(burglarbaronwindowno)
                .next();

        dwellingConstruction.setRoofYear(roofYear)
                .setPrimaryHeating(primaryHeatingfire)
                .dwellingConstructionEnter();
        sh.waitForNoMask();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        System.out.println(primaryheating);
        Assert.assertTrue(primaryheating.startsWith(expectedpprimaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);


        //changing to space heater
        dwellingConstruction.setPrimaryHeating(primaryHeatingspace)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(primaryheating.startsWith(expectedpprimaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);

        //changing to woodstove
        dwellingConstruction.setPrimaryHeating(primaryHeatingwood)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(primaryheating.startsWith(expectedpprimaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);


        //changing to wood furnace
        dwellingConstruction.setPrimaryHeating(primaryHeatingwoodf)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(primaryheating.startsWith(expectedpprimaryheating));
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
        System.out.println("There should be an error message here but there is no error message");

        dwellingConstruction.setPlumbingYear(currentYear)
                .setWaterHeaterYear(futureYear)
                .next()
                .back();

        dwellingConstruction.setWaterHeaterYear(currentYear)
                .next()
                .back();

        //now changes in Electrical System in dwelling construction
        dwellingConstruction.setElectricalSystem(electricalsystemFuses)
                .dwellingConstructionEnter();

        electricsystemfuse = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(electricsystemfuse.startsWith(expectedelectricsystemfuse));
        System.out.println(" Expected Error message is " + expectedelectricsystemfuse + "and it is " + electricsystemfuse);

        dwellingConstruction.setElectricalSystem(electricalsystemcircuitbreaker)
                .next()
                .back();

        //setting the roof year to one future year

        dwellingConstruction.setRoofYear(futureYear)
                .next()
                .back();

        System.out.println("There should be an error message here but there is no error message");

        dwellingConstruction.setRoofYear(currentYear)
                .next()
                .back();

        //entering the condition of the roof

        dwellingConstruction.setConditionOfRoof(conditionofroof)
                .dwellingConstructionEnter();

        conditionrooferror = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(conditionrooferror.startsWith(expectedconditionroof));
        System.out.println(" Expected error message is " + expectedconditionroof + "and it is " + conditionrooferror);

        NCHO3Coverages coverages = dwellingConstruction
                .setConditionOfRoof(conditionofroof1)
                .next();


        //goes to the coverages page
        coverages.setDwellingLimit(dwellinglimit1)
                .coveragesEnter();

        dwellinglimiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(dwellinglimiterror.startsWith(expecteddwellinglimiterror));
        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);

        coverages.setDwellingLimit(dwellinglimit2)
                .next()
                .back();

        //Comes back to the coverages page

        coverages.setDwellingLimit(dwellinglimit2)
                .setPersonalPropertyLimit(personalpropertylimit)
                .coveragesEnter();

        //personal property is below
        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(personalpropertylimmiterror.startsWith(expectedpersonalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);

        coverages.setPersonalPropertyLimit(personalpropertylimit1)
                .next()
                .back();

        coverages.setDwellingLimit(dwellinglimit3)
                .setPersonalPropertyLimit(personalpropertylimit2)
                .coveragesEnter();

        //error personal property above
        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
        Assert.assertTrue(personalpropertylimitaboveerror.startsWith(expectedpersonalpropertylimitaboveerror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);

        coverages.setPersonalPropertyLimit(personalpropertylimit3)
                .next()
                .back();

        //validating the dwelling, personal property  and structure percentage limit

        dwellingfinal = coverages.getDwellingLimit();
        Assert.assertTrue(dwellingfinal.startsWith(expecteddwellingfinal));
        System.out.println("  Expected error message is " + expecteddwellingfinal + " and it is " + dwellingfinal);

        personalpropertylimitval = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(personalpropertylimitval.startsWith(expectedpersonalpersonallimit));
        System.out.println("  Expected error message is " + expectedpersonalpersonallimit + " and it is " + personalpropertylimitval);


        otherstructurepercentage = coverages.getOtherStructurePercentageGreyedOut();
        Assert.assertTrue(otherstructurepercentage.startsWith(expectedothersstructurepercentage));
        System.out.println("  Expected error message is " + expectedothersstructurepercentage + " and it is " + otherstructurepercentage);

        coverages.next()
                .back();

        coverages.clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresDescription(1, "Example")
                .setSpecificOtherStructuresLimit(1, "66,000")
                .coveragesPropertyEnter();


        //error message of structure coverage

        structurecoverage = coverages.coveragesErrorMessage();
        Assert.assertTrue(structurecoverage.startsWith(expectedstructurecoverage));
        System.out.println("  Expected error message is " + expectedstructurecoverage + " and it is " + structurecoverage);


        NCHO3RiskAnalysis riskanalysis = coverages.clickCoverages()
                .clickPropertyEndorsements()
                .setSpecificOtherStructuresLimit(1, "5000")
                .next();

        riskanalysis.clickUnderWritingQuestions();

        for (int j = 9; j <= 9; j++) {
            riskanalysis.answerYes(j);
        }
        riskanalysis.back();

        convitederror = riskanalysis.getErrorMessage();
        Assert.assertTrue(convitederror.startsWith(expectedconvitederror));
        System.out.println("  Expected error message is " + expectedconvitederror + " and it is " + convitederror);

        for (int z = 9; z <= 9; z++) {
            riskanalysis.answerNo(z);
        }

        //goes to the dwelling page from risk analysis page

        riskanalysis.back()
                .back()
                .back()
                .back();

        dwe.setTerritoryCode(Tcode)
                .next();

        territorycodeerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(territorycodeerror.startsWith(expectedterritorycodeerrror));
        System.out.println("  Expected error message is " + expectedterritorycodeerrror + " and it is " + territorycodeerror);


        //setting back the territory to 110
        dwe.setTerritoryCode(Tcode1)
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
