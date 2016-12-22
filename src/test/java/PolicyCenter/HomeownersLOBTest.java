package PolicyCenter;

import DataProviders.AccountPolicyGenerator;
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
import pageobjects.Login;
import pageobjects.WizardPanelBase.*;

import java.util.LinkedHashMap;

@Test
public class HomeownersLOBTest extends BaseTest
{
	private WebDriver driver;
	private Login login;
	private CenterSeleniumHelper sh;
	private String dateString;
	private AccountFileSummary accountFileSummary;
	private String 	policyNumHO3 = "FPH3-324233344",
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
				.selectAddressForCreateAccount(2)
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
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
	public void FLH03AccountRenewalPOCWithHash(LinkedHashMap<String, String> eai)
	{
		int i= 0;
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
		System.out.println(new DateTime().toString());

		log("Test new person account creation");
		String[] addlInsuredName = eai.get("Addl Interest Name").split("\\s+");
		String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

		enterAccountInfo
			.setFirstName(firstName)
			.setCompanyName("Jelly")
			.setCountry("United States")
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setZipCode(eai.get("Mailing Zipcode"))
			.setLastName(lastName)
			.clickSearch();
		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();

		log("Creating new account: " + dateString);
		createAccount
			.setAddressLine1(eai.get("Mailing Address"))
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setDateOfBirth(eai.get("Date of Birth"))
			.setHomePhone(eai.get("Home Phone"))
			.setWorkPhone(eai.get("Work Phone"))
			.setMobilePhone("745-512-6590")
			.setFaxPhone("487-963-8521")
			.setPrimaryPhone("Work")
			.setPrimaryEmail(eai.get("Email Address"))
			.setSecondaryEmail("jdklafj@hotmail.com")
			.setState(eai.get("Mailing State"))

			.setZipCode(eai.get("Mailing Zipcode"))
				.clickVerifyAddress()
				.selectAddressForCreateAccount(2)
			.setAddressType(eai.get("Address Type"))
			.setDescription("Nerd Lair")
			.setSsn(eai.get("SSN"))
			.setOrganization(eai.get("Organization"))
			.setProducerCode(eai.get("Producer Code"));

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

		// Initiate Manual Renewal
		imr.setOrganization(eai.get("Organization"))
		.setProducerCode(eai.get("Producer Code"))
		.setBaseState(eai.get("Mailing State"))
		.setProduct(eai.get("Product"))
		.setPolicyType(eai.get("Policy Type"))
		.setLegacyPolicyNumber(eai.get("Legacy Policy Number"))
		.setOriginalEffectiveDate(eai.get("Policy Original Effective Date"))
		.setEffectiveDate(eai.get("Effective Date"))
		.setLastInspectionCompletionDate(eai.get("Last Inspection Completion Date"))
		.setInflationGuard(eai.get("Inflation Guard"))
		.clickExcludeLossOfUseCoverage(eai.get("Exclude Loss of Use Coverage"))
		.nextAndAccept()

		// Offerings
		.setPolicyType("Homeowners")
		.setOfferingSelection(eai.get("Offering Selection"))
		.next()

		// Policy Info
		.setOccupation("Twinkie Smuggler")
		.clickDoesInsuredOwnOtherResidenceWithFrontline(eai.get("Does the insured own any other residence that is insured with Frontline?"))
		.setTermType("Annual")
		//.setPolicyWriter(eai.get("Policy Writer"))
		.clickAddNewPerson()


		// New Additional Named Insured
		.setRelationshipToPrimary("Sugah Mama")

		.setFirstName(eai.get("Additional Name Insured First Name"))
		.setLastName(eai.get("Additional Name Insured Last Name"))
		.setDateOfBirth(eai.get("Additional Name Insured Date of Birth"))
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("323-254-8457")
		.setFaxPhone("356-984-5478")
		.setPrimaryEmail(eai.get("Email Address"))
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1("2470 Wild Wood dr")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickVerifyAddress()
		.selectAddressForNewAdditionalNamedInsured(2)
		.setAddressType("Billing")
		.setAddressDescription("Hideout")
		.setLicenseNumber("156468465")
		.setLicenseState("Florida")
		.setSsn(eai.get("Additional Name Insured SSN"))
		.clickOk().next()

		// Dwelling
		.setLocationName("1:") // Left as is
		.setYearBuilt(eai.get("Year Built"))
		.setDistanceToFireHydrant(eai.get("Distance to Fire Hydrant"))
		.setDistanceToFireStation(eai.get("Distance to Fire Station"))
		.setTerritoryCode(eai.get("Territory Code"))
		.setBCEG(eai.get("BCEG"))
		.setProtectionClassCode(eai.get("Protection Class Code"))
		.setLocationType(eai.get("Location Type"))
		.setInTheWindpool(eai.get("In the Windpool?"))
		.setDistanceToCoast(eai.get("Distance to Coast"))
		.setPurchaseDate(eai.get("Purhcase Date"))
		.setPurchasePrice(eai.get("Purchase Price"))
		.setMarketValue(eai.get("Market Value"))
		.setOwnedByOther(eai.get("At the inception of this policy, will this property be deeded in the name of corporation, business, LLC or any other entity?"))
		.setOccupiedDaily(eai.get("How is the dwelling occupied"))
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setDwellingOccupancy("Owner Occupied")
		.setSwimmingPool(eai.get("Is there a swimming pool?"))
		.setPoolLocation("In-Ground")
		.setPoolFenced("true")
		.setFenceType("Screen Enclosure")
		.setDivingBoard("true")
		.setPoolSlide("true")
		.setTrampolineOnPremises(eai.get("Is there a tampoline"))
		.setSkateboardBicycleRampOnPremises(eai.get("is there a skateboard or bicycle ramp on premises?"))
		.setAnimalsOrExoticPets(eai.get("Any animals or exotic pets on premses?"))
		.setGolfCarts(eai.get("Any owned Golf Carts?"))
		.setRecreationalVehiclesOwned(eai.get("Any owned recreational vehicles?"))
		.setHousekeepingCondition(eai.get("Housekeeping Condition"))




		// Protection Details
		.clickProtectionDetails()
		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		.setBurglarAlarm(eai.get("Burglar Alarm Type"))
		.setLockedPrivacyFence(eai.get("Is there a locked privacy fence"))
		.setBurglarBarsOnWindows(eai.get("are there any burglar bars on the windows/doors?"))
		.setCommunityGuarded(eai.get("Is the community Guarded?"))
		.setGatedCommunity(eai.get("Is the community Gated?"))
		.setFireAlarm(eai.get("Fire Alarm type"))
		.setSmokeAlarm(eai.get("Smoke Alarms"))
		.setFireExtinguishers(eai.get("One or move fire extinguishers in the home?"))
		.setSprinklerSystem(eai.get("Sprinkler System"))
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.get("Residence Visible to neighbors"))

		//.safetyLatchesPresent(true)
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setBurglarAlarmType("Central Station")

		// Additional Interests
		.clickAdditionalInterests()
		.clickAddNewPerson()
		.setType(eai.get("Addl Interest Type"))
		.setLoanNumber(eai.get("Addl Interest Loan Number"))
		//.clickCertificateRequired("true")
		.setFirstName(addlInsuredName[0])
		.setLastName(addlInsuredName[addlInsuredName.length -1])
		.setDateOfBirth("10/20/1986")
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("323-254-8457")
		.setFaxPhone("356-984-5478")
		.setPrimaryEmail("jelly@jellymail.com")
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1(eai.get("Addl Interest Address"))
		.setCity(eai.get("Addl Interest City"))
		.setState(eai.get("Addl Interest State"))
		.setZipCode(eai.get("Addl Interest Zip Code"))
		.clickVerifyAddress()
		.selectAddressForNewAdditionalInterests(2)
		.setAddressType("Billing")
		.setAddressDescription("Hideout")
		.setLicenseNumber("156468465")
		.setLicenseState("Florida")
		.setSsn("598-99-6565")
		.clickOk()
		.next()

		// Dwelling Construction
		.setValuationType(eai.get("Valuation Type"))
		.setEstimatedReplacementCost(eai.get("Estimated Replacement Cost"))
		.setConstructionType(eai.get("Construction Type"))
		.setNumberOfUnits(eai.get("Number Of Units"))
		.setUnitsInFireWall(eai.get("Units in Fire Wall"))
		.setNumberOfStories(eai.get("Number of Stories"))
		.setSquareFootage(eai.get("Square Footage"))
		.setFoundationType(eai.get("Foundation Type"))
		.setPrimaryHeating(eai.get("Primary Heating"))
		.setIsThereASecondaryHeatingSystem(eai.get("Is there a secondary heating system?"))
		.setPlumbing(eai.get("Plumbing Type"))
		.setPlumbingYear(eai.get("Plumbing Year"))
		.setWaterHeaterYear(eai.get("Water Heater Year"))
		.setWiring(eai.get("Wiring"))
		.setElectricalSystem(eai.get("Electrical System"))
		.setRoofType(eai.get("Roof Type"))
		.setRoofYear(eai.get("Roof Year"))
		.setConditionOfRoof(eai.get("Condition of Roof"))
		.setScreenEnclosureOnPremises(eai.get("Is there a screen enclosure on premises?"))



		.setPlumbingSystemHaveKnownLeaks("false")
		.setBuildingRetrofittedForEarthquakes("false")
		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
		.setUncorrectedFireOrBuildingCodeViolations("false")
		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
		.setLeadPaintHazard("false")
//		.setLeadPaintHazardDescription("best")
//		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")


		// Wind Mitigation
		.clickWindMitigation()
		.setRoofShapeType(eai.get("Roof Shape"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setRoofCover(eai.get("Roof Cover"))
		.setRoofDeckAttachment(eai.get("Roof Deck Attachment"))
		.setRoofWallConnection(eai.get("Roof Wall Connection"))
		.setSecondaryWaterResistance(eai.get("Secondary Water Resistance"))
		.next()

		// Coverages
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"))
		.setPersonalPropertyExcluded("false")
		.setPersonalPropertyLimit(eai.get("Personal Property - Limit"))
		.setPersonalPropertyValuationMethod(eai.get("Personal Property Valuation Method"))
		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles AOP"))
		.setHurricane(eai.get("Section I Deductibles - Hurricane"))
		.setPersonalLiabilityLimit(eai.get("Personal Liability"))
		.setMedicalPaymentsLimit(eai.get("Medical Payments"))





		// Property Endorsements
		.clickPropertyEndorsements()
		.checkGuardianEndorsements()
		.checkOtherStructuresIncreasedCoverageRentedToOthers()
		.clickAddOtherStructures()
		.setOtherStructuresDescription(1,eai.get("Other Structures Increase Coverage - Rented to Others - Description"))
		.setOtherStructuresLimit(1,eai.get("Other Structures Increase Coverage - Rented to Others - Limit"))
		.checkScheduledPersonalProperty()
		.clickAddScheduledPersonalProperty()
		.setPersonalPropertyArticleType(1,"Jewelry")
		.setPersonalPropertyDescription(1,"schweggggg")
		.setPersonalPropertyValue(1,"234342")
		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
		//.checkPermittedIncidentalOccupancy()
		.checkScreenEnclosureHurricaneCoverage()
		.checkSinkholeLossCoverage()
		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")

		.setWhenSafeCreditPercentage(eai.get("Whensafe - %"))
		.setOccurrenceAggregateLimit("10,000 / 50,000")
		.setLossAssessmentLimit(eai.get("Loss Assessment (Limit)"))
		.setOrdinanceOrLawLimit(eai.get("Ordinance or Law - Percent"))
		.setPercentageOfAnnualIncrease("12%")
		.setSinkholeClaimsIndex("4500")
		.setSinkholeIndex("330")

		// Liability Endorsements
		.clickLiabilityEndorsements()
		.checkPermittedIncidentalOccupancyLiability()
		//.checkAnimalLiability()
		.checkAdditionalResidenceRentedToOthers()
		.checkBusinessPursuits()
		.checkWatercraftLiability()

		.setLocationName("1:")
		.setNumberOfFamilies("2 Family Residence")
		.setBusinessActivity(eai.get("Business Pursuits - Business activity"))
		.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"))



//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.checkScheduledPersonalProperty()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkSinkholeLossCoverage()
		.next()
		.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}
	// Renewal types
	public void FLH03AccountRenewalPOC()
	{
		int i= 0;
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
				.selectAddressForCreateAccount(2)
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

		// Initiate Manual Renewal
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
		.clickExcludeLossOfUseCoverage("false");
		Offerings offerings = imr.nextAndAccept()

		// Offerings
		.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular");
		PolicyInfo pi = offerings.next();

		// Policy Info
		pi.setOccupation("Twinkie Smuggler")
		.clickDoesInsuredOwnOtherResidenceWithFrontline("false")
		.setTermType("Annual");
		SearchAddressBook sab = pi
		//.setPolicyWriter()
		//.clickAddNewPerson()
		.clickAddFromAddressBook();


		// Search Address Book
		sab
		.setType("Person")
		.setFirstName("fsadfasd")
		.setLastName("fadsfasdfasdf")
		.setCountry("United States")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickSearch();
		if(sab.areThereSearchResults())
			sab.selectFirstSearchResult();
		else
		{
			sab.clickReturnToPolicyInfo()
			.clickAddNewPerson()
			.setRelationshipToPrimary("Sugah Mama")

			.setFirstName("Jelly")
			.setLastName("Junior")
			.setDateOfBirth("10/20/1986")
			.setMaritalStatus("Married")
			.setPrimaryPhone("Home")
			.setHomePhone("456-987-6542")
			.setWorkPhone("453-985-6325")
			.setMobilePhone("323-254-8457")
			.setFaxPhone("356-984-5478")
			.setPrimaryEmail("jelly@jellymail.com")
			.setSecondaryEmail("jiggla@jigglamail.com")
			.setCountry("United States")
			.setAddress1("2470 Wild Wood dr")
			.setCity("Melbourne")
			.setState("Florida")
			.setZipCode("32935")
			.clickVerifyAddress()
			.selectAddressForNewAdditionalNamedInsured(2)
			.setAddressType("Billing")
			.setAddressDescription("Hideout")
			.setLicenseNumber("156468465")
			.setLicenseState("Florida")
			.setSsn("598-99-6565")
			.clickOk();

		}



		// New Additional Named Insured
		Dwelling dwelling = pi.next();

		// Dwelling
		dwelling
		.setLocationName("1:")
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setDistanceToFireStation("2100")
		.setTerritoryCode("064")
		.setBCEG("02")
		.setProtectionClassCode("2")
		.setLocationType("In City Limits")
		.setInTheWindpool("true")
		.setDistanceToCoast("2000")
		.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setOwnedByOther("false")
		.setOccupiedDaily("false")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setDwellingOccupancy("Owner Occupied")
		.setSwimmingPool("true")
		.setPoolLocation("In-Ground")
		.setPoolFenced("true")
		.setFenceType("Screen Enclosure")
		.setDivingBoard("true")
		.setPoolSlide("true")
		.setTrampolineOnPremises("true")
		.setSkateboardBicycleRampOnPremises("true")
		.setAnimalsOrExoticPets("false")
		.setGolfCarts("true")
		.setRecreationalVehiclesOwned("true")
		.setHousekeepingCondition("Excellent");



		// Protection Details
		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();
		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		pd
		.setBurglarAlarm("true")
		.setLockedPrivacyFence("true")
		.setBurglarBarsOnWindows("true")
		.setCommunityGuarded("true")
		.setGatedCommunity("true")
		.setFireAlarm("true")
		.setSmokeAlarm("true")
		.setFireExtinguishers("true")
		.setSprinklerSystem("true")
		.setDeadbolts("true")
		.setResidenceVisibleToNeighbors("true")
		.safetyLatchesPresent("true")
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setBurglarAlarmType("Central Station")

		// Additional Interests
		.clickAdditionalInterests()
		.clickAddNewPerson()
		.setType("Additional Insured")
		.setLoanNumber("747384")
		.clickCertificateRequired("true")
		.setFirstName("Jelly")
		.setLastName("Junior")
		.setDateOfBirth("10/20/1986")
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("323-254-8457")
		.setFaxPhone("356-984-5478")
		.setPrimaryEmail("jelly@jellymail.com")
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1("2470 Wild Wood dr")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickVerifyAddress()
		.selectAddressForNewAdditionalInterests(2)
		.setAddressType("Billing")
		.setAddressDescription("Hideout")
		.setLicenseNumber("156468465")
		.setLicenseState("Florida")
		.setSsn("598-99-6565")
		.clickOk()
		.next()

		// Dwelling Construction
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setIsThereASecondaryHeatingSystem("true")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setRoofYear("2000")
		.setConditionOfRoof("Good")
		.setScreenEnclosureOnPremises("true")



		.setPlumbingSystemHaveKnownLeaks("false")
		.setBuildingRetrofittedForEarthquakes("false")
		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
		.setUncorrectedFireOrBuildingCodeViolations("false")
		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
		.setLeadPaintHazard("false")
//		.setLeadPaintHazardDescription("best")
//		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")


		// Wind Mitigation
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
		.setTerrain("C")
		.setRoofCover("FBC Equivalent")
		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
		.setRoofWallConnection("Clips")
		.setSecondaryWaterResistance("true")
		.next()

		// Coverages
		.setDwellingLimit("300000")
		.setOtherStructuresPercentage("5%")
		.setPersonalPropertyExcluded("false")
		.setPersonalPropertyLimit("150000")
		.setPersonalPropertyValuationMethod("Actual Cash Value")
		.setLossOfUseSelection("5%")
		.setWindExcluded("false")
		.setAllOtherPerils("5,000")
		.setHurricane("2%")
		.setPersonalLiabilityLimit("500,000")
		.setMedicalPaymentsLimit("5,000")





		// Property Endorsements
		.clickPropertyEndorsements()
		.checkGuardianEndorsements()
		.checkOtherStructuresIncreasedCoverageRentedToOthers()
		.clickAddOtherStructures()
		.setOtherStructuresDescription(1,"Arsalans' Skill")
		.setOtherStructuresLimit(1,"9001")
		.checkScheduledPersonalProperty()
		.clickAddScheduledPersonalProperty()
		.setPersonalPropertyArticleType(1,"Jewelry")
		.setPersonalPropertyDescription(1,"schweggggg")
		.setPersonalPropertyValue(1,"234342")
		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
		//.checkPermittedIncidentalOccupancy()
		.checkScreenEnclosureHurricaneCoverage()
		.checkSinkholeLossCoverage()
		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")

		.setWhenSafeCreditPercentage("20%")
		.setOccurrenceAggregateLimit("10,000 / 50,000")
		.setLossAssessmentLimit("3000")
		.setOrdinanceOrLawLimit("25%")
		.setPercentageOfAnnualIncrease("12%")
		.setSinkholeClaimsIndex("4500")
		.setSinkholeIndex("330")

		// Liability Endorsements
		.clickLiabilityEndorsements()
		.checkPermittedIncidentalOccupancyLiability()
		//.checkAnimalLiability()
		.checkAdditionalResidenceRentedToOthers()
		.checkBusinessPursuits()
		.checkWatercraftLiability()

		.setLocationName("1:")
		.setNumberOfFamilies("2 Family Residence")
		.setBusinessActivity("Clerical Employee")
		.setWatercraftType("Up to 50 Horsepower and 16-26 feet")



//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.checkScheduledPersonalProperty()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkSinkholeLossCoverage()
		.next()
		.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}
	public void SCH03AccountRenewalPOC()
	{
		int i= 0;
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

			.setZipCode("29401")
				.clickVerifyAddress()
				.selectAddressForCreateAccount(2)
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

		// Initiate Manual Renewal
		imr.setOrganization("Brown and Brown of Florida, Inc")
		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
		.setBaseState("South Carolina")
		.setProduct("Homeowners")
		.setPolicyType("Homeowners")
		.setLegacyPolicyNumber(policyNumHO3)
		.setOriginalEffectiveDate("11/21/2016")
		.setEffectiveDate("10/29/2017")
		.setLastInspectionCompletionDate("03/21/2015")
		.setInflationGuard("12%")
		.clickExcludeLossOfUseCoverage("false")
		.nextAndAccept()

		// Offerings
		.setPolicyType("Homeowners")
		.setOfferingSelection("Most Popular")
		.next()

		// Policy Info
		.setOccupation("Twinkie Smuggler")
		.clickDoesInsuredOwnOtherResidenceWithFrontline("false")
		.setNoPriorInsuranceSurcharge("false")
		.setTermType("Annual")
		//.setPolicyWriter()
		.clickAddNewPerson()


		// New Additional Named Insured
		.setRelationshipToPrimary("Sugah Mama")

		.setFirstName("Jelly")
		.setLastName("Junior")
		.setDateOfBirth("10/20/1986")
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("323-254-8457")
		.setFaxPhone("356-984-5478")
		.setPrimaryEmail("jelly@jellymail.com")
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1("2470 Wild Wood dr")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickVerifyAddress()
		.selectAddressForNewAdditionalNamedInsured(2)
		.setAddressType("Billing")
		.setAddressDescription("Hideout")
		.setLicenseNumber("156468465")
		.setLicenseState("Florida")
		.setSsn("598-99-6565")
		.clickOk().next()

		// Dwelling
		.setLocationName("1:")
		.setYearBuilt("2000")
		.setDistanceToFireHydrant("2000")
		.setDistanceToFireStation("2100")
		.setTerritoryCode("03S")
		.setBCEG("02")
		.setProtectionClassCode("2")
		.setLocationType("In City Limits")
		.setInTheWindpool("true")
		.setWindpoolZone("Windpool Zone 1")
		.setDistanceToCoast("2000")
		.setPurchaseDate("01/25/2000")
		.setPurchasePrice("500000")
		.setMarketValue("6000000")
		.setOwnedByOther("false")
		.setOccupiedDaily("false")
		.setResidenceType("Duplex")
		.setDwellingUsage("Seasonal")
		.setDwellingOccupancy("Owner Occupied")
		.setSwimmingPool("true")
		.setPoolLocation("In-Ground")
		.setPoolFenced("true")
		.setFenceType("Screen Enclosure")
		.setDivingBoard("true")
		.setPoolSlide("true")
		.setTrampolineOnPremises("true")
		.setSkateboardBicycleRampOnPremises("true")
		.setAnimalsOrExoticPets("false")
		.setGolfCarts("true")
		.setRecreationalVehiclesOwned("true")
		.setHousekeepingCondition("Good")




		// Protection Details
		.clickProtectionDetails()
		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		.setBurglarAlarm("true")
		.setLockedPrivacyFence("true")
		.setBurglarBarsOnWindows("true")
		.setCommunityGuarded("true")
		.setGatedCommunity("true")
		.setFireAlarm("true")
		.setSmokeAlarm("true")
		.setFireExtinguishers("true")
		.setSprinklerSystem("true")
		.setDeadbolts("true")
		.setResidenceVisibleToNeighbors("true")
		.safetyLatchesPresent("true")
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setBurglarAlarmType("Central Station")

		// Additional Interests
		.clickAdditionalInterests()
		.clickAddNewPerson()
		.setType("Additional Insured")
		.setLoanNumber("747384")
		.clickCertificateRequired("true")
		.setFirstName("Jelly")
		.setLastName("Junior")
		.setDateOfBirth("10/20/1986")
		.setMaritalStatus("Married")
		.setPrimaryPhone("Home")
		.setHomePhone("456-987-6542")
		.setWorkPhone("453-985-6325")
		.setMobilePhone("323-254-8457")
		.setFaxPhone("356-984-5478")
		.setPrimaryEmail("jelly@jellymail.com")
		.setSecondaryEmail("jiggla@jigglamail.com")
		.setCountry("United States")
		.setAddress1("2470 Wild Wood dr")
		.setCity("Melbourne")
		.setState("Florida")
		.setZipCode("32935")
		.clickVerifyAddress()
		.selectAddressForNewAdditionalInterests(2)
		.setAddressType("Billing")
		.setAddressDescription("Hideout")
		.setLicenseNumber("156468465")
		.setLicenseState("Florida")
		.setSsn("598-99-6565")
		.clickOk()
		.next()

		// Dwelling Construction
		.setValuationType("Appraisal")
		.setEstimatedReplacementCost("100000")
		.setConstructionType("Superior")
		.setNumberOfUnits("11-50")
		.setUnitsInFireWall("2")
		.setNumberOfStories("2")
		.setSquareFootage("3500")
		.setFoundationType("Open")
		.setPrimaryHeating("Gas")
		.setIsThereASecondaryHeatingSystem("true")
		.setPlumbing("Copper")
		.setPlumbingYear("2003")
		.setWaterHeaterYear("2004")
		.setWiring("Multi-Strand Aluminum")
		.setElectricalSystem("Circuit Breaker")
		.setRoofType("Metal")
		.setRoofYear("2000")
		.setConditionOfRoof("Good")
		.setScreenEnclosureOnPremises("true")



		.setPlumbingSystemHaveKnownLeaks("false")
		.setBuildingRetrofittedForEarthquakes("false")
		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
		.setUncorrectedFireOrBuildingCodeViolations("false")
		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
		.setLeadPaintHazard("false")
//		.setLeadPaintHazardDescription("best")
//		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")


		// Wind Mitigation
		.clickWindMitigation()
		.setRoofShapeType("Hip")
		.setOpeningProtectionType("Hurricane")
//		.setTerrain("C")
//		.setRoofCover("FBC Equivalent")
//		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
//		.setRoofWallConnection("Clips")
		.setSecondaryWaterResistance("true")
		.setIsTheRoofCoverConstructionBuildingCodeCompliant("true")
		.setIsTheRoofDeckAttachmentBuildingCodeCompliant("true")
		.setIsTheRoofWallconnectionBuildingCodeCompliant("true")
		.next()

		// Coverages
		.setDwellingLimit("300000")
		.setOtherStructuresPercentage("5%")
		//.setPersonalPropertyExcluded("false")
		.setPersonalPropertyLimit("120000")
		.setPersonalPropertyValuationMethod("Actual Cash Value")
		.setLossOfUseSelection("10,000")
		//.setWindExcluded("false")
		.setAllOtherPerils("5,000")
		.setHurricane("5%")
		.setPersonalLiabilityLimit("100,000")
		//.setMedicalPaymentsLimit("5,000")
		.clickPropertyEndorsements()





		// Property Endorsements
		.checkGuardianEndorsements()
		.checkOtherStructuresIncreasedCoverageRentedToOthers()
		.clickAddOtherStructures()
		.setOtherStructuresDescription(1,"Arsalans' Skill")
		.setOtherStructuresLimit(1,"9001")
		.checkScheduledPersonalProperty()
		.clickAddScheduledPersonalProperty()
		.setPersonalPropertyArticleType(1,"Jewelry")
		.setPersonalPropertyDescription(1,"schweggggg")
		.setPersonalPropertyValue(1,"234342")
		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")
		//.checkPermittedIncidentalOccupancy()
		.checkScreenEnclosureHurricaneCoverage()
		.checkEarthquakeCoverage()
		.checkEarthquakeLossAssessment()
		//.checkSinkholeLossCoverage()

		.setWhenSafeCreditPercentage("20%")
		.setOccurrenceAggregateLimit("10,000 / 50,000")
		.setLossAssessmentLimit("3000")
		.setOrdinanceOrLawLimit("25%")
		.setEarthquakeCoverageDeductiblePercentage("10%")
		.setDoesExteriorMasonryVeneerExclusionApply("true")
		.setEarthquakeLossAssessmentLimit("5,000")
		.setPercentageOfAnnualIncrease("12%")
		//.setSinkholeClaimsIndex("4500")
		//.setSinkholeIndex("330")
		.clickLiabilityEndorsements()

		// Liability Endorsements
		.checkPermittedIncidentalOccupancyLiability()
		.checkAnimalLiability()
		.checkAdditionalResidenceRentedToOthers()
		.checkBusinessPursuits()
		.checkWatercraftLiability()

		.setLocationName("1:")
		.setNumberOfFamilies("2 Family Residence")
		.setBusinessActivity("Clerical Employee")
		.setWatercraftType("Up to 50 Horsepower and 16-26 feet")



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
				.selectAddressForCreateAccount(2)
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
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015");//.setInflationGuard("12%").clickExcludeLossOfUseCoverage("true");
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

	public void SCH03AccountRenewalPOCBasic()
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
				.selectAddressForCreateAccount(2)
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
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015").setInflationGuard("12%").clickExcludeLossOfUseCoverage("true");
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
				.selectAddressForCreateAccount(2)
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
		.clickExcludeLossOfUseCoverage("true");
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
				.selectAddressForCreateAccount(2)
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
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage("true")
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
		.setAtInceptionOfPolicyIsDeedOwnedByEntity("false");

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
				.selectAddressForCreateAccount(2)
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
		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage("true");
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
		.setAtInceptionOfPolicyIsDeedOwnedByEntity("false");

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
				.selectAddressForCreateAccount(2)
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
		.clickExcludeLossOfUseCoverage("true");
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
				.selectAddressForCreateAccount(2)
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
		.clickExcludeLossOfUseCoverage("true");
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
				.selectAddressForCreateAccount(2)
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
		.clickDoesInsuredOwnOtherResidenceWithFrontline("true")
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
		.setBurglarAlarm("true")
		.setLockedPrivacyFence("true")
		.setBurglarBarsOnWindows("true")
		.setCommunityGuarded("true")
		.setGatedCommunity("true")
		.setFireAlarm("true")
		.setSmokeAlarm("true")
		.setFireExtinguishers("true")
		.setSprinklerSystem("true")
		.setDeadbolts("true")
		.setResidenceVisibleToNeighbors("true")
		.safetyLatchesPresent("true")
		.setFireAlarmType("Central Station")
		.setSprinklerSystemType("Full")
		.setBurglarAlarmType("Central Station");

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
}