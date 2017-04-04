package AL.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;

import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ALHO3.*;
import pageobjects.Logon;
import pageobjects.WizardPanelBase.*;

public class ProductModelALHO3 extends BaseTest
{
    private WebDriver driver;
    private Logon logon;
    private ALHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString, firstname, lastname;
    private MyActivities ma;

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
        String userName = "User1brown", passWord = "";
        logon.login(userName, passWord);
        log(String.format("Logged in as: %s\nPassword: %s", userName, passWord));

        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
    }

    @Test(description = "Creates account for Alabama HO3 product")
    public void createPersonAccountALHO3(ITestContext itc)
    {
        firstname = String.format("ALHO3Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String  country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "2561234567",
                address = "5264 Willard Dr N",
                city = "Theodore",
                state = "Alabama",
                addressType = "Home",
                ssn = "777-12-3456",
                producerCode = "523-23-21498 Brown & Brown of Florida - West Palm Beach";

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
		//new ALHO3Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        ALHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountALHO3();
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

            ALHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            throw new WebDriverException(e);
        }
    }

    @Test(description = "AL.HO3.ProductModel.Less.001", dependsOnMethods =
            { "createPersonAccountALHO3" })
    public void productModelLessCoverageALHO3(ITestContext itc)
    {
        log(itc.getName());

        /*Set Variables*/

        //        String firstname = "Ricky0209015449";
        //        String lastname = "Bobby0209015449";
//        firstname = "ALHO3Ricky0328114843";
//        lastname = "Bobby0328114843";

        String policyType = "Homeowners (HO3)";
        String offeringSelection = "Less Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "120";
        String protectionClassCode = "3";
        String residenceType = "1 Family Residence";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Owner Occupied",
                expectedDwellingOccupance;
        String roofShapeType = "Gable";
        String dwellingLimit = "980000",
                defaultDwellingLimit = "",
                actualDwellingLimit;
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "0%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "0";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "490,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Actual Cash Value";
        String lossOfUseSelectionPercentage,
                defaultLossOfUseSelectionPercentage = "20%";
        String lossOfUseLimit, defaultLossOfUseLimit = "10,000";
        String windHail, defaultWindHail = "5%";
        String windHailDeductible, defaultWindHailDeductible = "49,000";
        String fairRentalValuePercentage,
                defaultFairRentalValuePercentage = "10%";
        String fairRentalValueLimit,
                defaultFairRentalValueLimit = "25,000";
        String premisesLiabilityLimit,
                defaultPremisesLiabilityLimit = "100,000";
        String allOtherPerils, defaultAllOtherPerils = "2,500";
        String personalLiabilityLimit, defaultPersonalLiabilityLimit = "100,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String specificOtherStructureDescription = "test",
                specificOtherStructuresLimit = "25,000";
        String otherStructuresTableDescription = "test",
                otherStructuresTableLimit = "25,000";

        String hurricaneDeductible, defaultHurricaneDeductible = "5%";
        String whenSafeCreditPercentage, defaultWhenSafeCreditPercentage = "5%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "500";
        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "5,000 / 50,000";
        String scheduledPersonalPropertyArticleType = "Antiques",
                scheduledPersonalPropertyDescription = "Test",
                scheduledPersonalPropertyValue = "1,000";
        String scheduledPersonalPropertyClassArticleType,
                scheduledPersonalPropertyClassValue;
        String creditCardFundTransferCardLimit,
                defaultCreditCardFundTransferCardLimit = "5,000";

        String lossAssessmentLimit, defaultLossAssessmentLimit = "1,000";
        String ordinanceOrLawLimit, defaultOrdinanceOrLawLimit = "10%";
        String screenEnclosureHurricaneCoverageLimit,
                defaultScreenEnclosureHurricaneCoverageLimit = "1,000";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";
        String inflationGuardAnnualIncrease, defaultInflationGuardAnnualIncrease = "4%";
        String newAddress1 = "2009 RIVER FOREST DR", newAddressCity = "MOBILE", newAddressCounty = "Volusia";
        String businessActivity = "Clerical Employee";
        String watercraftType = "Sailboat 26-40 feet with or with out auxiliary power";
        String sinkholeIndex = "10", sinkholeClaimsIndex = "10";
        String animalLiability, defaultAnimalLiability = "25,000";
        String locationName = "1: 5264 WILLARD DR N, THEODORE, AL 36582-2382",
                numberOfFamilies = "2 Family Residence";


        String theftType, defaultTheftType = "Limited";

        String additionalLivingExpensesPercent, defaultAdditionalLivingExpensesPercent = "10%";
        String additionalLivingExpensesLimit, defaultAdditionalLivingExpensesLimit = "25,000";

        /*Begin Test*/

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
        ALHO3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberALHO3();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
        ALHO3Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i = 0; i < 8; i++)
        {
            qualification.questionnaire.answerNo(i + 1);
        }

        actualDwellingLimit = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setProtectionClassCode(protectionClassCode)
                .next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .getDwellingLimit();

        Assert.assertTrue(actualDwellingLimit.equals(defaultDwellingLimit),
                "Dwelling limit was expected to be " + defaultDwellingLimit +
        " but it was" + actualDwellingLimit);

        ALHO3Coverages coverages = new ALHO3Coverages(sh, CenterPanelBase.Path.SUBMISSION);
        coverages.setDwellingLimit(dwellingLimit);
        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +
                        ", but it was " + otherStructuresPercentage);

        /* Personal Property */
        Assert.assertTrue(coverages.isPersonalPropertyExcludedRequired(),
                "Personal Property Excluded was expected to be marked as a required field but it was not");
        Assert.assertFalse(coverages.isPersonalPropertyExcluded(),
                "Personal Property Excluded radio button was expected to be 'No' but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyLimitRequired(),
                "Personal Property Limit was expected to be marked as a required field but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyValuationMethod);

        /* Loss Of Use */
        Assert.assertTrue(coverages.isLossOfUseSelectionRequired(),
                "Loss Of Use Selection was expected to be a required field but it was not");
        lossOfUseLimit = coverages.getLossOfUseSelection();
        Assert.assertTrue(defaultLossOfUseLimit.equals(lossOfUseLimit),
                "Loss Of Use Limit was expected to be " + defaultLossOfUseLimit +
                        ", but it was " + lossOfUseLimit);

        Assert.assertTrue(coverages.isWindHailRequired(),
                "Wind/Hail was expected to be marked as required but it was not");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);

        /* Wind Hail */
        windHail = coverages.getWindHail();
        Assert.assertTrue(defaultWindHail.equals(windHail),
                "Wind Hail is expected to be " + defaultWindHail +
                        ", but it was " + windHail);
        windHailDeductible = coverages.getWindHailDeductible();
        Assert.assertTrue(defaultWindHailDeductible.equals(windHailDeductible),
                "Wind Hail deductible is expected to be " + defaultWindHailDeductible +
                        ", but it was " + windHailDeductible);

        Assert.assertTrue(coverages.setAllOtherPerils("1,000").isWindHailEnabled(),
        "Wind/Hail was expected to be enabled but it was not");

        Assert.assertTrue(coverages.setAllOtherPerils("5,000").isWindHailEnabled(),
                "Wind/Hail was expected to be enabled but it was not");

        Assert.assertTrue(coverages.setDwellingLimit("295,000").isAllOtherPerilsEditable(),
        "All Other Perils was expected to be enabled but it was not");
        Assert.assertTrue(coverages.isWindHailEnabled(),
        "Wind/Hail was expected to be enabled but it was not");
        Assert.assertTrue(coverages.setDwellingLimit("301,000").isAllOtherPerilsEditable(),
                "All Other Perils was expected to be enabled but it was not");
        Assert.assertTrue(coverages.setAllOtherPerils("10,000").isWindHailEnabled(),
                "Wind/Hail was expected to be enabled but it was not");

        Assert.assertTrue(!coverages.getWindHailDeductible().equals(""),
        "Wind/Hail deductible was expected to have a value but it did not");

        /* Personal Liability Limit */
        coverages.isPersonalLiabilityLimitRequired();
        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
                "Personal Liability Limit was expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
                "Personal Liability Limit dropdown was expected to be enabled but it was not");
        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(defaultPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability limit was " + defaultPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);

        /*Medical Payments*/

        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        ALHO3Coverages.ALHO3PropertyEndorsements pe = coverages.clickPropertyEndorsements();
//        Assert.assertTrue(pe.isSpecificOtherStructuresEnabled(),
//        "Specific Other Structures was expected to be enabled but it was not");
//        pe.addSpecificOtherStructures()
//                .setSpecificOtherStructuresDescription(1, specificOtherStructureDescription)
//                .setSpecificOtherStructuresLimit(1, specificOtherStructuresLimit);

        pe.checkOtherStructuresIncreasedCoverageRentedToOthers().addOtherStructures()
                .setOtherStructuresDescription(1, otherStructuresTableDescription)
                .setOtherStructuresLimit(1, otherStructuresTableLimit);

        Assert.assertFalse(pe.isScheduledPersonalPropertyChecked(),
                "Scheduled Personal Property was not expected to be checked, but it was");
        pe.checkScheduledPersonalProperty().clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, scheduledPersonalPropertyArticleType)
                .setPersonalPropertyDescription(1, scheduledPersonalPropertyDescription)
                .setPersonalPropertyValue(1, scheduledPersonalPropertyValue);

        scheduledPersonalPropertyClassArticleType = pe.getScheduledPersonalPropertyClassArticleType(1);
        scheduledPersonalPropertyClassValue = pe.getScheduledPersonalPropertyClassValue(1);

        Assert.assertTrue(scheduledPersonalPropertyArticleType.equals(scheduledPersonalPropertyClassArticleType),
                        "Was expected " + scheduledPersonalPropertyArticleType +
                                ", but it was " + scheduledPersonalPropertyClassArticleType);
        Assert.assertTrue(scheduledPersonalPropertyClassValue.equals(scheduledPersonalPropertyValue),
                        "Was expected " + scheduledPersonalPropertyClassValue +
                                ", but it was " + scheduledPersonalPropertyValue);

        Assert.assertFalse(pe.isCreditCardFundTransferForgeryCounterfeitMoneyChecked(),
                "Credit Card, Fund Transfer Card... was not expected to be checked but it was");
        Assert.assertTrue(pe.checkCreditCardFundTransferForgeryCounterfeitMoney().isCreditCardFundTransferForgeryCounterfeitMoneyLimitRequired(),
                "Credit Card, Fund Transfer Card... was expected to be marked required but it was not");
        creditCardFundTransferCardLimit = pe.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        Assert.assertTrue(defaultCreditCardFundTransferCardLimit.equals(creditCardFundTransferCardLimit),
                        "Credit Card, Fund Transfer Card... was expected to be " + defaultCreditCardFundTransferCardLimit +
                                ", but it was " + creditCardFundTransferCardLimit);

        Assert.assertTrue(pe.isOccurrenceAggregateLimitRequired(),
                "Limited Fungi... was expected to be a required field but it was not");
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                        "Limited Fungi... was expected to be " + defaultFungiOccurrenceAggregateLimit +
                                ", but it was " + fungiOccurrenceAggregateLimit);

        Assert.assertTrue(pe.isLossAssessmentLimitRequired(),
                "Loss Assessment was expected to be marked as a required field but it was not");
        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(defaultLossAssessmentLimit.equals(lossAssessmentLimit),
                        "Loss Assessment Limit was expected to be " + defaultLossAssessmentLimit +
                                ", but it was " + lossAssessmentLimit);

        Assert.assertFalse(pe.isOrdinanceOrLawLimitChecked(),
                "Ordinance Or Law Limit was not expected to be checked but it was");

        ordinanceOrLawLimit = pe.checkOrdinanceOrLaw().getOrdinanceOrLawLimit();
        Assert.assertTrue(defaultOrdinanceOrLawLimit.equals(ordinanceOrLawLimit),
                        "Ordinance or Law Limit was expected to be " + defaultOrdinanceOrLawLimit +
                                ", but it was " + ordinanceOrLawLimit);

        screenEnclosureHurricaneCoverageLimit = pe.checkScreenEnclosureHurricaneCoverage().getScreenEnclosureHurricaneCoverageLimit();
        Assert.assertTrue(defaultScreenEnclosureHurricaneCoverageLimit.equals(screenEnclosureHurricaneCoverageLimit),
                        "Screen Enclosure Hurricane Coverage was expected to be " + defaultScreenEnclosureHurricaneCoverageLimit +
                                ", but it was " + screenEnclosureHurricaneCoverageLimit);

        /* Water Back Up */
        Assert.assertFalse(pe.isWaterBackUpChecked(),
                "Water Back Up was not expected to be checked but it was");
        Assert.assertTrue(pe.checkWaterBackUp().isWaterBackUpChecked(),
                "Water Back Up as expected to be checked but it was not");

        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                        ", but it was " + waterBackUpLimit);

        /*Inflation Guard*/
        Assert.assertFalse(pe.isInflationGuardChecked(),
                "Inflation Guard was not expected to be checked but it was");
        Assert.assertTrue(pe.checkInflationGuard().isInflationGuardChecked(),
                "Inflation Guard was expected to be checked but it was not");
        inflationGuardAnnualIncrease = pe.getPercentageOfAnnualIncrease();
        Assert.assertTrue(defaultInflationGuardAnnualIncrease.equals(inflationGuardAnnualIncrease),
                "Inflation Guard % of Annual Increase was expected to be " + defaultInflationGuardAnnualIncrease +
                        ", but it was " + (inflationGuardAnnualIncrease));

        /* Liability Endorsements */
        ALHO3Coverages.ALHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();
        Assert.assertFalse(le.isPermittedIncidentalOccupancyLiabilityChecked(),
                "Permitted Incidental Occupancy Liability was not expected to be checked but it was");

        Assert.assertFalse(le.isAdditionalResidenceRentedToOthersChecked(),
                "Additional Residence Rented To Others was not expected to be checked but it was");
        le.checkAdditionalResidenceRentedToOthers().setLocationName(locationName).setNumberOfFamilies(numberOfFamilies)
                .addNewLocation()
                .setAddress1(newAddress1)
                .setCity(newAddressCity)
                .clickVerifyAddress()
                .clickVerifiedAddressForCreateAccountALHO3(1)
                .clickOkCoverages();

        String defaultBusinessActivity = le.setNumberOfFamilies("1 Family Residence").checkBusinessPursuits().getBusinessActivity();
        Assert.assertTrue(defaultBusinessActivity.equals("<none>"),
                "Business Activity was expected to default to <none> but it was " + defaultBusinessActivity);

        String watercraftLiabilityType = le.setBusinessActivity(businessActivity)
                .checkWatercraftLiability().getWatercraftType();
        Assert.assertTrue(watercraftLiabilityType.equals("<none>"),
                "Watercraft Type was expected to default to <none> but it was " + watercraftLiabilityType);

        personalPropertyLimit = le.setWatercraftType(watercraftType).clickCoverages()
                .setDwellingLimit("980,000").getPersonalPropertyLimit();
        Assert.assertTrue(personalPropertyLimit.equals("490,000"),
                "Personal Property Limit was expected to be 490,000 but it was " + personalLiabilityLimit);

        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                        "Personal Property Valuation Method was expected to be " + defaultPersonalPropertyValuationMethod +
                                ", but it was " + personalPropertyValuationMethod);

        creditCardFundTransferCardLimit = coverages.clickPropertyEndorsements().checkGuardianEndorsements().getCreditCardFundTransferForgeryCounterfeitMoneyLimitDiv();
        Assert.assertTrue(creditCardFundTransferCardLimit.equals("10,000"),
                        "Credit Card Limit was expected to be 10,000" +
                                ", but it was " + creditCardFundTransferCardLimit);

        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);
        pe.clickCoverages();
        dwellingLimit = coverages.getDwellingLimit();
        Assert.assertTrue(dwellingLimit.equals(dwellingLimit),
                        "Dwelling Limit was expected to be " + dwellingLimit +
                                ", but it was " + defaultDwellingLimit);

        Assert.assertFalse(coverages.isPersonalPropertyExcludedPresent(),
        "Personal Property Excluded was not expected to be present but it was");

        expectedPersonalPropertyLimit = "686,000";
        personalPropertyLimit = coverages.getPersonalPropertyLimitDiv();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                        "Personal Property Limit was expected to be " + expectedPersonalPropertyLimit +
                                ", but it was " + personalPropertyLimit);
        
        defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                        "Personal Property Valuation Method was expected to be " + defaultPersonalPropertyValuationMethod +
                                ", but it was " + personalPropertyValuationMethod);

        defaultPersonalLiabilityLimit = "300,000";
        personalLiabilityLimit = coverages.getPersonalLiabilityLimitDiv();
        Assert.assertTrue(defaultPersonalLiabilityLimit.equals(personalLiabilityLimit),
                        "Personal Liability Limit was expected to be " + defaultPersonalLiabilityLimit +
                                ", but it was " + personalLiabilityLimit);

        defaultMedicalPaymentsLimit = "5,000";
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                        "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                                ", but it was " + medicalPaymentsLimit);

        coverages.clickSaveDraftCoverages();
        Assert.assertFalse(coverages.setDwellingLimit("280,000").clickPropertyEndorsements().isGuardianEndorsementsDisplayed(),
        "Guardian Endorsements was not expected to be displayed but it was");

        coverages.clickSaveDraftCoverages();
    }

    @Test(description = "AL.HO3.ProductModel.Most.001", dependsOnMethods =
            { "createPersonAccountALHO3" })
    public void productModelMostPopularALHO3(ITestContext itc)
    {
        log(itc.getName());

//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";

//        firstname = String.format("Ricky%s", dateString);
//        lastname = String.format("Bobby%s", dateString);

        String policyType = "Homeowners (HO3)";
        String defaultOfferingSelection,
                expectedOfferingSelection = "Most Popular";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "60";
        String protectionClassCode,
                expectedProtectionClassCode = "5";
        String roofShapeType = "Gable";
        String dwellingLimit = "600000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "2%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "12,000";
        String  personalLiabilityLimit,
                expectedPersonalLiabilityLimit = "300,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "300,000",
                personalPropertyValuationMethod,
                expectedPersonalPropertyValuationMethod = "Replacement Cost Value",
                newPersonalPropertyValuationMethod = "Actual Cash Value";
        String lossOfUseSelection, expectedLossOfUseSelection = "20%";
        String lossOfUseLimit, expectedLossOfUseLimit = "120,000";
        String allOtherPerils, expectedAllOtherPerils = "2,500";
        String windHail, expectedWindHail = "2%",
                windHailDeductible, expectedWindHailDeductible = "12,000";
        String medicalPaymentsLimit, medicalPaymentsLimitDefault = "1,000";
        String fungiOccurrenceAggregateLimit,
                expectedFungiOccurrenceAggregateLimit = "25,000 / 50,000";
        String lossAssessmentLimit,
                expectedLossAssessmentLimit = "5,000";
        String ordinanceOrLawLimit, expectedOrdinanceOrLawLimit = "10%";
        String waterBackUpLimit, expectedWaterBackUpLimit = "5,000";
        String inflationGuardAnnualIncrease, expectedInflationGuardAnnualIncrease = "4%";

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
        ALHO3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberALHO3();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
        ALHO3Qualification qualification = ns.productTable.selectHomeowners();
        defaultOfferingSelection = qualification
                .setPolicyType(policyType)
                .getOfferingSelection();

        System.out.println(defaultOfferingSelection);
        Assert.assertTrue(defaultOfferingSelection.equals(expectedOfferingSelection),
                "Expected Offering Selection was " + expectedOfferingSelection +", but it was " + defaultOfferingSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        ALHO3Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant);
        dwelling.waitForProtectionClassCode(expectedProtectionClassCode);
        protectionClassCode = dwelling.getProtectionClassCode();
        Assert.assertTrue(expectedProtectionClassCode.equals(protectionClassCode),
                "Expected Protection Class Code was " + expectedProtectionClassCode + ", but it was " + protectionClassCode);

        ALHO3Coverages coverages = dwelling.next()
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
        System.out.println(otherStructuresLimit);

        /* Personal Liability */
        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
                "Personal Liability Limit was expected to be a required field but it was not");
        System.out.println(String.format("%s, %s", firstname, lastname));

        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
                "Personal Liability Limit dropdown was expected to be enabled but it was not");
        takeScreenShot(driver);

        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(expectedPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability limit was " + expectedPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);

        /* Personal Property Limit */
        Assert.assertTrue(coverages.isPersonalPropertyLimitRequired(),
                "Personal Property Limit was expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyLimitEnabled(),
                "Personal Property Limit was expected to be enabled but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                        "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                                ", but it was " + personalPropertyLimit);

        /* Personal Property Valuation */
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodRequired(),
                "Personal Property Valuation Method is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodEnabled(),
                "Personal Property Valuation Method is expected to be enabled but it is not");
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(expectedPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                        "Personal Property " + expectedPersonalPropertyValuationMethod +
                                ", but it was " + personalPropertyLimit);
        coverages.setPersonalPropertyValuationMethod(newPersonalPropertyValuationMethod);
        coverages.setPersonalPropertyValuationMethod(personalPropertyValuationMethod);
        
        /* Loss of Use */
        Assert.assertTrue(coverages.isLossOfUseSelectionRequired(),
                "Loss of Use Selection is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isLossOfUseSelectionEnabled(),
                "Loss of Use Selection is expected to be enabled but it was not");
        lossOfUseSelection = coverages.getLossOfUseSelection();
        Assert.assertTrue(expectedLossOfUseSelection.equals(lossOfUseSelection),
                        "Expected Loss Of Use Selection was " + expectedLossOfUseSelection +
                                ", but it was " + lossOfUseSelection);
        lossOfUseLimit = coverages.getLossOfUseLimit();
        System.out.println(expectedLossOfUseLimit);
        System.out.println(lossOfUseLimit);
        Assert.assertTrue(expectedLossOfUseLimit.equals(lossOfUseLimit),
                        "Expected Loss of Use Limit was " + expectedLossOfUseLimit +
                                ", but it was " + lossOfUseLimit);

        /* All Other Perils */
        Assert.assertTrue(coverages.isAllOtherPerilsRequired(),
                "All Other Perils is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isAllOtherPerilsEditable(),
                "All Other Perils is expected to be enabled but it was not");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(expectedAllOtherPerils.equals(allOtherPerils),
                        "All Other Perils is expected to be " + expectedAllOtherPerils +
                                ", but it was " + allOtherPerils);
        Assert.assertTrue(coverages.isWindHailRequired(),
                "Wind Hail is expected to be a required field, ");
        Assert.assertTrue(coverages.isWindHailEnabled(),
                "Wind Hail is expected to be enabled but it was not");

        /* Wind Hail */
        windHail = coverages.getWindHail();
        Assert.assertTrue(expectedWindHail.equals(windHail),
                        "Wind Hail is expected to be " + expectedWindHail +
                                ", but it was " + windHail);
        windHailDeductible = coverages.getWindHailDeductible();
        Assert.assertTrue(expectedWindHailDeductible.equals(windHailDeductible),
                        "Wind Hail deductible is expected to be " + expectedWindHailDeductible +
                                ", but it was " + windHailDeductible);

        /* Personal Liability Again */
        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
                "Personal Liability Limit was expected to be a required field but it was not");
        System.out.println(String.format("%s, %s", firstname, lastname));

        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
                "Personal Liability Limit dropdown was expected to be enabled but it was not");
        takeScreenShot(driver);

        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(expectedPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability limit was " + expectedPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);

        /* Medical Payments */
        Assert.assertFalse(coverages.isMedicalPaymentsLimitEditable(),
                "Medical Payments Limit was not expected to be editable but it is");
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(medicalPaymentsLimitDefault.equals(medicalPaymentsLimit),
                        "Medical Payments Limit expected was " + medicalPaymentsLimitDefault +
                                ", but it was " + medicalPaymentsLimit);
        ALHO3Coverages.ALHO3PropertyEndorsements pe = coverages.clickPropertyEndorsements();

        /* Fungi Occurrence/Aggregate */
        Assert.assertTrue(pe.isOccurrenceAggregateLimitRequired(),
                "Fungi Occurrence/Aggregate Limit was expected to be required but it was not");
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(expectedFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                        "Fungi Occurrence/Aggregate Limit was expected to be " + expectedFungiOccurrenceAggregateLimit +
                                ", but it was " + fungiOccurrenceAggregateLimit);
         Assert.assertTrue(pe.isOccurrenceAggregateLimitEditable(),
                 "Fungi Occurrence/Aggregate Limit was expected to be editable bur it was not");

         /* Loss Assessment */
        Assert.assertTrue(pe.isLossAssessmentLimitRequired(),
                "Loss Assessment Limit was expected to be required but it was not");
        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                        ", but it was " + lossAssessmentLimit);
        Assert.assertTrue(pe.isLossAssessmentLimitEditable(),
                "Loss Assessment Limit was expected to be editable bur it was not");

        /* Ordinance or Law */
        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Ordinance or Law Limit was expected to be " + expectedOrdinanceOrLawLimit +
                        ", but it was " + ordinanceOrLawLimit);
        Assert.assertFalse(pe.isOrdinanceOrLawLimitEditable(),
                "Ordinance or Law Limit was not expected to be editable bur it was");

        /* Water Backup */
        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(expectedWaterBackUpLimit.equals(waterBackUpLimit),
                "Water Back Up Limit is expected to be " + expectedWaterBackUpLimit +
                        ", but it was " + waterBackUpLimit);
        Assert.assertFalse(pe.isWaterBackUpLimitEditable(),
                "Water Back Up Limit was not expected to be editable bur it was");

        /* Inflation Guard */
        pe.isInflationGuardChecked();
        inflationGuardAnnualIncrease = pe.getPercentageOfAnnualIncrease();
        Assert.assertTrue(expectedInflationGuardAnnualIncrease.equals(inflationGuardAnnualIncrease),
                        "Inflation Guard Annual Increase was expected to be " + expectedInflationGuardAnnualIncrease +
                                ", but it was " + inflationGuardAnnualIncrease);

        ALHO3Coverages.ALHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();
        coverages.clickSaveDraftCoverages();
    }

    @Test(description = "AL.HO3.ProductModel.More.001", dependsOnMethods =
            { "createPersonAccountALHO3" })
    public void productModelMoreCoverageALHO3(ITestContext itc)
    {

    /* Declare Variables */
//        String firstname = "ALHO3Ricky0308042946";
//        String lastname = "Bobby0308042946";
//        firstname = "ALHO3Ricky0404111732";
//        lastname = "Bobby0404111732";

        String policyType = "Homeowners (HO3)";
        String expectedOfferingSelection, offeringSelection = "More Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "60";
        String protectionClassCode,
                expectedProtectionClassCode = "5";
        String roofShapeType = "Gable";
        String dwellingLimit = "600000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "2%";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "420,000";
        String personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        String lossOfUseSelection, expectedLossOfUseSelection = "20%";
        String personalLiabilityLimit,
                expectedPersonalLiabilityLimit = "300,000";
        String creditCardLimit, defaultCreditCardLimit = "5,000";
        String fungiOccurrenceAggregateLimit,
                expectedFungiOccurrenceAggregateLimit = "50,000 / 50,000";
        String lossAssessmentLimit,
                expectedLossAssessmentLimit = "10,000";
        String ordinanceOrLawLimit, expectedOrdinanceOrLawLimit = "10%";
        String waterBackUpLimit, expectedWaterBackUpLimit = "5,000";
        String inflationGuardAnnualIncrease, expectedInflationGuardAnnualIncrease = "4%";

    /* Begin Test */
        log(itc.getName());

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
        ALHO3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberALHO3()
                .clickTransactionNumber();
        System.out.println(String.format("%s, %s", firstname, lastname));

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickCopySubmission();
        ALHO3Qualification qualification = new ALHO3Qualification(sh);

        expectedOfferingSelection = qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection)
                .getOfferingSelection();

        System.out.println(expectedOfferingSelection);
        Assert.assertTrue(expectedOfferingSelection.equals(offeringSelection),
                "Expected Offering Selection was " + offeringSelection + ", but it was " + expectedOfferingSelection);

        ALHO3Coverages coverages = afs.clickCoveragesALHO3();
        coverages.setDwellingLimit(dwellingLimit);

        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +
                        ", but it was " + otherStructuresPercentage);


        Assert.assertTrue(coverages.isPersonalPropertyExcludedRequired(),
                "Personal Property Excluded was expected to be a required field but it was not");
        coverages.setPersonalPropertyExcluded("false");

    /* Personal Property Limit */
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                        "Personal Property Limit was expected to be " + expectedPersonalPropertyLimit +
                                ", but it was " + personalPropertyLimit);
        Assert.assertTrue(coverages.isPersonalPropertyLimitRequired(),
                "Personal Property Limit was expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyLimitEnabled(),
                "Personal Property Limit was expected to be enabled but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

    /* Personal Property Valuation */
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodRequired(),
                "Personal Property Valuation Method is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodEnabled(),
                "Personal Property Valuation Method is expected to be enabled but it is not");
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property Valuation Method was expected to be " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyValuationMethod);

    /* Loss of Use */
        Assert.assertTrue(coverages.isLossOfUseSelectionRequired(),
                "Loss of Use Selection is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isLossOfUseSelectionEnabled(),
                "Loss of Use Selection is expected to be enabled but it was not");
        lossOfUseSelection = coverages.getLossOfUseSelection();
        Assert.assertTrue(expectedLossOfUseSelection.equals(lossOfUseSelection),
                "Expected Loss Of Use Selection was " + expectedLossOfUseSelection +
                        ", but it was " + lossOfUseSelection);

    /* Personal Liability */
        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(expectedPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability limit was " + expectedPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);

    /* Property Endorsements */
        ALHO3Coverages.ALHO3PropertyEndorsements pe = coverages.clickPropertyEndorsements();
        creditCardLimit = pe.getCreditCardFundTransferForgeryCounterfeitMoneyLimit();
        Assert.assertTrue(defaultCreditCardLimit.equals(creditCardLimit),
                "Credit Card, Fund Transfer Card... was expected to be " + defaultCreditCardLimit +
                        ", but it was " + creditCardLimit);

    /* Fungi Occurrence/Aggregate */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(expectedFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                "Fungi Occurrence/Aggregate Limit was expected to be " + expectedFungiOccurrenceAggregateLimit +
                        ", but it was " + fungiOccurrenceAggregateLimit);

    /* Loss Assessment */
        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                        ", but it was " + lossAssessmentLimit);

    /* Ordinance or Law */
        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Ordinance or Law Limit was expected to be " + expectedOrdinanceOrLawLimit +
                        ", but it was " + ordinanceOrLawLimit);
        Assert.assertFalse(pe.isOrdinanceOrLawLimitEditable(),
                "Ordinance or Law Limit was not expected to be editable bur it was");

    /* Water Backup */
        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(expectedWaterBackUpLimit.equals(waterBackUpLimit),
                "Water Back Up Limit is expected to be " + expectedWaterBackUpLimit +
                        ", but it was " + waterBackUpLimit);
        Assert.assertFalse(pe.isWaterBackUpLimitEditable(),
                "Water Back Up Limit was not expected to be editable bur it was");

    /* Inflation Guard */
        pe.isInflationGuardChecked();
        inflationGuardAnnualIncrease = pe.getPercentageOfAnnualIncrease();
        Assert.assertTrue(expectedInflationGuardAnnualIncrease.equals(inflationGuardAnnualIncrease),
                "Inflation Guard Annual Increase was expected to be " + expectedInflationGuardAnnualIncrease +
                        ", but it was " + inflationGuardAnnualIncrease);

        coverages.clickSaveDraftCoverages();
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
