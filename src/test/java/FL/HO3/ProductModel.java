package FL.HO3;


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
import pageobjects.FLHO3.*;
import pageobjects.Login;
import pageobjects.WizardPanelBase.*;

public class ProductModel extends BaseTest
{
    private WebDriver driver;
    private Login login;
    private FLHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private String firstname, lastname;

    @BeforeMethod
    public void beforeMethod()
    {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        String user = "Su", password = "";
        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        login = new Login(sh, sessionInfo);
        login.load();
        login.isLoaded();
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));

        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
    }

    @Test(description = "Creates account for Florida HO3 product")
    public void createPersonAccountFLHO3(ITestContext itc)
    {
        log(itc.getName());
        firstname = String.format("FLHO3Ricky%s", dateString);
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
                organizationName = "We Insure",
                organizationType = Organizations.OrganizationTypes.AGENCY.value,
                producerCode = "523-23-21531 We Insure(Jacksonville)";

        enterAccountInformation = new FLHO3EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLHO3();
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
                    .clickOrganizationSearch()
                    .setOrganizationName(organizationName)
                    .setOrganizationType(organizationType)
                    .clickSearchButton()
                    .clickSelectOrganizationButton()
                    .setProducerCode(producerCode);

            String expectedAddress = createAccount.getAddressLine1();
            Assert.assertTrue(expectedAddress.toUpperCase().equals(address.toUpperCase()),
            "Address expected was " + address + " but it was " + expectedAddress);
            Assert.assertTrue(createAccount.getZipCode().contains(zipcode),
                    "Zipcode expected was " + createAccount.getZipCode() +
                            ", but it was " + zipcode);

            FLHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            log(e.getMessage());
            throw new WebDriverException(e);
        }
    }

    @Test
    public void productModelFLHO3LessCoverage(ITestContext itc)
    {

    }

    @Test(description = "FL.HO3.ProductModel.MostCoverage002"/*, dependsOnMethods =
            { "createPersonAccountFLHO3" }*/)
    public void productModelMostCoverageFLHO3(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
        firstname = "FLHO3Ricky0224102737";
        lastname = "Bobby0224102737";

        String policyType = "Homeowners (HO3)";
        String defaultOfferingSelection,
                expectedOfferingSelection = "Most Popular";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String roofShapeType = "Gable";
        String dwellingLimit = "400000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "2%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "8,000";
        String  personalLiabilityLimit,
                defaultPersonalLiabilityLimit = "300,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "200,000",
                personalPropertyValuationMethod,
                expectedPersonalPropertyValuationMethod = "Replacement Cost Value",
                newPersonalPropertyValuationMethod = "Actual Cash Value";
        String lossOfUseSelection, expectedLossOfUseSelection = "11%";
        String lossOfUseLimit, expectedLossOfUseLimit = "44,000";
        String allOtherPerils, defaultAllOtherPerils = "2,500";
        String windHail, expectedWindHail = "2%",
                windHailDeductible, expectedWindHailDeductible = "12,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "3,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "400";

        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "25,000 / 50,000";
        String lossAssessmentLimit,
                expectedLossAssessmentLimit = "1,000";
        String ordinanceOrLawLimit, defaultOrdinanceOrLawLimit = "25%";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";
        String inflationGuardAnnualIncrease, defaultInflationGuardAnnualIncrease = "4%";

        /* Begin Test */
        FLHO3NavigationBar nb = new FLHO3NavigationBar(sh);
        enterAccountInformation = new FLHO3EnterAccountInformation(sh);
        FLHO3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLHO3();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO3NewSubmission ns = new FLHO3NewSubmission(sh);
        FLHO3Qualification qualification = ns.productTable.selectHomeowners();
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

        FLHO3Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setTerritoryCode("005")    // This line had to be added because test would not proceed without this value
                .setBCEG("05")              // This line had to be added because test would not proceed without this value
                .setProtectionClassCode(protectionClassCode);

        FLHO3Coverages coverages = dwelling.next()
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
        Assert.assertFalse(coverages.isOtherStructuresLimitEditable(),
                "Other Structures Limit was not expected to be editable but it was");

        /* Personal Property */
        Assert.assertFalse(coverages.isPersonalPropertyExcluded(),
                "Personal Property Excluded radio button was expected to be 'No' but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyLimitRequired(),
                "Personal Property Limit was expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyLimitEnabled(),
                "Personal Property Limit was expected to be enabled but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodRequired(),
                "Personal Property Valuation Method is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodEnabled(),
                "Personal Property Valuation Method is expected to be enabled but it is not");
        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(expectedPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + expectedPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyLimit);

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
        Assert.assertTrue(expectedLossOfUseLimit.equals(lossOfUseLimit),
                "Expected Loss of Use Limit was " + expectedLossOfUseLimit +
                        ", but it was " + lossOfUseLimit);
        Assert.assertFalse(coverages.isLossOfUseLimitEditable(),
                "Loss Of Use Limit was not expected to be editable, but it was");

        /* Section I Deductibles */
        Assert.assertFalse(coverages.isWindExcluded(),
        "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");
        Assert.assertTrue(coverages.isAllOtherPerilsRequired(),
                "All Other Perils is expected to be a required field but it was not");
        Assert.assertTrue(coverages.isAllOtherPerilsEditable(),
                "All Other Perils is expected to be enabled but it was not");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                        "All Other Perils was expected to be " + defaultAllOtherPerils +
                                ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricane();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                        "" + defaultHurricaneDeductible +
                                ", but it was " + hurricaneDeductible);

        /* Personal Liability */
        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
                "Personal Liability Limit was expected to be a required field but it was not");
        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
                "Personal Liability Limit dropdown was expected to be enabled but it was not");
        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(defaultPersonalLiabilityLimit.equals(personalLiabilityLimit),
                "Personal Liability limit was " + defaultPersonalLiabilityLimit +
                        ", but it was " + personalLiabilityLimit);
        
        /* Medical Payments */
        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit expected was " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);
        FLHO3Coverages.FLHO3PropertyEndorsements pe = coverages.clickPropertyEndorsements();

        /* Property Endorsements */
        Assert.assertFalse(pe.isGuardianEndorsementChecked(),
                "Guardian Endorsement was not expected to be checked but it was");
        Assert.assertTrue(pe.isWhenSafeChecked(),
                "When Safe was expected to be checked but it was not");
        whenSafeCreditValue = pe.getCreditValue();
        Assert.assertTrue(defaultWhenSafeCreditValue.equals(whenSafeCreditValue),
                        "When Safe Credit Value was expected to be " + defaultWhenSafeCreditValue +
                                ", but it was " + whenSafeCreditValue);
        Assert.assertFalse(pe.isOtherStructuresIncreasedCoverageChecked(),
                "Other Structures Increased Coverage was not expected to be checked but it was");
        Assert.assertFalse(pe.isScheduledPersonalPropertyChecked(),
                "Scheduled Personal Property was not expected to be checked but it was");
        Assert.assertFalse(pe.isCreditCardFundTransferForgeryCounterfeitChecked(),
                "Credit Card, Fund Transfer, Forgery, and Counterfeit was expected to be checked but it was not");

        /* Limited Fungi, Wet or dry Rot, or Bacteria */
        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
        Assert.assertTrue(defaultFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
                        "Limit Fungi, Wet or Dry Rot... Occurrence/Aggregate Limit " + defaultFungiOccurrenceAggregateLimit +
                                ", but it was " + fungiOccurrenceAggregateLimit);

        /* Loss Assessment */
        lossAssessmentLimit = pe.getLossAssessmentLimit();
        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
                "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
                        ", but it was " + lossAssessmentLimit);

        /* Ordinance or Law */
        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
        Assert.assertTrue(defaultOrdinanceOrLawLimit.equals(ordinanceOrLawLimit),
                "Ordinance or Law Limit was expected to be " + defaultOrdinanceOrLawLimit +
                        ", but it was " + ordinanceOrLawLimit);

        Assert.assertFalse(pe.isScreenEnclosureHurricaneCoverageChecked(),
                "Screen Enclosure Hurricane Coverage was expected to be checked but it was not");

        /* Water Back Up */
        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Expected Water Back Up Limit was " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);

        /* Inflation Guard */
        inflationGuardAnnualIncrease = pe.getPercentageOfAnnualIncrease();
        Assert.assertTrue(defaultInflationGuardAnnualIncrease.equals(inflationGuardAnnualIncrease),
                        "Inflation Guard % of Annual Increase was expected to be " + defaultInflationGuardAnnualIncrease +
                                ", but it was " + (inflationGuardAnnualIncrease));

        Assert.assertFalse(pe.isSinkholeLossCoverageChecked(),
                "Sinkhole Loss Coverage was not expected to be checked but it was");

        /* Liability Endorsements */
        FLHO3Coverages.FLHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();
        Assert.assertFalse(le.isPermittedIncidentalOccupancyLiabilityChecked(),
                "Permitted Incidental Occupancy was expected to not be checked but it was");
        Assert.assertFalse(le.isAnimalLiabilityChecked(),
                "Animal Liability was expected to be checked but it was not");
        Assert.assertFalse(le.isAdditionalResidenceRentedToOthersChecked(),
                "Additional Residence Rented To Others was not expected to be checked but it was");
        Assert.assertFalse(le.isBusinessPursuitsChecked(),
                "Business Pursiots was not expected to be checked but it was");
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
