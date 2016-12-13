package PolicyCenter;

import DataProviders.AccountPolicyGenerator;
import DataProviders.PolicyCreatorData;
import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CenterPanel.*;
import pageobjects.Login;

import java.util.LinkedHashMap;

@Test
public class HomeownersLOBTest extends BaseTest
{
	private WebDriver driver;
	private Login login;
	private CenterSeleniumHelper sh;
	private String dateString;
	private AccountFileSummary accountFileSummary;
	private String 	policyNumHO3 = "FPH3-324237878",
					policyNumDP3 = "FPD3-324237824";

	@BeforeMethod
	public void beforeMethod()
	{
		DateTime date = new DateTime();
		dateString = date.toString("MMddhhmmss");

		System.out.println(new DateTime().toString());
		// users: conversion2,mcoad
		String user = "mcoad", pwd = "";
		driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
		sh = new CenterSeleniumHelper(driver);
		login = new Login(sh, sessionInfo);
		login.load();
		login.isLoaded();
		login.login(user, pwd);
		log("Logged in as: " + user + "\nPassword: " + pwd);
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult testResult)
	{
		if(testResult.getStatus() != ITestResult.SUCCESS)
		{
			takeScreenShot(driver);
			System.out.println("\n'" + testResult.getMethod().getMethodName() + "' Failed.\n");
		}
		if(driver != null)
			driver.quit();
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
		dc.setRoofYear("2000").clickWindMitigation().setRoofShapeType("Hip");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000").next().quote();




		log("Specifying dwelling protection details");
		System.out.println("waiting");
	}

	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
	public void AccountPolicyCreatorPOCWithHash(LinkedHashMap<String, String> eai)
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
		String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = insuredName[0], lastName = insuredName[1];

		enterAccountInfo
			.setFirstName(firstName)
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1(eai.get("Mailing Address"))
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))

			.setZipCode(eai.get("Mailing Zipcode"))
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType(eai.get("Address Type"))
			.setOrganization(eai.get("Organization"))
			.setProducerCode(eai.get("Producer Code"));
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

		String policyType = eai.get("Policy Type");
		log("Policy Type: " + eai.get("Policy Type"));
		qualification.setPolicyType(eai.get("Policy Type"));

		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(int i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		Dwelling dwelling = qualification.next().next();

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt(eai.get("Year Built"))
		.setDistanceToFireHydrant(eai.get("Distance to Fire Hydrant")).setTerritoryCode(eai.get("Territory Code"))
		.setBCEG(eai.get("BCEG")).setProtectionClassCode(eai.get("Protection Class Code"));

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear(eai.get("Roof Year")).clickWindMitigation().setRoofShapeType(eai.get("Roof Shape"));
		Coverages co = dc.next();
		co.setDwellingLimit(eai.get("Dwelling Limit")).setPersonalPropertyLimit(eai.get("Personal Property - Limit"))
		.next().quote().back().requestApproval().sendRequest();
		sh.waitForElementToAppear(By.id("SubmissionWizard:Job_RiskAnalysisScreen:0"));



		log("Specifying dwelling protection details");
		log("Waiting for Quote Page.");
	}

	// Renewal types
	public void FLH03AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc")
		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("Florida")
		.setProduct("Homeowners")
		.setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumHO3)
		.setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017")
		.setLastInspectionCompletionDate("03/21/2015")
		.setInflationGuard("12%")
		.clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler")
		.clickDoesInsuredOwnOtherResidence(false)
		.setTermType("Annual");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setHousekeepingCondition("Good")
		.setSwimmingPool(true)
		.setPoolLocation("In-Ground")
		.setPoolFenced(true)
		.setFenceType("Screen Enclosure")
		.setDivingBoard(true)
		.setPoolSlide(true)
		.setTrampolineOnPremises(true)
		.setSkateboardBicycleRampOnPremises(true)
		.setAnimalsOrExoticPets(false)
		.setGolfCarts(true)
		.setRecreationalVehiclesOwned(true)
		.setOwnedByOther(false)
		.setOccupiedDaily(false);

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setDistanceToFireStation("2100")
		.setTerritoryCode("064")
		.setBCEG("02")
		.setProtectionClassCode("2")


		// Protection Details
		.clickProtectionDetails()
		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		.setBurglarAlarm(true)

		.setLockedPrivacyFence(true)
		.setBurglarBarsOnWindows(true)
		.setCommunityGuarded(true)
		.setGatedCommunity(true)
		.setFireAlarm(true)
		.setSmokeAlarm(true)
		.setFireExtinguishers(true)
		.setSprinklerSystem(true)
		.setDeadbolts(true)
		.setResidenceVisibleToNeighbors(true)
		.safetyLatchesPresent(true)
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setAlarmType("Central Station")

		// Additional Interests
		.clickAdditionalInterests()
		.clickAddNewPerson()
		.setType("Additional Insured")
		.clickCertificateRequired(true)
		.setLoanNumber("747384")
		.setFirstName("Jelly")
		.setLastName("Junior")
		.setDateOfBirth("10/20/1986")
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("123-254-8457")
		.setFaxPhone("156-984-5478")
		.setPrimaryEmail("jelly@jellymail.com")
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1("2470 Wild Wood dr")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickVerifyAddress()
		.selectAddress(2)
		.setAddressType("Billing");



		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000")
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setConditionOfRoof("Good")


//		.setPlumbingSystemHaveKnownLeaks(true)
//		.setBuildingRetrofittedForEarthquakes(true)
////		.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
//		.setUncorrectedFireOrBuildingCodeViolations(true)
//		.setStructureOriginallyBuiltForOtherThanPrivateResidence(true)
//		.setLeadPaintHazard(true)
////		.setLeadPaintHazardDescription("best")
////		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
////		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")

		// Wind Mitigation
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
		.setTerrain("C")
		.setRoofCover("FBC Equivalent")
		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
		.setRoofWallConnection("Clips")
		.clickSecondaryWaterResistance(true).next()

		// Coverages
		.setDwellingLimit("300000")
		.setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value")
		.setLossOfUseSelection("5%")
		.setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000")
		.setHurricane("2%")
		.setMedicalPaymentsLimit("5,000")

		// Property Endorsements
		.clickPropertyEndorsements()
//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.checkScheduledPersonalProperty()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkSinkholeLossCoverage()
		.next()
		.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void NCH03AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Jacksonville")
			.setState("North Carolina")
			.setZipCode("28546")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("104 Baymeade Ct")
			.setCity("Jacksonville")
			.setState("North Carolina")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("North Carolina")

			.setZipCode("28546")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("North Carolina").setProduct("Homeowners").setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumHO3).setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015");//.setInflationGuard("12%").clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners").setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
		.setMarketValue("6000000").setResidenceType("Duplex")
		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setTerritoryCode("140")//.setBCEG("02")
		 .setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
		.clickWindMitigation().setDiscountType("Fortified Home").setFortifiedHomeType("Silver - Option 1")
		.setRoofShapeType("Hip").setOpeningProtectionType("Hurricane");//.setTerrain("C")
//		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value").setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000")//.setMedicalPaymentsLimit("5,000")
		.setWindDeductibleType("Named Storm").setNamedStorm("5%")
		.next().quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void SCH03AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Charleston")
			.setState("South Carolina")
			.setZipCode("29401")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("32 Legare St")
			.setCity("Charleston")
			.setState("South Carolina")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("South Carolina")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("South Carolina").setProduct("Homeowners").setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumHO3).setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015").setInflationGuard("12%").clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners").setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
		.setMarketValue("6000000").setResidenceType("Duplex")
		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setTerritoryCode("04S").setBCEG("02").setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane");//.setTerrain("C")
//		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000").next().quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void ALH03AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Saraland")
			.setState("Alabama")
			.setZipCode("36571")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("5 Laredo Drive")
			.setCity("Saraland")
			.setState("Alabama")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Alabama")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("Alabama").setProduct("Homeowners").setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumHO3).setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%")
		.clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners").setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
		.setMarketValue("6000000").setResidenceType("Duplex")
		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")//.setTerritoryCode("064")
		//.setBCEG("02")
		.setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane");//.setTerrain("C")
		//.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
		.next().quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void FLDP3AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("Florida").setProduct("Homeowners").setPolicyType("Dwelling Fire")
		.setLegacyPolicyNumber(policyNumDP3).setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage(true)
		.setTheftCoverage("Limited");
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Dwelling Fire").setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
		.setMarketValue("6000000").setResidenceType("Duplex")
		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setDistanceToFireStation("2000").setTerritoryCode("064").setBCEG("02").setProtectionClassCode("2")
		.setAtInceptionOfPolicyIsDeedOwnedByEntity(false);

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane").setTerrain("C")
		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
		.next().quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void SCDP3AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Charleston")
			.setState("South Carolina")
			.setZipCode("29401")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("32 Legare St")
			.setCity("Charleston")
			.setState("South Carolina")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("South Carolina")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("South Carolina").setProduct("Homeowners").setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumDP3).setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage(true);
		.setTheftCoverage("Limited");
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Dwelling Fire").setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
		.setMarketValue("6000000").setResidenceType("Duplex")
		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000").setDistanceToFireStation("2000").setTerritoryCode("064").setBCEG("02").setProtectionClassCode("2")
		.setAtInceptionOfPolicyIsDeedOwnedByEntity(false);

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane").setTerrain("C")
		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
		.next().quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void FFH3AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc")
		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("Florida").setProduct("Homeowners")
		.setPolicyType("Homeowners")
		.setLegacyPolicyNumber("FFH3-324237913")
		.setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017")
		.setLastInspectionCompletionDate("03/21/2015")
		.setInflationGuard("12%")
		.clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setTerritoryCode("064")
		.setBCEG("02")
		.setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000")
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setConditionOfRoof("Good")
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
		.setTerrain("C")
		.setRoofCover("FBC Equivalent")
		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
		.setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000")
		.setPersonalPropertyLimit("150000")
		.next()
		.quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}

	public void FFH4AccountRenewalPOC()
	{
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
			.setOrganization("Brown and Brown of Florida, Inc")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal

		log("Test simple homeowners policy submission");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
		imr.setOrganization("Brown and Brown of Florida, Inc")
		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("Florida")
		.setProduct("Homeowners")
		.setPolicyType("Homeowners")
		.setLegacyPolicyNumber("FFH3-324237913")
		.setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017")
		.setLastInspectionCompletionDate("03/21/2015")
		.setInflationGuard("12%")
		.clickExcludeLossOfUseCoverage(true);
		Offerings offerings = imr.nextAndAccept();
		offerings.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();
		pi.setOccupation("Twinkie Smuggler");

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setTerritoryCode("064")
		.setBCEG("02")
		.setProtectionClassCode("2");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000")
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setConditionOfRoof("Good")
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
		.setTerrain("C")
		.setRoofCover("FBC Equivalent")
		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
		.setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000")
		.setPersonalPropertyLimit("150000")
		.next()
		.quote();//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}




	public void FLHO3AccountPolicyCreatorPOC()
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
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1("2470 Wild Wood Dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setDateOfBirth("03/15/1987")
			.setHomePhone("456-748-1503")
			.setWorkPhone("958-562-1250")
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail("djfklajs@gmail.com")
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState("Florida")

			.setZipCode("32935")
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType("Home")
			.setDescription("Nerd Lair")
			.setSsn("555-44-3333")
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
		qualification.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular");

		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(int i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		PolicyInfo pi = qualification.next();
		pi.setOccupation("Twinkie Smuggler")
		.clickDoesInsuredOwnOtherResidence(true)
		.setTermType("Annual");
		//.setEffectiveDate("11/14/2016").setOrganization().setProducerCode().setPolicyWriter().setUnderwritingCompanies();

		Dwelling dwelling = pi.next();
		dwelling.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setHousekeepingCondition("Good");

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setTerritoryCode("064")
		.setBCEG("02")
		.setProtectionClassCode("2")
		.clickProtectionDetails()
		.setBurglarAlarm(true)
		.setLockedPrivacyFence(true)
		.setBurglarBarsOnWindows(true)
		.setCommunityGuarded(true)
		.setGatedCommunity(true)
		.setFireAlarm(true)
		.setSmokeAlarm(true)
		.setFireExtinguishers(true)
		.setSprinklerSystem(true)
		.setDeadbolts(true)
		.setResidenceVisibleToNeighbors(true)
		.safetyLatchesPresent(true)
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setAlarmType("Central Station");

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear("2000")
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setConditionOfRoof("Good")
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
		.setTerrain("C")
		.setRoofCover("FBC Equivalent")
		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
		.setRoofWallConnection("Clips");
		Coverages co = dc.next();
		co.setDwellingLimit("300000")
		.setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value")
		.setLossOfUseSelection("5%")
		.setAllOtherPerils("5,000")
		.setPersonalLiabilityLimit("500,000")
		.setMedicalPaymentsLimit("5,000")
		.next()
		.quote();
		sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));



		log("Specifying dwelling protection details");
		System.out.println("waiting");
	}

	@Test(dataProviderClass = PolicyCreatorData.class, dataProvider = "TestingCSV")
	public void AccountPolicyCreatorDoc(String NameInsured , String DateofBirth , String HomePhone , String WorkPhone , String EmailAddress , String MailingAddress ,
										String MailingCity , String MailingCounty , String MailingState , String MailingZipcode , String AddressType , String SSN ,
										String Organization , String ProducerCode , String BaseSate , String Product , String PolicyType , String LegacyPolicyNumber ,
										String PolicyOriginalEffectiveDate , String LastInspectionCompletionDate , String InflationGuard ,
										String AdditionalResidenceRentedtoOthersLocation , String ExcludeLossofUseCoverage , String PolicyType2 , String OfferingSelection ,
										String secondNameInsuredName , String secondNameInsuredDateofBirth , String secondnameInsuredSSN , String SeniorCitizenDiscount ,
										String DoestheinsuredownanyotherresidencethatisinsruedwithFrontline , String LocationAddress , String YearBuilt ,
										String DistancetoFireHydrant , String DistancetoFireStation , String TerritoryCode , String BCEG , String ProtectionClassCode ,
										String LocationType , String IntheWindpool , String DistancetoCoast , String PurchaseDate , String PurchasePrice , String MarketValue ,
										String AttheinceptionofthispolicywillthispropertybedeededinthenameofcorporationbusinessLLCoranyotherentity ,
										String OccupiedDaily , String ResidenceType , String HowisthedwellingcustomarilyUsed , String Howisthedwellingoccupied ,
										String WeeksRentedAnnually , String MinimRentalIncrement , String UnderContractwithRentalManagementcompany , String Isthereaswimmingpool ,
										String Isthereatrampoline , String isthereaskateboardorbicycleramponpremises , String Anyanimalsorexoticpetsonpremses ,
										String AnyownedGolfCarts , String Anyownedrecreationalvehicles , String HousekeepingCondition , String BurglarAlarmType ,
										String Istherealockedprivacyfence , String arethereanyburglarbarsonthewindowsdoors , String IsthecommunityGuarded ,
										String IsthecommunityGated , String FireAlarmtype , String SmokeAlarms , String Oneormorefireextinguishersinthehome ,
										String SprinklerSystem , String Deadbolts , String ResidenceVisibletoneighbors , String AdditionalInterest1Type ,
										String AdditionalInterest1LoanNumber , String AdditionalInterest1Name , String AdditionalInterest1Address , String AdditionalInterest1City ,
										String AdditionalInterest1State , String AdditionalInterest1ZipCode , String AdditionalInterest2Type , String AdditionalInterest2LoanNumber ,
										String AdditionalInterest2Name , String AdditionalInterest2Address , String AdditionalInterest2City , String AdditionalInterest2State ,
										String AdditionalInterest2ZipCode , String AdditionalInterest3Type , String AdditionalInterest3LoanNumber , String AdditionalInterest3Name ,
										String AdditionalInterest3Address , String AdditionalInterest3City , String AdditionalInterest3State , String AdditionalInterest3ZipCode ,
										String AdditionalInterest4Type , String AdditionalInterest4LoanNumber , String AdditionalInterest4Name , String AdditionalInterest4Address ,
										String AdditionalInterest4City , String AdditionalInterest4State , String AdditionalInterest4ZipCode , String ValuationType ,
										String EstimatedReplacementCost , String ConstructionType , String NumberofUnits , String UnitsinFireWall , String NumberofStories ,
										String SquareFootage , String FoundationType , String PrimaryHeating , String Isthereasecondaryheatingsystem , String PlumbingType ,
										String PlumbingYear , String WaterHeaterYear , String Wiring , String ElectricalSystem , String RoofType , String RoofYear ,
										String ConditionofRoof , String Isthereascreenenclosureonpremises , String Doestheplumbingsystemhaveknownleaks ,
										String Isthebuildingretrofittedforearthquakes , String Anyuncorrectedfireorbuildingcodeviolations ,
										String Wasthestructureoriginallybuiltforotherthanaprivateresidenceandthenconverted , String Anyleadpainthazard ,
										String Isanyportionofanystructureatthispropertylocationnoworeverhasbeenamobilehomemodularhometrailerhomeorotherprefabricatedhome ,
										String DiscountType , String RoofShape , String OpeningProtectionType , String Terrain , String RoofCover ,
										String RoofDeckAttachment , String RoofWallConnection , String SecondaryWaterResistance , String RoofDeck , String FBCWindSpeed ,
										String InternalPressure , String WindBorneDebrisRegion , String DwellingLimit , String OtherStructures , String OtherStructuresIncreasedLimit ,
										String PersonalPropertyLimit , String PersonalPropertyValuationMethod , String LossofUse , String WindExcluded ,
										String SectionIDeductiblesAOP , String SectionIDeductiblesType , String PersonalLiability , String PremisesLiability ,
										String MedicalPayments , String GuardianEndorsement , String Whensafe , String SpecificOtherStructuresDescription ,
										String SpecificOtherStructuresLimit , String OtherStructuresIncreaseCoverageRentedtoOthersDescription ,
										String OtherStructuresIncreaseCoverageRentedtoOthersLimit , String ScheduledPersonalProperty ,
										String PermittedIncidentalOccupancyPropertyLimit , String CreditCardLimit , String LimitedFungiLimit , String LossAssessmentLimit ,
										String OrdinanceorLawPercent , String RefrigeratedPersonalProperty , String EarthquakeCoverageDeductible ,
										String EarthquakeCoverageConstructionClass , String EarthquakeZone , String EarthquakeLossAssessmentCoverageLimit ,
										String SpecialComputerCoverage , String ScreenEnclosureHurricaneCoverageLimit , String ResidenceHeldinTrust ,
										String SpecifiedAdditionalAmountofCoverageA , String UnitOwnersCoverageASpecialCoverageLimit , String UnitOwnersRentedtoOthers ,
										String TheftCoverage , String WaterBackUpLimit , String InflationGuard2 , String SinkholeLossCoverage ,
										String PermittedIncidentalOccupancyLiability , String AnimalLiability , String AdditionalResidenceRentedtoOthersLocation2 ,
										String AdditionalResidenceRentedtoOthersNumberoffamilies , String BusinessPursuitsBusinessactivity , String PersonalInjury ,
										String WatercraftLiablityWatercraftType , String BillingContactinsuredormortgage , String PaymentPlanSchedule)
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
		String[] name = NameInsured.split("  ");
		String firstName = name[0], lastName = name[1];

		enterAccountInfo
			.setFirstName(firstName)

			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1(MailingAddress)
			.setCity(MailingCity)
			.setState(MailingState)

			.setZipCode(MailingZipcode)
				.clickVerifyAddress()
				.selectAddress(2)
			.setAddressType(AddressType)
			.setOrganization(Organization)
			.setProducerCode(ProducerCode);
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
		qualification.setPolicyType(PolicyType);

		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(int i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		Dwelling dwelling = qualification.next().next();

		log("Specifying dwelling details");
		dwelling
		.setYearBuilt(YearBuilt)
		.setDistanceToFireHydrant(DistancetoFireHydrant).setTerritoryCode(TerritoryCode).setBCEG(BCEG).setProtectionClassCode(ProtectionClassCode);

		DwellingConstruction dc = dwelling.next();

		dc.setRoofYear(RoofYear)
		.clickWindMitigation()
		.setRoofShapeType(RoofShape);
		Coverages co = dc.next();
		co.setDwellingLimit(DwellingLimit).setPersonalPropertyLimit(PersonalPropertyLimit)
		.next().quote().back().requestApproval();





		log("Specifying dwelling protection details");
		System.out.println("waiting");
	}
}