//package FL.HO3;
//
//import Helpers.CenterSeleniumHelper;
//import base.BaseTest;
//import base.LocalDriverManager;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.Account.AccountFileSummary;
//import pageobjects.FLHO3.*;
//import pageobjects.Login;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Random;
//
///**
// * Created by ssai on 3/10/2017.
// */
//public class UWIssueFLHO3 extends BaseTest {
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
//        String user = "user1fcorners", password = "";
//        login.login(user, password);
//        log(String.format("Logged in as: %s\nPassword: %s", user, password));
//    }
//
//    @Test(description = "Creates Account for FLUWIssue")
//    public void CreatesAccountandValdatingFLUWIssue(ITestContext itc) {
//        String firstname = "FLHO3UWIssue";
//        // String lastname = "Validationrule";
//
//        Random rand = new Random();
//        int num  = rand.nextInt(99 - 10 + 1)+10;
//        String lastname = "ValidationruleTest"+num;
//
//        //String lastname = "Validationrule01Test11";
//        //  String date = "03/30/1985";
//        String homeaddress = "500 International Parkway";
//        String city = "Lake Mary";
//        String state = "Florida";
//     //   String county = "MOBILE";
//        String zip = "32746";
//        String addrestype = "Home";
//        String producercode = "523-23-20770 4 Corners Insurance";
//        String policyType = "Homeowners (HO3)";
//        String distanceToFireHydrant = "200";
//        String rooftype = "Flat";
//        String rooftype1 = "Hip";
//        String dwellinglimit = "400,000",
//                dwellinglimit1 = "1,000,000";
//        String DateofBirth = "06/14/1970";
//        String ssn = "111-11-1111";
//        String animaltrue = "true";
//        String animalfalse = "false";
//        String constructiontype= "Superior",
//                constructiontype1 = "Frame";
//        String wateryear = "1999",
//                wateryear1 = "2010";
//        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
//        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
//        String uwissueblobkingbind3, expecteduwissueblobkingbind3 = "Flat roofs must be reviewed by Underwriting";
//        String Verifyto, expectedVerifyto = "UW Approval - PL Team 2";
//        String Verifytoexception, expectedVerifytoexception = "Exception Quotes - PL Exceptions Team";
//        String descriptionssndob, expecteddescriptionssndob = "SSN required for all Named Insureds, DOB required for all Named Insureds, Flat roofs must be reviewed by Underwriting";
//        String descriptioneff, expecteddescriptioneff = "Transaction Effective Date earlier than Written Date";
//        String description1, expecteddescription1 = "Maximum Dwelling Limit Exceeded";
//        String descriptionyear, expecteddescriptionyear = "Dwelling Year Built";
//        String descriptionhomeanimal, expecteddescriptionhomeanimal = "Home with Exotic Animals";
//        String descriptionconstruction, expecteddescriptionconstruction = "Dwelling Construction Type Superior";
//        String descriptionwaterheater, expecteddescriptionwaterheater = "Water Heater Age";
//        String descriptionspp, expecteddescriptionspp = "Scheduled Personal Property";
//        String uwissueblockingquotemessage, expecteduwissueblockingquotemessage = "Transaction Effective Date earlier than Written Date";
//        String uwissueblobkingbindtran, expecteduwissueblobkingbindtran = "Transaction Effective Date 5 days earlier than System Date";
//        String usissueblobkingquoteissue, expectedusissueblobkingquoteissue = "Maximum Dwelling Limit Exceeded";
//        String uwissueblockingyear, expecteduwissueblockingyear = "Dwelling Year Built";
//        String usissueblobkinghomeanimal, expectedusissueblobkinghomeanimal = "Home with Exotic Animals";
//        String uwissueblockingsuperior, expecteduwissueblockingsuperior = "Dwelling Construction Type Superior";
//        String uwissueblockingwater, expecteduwissueblockingwater = "Water Heater Age";
//        String uwissueblockingspp, expecteduwissueblockingspp = "Scheduled Personal Property";
//
//        FLHO3NavigationBar nav = new FLHO3NavigationBar(sh);
//        nav.clickAccountTab();
//        nav.clickNewAccountDropdown();
//
//        FLHO3EnterAccountInformation eai = new FLHO3EnterAccountInformation(sh);
//        eai.setFirstName(firstname);
//        eai.setLastName(lastname);
//        eai.clickSearch();
//        eai.createNewPersonAccountFLHO3();
//
//        FLHO3CreateAccount ca = new FLHO3CreateAccount(sh);
//        //  ca.setDateOfBirth(date);
//        ca.setAddressLine1(homeaddress);
//        ca.setCity(city);
//      //  ca.setCounty(county);
//        ca.setState(state);
//        ca.setZipCode(zip);
//        ca.clickVerifyAddress();
//        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:1:_Select")).click();
//        ca.setAddressType(addrestype);
//        ca.setProducerCode(producercode);
//        ca.update();
//
//
//        nav.clickInternalToolTab()
//                .clickTestingTimeClock();
//        FLHO3TestingSystemClock tsc = new FLHO3TestingSystemClock(sh);
//        String currentdate = tsc.getCurrentDate();
//        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
//        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        String yearBuilt = "2010";
//      //  String yearBuilt1 = "2000";
//         String yearBuilt1 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
//        String yearBuilt2 = dateTime.minusYears(14).format(DateTimeFormatter.ofPattern("yyyy"));
//
//        nav.clickSettings()
//                .clickReturntoPolicyCenter();
//        sh.waitForNoMask();
//
//        FLHO3SearchAccounts sa = nav.clickSearchAccount();
//        sa.setFirstName(firstname);
//        sa.setLastName(lastname);
//        sa.clickSearchButton();
//        sa.clickAccountNumberSearchAccount();
//
//
//        FLHO3AccountFileSummary afs = new FLHO3AccountFileSummary(sh);
//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();
//        FLHO3NewSubmission ns = new FLHO3NewSubmission(sh);
//        FLHO3Qualification qua = ns.productTable.selectHomeowners();
//
//        qua.setPolicyType(policyType);
//        qua.getOfferingSelection();
//        // to select no for all the blanks
//        for (int i = 0; i < 8; i++) {
//            qua.questionnaire.answerNo(i + 1);
//        }
//        FLHO3PolicyInfo pi = qua.next();
//        FLHO3Dwelling dwe = pi.next()
//                .setYearBuilt(yearBuilt)
//                .setDistanceToFireHydrant(distanceToFireHydrant);
//
//        FLHO3DwellingConstruction dwellingConstruction = dwe.next();
//
//
//        FLHO3Coverages coverages = dwellingConstruction.clickWindMitigation()
//                .setRoofShapeType(rooftype)
//                .next()
//                .setDwellingLimit(dwellinglimit);
//
//        FLHO3RiskAnalysis ra = coverages.next();
//
//        FLHO3Quote quote = ra.quote();
//
//        quote.backToRiskAnalysis();
//
//        //validating the UWIssues in Blocking Bind
//
//        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
//        System.out.println(uwissueblobkingbind1);
////        System.out.println(uwissueblobkingbind2);
////        System.out.println(uwissueblobkingbind3);
//        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
//        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);
//
//        uwissueblobkingbind2 = ra.getusIssueblockingbind2();
//        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
//        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);
//
//        uwissueblobkingbind3 = ra.getusIssueblockingbind3();
//        Assert.assertTrue(expecteduwissueblobkingbind3.equals(uwissueblobkingbind3));
//        System.out.println("The expected is " + expecteduwissueblobkingbind3 + " and it is " + uwissueblobkingbind3);
//
//        //clicks the request approval
//        FLHO3UWActivity uwa = ra.riskAnalysisRequestApproval();
//
//        //verifies the description
//        descriptionssndob = uwa.getDescription();
//        System.out.println(descriptionssndob);
////        Assert.assertTrue(expecteddescriptionssndob.equals(descriptionssndob));
////        System.out.println("The expected is " +expecteddescriptionssndob+ " and it is " + descriptionssndob);
//
//
//
//        //verifies the Assign to
//        Verifyto = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);
//
//        uwa.clickCancel();
//        AccountFileSummary af = ra.np.clickAccountNumber();
//
//        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).setDateOfBirth(DateofBirth).clickupdate();
//
//        nav.clickPolicyTab()
//                .clickLatestTran();
//
//      //  af.westPanel.clickPolicyTransaction().clickTransactionNumber();
//
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes to dwelling construction
//
//        quote.backToRiskAnalysis().back().back();//have to do from here
//        quote.backToRiskAnalysis().back().back();
//
//        dwellingConstruction.clickWindMitigation()
//                .setRoofShapeType(rooftype1)
//                .winddwellingback()
//                .clickDwellingBack();
//
//        //sets the effective date to +7 days
//
//        pi.setEffectiveDate(priorDate)
//                .quoteWithIssues()
//                .clickDetailsTab();
//
//
//        //verifies the blocking quote releases and blobking bind
//
//        uwissueblockingquotemessage = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingquotemessage.equals(uwissueblockingquotemessage));
//        System.out.println("The expected is " +expecteduwissueblockingquotemessage+ " and it is " + uwissueblockingquotemessage);
//
//        uwissueblobkingbindtran = ra.getusIssueblockingbind3();
//        Assert.assertTrue(expecteduwissueblobkingbindtran.equals(uwissueblobkingbindtran));
//        System.out.println("The expected is " +expecteduwissueblobkingbindtran+ " and it is " + uwissueblobkingbindtran);
//
//        //clicks on request approval
//
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the description and the assign to
//
//        descriptioneff = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptioneff.equals(descriptioneff));
//        System.out.println("The expected is " +expecteddescriptioneff+ " and it is " + descriptioneff);
//
//        Verifyto = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " +expectedVerifyto+ " and it is " + Verifyto);
//
//        uwa.clickCancel();
//
//        //goes to edit policy transaction and goes back to the policy
//        ra.clickEditPolicyTransaction()
//                .acceptYes()
//                .back()
//                .back().back().back();
//
//        //set the effective as the system date
//
//        pi.setEffectiveDate(currentDate)
//                .next()
//                .next()
//                .next();
//
//        //lands to coverages page and sets the dwelling limit
//
//        coverages.setDwellingLimit(dwellinglimit1)
//                .coveragesquoteWithIssues()
//                .clickDetailsTab();
//
//
//        //verify the blocking Quote Release
//        usissueblobkingquoteissue = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expectedusissueblobkingquoteissue.equals(usissueblobkingquoteissue));
//        System.out.println("The expected is " +expectedusissueblobkingquoteissue+ " and it is " + usissueblobkingquoteissue);
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        description1 = uwa.getDescription();
//        Assert.assertTrue(expecteddescription1.equals(description1));
//        System.out.println("The expected is " +expecteddescription1+ " and it is " + description1);
//
//        Verifytoexception = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
//        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);
//
//        uwa.clickCancel();
//
//        //clicks on edit policy transaction and goes to coverages
//        ra.clickEditPolicyTransaction()
//                .acceptYes()
//                .back();
//
//        //sets the dwelling limit
//
//        coverages.setDwellingLimit(dwellinglimit)
//                .back()
//                .back();
//
//        //sets the year built
//        //step 81
//        dwe.setYearBuilt(yearBuilt1)
//                .clickDwellingquoteissue()
//                .clickDetailsTab();
//
//
//        //verify the blobking quote release
//        uwissueblockingyear = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingyear.equals(uwissueblockingyear));
//        System.out.println("The expected is " +expecteduwissueblockingyear+ " and it is " + uwissueblockingyear);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        descriptionyear = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionyear.equals(descriptionyear));
//        System.out.println("The expected is " +expecteddescriptionyear+ " and it is " + descriptionyear);
//
//        Verifytoexception = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
//        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);
//
//        uwa.clickCancel();
//
//        //clicks on edit policy transaction
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes back to the dwelling
//        ra.back()
//                .back()
//                .back();
//
//        //setting the year to prior to 51 years
//
//        dwe.setYearBuilt(yearBuilt2)
//                .setAnimalsOrExoticPets(animaltrue)
//                .setexoticAnimalType(1, "Exotic")
//                .setexoticAnimalBreed(1, "Other")
//                .setexoticAnimalBiteHistory(1, "false");
//
//        dwe.clickDwellingquote();
//
//        //goes back to the risk analysis pagge
//
//        quote.backToRiskAnalysis();
//
//        //verifies the blocking bind.
//
//        //verify the blobking quote release
//        usissueblobkinghomeanimal = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expectedusissueblobkinghomeanimal.equals(usissueblobkinghomeanimal));
//        System.out.println("The expected is " +expectedusissueblobkinghomeanimal+ " and it is " + usissueblobkinghomeanimal);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        descriptionhomeanimal = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionhomeanimal.equals(descriptionhomeanimal));
//        System.out.println("The expected is " +expecteddescriptionhomeanimal+ " and it is " + descriptionhomeanimal);
//
//        Verifyto = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);
//
//        uwa.clickCancel();
//
//        //clicks on edit policy transaction
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes back to the dwelling
//
//        ra.back().back().back();
//
//
//
//        //change the animal to no and sets the construction type
//
//        dwe.setAnimalsOrExoticPets(animalfalse)
//                .next()
//                .setConstructionType(constructiontype)
//                .clickDwellingconstructionQuote()
//                .backToRiskAnalysis();
//
//        //verify the blocking Bind
//
//        uwissueblockingsuperior = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingsuperior.equals(uwissueblockingsuperior));
//        System.out.println("The expected is " +expecteduwissueblockingsuperior+ " and it is " + uwissueblockingsuperior);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        descriptionconstruction = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionconstruction.equals(descriptionconstruction));
//        System.out.println("The expected is " +expecteddescriptionconstruction+ " and it is " + descriptionconstruction);
//
//        Verifyto = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);
//
//        uwa.clickCancel();
//
//
//        //clicks on edit policy transaction
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes to the dwelling construction
//        ra.back().back();
//
//        //sets the construction type to its back and sets the water heater year
//
//        dwellingConstruction.setConstructionType(constructiontype1)
//                .setWaterHeaterYear(wateryear)
//                .clickDwellingconstructionQuote()
//                .backToRiskAnalysis();
//
//
//        //verify the blocking Bind
//
//        uwissueblockingwater = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingwater.equals(uwissueblockingwater));
//        System.out.println("The expected is " +expecteduwissueblockingwater+ " and it is " + uwissueblockingwater);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//
//        descriptionwaterheater = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionwaterheater.equals(descriptionwaterheater));
//        System.out.println("The expected is " +expecteddescriptionwaterheater+ " and it is " + descriptionwaterheater);
//
//        Verifyto = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
//        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);
//
//
//        uwa.clickCancel();
//
//
//        //clicks on edit policy transaction
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes back to the dwelling construction
//
//        ra.back().back();
//
//        //sets the water heater year and clicks next
//
//        dwellingConstruction.setWaterHeaterYear(wateryear1)
//                .next()
//                .clickPropertyEndorsements()
//                .checkScheduledPersonalProperty()
//                .clickAddScheduledPersonalProperty()
//                .setPersonalPropertyArticleType(1, "Antiques")
//                .setPersonalPropertyDescription(1, "Test")
//                .setPersonalPropertyValue(1, "52,500")
//                .clickcoveragesPropertyEndorsementsQuote()
//                .backToRiskAnalysis();
//
//
//        //verify the blocking Bind
//
//        uwissueblockingspp = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingspp.equals(uwissueblockingspp));
//        System.out.println("The expected is " +expecteduwissueblockingspp+ " and it is " + uwissueblockingspp);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        descriptionspp = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
//        System.out.println("The expected is " +expecteddescriptionspp+ " and it is " + descriptionspp);
//
//
//        Verifytoexception = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
//        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);
//
//
//        uwa.clickCancel();
//
//
//        //clicks on edit policy transaction
//
//        ra.clickEditPolicyTransaction()
//                .acceptYes();
//
//        //goes back to the property endorsements
//        ra.back();
//        coverages.clickPropertyEndorsements()
//                .setPersonalPropertyValue(1, "40,000")
//                .clickAddScheduledPersonalProperty()
//                .setPersonalPropertyArticleType(2, "Antiques")
//                .setPersonalPropertyDescription(2, "Test")
//                .setPersonalPropertyValue(2, "40,000")
//                .clickAddScheduledPersonalProperty()
//                .setPersonalPropertyArticleType(3, "Antiques")
//                .setPersonalPropertyDescription(3, "Test")
//                .setPersonalPropertyValue(3, "40,000")
//                .clickAddScheduledPersonalProperty()
//                .setPersonalPropertyArticleType(4, "Antiques")
//                .setPersonalPropertyDescription(4, "Test")
//                .setPersonalPropertyValue(4, "40,000")
//                .clickcoveragesPropertyEndorsementsQuote()
//                .backToRiskAnalysis();
//
//
//        //verify the blocking Bind
//
//        uwissueblockingspp = ra.getusIssueblockingbind1();
//        Assert.assertTrue(expecteduwissueblockingspp.equals(uwissueblockingspp));
//        System.out.println("The expected is " +expecteduwissueblockingspp+ " and it is " + uwissueblockingspp);
//
//
//        //clicks on request approval
//        ra.riskAnalysisRequestApproval();
//
//        //verifies the dwelling exceeded description and Assign to
//
//        descriptionspp = uwa.getDescription();
//        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
//        System.out.println("The expected is " +expecteddescriptionspp+ " and it is " + descriptionspp);
//
//
//        Verifytoexception = uwa.getAssignTo();
//        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
//        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);
//
//
//        uwa.clickCancel();
//
//
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult testResult, ITestContext itc) {
//        WebDriver driver = LocalDriverManager.getDriver();
//        if (testResult.getStatus() != ITestResult.SUCCESS) {
//            takeScreenShot(driver);
//            System.out.println(String.format("\n'%s' Failed.\n", testResult.getMethod().getMethodName()));
//        }
//        if (driver != null)
//            driver.quit();
//    }
//}