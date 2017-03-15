package FL.MH3;


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
import pageobjects.FLMH3.*;
import pageobjects.Logon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


/**
 * Created by ssai on 3/14/2017.
 */
public class UWIssueFLMH3 extends BaseTest {

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
        String user = "userAcomm", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for FLUWIssue")
    public void CreatesAccountandValdatingFLUWIssue(ITestContext itc) {
        String firstname = "FLMH3UWIssue";
        // String lastname = "Validationrule";

        Random rand = new Random();
        int num  = rand.nextInt(99 - 10 + 1)+10;
        String lastname = "ValidationruleTest"+num;

        //String lastname = "Validationrule01Test11";
        //  String date = "03/30/1985";
        String homeaddress = "104 Grand Oaks Cir";
        String city = "Daytona Beach";
        String state = "Florida";
        String county = "Volusia";
        String zip = "32114";
        String addrestype = "Home";
        String producercode = "523-23-21358";
        String policyType = "Mobile Home (MH3)";
        String distanceToFireHydrant = "200";
        String mobilehomepark = "1 - Aberdeen at Ormond Beach";
        String skirtedYes= "true";
        String rooftype = "Hip";
        String rooftype1 = "Hip";
        String dwellinglimit = "124,000",
                dwellinglimit1 = "130,000",
                dwellinglimit2 = "125,000";
        String personalpropertylimit = "100,000";
        String openprotectiontype = "Hurricane";
        String DateofBirth = "06/14/1970";
        String ssn = "111-11-1111";
        String animaltrue = "true";
        String animalfalse = "false";
        String constructiontype= "Superior",
                constructiontype1 = "Frame";
        String Medicalpayments = "10,000",
                medicalPayments1 = "3,000";
        String allotherPerils = "500";
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String uwissueblobkingbind3, expecteduwissueblobkingbind3 = "Flat roofs must be reviewed by Underwriting";
        String Verifyto, expectedVerifyto = "UW Approval - PL Team 5";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
        String descriptionssndob, expecteddescriptionssndob = "SSN required for all Named Insureds, DOB required for all Named Insureds, Flat roofs must be reviewed by Underwriting";
        String descriptioneff, expecteddescriptioneff = "Transaction Effective Date earlier than Written Date";
        String description1, expecteddescription1 = "Maximum Dwelling Limit Exceeded";
        String descriptionyear, expecteddescriptionyear = "Dwelling Year Built";
        String descriptionhomeanimal, expecteddescriptionhomeanimal = "Home with Exotic Animals";
        String descriptionconstruction, expecteddescriptionconstruction = "Dwelling Construction Type Superior";
        String descriptionwaterheater, expecteddescriptionwaterheater = "Water Heater Age";
        String descriptionmedical, expecteddescriptionmedical = "HO Medical Pay";
        String descriptionspp, expecteddescriptionspp = "Scheduled Personal Property";
        String descriptionsinkhole, expecteddescriptionsinkhole = "Sinkhole Loss Coverage";
        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
        String uwissueblobkingbindtran, expecteduwissueblobkingbindtran = "Transaction Effective Date 5 days earlier than System Date";
        String usissueblobkingquoteissue, expectedusissueblobkingquoteissue = "Maximum Dwelling Limit Exceeded";
        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";
        String usissueblobkinghomeanimal, expectedusissueblobkinghomeanimal = "Home with Exotic Animals";
        String uwissueblockingsuperior, expecteduwissueblockingsuperior = "Dwelling Construction Type Superior";
        String uwissueblockingwater, expecteduwissueblockingwater = "Water Heater Age";
        String usissueblockingmedical, expectedusissueblockingmedical = "HO Medical Pay";
        String uwissueblockingspp, expecteduwissueblockingspp = "Scheduled Personal Property";
        String usissueblockingsinkhole, expectedusissueblockingsinkhole = "Sinkhole Loss Coverage";
        String uwissueblockingperils, expecteduwissueblockingperils = "$500 AOP deductible requires UW approval";


        FLMH3NavigationBar nav = new FLMH3NavigationBar(sh);
        nav.clickAccountTab();
        nav.clickNewAccountDropdown();

        FLMH3EnterAccountInformation eai = new FLMH3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountFLMH3();

        FLMH3CreateAccount ca = new FLMH3CreateAccount(sh);
        //  ca.setDateOfBirth(date);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        //  ca.setCounty(county);
        ca.setState(state);
        ca.setCounty(county);
        ca.setZipCode(zip);
        ca.clickVerifyAddress();
        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:0:_Select")).click();
        ca.setAddressType(addrestype);
        ca.setProducerCode(producercode);
        ca.update();


        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        FLMH3TestingSystemClock tsc = new FLMH3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = "1999";
        //  String yearBuilt1 = "2000";
        String yearBuilt2 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
        // String yearBuilt2 = dateTime.minusYears(14).format(DateTimeFormatter.ofPattern("yyyy"));
        String yearBuilt1 = "2003";
        String yearBuilt3 = "2010";
        // String yearBuilt2 = "2000";
        //  String wateryear = "1999",
        String wateryear1 = "2010";
        String wateryear = dateTime.minusYears(16).format(DateTimeFormatter.ofPattern("yyyy"));

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();

        FLMH3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


        FLMH3AccountFileSummary afs = new FLMH3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLMH3NewSubmission ns = new FLMH3NewSubmission(sh);
        FLMH3Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        FLMH3PolicyInfo pi = qua.next();
        FLMH3Dwelling dwe = pi.setEffectiveDate(priorDate)
                .next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setMobileHomePark(mobilehomepark);

        FLMH3DwellingConstruction dwellingConstruction = dwe.next();


        FLMH3Coverages coverages = dwellingConstruction.setIsTheMobileHomeFullySkirted(skirtedYes)
                .next()
                .setDwellingLimit(dwellinglimit);

        FLMH3RiskAnalysis ra = coverages.next();

        ra.Issuequote()
                .clickDetailsTab();


        //verify only one on blocking quote.

        uwissueblockingquotemessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingquotemessage.equals(uwissueblockingquotemessage));
        System.out.println("The expected is " +expecteduwissueblockingquotemessage+ " and it is " + uwissueblockingquotemessage);

        //clicks on request approval

        FLMH3UWActivity uwa =  ra.riskAnalysisRequestApproval();

        //verifies the assign to

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        ra.back()
                .back().back().back();

        pi.clickEditPolicyTransaction()
                .acceptYes();

        //sets to the current date

        pi.setEffectiveDate(currentDate)
                .next()
                .next()
                .next();

        //changes the dwelling limit
        coverages.setDwellingLimit(dwellinglimit1)
                .coveragesquoteWithIssues()
                .clickDetailsTab();

        //verifies the dwelling exceeded description and Assign to

        description1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteddescription1.equals(description1));
        System.out.println("The expected is " +expecteddescription1+ " and it is " + description1);

        ra.riskAnalysisRequestApproval();

        //verifies the assign to

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the coverages

        ra.back();

        //sets teh dwelling limit
        coverages.setDwellingLimit(dwellinglimit2)
                .next()
                .quote()
                .backToRiskAnalysis();

        //verifies the SSN message

        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        ra.riskAnalysisRequestApproval();

        //verifies the assign to

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //clicks the account number

        AccountFileSummary af = ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).clickupdate();
        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

        //goes to the dwe construction
        qua.next().next().next().clickDwellingconstructionQuote()
                .backToRiskAnalysis();

        uwissueblobkingbind2 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        //verifies the assign to

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel()
                .clickEditPolicyTransaction()
                .acceptYes();

        //now we need to put the dob blicking the account number

        ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setDateOfBirth(DateofBirth).clickupdate();
        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

        qua.next().next();

        dwe.setYearBuilt(yearBuilt1)
                .setAnimalsOrExoticPets(animaltrue)
                .setexoticAnimalType(1, "Exotic")
                .setexoticAnimalBreed(1, "Other")
                .setexoticAnimalBiteHistory(1, "false")
                .clickDwellingquote()
                .backToRiskAnalysis();

        //verify the blobking quote release
        usissueblobkinghomeanimal = ra.getusIssueblockingbind1();
        Assert.assertTrue(expectedusissueblobkinghomeanimal.equals(usissueblobkinghomeanimal));
        System.out.println("The expected is " +expectedusissueblobkinghomeanimal+ " and it is " + usissueblobkinghomeanimal);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();
        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the dwelling

        ra.back().back().back();
        dwe.setYearBuilt(yearBuilt2)
                .setAnimalsOrExoticPets(animalfalse)
                .clickDwellingquoteissue()
                .clickDetailsTab();


        //verify the blobking quote release
        uwissueblockingyear = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingyear.equals(uwissueblockingyear));
        System.out.println("The expected is " +expecteduwissueblockingyear+ " and it is " + uwissueblockingyear);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();


        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes to the dwelling

        ra.back().back().back();

        dwe.setYearBuilt(yearBuilt3)
                .next()
                .next();

        //goes to property endorsnments
        coverages.clickPropertyEndorsements()
                .checkScheduledPersonalProperty()
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, "Jewelry")
                .setPersonalPropertyDescription(1, "Test")
                .setPersonalPropertyValue(1, "52,500")
                .next()
                .quote()
                .backToRiskAnalysis();


        //verify the blocking Bind

        uwissueblockingspp = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingspp.equals(uwissueblockingspp));
        System.out.println("The expected is " +expecteduwissueblockingspp+ " and it is " + uwissueblockingspp);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();
        ra.clickEditPolicyTransaction()
                .acceptYes();


        ra.back();
        coverages.clickPropertyEndorsements()
                .setPersonalPropertyArticleType(1, "Guns")
                .setPersonalPropertyDescription(1, "Test")
                .setPersonalPropertyValue(1, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(2, "Guns")
                .setPersonalPropertyDescription(2, "Test")
                .setPersonalPropertyValue(2, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(3, "Guns")
                .setPersonalPropertyDescription(3, "Test")
                .setPersonalPropertyValue(3, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(4, "Guns")
                .setPersonalPropertyDescription(4, "Test")
                .setPersonalPropertyValue(4, "40,000")
                .clickcoveragesPropertyEndorsementsQuote()
                .backToRiskAnalysis();

        //verify the blocking Bind

        uwissueblockingspp = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingspp.equals(uwissueblockingspp));
        System.out.println("The expected is " +expecteduwissueblockingspp+ " and it is " + uwissueblockingspp);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();
        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes to coverages
        ra.back();

        coverages.clickPropertyEndorsements()
                .uncheckScheduledPersonalProperty()
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

        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        //verifies the assign to

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();
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
