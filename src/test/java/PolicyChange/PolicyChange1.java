//package PolicyChange;
//
//import Helpers.CenterSeleniumHelper;
//import PolicyConversion.HO3.*;
//import base.BaseTest;
//import com.sun.xml.internal.ws.policy.AssertionSet;
//import org.apache.poi.ss.formula.functions.T;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.ITestContext;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.ALHO3.*;
//import pageobjects.Logon;
//import pageobjects.Policy.StartPolicyChange;
//import pageobjects.Policy.Summary;
//import pageobjects.WizardPanelBase.CenterPanelBase;
//import pageobjects.WizardPanelBase.MyActivities;
//import pageobjects.WizardPanelBase.Organizations;
//import pageobjects.WizardPanelBase.PolicyChangeBound;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * Created by ssai on 3/17/2017.
// */
//public class PolicyChange1 extends BaseTest {
//
//    private WebDriver driver;
//    private Logon logon;
//    private ALHO3EnterAccountInformation enterAccountInformation;
//    private CenterSeleniumHelper sh;
//    private String dateString, firstname, lastname;
//    private MyActivities ma;
//
//    @BeforeMethod
//    public void beforeMethod()
//    {
//        DateTime date = new DateTime();
//        dateString = date.toString("MMddhhmmss");
//        System.out.println(new DateTime().toString());
//
//        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
//        sh = new CenterSeleniumHelper(driver);
//        logon = new Logon(sh, sessionInfo);
//        logon.load();
//        logon.isLoaded();
//        String userName = "kguy", passWord = "";
//        logon.login(userName, passWord);
//        log(String.format("Logged in as: %s\nPassword: %s", userName, passWord));
//
//        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//        Actions build = new Actions(driver);
//        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//    }
//
//    @Test(description = "Creates account for Alabama HO3 product")
//    public void createPersonAccountAndIssueQuoteALHO3(ITestContext itc)
//    {
//        firstname = String.format("ALHO3PolicyChange", dateString);
//        lastname = String.format("Test11111", dateString);
//        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
//        nb.clickAccountTab();
//        nb.clickNewAccountDropdown();
//        log(itc.getName());
//
//        String  country = "United States",
//                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
//                phoneNumber = "2561234567",
//                address = "5264 Willard Dr N",
//                city = "Theodore",
//                state = "Alabama",
//                addressType = "Home",
//                ssn = "777-12-3456",
//                organizationName = "We Insure",
//                organizationType = Organizations.OrganizationTypes.AGENCY.value,
//                producerCode = "523-23-21531 We Insure(Jacksonville)";
//
//
//        String policyType = "Homeowners (HO3)",
//                distanceToFireHydrant = "79",
//                windpoolfalse = "false",
//                distancetocoast = "200",
//                yearBuilt = "2000",
//                county = "Mobile",
//                roofShapeType = "Gable",
//                valuation = "Appraisal",
//                replacementcost = "400000",
//                constructiontype = "Masonry Veneer",
//                squarefootage = "3000",
//                foundationtype = "Closed",
//                primaryheating = "Electric",
//                secondaryheatingsystem = "false",
//                plumbing = "PVC",
//                plumbingyear = "2010",
//                waterheateryear = "2010",
//                wiring = "Copper",
//                electricalsystem = "Circuit Breaker",
//                rooftype = "Architectural Shingle",
//                roofyear = "2010",
//                conditionofroof= "Good",
//                screenenclosure = "false",
//                dwellingLimit = "600000";
//
//        enterAccountInformation = new ALHO3EnterAccountInformation(sh);
//        //new FLHO3Coverages(sh, CenterPanelBase.Path.POLICYRENEWAL).setPersonalPropertyLimit("fasdf").setOtherStructuresPercentage("afda").clickPropertyEndorsements().
//        enterAccountInformation
//                .setFirstName(firstname)
//                .setLastName(lastname)
//                .setCountry(country);
//
//        ALHO3CreateAccount createAccount = enterAccountInformation.createNewPersonAccountALHO3();
//        log(String.format("Creating new account: %s", dateString));
//
//        try {
//            createAccount
//                    .setCountry(country)
//                    .setDateOfBirth(dob)
//                    .setMobilePhone(phoneNumber)
//                    .setAddressLine1(address)
//                    .setCity(city)
//                    .setState(state)
//                    .clickVerifyAddress()
//                    .selectSuccessfulVerificationIfPossibleForCreateAccount()
//                    .setAddressType(addressType)
//                    .setSsn(ssn)
//                    .clickOrganizationSearch()
//                    .setOrganizationName(organizationName)
//                    .setOrganizationType(organizationType)
//                    .clickSearchButton()
//                    .clickSelectOrganizationButton()
//                    .setProducerCode(producerCode);
//            ALHO3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//                    ", first name: " + firstname + ", last name: " + lastname);
//        }
//        catch (Exception e)
//        {
//            throw new WebDriverException(e);
//        }
//
//        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
//        afs.westPanel.actions.clickActions();
//        afs.westPanel.actions.clickNewSubmission();
//        ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
//        ALHO3Qualification qua = ns.productTable.selectHomeowners();
//
//        qua.setPolicyType(policyType);
//        qua.getOfferingSelection();
//        // to select no for all the blanks
//        for (int i = 0; i < 8; i++) {
//            qua.questionnaire.answerNo(i + 1);
//        }
//        ALHO3PolicyInfo pi = qua.next();
//        ALHO3Dwelling dwe = pi.next()
//                .editLocation()
//                .setCounty(county)
//                .clickOk()
//                .setYearBuilt(yearBuilt)
//                .setDistanceToFireHydrant(distanceToFireHydrant)
//                .setInTheWindpool(windpoolfalse)
//                .setDistanceToCoast(distancetocoast);
//
//        ALHO3Coverages coverages = dwe.next()
//                .setValuationType(valuation)
//                .setEstimatedReplacementCost(replacementcost)
//                .setConstructionType(constructiontype)
//                .setSquareFootage(squarefootage)
//                .setFoundationType(foundationtype)
//                .setPrimaryHeating(primaryheating)
//                .setIsThereASecondaryHeatingSystem(secondaryheatingsystem)
//                .setPlumbing(plumbing)
//                .setPlumbingYear(plumbingyear)
//                .setWaterHeaterYear(waterheateryear)
//                .setWiring(wiring)
//                .setElectricalSystem(electricalsystem)
//                .setRoofType(rooftype)
//                .setRoofYear(roofyear)
//                .setConditionOfRoof(conditionofroof)
//                .setScreenEnclosureOnPremises(screenenclosure)
//                .clickWindMitigation()
//                .setRoofShapeType(roofShapeType)
//                .next()
//                .setDwellingLimit(dwellingLimit);
//
//        ALHO3RiskAnalysis ra = coverages.next();
//        ra.clickPriorLosses();
//
//        ra.clickOrderAreport();
//
//        //creates a A report
//
////        sh.waitForNoMask();
////        driver.findElement(By.id("SubmissionWizard:Job_RiskAnalysisScreen:RiskAnalysisCV:APlusReport_fliLV_tb:OrderAPlusRpt-btnInnerEl'")).click();
//
//        ALHO3Quote quote = ra.quote();
//
//        //issue the policy
//        quote.clickissuePolicy()
//                .acceptyes();
//
//        log("Policy has been created Policy number is: ");
//        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl")));
//        WebElement Policynumber = driver.findElement(By.id("JobComplete:JobCompleteScreen:JobCompleteDV:ViewPolicy-inputEl"));
//        Policynumber.getText();
//        System.out.println(Policynumber);
//
//    }
//
//    @Test
//    public void  PolicyChange()
//    {
//
//        String reason = "Amend Coverage",
//                reason1 = "Amend Alarm Credits";
//        String occuranceaggregateLimit = "25,000 / 50,000";
//        String burgular = "true",
//                burgulartype= "Central Station";
////        String policychangeyes, expectedpolicychangeyes = "Yes";
//
//
//        firstname = String.format("ALHO3PolicyChange", dateString);
//        lastname = String.format("Test11111", dateString);
//
//
//        ALHO3NavigationBar nav = new ALHO3NavigationBar(sh);
//        nav.clickInternalToolTab()
//                .clickTestingTimeClock();
//        ALHO3TestingSystemClock tsc = new ALHO3TestingSystemClock(sh);
//        String currentdate = tsc.getCurrentDate();
//        LocalDate dateTime = LocalDateTime.parse(currentdate, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")).toLocalDate();
//        String futureDate = dateTime.plusDays(55).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        String futureDate1 = dateTime.plusDays(30).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//        nav.clickSettings()
//                .clickReturntoPolicyCenter();
//        sh.waitForNoMask();
//
//
//        ALHO3SearchAccounts sa = nav.clickSearchAccount();
//        sa.setFirstName(firstname);
//        sa.setLastName(lastname);
//        sa.clickSearchButton();
//        sa.clickAccountNumberSearchAccount();
//
//        ALHO3AccountFileSummary afs = new ALHO3AccountFileSummary(sh);
//        StartPolicyChange spc =  afs.clickInforcedAccountNumber().actions.clickChangePolicy();
//
//        spc.setEffectiveDate(futureDate);
//
//        String [] expectedreasonlist = {"Additional Insured/Interest Change", "Amend Alarm Credits", "Amend Coverage","Amend Deductible", "Amend Named Insured", "Amend Occupancy",
//        "Amend Payor", "Amend Wind Mit Credits", "Mailing Address Change", "Mortgage Change", "Other"};
//
//        List<String> list = spc.getTextInReasonList();
//
////        List<String> differences = Arrays.stream(expectedreasonlist).filter(o -> !list.contains(o)).collect(Collectors.toList());
//
//        Set<String> set1 = new HashSet<String>(list);
//        Set<String> set2 = new HashSet<String>(Arrays.asList(expectedreasonlist));
//        set1.removeAll(set2);
//        if(set1.size() > 0) {
//            System.out.println(set1.size());
//        }
//        //todo check set1
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
//
//        list.contains(expectedreasonlist);
//
//        spc.setReason(reason)
//                .next();
//
//        ALHO3PolicyInfo pi = new ALHO3PolicyInfo(sh, CenterPanelBase.Path.POLICYCHANGE);
//        pi.next()
//                .next()
//                .next()
//                .clickPropertyEndorsements()
//                .setOccurrenceAggregateLimit(occuranceaggregateLimit)
//                .next()
//                .next()
//                .quote()
//                .clickPolicyChangeIssuePolicy()
//                .clickPolicyChangePrint();
//
//        PolicyChangeBound pcb = new PolicyChangeBound(sh);
//
//        pcb.clickViewYourPolicy();
//
//        //gets the values from the completed policy transactions
//
//        Summary sum = new Summary(sh);
//
//        System.out.println(sum.getCompletedPolicyTranComment());
//        System.out.println(sum.getTransEffDate());
//        System.out.println(sum.getCompletedPolicyTranPremium());
//        System.out.println(sum.getCompletedPolicyTranType());
//
//        sum.actions.clickChangePolicy();
//
//        //select the effective date and reason
//
//        spc.setEffectiveDate(futureDate1)
//                .setReason(reason1);
//
//        spc.next();
//
//        ALHO3StartPolicyChange startpc = new ALHO3StartPolicyChange(sh, CenterPanelBase.Path.POLICYCHANGE);
//        startpc.clickYes();
//
//
//        //capture the error messgae
//
//        System.out.println(pi.getPolicyInfoErrorMessage());
//
//
//        //goes to dwelling sets the burgular and clicks the policy review
//        pi.next();
//
//        //clicks on protection details
//        ALHO3Dwelling dwe = new ALHO3Dwelling(sh, CenterPanelBase.Path.POLICYCHANGE);
//
//            dwe .clickProtectionDetails()
//                .setBurglarAlarm(burgular)
//                .setBurglarAlarmType(burgulartype)
//                .next()
//                .next()
//                .next()
//                .next();
//
//        ALHO3PolicyReview  pr = new ALHO3PolicyReview(sh, CenterPanelBase.Path.POLICYCHANGE);
//
//        System.out.println(pr.checkPolicyReview());
//
//        pr.quote()
//                .backToPoliycReview();
//
//        pr.clickChangeConflits();
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
//
//    }
//
//
//
//
//}
