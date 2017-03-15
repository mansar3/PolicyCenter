package NC.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Account.AccountFileSummary;
import pageobjects.Logon;
import pageobjects.NCHO3.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by ssai on 3/15/2017.
 */
public class UWIssueNCHO3 extends BaseTest {

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
        String user = "user1sfi", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for FLUWIssue")
    public void CreatesAccountandValdatingFLUWIssue(ITestContext itc) {
        String firstname = "NCHO3UWIssue";
        Random rand = new Random();
        int num  = rand.nextInt(99 - 10 + 1)+10;
        String lastname = "ValidationruleTest"+num;
        String homeaddress = "2511 W Beach Dr";
        String city = "Oak Island";
        String state = "North Carolina";
        String county = "Brunswick";
        String zip = "28465";
        String addrestype = "Home";
        String producercode = "523-23-50004 SFI Group, Inc - Carteret";
        String policyType = "Homeowners (HO3)";
        String distanceToFireHydrant = "79";
        String rooftype = "Hip";
        String DateofBirth = "06/14/1970";
        String ssn = "111-11-1111";
        String dwellinglimit = "400,000",
                dwellinglimit1 = "1,000,000";
        String animaltrue = "true";
        String animalfalse = "false";
        String constructiontype= "Superior";
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String Verifyto, expectedVerifyto = "UW Approval - PL North Carolina  Team";
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



        NCHO3NavigationBar nav = new NCHO3NavigationBar(sh);
        nav.clickAccountTab();
        nav.clickNewAccountDropdown();

        NCHO3EnterAccountInformation eai = new NCHO3EnterAccountInformation(sh);
        eai.setFirstName(firstname);
        eai.setLastName(lastname);
        eai.clickSearch();
        eai.createNewPersonAccountNCHO3();

        NCHO3CreateAccount ca = new NCHO3CreateAccount(sh);
        //  ca.setDateOfBirth(date);
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setCounty(county);
        ca.setState(state);
        ca.setZipCode(zip);
        ca.clickVerifyAddress();
        driver.findElement(By.id("FP_VerifiedAddressSelectionPopup:0:_Select")).click();
        ca.setAddressType(addrestype);
        ca.setProducerCode(producercode);
        ca.update();


        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        NCHO3TestingSystemClock tsc = new NCHO3TestingSystemClock(sh);
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

        NCHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();


        NCHO3AccountFileSummary afs = new NCHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        NCHO3NewSubmission ns = new NCHO3NewSubmission(sh);
        NCHO3Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        NCHO3PolicyInfo pi = qua.next();
        NCHO3Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant);

        NCHO3DwellingConstruction dwellingConstruction = dwe.next();


        NCHO3Coverages coverages = dwellingConstruction.clickWindMitigation()
                .setRoofShapeType(rooftype)
                .next()
                .setDwellingLimit(dwellinglimit);

        NCHO3RiskAnalysis ra = coverages.next();

        NCHO3Quote quote = ra.quote();

        quote.backToRiskAnalysis();

        //validating the UWIssues in Blocking Bind

        uwissueblobkingbind1 = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblobkingbind1.equals(uwissueblobkingbind1));
        System.out.println("The expected is " + expecteduwissueblobkingbind1 + " and it is " + uwissueblobkingbind1);

        uwissueblobkingbind2 = ra.getusIssueblockingbind2();
        Assert.assertTrue(expecteduwissueblobkingbind2.equals(uwissueblobkingbind2));
        System.out.println("The expected is " + expecteduwissueblobkingbind2 + " and it is " + uwissueblobkingbind2);

        //clicks the request approval
        NCHO3UWActivity uwa = ra.riskAnalysisRequestApproval();

        //verifies the Assign to
        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        //clicks the account number

        AccountFileSummary af = ra.np.clickAccountNumber();

        af.westPanel.clickContacts().clickNameAccountFileContacts().setSsn(ssn).setDateOfBirth(DateofBirth).clickupdate();
        af.westPanel.clickPolicyTransaction().clickTransactionNumber();

//        ra.clickEditPolicyTransaction()
//                .acceptYes();


        //goes to policy info

        qua.next();


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
                .setAnimalsOrExoticPets(animaltrue)
                .setexoticAnimalType(1, "Exotic")
                .setexoticAnimalBreed(1, "Other")
                .setexoticAnimalBiteHistory(1, "false");

        dwe.clickDwellingquote();

        //goes back to the risk analysis pagge

        quote.backToRiskAnalysis();

        //verifies the blocking bind.

        //verify the blobking quote release
        usissueblobkinghomeanimal = ra.getusIssueblockingbind1();
        Assert.assertTrue(expectedusissueblobkinghomeanimal.equals(usissueblobkinghomeanimal));
        System.out.println("The expected is " +expectedusissueblobkinghomeanimal+ " and it is " + usissueblobkinghomeanimal);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        descriptionhomeanimal = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionhomeanimal.equals(descriptionhomeanimal));
        System.out.println("The expected is " +expecteddescriptionhomeanimal+ " and it is " + descriptionhomeanimal);

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();

        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the dwelling

        ra.back().back().back();



        //change the animal to no and sets the construction type

        dwe.setAnimalsOrExoticPets(animalfalse)
                .next()
                .setWaterHeaterYear(wateryear)
                .clickDwellingconstructionQuote()
                .backToRiskAnalysis();

        //verify the blocking Bind

        uwissueblockingwater = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingwater.equals(uwissueblockingwater));
        System.out.println("The expected is " +expecteduwissueblockingwater+ " and it is " + uwissueblockingwater);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();


        descriptionwaterheater = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionwaterheater.equals(descriptionwaterheater));
        System.out.println("The expected is " +expecteddescriptionwaterheater+ " and it is " + descriptionwaterheater);

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);


        uwa.clickCancel();


        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the dwelling

        ra.back().back();


        //sets the water heater year

        dwellingConstruction.setWaterHeaterYear(wateryear1)
                .next()
                .clickPropertyEndorsements()
                .checkScheduledPersonalProperty()
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, "Stamps")
                .setPersonalPropertyDescription(1, "Test")
                .setPersonalPropertyValue(1, "52,500")
                .clickcoveragesPropertyEndorsementsQuote()
                .backToRiskAnalysis();


        //verify the blocking Bind

        uwissueblockingspp = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingspp.equals(uwissueblockingspp));
        System.out.println("The expected is " +expecteduwissueblockingspp+ " and it is " + uwissueblockingspp);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        descriptionspp = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
        System.out.println("The expected is " +expecteddescriptionspp+ " and it is " + descriptionspp);


        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);


        uwa.clickCancel();


        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes back to the property endorsements
        ra.back();
        coverages.clickPropertyEndorsements()
                .setPersonalPropertyValue(1, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(2, "Stamps")
                .setPersonalPropertyDescription(2, "Test")
                .setPersonalPropertyValue(2, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(3, "Stamps")
                .setPersonalPropertyDescription(3, "Test")
                .setPersonalPropertyValue(3, "40,000")
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(4, "Stamps")
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

        //verifies the dwelling exceeded description and Assign to

        descriptionspp = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionspp.equals(descriptionspp));
        System.out.println("The expected is " +expecteddescriptionspp+ " and it is " + descriptionspp);


        Verifytoexception = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifytoexception.equals(Verifytoexception));
        System.out.println("The expected is " +expectedVerifytoexception+ " and it is " + Verifytoexception);


        uwa.clickCancel();


        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();

        //goes to the coverages

        ra.back();
        coverages.clickPropertyEndorsements()
                .uncheckScheduledPersonalProperty()
                .clickCoverages()
                .back();

        dwellingConstruction.setConstructionType(constructiontype)
                .clickDwellingconstructionQuote()
                .backToRiskAnalysis();


        //verify the blocking Bind

        //verify the blocking Bind

        uwissueblockingsuperior = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingsuperior.equals(uwissueblockingsuperior));
        System.out.println("The expected is " +expecteduwissueblockingsuperior+ " and it is " + uwissueblockingsuperior);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        descriptionconstruction = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionconstruction.equals(descriptionconstruction));
        System.out.println("The expected is " +expecteddescriptionconstruction+ " and it is " + descriptionconstruction);

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();


        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();   //verify the blocking Bind

        uwissueblockingsuperior = ra.getusIssueblockingbind1();
        Assert.assertTrue(expecteduwissueblockingsuperior.equals(uwissueblockingsuperior));
        System.out.println("The expected is " +expecteduwissueblockingsuperior+ " and it is " + uwissueblockingsuperior);


        //clicks on request approval
        ra.riskAnalysisRequestApproval();

        //verifies the dwelling exceeded description and Assign to

        descriptionconstruction = uwa.getDescription();
        Assert.assertTrue(expecteddescriptionconstruction.equals(descriptionconstruction));
        System.out.println("The expected is " +expecteddescriptionconstruction+ " and it is " + descriptionconstruction);

        Verifyto = uwa.getAssignTo();
        Assert.assertTrue(expectedVerifyto.equals(Verifyto));
        System.out.println("The expected is " + expectedVerifyto + " and it is " + Verifyto);

        uwa.clickCancel();


        //clicks on edit policy transaction

        ra.clickEditPolicyTransaction()
                .acceptYes();



    }
}
