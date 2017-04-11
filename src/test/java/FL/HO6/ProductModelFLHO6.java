package FL.HO6;


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
import pageobjects.FLHO6.*;
import pageobjects.Logon;

public class ProductModelFLHO6 extends BaseTest
{
    private WebDriver driver;
    private Logon logon;
    private FLHO6EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private String firstname, lastname;

    @BeforeMethod
    public void beforeMethod()
    {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        logon = new Logon(sh, sessionInfo);
        logon.load();
        logon.isLoaded();
        String user = "User1brown", password = "";
        logon.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));

        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
    }

    @Test(description = "Creates account for Florida HO6 product")
    public void createPersonAccountFLHO6(ITestContext itc)
    {
        log(itc.getName());
        firstname = String.format("FLHO6Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
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

        enterAccountInformation = new FLHO6EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLHO6CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLHO6();
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

            FLHO6AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            log(e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Test(description = "FL.HO6.productModel.LessCoverage001"/*,
            dependsOnMethods = {"createPersonAccountFLHO6"}*/)
    public void productModelLessCoverageFLHO6(ITestContext itc)
    {
        log(itc.getName());

    /* Set Variables */
        //        String firstname = "Ricky0209015449";
        //        String lastname = "Bobby0209015449";
        firstname = "FLHO6Ricky0407112234";
        lastname = "Bobby0407112234";

        String policyType = "Condominium (HO6)";
        String offeringSelection = "Less Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "Condominium";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Tenant Occupied",
                expectedDwellingOccupance;
        String roofShapeType = "Gable";
        String dwellingLimit = "100000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "10%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "25,000";
        String personalPropertyLimit = "50,000",
                expectedPersonalPropertyLimit = "",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Actual Cash Value";
        String lossOfUsePercentage, defaultLossOfUsePercentage = "40%";
        String fairRentalValuePercentage,
                defaultFairRentalValuePercentage = "10%";
        String fairRentalValueLimit,
                defaultFairRentalValueLimit = "25,000";
        String premisesLiabilityLimit,
                defaultPremisesLiabilityLimit = "100,000";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String hurricanePercentage, defaultHurricanePercentage = "10%";
        String whenSafeCreditPercentage, defaultWhenSafeCreditPercentage = "5%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "1,250";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "10,000 / 50,000";
        String theftType, defaultTheftType = "Limited";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";
        String additionalLivingExpensesPercent, defaultAdditionalLivingExpensesPercent = "10%";
        String additionalLivingExpensesLimit, defaultAdditionalLivingExpensesLimit = "25,000";

    /* Begin Test */
        enterAccountInformation = new FLHO6EnterAccountInformation(sh);
        FLHO6AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLHO6();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO6NewSubmission ns = new FLHO6NewSubmission(sh);
        FLHO6Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++)
        {
            qualification.questionnaire.answerNo(i+1);
        }

        FLHO6Dwelling dwelling = qualification
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

        FLHO6Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next();

        /* Dwelling Limit */
        String defaultDwellingLimit = coverages.getDwellingLimit();
        Assert.assertTrue(defaultDwellingLimit.equals(defaultDwellingLimit),
                "Dwelling limit was expected to be " + defaultDwellingLimit +
                        " but it was" + defaultDwellingLimit);
        coverages.setDwellingLimit(dwellingLimit);

        /* Personal Property */
        String defaultPersonalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(defaultPersonalPropertyLimit.equals(expectedPersonalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + defaultPersonalPropertyLimit);

        coverages.setPersonalPropertyLimit(personalPropertyLimit);
        expectedPersonalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        /* Personal Property Valuation Method */
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyValuationMethod);

        lossOfUsePercentage = coverages.getLossOfUseSelection();
        Assert.assertTrue(defaultLossOfUsePercentage.equals(lossOfUsePercentage),
                "Loss Of Use Percentage was expected to be " + defaultLossOfUsePercentage +
                        ", but it was " + lossOfUsePercentage);

        /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");

        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricanePercentage = coverages.getHurricanePercentage();
        Assert.assertTrue(defaultHurricanePercentage.equals(hurricanePercentage),
                "Hurricane Deductible was expected to be " + defaultHurricanePercentage +
                        ", but it was " + hurricanePercentage);

        Assert.assertFalse(coverages.setWindExcluded("true").isHurricanePresent(),
                "Hurricane was not expected to be present but it was");
        Assert.assertTrue(coverages.setWindExcluded("false").isHurricanePresent(),
                "Hurricane was expected to be present but it was not");



        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +
                        ", but it was " + otherStructuresPercentage);

        otherStructuresLimit = coverages.getOtherStructuresLimit();
        Assert.assertTrue(expectedOtherStructuresLimit.equals(otherStructuresLimit),
                "Expected Other Structures Limit was " + expectedOtherStructuresLimit + ", but it was " +
                        otherStructuresLimit);



    /* Fair Rental */
        fairRentalValuePercentage = coverages.getFairRentalValuePercentage();
        Assert.assertTrue(defaultFairRentalValuePercentage.equals(fairRentalValuePercentage),
                "Fair Rental Value Percentage was expected to be " + defaultFairRentalValuePercentage +
                        ", but it was " + fairRentalValuePercentage);
        fairRentalValueLimit = coverages.getFairRentalValueLimit();
        Assert.assertTrue(defaultFairRentalValueLimit.equals(fairRentalValueLimit),
                "Fair Rental Value Limit was expected to be " + defaultFairRentalValueLimit +
                        ", but it was " + fairRentalValueLimit);



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

        FLHO6Coverages.FLHO6PropertyEndorsements pe = coverages.clickPropertyEndorsements();

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

        /*Assert.assertFalse(pe.isTheftCoverageChecked(),
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
        afs.westPanel.clickDwelling();
        dwelling = new FLHO6Dwelling(sh, CenterPanelBase.Path.SUBMISSION);
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
        afs.westPanel.clickDwelling();

        dwelling = new FLHO6Dwelling(sh, CenterPanelBase.Path.SUBMISSION);
        dwellingOccupance = dwelling.getDwellingOccupancy();
        expectedDwellingOccupance = "Owner Occupied";

        Assert.assertTrue(expectedDwellingOccupance.equals(dwellingOccupance),
                "Dwelling Occupancy was expected to be " + expectedDwellingOccupance +
                        ", but it was " + dwellingOccupance);

        dwelling.next().next(); // Go to coverages

        coverages = new FLHO6Coverages(sh, CenterPanelBase.Path.SUBMISSION);

        theftType = coverages.clickPropertyEndorsements().clickTheftCoverage().getTheftType();

        Assert.assertTrue(defaultTheftType.equals(theftType),
                "Theft Type was expected to be " + defaultTheftType +
                        ", but it was " + theftType);*/
    }

    @Test(description = "FL.HO6.ProductModel.MoreCoverage003"/*, dependsOnMethods =
            { "createPersonAccountFLHO6" }*/)
    public void productModelMostCoverageFLHO6(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
        firstname = "FLHO6Ricky0302013826";
        lastname = "Bobby0302013826";

        String policyType = "Condominium (HO6)";
        String offeringSelection = "More Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "Condominium";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Owner Occupied";
        String roofShapeType = "Gable";
        String dwellingLimit = "400000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "50,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        String lossOfUsePercentage, expectedLossOfUsePercentage = "40%";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String creditCard, defaultCreditCard = "5,000";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "10,000 / 50,000";
        String lossAssessmentLimit,
                expectedLossAssessmentLimit = "3,000";
        String ordinanceOrLawLimit, defaultOrdinanceOrLawLimit = "50%";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";

        /* Begin Test */
        FLHO6NavigationBar nb = new FLHO6NavigationBar(sh);
        FLHO6SearchAccounts sa = nb.clickSearchAccount();
        FLHO6AccountFileSummary afs = sa.setFirstName(firstname)
                .setLastName(lastname)
                .clickSearchButton()
                .clickAccountNumberSearchAccount();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO6NewSubmission ns = new FLHO6NewSubmission(sh);
        FLHO6Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        FLHO6Dwelling dwelling = qualification
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

        FLHO6Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .setDwellingLimit(dwellingLimit);

        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue("".equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);
        coverages.setPersonalPropertyLimit(expectedPersonalPropertyLimit);

        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyLimit);

        lossOfUsePercentage = coverages.getLossOfUseSelection();
        Assert.assertTrue(expectedLossOfUsePercentage.equals(lossOfUsePercentage),
                        "Loss Of Use Percentage was expected to be " + expectedLossOfUsePercentage +
                                ", but it was " + lossOfUsePercentage);

        /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricanePercentage();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "" + defaultHurricaneDeductible +
                        ", but it was " + hurricaneDeductible);

        /* Medical Payments */
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        FLHO6Coverages.FLHO6PropertyEndorsements pe = coverages.clickPropertyEndorsements();

        /* Property Endorsements */
        Assert.assertFalse(pe.isSpecificOtherStructuresChecked(),
                "Specific Other Structures was not expected to be checked but it was");
        Assert.assertFalse(pe.isScheduledPersonalPropertyChecked(),
                "Scheduled Personal Property was expected to be checked but it was not");
        creditCard = pe.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        Assert.assertTrue(defaultCreditCard.equals(creditCard),
                        "Credit Card was expected to be " + defaultCreditCard +
                                ", but it was " + creditCard);

        /* Limited Fungi, Wet or dry Rot, or Bacteria */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                "Limit Fungi, Wet or Dry Rot... Occurrence/Aggregate Limit " + defaultFungiOccurrenceAggregateLimit +
                        ", but it was " + fungiOccurrenceAggregateLimit);

        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                        "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                                ", but it was " + lossAssessmentLimit);
        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                        "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                                ", but it was " + lossAssessmentLimit);

        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(defaultOrdinanceOrLawLimit.equals(ordinanceOrLawLimit),
                        "Ordinance Or Law Limit was expected to be " + defaultOrdinanceOrLawLimit +
                                ", but it was " + ordinanceOrLawLimit);

        Assert.assertFalse(pe.isScreenEnclosureHurricaneCoverageChecked(),
                "Screen Enclosure Hurricane Coverage was not expected to be checked but it was");

        Assert.assertFalse(pe.isUnitOwnersCoverageASpecialCoverage(),
                "Unit Owners Coverage A Special Coverage was not expected to be checked but it was");

        Assert.assertFalse(pe.isUnitOwnersRentedToOthers(),
                "Unit Owners Rented To Others was not expected to be checked but it was");

        Assert.assertTrue(pe.isWaterBackUpChecked(),
                "Water Back Up was expected to be checked but it was not");
        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);

        FLHO6Coverages.FLHO6LiabilityEndorsements le = pe.clickLiabilityEndorsements();

        /* Liability Endorsements */
        Assert.assertFalse(le.isPermittedIncidentalOccupancyLiabilityChecked(),
                "Permitted Incidental Occupancy Liability was not expected to be checked but it was");
        Assert.assertFalse(le.isAdditionalResidenceRentedToOthersChecked(),
                "Additional Residence Rented To Others was not expected to be checked but it was");
        Assert.assertFalse(le.isBusinessPursuitsChecked(),
                "Business Pursuits was not expected to be checked but it was");
        Assert.assertFalse(le.isWatercraftLiabilityChecked(),
                "Watercraft Liability was not expected to be checked but it was");
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
