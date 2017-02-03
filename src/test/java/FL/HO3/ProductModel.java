//package FL.HO3;
//
//
//import Helpers.CenterSeleniumHelper;
//import base.BaseTest;
//import base.LocalDriverManager;
//import org.apache.commons.io.FileUtils;
//import org.joda.time.DateTime;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.Login;
//import pageobjects.WizardPanelBase.AccountFileSummary;
//import pageobjects.WizardPanelBase.CreateAccount;
//import pageobjects.WizardPanelBase.EnterAccountInformation;
//import pageobjects.WizardPanelBase.Organizations;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ProductModel extends BaseTest
//{
//    private WebDriver driver;
//    private Login login;
//    private EnterAccountInformation enterAccountInformation;
//    private CenterSeleniumHelper sh;
//    private String dateString;
//
//    @BeforeMethod
//    public void beforeMethod()
//    {
//        DateTime date = new DateTime();
//        dateString = date.toString("MMddhhmmss");
//        System.out.println(new DateTime().toString());
//
//        String user = "Su", password = "";
//        driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
//        sh = new CenterSeleniumHelper(driver);
//        login = new Login(sh, sessionInfo);
//        login.load();
//        login.isLoaded();
//        login.login(user, password);
//        log(String.format("Logged in as: %s\nPassword: %s", user, password));
//
//        sh.wait(5).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//        WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//        Actions build = new Actions(driver);
//        build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//        sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//        enterAccountInformation = new EnterAccountInformation(sh);
//    }
//
//    @Test(description = "Creates account for Florida HO3 product")
//    public void createPersonAccountFLHO3(ITestContext itc)
//    {
//        log(itc.getName());
//        String firstName = String.format("Ricky%s", dateString),
//                lastName = String.format("Bobby%s", dateString),
//                country = "United States",
//                dob = new DateTime().minusYears(30).toString("01/dd/yyyy"),
//                phoneNumber = "4071234567",
//                address = "12000 River Forest Dr",
//                city = "Fort Myers",
//                state = "Florida",
//                addressType = "Home",
//                ssn = "777-12-3456",
//                organizationName = "We Insure",
//                organizationType = Organizations.OrganizationTypes.AGENCY.value,
//                producerCode = "523-23-21531 We Insure(Jacksonville)";
//
//        System.out.println(dob);
//        enterAccountInformation
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setCountry(country);
//
//        CreateAccount createAccount = enterAccountInformation.CreatePersonAccount();
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
//                    .selectVerifiedAddressForCreateAccount(1)
//                    .setAddressType(addressType)
//                    .setSsn(ssn)
//                    .clickOrganizationSearch()
//                    .setOrganizationName(organizationName)
//                    .setOrganizationType(organizationType)
//                    .clickSearchButton()
//                    .clickSelectOrganizationButton()
//                    .setProducerCode(producerCode);
//            AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//                    ", first name: " + firstName + ", last name: " + lastName);
//        }
//        catch (Exception e)
//        {
//            throw new WebDriverException(e);
//        }
//
//
//        try {
//            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
//
//            File file = screenshotDriver.getScreenshotAs(OutputType.FILE);
//            String path = String.format("C:\\Users\\%s\\Desktop\\%s", System.getenv("USERNAME"), file.getName());
//            System.out.println(file.getName());
//            System.out.println(file.getAbsolutePath());
//            System.out.println(screenShotDirectory);
//            FileUtils.copyFile(file, new File(path));
//        }
//        catch (IOException e)
//        {
//
//        }
//    }
//
//    @Test
//    public void productModelFLHO3LessCoverage(ITestContext itc)
//    {
//
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult testResult, ITestContext itc)
//    {
//        WebDriver driver = LocalDriverManager.getDriver();
//        if(testResult.getStatus() != ITestResult.SUCCESS)
//        {
//            takeScreenShot(driver);
//            System.out.println(String.format("\n'%s' Failed.\n", testResult.getMethod().getMethodName()));
//        }
//        if(driver != null)
//            driver.quit();
//    }
//}
