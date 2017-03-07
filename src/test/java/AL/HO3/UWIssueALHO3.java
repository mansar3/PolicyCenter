//package AL.HO3;
//
//import Helpers.CenterSeleniumHelper;
//import base.BaseTest;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.ALHO3UWIssue.*;
//import pageobjects.Account.AccountFileSummary;
//import pageobjects.Login;
//import pageobjects.NorthPanel;
//
///**
// * Created by ssai on 3/7/2017.
// */
//public class UWIssueALHO3 extends BaseTest{
//
//    private String dateString;
//    private WebDriver driver;
//    private Login login;
//    private CenterSeleniumHelper sh;
//
//
//    @BeforeMethod
//    public void beforeMethod() {
//        DateTime date = new DateTime();
//        dateString = date.toString("MMddhhmmss");
//        System.out.println(new DateTime().toString());
//
//        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
//        sh = new CenterSeleniumHelper(driver);
//        login = new Login(sh, sessionInfo);
//        login.load();
//        login.isLoaded();
//        String user = "user1baldwin", password = "";
//        login.login(user, password);
//        log(String.format("Logged in as: %s\nPassword: %s", user, password));
//    }
//
//    @Test(description = "Creates Account for NCUWIssue")
//    public void CreatePersonalAccountforNCUWIssue(ITestContext itc) {
//        String firstname = "ALHO3UWIssue";
//        String lastname = "Validationrule";
//      //  String date = "03/30/1985";
//        String homephone = "8501112222";
//        String homeaddress = "2000 River Forest Rd";
//        String city = "Mobile";
//        String state = "Alabama";
//        String zip = "36005";
//        String addrestype = "Home";
//        //String orgname = "SFI";
//        String producercode = "523-23-40004 First Baldwin Insurance, LLC";
//       ALHO3UWIssueNavigationBar nb = new ALHO3UWIssueNavigationBar(sh);
//        nb.clickAccountTab();
//        nb.clickNewAccountDropdown();
//
//       ALHO3UWIssueEnterAccountInformation eai = new ALHO3UWIssueEnterAccountInformation(sh);
//        eai.setFirstName(firstname);
//        eai.setLastName(lastname);
//        eai.clickSearch();
//        eai.createNewPersonAccountALHO3UWIssue();
//
//       ALHO3UWIssueCreateAccount ca = new ALHO3UWIssueCreateAccount(sh);
//      //  ca.setDateOfBirth(date);
//        ca.setHomePhone(homephone);
//        ca.setAddressLine1(homeaddress);
//        ca.setCity(city);
//        ca.setState(state);
//        ca.setZipCode(zip);
//        ca.clickVerifyAddress();
//        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
//        ca.setAddressType(addrestype);
//    //    ca.organizationSearch();
//      // ALHO3UWIssueUWIssueOrganizations org = newALHO3UWIssueUWIssueOrganizations(sh);
//
//      //  org.setOrganizationName(orgname);
//       // org.clickSearchButton();
//       // org.selectOrganizationButton();
//        ca.setProducerCode(producercode);
////after filling the form clicking on the update button in create account page
//        ca.update();
//
//
//    }
//
//    @Test(description = "Validating the Ho3")
//    public void ValidatingHO3AL() {
//
//        String firstname = "ALHO3UWIssue";
//        String lastname = "Validationrule";
//        String policyType = "Homeowners (HO3)";
//        String yearBuilt = new DateTime().minusYears(7).toString("yyyy");
//        String distanceToFireHydrant = "79";
//        String county = "MOBILE";
//        String rooftype = "Flat";
//        String dwellinglimit = "400,000";
//        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
//        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
//        String uwissueblobkingbind3, expecteduwissueblobkingbind3 = "Flat roofs must be reviewed by Underwriting";
//        String Verifyto, expectedVerifyto = "UW Approval - PL Alabama Team";
//
//        ALHO3UWIssueNavigationBar nav = new ALHO3UWIssueNavigationBar(sh);
//        ALHO3UWIssueSearchAccounts sa = nav.clickSearchAccount();
//        sa.setFirstName(firstname);
//        sa.setLastName(lastname);
//        sa.clickSearchButton();
//        sa.clickAccountNumberSearchAccount();
//
//
//        ALHO3UWIssueAccountFileSummary afs = new ALHO3UWIssueAccountFileSummary(sh);
//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();
//        ALHO3UWIssueNewSubmission ns = new ALHO3UWIssueNewSubmission(sh);
//        ALHO3UWIssueQualification qua = ns.productTable.selectHomeowners();
//        qua.setPolicyType(policyType);
//        qua.getOfferingSelection();
//        // to select no for all the blanks
//        for (int i = 0; i < 8; i++) {
//            qua.questionnaire.answerNo(i + 1);
//        }
//
//        ALHO3UWIssueDwelling dwe = qua.next()
//                .next()
//                .setYearBuilt(yearBuilt)
//                .setDistanceToFireHydrant(distanceToFireHydrant).editLocation()
//                .setCounty(county)
//                .clickOk();
//
//        ALHO3UWIssueDwellingConstruction  dwellingConstruction = dwe.next();
//
//
//        ALHO3UWIssueCoverages coverages = dwellingConstruction.clickWindMitigation()
//                .setRoofShapeType(rooftype)
//                .next()
//                .setDwellingLimit(dwellinglimit);
//
//        ALHO3UWIssueRiskAnalysis ra = coverages.next();
//
//        ALHO3UWIssueQuote quote = ra.quote();
//
//        quote.backToRiskAnalysis();
//
//        //validating the UWIssues in Blocking Bind
//
//        System.out.println(ra.getusIssueblockingbind1());
//        System.out.println(ra.getusIssueblockingbind2());
//        System.out.println(ra.getusIssueblockingbind3());
//        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
//        System.out.println("The expected is " +expecteduwissueblobkingbind1+ " and it is " + uwissueblobkingbind1);
//
//        uwissueblobkingbind2 = ra.getusIssueblockingbind2();
//        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
//        System.out.println("The expected is " +expecteduwissueblobkingbind2+ " and it is " + uwissueblobkingbind2);
//
//        uwissueblobkingbind3 = ra.getusIssueblockingbind3();
//        Assert.assertTrue(expecteduwissueblobkingbind3.equals(uwissueblobkingbind3));
//        System.out.println("The expected is " +expecteduwissueblobkingbind3+ " and it is " + uwissueblobkingbind3);
//
//        //clicks the request approval
//     ALHO3UWIssueUWActivity uwa =    ra.riskAnalysisRequestApproval();
//
//        //verifies the Assign to
//        Verifyto = uwa.getAssignTo();
//        System.out.println(uwa.getAssignTo());
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " +expectedVerifyto+ " and it is " + Verifyto);
//
//        uwa.clickCancel();
//        AccountFileSummary af = ra.np.clickAccountNumber();
//
//       af.westPanel.clickContacts().clickNameAccountFileContacts();
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
//}
