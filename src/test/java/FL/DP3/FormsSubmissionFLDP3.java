package FL.DP3;


import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.FLDP3.*;
import pageobjects.Logon;
import pageobjects.WizardPanelBase.*;

import java.util.HashMap;

public class FormsSubmissionFLDP3 extends BaseTest
{
    private WebDriver driver;
    private Logon logon;
    private FLDP3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private String firstname, lastname;

    @BeforeMethod
    public void beforeMethod()
    {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        String user = "User1brown", password = "";
        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        logon = new Logon(sh, sessionInfo);
        logon.load();
        logon.isLoaded();
        logon.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));

        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
    }

    @Test(description = "Creates account for Florida DP3 product")
    public void createPersonAccountFLDP3(ITestContext itc)
    {
        log(itc.getName());
        firstname = String.format("FLDP3Ricky%s", dateString);
        lastname = String.format("Submission%s", dateString);
        String country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "4071234567",
                address = "234 Walnut St",
                city = "Daytona Beach",
                state = "Florida",
                zipcode = "32114",
                addressType = "Home",
                ssn = "777-12-3456",
                producerCode = "523-23-21498 Brown & Brown of Florida - West Palm Beach";

        enterAccountInformation = new FLDP3EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLDP3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLDP3();
        log(String.format("Creating new account: %s", dateString));

        try {
            createAccount
                    .setCountry(country)
                    .setDateOfBirth(dob)
                    .setMobilePhone(phoneNumber)
                    .setAddressLine1(address)
                    .setCity(city)
                    .setState(state)
                    .clickVerifyAddress()
                    .selectSuccessfulVerificationIfPossibleForCreateAccount()
                    .setAddressType(addressType)
                    .setSsn(ssn)
                    .setProducerCode(producerCode);

            String expectedAddress = createAccount.getAddressLine1();
            Assert.assertTrue(expectedAddress.toUpperCase().equals(address.toUpperCase()),
                    "Address expected was " + address + " but it was " + expectedAddress);
            Assert.assertTrue(createAccount.getZipCode().contains(zipcode),
                    "Zipcode expected was " + createAccount.getZipCode() +
                            ", but it was " + zipcode);

            FLDP3AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            log(e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Test(description = "FL.DP3.productModel.LessCoverage001",
            dependsOnMethods = {"createPersonAccountFLDP3"})
    public void FormsSubmissionFLDP3(ITestContext itc)
    {
        log(itc.getName());

    /* Set Variables */
        //        String firstname = "Ricky0209015449";
        //        String lastname = "Bobby0209015449";
            firstname = "FLDP3Ricky0420041335";
            lastname = "Bobby0420041335";

        String policyType = "Dwelling Fire (DP3)";
        String offeringSelection = "Less Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "1 Family Residence";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Tenant Occupied",
                expectedDwellingOccupance;
        String roofShapeType = "Gable";
        String dwellingLimit = "250000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "10%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "25,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "5,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Actual Cash Value";
        String fairRentalValuePercentage,
                defaultFairRentalValuePercentage = "10%";
        String fairRentalValueLimit,
                defaultFairRentalValueLimit = "25,000";
        String premisesLiabilityLimit,
                defaultPremisesLiabilityLimit = "100,000";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "10%";
        String whenSafeCreditPercentage, defaultWhenSafeCreditPercentage = "5%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "1,250";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "10,000 / 50,000";
        String theftType, defaultTheftType = "Limited";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";
        String additionalLivingExpensesPercent, defaultAdditionalLivingExpensesPercent = "10%";
        String additionalLivingExpensesLimit, defaultAdditionalLivingExpensesLimit = "25,000";

        String[] forms = {"meh"};
        HashMap<String, String> hm = new HashMap<>();
        hm.put("meh" , "bleh");

    /* Begin Test */
        enterAccountInformation = new FLDP3EnterAccountInformation(sh);
        FLDP3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLDP3();

        afs.clickTransactionNumber().clickQuote().westPanel.clickForms();


//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();


        FLDP3NewSubmission ns = new FLDP3NewSubmission(sh);
        FLDP3Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        FLDP3Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode("005")    // This line had to be added because test would not proceed without this value
                .setBCEG("05")              // This line had to be added because test would not proceed without this value
                .setProtectionClassCode(protectionClassCode)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity("false")
                .setResidenceType(residenceType)
                .setDwellingUsage(dwellingUsage)
                .setDwellingOccupancy(dwellingOccupance);

        FLDP3Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .setDwellingLimit(dwellingLimit);
        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +
                        ", but it was " + otherStructuresPercentage);

        otherStructuresLimit = coverages.getOtherStructuresLimit();
        Assert.assertTrue(expectedOtherStructuresLimit.equals(otherStructuresLimit),
                "Expected Other Structures Limit was " + expectedOtherStructuresLimit + ", but it was " +
                        otherStructuresLimit);

    /* Personal Property */
        Assert.assertTrue(coverages.isPersonalPropertyExcluded(),
                "Personal Property Excluded radio button was expected to be 'Yes' but it was 'No'");

        personalPropertyLimit = coverages.setPersonalPropertyExcluded("false").getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyValuationMethod);

    /* Fair Rental */
        fairRentalValuePercentage = coverages.getFairRentalValuePercentage();
        Assert.assertTrue(defaultFairRentalValuePercentage.equals(fairRentalValuePercentage),
                "Fair Rental Value Percentage was expected to be " + defaultFairRentalValuePercentage +
                        ", but it was " + fairRentalValuePercentage);
        fairRentalValueLimit = coverages.getFairRentalValueLimit();
        Assert.assertTrue(defaultFairRentalValueLimit.equals(fairRentalValueLimit),
                "Fair Rental Value Limit was expected to be " + defaultFairRentalValueLimit +
                        ", but it was " + fairRentalValueLimit);

    /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricanePercentage();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "Hurricane Deductible was expected to be " + defaultHurricaneDeductible +
                        ", but it was " + hurricaneDeductible);

    /* Premises Liability */
        premisesLiabilityLimit = coverages.getPremisesLiabilityLimit();
        Assert.assertTrue(defaultPremisesLiabilityLimit.equals(premisesLiabilityLimit),
                "Premises Liability Limit was expected to be " + defaultPremisesLiabilityLimit +
                        ", but it was " + premisesLiabilityLimit);

    /* Medical Payments */
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        FLDP3Coverages.FLDP3PropertyEndorsements pe = coverages.clickPropertyEndorsements();

    /* Property Endorsements */
        Assert.assertTrue(pe.isWhenSafeChecked(),
                "When Safe was expected to be checked but it was not");
        whenSafeCreditPercentage = pe.getWhenSafeCreditPercentage();
        Assert.assertTrue(defaultWhenSafeCreditPercentage.equals(whenSafeCreditPercentage),
                "When Safe Credit Percentage was expected to be " + defaultWhenSafeCreditPercentage +
                        ", but it was " + whenSafeCreditPercentage);
        whenSafeCreditValue = pe.getWhenSafeCreditValue();
        Assert.assertTrue(defaultWhenSafeCreditValue.equals(whenSafeCreditValue),
                "When Safe Credit Value was expected to be " + defaultWhenSafeCreditValue +
                        ", but it was " + whenSafeCreditValue);

    /* Limited Fungi, Wet or dry Rot, or Bacteria */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                "Limit Fungi, Wet or Dry Rot... Occurrence/Aggregate Limit " + defaultFungiOccurrenceAggregateLimit +
                        ", but it was " + fungiOccurrenceAggregateLimit);

        Assert.assertFalse(pe.isScreenEnclosureHurricaneCoverageChecked(),
                "Screen Enclosure Hurricane Coverage was expected to be checked but it was not");

        Assert.assertFalse(pe.isTheftCoverageChecked(),
                "Theft Coverage was expected to be checked but it was not");
        theftType = pe.clickTheftCoverage().getTheftType();
        Assert.assertTrue(defaultTheftType.equals(theftType),
                "Theft Type was expected to be " + defaultTheftType +
                        ", but it was " + theftType);

        Assert.assertFalse(pe.isWaterBackUpChecked(),
                "Water Back Up was not expected to be checked but it was");

        waterBackUpLimit = pe.checkWaterBackUp().getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                        ", but it was " + waterBackUpLimit);

        Assert.assertFalse(pe.isSinkholeLossCoverageChecked(),
                "Sinkhole Loss Coverage was not expected to be checked but it was");
        Assert.assertTrue(pe.checkSinkholeLossCoverage().isSinkholeLossCoverageChecked(),
                "Sinkhole Loss Coverage was expected to be displayed after checked, but it was not");
//        afs.westPanel.clickDwelling();
        dwelling = new FLDP3Dwelling(sh, CenterPanelBase.Path.SUBMISSION);
        coverages = dwelling.setDwellingOccupancy("Owner Occupied").next().next();

        additionalLivingExpensesPercent = coverages.getAdditionalLivingExpensesPercent();
        Assert.assertTrue(defaultAdditionalLivingExpensesPercent.equals(additionalLivingExpensesPercent),
                "Additional Living Expenses Percent was expected to be " + defaultAdditionalLivingExpensesPercent +
                        ", but it was " + additionalLivingExpensesPercent);

        additionalLivingExpensesLimit = coverages.getAdditionalLivingExpensesLimit();
        Assert.assertTrue(defaultAdditionalLivingExpensesLimit.equals(additionalLivingExpensesLimit),
                "Additional Living Expenses Limit was expected to be " + defaultAdditionalLivingExpensesLimit +
                        ", but it was " + additionalLivingExpensesLimit);

        Assert.assertFalse(coverages.isPremiseLiabilityPresent(),
                "Premise Liability was not expected to be present but it was");

        Assert.assertTrue(coverages.isPersonalLiabilityPresent(),
                "Personal Liability was expected to be present but it was not");

        pe = coverages.clickPropertyEndorsements();
        defaultTheftType = "Broad";
        theftType = pe.getTheftType();

        Assert.assertTrue(defaultTheftType.equals(theftType),
                "Theft Type was expected to be " + defaultTheftType +
                        ", but it was " + theftType);
        coverages = pe.clickCoverages();
        coverages.setPersonalPropertyExcluded("true");
        pe = coverages.clickPropertyEndorsements();

        Assert.assertFalse(pe.isTheftCoveragePresent(),
                "Theft Coverage was not expected to be present but it was not");

        coverages = pe.clickCoverages();
        personalPropertyLimit = coverages.setPersonalPropertyExcluded("false")
                .getPersonalPropertyLimit();

        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property Limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);
        coverages.clickPropertyEndorsements();
//        afs.westPanel.clickDwelling();

        dwelling = new FLDP3Dwelling(sh, CenterPanelBase.Path.SUBMISSION);
        dwellingOccupance = dwelling.getDwellingOccupancy();
        expectedDwellingOccupance = "Owner Occupied";

        Assert.assertTrue(expectedDwellingOccupance.equals(dwellingOccupance),
                "Dwelling Occupancy was expected to be " + expectedDwellingOccupance +
                        ", but it was " + dwellingOccupance);

        dwelling.next().next(); // Go to coverages

        coverages = new FLDP3Coverages(sh, CenterPanelBase.Path.SUBMISSION);

        theftType = coverages.clickPropertyEndorsements().clickTheftCoverage().getTheftType();

        Assert.assertTrue(defaultTheftType.equals(theftType),
                "Theft Type was expected to be " + defaultTheftType +
                        ", but it was " + theftType);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult, ITestContext itc)
    {
        WebDriver driver = LocalDriverManager.getDriver();
        if(testResult.getStatus() != ITestResult.SUCCESS)
        {
            takeScreenShot(driver);
            System.out.println(String.format("\n'%s' Failed.\n", testResult.getMethod().getMethodName()));
        }
        if(driver != null)
            driver.quit();
    }
}
