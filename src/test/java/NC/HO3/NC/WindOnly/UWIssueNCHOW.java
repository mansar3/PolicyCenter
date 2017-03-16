package NC.HO3.NC.WindOnly;

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
import pageobjects.Logon;
import pageobjects.NCHOW.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by ssai on 3/15/2017.
 */
public class UWIssueNCHOW  extends BaseTest {

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
        String user = "user2Bankers", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for FLUWIssue")
    public void CreatesAccountandValdatingFLUWIssue(ITestContext itc) {
        String firstname = "NCHOWUWIssue";
        Random rand = new Random();
        int num  = rand.nextInt(99 - 10 + 1)+10;
        String lastname = "ValidationruleTest"+num;
        String homeaddress = "2511 W Beach Dr";
        String city = "Oak Island";
        String state = "North Carolina";
        String county = "Brunswick";
        String zip = "28465";
        String addrestype = "Home";
        String producercode = "523-23-50026 Bankers Insurance";
        String policyType = "Wind Only";
        String distanceToFireHydrant = "79";
        String rooftype = "Hip";
        String dwellinglimit = "400,000",
                dwellinglimit1 = "1,000,000";
        String animaltrue = "true";
        String animalfalse = "false";
        String DateofBirth = "06/14/1970";
        String ssn = "111-11-1111";
        String constructiontype= "Superior";
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String Verifyto, expectedVerifyto = "UW Approval - PL North Carolina Team";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
        String descriptioneff, expecteddescriptioneff = "Transaction Effective Date earlier than Written Date";
        String description1, expecteddescription1 = "Maximum Dwelling Limit Exceeded";
        String descriptionyear, expecteddescriptionyear = "Dwelling Year Built";
        String descriptionhomeanimal, expecteddescriptionhomeanimal = "Home with Exotic Animals";
        String descriptionconstruction, expecteddescriptionconstruction = "Dwelling Construction Type Superior";
        String descriptionwaterheater, expecteddescriptionwaterheater = "Water Heater Age";
        String descriptionspp, expecteddescriptionspp = "Scheduled Personal Property";
        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
        String uwissueblobkingbindtran, expecteduwissueblobkingbindtran = "Transaction Effective Date 5 days earlier than System Date";
        String usissueblobkingquoteissue, expectedusissueblobkingquoteissue = "Maximum Dwelling Limit Exceeded";
        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";
        String usissueblobkinghomeanimal, expectedusissueblobkinghomeanimal = "Home with Exotic Animals";
        String uwissueblockingsuperior, expecteduwissueblockingsuperior = "Dwelling Construction Type Superior";
        String uwissueblockingwater, expecteduwissueblockingwater = "Water Heater Age";
        String uwissueblockingspp, expecteduwissueblockingspp = "Scheduled Personal Property";



        NCHOWNavigationBar nav = new NCHOWNavigationBar(sh);
        nav.clickAccountTab();
        nav.clickNewAccountDropdown();

        NCHOWEnterAccountInformation eai = new NCHOWEnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountNCHOW();

        NCHOWCreateAccount ca = new NCHOWCreateAccount(sh);
        //  ca.setDateOfBirth(date);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setCounty(county);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress();
        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
        ca.setAddressType(addrestype);
        ca.setProducerCode(producercode);
        ca.update();


        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        NCHOWTestingSystemClock tsc = new NCHOWTestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = "2010";
        //  String yearBuilt1 = "2000";
        String yearBuilt1 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
        // String yearBuilt2 = dateTime.minusYears(14).format(DateTimeFormatter.ofPattern("yyyy"));
        String yearBuilt2 = "2003";
        //  String wateryear = "1999",
        String wateryear1 = "2010";
        String wateryear = "1999";

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();

        NCHOWSearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


        NCHOWAccountFileSummary afs = new NCHOWAccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        NCHOWNewSubmission ns = new NCHOWNewSubmission(sh);
        NCHOWQualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        NCHOWPolicyInfo pi = qua.next();
        NCHOWDwelling dwe = pi.next()
                .setYearBuilt(yearBuilt);

        NCHOWDwellingConstruction dwellingConstruction = dwe.next();


        NCHOWCoverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .next()
                .setDwellingLimit(dwellinglimit);

        NCHOWRiskAnalysis ra = coverages.next();

        NCHOWQuote quote = ra.quote();

        quote.backToRiskAnalysis();

        //validating the UWIssues in Blocking Bind

        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        uwissueblobkingbind2 = ra.getusIssueblockingbind2();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);

        //clicks the request approval
        NCHOWUWActivity uwa = ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        //clicks the account number

        AccountFileSummary af = ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).setDateOfBirth(DateofBirth).clickupdate();
        af.westPanel.clickPolicyTransaction().clickTransactionNumber();


        ra.clickEditPolicyTransaction()
                .acceptYes()
                .back()
                .back()
                .back()
                .back();


        pi.setEffectiveDate(priorDate)
                .quoteWithIssues()
                .clickDetailsTab();


        //verifies the blocking quote releases and blobking bind

        uwissueblockingquotemessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingquotemessage.equals(uwissueblockingquotemessage));
        System.out.println("The expected is " +expecteduwissueblockingquotemessage+ " and it is " + uwissueblockingquotemessage);

        uwissueblobkingbindtran = ra.getusIssueblockingbind3();
        Assert.assertTrue(expecteduwissueblobkingbindtran.equals(uwissueblobkingbindtran));
        System.out.println("The expected is " +expecteduwissueblobkingbindtran+ " and it is " + uwissueblobkingbindtran);

        //clicks on request approval

        ra.riskAnalysisRequestApproval();

        //verifies the description and the assign to

        descriptioneff = uwa.getDescription();
        Assert.assertTrue(expecteddescriptioneff.equals(descriptioneff));
        System.out.println("The expected is " +expecteddescriptioneff+ " and it is " + descriptioneff);

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " +expectedVerifyto+ " and it is " + Verifyto);

        uwa.clickCancel();

        //goes to edit policy transaction and goes back to the policy
        ra.clickEditPolicyTransaction()
                .acceptYes()
                .back()
                .back().back().back();

        //set the effective as the system date

        pi.setEffectiveDate(currentDate)
                .next()
                .next()
                .next();

        //lands to coverages page and sets the dwelling limit

        coverages.setDwellingLimit(dwellinglimit1)
                .coveragesquoteWithIssues()
                .clickDetailsTab();


        //verify the blocking Quote Release
        usissueblobkingquoteissue = ra.getusIssueblockingbind1();
        Assert.assertTrue(expectedusissueblobkingquoteissue.equals(usissueblobkingquoteissue));
        System.out.println("The expected is " +expectedusissueblobkingquoteissue+ " and it is " + usissueblobkingquoteissue);

        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        description1 = uwa.getDescription();
        Assert.assertTrue(expecteddescription1.equals(description1));
        System.out.println("The expected is " +expecteddescription1+ " and it is " + description1);

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();

        //clicks on edit policy transaction and goes to coverages
        ra.clickEditPolicyTransaction()
                .acceptYes()
                .back();

        //sets the dwelling limit

        coverages.setDwellingLimit(dwellinglimit)
                .back()
                .back();

        //sets the year built
        //step 81
        dwe.setYearBuilt(yearBuilt1)
                .clickDwellingquoteissue()
                .clickDetailsTab();


        //verify the blobking quote release
        uwissueblockingyear = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingyear.equals(uwissueblockingyear));
        System.out.println("The expected is " +expecteduwissueblockingyear+ " and it is " + uwissueblockingyear);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        descriptionyear = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionyear.equals(descriptionyear));
        System.out.println("The expected is " +expecteddescriptionyear+ " and it is " + descriptionyear);

        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

        uwa.clickCancel();

        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the dwelling
        ra.back()
                .back()
                .back();


        dwe.setYearBuilt(yearBuilt2)
                .clickDwellingquote();


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
