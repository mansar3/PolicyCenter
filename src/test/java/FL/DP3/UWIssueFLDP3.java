package FL.DP3;

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
import pageobjects.FLDP3.*;
import pageobjects.Account.AccountFileSummary;
import pageobjects.Logon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by ssai on 3/10/2017.
 */
public class UWIssueFLDP3  extends BaseTest {

    private String dateString;
    private WebDriver driver;
    private Logon login;
    private CenterSeleniumHelper sh;

    String firstname = "FLDP3UWIssue";
    Random rand = new Random();
    int num = rand.nextInt(99 - 10 + 1) + 10;
    String lastname = "ValidationruleTest" + num;

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

        //
        String homeaddress = "241 Bayshore Dr";
        String city = "Pensacola";
        String state = "Florida";
        String county = "Escambia";
        String zip = "32507";
        String addrestype = "Home";
        String producercode = "523-23-20770";

        FLDP3NavigationBar nav = new FLDP3NavigationBar(sh);
        nav.clickAccountTab();
        nav.clickNewAccountDropdown();

        FLDP3EnterAccountInformation eai = new FLDP3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountFLDP3();

        FLDP3CreateAccount ca = new FLDP3CreateAccount(sh);
        //  ca.setDateOfBirth(date);
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

    }

    @Test(description = "Creates Account for FLDP3UWIssue")
    public void CreatesandValidatesFLDP3UWIssue(ITestContext itc) {

        String policyType = "Dwelling Fire (DP3)";
        String distanceToFireHydrant = "200";
        String inceptionno = "false";
        String rooftype = "Hip";
        String rooftype1 = "Flat";
        String dwellinglimit = "300,000";
        String DateofBirth = "01/01/1970";
        String ssn = "111-22-3333";
        String animaltrue = "true";
        String animalfalse = "false";
        String wateryear = "2010";
        String openProtectiontype = "Hurricane";
        String allotherPerils = "500";
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String Verifyto, expectedVerifyto = "UW Approval - PL Team 2";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
        String uwissueblobkingwater, expecteduwissueblobkingwater = "Water Heater Age";
        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";
        String usissueblobkinghomeanimal, expectedusissueblobkinghomeanimal = "Home with Exotic Animals";
        String uwissueblobkingflatroofs, expecteduwissueblobkingflatroofs = "Flat roofs must be reviewed by Underwriting";
        String uwissueblockingperils, expecteduwissueblockingperils = "$500 AOP deductible requires UW approval";

        FLDP3NavigationBar nav = new FLDP3NavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        FLDP3TestingSystemClock tsc = new FLDP3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = "1999",
                yearBuilt1 = "2003",
                yearBuilt2 = "2010";
        String yearBuilt12 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
       // String yearBuilt2 = dateTime.minusYears(14).format(DateTimeFormatter.ofPattern("yyyy"));

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();

        FLDP3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


        FLDP3AccountFileSummary afs = new FLDP3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLDP3NewSubmission ns = new FLDP3NewSubmission(sh);
        FLDP3Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        FLDP3PolicyInfo pi = qua.next();

        //sets the prior date to 7
        pi.setEffectiveDate(priorDate);

        FLDP3Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity(inceptionno);

        FLDP3DwellingConstruction dwellingConstruction = dwe.next();


        FLDP3Coverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .next()
                .setDwellingLimit(dwellinglimit);

        FLDP3RiskAnalysis ra = coverages.next();

         ra.Issuequote()
                .clickDetailsTab();

        //verifies the blocking quote
        uwissueblockingquotemessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingquotemessage.equals(uwissueblockingquotemessage));
        System.out.println("The expected is " +expecteduwissueblockingquotemessage+ " and it is " + uwissueblockingquotemessage);

        //clicks the request approval
        FLDP3UWActivity uwa = ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        //gos back to the policy and changes the effective date

        ra.back().back().back().back();

        //clicks on edit policy transaction
       pi.clickEditPolicyTransaction()
               .acceptYes()
               .setEffectiveDate(currentDate)
               .quote()
               .backToRiskAnalysis();

       //verify the blocking bind water issue

        uwissueblobkingwater = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingwater.equals(uwissueblobkingwater));
        System.out.println("The expected is " +expecteduwissueblobkingwater+ " and it is " + uwissueblobkingwater);

        ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        //goes to dwelling construction
        ra.back().back();

             dwellingConstruction.clickeditpolicytransaction()
                     .acceptYes();


        //sets the water heater year
        dwellingConstruction.setWaterHeaterYear(wateryear)
                .clickDwellingconstructionQuote()
                .backToRiskAnalysis();

        //verify the blocking bind in ssn

        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        ra.riskAnalysisRequestApproval();


        //verifies the Assign to
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

        //lands to the qualification page

        qua.next().next().next()
                .clickDwellingconstructionQuote()
                .backToRiskAnalysis();

        //verify the blocking bind in dob

        uwissueblobkingbind2 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);

        ra.riskAnalysisRequestApproval();


        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();
        ra.clickEditPolicyTransaction()
                .acceptYes();

        //now we need to put the dob blicking the account number

        ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setDateOfBirth(DateofBirth).clickupdate();
        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

        //goes to the dwelling construction and changes the year built date

        qua.next().next()
                .setYearBuilt(yearBuilt1)
                .setAnimalsOrExoticPets(animaltrue)
                .setexoticAnimalType(1, "Exotic")
                .setexoticAnimalBreed(1, "Other")
                .setexoticAnimalBiteHistory(1, "false")
                .next()
                .clickWindMitigation()
                .setOpeningProtectionType(openProtectiontype)
                .clickdwellingconstructionwindmitiQuote()
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

        dwe.setYearBuilt(yearBuilt12)
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

        ra.back().back().back();
        //change the yyear built date
        dwe.setYearBuilt(yearBuilt2)
                .clickDwellingquote()
                .backToRiskAnalysis();

        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();
        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the dwelling cons

        ra.back().back();

        dwellingConstruction
                .next()
                .setAllOtherPerils(allotherPerils)
                .next()
                .Issuequote()
                .clickDetailsTab();

        //verify the blocking Issue

        //verify the blobking quote release
        uwissueblockingperils = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingperils.equals(uwissueblockingperils));
        System.out.println("The expected is " +expecteduwissueblockingperils+ " and it is " + uwissueblockingperils);

        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);


    }

    @Test
    public void UWIssueIssue002(){

        String policyType = "Dwelling Fire (DP3)";
        String yearBuilt = "1999";
        String distanceToFireHydrant = "200";
        String dwellinglimit = "190,000",
                dwellinglimit1 = "1,000,000";
        String inceptionno = "false";
        String rooftype = "Hip";
        String uwissueblockingdescquotemessage, expecteduwissueblockingdescquotemessage = "Dwelling limit below minimum";
        String uwissueblockingdescquotemaxmessage, expecteduwissueblockingdescquotemaxmessage = "Maximum Dwelling Limit Exceeded";
        String Verifyto, expectedVerifyto = "UW Approval - PL Team 2";
        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";


        FLDP3AccountFileSummary afs = new FLDP3AccountFileSummary(sh);


        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();

        FLDP3NewSubmission ns = new FLDP3NewSubmission(sh);
        FLDP3Qualification qua = ns.productTable.selectHomeowners();
        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }

        FLDP3PolicyInfo pi = qua.next();
        FLDP3Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity(inceptionno);

        FLDP3DwellingConstruction dwellingConstruction = dwe.next();


        FLDP3Coverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .next()
                .setDwellingLimit(dwellinglimit);

        FLDP3RiskAnalysis ra = coverages.next();

        ra.Issuequote()
                .clickDetailsTab();

        //verifies the blocking quote
        uwissueblockingdescquotemessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingdescquotemessage.equals(uwissueblockingdescquotemessage));
        System.out.println("The expected is " +expecteduwissueblockingdescquotemessage+ " and it is " + uwissueblockingdescquotemessage);

        //clicks the request approval
        FLDP3UWActivity uwa = ra.riskAnalysisRequestApproval();

        //verifies  the description

        uwissueblockingdescquotemessage = uwa.getDescription();
        Assert.assertTrue(expecteduwissueblockingdescquotemessage.equals(uwissueblockingdescquotemessage));
        System.out.println("The expected is " +expecteduwissueblockingdescquotemessage+ " and it is " + uwissueblockingdescquotemessage);


        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        ra.clickEditPolicyTransaction();

        //goes back to coverages

        ra.back();

        coverages.setDwellingLimit(dwellinglimit1)
                .next()
                .Issuequote()
                .clickDetailsTab();

        //verifies the blocking quote
        uwissueblockingdescquotemaxmessage = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingdescquotemaxmessage.equals(uwissueblockingdescquotemaxmessage));
        System.out.println("The expected is " +expecteduwissueblockingdescquotemaxmessage+ " and it is " + uwissueblockingdescquotemaxmessage);

        //clicks the request approval
        ra.riskAnalysisRequestApproval();

        //verifies  the description

        uwissueblockingdescquotemaxmessage = uwa.getDescription();
        Assert.assertTrue(expecteduwissueblockingdescquotemaxmessage.equals(uwissueblockingdescquotemaxmessage));
        System.out.println("The expected is " +expecteduwissueblockingdescquotemaxmessage+ " and it is " + uwissueblockingdescquotemaxmessage);

        //verifies the Assign to
        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);

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

