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
import pageobjects.ALHO3.*;
import pageobjects.Logon;
import pageobjects.Policy.StartPolicyChange;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by ssai on 3/17/2017.
 */
public class PolicyChange1 extends BaseTest {

    private WebDriver driver;
    private Logon logon;
    private ALHO3EnterAccountInformation enterAccountInformation;
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

    @Test(description = "Creates account for Alabama HO3 product")
    public void createPersonAccountAndIssueQuoteALHO3(ITestContext itc) {
        firstname = String.format("ALHO3PolicyChange", dateString);
        lastname = String.format("Test5", dateString);
        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "2561234567",
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
    public void PolicyChange001() {

        String expectedreason, reason = "Amend Coverage",
                reason1 = "Amend Alarm Credits";
        String occuranceaggregateLimit = "25,000 / 50,000";
        String burgular = "true",
                burgulartype = "Central Station";
        String expectedPolicyType, PolicyType = "Policy Change";
        String reasonlabel, expectedreasonlabel = "Reason";
        String effectivedatelabel, expectedeffectivedatelabel = "Effective Date";

        firstname = String.format("ALHO3PolicyChange", dateString);
        lastname = String.format("Test4111", dateString);


        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();
        String futureDate = dateTime.plusDays(55).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String futureDate1 = dateTime.plusDays(30).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        nav.clickSettings()
                .clickReturntoPolicyCenter();
        sh.waitForNoMask();


        ALHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
        StartPolicyChange spc = afs.clickInforcedAccountNumber().actions.clickChangePolicy();

        spc.setEffectiveDate(futureDate);

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

        log("Verifies the labels in Start Policy Change");

        reasonlabel = spc.getReasonLabel();
        Assert.assertEquals(reasonlabel, expectedreasonlabel);
        System.out.println("The expected label is " + expectedreasonlabel + " and it was " + reasonlabel);



        effectivedatelabel = spc.getEffectiveDateLabel();
        Assert.assertEquals(effectivedatelabel, expectedeffectivedatelabel);
        System.out.println("The expected label is " + expectedeffectivedatelabel + " and it was " + effectivedatelabel);


//        List<String> differences = Arrays.stream(expectedreasonlist).filter(o -> !list.contains(o)).collect(Collectors.toList());

//        Set<String> set1 = new HashSet<String>(list);
//        Set<String> set2 = new HashSet<String>(Arrays.asList(expectedreasonlist));
//        set1.removeAll(set2);
//        if(set1.size() > 0) {
//            System.out.println(set1.size());
//        }
//
//
//         set1 = new HashSet<String>(list);
//         set2 = new HashSet<String>(Arrays.asList(expectedreasonlist));
//         set2.removeAll(set1);
//        if(set2.size() > 0) {
//
//            System.out.println(set2.size());
//        }
//
////        int size = differences.size();
////        System.out.println(size);

//        list.contains(expectedreasonlist);


        spc.setReason(reason)
                .next();

        ALHO3PolicyInfo pi = new ALHO3PolicyInfo(sh, CenterPanelBase.Path.POLICYCHANGE);
        pi.next()
                .next()
                .next()
                .clickPropertyEndorsements()
                .setOccurrenceAggregateLimit(occuranceaggregateLimit)
                .next()
                .next()
                .quote()
                .clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();

        PolicyChangeBound pcb = new PolicyChangeBound(sh);

        pcb.clickViewYourPolicy();

        //gets the values from the completed policy transactions

        Summary sum = new Summary(sh);

        //Verifying the completed policy transactions

        expectedreason = sum.getCompletedPolicyTranComment();
        try {
            Assert.assertEquals(expectedreason, reason);
            System.out.println("The Completed Policy Transaction of Comment is: " + sum.getCompletedPolicyTranComment());
        } catch (Exception e) {
            System.out.println("The Comment is not matching " + e.getMessage());
        }


        System.out.println("The Completed Policy Transaction of Effective Date  is: " + sum.getTransEffDate());


        System.out.println("The Completed Policy Transaction of change of premium  is: " + sum.getCompletedPolicyTranPremium());


        expectedPolicyType = sum.getCompletedPolicyTranType();
        try {
            Assert.assertEquals(expectedPolicyType, PolicyType);
            System.out.println("The Completed Policy Transaction of Type is: " + sum.getCompletedPolicyTranType());
        } catch (Exception e) {
            System.out.println("The Policy Type is not matching " + e.getMessage());
        }


        sum.actions.clickChangePolicy();

        //select the effective date and reason

        spc.setEffectiveDate(futureDate1)
                .setReason(reason1);

        spc.next();

        ALHO3StartPolicyChange startpc = new ALHO3StartPolicyChange(sh, CenterPanelBase.Path.POLICYCHANGE);
        startpc.clickYes();


        //capture the error messgae for the out-of-sequence

        System.out.println(pi.getPolicyInfoErrorMessage());


        //goes to dwelling sets the burgular and clicks the policy review
        pi.next();

        //clicks on protection details
        ALHO3Dwelling dwe = new ALHO3Dwelling(sh, CenterPanelBase.Path.POLICYCHANGE);

        dwe.clickProtectionDetails()
                .setBurglarAlarm(burgular)
                .setBurglarAlarmType(burgulartype)
                .next()
                .next()
                .next()
                .next();

        ALHO3PolicyReview pr = new ALHO3PolicyReview(sh, CenterPanelBase.Path.POLICYCHANGE);

        System.out.println(pr.checkPolicyReview());

        pr.quote()
                .backToPoliycReview();

        pr.clickChangeConflits();

    }

    @Test
    public void PolicyChange002() {

        String expectedreason, reason = "Amend Coverage",
                reason1 = "Amend Alarm Credits";
        String dwellinglimit = "450,000";
        String occuranceaggregateLimit = "25,000 / 50,000";
        String burgular = "true",
                burgulartype = "Central Station";
        String expectedPolicyType, PolicyType = "Policy Change";

        firstname = String.format("ALHO3PolicyChange", dateString);
        lastname = String.format("Test21111", dateString);


        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);
        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();
        String futureDate = dateTime.plusDays(55).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String futureDate1 = dateTime.plusDays(30).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String priorrenewaleffdate = dateTime.plusDays(358).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
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
        pi.clickEditPolicyTransaction()
                .acceptYes();

        //clicks on  quote
        pi.next()
                .next()
                .next()
                .next()
                .quote();

        ALHO3Quote quote = new ALHO3Quote(sh, CenterPanelBase.Path.POLICYRENEWAL);
        quote.issueNow();


        RenewalBound rb = new RenewalBound(sh, CenterPanelBase.Path.POLICYRENEWAL);
        rb.viewYourPolicy();

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

        spc.setEffectiveDate(priorrenewaleffdate)
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

        ALHO3PolicyReview pr = new ALHO3PolicyReview(sh, CenterPanelBase.Path.POLICYCHANGE);

        pr.quote()
                .clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();

        PolicyChangeBound pcb = new PolicyChangeBound(sh);

        //lands on policy info

        pcb.clickViewLaterBound();

        PI.next()
                .next()
                .next();

        //conform the new dwelling limit





        ALHO3Coverages cov = new ALHO3Coverages(sh, CenterPanelBase.Path.POLICYCHANGE);
        cov.next()
                .next();


        //conform the diffrences




        pr.quote()
                .clickPolicyChangeIssuePolicy()
                .clickPolicyChangePrint();

    }


}
