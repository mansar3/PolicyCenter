package SC.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.SCHO3.*;
import pageobjects.Login;
import pageobjects.WizardPanelBase.MyActivities;
import pageobjects.WizardPanelBase.Organizations;

/**
 * Created by afilizzola on 2/22/17.
 */

public class ProductModelSCHO3 extends BaseTest
{
    private WebDriver driver;
    private Login login;
    private SCHO3EnterAccountInformation enterAccountInformation;
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
        login = new Login(sh, sessionInfo);
        login.load();
        login.isLoaded();
        String user = "Su", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates account for SCHO3 product")
    public void createPersonAccountSCHO3(ITestContext itc)
    {
        firstname = String.format("SCHO3Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
        SCHO3NavigationBar nb = new SCHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String  country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "2561234567",
                primaryPhone = "Work",
                address = "3222 Sand Marsh Ln",
                city = "Mount Pleasant",
                state = "South Carolina",
                county = "Charlestone",
                zipcode = "29466",
                addressType = "Home",
                ssn = "777-12-3456",
                organizationName = "We Insure",
                organizationType = Organizations.OrganizationTypes.AGENCY.value,
                producerCode = "523-23-21531 We Insure(Jacksonville)";

        enterAccountInformation = new SCHO3EnterAccountInformation(sh);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        SCHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountSCHO3();
        log(String.format("Creating new account: %s", dateString));

        try {
            createAccount
                    .setCountry(country)
                    .setDateOfBirth(dob)
                    .setMobilePhone(phoneNumber)
                    .setPrimaryPhone(primaryPhone)
                    .setAddressLine1(address)
                    .setCity(city)
                    .setCounty(county)
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
            Assert.assertTrue(createAccount.getZipCode().equals(zipcode),
                    "Zipcode expected was " + createAccount.getZipCode() +
                            ", but it was " + zipcode);

            SCHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();

            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        }
        catch (Exception e)
        {
            throw new WebDriverException(e);
        }
    }

//    @Test(description = "AL.HO3.ProductModel.Most.001"/*, dependsOnMethods =
//            { "createPersonAccountSCHO3" }*/)
//    public void productModelMostPopular(ITestContext itc)
//    {
//        log(itc.getName());
//
//        String firstname = "Ricky0209015449";
//        String lastname = "Bobby0209015449";
////        firstname = String.format("Ricky%s", dateString);
////        lastname = String.format("Bobby%s", dateString);
//
//        String policyType = "Homeowners (HO3)";
//        String defaultOfferingSelection,
//                expectedOfferingSelection = "Most Popular";
//        String county = "Mobile";
//        String yearBuilt = "2000";
//        String distanceToFireHydrant = "60";
//        String protectionClassCode,
//                expectedProtectionClassCode = "5";
//        String roofShapeType = "Gable";
//        String dwellingLimit = "600000";
//        String otherStructuresPercentage,
//                expectedOtherStructuresPercentage = "2%";
//        String otherStructuresLimit,
//                expectedOtherStructuresLimit = "12,000";
//        String  personalLiabilityLimit,
//                expectedPersonalLiabilityLimit = "300,000";
//        String personalPropertyLimit,
//                expectedPersonalPropertyLimit = "300,000",
//                personalPropertyValuationMethod,
//                expectedPersonalPropertyValuationMethod = "Replacement Cost Value",
//                newPersonalPropertyValuationMethod = "Actual Cash Value";
//        String lossOfUseSelection, expectedLossOfUseSelection = "20%";
//        String lossOfUseLimit, expectedLossOfUseLimit = "120,000";
//        String allOtherPerils, expectedAllOtherPerils = "2,500";
//        String windHail, expectedWindHail = "2%",
//                windHailDeductible, expectedWindHailDeductible = "12,000";
//        String medicalPaymentsLimit, medicalPaymentsLimitDefault = "1,000";
//        String fungiOccurrenceAggregateLimit,
//                expectedFungiOccurrenceAggregateLimit = "25,000 / 50,000";
//        String lossAssessmentLimit,
//                expectedLossAssessmentLimit = "5,000";
//        String ordinanceOrLawLimit, expectedOrdinanceOrLawLimit = "10%";
//        String waterBackUpLimit, expectedWaterBackUpLimit = "5,000";
//        String inflationGuardAnnualIncrease, expectedInflationGuardAnnualIncrease = "4%";
//
//
//
//        SCHO3NavigationBar nb = new SCHO3NavigationBar(sh);
//        SCHO3SearchAccounts sa = nb.clickSearchAccount();
//        SCHO3AccountFileSummary afs = sa.setFirstName(firstname)
//                .setLastName(lastname)
//                .clickSearchButton()
//                .clickAccountNumberSearchAccount();
//
//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();
//        SCHO3NewSubmission ns = new SCHO3NewSubmission(sh);
//        SCHO3Qualification qualification = ns.productTable.selectHomeowners();
//        defaultOfferingSelection = qualification
//                .setPolicyType(policyType)
//                .getOfferingSelection();
//
//        System.out.println(defaultOfferingSelection);
//        Assert.assertTrue(defaultOfferingSelection.equals(expectedOfferingSelection),
//                "Expected Offering Selection was " + expectedOfferingSelection +", but it was " + defaultOfferingSelection);
//
//        // Answer 'no' to all 8 questions
//        for (int i=0; i< 8; i++) {
//            qualification.questionnaire.answerNo(i+1);
//        }
//
//        SCHO3Dwelling dwelling = qualification
//                .next()
//                .next()
//                .editLocation()
//                .setCounty(county)
//                .clickOk()
//                .setYearBuilt(yearBuilt)
//                .setDistanceToFireHydrant(distanceToFireHydrant);
//        dwelling.waitForProtectionClassCode(expectedProtectionClassCode);
//        protectionClassCode = dwelling.getProtectionClassCode();
//        Assert.assertTrue(expectedProtectionClassCode.equals(protectionClassCode),
//                "Expected Protection Class Code was " + expectedProtectionClassCode + ", but it was " + protectionClassCode);
//
//        SCHO3Coverages coverages = dwelling.next()
//                .clickWindMitigation()
//                .setRoofShapeType(roofShapeType)
//                .next()
//                .setDwellingLimit(dwellingLimit);
//        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
//        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
//                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +
//                        ", but it was " + otherStructuresPercentage);
//
//        otherStructuresLimit = coverages.getOtherStructuresLimit();
//        Assert.assertTrue(expectedOtherStructuresLimit.equals(otherStructuresLimit),
//                "Expected Other Structures Limit was " + expectedOtherStructuresLimit + ", but it was " +
//                        otherStructuresLimit);
//        System.out.println(otherStructuresLimit);
//
//        /* Personal Liability */
//        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
//                "Personal Liability Limit was expected to be a required field but it was not");
//        System.out.println(String.format("%s, %s", firstname, lastname));
//
//        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
//                "Personal Liability Limit dropdown was expected to be enabled but it was not");
//        takeScreenShot(driver);
//
//        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
//        Assert.assertTrue(expectedPersonalLiabilityLimit.equals(personalLiabilityLimit),
//                "Personal Liability limit was " + expectedPersonalLiabilityLimit +
//                        ", but it was " + personalLiabilityLimit);
//
//        /* Personal Property Limit */
//        Assert.assertTrue(coverages.isPersonalPropertyLimitRequired(),
//                "Personal Property Limit was expected to be a required field but it was not");
//        Assert.assertTrue(coverages.isPersonalPropertyLimitEnabled(),
//                "Personal Property Limit was expected to be enabled but it was not");
//        personalPropertyLimit = coverages.getPersonalPropertyLimit();
//        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
//                "Personal Property limit was expected to be " + expectedPersonalPropertyLimit +
//                        ", but it was " + personalPropertyLimit);
//
//        /* Personal Property Valuation */
//        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodRequired(),
//                "Personal Property Valuation Method is expected to be a required field but it was not");
//        Assert.assertTrue(coverages.isPersonalPropertyValuationMethodEnabled(),
//                "Personal Property Valuation Method is expected to be enabled but it is not");
//        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
//        Assert.assertTrue(expectedPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
//                "Personal Property " + expectedPersonalPropertyValuationMethod +
//                        ", but it was " + personalPropertyLimit);
//        coverages.setPersonalPropertyValuationMethod(newPersonalPropertyValuationMethod);
//        coverages.setPersonalPropertyValuationMethod(personalPropertyValuationMethod);
//
//        /* Loss of Use */
//        Assert.assertTrue(coverages.isLossOfUseSelectionRequired(),
//                "Loss of Use Selection is expected to be a required field but it was not");
//        Assert.assertTrue(coverages.isLossOfUseSelectionEnabled(),
//                "Loss of Use Selection is expected to be enabled but it was not");
//        lossOfUseSelection = coverages.getLossOfUseSelection();
//        Assert.assertTrue(expectedLossOfUseSelection.equals(lossOfUseSelection),
//                "Expected Loss Of Use Selection was " + expectedLossOfUseSelection +
//                        ", but it was " + lossOfUseSelection);
//        lossOfUseLimit = coverages.getLossOfUseLimit();
//        System.out.println(expectedLossOfUseLimit);
//        System.out.println(lossOfUseLimit);
//        Assert.assertTrue(expectedLossOfUseLimit.equals(lossOfUseLimit),
//                "Expected Loss of Use Limit was " + expectedLossOfUseLimit +
//                        ", but it was " + lossOfUseLimit);
//
//        /* All Other Perils */
//        Assert.assertTrue(coverages.isAllOtherPerilsRequired(),
//                "All Other Perils is expected to be a required field but it was not");
//        Assert.assertTrue(coverages.isAllOtherPerilsEditable(),
//                "All Other Perils is expected to be enabled but it was not");
//        allOtherPerils = coverages.getAllOtherPerils();
//        Assert.assertTrue(expectedAllOtherPerils.equals(allOtherPerils),
//                "All Other Perils is expected to be " + expectedAllOtherPerils +
//                        ", but it was " + allOtherPerils);
//        Assert.assertTrue(coverages.isWindHailRequired(),
//                "Wind Hail is expected to be a required field, ");
//        Assert.assertTrue(coverages.isWindHailEnabled(),
//                "Wind Hail is expected to be enabled but it was not");
//
//        /* Wind Hail */
//        windHail = coverages.getWindHail();
//        Assert.assertTrue(expectedWindHail.equals(windHail),
//                "Wind Hail is expected to be " + expectedWindHail +
//                        ", but it was " + windHail);
//        windHailDeductible = coverages.getWindHailDeductible();
//        Assert.assertTrue(expectedWindHailDeductible.equals(windHailDeductible),
//                "Wind Hail deductible is expected to be " + expectedWindHailDeductible +
//                        ", but it was " + windHailDeductible);
//
//        /* Personal Liability Again */
//        Assert.assertTrue(coverages.isPersonalLiabilityLimitRequired(),
//                "Personal Liability Limit was expected to be a required field but it was not");
//        System.out.println(String.format("%s, %s", firstname, lastname));
//
//        Assert.assertTrue(coverages.isPersonalLiabilityLimitEnabled(),
//                "Personal Liability Limit dropdown was expected to be enabled but it was not");
//        takeScreenShot(driver);
//
//        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
//        Assert.assertTrue(expectedPersonalLiabilityLimit.equals(personalLiabilityLimit),
//                "Personal Liability limit was " + expectedPersonalLiabilityLimit +
//                        ", but it was " + personalLiabilityLimit);
//
//        /* Medical Payments */
//        Assert.assertFalse(coverages.isMedicalPaymentsLimitEditable(),
//                "Medical Payments Limit was not expected to be editable but it is");
//        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
//        Assert.assertTrue(medicalPaymentsLimitDefault.equals(medicalPaymentsLimit),
//                "Medical Payments Limit expected was " + medicalPaymentsLimitDefault +
//                        ", but it was " + medicalPaymentsLimit);
//        SCHO3Coverages.SCHO3PropertyEndorsements pe = coverages.clickPropertyEndorsements();
//
//        /* Fungi Occurrence/Aggregate */
//        Assert.assertTrue(pe.isOccurrenceAggregateLimitRequired(),
//                "Fungi Occurrence/Aggregate Limit was expected to be required but it was not");
//        fungiOccurrenceAggregateLimit = pe.getOccurrenceAggregateLimit();
//        Assert.assertTrue(expectedFungiOccurrenceAggregateLimit.equals(fungiOccurrenceAggregateLimit),
//                "Fungi Occurrence/Aggregate Limit was expected to be " + expectedFungiOccurrenceAggregateLimit +
//                        ", but it was " + fungiOccurrenceAggregateLimit);
//        Assert.assertTrue(pe.isOccurrenceAggregateLimitEditable(),
//                "Fungi Occurrence/Aggregate Limit was expected to be editable bur it was not");
//
//         /* Loss Assessment */
//        Assert.assertTrue(pe.isLossAssessmentLimitRequired(),
//                "Loss Assessment Limit was expected to be required but it was not");
//        lossAssessmentLimit = pe.getLossAssessmentLimit();
//        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
//                "Loss Assessment Limit was expected to be " + expectedLossAssessmentLimit +
//                        ", but it was " + lossAssessmentLimit);
//        Assert.assertTrue(pe.isLossAssessmentLimitEditable(),
//                "Loss Assessment Limit was expected to be editable bur it was not");
//
//        /* Ordinance or Law */
//        ordinanceOrLawLimit = pe.getOrdinanceOrLawLimit();
//        Assert.assertTrue(expectedLossAssessmentLimit.equals(lossAssessmentLimit),
//                "Ordinance or Law Limit was expected to be " + expectedOrdinanceOrLawLimit +
//                        ", but it was " + ordinanceOrLawLimit);
//        Assert.assertFalse(pe.isOrdinanceOrLawLimitEditable(),
//                "Ordinance or Law Limit was not expected to be editable bur it was");
//
//        /* Water Backup */
//        waterBackUpLimit = pe.getWaterBackUpLimit();
//        Assert.assertTrue(expectedWaterBackUpLimit.equals(waterBackUpLimit),
//                "Water Back Up Limit is expected to be " + expectedWaterBackUpLimit +
//                        ", but it was " + waterBackUpLimit);
//        Assert.assertFalse(pe.isWaterBackUpLimitEditable(),
//                "Water Back Up Limit was not expected to be editable bur it was");
//
//        /* Inflation Guard */
//        pe.isInflationGuardChecked();
//        inflationGuardAnnualIncrease = pe.getPercentageOfAnnualIncrease();
//        Assert.assertTrue(expectedInflationGuardAnnualIncrease.equals(inflationGuardAnnualIncrease),
//                "Inflation Guard Annual Increase was expected to be " + expectedInflationGuardAnnualIncrease +
//                        ", but it was " + inflationGuardAnnualIncrease);
//
//        SCHO3Coverages.SCHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();
//        coverages.clickSaveDraftCoverages();
//    }

//    @Test(description = "AL.HO3.ProductModel.More.001")
//    public void productModelMoreCoverage(ITestContext itc)
//    {
//        String firstname = "Ricky";
//        String lastname = "Bobby";
//
//        SCHO3NavigationBar nb = new SCHO3NavigationBar(sh);
//
//        SCHO3SearchAccounts sa = nb.clickSearchAccount();
//        log(itc.getName());
//        sa.setFirstName(firstname)
//                .setLastName(lastname)
//                .clickSearchButton()
//                .clickAccountNumberSearchAccount();
//        System.out.println(String.format("%s, %s", firstname, lastname));
//
//        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//        Actions build = new Actions(driver);
//        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//    }

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