//package PolicyCenter;
//
//import Helpers.CenterSeleniumHelper;
//import base.BaseTest;
//import org.joda.time.DateTime;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobjects.FLHO3.FLHO33EnterAccountInformation;
//import pageobjects.WizardPanelBase.AccountFileSummary;
//import pageobjects.WizardPanelBase.CreateAccount;
//import pageobjects.WizardPanelBase.EnterAccountInformation;
//import pageobjects.Logon;
//
//
//public class AccountTest extends BaseTest
//{
//	private WebDriver driver;
//	private Logon login;
//	private EnterAccountInformation enterAccountInfo;
//	private CenterSeleniumHelper sh;
//	private String dateString;
//
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		DateTime date = new DateTime();
//		dateString = date.toString("MMddhhmmss");
//		log("dateString: " +dateString);
//
//		String user = "mcoad", pwd = "";
//		driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
//		sh = new CenterSeleniumHelper(driver);
//		login = new Logon(sh, sessionInfo);
//		login.load();
//		login.isLoaded();
//		login.login(user, pwd);
//		log("Logged in as: " + user + "\nPassword: " + pwd);
//
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//	}
//
//	@AfterMethod(alwaysRun = true)
//	public void afterMethod(ITestResult testResult)
//	{
//		if(testResult.getStatus() != ITestResult.SUCCESS)
//		{
//			takeScreenShot(driver);
//			System.out.println("\n'" + testResult.getMethod().getMethodName() + "' Failed.\n");
//		}
//		if(driver != null)
//			driver.quit();
//	}
//
//	@Test
//	public void testNewPersonAccount()
//	{
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.createPersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(1)
//			.setAddressType("Home")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//	}
//
//	@Test
//	public void testNewCompanyAccount()
//	{
//		log("Test new company account creation");
//		String companyName = "company " + dateString;
//
//		enterAccountInfo
//			.setCompanyName(companyName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreateCompanyAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", company name: " + companyName);
//	}
//}