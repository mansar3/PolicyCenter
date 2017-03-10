package SC.HO6;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Logon;
import pageobjects.SCHO6.*;

/**
 * Created by ssai on 3/1/2017.
 */
public class ValidationRulesSCHO6 extends BaseTest {

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

    @Test(description = "Creates Account for SCHO6")
    public void CreatePersonalAccountforSCHO6(ITestContext itc) {
        String firstname = "SCHO6";
        String lastname = "Validationrule";
        String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "371 Pelican Flight Dr";
        String city = "Dewees Island";
        String state = "South Carolina";
        String zip = "29451";
        String addrestype = "Home";
        String orgname = "C.T";
        String producercode = "523-23-30007 C.T. Lowndes & Co. - Charleston";
        SCHO6NavigationBar nb = new SCHO6NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

        SCHO6EnterAccountInformation eai = new SCHO6EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountSCHO6();

        SCHO6CreateAccount ca = new SCHO6CreateAccount(sh);
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
        SCHO6Organizations org = new SCHO6Organizations(sh);

        org.setOrganizationName(orgname);
        org.clickSearchButton();
        org.selectOrganizationButton();
        ca.setProducerCode(producercode);
//after filling the form clicking on the update button in create account page
        ca.update();

    }

    @Test(description = "Validating the HO3")
    public void ValidatingSCH06() {

        String firstname = "SCHO6";
        String lastname = "Validationrule";
        String policyType = "Condominium (HO6)";
      //  String futureEffectiveDate = new DateTime().plusDays(56).toString("MM/dd/yyyy");
        String effectiveDate = new DateTime().toString("MM/dd/yyyy");
        String futureYear = new DateTime().plusYears(1).toString("yyyy");
     //   String currentYear = new DateTime().toString("yyyy");
        String plumbingYear = new DateTime().minusYears(18).toString("yyyy");
        String waterHeaterYear = new DateTime().minusYears(18).toString("yyyy");
        String roofYear = new DateTime().minusYears(18).toString("yyyy");
        String yearBuilt1 = new DateTime().minusYears(18).toString("yyyy");
        String yearBuilt = "2001";
        String distanceToFireHydrant = "200",
                territorycode = "01",
                BECG = "07",
                protectionclass = "3";
        String county = "Dell",
                county1 = "Charleston";
        String roofshapetype = "Gable";
     //   String roofyear;
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
                dwellinglimit1 = "900",
                dwellinglimit2 = "300000";
        // dwellinglimit3 = "220000";
        String personalpropertylimit = "900",
                personalpropertylimit1 = "150000",
                personalpropertylimit2 = "100000";
        String electricalsystemFuses = "Fuses",
                electricalsystemcircuitbreaker = "Circuit Breaker";
        String conditionofroof = "Below Average",
                conditionofroof1 = "Good";
        String yearbuilt, expectedyearbuilt = "Please enter a valid 4 digit year: Year Built.";
        String Countyrisk, expectedcountyrisk = "This risk is not located within the approved binding territory for your agency. Please contact your Sales Representative should you have any questions.: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String expectederrormessagesafetylatches = " Burglar bars without safety release latches are ineligible for coverage";
        String yearerrormessage, expectedyearerrormessage = "Please enter a valid 4 digit year: Year Built.";
        String protectionclasserror, expectedprotectionclasserror = "Property with a protection class of 10 or 10W are ineligible for coverage: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String poolerror1, expectedpoolerror1 = "Pools without approved security do not meet eligibility guidelines: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String divingerror, expecteddivingerror = "Diving Boards do not meet eligibility guidelines: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String slideerror, expectedslideerror = "Slides do not meet eligibility guidelines: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String housekeepingerror, expectedhousekeepingwrror = "Below average housekeeping is ineligible for coverage: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String burgularbars, expectedburgularbars = "Burglar bars without safety release latches are ineligible for coverage: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String primaryheating, expectedpprimaryheating = "Fireplaces, Space Heaters, Wood Stoves, and Wood Furnaces do not meet eligibility guidelines.: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String electricsystemfuse, expectedelectricsystemfuse = "Fuse panels do not meet eligibility guidelines: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String conditionrooferror, expectedconditionroof = "Below Average roofs do not meet eligibility guidelines.: Dwelling at 371 PELICAN FLIGHT DR, DEWEES ISLAND, SC.";
        String dwellinglimiterror, expecteddwellinglimiterror = "Dwelling coverage limit is below the acceptable minimum limit: Dwelling.";
        String personalpropertylimmiterror, expectedpersonalpropertylimmiterror = "Personal Property limit is below the allowable minimum: Personal Property.";
      //  String personalpropertylimitaboveerror, expectedpersonalpropertylimitaboveerror = "Personal Property limit is above the allowable maximum: Personal Property.";
       // String otherstructureserror, expectedotherstructureserror = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String convitederror, expectedconvitederror = "Applicants convicted of arson are ineligible for coverage.";
     //   String structurecoverage, expectedstructurecoverage = "The combined limit of all Other Structure Coverages is above the allowable maximum limit: Dwelling.";
        String dwellingpersonalerror, expecteddwellingpersonalerror = "The combined dwelling and personal property limits are below the allowable minimum: Dwelling.";

        SCHO6NavigationBar nav = new SCHO6NavigationBar(sh);
        SCHO6SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        SCHO6AccountFileSummary afs = new SCHO6AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        SCHO6NewSubmission ns = new SCHO6NewSubmission(sh);
        SCHO6Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        SCHO6Dwelling dwe = qua.next()
                // .setEffectiveDate(futureEffectiveDate)
                .setEffectiveDate(effectiveDate)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode(territorycode)
                .setBCEG(BECG)
                .setProtectionClassCode(protectionclass)
                .editLocation()
                .setCounty(county)
                .clickOk()
                .Enter();

        //validating the error

        Countyrisk = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedcountyrisk.equals(Countyrisk));
        System.out.println(" Expected Roof Year should be " + expectedcountyrisk + " and it is " + Countyrisk);

        //setting back the county to default
        dwe.editLocation()
                .setCounty(county1)
                .clickOk();

        dwe.setYearBuilt(futureYear)
                .Enter();

        //verify the error message

        yearbuilt = dwe.getdwellingErrorMessage();
        Assert.assertTrue(expectedyearbuilt.equals(yearbuilt));
        System.out.println(" Expected Roof Year should be " + expectedyearbuilt + " and it is " + yearbuilt);

        dwe.setYearBuilt(yearBuilt1)
                .next()
                .clickWindMitigation()
                .setRoofShapeType(roofshapetype)
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

        SCHO6DwellingConstruction dwellingConstruction = dwe.clickProtectionDetails()
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
                .setPersonalPropertyLimit(personalpropertylimit2)
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

        SCHO6Coverages coverages = dwellingConstruction
                .setConditionOfRoof(conditionofroof1)
                .next();

        coverages.setDwellingLimit(dwellinglimit1)
                .setPersonalPropertyLimit(personalpropertylimit)
                .coveragesEnter();
        //3 error messages should display


        personalpropertylimmiterror = coverages.coveragesErrorMessage();
        Assert.assertTrue(expectedpersonalpropertylimmiterror.equals(personalpropertylimmiterror));
        System.out.println("  Expected error message is " + expectedpersonalpropertylimmiterror + " and it is " + personalpropertylimmiterror);


        dwellinglimiterror = coverages.coveragesErrorMessage2();
        Assert.assertTrue(expecteddwellinglimiterror.equals(dwellinglimiterror));
        System.out.println(" Expected error message is " + expecteddwellinglimiterror + "  and it is " + dwellinglimiterror);

        dwellingpersonalerror = coverages.coveragesErrorMessage3();
        Assert.assertTrue(expecteddwellingpersonalerror.equals(dwellingpersonalerror));
        System.out.println(" Expected error message is " + expecteddwellingpersonalerror + "  and it is " + dwellingpersonalerror);


        //one  more error  need to be done

        SCHO6RiskAnalysis riskanalysis = coverages.setDwellingLimit(dwellinglimit2)
                .setPersonalPropertyLimit(personalpropertylimit1)
                .next();
        //goes to underwriting questions

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
}