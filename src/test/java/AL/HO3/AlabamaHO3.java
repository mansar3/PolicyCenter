package AL.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;

import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import pageobjects.ALHO3.ALHO3Coverages;
//import pageobjects.ALHO3.ALHO3CreateAccount;
//import pageobjects.ALHO3.ALHO3EnterAccountInformation;
import pageobjects.ALHO3.*;
import pageobjects.Login;
import pageobjects.WizardPanelBase.*;

import java.net.MalformedURLException;
import java.net.URL;

public class AlabamaHO3 extends BaseTest
{
    private WebDriver driver;
    private Login login;
    private ALHO3EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString, firstname, lastname;
    private MyActivities ma;

    @BeforeMethod
    public void beforeMethod()
    {
        DateTime date = new DateTime();
        dateString = date.toString("MMddhhmmss");
        System.out.println(new DateTime().toString());

        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
        sh = new CenterSeleniumHelper(driver);
        URL url = null;
        try {
            url = new URL("http://10.0.4.73:8180/pc/PolicyCenter.do");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        login = new Login(sh, sessionInfo);
        login.load();
        login.isLoaded();
        String user = "Su", password = "";
        login.login(user, password);
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
    }

    @Test(description = "Creates account for Alabama HO3 product")
    public void createPersonAccountALHO3(ITestContext itc)
    {
        firstname = String.format("Ricky%s", dateString);
        lastname = String.format("Bobby%s", dateString);
        String user = "Su", password = "";
        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
        log(itc.getName());

        String  country = "United States",
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
        }
        catch (Exception e)
        {
            throw new WebDriverException(e);
        }
    }

    @Test(description = "AL.HO3.ProductModel.Most.001"/*, dependsOnMethods =
            { "createPersonAccountALHO3" }*/)
    public void productModelMostPopular(ITestContext itc)
    {
        log(itc.getName());

        String firstname = "Ricky0209015449";
        String lastname = "Bobby0209015449";
//        firstname = String.format("Ricky%s", dateString);
//        lastname = String.format("Bobby%s", dateString);

        String policyType = "Homeowners (HO3)";
        String defaultOfferingSelection,
                expectedOfferingSelection = "Most Popular";
        String county = "Mobile";
        String yearBuilt = "2000";
        String distanceToFireHydrant = "60";
        String protectionClassCode,
                expectedProtectionClassCode = "5";
        String roofShapeType = "Gable";
        String dwellingLimit = "600000";
        String otherStructuresPercentage,
                expectedOtherStructuresPercentage = "2%";

        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);
        ALHO3SearchAccounts sa = nb.clickSearchAccount();
        ALHO3AccountFileSummary afs = sa.setFirstname(firstname)
                .setLastname(lastname)
                .clickSearchButton()
                .clickAccountNumberSearchAccount();

        afs.westPanel.actions.clickActions();
        afs.westPanel.actions.clickNewSubmission();
        ALHO3NewSubmission ns = new ALHO3NewSubmission(sh);
        ALHO3Qualification qualification = ns.productTable.selectHomeowners();
        defaultOfferingSelection = qualification
                .setPolicyType(policyType)
                .getOfferingSelection();

        Assert.assertTrue(defaultOfferingSelection.equals(expectedOfferingSelection),
                "Expected Offering Selection was " + expectedOfferingSelection +", but it was " + defaultOfferingSelection);

        // Answer 'no' to all 8 questions
        for (int i=0; i< 8; i++) {
            qualification.questionnaire.answerNo(i+1);
        }

        ALHO3Dwelling dwelling = qualification
                .next()
                .next()
                .editLocation()
                .setCounty(county)
                .clickOk()
                .setYearBuilt(yearBuilt)
                .setDistanceToFireHydrant(distanceToFireHydrant);
        dwelling.waitForProtectionClassCode(expectedProtectionClassCode);
        protectionClassCode = dwelling.getProtectionClassCode();
        Assert.assertTrue(expectedProtectionClassCode.equals(protectionClassCode),
                "Expected Protection Class Code was " + expectedProtectionClassCode + ", but it was " + protectionClassCode);

        ALHO3Coverages coverages = dwelling.next()
                .clickWindMitigation()
                .setRoofShapeType(roofShapeType)
                .next()
                .setDwellingLimit(dwellingLimit);
        otherStructuresPercentage = coverages.getOtherStructuresPercentage();
        Assert.assertTrue(expectedOtherStructuresPercentage.equals(otherStructuresPercentage),
                "Expected Other Structures Percentage was " + expectedOtherStructuresPercentage +", but it was " + otherStructuresPercentage);
        System.out.println(coverages.getOtherStructuresLimit());
        System.out.println(String.format("%s, %s", firstname, lastname));

        takeScreenShot(driver);
    }

    @Test(description = "AL.HO3.ProductModel.More.001")
    public void productModelMoreCoverage(ITestContext itc)
    {
        String firstname = "Ricky";
        String lastname = "Bobby";

        ALHO3NavigationBar nb = new ALHO3NavigationBar(sh);

        ALHO3SearchAccounts sa = nb.clickSearchAccount();
        log(itc.getName());
        sa.setFirstname(firstname)
                .setLastname(lastname)
                .clickSearchButton()
                .clickAccountNumberSearchAccount();
        System.out.println(String.format("%s, %s", firstname, lastname));

        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
        Actions build = new Actions(driver);
        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
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
