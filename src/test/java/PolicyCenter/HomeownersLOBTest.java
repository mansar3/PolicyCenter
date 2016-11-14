package PolicyCenter;

import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CenterPanel.*;
import pageobjects.Login;

public class HomeownersLOBTest extends BaseTest
{
	private WebDriver driver;
	private Login login;
	private CenterSeleniumHelper sh;
	private String dateString;
	private AccountFileSummary accountFileSummary;

	@BeforeMethod
	public void beforeMethod()
	{
		DateTime date = new DateTime();
		dateString = date.toString("MMddhhmmss");

		System.out.println(new DateTime().toString());
		String user = "mcoad", pwd = "";
		driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
		sh = new CenterSeleniumHelper(driver);
		login = new Login(sh, sessionInfo);
		login.load();
		login.isLoaded();
		login.login(user, pwd);
		log("Logged in as: " + user + "\nPassword: " + pwd);
	}

	@Test
	public void testSimpleSubmission()
	{
		log("Test simple homeowners policy submission");
		String accountNumber = "5015804910";
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();

		log("Answering qualification questions");
		Qualification qualification = submission.productTable.selectHomeowners();
		String policyType = "Homeowners";
		log("Policy Type: " + policyType);
		qualification.setPolicyType("Homeowners");

		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(int i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		Dwelling dwelling = qualification.next().next();

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setBCEG("02").setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();
		dc.setRoofYear("2000").clickMitigation().setRoofShapeType("Hip");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000").next().quote();




		log("Specifying dwelling protection details");
		System.out.println("waiting");
	}
	@Test
	public void AccountPolicyCreator()
	{

		// Create Account

		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
		System.out.println(new DateTime().toString());

		log("Test new person account creation");
		String firstName = "First" + dateString, lastName = "Last" + dateString;

		enterAccountInfo
			.setFirstName(firstName)
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);



		// Create policy

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();

		log("Answering qualification questions");
		Qualification qualification = submission.productTable.selectHomeowners();
		String policyType = "Homeowners";
		log("Policy Type: " + policyType);
		qualification.setPolicyType("Homeowners");

		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(int i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		Dwelling dwelling = qualification.next().next();

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setTerritoryCode("064").setBCEG("02").setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").clickMitigation().setRoofShapeType("Hip");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000").next().quote();
		sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));



		log("Specifying dwelling protection details");
		System.out.println("waiting");
	}
}