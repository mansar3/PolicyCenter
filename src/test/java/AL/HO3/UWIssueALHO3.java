package AL.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ALHO3.*;
import pageobjects.ALHO3UWIssue.*;
import pageobjects.Account.AccountFileSummary;
import pageobjects.Login;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.AccountFileContacts;
import pageobjects.WizardPanelBase.PreQuoteIssues;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ssai on 3/7/2017.
 */
public class UWIssueALHO3 extends BaseTest {

    private String dateString;
    private WebDriver driver;
    private Login login;
    private CenterSeleniumHelper sh;


    @BeforeMethod
    public void beforeMethod() {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        login = new Login(sh, sessionInfo);
        login.load();
        login.isLoaded();
        String user = "user1baldwin", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for NCUWIssue")
    public void CreatePersonalAccountforNCUWIssue(ITestContext itc) {
        String firstname = "ALHO3UWIssue";
        // String lastname = "Validationrule";
        String lastname = "ValidationruleTest41";
        //  String date = "03/30/1985";
        String homephone = "8501112222";
        String homeaddress = "2000 River Forest Rd";
        String city = "Mobile";
        String state = "Alabama";
        String zip = "36005";
        String addrestype = "Home";
        //String orgname = "SFI";
        String producercode = "523-23-40004 First Baldwin Insurance, LLC";
       ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();

       ALHO3EnterAccountInformation eai = new ALHO3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountALHO3();

       ALHO3CreateAccount ca = new ALHO3CreateAccount(sh);
        //  ca.setDateOfBirth(date);
        ca.setHomePhone(homephone);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress();
        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
        ca.setAddressType(addrestype);
        //    ca.organizationSearch();
        //ALHO3UWIssueOrganizations org = newALHO3UWIssueUWIssueOrganizations(sh);

        //  org.setOrganizationName(orgname);
        // org.clickSearchButton();
        // org.selectOrganizationButton();
        ca.setProducerCode(producercode);
//after filling the form clicking on the update button in create account page
        ca.update();


    }

    @Test(description = "Validating the Ho3")
    public void ValidatingHO3AL() {

        String firstname = "ALHO3UWIssue";
        String lastname = "ValidationruleTest41";
        String policyType = "Homeowners (HO3)";
        String distanceToFireHydrant = "79";
        String county = "MOBILE";
        String rooftype = "Flat";
        String rooftype1 = "Hip";
        String dwellinglimit = "400,000",
                dwellinglimit1 = "1,000,000";
        String DateofBirth = "01/01/1982";
        String ssn = "666-77-8888";
        //    String priorDate = new DateTime().minusDays(7).toString("MM/dd/yyyy");
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String uwissueblobkingbind3, expecteduwissueblobkingbind3 = "Flat roofs must be reviewed by Underwriting";
        String Verifyto, expectedVerifyto = "UW Approval - PL Alabama Team";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
        String description, expecteddescription = "Transaction Effective Date earlier than Written Date";
        String description1, expecteddescription1 = "Maximum Dwelling Limit Exceeded";
        String descriptionyear, expecteddescriptionyear = "Dwelling Year Built";
        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
        String uwissueblobkingbindtran, expecteduwissueblobkingbindtran = "Transaction Effective Date 5 days earlier than System Date";
        String usissueblobkingquoteissue, expectedusissueblobkingquoteissue = "Maximum Dwelling Limit Exceeded";
        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";

       ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);

        nav.clickInternalToolTab()
                .clickTestingTimeClock();
       ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = dateTime.minusYears(7).format(DateTimeFormatter.ofPattern("yyyy"));
        String yearBuilt1 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();

       ALHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


       ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
       ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
       ALHO3Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
       ALHO3PolicyInfo pi = qua.next();
       ALHO3Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant).editLocation()
                .setCounty(county)
                .clickOk();

       ALHO3DwellingConstruction dwellingConstruction = dwe.next();


       ALHO3Coverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .next()
                .setDwellingLimit(dwellinglimit);

       ALHO3RiskAnalysis ra = coverages.next();

       ALHO3Quote quote = ra.quote();

        quote.backToRiskAnalysis();

        //validating the UWIssues in Blocking Bind

        System.out.println(ra.getusIssueblockingbind1());
//        System.out.println(ra.getusIssueblockingbind2());
//        System.out.println(ra.getusIssueblockingbind3());
        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        uwissueblobkingbind2 = ra.getusIssueblockingbind2();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);

        uwissueblobkingbind3 = ra.getusIssueblockingbind3();
        Assert.assertTrue(expecteduwissueblobkingbind3.equals(uwissueblobkingbind3));
        System.out.println("The expected is " + expecteduwissueblobkingbind3 + " and it is " + uwissueblobkingbind3);

        //clicks the request approval
       ALHO3UWActivity uwa = ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();
        AccountFileSummary af = ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).setDateOfBirth(DateofBirth).clickupdate();

        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes to dwelling construction

        ra.back()
                .back();

        dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype1)
                .winddwellingback()
                .clickDwellingBack();

        //sets the effective date to +7 days

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

        description = uwa.getDescription();
        System.out.println(description);
        Assert.assertTrue(expecteddescription.equals(description));
        System.out.println("The expected is " +expecteddescription+ " and it is " + description);

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




//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
    }
}
