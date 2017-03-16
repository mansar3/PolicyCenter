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
import pageobjects.WizardPanelBase.*;

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

        String user = "Su", password = "";
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
                organizationName = "We Insure",
                organizationType = Organizations.OrganizationTypes.AGENCY.value,
                producerCode = "523-23-21531 We Insure(Jacksonville)";

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

    @Test
    public void productModelFLHO6LessCoverage(ITestContext itc)
    {

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
        hurricaneDeductible = coverages.getHurricane();
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
