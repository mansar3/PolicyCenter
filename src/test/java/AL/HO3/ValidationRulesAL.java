package AL.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ALHO3.*;
import pageobjects.Login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ssai on 2/22/2017.
 */

// For Alabama Ho3AL

public class ValidationRulesAL extends BaseTest {
    private String dateString;
    private WebDriver driver;
    private Login login;
    private CenterSeleniumHelper sh;


    @BeforeMethod
    public void beforeMethod() {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        login = new Login(sh, sessionInfo);
        login.load();
        login.isLoaded();
        String user = "Su", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for ALHO3")
    public void CreatePersonalAccountforALHO3(ITestContext itc) {
        String user = "su";
        String password = "gw";
        String firstname = "ALHO3";
        String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "2000 River Forest Rd";
        String city = "Mobile";
        String state = "Alabama";
        String zip = "36005";
        String addrestype = "Home";
        String orgname = "BB";
        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
        log(itc.getName());

        ALHO3EnterAccountInformation eai = new ALHO3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountALHO3();

        ALHO3CreateAccount ca = new ALHO3CreateAccount(sh);
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
        ALHO3Organizations org = new ALHO3Organizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
//after filling the form clicking on the update button in create account page
        ca.update();

    }

    @Test(description = "Validating the Ho3")
    public void ValidatingHO3AL() {

        String firstname = "ALHO3";
        String lastname = "Validationrule";
        String policyType = "Homeowners (HO3)";
        //   String effectivedate = "04/18/2017";
        String effectivedate1 = new DateTime().toString("MM/dd/yyyy");
        String yearBuilt = "2001";
        String distanceToFireHydrant = "200";
        String county = "Dell";
        String county1 = "MOBILE";
        String roofshapetype = "Gable";
        String roofyear;
        String expectedroofyear = "2001";
        String protectionclasscode = "10";
        String protectionclasscode1 = "10W";
        String protectionclasscode2 = "6";
        String pool = "true";
        String pool1 = "false";
        String poolLocation = "Above-Ground";
        String poolFensed = "false";
        String poolFensed1 = "true";
        String poolFencetype = "Approved Fence";
        String divingBoard1 = "true";
        String divingBoard = "false";
        String poolSlide = "false";
        String poolSlide1 = "true";
        String houseKeepongConditionsBA = "Below Average";
        String housekeepingConditiongood = "Good";
        String burglarbaronwindowstrue = "true";
        String burglarbaronwindowno = "false";
        String safetylatches = "false";
        String primaryHeatingfire = "Fireplace";
        String primaryHeatingspace = "Space Heater";
        String primaryHeatingwood = "Wood Stove";
        String primaryHeatingwoodf = "Wood Furnace";
        String primaryHeatingelectric = "Electric";
        String dwellinglimit = "250000",
                dwellinglimit1 = "190000",
                dwellinglimit2 = "210000",
                dwellinglimit3 = "220000";
        String personalpropertylimit = "24000",
                personalpropertylimit1 = "120000",
                personalpropertylimit2 = "176000",
                personalpropertylimit3 = "112000";
        String dwellingfinal,
                expecteddwellingfinal = "220,000";
        String personalpropertylimitval,
                expectedpersonalpersonallimit = "112,000";
        String otherstructurepercentage,
                expectedothersstructurepercentage = "2%";
        String electricalsystemFuses = "Fuses",
                electricalsystemcircuitbreaker = "Circuit Breaker";
        String conditionofroof = "Below Average",
                conditionofroof1 = "Good";

        String futureEffectiveDate = new DateTime().plusDays(56).toString("MM/dd/yyyy");
        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
        String futureYear = new DateTime().plusYears(1).toString("yyyy");
        String currentYear = new DateTime().toString("yyyy");
        String plumbingYear = new DateTime().minusYears(18).toString("yyyy");
        String waterHeaterYear = new DateTime().minusYears(18).toString("yyyy");
        String roofYear = new DateTime().minusYears(18).toString("yyyy");

        String specificotherstructuresdescription = ", Example";
        // String othersstructurelimit = (1, "66000");
        String expectederrormessagesafetylatches = " Burglar bars without safety release latches are ineligible for coverage";
        String yearerrormessage, expectedyearerrormessage = "Please enter a valid 4 digit year: Year Built.";
        String protectionclasserror, expectedprotectionclasserror = "Property with a protection class of 10 or 10W are ineligible for coverage: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String poolerror1, expectedpoolerror1 = "Pools without approved security do not meet eligibility guidelines: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String divingerror, expecteddivingerror = "Diving Boards do not meet eligibility guidelines: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String slideerror, expectedslideerror = "Slides do not meet eligibility guidelines: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String housekeepingerror, expectedhousekeepingwrror = "Below average housekeeping is ineligible for coverage: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String Burgularbars, expectedburgularbars = "Burglar bars without safety release latches are ineligible for coverage: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String primaryheating, expectedpprimaryheating = "Fireplaces, Space Heaters, Wood Stoves, and Wood Furnaces do not meet eligibility guidelines.: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String electricsystemfuse, expectedelectricsystemfuse = "Fuse panels do not meet eligibility guidelines: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String conditionrooferror, expectedconditionroof = "Below Average roofs do not meet eligibility guidelines.: Dwelling at 2000 RIVER FOREST DR, MOBILE, AL.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
        String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
        String otherstructureserror, expectedotherstructureserror = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";

        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);
        ALHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
        ALHO3Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        ALHO3Dwelling dwe = qua.next()
                .setEffectiveDate(effectivedate1)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .editLocation()
                .setCounty(county)
                .clickOk()
                .editLocation()
                .setCounty(county1)
                .clickOk();

        ALHO3DwellingConstruction dwellingConstruction = dwe.next()
                .clickWindMitigation()
                .setRoofShapeType(roofshapetype)
                .clickDetails();

        roofyear = dwellingConstruction.getRoofYear();
        Assert.assertTrue(expectedroofyear.equals(roofyear));
        System.out.println(" Expected Roof Year should be " + expectedroofyear + " and it is " + roofyear);

        dwe.clickDwellingLeftMenu()
                .setYearBuilt(futureYear)
                .Enter();
        yearerrormessage = dwe.getdwellingErrorMessage();
        //       System.out.println(yearerrormessage);
        //   System.out.println(expectedyearerrormessage);
        Assert.assertTrue(expectedyearerrormessage.equals(yearerrormessage));
        System.out.println(" Expected error message " + expectedyearerrormessage + " but it was " + yearerrormessage);
        dwe.setYearBuilt(currentYear)
                .next()
                .back();

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

        //changing the pool settings

        dwe.setSwimmingPool(pool)
                .setPoolLocation(poolLocation)
                .setPoolFenced(poolFensed)
                .setDivingBoard(divingBoard)
                .setPoolSlide(poolSlide)
                .Enter();
        poolerror1 = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedpoolerror1.equals(poolerror1));
        System.out.println(" Expected error message is " + expectedpoolerror1 + " but it was " + poolerror1);

        //changing the pool  option again
        dwe.setPoolFenced(poolFensed1)
                .setFenceType(poolFencetype)
                .setDivingBoard(divingBoard1)
                .Enter();
        divingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expecteddivingerror.equals(divingerror));
        System.out.println(" Expected error message is " + expecteddivingerror + " but it was " + divingerror);

        //changing the options for slide
        dwe.setDivingBoard(divingBoard)
                .setPoolSlide(poolSlide1)
                .Enter();
        slideerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedslideerror.equals(slideerror));
        System.out.println(" Expected error message is " + expectedslideerror + " but it was " + slideerror);

        //doing changes for house keeping
        dwe.setSwimmingPool(pool)
                .setHousekeepingCondition(houseKeepongConditionsBA)
                .Enter();

        housekeepingerror = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedhousekeepingwrror.equals(housekeepingerror));
        System.out.println(" Expected error message is " + expectedhousekeepingwrror + " but it was " + housekeepingerror);

        //goes to the protection page.
        dwe.setSwimmingPool(pool1)
                .setHousekeepingCondition(housekeepingConditiongood)
                .next();

        dwe.clickDwellingBack()
                .clickProtectionDetails()
                .setBurglarBarsOnWindows(burglarbaronwindowstrue)
                .safetyLatchesPresent(safetylatches)
                .clickProtectionDetailsenter()
//
//         Burgularbars = dwe.getdwellingErrorMessage();
//          Assert.assertTrue(expectedburgularbars.equals(Burgularbars)," Expected dwelling limit "+ Burgularbars+
//           " but it was " + expectedburgularbars);
                .setBurglarBarsOnWindows(burglarbaronwindowno)
                .next();

        //validating the primary heating
        dwellingConstruction.setPrimaryHeating(primaryHeatingfire)
                .dwellingConstructionEnter();
        sh.waitForNoMask();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        System.out.println(primaryheating);
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);

        dwellingConstruction.setPrimaryHeating(primaryHeatingspace)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is  " + expectedpprimaryheating + " but it was " + primaryheating);

        dwellingConstruction.setPrimaryHeating(primaryHeatingwood)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);

        dwellingConstruction.setPrimaryHeating(primaryHeatingwoodf)
                .dwellingConstructionEnter();

        primaryheating = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedpprimaryheating.equals(primaryheating));
        System.out.println(" Expected error message is " + expectedpprimaryheating + " but it was " + primaryheating);

        dwellingConstruction.setPrimaryHeating(primaryHeatingelectric)
                .next()
                .setDwellingLimit(dwellinglimit)
                .back();
        ALHO3Coverages coverages = dwellingConstruction.setPlumbingYear(futureYear)
                .next()
                .back();

        //Going back to the Dwelling construction
        dwellingConstruction.setWaterHeaterYear(futureYear)
                .next()
                .back();

        //setting the water heateryear to the current year
        dwellingConstruction.setWaterHeaterYear(currentYear)
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

        //sets to plus one year for roof year
//        dwellingConstruction.setRoofYear(futureYear)
//                .dwellingConstructionEnter();
        //  Assert.assertTrue(sh.isDisplayed(By.xpath("//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingConstructionHOEScreen:_msgs']/div"))," This error message was expected");

        dwellingConstruction.setRoofYear(currentYear)
                .next()
                .back();


        dwellingConstruction.setConditionOfRoof(conditionofroof)
                .dwellingConstructionEnter();

        conditionrooferror = dwellingConstruction.dwellingConstructionErrorMessage();
        Assert.assertTrue(expectedconditionroof.equals(conditionrooferror));
        System.out.println(" Expected error message is " + expectedconditionroof + "and it is " + conditionrooferror);

        dwellingConstruction
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
        coverages.setPersonalPropertyLimit(personalpropertylimit)
                .coveragesEnter();

        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);

        //changing and setting personal property limit
        coverages.setPersonalPropertyLimit(personalpropertylimit1)
                .next()
                .back();
        coverages.setDwellingLimit(dwellinglimit3)
                .setPersonalPropertyLimit(personalpropertylimit2)
                .coveragesEnter();

        personalpropertylimitaboveerror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimitaboveerror.equals(personalpropertylimitaboveerror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimitaboveerror + " and it is " + personalpropertylimitaboveerror);


        //changing the personal property value
        coverages.setPersonalPropertyLimit(personalpropertylimit3)
                .next()
                .back();

        //verifying dwelling limit, personal property and structure percentage

        dwellingfinal = coverages.getDwellingLimit();
        Assert.assertTrue(expecteddwellingfinal.equals(dwellingfinal));
        System.out.println("  Expected error message is " + expecteddwellingfinal + " and it is " + dwellingfinal);

        personalpropertylimitval = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedpersonalpersonallimit.equals(personalpropertylimitval));
        System.out.println("  Expected error message is " + expectedpersonalpersonallimit + " and it is " + personalpropertylimitval);


        otherstructurepercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedothersstructurepercentage.equals(otherstructurepercentage));
        System.out.println("  Expected error message is " + expectedothersstructurepercentage + " and it is " + otherstructurepercentage);


        coverages.clickPropertyEndorsements()
                .checkSpecificOtherStructures()
                .addSpecificOtherStructures()
                .setSpecificOtherStructuresDescription(1, "Example")
                .setSpecificOtherStructuresLimit(1, "66,000")
                .coveragespropertyendorsementsEnter();

        //setting specific other structures
        otherstructureserror = coverages.coveragesErrorMessage();
        System.out.println(otherstructureserror);
        Assert.assertTrue(expectedotherstructureserror.equals(otherstructureserror));
        System.out.println("  Expected error message is " + expectedotherstructureserror + " and it is " + otherstructureserror);

        //setting the limit

        ALHO3RiskAnalysis riskanalysis = coverages.clickPropertyEndorsements()
                .setSpecificOtherStructuresLimit(1, "5,000")
                .next();

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


