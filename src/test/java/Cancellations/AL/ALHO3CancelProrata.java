package Cancellations.AL;

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
import pageobjects.ALHO3.ALHO3TestingSystemClock;
import pageobjects.Logon;
import pageobjects.Policy.StartCancellationForPolicy;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * Created by spotnuru on 3/23/2017.
 */
public class ALHO3CancelProrata extends BaseTest {

    private WebDriver driver;
    private Logon logon;
    private ALHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private MyActivities ma;

    String firstname = "ALHO3";
    Random rand = new Random();
    int num = rand.nextInt(99 - 10 + 1) + 10;
    String lastname = "CancelletionProRataTest" + num;
    //String lastname = "CancelletionProRataBahu1";

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
        String userName = "su", passWord = "";
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
                protectionclasscode = "6",
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

      //  String effectiveDate = new DateTime().toString("MM/dd/yyyy");

        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
        //new ALHO3Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
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
                    .setSsnUmasked(ssn)
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

        //pi.setEffectiveDate(effectiveDate);
        ALHO3Dwelling dwe = pi.next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setInTheWindpool(windpoolfalse)
                .setDistanceToCoast(distancetocoast)
                .setProtectionClassCode(protectionclasscode);

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

    @Test(dependsOnMethods =
            {"createPersonAccountAndIssueQuoteALHO3"})
    public void CancelProrata() throws ParseException {

        String source = "Insured",
                source1 = "Insurer",
                reason = "Applicant has not obtained ownership of the insured location",
                reason1 = "Insurance Placed Elsewhere",
                reason2 = "Policy not-taken",
                reason3 = "Policy Rewritten with Frontline",
                reason4 = "Insured Request",
                reason5 = "Property Sold",
                reasondescription = "Test";
        String insurerreason = "Excessive Liability Exposure",
                insurerreason1 = "Loss History",
                insurerreason2 = "Material Misrepresentation",
                insurerreason3 = "Risk Does Not Meet Company Guidelines",
                insurerreason4 = "Risk does not meet Occupancy Requirements",
                insurerreason5 = "Substantial change in risk";


        String futureCanEffecDate = new DateTime().plusDays(2).toString("MM/dd/yyyy");
        String refundMethod, expectedrefundMethod = "Flat";
        String refundMethod1, expectedrefundMethod1 = "Pro rata";
        String cancellationeffdate;
        String policyeffectiveDate;
        String Insurercancellationeffdate;
        String systemdate = new DateTime().toString("MM/dd/yyyy");
        String canceldescription, expectedcanceldescription = "Notice of Cancellation";

        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);

        nav.clickInternalToolTab()
                .clickTestingTimeClock();
        ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
        String currentdate = tsc.getCurrentDate();
        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();//.plusYears(1);
        String currentDate = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String futureCanEffectiveDate = dateTime.plusDays(2).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        nav.clickSettings()
                .clickReturntoPolicyCenter();
        
        
        ALHO3SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
        afs.clickInforcedAccountNumber();

        Summary sum = new Summary(sh);

        //gets the policy effective date
        policyeffectiveDate = sum.getpolicyEffectiveDate();


        //clicks on cancel policy
        sum.actions.clickCancelPolicy();

        log("Lands in Start Cancellation for Policy ");

        StartCancellationForPolicy scfp = new StartCancellationForPolicy(sh);

        scfp.setSource(source)
                .setReason(reason)
                .setReasonDescription(reasondescription);


        Assert.assertTrue(scfp.isReasonLabelRequired(), "Reason was expected to be a required field but it was not");


//        Assert.assertFalse(scfp.isReasonDescriptionLabelRequired(),
//                "Reason Description was not expected to be a required field");

        Assert.assertTrue(scfp.isSourceLabelRequired(), "Source was expected to be a required field but it was not");


        refundMethod = scfp.getRefundMethod();

        //validates the refund method

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the Refund method  is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        log("verify the cancellation eff date is editable or not");

        Assert.assertFalse(scfp.isCancellationEffectiveDateEditable(),
                "Effective date was not expected to be editable but it was");


        //verifies the policy date and cancel effec date

        cancellationeffdate = scfp.getCancellationEffectiveDate();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //changes the reason again

        scfp.setReason(reason1)
                .setReasonDescription(reasondescription);

        //verifies the refund method

        refundMethod = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the value is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "Effective date was  expected to be editable but it was not");

        //verifies the policy date and the change eff date

        cancellationeffdate = scfp.getCancellationEffectiveDateEdi();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //now change the effective date to 2 days ahead of the system date

        scfp.setCancellationEffectiveDate(futureCanEffectiveDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(refundMethod1, expectedrefundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //now change the reason to insured request

        scfp.setReason(reason4)
                .setReasonDescription(reasondescription);


        refundMethod = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the value is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "Effective date was  expected to be editable but it was not");

        //verifies the policy date and the change eff date

        cancellationeffdate = scfp.getCancellationEffectiveDateEdi();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        scfp.setCancellationEffectiveDate(futureCanEffectiveDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //now changes the reason to policy not taken

        scfp.setReason(reason2)
                .setReasonDescription(reasondescription);

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the Refund method  is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //verifies the refund method

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method was not expected to be editable ");


        log("verify the cancellation eff date is Editable or not");

        Assert.assertFalse(scfp.isCancellationEffectiveDateEditable(), "Effective date was  expected to be editable but it was not");


        // Policy and can eff dates are same

        cancellationeffdate = scfp.getCancellationEffectiveDate();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //change the reason to policy rewritten

        scfp.setReason(reason3)
                .setReasonDescription(reasondescription);


        log("Verifies the Refund Method");

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the Refund method  is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //verifies the refund method

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method was not expected to be editable ");


        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(),
                "Effective date was  expected to be editable but it was not");

        // Policy and can eff dates are same

        cancellationeffdate = scfp.getCancellationEffectiveDateEdi();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scfp.setCancellationEffectiveDate(futureCanEffectiveDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //now reason changeed to property sold

        scfp.setReason(reason5)
                .setReasonDescription(reasondescription);


        log("Verifies the Refund Method");

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the Refund method  is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        log("Verifies whether Refund Method is refundable or not");

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is supposed to be non Editable but it was");

        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        // Policy and can eff dates are same

        cancellationeffdate = scfp.getCancellationEffectiveDateEdi();

        try {
            Assert.assertEquals(cancellationeffdate, policyeffectiveDate);
            System.out.println("The Cancellation and Policy effective date both are equal and the date is: " + cancellationeffdate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scfp.setCancellationEffectiveDate(futureCanEffectiveDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        log("Now changes in Source from insured to Insurer");

        scfp.setSource(source1)
                .setReason(insurerreason)
                .setReasonDescription(reasondescription);


        //verifies the refund method

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        log("Verifies whether Refund Method is Editable or not");

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");

        Insurercancellationeffdate = scfp.getCancellationEffectiveDateEdi();


        //verifies the dates between the current and eff

        String format = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dateobject1 = sdf.parse(Insurercancellationeffdate);
        Date dateobject2 = sdf.parse(policyeffectiveDate);

        DecimalFormat formatter = new DecimalFormat("###,###");

        long diff = dateobject1.getTime() - dateobject2.getTime();

        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

        System.out.println("diffrence between days: " + diffDays);

        String insuredCanEffectiveDate = String.valueOf(diffDays);
        String insuredDiffEffectiveDate = "35";


        //verify the diffrence between the policy eff date and can effective date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not
        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        //now changes the reason to loss history

        scfp.setReason(insurerreason1)
                .setReasonDescription(reasondescription);


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //Verifies whether Refund Method is Editable or not

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");


        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not
        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        scfp.setReason(insurerreason2)
                .setReasonDescription(reasondescription);


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //Verifies whether Refund Method is Editable or not

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");


        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not
        log("verify the cancellation eff date is editable or not");

        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        scfp.setReason(insurerreason3)
                .setReasonDescription(reasondescription);


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Verifies whether Refund Method is Editable or not

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");


        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not


        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        scfp.setReason(insurerreason4)
                .setReasonDescription(reasondescription);


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Verifies whether Refund Method is Editable or not

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");


        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not


        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        scfp.setReason(insurerreason5)
                .setReasonDescription(reasondescription);

        //verifies the required label
        Assert.assertTrue(scfp.isReasonDescriptionLabelRequired(), "The Reason Description was expected to be required but it was not");


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //Verifies whether Refund Method is Editable or not

        Assert.assertFalse(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");


        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate, insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 35 days and it is not");


        //verify the cancellation is manditory or not


        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");



        String policyCancellationEffectiveDate = scfp.getCancellationEffectiveDateEdi();

        System.out.println(policyCancellationEffectiveDate);


        //Hit the start button start button

        scfp.clickStartCancellation()
                .clickScheduleCancellation()
                .accept();

        CancellationBound cb = new CancellationBound(sh);
        cb.clickViewYourPolicy();


        nav.clickInternalToolTab()
                .clickTestingTimeClock();



        tsc.setDate(policyCancellationEffectiveDate)
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

        nav.clickSearchAccount();
     //   sa.setFirstName(firstname);
      //  sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        afs.clickInforcedAccountNumber();

        sum.actions.clickForms();

        Forms forms = new Forms(sh);


        String cancelDescription =  forms.getnoticeofcancellationdescription();


        //verifies the notice of cancellation decription

        try {
            Assert.assertEquals(cancelDescription, expectedcanceldescription);
            System.out.println("There is a " + cancellationeffdate + " in the Description");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
