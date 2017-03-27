package FL.HO4;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Account.AccountFileSummary;
import pageobjects.FLHO4.*;
import pageobjects.Logon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by ssai on 3/13/2017.
 */
public class UWIssueFLHO4 extends BaseTest {


    private String dateString;
    private WebDriver driver;
    private Logon login;
    private CenterSeleniumHelper sh;


    @BeforeMethod
    public void beforeMethod() {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        login = new Logon(sh, sessionInfo);
        login.load();
        login.isLoaded();
        String user = "user1fcorners", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for FLUWIssue")
    public void CreatesAccountandValdatingFLUWIssue(ITestContext itc) {
        String firstname = "FLHO4UWIssue";
        Random rand = new Random();
        int num  = rand.nextInt(99 - 10 + 1)+10;
        String lastname = "ValidationruleTest"+num;

        String homeaddress = "475 Oakwood Ct";
        String city = "Merritt Island";
        String county = "Brevard";
        String state = "Florida";
        String zip = "32953";
        String addrestype = "Home";
        String producercode = "523-23-20770 4 Corners Insurance";
        String policyType = "Renters (HO4)";
        String distanceToFireHydrant = "200";
        String rooftype = "Hip";
        String openprotectiontype = "Hurricane";
        String personalpropertylimit = "130,000";
        String DateofBirth = "01/01/1970";
        String ssn = "111-22-3333";
        String animaltrue = "true";
        String animalfalse = "false";
        String allotherPerils = "500";
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
        String descriptionspp, expecteddescriptionspp = "Scheduled Personal Property";
        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
        String uwissueblobkingbindtran, expecteduwissueblobkingbindtran = "Transaction Effective Date 5 days earlier than System Date";
        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";
        String usissueblobkinghomeanimal, expectedusissueblobkinghomeanimal = "Home with Exotic Animals";
        String uwissueblockingwater, expecteduwissueblockingwater = "Water Heater Age";
        String uwissueblockingperils, expecteduwissueblockingperils = "$500 AOP deductible requires UW approval";
        String uwissueblockingrisk, expecteduwissueblockingrisk = "This risk will require underwriting approval";


        FLHO4NavigationBar nav = new FLHO4NavigationBar(sh);
        nav.clickAccountTab();
        nav.clickNewAccountDropdown();

        FLHO4EnterAccountInformation eai = new FLHO4EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountFLHO4();

        FLHO4CreateAccount ca = new FLHO4CreateAccount(sh);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setCounty(county);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress()
                .selectSuccessfulVerificationIfPossibleForCreateAccount();
        ca.setAddressType(addrestype);
        ca.setProducerCode(producercode);
        ca.update();


        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        FLHO4TestingSystemClock tsc = new FLHO4TestingSystemClock(sh);


        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = "1999";
        String yearBuilt1 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
        String yearBuilt2 = "2003";
        String wateryear1 = "2010";

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();

        FLHO4SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


        FLHO4AccountFileSummary afs = new FLHO4AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO4NewSubmission ns = new FLHO4NewSubmission(sh);
        FLHO4Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        FLHO4PolicyInfo pi = qua.next();
        FLHO4Dwelling dwe = pi.setEffectiveDate(priorDate)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant);

        FLHO4DwellingConstruction dwellingConstruction = dwe.next();


        FLHO4Coverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .setOpeningProtectionType(openprotectiontype)
                .next()
                .setPersonalPropertyLimit(personalpropertylimit);

        FLHO4RiskAnalysis ra = coverages.next();

         ra.Issuequote()
                .clickDetailsTab();


        //validating the UWIssues in Blocking Bind

        uwissueblockingquotemessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingquotemessage.equals(uwissueblockingquotemessage));
        System.out.println("The expected is " + expecteduwissueblockingquotemessage + " and it is " + uwissueblockingquotemessage);

        uwissueblockingrisk = ra.getusIssueblockingbind2();
        Assert.assertTrue(expecteduwissueblockingrisk.equals(uwissueblockingrisk));
        System.out.println("The expected is " + expecteduwissueblockingrisk + " and it is " + uwissueblockingrisk);

        uwissueblobkingbindtran = ra.getusIssueblockingbind4();
        Assert.assertTrue(expecteduwissueblobkingbindtran.equals(uwissueblobkingbindtran));
        System.out.println("The expected is " + expecteduwissueblobkingbindtran + " and it is " + uwissueblobkingbindtran);

        uwissueblockingwater = ra.getusIssueblockingbind5();
        Assert.assertTrue(expecteduwissueblockingwater.equals(uwissueblockingwater));
        System.out.println("The expected is " + expecteduwissueblockingwater + " and it is " + uwissueblockingwater);

        uwissueblobkingbind1 = ra.getusIssueblockingbind6();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        uwissueblobkingbind2 = ra.getusIssueblockingbind7();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);

        //goes back to the policy info

        ra.back().back().back().back();

        pi.clickEditPolicyTransaction()
                .acceptYes();

        //changes the date to system date
        pi.setEffectiveDate(currentDate)
                .next()
                .setYearBuilt(yearBuilt2)
                .setAnimalsOrExoticPets(animaltrue)
                .setexoticAnimalType(1, "Exotic")
                .setexoticAnimalBreed(1, "Other")
                .setexoticAnimalBiteHistory(1, "false")
                .next()
                .setWaterHeaterYear(wateryear1)
                .clickdwellingConSaveDraft();


        //clicks on account number

        AccountFileSummary af = ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).setDateOfBirth(DateofBirth).clickupdate();

        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

        //goes to the riskanalysis
        qua.next().next().next().next()
                .next()
                .Issuequote()
                .clickDetailsTab();

        uwissueblockingrisk = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingrisk.equals(uwissueblockingrisk));
        System.out.println("The expected is " + expecteduwissueblockingrisk + " and it is " + uwissueblockingrisk);

        //verify the blobking quote release
        usissueblobkinghomeanimal = ra.getusIssueblockingbind3();
        Assert.assertTrue(expectedusissueblobkinghomeanimal.equals(usissueblobkinghomeanimal));
        System.out.println("The expected is " +expectedusissueblobkinghomeanimal+ " and it is " + usissueblobkinghomeanimal);

        FLHO4UWActivity uwa =   ra.riskAnalysisRequestApproval();

        //verifies the assign to
        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        //goes back to the dwelling
        uwa.clickCancel()
                .back()
                .back()
                .back();

        //edits the data in dwelling

        dwe.clickEditPolicyTransaction()
                .acceptYes();

        //changes  the buit year

        dwe.setYearBuilt(yearBuilt1)
                .setAnimalsOrExoticPets(animalfalse)
                .next()
                .next()
                .clickPropertyEndorsements()
                .checkScheduledPersonalProperty()
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, "Antiques")
                .setPersonalPropertyDescription(1, "Test")
                .setPersonalPropertyValue(1, "52,500")
                .next()
                .Issuequote()
                .clickDetailsTab();

        //
        //verify the blobking quote release
        uwissueblockingyear = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingyear.equals(uwissueblockingyear));
        System.out.println("The expected is " +expecteduwissueblockingyear+ " and it is " + uwissueblockingyear);

        descriptionspp =  ra.getusIssueblockingbind4();
        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
        System.out.println("The expected is " +expecteddescriptionspp+ " and it is " + descriptionspp);

        //ra.back();

        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .back();


//        coverages.clickPropertyEndorsements()
//                .clickEditPolicyTransaction()
//                .acceptYes();

              coverages.clickPropertyEndorsements()
                      .setPersonalPropertyValue(1, "40,000")
                      .clickAddScheduledPersonalProperty()
                      .setPersonalPropertyArticleType(2, "Antiques")
                      .setPersonalPropertyDescription(2, "Test")
                      .setPersonalPropertyValue(2, "40,000")
                      .clickAddScheduledPersonalProperty()
                      .setPersonalPropertyArticleType(3, "Antiques")
                      .setPersonalPropertyDescription(3, "Test")
                      .setPersonalPropertyValue(3, "40,000")
                      .clickAddScheduledPersonalProperty()
                      .setPersonalPropertyArticleType(4, "Antiques")
                      .setPersonalPropertyDescription(4, "Test")
                      .setPersonalPropertyValue(4, "40,000");
        //goes back to the dwelling
        coverages.back()
                .back();

        //changs the year built

        dwe.setYearBuilt(yearBuilt2)
                .next()
                .next()
                .next();

        //clicks on quote
        ra.Issuequote()
                .clickDetailsTab();


        //verifies the blocking bind

        descriptionspp = ra.getusIssueblockingbind3();
        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
        System.out.println("The expected is " + expecteddescriptionspp + " and it is " + descriptionspp);


        //goes back
        ra.clickEditPolicyTransaction()
                .back();
        //unchecks the scheduled property

        coverages.clickPropertyEndorsements()
                .checkScheduledPersonalProperty()
                .clickCoverages()
                .setAllOtherPerils(allotherPerils)
                .next();

        //click the quote

        ra.Issuequote()
                .clickDetailsTab();

        //verifies the blocking quote
        uwissueblockingperils = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingperils.equals(uwissueblockingperils));
        System.out.println("The expected is " + expecteduwissueblockingperils + " and it is " + uwissueblockingperils);
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
