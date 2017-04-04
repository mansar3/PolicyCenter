package Cancellations.FL;

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
import pageobjects.FLHO6.*;
import pageobjects.Logon;
import pageobjects.Policy.StartCancellationForPolicy;
import pageobjects.Policy.Summary;
import pageobjects.WizardPanelBase.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by spotnuru on 3/24/2017.
 */
public class FLHO6CancelFlat001 extends BaseTest {

    private WebDriver driver;
    private Logon logon;
    private FLHO6EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
    private MyActivities ma;

    String firstname = "FLHO6";
    Random rand = new Random();
    int num = rand.nextInt(99 - 10 + 1) + 10;
    String lastname = "CancelletionProRataTest" + num;

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


    @Test(description = "Creates account for Florida HO3 product")
    public void createPersonAccountAndIssueQuoteFLHO6(ITestContext itc) {

        FLHO6NavigationBar nb = new FLHO6NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(itc.getName());

        String country = "United States",
                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
                phoneNumber = "2561234567",
                address = "3546 Egret Dr",
                city = "Melbourne",
                state = "Florida",
                addressType = "Home",
                ssn = "777-12-7457",
                organizationName = "4",
                organizationType = Organizations.OrganizationTypes.AGENCY.value;



        String policyType = "Condominium (HO6)",
                distanceToFireHydrant = "79",
                weeksrented = "10",
                minrentalincre = "Monthly",
                undercontract = "false",
                inceptionno = "false",
                windpoolfalse = "false",
                distancetocoast = "200",
                yearBuilt = "2000",
                county = "Mobile",
                roofShapeType = "Gable",
                valuation = "Appraisal",
                replacementcost = "400000",
                constructiontype = "Masonry Veneer",
                squarefootage = "3000",
                floor = "1",
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
                dwellinglimit = "350,000",
                personalpropertylimit = "350,000";

        enterAccountInformation = new FLHO6EnterAccountInformation(sh);
        //new FLHO6Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
        enterAccountInformation
                .setFirstName(firstname)
                .setLastName(lastname)
                .setCountry(country);

        FLHO6CreateAccount createAccount = enterAccountInformation.createNewPersonAccountFLHO6();
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
                    .clickSelectOrganizationButton();

            FLHO6AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstname + ", last name: " + lastname);
        } catch (Exception e) {
            throw new WebDriverException(e);
        }

        FLHO6AccountFileSummary afs = new FLHO6AccountFileSummary(sh);
        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        FLHO6NewSubmission ns = new FLHO6NewSubmission(sh);
        FLHO6Qualification qua = ns.productTable.selectHomeowners();

        qua.setPolicyType(policyType);
        qua.getOfferingSelection();
        // to select no for all the blanks
        for (int i = 0; i < 8; i++) {
            qua.questionnaire.answerNo(i + 1);
        }
        FLHO6PolicyInfo pi = qua.next();
        FLHO6Dwelling dwe = pi.next()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant)
                .setAtInceptionOfPolicyIsDeedOwnedByEntity(inceptionno)
                .setInTheWindpool(windpoolfalse)
                .setDistanceToCoast(distancetocoast);
//                .setWeeksRentedAnnually(weeksrented)
//                .setMinimumRentalIncrement(minrentalincre)
//                .underContractWithRentalManagementCompany(undercontract);




        FLHO6Coverages coverages = dwe.next()
//                .setValuationType(valuation)
//                .setEstimatedReplacementCost(replacementcost)
                .setConstructionType(constructiontype)
                .setFloorUnitIsLocatedOn(floor)
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
                .setDwellingLimit(dwellinglimit)
                .setPersonalPropertyLimit(personalpropertylimit);

        FLHO6RiskAnalysis ra = coverages.next();
        ra.clickPriorLosses();

        ra.clickOrderAreport();

        FLHO6Quote quote = ra.quote();

        //issue the policy
        quote.clickIssuePolicy()
                .acceptyes();

        log("Policy has been created");

        SubmissionBound sb = new SubmissionBound(sh, CenterPanelBase.Path.SUBMISSION);
        sb.clickViewYourPolicy();

    }

    @Test(dependsOnMethods =
            { "createPersonAccountAndIssueQuoteFLHO6" })
    public void CancelFlat() throws ParseException {

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
                insurerreason2  = "Material Misrepresentation",
                insurerreason3 = "Risk Does Not Meet Company Guidelines",
                insurerreason4 = "Risk does not meet Occupancy Requirements",
                insurerreason5 = "Substantial change in risk",
                insurerreason6 = "Unable to Conduct a Favorable Company Inspection";


        String futureCanEffecDate = new DateTime().plusDays(2).toString("MM/dd/yyyy");
        String refundMethod, expectedrefundMethod = "Flat";
        String refundMethod1, expectedrefundMethod1 = "Pro rata";
        String cancellationeffdate;
        String policyeffectiveDate;
        String Insurercancellationeffdate;
        String systemdate = new DateTime().toString("MM/dd/yyyy");
        String canceldescription, expectedcanceldescription = "Notice of Cancellation";
        String Insurercancellationeffdate1;

        FLHO6NavigationBar nav = new FLHO6NavigationBar(sh);
        FLHO6SearchAccounts sa = nav.clickSearchAccount();
        sa.setFirstName(firstname);
        sa.setLastName(lastname);
        sa.clickSearchButton();
        sa.clickAccountNumberSearchAccount();

        FLHO6AccountFileSummary afs = new FLHO6AccountFileSummary(sh);
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

        scfp.setCancellationEffectiveDate(futureCanEffecDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(refundMethod1, expectedrefundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1 );
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


        scfp.setCancellationEffectiveDate(futureCanEffecDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1 );
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

        scfp.setCancellationEffectiveDate(futureCanEffecDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1 );
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

        scfp.setCancellationEffectiveDate(futureCanEffecDate);

        //Refund method changes to flat to pro data

        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1 + " . The Refund Method got changed from " + refundMethod + " to " + refundMethod1 );
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
        Date dateobject1 = sdf.parse(Insurercancellationeffdate );
        Date dateobject2 = sdf.parse(policyeffectiveDate );

        DecimalFormat formatter = new DecimalFormat("###,###");

        long diff = dateobject1.getTime() - dateobject2.getTime();

        int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

        System.out.println("diffrence between days: " + diffDays);

        String insuredCanEffectiveDate = String.valueOf(diffDays);
        String insuredDiffEffectiveDate = "25";



        //verify the diffrence between the policy eff date and can effective date

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");



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

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");


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

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");


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

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");


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

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");


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

        //verifies the dates between the current and eff

        Insurercancellationeffdate1 = scfp.getCancellationEffectiveDateEdi();

        String format1 = "MM/dd/yyyy";
        SimpleDateFormat sdf1 = new SimpleDateFormat(format1);
        Date dateobject11 = sdf1.parse(Insurercancellationeffdate1);
        Date dateobject22 = sdf1.parse(policyeffectiveDate);

        DecimalFormat formater = new DecimalFormat("###,###");

        long difff = Math.abs(dateobject11.getTime() - dateobject22.getTime());

        long difffDays = (difff / (24 * 60 * 60 * 1000));




        String insuredCanEffectiveDate1 = String.valueOf(difffDays);
        String insuredDiffEffectiveDate1 = "125";
        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate1 , insuredDiffEffectiveDate1, "The Cancellation effective date diffrence should be 125 days and it is not");


        //verify the cancellation is manditory or not


        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");

        scfp.setReason(insurerreason6)
                .setReasonDescription(reasondescription);

        //verifies the required label
        Assert.assertFalse(scfp.isReasonDescriptionLabelRequired(), "The Reason Description was expected to be required but it was not");


        refundMethod1 = scfp.getRefundMethod();

        try {
            Assert.assertEquals(expectedrefundMethod1, refundMethod1);
            System.out.println("The expected and actual are equal and the Refund Method is : " + refundMethod1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Verifies whether Refund Method is Editable or not

        Assert.assertTrue(scfp.isRefundMethodEditable(), "The Refund Method is not supposed to be editable but it is");

        //verifies the diffrence between the date

        Assert.assertEquals(insuredCanEffectiveDate , insuredDiffEffectiveDate, "The Cancellation effective date diffrence should be 25 days and it is not");


        //verify the cancellation is manditory or not


        Assert.assertTrue(scfp.isCancellationEffectiveDateEditable(), "The Cancellation effective date is supposed to be editable but it was not ");

        //verifies the required label

        Assert.assertTrue(scfp.isCancellationEffectiveDateLabelRequired(), "The Cancellation Effective Date was expected to be a required but it was not");


        //now source will be changed to Insured

        scfp.setSource(source)
                .setReason(reason)
                .setReasonDescription(reasondescription);


        refundMethod = scfp.getRefundMethod();

        //validates the refund method

        try {
            Assert.assertEquals(expectedrefundMethod, refundMethod);
            System.out.println("The expected and actual are equal and the Refund method  is : " + refundMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //verify the cancellation eff date is editable or not

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


        //Hit the start button start button

        scfp.clickStartCancellation()
                .clickScheduleCancellation()
                .accept();

        CancellationBound cb = new CancellationBound(sh);
        cb.clickViewYourPolicy();

        sum.actions.clickForms();

        Forms forms = new Forms(sh);


        String cancelDescription =  forms.getnoticeofcancellationdescription();


        //verifies the notice of cancellation decription
        Assert.assertTrue(cancelDescription.equals(expectedcanceldescription), "In the Description Form# FIM-CXB and Edition 06/14 (Notice Of Cancellation) should be present but it is not");

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult, ITestContext itc)
    {
        WebDriver driver = LocalDriverManager.getDriver();
        if(testResult.getStatus() != ITestResult.SUCCESS)
        {
            takeScreenShot(driver);
            System.out.println(String.format("\n'%s' Failed.\n", testResult.getMethod().getMethodName()));
        }
        if(driver != null)
            driver.quit();
    }
}
