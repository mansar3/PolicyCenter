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
import pageobjects.Account.AccountFileSummary;
import pageobjects.Logon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by ssai on 3/7/2017.
 */
public class UWIssueALHO3 extends BaseTest {

    private String dateString;
    private WebDriver driver;
    private Logon logon;
    private CenterSeleniumHelper sh;


    @BeforeMethod
    public void beforeMethod() {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        logon = new Logon(sh, sessionInfo);
        logon.load();
        logon.isLoaded();
        String user = "user1baldwin", password = "";
        logon.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates Account for NCUWIssue")
    public void CreatePersonalAccountforNCUWIssue(ITestContext itc) {
        String firstname = "ALHO3UWIssue";
        // String lastname = "Validationrule";
        String lastname = "Validationrule01Test06";
        //  String date = "03/30/1985";
        String homeaddress = "2000 River Forest Rd";
        String city = "Mobile";
        String state = "Alabama";
        String county = "MOBILE";
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
        ca.setAddressLine1(homeaddress);
        ca.setCity(city);
        ca.setCounty(county);
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
    public void ValidatingALHO3UWIssues() {

        String firstname = "ALHO3UWIssue";
        String lastname = "Validationrule01Test06";
        String policyType = "Homeowners (HO3)";
        String distanceToFireHydrant = "79";
        String rooftype = "Flat";
        String rooftype1 = "Hip";
        String dwellinglimit = "400,000",
                dwellinglimit1 = "1,000,000";
        String DateofBirth = "01/01/1982";
        String ssn = "666-77-8888";
        String animaltrue = "true";
        String animalfalse = "false";
        String constructiontype= "Superior",
                constructiontype1 = "Frame";
        String wateryear = "1999",
                wateryear1 = "2010";
        //    String priorDate = new DateTime().minusDays(7).toString("MM/dd/yyyy");
        String uwissueblobkingbind1, expecteduwissueblobkingbind1 = "SSN required for all Named Insureds";
        String uwissueblobkingbind2, expecteduwissueblobkingbind2 = "DOB required for all Named Insureds";
        String uwissueblobkingbind3, expecteduwissueblobkingbind3 = "Flat roofs must be reviewed by Underwriting";
        String Verifyto, expectedVerifyto = "UW Approval - PL Alabama Team";
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
       ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);

        nav.clickInternalToolTab()
                .clickTestingTimeClock();
       ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorDate = dateTime.minusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String yearBuilt = "2010";
        String yearBuilt1 = dateTime.minusYears(51).format(DateTimeFormatter.ofPattern("yyyy"));
        String yearBuilt2 = dateTime.minusYears(14).format(DateTimeFormatter.ofPattern("yyyy"));

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
                .setDistanceToFireHydrant(distanceToFireHydrant);

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

        descriptioneff = uwa.getDescription();
        System.out.println(descriptioneff);
        System.out.println(descriptioneff);
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

        //setting the year to prior to 51 years

        dwe.setYearBuilt(yearBuilt2)
           .setAnimalsOrExoticPets(animaltrue)
                .setexoticAnimalType(1, "Exotic")
                .setexoticAnimalBreed(1, "Other")
                .setexoticAnimalBiteHistory(1, "false");


        //nneed to put the type breed and bite history of the animal
//*[@id= 'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:AnimalListViewInput-tbody']/tr/td/div/div[3]/div/div/table/tbody/tr/td[2]/div//*[@id= 'SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:AnimalListViewInput']/table/tbody/tr/td/div/div[3]/div[1]/div[1]/table/tbody/tr/td[2]/div

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
                .setConstructionType(constructiontype)
                .clickDwellingconstructionQuote()
                .backToRiskAnalysis();

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
                .acceptYes();

        //goes to the dwelling construction
        ra.back().back();

        //sets the construction type to its back and sets the water heater year

        dwellingConstruction.setConstructionType(constructiontype1)
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

        //goes back to the dwelling construction

        ra.back().back();

        //sets the water heater year and clicks next

        dwellingConstruction.setWaterHeaterYear(wateryear1)
                .next()
                .clickPropertyEndorsements()
                .checkScheduledPersonalProperty()
                .clickAddScheduledPersonalProperty()
                .setPersonalPropertyArticleType(1, "Antiques")
                .setPersonalPropertyDescription(1, "Test")
                .setPersonalPropertyValue(1, "52,5000")
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
