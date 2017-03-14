package FL.MH3;


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
import org.testng.annotations.*;
import pageobjects.FLMH3.*;
import pageobjects.Logon;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductModelFLMH3 extends BaseTest
{
    private WebDriver driver;
    private Logon logon;
    private FLMH3EnterAccountInformation enterAccountInformation;
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

    @Test(description = "Creates account for Florida MH3 product")
    public void createPersonAccountFLMH3(ITestContext itc)
    {
        log(itc.getName());
        firstname = String.format("FLMH3Ricky%s", dateString);
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

        enterAccountInformation = new FLMH3EnterAccountInformation(sh);
        System.out.println(dob);
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLMH3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLMH3();
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

            FLMH3AccountFileSummary accountFileSummary = createAccount.clickUpdate();

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
    public void productModelFLMH3LessCoverage(ITestContext itc)
    {

    }

    @Test(description = "FL.MH3.ProductModel.MostPopular001"/*, dependsOnMethods =
            { "createPersonAccountFLMH3" }*/)
    public void productModelMostPopularFLMH3(ITestContext itc)
    {
        log(itc.getName());

        /* Set Variables */
/*        String firstname = "Ricky0209015449";
        String lastname = "Bobby0209015449";*/
        firstname = "FLMH3Ricky0310021911";
        lastname = "Bobby0310021911";

        String policyType = "Mobile Home (MH3)";
        String offeringSelection = "Most Popular";
        String county = "Volusia";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "70";
        String mobileHomePark = "1 - Aberdeen at Ormond Beach";
        String constructionType, defaultConstructionType = "Vinyl";
        String foundationType, defaultFoundationType = "Continuous Masonry";
        String dwellingLimit, expectedDwellingLimit = "80,000";
        String personalPropertyLimit,
                expectedPersonalPropertyLimit = "40,000",
                personalPropertyValuationMethod,
                defaultPersonalPropertyValuationMethod = "Replacement Cost Value";
        String lossOfUsePercentage, defaultLossOfUsePercentage = "20%";
        String lossOfUseLimit, defaultLossOfUseLimit = "16,000";
        String sectionIDeductibles;
        String personalLiabilityLimit, defaultPersonalLiabilityLimit = "300,000";
        String allOtherPerils, defaultAllOtherPerils = "1,000", newAllOtherPerils = "500";
        String hurricaneDeductible, defaultHurricaneDeductible = "2%";
        String medicalPaymentsLimit, defaultMedicalPaymentsLimit = "500";
        String otherStructuresAttachedOrDetached = "Detached",
                otherStructuresDescription = "Test",
                otherStructuresLimit = "25,000";
        String articleType = "Jewelry",
                propertyDescription = "Personal",
                personalPropertyValue = "2500";

        /* Begin Test */
        FLMH3NavigationBar nb = new FLMH3NavigationBar(sh);

        enterAccountInformation = new FLMH3EnterAccountInformation(sh);
        FLMH3AccountFileSummary afs = enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .clickSearch()
                .clickAccountNumberFLMH3();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLMH3NewSubmission ns = new FLMH3NewSubmission(sh);
        FLMH3Qualification qualification = ns.productTable.selectHomeowners();
        qualification
                .setPolicyType(policyType)
                .setOfferingSelection(offeringSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        FLMH3DwellingConstruction dwellingConstruction = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setMobileHomePark(mobileHomePark)
                .next();
                /*.setAtInceptionOfPolicyIsDeedOwnedByEntity("false")
                .setResidenceType(residenceType)
                .setDwellingUsage(dwellingUsage)
                .setDwellingOccupancy(dwellingOccupance);*/

        Assert.assertFalse(dwellingConstruction.isMobileHomeTiedDown(),
                "Is Mobile Home Tied Down was expected to be 'No' but it was 'Yes");

        Assert.assertTrue(dwellingConstruction.isConstructionTypeRequired(),
                "Construction Type was expected to be a required field but it was not");
        constructionType = dwellingConstruction.getConstructionType();
        Assert.assertTrue(defaultConstructionType.equals(constructionType),
                        "Construction Type expected was " + defaultConstructionType +
                                ", but it was " + constructionType);

        Assert.assertTrue(dwellingConstruction.isFoundationTypeRequired(),
                "Foundation Type was expected to be a required field but it was not");
        foundationType = dwellingConstruction.getFoundationType();
        Assert.assertTrue(defaultFoundationType.equals(foundationType),
                        "Foundation Type expected was " + defaultFoundationType +
                                ", but it was " + foundationType);

        Assert.assertTrue(dwellingConstruction.isMobileHomeFullySkirtedRequired(),
                "Is Mobile Home Fully Skirted expected to be a required field but it was not");
        Assert.assertFalse(dwellingConstruction.isMobileHomeFullySkirted(),
                "Is Mobile Home Fully Skirted expected to be 'No' but it was 'Yes'");
        FLMH3Coverages coverages = dwellingConstruction.setIsTheMobileHomeFullySkirted("true")
                .next();

        dwellingLimit = coverages.getDwellingLimit();
        Assert.assertTrue(dwellingLimit.equals(""),
                "Dwelling Limit was expected to be blank but it was " + dwellingLimit);
        dwellingLimit = coverages.setDwellingLimit(expectedDwellingLimit).getDwellingLimit();
        Assert.assertTrue(expectedDwellingLimit.equals(dwellingLimit),
                        "Dwelling Limit was expected to be " + expectedDwellingLimit +
                                ", but it was " + dwellingLimit);

        Assert.assertFalse(coverages.isPersonalPropertyExcluded(),
                "Is Personal Property Excluded was expected to be 'No' but it was 'Yes'");

        /* Personal Property */
        coverages.isPersonalPropertyLimitRequired();
        personalPropertyLimit = coverages.getPersonalPropertyLimit();
        Assert.assertTrue(expectedPersonalPropertyLimit.equals(personalPropertyLimit),
                        "Personal Property Limit was expected to be " + expectedPersonalPropertyLimit +
                                ", but it was " + personalPropertyLimit);

        personalPropertyValuationMethod = coverages.getPersonalPropertyValuationMethod();
        Assert.assertTrue(defaultPersonalPropertyValuationMethod.equals(personalPropertyValuationMethod),
                "Personal Property " + defaultPersonalPropertyValuationMethod +
                        ", but it was " + personalPropertyLimit);

        /* Loss of Use */
        lossOfUsePercentage = coverages.getLossOfUseSelection();
        Assert.assertTrue(defaultLossOfUsePercentage.equals(lossOfUsePercentage),
                "Loss Of Use Percentage was expected to be " + defaultLossOfUsePercentage +
                        ", but it was " + lossOfUsePercentage);
        lossOfUseLimit = coverages.getLossOfUseLimit();
        Assert.assertTrue(defaultLossOfUseLimit.equals(lossOfUseLimit),
                "Loss Of Use Limit was expected to be " + defaultLossOfUseLimit +
                        ", but it was " + lossOfUseLimit);

        /* Section I Deductibles */
        allOtherPerils = coverages.getAllOtherPerils();
        Assert.assertTrue(defaultAllOtherPerils.equals(allOtherPerils),
                "All Other Perils was expected to be " + defaultAllOtherPerils +
                        ", but it was " + allOtherPerils);
        hurricaneDeductible = coverages.getHurricane();
        Assert.assertTrue(defaultHurricaneDeductible.equals(hurricaneDeductible),
                "" + defaultHurricaneDeductible +
                        ", but it was " + hurricaneDeductible);
        coverages.setAllOtherPerils(newAllOtherPerils);

        sectionIDeductibles = coverages.getSectionIDeductibles();
        System.out.println(sectionIDeductibles);

        /* Personal Liability */
        personalLiabilityLimit = coverages.getPersonalLiabilityLimit();
        Assert.assertTrue(defaultPersonalLiabilityLimit.equals(personalLiabilityLimit),
                        "Personal Liability Limit was expected to be " + defaultPersonalLiabilityLimit +
                                ", but it was " + personalLiabilityLimit);

        medicalPaymentsLimit = coverages.getMedicalPaymentsLimit();
        Assert.assertTrue(defaultMedicalPaymentsLimit.equals(medicalPaymentsLimit),
                "Medical Payments Limit was expected to be " + defaultMedicalPaymentsLimit +
                        ", but it was " + medicalPaymentsLimit);

        FLMH3Coverages.FLMH3PropertyEndorsements pe = coverages.clickPropertyEndorsements();
        pe.checkSpecificOtherStructures().addSpecificOtherStructures()
                .setSpecificOtherStructuresAttachedDetached(1, otherStructuresAttachedOrDetached)
                .setSpecificOtherStructuresDescription(1, otherStructuresDescription)
                .setSpecificOtherStructuresLimit(1, otherStructuresLimit);

        pe.checkScheduledPersonalProperty()
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, articleType)
                .setPersonalPropertyDescription(1, propertyDescription)
                .setPersonalPropertyValue(1, personalPropertyValue);

        String scheduledPersonalPropertyClassArticleType = pe.getScheduledPersonalPropertyClassArticleType(1);
        Assert.assertTrue(scheduledPersonalPropertyClassArticleType.equals(articleType),
                        "Article Type was expected to be " + articleType +
                                ", but it was " + scheduledPersonalPropertyClassArticleType);

        String scheduledPersonalPropertyClassValue = pe.getScheduledPersonalPropertyClassValue(1);
        personalPropertyValue = NumberFormat.getNumberInstance(Locale.US).format(Integer.valueOf(personalPropertyValue));
        Assert.assertTrue(scheduledPersonalPropertyClassValue.equals(personalPropertyValue),
                        "Personal Property Value was expected to be " + personalPropertyValue +
                                ", but it was " + scheduledPersonalPropertyClassValue);
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
