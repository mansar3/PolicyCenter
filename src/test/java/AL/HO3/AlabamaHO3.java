package AL.HO3;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;

import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Login;
import pageobjects.WizardPanelBase.*;

import java.net.MalformedURLException;
import java.net.URL;

public class AlabamaHO3 extends BaseTest
{
    private WebDriver driver;
    private Login login;
    private EnterAccountInformation enterAccountInformation;
    private CenterSeleniumHelper sh;
    private String dateString;
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
    }

    @Test(description = "Creates account for Alabama HO3 product")
    public void createPersonAccountALHO3(ITestContext itc)
    {
        String user = "Su", password = "";
        NavigationBar nb = login.login(user, password);
        nb.clickAccountTab();
        nb.clickNewAccountDropdown();
        log(String.format("Logged in as: %s\nPassword: %s", user, password));
        log(itc.getName());

        String firstName = String.format("Ricky%s", dateString),
                lastName = String.format("Bobby%s", dateString),
                country = "United States",
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

        enterAccountInformation = new EnterAccountInformation(sh);

        enterAccountInformation
                .setFirstName(firstName)
                .setLastName(lastName)
                .setCountry(country);

        CreateAccount createAccount = enterAccountInformation.CreatePersonAccount();
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
                    .selectVerifiedAddressForCreateAccount(1)
                    .setAddressType(addressType)
                    .setSsn(ssn)
                    .clickOrganizationSearch()
                    .setOrganizationName(organizationName)
                    .setOrganizationType(organizationType)
                    .clickSearchButton()
                    .clickSelectOrganizationButton()
                    .setProducerCode(producerCode);
            AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
                    ", first name: " + firstName + ", last name: " + lastName);
            takeScreenShot(driver);

        }
        catch (Exception e)
        {
            throw new WebDriverException(e);
        }
    }

    @Test(description = "AL.HO3.ProductModel.More.001")
    public void productModelMore(ITestContext itc)
    {
        log(itc.getName());
        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));

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
