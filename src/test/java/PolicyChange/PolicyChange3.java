package PolicyChange;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.FLHO3.*;
import pageobjects.Logon;
import pageobjects.Policy.StartPolicyChange;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ssai on 3/21/2017.
 */
public class PolicyChange3 extends BaseTest {

    private WebDriver driver;
    private Logon logon;
    private FLHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString, firstname, lastname;
    private MyActivities ma;

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

    @Test(description = "Creates account for Florida HO3 product")
    public void createPersonAccountAndIssueQuoteFLHO3(ITestContext itc) {
        firstname = String.format("FLHO3PolicyChange3", dateString);
        lastname = String.format("Test1111", dateString);
        FLHO3NavigationBar nb = new FLHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String country = "United States",
                dob = new DateTime().minusYears(31).toString("01/dd/yyyy"),
                phoneNumber = "4801234567",
                address = "3546 Egret Dr",
                city = "Melbourne",
                state = "Florida",
                addressType = "Home",
                ssn = "887-12-3456",
                organizationName = "4",
                organizationType = Organizations.OrganizationTypes.AGENCY.value;


        String policyType = "Homeowners (HO3)",
                distanceToFireHydrant = "79",
                windpoolfalse = "false",
                distancetocoast = "200",
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

        enterAccountInformation = new FLHO3EnterAccountInformation(sh);
        //new FLHO3Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLHO3();
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
                    .setSsn(ssn)
                    .clickOrganizationSearch()
                    .setOrganizationName(organizationName)
                    .setOrganizationType(organizationType)
                    .clickSearchButton()
                    .clickSelectOrganizationButton();
            FLHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        } catch (Exception e) {
            throw new WebDriverException(e);
        }

        FLHO3AccountFileSummary afs = new FLHO3AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO3NewSubmission ns = new FLHO3NewSubmission(sh);
        FLHO3Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        FLHO3PolicyInfo pi = qua.next();
        FLHO3Dwelling dwe = pi.next()
//                .editLocation()
//                .setCounty(county)
//                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setInTheWindpool(windpoolfalse)
                .setDistanceToCoast(distancetocoast);

        FLHO3Coverages coverages = dwe.next()
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

        FLHO3RiskAnalysis ra = coverages.next();
        ra.clickPriorLosses();

        ra.clickOrderAreport();

        //creates a A report

//        sh.waitForNoMask();
//        driver.findElement(By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:APlusReport_fliLV_tb:OrderAPlusRpt-btnInnerEl'")).click();

        FLHO3Quote quote = ra.quote();

        //issue the policy
        quote.clickissuePolicy()
                .acceptyes();

        log("Policy has been created");

        SubmissionBound sb = new SubmissionBound(sh, CenterPanelBase.Path.SUBMISSION);
        sb.clickViewYourPolicy();


    }

    @Test
    public void PolicyChange003() {

        String expectedreason, reason = "Amend Coverage",
                reason1 = "Amend Alarm Credits";
        String occuranceaggregateLimit = "25,000 / 50,000";
        String burgular = "true",
                burgulartype = "Central Station";
        String expectedPolicyType, PolicyType = "Policy Change";
        String expectedstatus, status= "Quoted";
        String valuationmethod = "Actual Cash Value";
        String allotherperils= "2,000";

        firstname = String.format("FLHO3PolicyChange", dateString);
        lastname = String.format("Test211", dateString);


        FLHO3NavigationBar nav = new FLHO3NavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        FLHO3TestingSystemClock tsc = new FLHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();
        String futureDate = dateTime.plusDays(7).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String futureDate1 = dateTime.plusDays(5).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();


        FLHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        FLHO3AccountFileSummary afs = new FLHO3AccountFileSummary(sh);
        StartPolicyChange spc = afs.clickInforcedAccountNumber().actions.clickChangePolicy();

        spc.setEffectiveDate(futureDate);

        String[] expectedreasonlist = {"<none>", "Additional Insured/Interest Change", "Amend Alarm Credits", "Amend Coverage", "Amend Deductible", "Amend Named Insured", "Amend Occupancy",
                "Amend Payor", "Amend Wind Mit Credits", "Mailing Address Change", "Mortgage Change", "Other"};
        List<String> expectedlist = Arrays.asList(expectedreasonlist);


        List<String> list = spc.getTextInReasonList();

//        System.out.println(list);
//        try {
//            Assert.assertEquals(expectedlist, list);
//            System.out.println("The expected and actual are equal in the reason drop down list");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        spc.setReason(reason)
                .next();

        FLHO3PolicyInfo pi = new FLHO3PolicyInfo(sh, CenterPanelBase.Path.POLICYCHANGE);
        pi.next()
                .next()
                .next();

        FLHO3Coverages cov = new FLHO3Coverages(sh, CenterPanelBase.Path.POLICYCHANGE);
        cov.setPersonalPropertyValuationMethod(valuationmethod)
                .coveragesQuote()
                .clicktopPolicyNumber();

        Summary sum = new Summary(sh);


        log("Verifies the Pending Policy Transaction");

        expectedstatus = sum.getPendingPolicyTranStatus();
        Assert.assertEquals(expectedstatus, status);
        System.out.println("The Pending Policy Transaction status is " + expectedstatus);

        expectedPolicyType = sum.getPendingPolicyTranType();
        Assert.assertEquals(expectedPolicyType, PolicyType);
        System.out.println("The Pending Policy Transaction status is " + expectedPolicyType);


        System.out.println("The Pending Policy Transaction of Effective Date  is: " + sum.getPendingPolicyTranEffecDate());

        //change tge policy again

        sum.actions.clickChangePolicy()
                .setEffectiveDate(futureDate1)
                .setReason(reason)
                .next();

        //goes to coverages

        pi.next()
                .next()
                .next();

        cov.setAllOtherPerils(allotherperils)
                .coveragesQuote()
                .clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();


























//                .clickPropertyEndorsements()
//                .setOccurrenceAggregateLimit(occuranceaggregateLimit)
//                .next()
//                .next()
//                .quote()
//                .clickPolicyChangeIssuePolicy()
//                .clickPolicyChangePrint();

        PolicyChangeBound pcb = new PolicyChangeBound(sh);

        pcb.clickViewYourPolicy();
    }


}
