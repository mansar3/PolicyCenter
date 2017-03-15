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

public class ProductModelFLDP3 extends BaseTest
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

    @Test(description = "Creates account for Florida DP3 product")
    public void createPersonAccountFLDP3(ITestContext itc)
    {
        log(itc.getName());
        firstname = String.format("FLDP3Ricky%s", dateString);
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

    @Test
    public void productModelLessCoverageFLDP3(ITestContext itc)
    {

    }

    @Test(description = "FL.DP3.ProductModel.MostCoverage002"/*, dependsOnMethods =
            { "createPersonAccountFLDP3" }*/)
    public void productModelMostPopularFLDP3(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
        firstname = "FLDP3Ricky0314043331";
        lastname = "Bobby0314043331";

        String policyType = "Dwelling Fire (DP3)";
        String offeringSelection = "Most Popular";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "1 Family Residence";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Tenant Occupied";
        String roofShapeType = "Gable";
        String dwellingLimit = "350000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "10%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "35,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "5,000";
        String fairRentalValuePercentage,
                defaultFairRentalValuePercentage = "10%";
        String fairRentalValueLimit,
                defaultFairRentalValueLimit = "35,000";
        String premisesLiabilityLimit,
                defaultPremisesLiabilityLimit = "300,000";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String whenSafeCreditPercentage, defaultWhenSafeCreditPercentage = "5%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "350";

        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "25,000 / 50,000";
        String waterBackUpLimit, defaultWaterBackUpLimit = "5,000";

        /* Begin Test */
        FLDP3NavigationBar nb = new FLDP3NavigationBar(sh);
        enterAccountInformation = new FLDP3EnterAccountInformation(sh);
        FLDP3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLDP3();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
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
        Assert.assertFalse(coverages.isPersonalPropertyExcluded(),
                "Personal Property Excluded radio button was expected to be 'No' but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

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
        hurricaneDeductible = coverages.getHurricane();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "" + defaultHurricaneDeductible +
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

        Assert.assertTrue(pe.isTheftCoverageChecked(),
                "Theft Coverage was expected to be checked but it was not");

        Assert.assertTrue(pe.isWaterBackUpChecked(),
                "Water Back Up was expected to be checked but it was not");

        waterBackUpLimit = pe.getWaterBackUpLimit();
        Assert.assertTrue(defaultWaterBackUpLimit.equals(waterBackUpLimit),
                        "Water Back Up Limit was expected to be " + defaultWaterBackUpLimit +
                                ", but it was " + waterBackUpLimit);

        Assert.assertFalse(pe.isSinkholeLossCoverageChecked(),
                "Sinkhole Loss Coverage was not expected to be checked but it was");
    }

    @Test(description = "FL.DP3.ProductModel.MoreCoverage003"/*, dependsOnMethods =
            { "createPersonAccountFLDP3" }*/)
    public void productModelMoreCoverageFLDP3(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
        firstname = "FLDP3Ricky0301100306";
        lastname = "Bobby0301100306";

        String policyType = "Dwelling Fire (DP3)";
        String offeringSelection = "More Coverage";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "200";
        String protectionClassCode = "1X";
        String residenceType = "1 Family Residence";
        String dwellingUsage = "Primary";
        String dwellingOccupance = "Tenant Occupied";
        String roofShapeType = "Gable";
        String dwellingLimit = "400000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "10%";
        String otherStructuresLimit,
                expectedOtherStructuresLimit = "40,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "10,000";
        String fairRentalValuePercentage,
                defaultFairRentalValuePercentage = "10%";
        String fairRentalValueLimit,
                defaultFairRentalValueLimit = "40,000";
        String premisesLiabilityLimit,
                defaultPremisesLiabilityLimit = "300,000";
        String allOtherPerils, defaultAllOtherPerils = "1,000";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "1,000";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String whenSafeCreditPercentage, defaultWhenSafeCreditPercentage = "5%";
        String whenSafeCreditValue, defaultWhenSafeCreditValue = "400";

        String fungiOccurrenceAggregateLimit,
                defaultFungiOccurrenceAggregateLimit = "50,000 / 50,000";

        /* Begin Test */
        FLDP3NavigationBar nb = new FLDP3NavigationBar(sh);
        FLDP3SearchAccounts sa = nb.clickSearchAccount();
        FLDP3AccountFileSummary afs = sa.setFirstName(firstname)
                .setLastName(lastname)
                .clickSearchButton()
                .clickAccountNumberSearchAccount();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
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
        Assert.assertFalse(coverages.isPersonalPropertyExcluded(3),
                "Personal Property Excluded radio button was expected to be 'No' but it was not");
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
                        ", but it was " + personalPropertyLimit);

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
        Assert.assertFalse(coverages.isWindExcluded(3),
                "Deductibles Wind Excluded was expected to be 'No' but it was 'Yes'");
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricane();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "" + defaultHurricaneDeductible +
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

        Assert.assertTrue(pe.isTheftCoverageChecked(),
                "Theft Coverage was expected to be checked but it was not");

        Assert.assertFalse(pe.isSinkholeLossCoverageChecked(),
        "Sinkhole Loss Coverage was not expected to be checked but it was");
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
