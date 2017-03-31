package PolicyChange;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.ALHO3.*;
import pageobjects.Account.*;
import pageobjects.Logon;
import pageobjects.Policy.StartPolicyChange;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by spotnuru on 3/29/2017.
 */
public class PolicyChange2  extends BaseTest {

    private WebDriver driver;
    private Logon logon;
    private ALHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private MyActivities ma;

    String firstname = "ALHO3";
   // String lastname = "CancelletionTestBahu2";
    Random rand = new Random();
    int num = rand.nextInt(999 - 10 + 1) + 10;
    String lastname = "CancelletionTest" + num;
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
        String userName = "kguy", passWord = "";
        logon.login(userName, passWord);
        log(String.format("Logged in as: %s\nPassword: %s", userName, passWord));

        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
    }


    @Test(description = "Creates account for Alabama HO3 product")
    public void createPersonAccountAndIssueQuoteALHO3(ITestContext itc) {

        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "2560234167",
                address = "5264 Willard Dr N",
                city = "Theodore",
                state = "Alabama",
                addressType = "Home",
                ssn = "777-12-3456",
                organizationName = "We Insure",
                organizationType = Organizations.OrganizationTypes.AGENCY.value,
                producerCode = "523-23-21531 We Insure(Jacksonville)";


        String policyType = "Homeowners (HO3)",
                distanceToFireHydrant = "79",
                windpoolfalse = "false",
                distancetocoast = "200",
                protectionclasscode = "4",
                yearBuilt = "2000",
                county = "Mobile",
                roofShapeType = "Gable",
                valuation = "Appraisal",
                replacementcost = "400000",
                constructiontype = "Masonry Veneer",
                squarefootage = "3000",
                foundationtype = "Closed",
                primaryheating = "Electric",
                secondaryheatingsystem = "false",
                plumbing = "PVC",
                plumbingyear = "2010",
                waterheateryear = "2010",
                wiring = "Copper",
                electricalsystem = "Circuit Breaker",
                rooftype = "Architectural Shingle",
                roofyear = "2010",
                conditionofroof = "Good",
                screenenclosure = "false",
                dwellingLimit = "350,000";

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
        //new FLHO3Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        ALHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountALHO3();
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
                    //.setSsnUmasked(ssn)
                      .setSsn(ssn)
                    .clickOrganizationSearch()
                    .setOrganizationName(organizationName)
                    .setOrganizationType(organizationType)
                    .clickSearchButton()
                    .clickSelectOrganizationButton()
                    .setProducerCode(producerCode);
            ALHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        } catch (Exception e) {
            throw new WebDriverException(e);
        }

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
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setInTheWindpool(windpoolfalse)
                .setProtectionClassCode(protectionclasscode)
                .setDistanceToCoast(distancetocoast);

        ALHO3Coverages coverages = dwe.next()
                .setValuationType(valuation)
                .setEstimatedReplacementCost(replacementcost)
                .setConstructionType(constructiontype)
                .setSquareFootage(squarefootage)
                .setFoundationType(foundationtype)
                .setPrimaryHeating(primaryheating)
                .setIsThereASecondaryHeatingSystem(secondaryheatingsystem)
                .setPlumbing(plumbing)
                .setPlumbingYear(plumbingyear)
                .setWaterHeaterYear(waterheateryear)
                .setWiring(wiring)
                .setElectricalSystem(electricalsystem)
                .setRoofType(rooftype)
                .setRoofYear(roofyear)
                .setConditionOfRoof(conditionofroof)
                .setScreenEnclosureOnPremises(screenenclosure)
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .setDwellingLimit(dwellingLimit);

        ALHO3RiskAnalysis ra = coverages.next();
        ra.clickPriorLosses();

        ra.clickOrderAreport();

        //creates a A report

//        sh.waitForNoMask();
//        driver.findElement(By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:APlusReport_fliLV_tb:OrderAPlusRpt-btnInnerEl'")).click();

        ALHO3Quote quote = ra.quote();

        //issue the policy
        quote.clickissuePolicy()
                .acceptyes();

        log("Policy has been created");

        SubmissionBound sb = new SubmissionBound(sh, CenterPanelBase.Path.SUBMISSION);
        sb.clickViewYourPolicy();

    }

    @Test
    public void PolicyChange002() {

        String  reason = "Amend Coverage",
                reason1 = "Amend Alarm Credits";
        String dwellinglimit = "450,000";


//        String firstname = "ALHO3";
//        String lastname = "CancelletionTestBahu2";


        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();
        String futureDate = dateTime.plusDays(55).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String futureDate1 = dateTime.plusDays(30).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorrenewaleffdate = dateTime.plusDays(341).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))+ " 06:10 PM";
        String oneweekpriorrenewal = dateTime.plusDays(348).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();


        ALHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
        afs.clickInforcedAccountNumber();

        Summary sum = new Summary(sh);
        sum.actions.clickRenewPolicy();
        sum.accept();


        ALHO3Offerings off = new ALHO3Offerings(sh, CenterPanelBase.Path.POLICYRENEWAL);
        off.next();


        ALHO3PolicyInfo pi = new ALHO3PolicyInfo(sh, CenterPanelBase.Path.POLICYRENEWAL);
        pi.next()
                .back();

        //wait for workflow to be done
        pageobjects.Account.AccountFileSummary af = pi.np.clickAccountNumberRenewal();

        //wait for 30 seconds
     //   sh.hardWait(30);

        afs.clickTransactionRenewalPending();

        //

        sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("RenewalWizard:Prev-btnInnerEl"))).click();
     //   sh.driver.findElement(By.id("RenewalWizard:Prev-btnInnerEl")).click();

        ALHO3PolicyReview pr = new ALHO3PolicyReview(sh, CenterPanelBase.Path.POLICYRENEWAL);


        pr.clickEditPolicyTransactionRenewal()
                .acceptYes();

        pr.quoteRenewal();

//        pr.back().back().back().back().back();
//
//        pi.clickEditPolicyTransactionRenewal()
//                .acceptYes();
//
//        pi.quoteRenewal();


        ALHO3Quote quote = new ALHO3Quote(sh, CenterPanelBase.Path.POLICYRENEWAL);
        quote.issueNow();

//        RenewalBound rb = new RenewalBound(sh, CenterPanelBase.Path.POLICYRENEWAL);
//        rb.viewYourPolicy();

        ///time travels to 2 weeks prior to renewal effective date

        nav.clickInternalToolTab()
                .clickTestingTimeClock();

        tsc.setDate(priorrenewaleffdate)
                .clickchangedate();

        //goes to server tools and clicks on batch process info

        nav.clickServerTools()
                .clickBatchProcessInfo();

        //clicks on run workflow

        ALHO3BatchProcessInfo bpi = new ALHO3BatchProcessInfo(sh);
        bpi.clickrunworkflow();

        //goes back to policy center

        nav.clickSettings()
                .clickReturntoPolicyCenter();

        //goes back to the account
        nav.clickSearchAccount();
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        afs.clickInforcedAccountNumber();

        //step number 13
        sum.actions.clickChangePolicy();

        StartPolicyChange spc = new StartPolicyChange(sh);


        String[] expectedreasonlist = {"<none>", "Additional Insured/Interest Change", "Amend Alarm Credits", "Amend Coverage", "Amend Deductible", "Amend Named Insured", "Amend Occupancy",
                "Amend Payor", "Amend Wind Mit Credits", "Mailing Address Change", "Mortgage Change", "Other"};
        List<String> expectedlist = Arrays.asList(expectedreasonlist);


        List<String> list = spc.getTextInReasonList();

        System.out.println(list);
        try {
            Assert.assertEquals(expectedlist, list);
            System.out.println("The expected and actual are equal in the reason drop down list");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        spc.setEffectiveDate(oneweekpriorrenewal)
                .setReason(reason)
                .next();

        ALHO3PolicyInfo PI = new ALHO3PolicyInfo(sh, CenterPanelBase.Path.POLICYCHANGE);

        PI.next()
                .next()
                .next()
                .setDwellingLimit(dwellinglimit)
                .next()
                .next();

//lads on the policy review page verify the policy diffrences


        ALHO3PolicyReview pr1 = new ALHO3PolicyReview(sh, CenterPanelBase.Path.POLICYCHANGE);
        pr1.quote();

        ALHO3Quote quote1 = new ALHO3Quote(sh, CenterPanelBase.Path.POLICYCHANGE);

             quote1.clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();

        PolicyChangeBound pcb = new PolicyChangeBound(sh);

        //lands on policy info

        pcb.clickViewLaterBound();

        PI.next()
                .next()
                .next();

        //conform the new dwelling limit

        ALHO3Coverages cov = new ALHO3Coverages(sh, CenterPanelBase.Path.POLICYCHANGE);

        String newdwellinglimit = cov.getDwellingLimit();
        Assert.assertTrue(newdwellinglimit.equals(dwellinglimit), "The new Dwelling limit has to be carried over to Renewal term but it is not carried over");


        //lands on Policy Info
        cov.next()
                .next();

//        String ChangedDwellingPolicy =   sh.driver.findElement(By.xpath(".//*[@id='PolicyChangeWizard:PolicyChangeWizard_DifferencesScreen:DifferencesPanelSet:DiffTreePanelSet:DiffTreePanelLV-body']//div[text() = '350,000']/../following-sibling::td[1]//div")).getText();
//
//        Assert.assertTrue(ChangedDwellingPolicy.equals(dwellinglimit), "There should be a change in dwelling limit in Existing and Policy change but it was not.");

        //click on quote
        pr1.quote();


        quote1.clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();

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