package PolicyCenter;

import DataProviders.AccountPolicyGenerator;
import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.Login;
import pageobjects.WizardPanelBase.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Test
public class HomeownersLOBTest extends BaseTest
{
	private String dateString;
	private AccountFileSummary accountFileSummary;
	private String 	policyNumHO3 = "FPH3-324233601",
					policyNumDP3 = "FPD3-324237824";

	@BeforeMethod
	public void beforeMethod()
	{
		DateTime date = new DateTime();
		dateString = date.toString("MMddhhmmss");

		System.out.println(new DateTime().toString());
		// users: conversion2,mcoad
		String user = "mcoad", pwd = "";
		WebDriver driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
		Login login = new Login(new CenterSeleniumHelper(driver), sessionInfo);
		login.load();
		login.isLoaded();
		login.login(user, pwd);
		log("Logged in as: " + user + "\nPassword: " + pwd);
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult testResult, ITestContext itc)
	{
		//CSVWriter writer = new CSVWriter(new FileWriter("/Users/aansari/Desktop/output4.csv"));
		WebDriver driver = LocalDriverManager.getDriver();
		if(testResult.getStatus() != ITestResult.SUCCESS)
		{
			takeScreenShot(driver);
			System.out.println("\n'" + testResult.getMethod().getMethodName() + "' Failed.\n");
			System.out.println("wait");
		}
		if(driver != null)
			driver.quit();
	}

//	@Test
//	public void testSimpleSubmission()
//	{
//		log("Test simple homeowners policy submission");
//		String accountNumber = "5015804910";
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();
//
//		log("Answering qualification questions");
//		Qualification qualification = submission.productTable.selectHomeowners();
//		String policyType = "Homeowners";
//		log("Policy Type: " + policyType);
//		qualification.setPolicyType("Homeowners");
//
//		System.out.println(qualification.questionnaire.getQuestionText(1));
//		for(int i = 1; i<9; i++)
//			qualification.questionnaire.answerNo(i);
//		Dwelling dwelling = qualification.next().next();
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000").setBCEG("02").setProtectionClassCode("2");
//
//		DwellingConstruction dc = dwelling.next();
//		dc.setRoofYear("2000").clickWindMitigation().setRoofShapeType("Hip");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000").next().quote();
//
//
//
//
//		log("Specifying dwelling protection details");
//		System.out.println("waiting");
//	}

//	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
//	public void AccountPolicyCreatorPOCWithHash(LinkedHashMap<String, String> eai, LinkedHashMap<String, String> spp, LinkedHashMap<String, String> osic)
//	{
//		// Create Account
//
//		//Object spp = eai.get("Scheduled Personal Property");
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		//EnterAccountInformation enterAccountInfo = new EnterAcLinkedHashMap<String, String> eaicountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String[] insuredName = eai.get("Name Insured").split("\\s+");
//		String firstName = insuredName[0], lastName = insuredName[1];
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1(eai.get("Mailing Address"))
//			.setCity(eai.get("Mailing City"))
//			.setState(eai.get("Mailing State"))
//
//			.setZipCode(eai.get("Mailing Zipcode"))
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType(eai.get("Address Type"))
//			.setOrganization(eai.get("Organization"))
//			.setProducerCode(eai.get("Producer Code"));
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//
//		// Create policy
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();
//
//		log("Answering qualification questions");
//		Qualification qualification = submission.productTable.selectHomeowners();
//
//		String policyType = eai.get("Policy Type");
//		log("Policy Type: " + eai.get("Policy Type"));
//		qualification.setPolicyType(eai.get("Policy Type"));
//
//		System.out.println(qualification.questionnaire.getQuestionText(1));
//		for(int i = 1; i<9; i++)
//			qualification.questionnaire.answerNo(i);
//		Dwelling dwelling = qualification.next().next();
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt(eai.get("Year Built"))
//		.setDistanceToFireHydrant(eai.get("Distance to Fire Hydrant")).setTerritoryCode(eai.get("Territory Code"))
//		.setBCEG(eai.get("BCEG")).setProtectionClassCode(eai.get("Protection Class Code"));
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear(eai.get("Roof Year")).clickWindMitigation().setRoofShapeType(eai.get("Roof Shape"));
//		Coverages co = dc.next();
//		co.setDwellingLimit(eai.get("Dwelling Limit")).setPersonalPropertyLimit(eai.get("Personal Property - Limit"))
//		.next().quote().back().requestApproval().sendRequest();
//		sh.waitForElementToAppear(By.id("SubmissionWizard:Job_RiskAnalysisScreen:0"));
//
//
//
//		log("Specifying dwelling protection details");
//		log("Waiting for Quote Page.");
//	}
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
	public void RenewalLoadTest(ITestContext itc, LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		int i;
		int[] territoryList = new int[] {043,193, 393, 593, 596, 601, 603, 604, 605, 606, 607, 608, 609, 693, 721, 722, 723, 724, 725, 726, 737, 793, 931, 932, 934,993};

		for (Map.Entry<String, String> entry : eai.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();

			itc.getCurrentXmlTest().addParameter(key,value);

		}

		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
		System.out.println(new DateTime().toString());

		log("Test new person account creation");

		//String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

		enterAccountInfo
			.setFirstName(firstName)
			.setCountry("United States")
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setZipCode(eai.get("Mailing Zip Code"))
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
			.setWorkPhone(eai.getOrDefault("Work Phone",null))
			.setPrimaryEmail(eai.getOrDefault("Email Address",null))
			.setState(eai.getOrDefault("Mailing State",null))
			.setZipCode(eai.getOrDefault("Mailing Zip Code",null))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForCreateAccount()
			.setAddressType(eai.getOrDefault("Address Type","Home"))
			//.setDescription("Nerd Lair")
			.setSsn(eai.getOrDefault("SSN", null))
			.setOrganization(eai.getOrDefault("Organization", null))
			.setProducerCode(eai.getOrDefault("Producer Code", null));

			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
		log("Test simple homeowners policy renewal");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();

		// Initiate Manual Renewal
		imr.setOrganization(eai.getOrDefault("Organization", null))
		.setProducerCode(eai.getOrDefault("Producer Code", null))
		.setBaseState(eai.getOrDefault("Mailing State", null))
		.setProduct(eai.getOrDefault("Product", null))
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setLegacyPolicyNumber(eai.getOrDefault("Legacy Policy Number", null))
		.setOriginalEffectiveDate(eai.getOrDefault("Policy Original Effective Date",null))
		.setEffectiveDate(eai.getOrDefault("Effective Date",null))
		.setLastInspectionCompletionDate(eai.getOrDefault("Last Inspection Completion Date", null))
		.setInflationGuard(eai.getOrDefault("Inflation Guard", null));
		if(eai.get("Exclude Loss of Use Coverage") == null)
			imr.clickExcludeLossOfUseCoverage("true");
		else
			imr.clickExcludeLossOfUseCoverage("false");
		Offerings offerings = imr.nextAndAccept();

		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		PolicyInfo pi = offerings.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			SearchAddressBook sab = pi.clickAddFromAddressBook();
			// See if value is for a person or company
			if(keyContainsValue(eai,"Additional Name Insured First Name" ))
			{
				person = true;
				sab.setType("Person")
				.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
				.setLastName(eai.get("Additional Name Insured Last Name"))
				.setTaxID(eai.getOrDefault("Additional Name Insured SSN", null));
			}
			else
			{
				sab.setType("Company")
				.setCompanyName(eai.get("Additional Name Insured Company Name"));
			}

			sab.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
				sab.selectFirstSearchResultPolicyInfo();

			// No results, add person/company
			else
			{
				pi = sab.clickReturnToPolicyInfo();
				// Add a person
				if(person)
				{
					NewAdditionalNameInsured ani = pi.clickAddNewPerson();
					ani

					.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
					.setLastName(eai.getOrDefault("Additional Name Insured Last Name", null))
					.setDateOfBirth(eai.getOrDefault("Additional Name Insured Date of Birth", null))
					.setSsn(eai.getOrDefault("Additional Name Insured SSN" , null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();
				}
				// Add a company
				else if (eai.getOrDefault("Additional Name Insured Company Name", null) != null)
				{
					System.out.println("COMPANY NAME IS: " + eai.get("Additional Name Insured Company Name"));
					NewAdditionalNameInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		Dwelling dwelling = pi.next();

		// Dwelling
		dwelling
		.setLocationName("1:") // Left as is
		.setYearBuilt(eai.getOrDefault("Year Built", null))
		.setDistanceToFireHydrant(eai.getOrDefault("Distance to Fire Hydrant", null))
		.setDistanceToFireStation(eai.getOrDefault("Distance to Fire Station", null))
		.setTerritoryCode(eai.getOrDefault("Territory Code", null));

		if(Integer.parseInt(eai.get("Year Built")) >1994)
		{
			dwelling.setBCEG(eai.getOrDefault("BCEG", null));
		}
		dwelling
		.setProtectionClassCode(eai.getOrDefault("Protection Class Code", null))
		.setLocationType(eai.getOrDefault("Location Type","In City Limits"))
		.setInTheWindpool(eai.getOrDefault("In the Windpool?", null))
		.setDistanceToCoast(eai.getOrDefault("Distance to Coast", null))
		.setPurchaseDate(eai.getOrDefault("Purchase Date", null))
		.setPurchasePrice(eai.getOrDefault("Purchase Price", null))
		.setMarketValue(eai.getOrDefault("Market Value", null))
		.setOwnedByOther(eai.getOrDefault("At the inception of this policy, will this property be deeded in the name of corporation, business, LLC or any other entity?", "false"))
		.setOccupiedDaily(eai.getOrDefault("Occupied Daily","true"))
		.setResidenceType(eai.getOrDefault("Residence Type", null))
		.setDwellingUsage(eai.getOrDefault("How is the dwelling customarily Used", null))
		.setDwellingOccupancy(eai.getOrDefault("How is the dwelling occupied", null));


		if(!eai.getOrDefault("Is there a swimming pool?","false").toLowerCase().equals("false"))
		{
			dwelling
			.setSwimmingPool("true")
			.setPoolLocation(eai.getOrDefault("Is there a swimming pool?", "<none>"))
			.setPoolFenced("true")
			.setFenceType("Approved Fence");

			dwelling
			.setDivingBoard("false")
			.setPoolSlide("false");
		}
		dwelling
		.setTrampolineOnPremises(eai.getOrDefault("Is there a trampoline","false"))
		.setSkateboardBicycleRampOnPremises(eai.getOrDefault("is there a skateboard or bicycle ramp on premises?","false"))
		.setAnimalsOrExoticPets(eai.getOrDefault("Any animals or exotic pets on premises?","false"))
		.setGolfCarts(eai.getOrDefault("Any owned Golf Carts?","false"))
		.setRecreationalVehiclesOwned(eai.getOrDefault("Any owned recreational vehicles?","false"))
		.setHousekeepingCondition(eai.getOrDefault("Housekeeping Condition","Average Condition"));




		// Protection Details
		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();



		if(!eai.getOrDefault("Burglar Alarm Type","none").toLowerCase().equals("none"))
			pd.
			setBurglarAlarm("true")
			.setBurglarAlarmType(eai.get("Burglar Alarm Type"));

		pd
		.setLockedPrivacyFence(eai.getOrDefault("Is there a locked privacy fence","false"))
		.setBurglarBarsOnWindows(eai.getOrDefault("are there any burglar bars on the windows/doors?","false"));

		if(eai.getOrDefault("are there any burglar bars on the windows/doors?", "false").toLowerCase().equals("true"))
			pd.safetyLatchesPresent("true");
		pd
		.setCommunityGuarded(eai.getOrDefault("Is the community Guarded?", "false"))
		.setGatedCommunity(eai.getOrDefault("Is the community Gated?", "false"));

		if(!eai.getOrDefault("Fire Alarm type", "none").toLowerCase().equals("none"))
			pd.setFireAlarm("true")
				.setFireAlarmType(eai.get("Fire Alarm type"));
		pd
		.setSmokeAlarm(eai.getOrDefault("Smoke Alarms","false"))
		.setFireExtinguishers(eai.getOrDefault("One or move fire extinguishers in the home?","false"));

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		Dwelling.AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			sab
			.setType("Person")
			.setFirstName(fName)
			.setLastName(lName)
			.setCity(addInts.get(i).get("City"))
			.setState(addInts.get(i).get("State"))
			.setZipCode(addInts.get(i).get("Zip Code"))
			.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
			{
				ai = sab.selectFirstSearchResultAdditionalInterests();
				ai
				.setType(i+1,addInts.get(i).get("Type"))
				.setLoanNumber(i+1,addInts.get(i).getOrDefault("Loan Number", null));


			}
			else
			{

				ai = sab.clickReturnToDwelling();
				NewAdditionalInterest nai =  ai.clickAddNewPerson();
				nai
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null))
				.setFirstName(fName)
				.setLastName(lName)
//				.clickSameAddressAsPrimaryNamedInsured()
				.setAddress1(addInts.get(i).get("Address"))
				.setCity(addInts.get(i).get("City"))
				.setState(addInts.get(i).get("State"))
				.setZipCode(addInts.get(i).get("Zip Code"))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
				.setAddressType("Home")
				.clickOk();




			}


		}

		DwellingConstruction dc = ai.next();

		// Dwelling Construction
		dc
		.setValuationType(eai.getOrDefault("Valuation Type","<none>"))
		.setEstimatedReplacementCost(eai.get("Estimated Replacement Cost"))
		.setConstructionType(eai.get("Construction Type"))
		.setNumberOfUnits(eai.get("Number of Units"))
		.setUnitsInFireWall(eai.get("Units in Fire Wall"))
		.setNumberOfStories(eai.get("Number of Stories"))
		.setSquareFootage(eai.get("Square Footage"))
		.setFoundationType(eai.get("Foundation Type"))
		.setPrimaryHeating(eai.getOrDefault("Primary Heating","<none>"))
		.setIsThereASecondaryHeatingSystem(eai.getOrDefault("Is there a secondary heating system?","false"))
		.setPlumbing(eai.get("Plumbing Type"))
		.setPlumbingYear(eai.get("Plumbing Year"))
		.setWaterHeaterYear(eai.get("Water Heater Year"))
		.setWiring(eai.getOrDefault("Wiring", "Copper"))
		.setElectricalSystem(eai.getOrDefault("Electrical System","None"))
		.setRoofType(eai.get("Roof Type"))
		.setRoofYear(eai.getOrDefault("Roof Year",eai.get("Year Built")))
		.setConditionOfRoof(eai.getOrDefault("Condition of Roof","<none>"))
		.setScreenEnclosureOnPremises(eai.getOrDefault("Is there a screen enclosure on premises?","false"))



		.setPlumbingSystemHaveKnownLeaks(eai.getOrDefault("Does the plumbing system have known leaks?","false"))
		.setBuildingRetrofittedForEarthquakes(eai.getOrDefault("Is the building retrofitted for earthquakes?","false"))
		.setUncorrectedFireOrBuildingCodeViolations(eai.getOrDefault("Any uncorrected fire or building code violations?","false"))
		.setStructureOriginallyBuiltForOtherThanPrivateResidence(eai.getOrDefault("Was the structure originally built for other than a private residence and then converted?","false"))
		.setLeadPaintHazard(eai.getOrDefault("Any lead paint hazard", "false"))
		.setAnyPortionOfAnyStructureAtThisPropertyLocation(eai.getOrDefault("Is any portion of any structure at this property location now (or ever has been) " +
		"a mobile home, modular home, trailer home, or other pre-fabricated home?", "false"));


		// Wind Mitigation
		DwellingConstruction.WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.get("Roof Shape"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		Coverages co;

		if(Integer.parseInt(eai.get("Year Built")) >= 2002)
		{
			wm
			.setRoofDeck(eai.getOrDefault("Roof Deck","<none>"))
			.setFbcWindSpeed(eai.getOrDefault("FBC Wind Speed","100 MPH"))
			.setInternalPressure(eai.getOrDefault("Internal Pressure", "<none>"))
			.setWindBorneDebris(eai.get("Wind Borne Debris Region"));
			if(qualifiesForHurricaneProtection(eai))
				co = wm.doubleClickNext();
			else
				co = wm.next();
		}
		else
		{
			wm.setRoofCover(eai.get("Roof Cover"))
			.setRoofDeckAttachment(eai.get("Roof Deck Attachment"))
			.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
		.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"))
		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles - AOP"));

		if(eai.get("Wind Excluded").toLowerCase().equals("false") && eai.get("Wind Excluded") != null)
			co
			.setHurricane(eai.get("Section I Deductibles - Hurricane"));

		co
		.setPersonalLiabilityLimit(eai.get("Personal Liability"))
		.setMedicalPaymentsLimit(eai.get("Medical Payments"));





		// Property Endorsements
		Coverages.PropertyEndorsements pe = co.clickPropertyEndorsements();

		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null)
			pe
			.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));

		if(eai.get("Specific Other Structures - Limit" ) != null)
		{
			pe
			.checkSpecificOtherStructures()
			.addSpecificOtherStructures()
			//.setSpecificOtherStructuresDescription(1,"Jelly")
			.setSpecificOtherStructuresLimit(1,eai.get("Specific Other Structures - Limit"));
		}

		if(eai.get("Other Structures Increase Coverage - Rented to Others - Limit") != null)
		{
			pe
			.checkOtherStructuresIncreasedCoverageRentedToOthers()
			.clickAddOtherStructures()
			.setOtherStructuresDescription(1, eai.get("Other Structures Increase Coverage - Rented to Others - Description"))
			.setOtherStructuresLimit(1, eai.get("Other Structures Increase Coverage - Rented to Others - Limit"));

		}

		if(spp.size() > 0)
			pe.checkScheduledPersonalProperty();

		for(int j = 1; j <= spp.size();j++)
		{
			pe
			.clickAddScheduledPersonalProperty()
			.setPersonalPropertyArticleType(j,spp.get(j-1).get("Class"))
			.setPersonalPropertyDescription(j, spp.get(j-1).get("Description"))
			.setPersonalPropertyValue(j, spp.get(j-1).get("Limit"));

		}

		pe
		.setOccurrenceAggregateLimit(eai.get("Limited Fungi (Limit)"))
		.setLossAssessmentLimit(eai.get("Loss Assessment (Limit)"))
		.setOrdinanceOrLawLimit(eai.get("Ordinance or Law - Percent"));

		if(eai.getOrDefault("Screen Enclosure Hurricane Coverage (Limit)",null) != null)
			pe
			.checkScreenEnclosureHurricaneCoverage()
			.setScreenEnclosureHurricaneCoverageLimit(eai.get("Screen Enclosure Hurricane Coverage (Limit)"));

		if(eai.getOrDefault("Credit Card (Limit)", null) != null)
			if(pe.isCreditCardCheckBoxAvailable())
				pe.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));



		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			pe
			.checkSinkholeLossCoverage()
			.setSinkholeClaimsIndex("4500")
			.setSinkholeIndex("330");

		// Liability Endorsements
		Coverages.LiabilityEndorsements le = pe.clickLiabilityEndorsements();
		if(eai.getOrDefault("Permitted Incidental Occupancy - Liability",null) != null)
			le
			.checkPermittedIncidentalOccupancyLiability();

//		if(!eai.get("Animal Liability").equals(""))
//			le.checkAnimalLiability();

		if(eai.getOrDefault("Additional Residence Rented to Others - Number of families",null) != null)
			le
			.checkAdditionalResidenceRentedToOthers()
			.setLocationName("1:")
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		if(eai.getOrDefault("Business Pursuits - Business activity", null) != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(eai.getOrDefault("Watercraft Liablity - Watercraft Type",null) != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));

		RiskAnalysis ra = le.next();

		if(qualifiesForHurricaneProtection(eai))
			ra.qualifiesForAdditionalProtectionQuote();
		else
			ra.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
	public void SubmissionLoadTest(ITestContext itc, LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		int i;
		int[] territoryList = new int[] {043,193, 393, 593, 596, 601, 603, 604, 605, 606, 607, 608, 609, 693, 721, 722, 723, 724, 725, 726, 737, 793, 931, 932, 934,993};
//		for(i =0 ; i < eai.size() - 1; i++)
//		{
//			itc.getCurrentXmlTest().addParameter(eai.keySet());
//		}
		for (Map.Entry<String, String> entry : eai.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();

			itc.getCurrentXmlTest().addParameter(key,value);

		}

		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
		System.out.println(new DateTime().toString());

		log("Test new person account creation");

		//String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

		enterAccountInfo
			.setFirstName(firstName)
			.setCountry("United States")
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setZipCode(eai.get("Mailing Zip Code"))
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
			.setWorkPhone(eai.getOrDefault("Work Phone",null))
			.setPrimaryEmail(eai.getOrDefault("Email Address",null))
			.setState(eai.getOrDefault("Mailing State",null))
			.setZipCode(eai.getOrDefault("Mailing Zip Code",null))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForCreateAccount()
			.setAddressType(eai.getOrDefault("Address Type","Home"))
			//.setDescription("Nerd Lair")
			.setSsn(eai.getOrDefault("SSN", null))
			.setOrganization(eai.getOrDefault("Organization", null))
			.setProducerCode(eai.getOrDefault("Producer Code", null));

			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
		log("Test simple homeowners policy renewal");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();
		Qualification qualification = submission.productTable.selectHomeowners();

		qualification.setPolicyType(eai.get("Policy Type"));
		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		PolicyInfo pi = qualification.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			SearchAddressBook sab = pi.clickAddFromAddressBook();
			// See if value is for a person or company
			if(keyContainsValue(eai,"Additional Name Insured First Name" ))
			{
				person = true;
				sab.setType("Person")
				.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
				.setLastName(eai.get("Additional Name Insured Last Name"))
				.setTaxID(eai.getOrDefault("Additional Name Insured SSN", null));
			}
			else
			{
				sab.setType("Company")
				.setCompanyName(eai.get("Additional Name Insured Company Name"));
			}

			sab.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
				sab.selectFirstSearchResultPolicyInfo();

			// No results, add person/company
			else
			{
				pi = sab.clickReturnToPolicyInfo();
				// Add a person
				if(person)
				{
					NewAdditionalNameInsured ani = pi.clickAddNewPerson();
					ani

					.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
					.setLastName(eai.getOrDefault("Additional Name Insured Last Name", null))
					.setDateOfBirth(eai.getOrDefault("Additional Name Insured Date of Birth", null))
					.setSsn(eai.getOrDefault("Additional Name Insured SSN" , null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();
				}
				// Add a company
				else if (eai.getOrDefault("Additional Name Insured Company Name", null) != null)
				{
					System.out.println("COMPANY NAME IS: " + eai.get("Additional Name Insured Company Name"));
					NewAdditionalNameInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		Dwelling dwelling = pi.next();

		// Dwelling
		dwelling
		.setLocationName("1:") // Left as is
		.setYearBuilt(eai.getOrDefault("Year Built", null))
		.setDistanceToFireHydrant(eai.getOrDefault("Distance to Fire Hydrant", null))
		.setDistanceToFireStation(eai.getOrDefault("Distance to Fire Station", null))
		.setTerritoryCode(eai.getOrDefault("Territory Code", null));

		if(Integer.parseInt(eai.get("Year Built")) >1994)
		{
			dwelling.setBCEG(eai.getOrDefault("BCEG", null));
		}
		dwelling
		.setProtectionClassCode(eai.getOrDefault("Protection Class Code", null))
		.setLocationType(eai.getOrDefault("Location Type","In City Limits"))
		.setInTheWindpool(eai.getOrDefault("In the Windpool?", null))
		.setDistanceToCoast(eai.getOrDefault("Distance to Coast", null))
		.setPurchaseDate(eai.getOrDefault("Purchase Date", null))
		.setPurchasePrice(eai.getOrDefault("Purchase Price", null))
		.setMarketValue(eai.getOrDefault("Market Value", null))
		.setOwnedByOther(eai.getOrDefault("At the inception of this policy, will this property be deeded in the name of corporation, business, LLC or any other entity?", "false"))
		.setOccupiedDaily(eai.getOrDefault("Occupied Daily","true"))
		.setResidenceType(eai.getOrDefault("Residence Type", null))
		.setDwellingUsage(eai.getOrDefault("How is the dwelling customarily Used", null))
		.setDwellingOccupancy(eai.getOrDefault("How is the dwelling occupied", null));


		if(!eai.getOrDefault("Is there a swimming pool?","false").toLowerCase().equals("false"))
		{
			dwelling
			.setSwimmingPool("true")
			.setPoolLocation(eai.getOrDefault("Is there a swimming pool?", "<none>"))
			.setPoolFenced("true")
			.setFenceType("Approved Fence");

			dwelling
			.setDivingBoard("false")
			.setPoolSlide("false");
		}
		dwelling
		.setTrampolineOnPremises(eai.getOrDefault("Is there a trampoline","false"))
		.setSkateboardBicycleRampOnPremises(eai.getOrDefault("is there a skateboard or bicycle ramp on premises?","false"))
		.setAnimalsOrExoticPets(eai.getOrDefault("Any animals or exotic pets on premises?","false"))
		.setGolfCarts(eai.getOrDefault("Any owned Golf Carts?","false"))
		.setRecreationalVehiclesOwned(eai.getOrDefault("Any owned recreational vehicles?","false"))
		.setHousekeepingCondition(eai.getOrDefault("Housekeeping Condition","Average Condition"));




		// Protection Details
		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();



		if(!eai.getOrDefault("Burglar Alarm Type","none").toLowerCase().equals("none"))
			pd.
			setBurglarAlarm("true")
			.setBurglarAlarmType(eai.get("Burglar Alarm Type"));

		pd
		.setLockedPrivacyFence(eai.getOrDefault("Is there a locked privacy fence","false"))
		.setBurglarBarsOnWindows(eai.getOrDefault("are there any burglar bars on the windows/doors?","false"));

		if(eai.getOrDefault("are there any burglar bars on the windows/doors?", "false").toLowerCase().equals("true"))
			pd.safetyLatchesPresent("true");
		pd
		.setCommunityGuarded(eai.getOrDefault("Is the community Guarded?", "false"))
		.setGatedCommunity(eai.getOrDefault("Is the community Gated?", "false"));

		if(!eai.getOrDefault("Fire Alarm type", "none").toLowerCase().equals("none"))
			pd.setFireAlarm("true")
				.setFireAlarmType(eai.get("Fire Alarm type"));
		pd
		.setSmokeAlarm(eai.getOrDefault("Smoke Alarms","false"))
		.setFireExtinguishers(eai.getOrDefault("One or move fire extinguishers in the home?","false"));

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		Dwelling.AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			sab
			.setType("Person")
			.setFirstName(fName)
			.setLastName(lName)
			.setCity(addInts.get(i).get("City"))
			.setState(addInts.get(i).get("State"))
			.setZipCode(addInts.get(i).get("Zip Code"))
			.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
			{
				ai = sab.selectFirstSearchResultAdditionalInterests();
				ai
				.setType(i+1,addInts.get(i).get("Type"))
				.setLoanNumber(i+1,addInts.get(i).getOrDefault("Loan Number", null));


			}
			else
			{

				ai = sab.clickReturnToDwelling();
				NewAdditionalInterest nai =  ai.clickAddNewPerson();
				nai
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null))
				.setFirstName(fName)
				.setLastName(lName)
//				.clickSameAddressAsPrimaryNamedInsured()
				.setAddress1(addInts.get(i).get("Address"))
				.setCity(addInts.get(i).get("City"))
				.setState(addInts.get(i).get("State"))
				.setZipCode(addInts.get(i).get("Zip Code"))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
				.setAddressType("Home")
				.clickOk();




			}


		}

		DwellingConstruction dc = ai.next();

		// Dwelling Construction
		dc
		.setValuationType(eai.getOrDefault("Valuation Type","<none>"))
		.setEstimatedReplacementCost(eai.get("Estimated Replacement Cost"))
		.setConstructionType(eai.get("Construction Type"))
		.setNumberOfUnits(eai.get("Number of Units"))
		.setUnitsInFireWall(eai.get("Units in Fire Wall"))
		.setNumberOfStories(eai.get("Number of Stories"))
		.setSquareFootage(eai.get("Square Footage"))
		.setFoundationType(eai.get("Foundation Type"))
		.setPrimaryHeating(eai.getOrDefault("Primary Heating","<none>"))
		.setIsThereASecondaryHeatingSystem(eai.getOrDefault("Is there a secondary heating system?","false"))
		.setPlumbing(eai.get("Plumbing Type"))
		.setPlumbingYear(eai.get("Plumbing Year"))
		.setWaterHeaterYear(eai.get("Water Heater Year"))
		.setWiring(eai.getOrDefault("Wiring", "Copper"))
		.setElectricalSystem(eai.getOrDefault("Electrical System","None"))
		.setRoofType(eai.get("Roof Type"))
		.setRoofYear(eai.getOrDefault("Roof Year",eai.get("Year Built")))
		.setConditionOfRoof(eai.getOrDefault("Condition of Roof","<none>"))
		.setScreenEnclosureOnPremises(eai.getOrDefault("Is there a screen enclosure on premises?","false"))



		.setPlumbingSystemHaveKnownLeaks(eai.getOrDefault("Does the plumbing system have known leaks?","false"))
		.setBuildingRetrofittedForEarthquakes(eai.getOrDefault("Is the building retrofitted for earthquakes?","false"))
		.setUncorrectedFireOrBuildingCodeViolations(eai.getOrDefault("Any uncorrected fire or building code violations?","false"))
		.setStructureOriginallyBuiltForOtherThanPrivateResidence(eai.getOrDefault("Was the structure originally built for other than a private residence and then converted?","false"))
		.setLeadPaintHazard(eai.getOrDefault("Any lead paint hazard", "false"))
		.setAnyPortionOfAnyStructureAtThisPropertyLocation(eai.getOrDefault("Is any portion of any structure at this property location now (or ever has been) " +
		"a mobile home, modular home, trailer home, or other pre-fabricated home?", "false"));


		// Wind Mitigation
		DwellingConstruction.WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.get("Roof Shape"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		Coverages co;
		
		if(Integer.parseInt(eai.get("Year Built")) >= 2002)
		{
			wm
			.setRoofDeck(eai.getOrDefault("Roof Deck","<none>"))
			.setFbcWindSpeed(eai.getOrDefault("FBC Wind Speed","100 MPH"))
			.setInternalPressure(eai.getOrDefault("Internal Pressure", "<none>"))
			.setWindBorneDebris(eai.get("Wind Borne Debris Region"));
			if(qualifiesForHurricaneProtection(eai))
				co = wm.doubleClickNext();
			else
				co = wm.next();
		}
		else
		{
			wm.setRoofCover(eai.get("Roof Cover"))
			.setRoofDeckAttachment(eai.get("Roof Deck Attachment"))
			.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
		.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"))
		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles - AOP"));

		if(eai.get("Wind Excluded").toLowerCase().equals("false") && eai.get("Wind Excluded") != null)
			co
			.setHurricane(eai.get("Section I Deductibles - Hurricane"));

		co
		.setPersonalLiabilityLimit(eai.get("Personal Liability"))
		.setMedicalPaymentsLimit(eai.get("Medical Payments"));





		// Property Endorsements
		Coverages.PropertyEndorsements pe = co.clickPropertyEndorsements();

		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null)
			pe
			.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));

		if(eai.get("Specific Other Structures - Limit" ) != null)
		{
			pe
			.checkSpecificOtherStructures()
			.addSpecificOtherStructures()
			//.setSpecificOtherStructuresDescription(1,"Jelly")
			.setSpecificOtherStructuresLimit(1,eai.get("Specific Other Structures - Limit"));
		}

		if(eai.get("Other Structures Increase Coverage - Rented to Others - Limit") != null)
		{
			pe
			.checkOtherStructuresIncreasedCoverageRentedToOthers()
			.clickAddOtherStructures()
			.setOtherStructuresDescription(1, eai.get("Other Structures Increase Coverage - Rented to Others - Description"))
			.setOtherStructuresLimit(1, eai.get("Other Structures Increase Coverage - Rented to Others - Limit"));

		}

		if(spp.size() > 0)
			pe.checkScheduledPersonalProperty();

		for(int j = 1; j <= spp.size();j++)
		{
			pe
			.clickAddScheduledPersonalProperty()
			.setPersonalPropertyArticleType(j,spp.get(j-1).get("Class"))
			.setPersonalPropertyDescription(j, spp.get(j-1).get("Description"))
			.setPersonalPropertyValue(j, spp.get(j-1).get("Limit"));

		}

		pe
		.setOccurrenceAggregateLimit(eai.get("Limited Fungi (Limit)"))
		.setLossAssessmentLimit(eai.get("Loss Assessment (Limit)"))
		.setOrdinanceOrLawLimit(eai.get("Ordinance or Law - Percent"));

		if(eai.getOrDefault("Screen Enclosure Hurricane Coverage (Limit)",null) != null)
			pe
			.checkScreenEnclosureHurricaneCoverage()
			.setScreenEnclosureHurricaneCoverageLimit(eai.get("Screen Enclosure Hurricane Coverage (Limit)"));

		if(eai.getOrDefault("Credit Card (Limit)", null) != null)
			if(pe.isCreditCardCheckBoxAvailable())
				pe.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));



		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			pe
			.checkSinkholeLossCoverage()
			.setSinkholeClaimsIndex("4500")
			.setSinkholeIndex("330");

		// Liability Endorsements
		Coverages.LiabilityEndorsements le = pe.clickLiabilityEndorsements();
		if(eai.getOrDefault("Permitted Incidental Occupancy - Liability",null) != null)
			le
			.checkPermittedIncidentalOccupancyLiability();

//		if(!eai.get("Animal Liability").equals(""))
//			le.checkAnimalLiability();

		if(eai.getOrDefault("Additional Residence Rented to Others - Number of families",null) != null)
			le
			.checkAdditionalResidenceRentedToOthers()
			.setLocationName("1:")
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		if(eai.getOrDefault("Business Pursuits - Business activity", null) != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(eai.getOrDefault("Watercraft Liablity - Watercraft Type",null) != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));

		RiskAnalysis ra = le.next();

		if(qualifiesForHurricaneProtection(eai))
			ra.qualifiesForAdditionalProtectionQuote();
		else
			ra.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}
	public boolean qualifiesForHurricaneProtection(LinkedHashMap<String, String> eai)
	{
		int[] territoryList = new int[] {043,193, 393, 593, 596, 601, 603, 604, 605, 606, 607, 608, 609, 693, 721, 722, 723, 724, 725, 726, 737, 793, 931, 932, 934,993};

		if(eai.get("Mailing State").toLowerCase().equals("florida")
		&& eai.get("Wind Borne Debris Region").toLowerCase().equals("true")
		&& eai.getOrDefault("Opening Protection Type", "<none>").toLowerCase() != "hurricane"
		&&
		(
			(Integer.parseInt(eai.get("Year Built")) >= 2002
			&&
				(
					(
					eai.get("Territory Code") == "602"
        			&& eai.get("Mailing City").toLowerCase() == "pensacola"
					)
					||
					(
					eai.get("Territory Code") != "602"
					&& !isInArray(territoryList,Integer.parseInt(eai.get("Territory Code")))
					)

				)
			)
			||
			(Integer.parseInt(eai.get("Year Built")) >= 2007
			&&
				(
					(
					eai.get("Territory Code") == "602"
        			&& eai.get("Mailing City").toLowerCase() != "pensacola"
					)
					||
					(
					isInArray(territoryList,Integer.parseInt(eai.get("Territory Code")))
					)

				)

			)
		))
			return true;
		return false;

	}
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "POCData")
	public void tableTest(LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts,ArrayList<LinkedHashMap<String, String>> spp)
	{

		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);
		int i;

		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
		System.out.println(new DateTime().toString());

		log("Test new person account creation");

		//String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

		enterAccountInfo
			.setFirstName(firstName)
			.setCountry("United States")
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setZipCode(eai.get("Mailing Zip Code"))
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
			.setWorkPhone(eai.getOrDefault("Work Phone",null))
			.setPrimaryEmail(eai.getOrDefault("Email Address",null))
			.setState(eai.getOrDefault("Mailing State",null))
			.setZipCode(eai.getOrDefault("Mailing Zip Code",null))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForCreateAccount()
			.setAddressType(eai.getOrDefault("Address Type","Home"))
			//.setDescription("Nerd Lair")
			.setSsn(eai.getOrDefault("SSN", null))
			.setOrganization(eai.getOrDefault("Organization", null))
			.setProducerCode(eai.getOrDefault("Producer Code", null));

			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
		log("Test simple homeowners policy renewal");
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new AccountFileSummary(sh);
		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();

		// Initiate Manual Renewal
		imr.setOrganization(eai.getOrDefault("Organization", null))
		.setProducerCode(eai.getOrDefault("Producer Code", null))
		.setBaseState(eai.getOrDefault("Mailing State", null))
		.setProduct(eai.getOrDefault("Product", null))
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setLegacyPolicyNumber(eai.getOrDefault("Legacy Policy Number", null))
		.setOriginalEffectiveDate(eai.getOrDefault("Policy Original Effective Date",null))
		.setEffectiveDate(eai.getOrDefault("Effective Date",null))
		.setLastInspectionCompletionDate(eai.getOrDefault("Last Inspection Completion Date", null))
		.setInflationGuard(eai.getOrDefault("Inflation Guard", null))
		.clickExcludeLossOfUseCoverage(eai.getOrDefault("Exclude Loss of Use Coverage", null));
		Offerings offerings = imr.nextAndAccept();

		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		PolicyInfo pi = offerings.next();

		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			SearchAddressBook sab = pi.clickAddFromAddressBook();
			// See if value is for a person or company
			if(keyContainsValue(eai,"Additional Name Insured First Name" ))
			{
				person = true;
				sab.setType("Person")
				.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
				.setLastName(eai.get("Additional Name Insured Last Name"))
				.setTaxID(eai.getOrDefault("Additional Name Insured SSN", null));
			}
			else
			{
				sab.setType("Company")
				.setCompanyName(eai.get("Additional Name Insured Company Name"));
			}

			sab.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
				sab.selectFirstSearchResultPolicyInfo();

			// No results, add person/company
			else
			{
				pi = sab.clickReturnToPolicyInfo();
				// Add a person
				if(person)
				{
					NewAdditionalNameInsured ani = pi.clickAddNewPerson();
					ani

					.setFirstName(eai.getOrDefault("Additional Name Insured First Name", null))
					.setLastName(eai.getOrDefault("Additional Name Insured Last Name", null))
					.setDateOfBirth(eai.getOrDefault("Additional Name Insured Date of Birth", null))
					.setSsn(eai.getOrDefault("Additional Name Insured SSN" , null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();
				}
				// Add a company
				else
				{
					NewAdditionalNameInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		Dwelling dwelling = pi.next();

		// Dwelling
		dwelling
		.setLocationName("1:") // Left as is
		.setYearBuilt(eai.getOrDefault("Year Built", null))
		.setDistanceToFireHydrant(eai.getOrDefault("Distance to Fire Hydrant", null))
		.setDistanceToFireStation(eai.getOrDefault("Distance to Fire Station", null))
		.setTerritoryCode(eai.getOrDefault("Territory Code", null))
		.setBCEG(eai.getOrDefault("BCEG", null))
		.setProtectionClassCode(eai.getOrDefault("Protection Class Code", null))
		.setLocationType(eai.getOrDefault("Location Type","In City Limits"))
		.setInTheWindpool(eai.getOrDefault("In the Windpool?", null))
		.setDistanceToCoast(eai.getOrDefault("Distance to Coast", null))
		.setPurchaseDate(eai.getOrDefault("Purchase Date", null))
		.setPurchasePrice(eai.getOrDefault("Purchase Price", null))
		.setMarketValue(eai.getOrDefault("Market Value", null))
		.setOwnedByOther(eai.getOrDefault("At the inception of this policy, will this property be deeded in the name of corporation, business, LLC or any other entity?", "false"))
		.setOccupiedDaily(eai.getOrDefault("Occupied Daily","true"))
		.setResidenceType(eai.getOrDefault("Residence Type", null))
		.setDwellingUsage(eai.getOrDefault("How is the dwelling customarily Used", null))
		.setDwellingOccupancy(eai.getOrDefault("How is the dwelling occupied", null));


		if(!eai.get("Is there a swimming pool?").toLowerCase().equals("false") && eai.get("Is there a swimming pool?") != null)
		{
			dwelling
			.setSwimmingPool("true")
			.setPoolLocation(eai.getOrDefault("Is there a swimming pool?", "<none>"))
			.setPoolFenced("true");

			if(eai.get("Pool Fence Type").toLowerCase().equals("true")) // hashkey assumed
				dwelling.setFenceType("Screen Enclosure");

			dwelling
			.setDivingBoard("false")
			.setPoolSlide("false");
		}
		dwelling
		.setTrampolineOnPremises(eai.getOrDefault("Is there a trampoline","false"))
		.setSkateboardBicycleRampOnPremises(eai.getOrDefault("is there a skateboard or bicycle ramp on premises?","false"))
		.setAnimalsOrExoticPets(eai.getOrDefault("Any animals or exotic pets on premises?","false"))
		.setGolfCarts(eai.getOrDefault("Any owned Golf Carts?","false"))
		.setRecreationalVehiclesOwned(eai.getOrDefault("Any owned recreational vehicles?","false"))
		.setHousekeepingCondition(eai.getOrDefault("Housekeeping Condition","Average Condition"));




		// Protection Details
		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();



		if(!eai.get("Burglar Alarm Type").toLowerCase().equals("false") && eai.get("Burglar Alarm Type") != null)
			pd.
			setBurglarAlarm("true")
			.setBurglarAlarmType(eai.get("Burglar Alarm Type"));

		pd
		.setLockedPrivacyFence(eai.getOrDefault("Is there a locked privacy fence","false"))
		.setBurglarBarsOnWindows(eai.getOrDefault("are there any burglar bars on the windows/doors?","false"));

		if(eai.get("are there any burglar bars on the windows/doors?").toLowerCase().equals("true"))
			pd.safetyLatchesPresent("true");
		pd
		.setCommunityGuarded(eai.get("Is the community Guarded?"))
		.setGatedCommunity(eai.get("Is the community Gated?"));

		if(!eai.get("Fire Alarm type").equals("false") && eai.get("Fire Alarm type") != null)
			pd.setFireAlarm("true")
				.setFireAlarmType(eai.get("Fire Alarm type"));
		pd
		.setSmokeAlarm(eai.get("Smoke Alarms"))
		.setFireExtinguishers(eai.getOrDefault("One or move fire extinguishers in the home?","false"));

		if(!eai.get("Sprinkler System").toLowerCase().equals("false") && eai.get("Sprinkler System") != null)

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		Dwelling.AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			sab
			.setType("Person")
			.setFirstName(fName)
			.setLastName(lName)
			.setCity(addInts.get(i).get("City"))
			.setState(addInts.get(i).get("State"))
			.setZipCode(addInts.get(i).get("Zipcode"))
			.clickSearch();
			// See if there are search results
			if(sab.areThereSearchResults())
			{
				ai = sab.selectFirstSearchResultAdditionalInterests();
				ai
				.setType(i+1,addInts.get(i).get("Type"))
				.setLoanNumber(i+1,addInts.get(i).getOrDefault("Loan Number", null));


			}
			else
			{

				ai = sab.clickReturnToDwelling();
				NewAdditionalInterest nai =  ai.clickAddNewPerson();
				nai
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null))
				.setFirstName(fName)
				.setLastName(lName)
//				.clickSameAddressAsPrimaryNamedInsured()
				.setAddress1(addInts.get(i).get("Address"))
				.setCity(addInts.get(i).get("City"))
				.setState(addInts.get(i).get("State"))
				.setZipCode(addInts.get(i).get("Zipcode"))
				.clickVerifyAddress()
				.selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
				.setAddressType("Home")
				.clickOk();




			}


		}

		DwellingConstruction dc = ai.next();

		// Dwelling Construction
		dc
		.setValuationType(eai.getOrDefault("Valuation Type","<none>"))
		.setEstimatedReplacementCost(eai.get("Estimated Replacement Cost"))
		.setConstructionType(eai.get("Construction Type"))
		.setNumberOfUnits(eai.get("Number of Units"))
		.setUnitsInFireWall(eai.get("Units in Fire Wall"))
		.setNumberOfStories(eai.get("Number of Stories"))
		.setSquareFootage(eai.get("Square Footage"))
		.setFoundationType(eai.get("Foundation Type"))
		.setPrimaryHeating(eai.getOrDefault("Primary Heating","<none>"))
		.setIsThereASecondaryHeatingSystem(eai.get("Is there a secondary heating system?"))
		.setPlumbing(eai.get("Plumbing Type"))
		.setPlumbingYear(eai.get("Plumbing Year"))
		.setWaterHeaterYear(eai.get("Water Heater Year"))
		.setWiring(eai.getOrDefault("Wiring", "Copper"))
		.setElectricalSystem(eai.getOrDefault("Electrical System","None"))
		.setRoofType(eai.get("Roof Type"))
		.setRoofYear(eai.getOrDefault("Roof Year",eai.get("Year Built")))
		.setConditionOfRoof(eai.getOrDefault("Condition of Roof","<none>"))
		.setScreenEnclosureOnPremises(eai.get("Is there a screen enclosure on premises?"))



		.setPlumbingSystemHaveKnownLeaks(eai.getOrDefault("Does the plumbing system have known leaks?","false"))
		.setBuildingRetrofittedForEarthquakes(eai.getOrDefault("Is the building retrofitted for earthquakes?","false"))
		.setUncorrectedFireOrBuildingCodeViolations(eai.getOrDefault("Any uncorrected fire or building code violations?","false"))
		.setStructureOriginallyBuiltForOtherThanPrivateResidence(eai.getOrDefault("Was the structure originally built for other than a private residence and then converted?","false"))
		.setLeadPaintHazard(eai.getOrDefault("Any lead paint hazard", "false"))
		.setAnyPortionOfAnyStructureAtThisPropertyLocation(eai.getOrDefault("Is any portion of any structure at this property location now (or ever has been) " +
		"a mobile home, modular home, trailer home, or other pre-fabricated home?", "false"));


		// Wind Mitigation
		DwellingConstruction.WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.get("Roof Shape"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setRoofCover(eai.get("Roof Cover"))
		.setRoofDeckAttachment(eai.get("Roof Deck Attachment"))
		.setRoofWallConnection(eai.get("Roof Wall Connection"))
		.setSecondaryWaterResistance(eai.get("Secondary Water Resistance"));
		Coverages co = wm.next()

		// Coverages
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
		.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"))
		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles - AOP"));

		if(eai.get("Wind Excluded").toLowerCase().equals("false") && eai.get("Wind Excluded") != null)
			co
			.setHurricane(eai.get("Section I Deductibles - Hurricane"));

		co
		.setPersonalLiabilityLimit(eai.get("Personal Liability"))
		.setMedicalPaymentsLimit(eai.get("Medical Payments"));





		// Property Endorsements
		Coverages.PropertyEndorsements pe = co.clickPropertyEndorsements();
		
		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null)
			pe
			.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));

		if(eai.get("Specific Other Structures - Limit" ) != null)
		{
			pe
			.checkSpecificOtherStructures()
			.addSpecificOtherStructures()
			.setSpecificOtherStructuresLimit(1,eai.get("Specific Other Structures - Limit"));
		}

		if(eai.get("Other Structures Increase Coverage - Rented to Others - Limit") != null)
		{
			pe
			.checkOtherStructuresIncreasedCoverageRentedToOthers()
			.clickAddOtherStructures()
			//.setOtherStructuresDescription(1, eai.get("Other Structures Increase Coverage - Rented to Others - Description " + i))
			.setOtherStructuresLimit(1, eai.get("Other Structures Increase Coverage - Rented to Others - Limit"));

		}

		if(spp.size() > 0)
			pe.checkScheduledPersonalProperty();

		for(int j = 1; j <= spp.size();j++)
		{
			pe
			.clickAddScheduledPersonalProperty()
			.setPersonalPropertyArticleType(j,spp.get(j-1).get("Class"))
			.setPersonalPropertyDescription(j, spp.get(j-1).get("Description"))
			.setPersonalPropertyValue(j, spp.get(j-1).get("Limit"));

		}

		pe
		.setOccurrenceAggregateLimit(eai.get("Limited Fungi (Limit)"))
		.setLossAssessmentLimit(eai.get("Loss Assessment (Limit)"))
		.setOrdinanceOrLawLimit(eai.get("Ordinance or Law - Percent"));

		if(!eai.get("Screen Enclosure Hurricane Coverage (Limit)").toLowerCase().equals(""))
			pe
			.checkScreenEnclosureHurricaneCoverage()
			.setScreenEnclosureHurricaneCoverageLimit(eai.get("Screen Enclosure Hurricane Coverage (Limit)"));
		
//		if(keyContainsValue(eai,"Credit Card (Limit)"))
//			pe.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));


		
		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.get("Sinkhole Loss Coverage").toLowerCase().equals("false"))
			pe
			.checkSinkholeLossCoverage()
			.setSinkholeClaimsIndex("4500")
			.setSinkholeIndex("330");

		// Liability Endorsements
		Coverages.LiabilityEndorsements le = pe.clickLiabilityEndorsements();
		if(!eai.get("Permitted Incidental Occupancy - Liability").toLowerCase().equals("false") && eai.get("Permitted Incidental Occupancy - Liability") != null)
			le
			.checkPermittedIncidentalOccupancyLiability();
		
//		if(!eai.get("Animal Liability").equals(""))
//			le.checkAnimalLiability();

		if(!eai.get("Additional Residence Rented to Others - Number of families").toLowerCase().equals("false") && eai.get("Additional Residence Rented to Others - Number of families") != null)
			le
			.checkAdditionalResidenceRentedToOthers()
			//.setLocationName("1:")
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		if(!eai.get("Business Pursuits - Business activity").toLowerCase().equals("false") && eai.get("Business Pursuits - Business activity") != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(!eai.get("Watercraft Liablity - Watercraft Type").toLowerCase().equals("false") && eai.get("Watercraft Liablity - Watercraft Type") != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));

		le
		.next()
		.quote();
		//.back().requestApproval().sendRequest();
		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));



	}
//	// Renewal types
//	public void FLH03AccountRenewalPOC()
//	{
//		int i= 0;
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Florida")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//
//		// Initiate Manual Renewal
//		imr.setOrganization("Brown and Brown of Florida, Inc")
//		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("Florida")
//		.setProduct("Homeowners")
//		.setPolicyType("Homeowners")
//		.setLegacyPolicyNumber(policyNumHO3)
//		.setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017")
//		.setLastInspectionCompletionDate("03/21/2015");
////		.setInflationGuard("12%")
////		.clickExcludeLossOfUseCoverage("false");
//		Offerings offerings = imr.nextAndAccept()
//
//		// Offerings
//		.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//
//		// Policy Info
//		pi.setOccupation("Twinkie Smuggler")
//		.setDoesInsuredOwnOtherResidenceWithFrontline("false")
//		.setTermType("Annual");
//		SearchAddressBook sab = pi
//		//.setPolicyWriter()
//		//.clickAddNewPerson()
//		.clickAddFromAddressBook();
//
//
//		// Search Address Book
//		sab
//		.setType("Person")
//		.setFirstName("fsadfasd")
//		.setLastName("fadsfasdfasdf")
//		.setCountry("United States")
//		.setCity("Melbourne")
//		.setState("Florida")
//		.setZipCode("32935")
//		.clickSearch();
//		if(sab.areThereSearchResults())
//			sab.selectFirstSearchResultPolicyInfo();
//		else
//		{
//			sab.clickReturnToPolicyInfo()
//			.clickAddNewPerson()
//			.setRelationshipToPrimary("Sugah Mama")
//
//			.setFirstName("Jelly")
//			.setLastName("Junior")
//			.setDateOfBirth("10/20/1986")
//			.setMaritalStatus("Married")
//			.setPrimaryPhone("Home")
//			.setHomePhone("456-987-6542")
//			.setWorkPhone("453-985-6325")
//			.setMobilePhone("323-254-8457")
//			.setFaxPhone("356-984-5478")
//			.setPrimaryEmail("jelly@jellymail.com")
//			.setSecondaryEmail("jiggla@jigglamail.com")
//			.setCountry("United States")
//			.setAddress1("2470 Wild Wood dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.clickVerifyAddress()
//			.selectAddressForNewAdditionalNamedInsured(2)
//			.setAddressType("Billing")
//			.setAddressDescription("Hideout")
//			.setLicenseNumber("156468465")
//			.setLicenseState("Florida")
//			.setSsn("598-99-6565")
//			.clickOk();
//
//		}
//
//
//
//		// New Additional Named Insured
//		Dwelling dwelling = pi.next();
//
//		// Dwelling
//		dwelling
//		.setLocationName("1:")
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setDistanceToFireStation("2100")
//		.setTerritoryCode("064")
//		.setBCEG("02")
//		.setProtectionClassCode("2")
//		.setLocationType("In City Limits")
//		.setInTheWindpool("true")
//		.setDistanceToCoast("2000")
//		.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setOwnedByOther("false")
//		.setOccupiedDaily("false")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setDwellingOccupancy("Owner Occupied")
//		.setSwimmingPool("true")
//		.setPoolLocation("In-Ground")
//		.setPoolFenced("true")
//		.setFenceType("Screen Enclosure")
//		.setDivingBoard("true")
//		.setPoolSlide("true")
//		.setTrampolineOnPremises("true")
//		.setSkateboardBicycleRampOnPremises("true")
//		.setAnimalsOrExoticPets("false")
//		.setGolfCarts("true")
//		.setRecreationalVehiclesOwned("true")
//		.setHousekeepingCondition("Excellent");
//
//
//
//		// Protection Details
//		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();
//		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
//		pd
//		.setBurglarAlarm("true")
//		.setLockedPrivacyFence("true")
//		.setBurglarBarsOnWindows("true")
//		.setCommunityGuarded("true")
//		.setGatedCommunity("true")
//		.setFireAlarm("true")
//		.setSmokeAlarm("true")
//		.setFireExtinguishers("true")
//		.setSprinklerSystem("true")
//		.setDeadbolts("true")
//		.setResidenceVisibleToNeighbors("true")
//		.safetyLatchesPresent("true")
//		.setFireAlarmType("Central Station")
//		.setSprinklerSystemType("Full")
//		.setBurglarAlarmType("Central Station")
//
//		// Additional Interests
//		.clickAdditionalInterests()
//		.clickAddNewPerson()
//		.setType("Additional Insured")
//		.setLoanNumber("747384")
//		.clickCertificateRequired("true")
//		.setFirstName("Jelly")
//		.setLastName("Junior")
//		.setDateOfBirth("10/20/1986")
//		.setMaritalStatus("Married")
//		.setPrimaryPhone("Home")
//		.setHomePhone("456-987-6542")
//		.setWorkPhone("453-985-6325")
//		.setMobilePhone("323-254-8457")
//		.setFaxPhone("356-984-5478")
//		.setPrimaryEmail("jelly@jellymail.com")
//		.setSecondaryEmail("jiggla@jigglamail.com")
//
//		.clickSameAddressAsPrimaryNamedInsured()
////		.setCountry("United States")
////		.setAddress1("2470 Wild Wood dr")
////		.setCity("Melbourne")
////		.setState("Florida")
////		.setZipCode("32935")
////		.clickVerifyAddress()
////		.selectAddressForNewAdditionalInterests(2)
////		.setAddressType("Billing")
////		.setAddressDescription("Hideout")
////		.setLicenseNumber("156468465")
////		.setLicenseState("Florida")
////		.setSsn("598-99-6565")
//		.clickOk()
//		.setType(1,"Trust")
//		.setEffectiveDate(1,"10/29/2017")
//		.next()
//
//		// Dwelling Construction
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setIsThereASecondaryHeatingSystem("true")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setRoofYear("2000")
//		.setConditionOfRoof("Good")
//		.setScreenEnclosureOnPremises("true")
//
//
//
//		.setPlumbingSystemHaveKnownLeaks("false")
//		.setBuildingRetrofittedForEarthquakes("false")
//		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
//		.setUncorrectedFireOrBuildingCodeViolations("false")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
//		.setLeadPaintHazard("false")
////		.setLeadPaintHazardDescription("best")
////		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
////		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")
//
//
//		// Wind Mitigation
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
//		.setTerrain("C")
//		.setRoofCover("FBC Equivalent")
//		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
//		.setRoofWallConnection("Clips")
//		.setSecondaryWaterResistance("true")
//		.next()
//
//		// Coverages
//		.setDwellingLimit("300000")
//		.setOtherStructuresPercentage("5%")
//		.setPersonalPropertyExcluded("false")
//		.setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value")
//		.setLossOfUseSelection("5%")
//		.setWindExcluded("false")
//		.setAllOtherPerils("5,000")
//		.setHurricane("2%")
//		.setPersonalLiabilityLimit("500,000")
//		.setMedicalPaymentsLimit("5,000")
//
//
//
//
//
//		// Property Endorsements
//		.clickPropertyEndorsements()
//		.checkGuardianEndorsements()
//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.clickAddOtherStructures()
//		.setOtherStructuresDescription(1,"Arsalans' Skill")
//		.setOtherStructuresLimit(1,"9001")
//		.checkScheduledPersonalProperty()
//		.clickAddScheduledPersonalProperty()
//		.setPersonalPropertyArticleType(1,"Jewelry")
//		.setPersonalPropertyDescription(1,"schweggggg")
//		.setPersonalPropertyValue(1,"234342")
//		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
//		//.checkPermittedIncidentalOccupancy()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkSinkholeLossCoverage()
//		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")
//
//		.setWhenSafeCreditPercentage("20%")
//		.setOccurrenceAggregateLimit("10,000 / 50,000")
//		.setLossAssessmentLimit("3000")
//		.setOrdinanceOrLawLimit("25%")
//		.setPercentageOfAnnualIncrease("12%")
//		.setSinkholeClaimsIndex("4500")
//		.setSinkholeIndex("330")
//
//		// Liability Endorsements
//		.clickLiabilityEndorsements()
//		.checkPermittedIncidentalOccupancyLiability()
//		//.checkAnimalLiability()
//		.checkAdditionalResidenceRentedToOthers()
//		.checkBusinessPursuits()
//		.checkWatercraftLiability()
//
//		.setLocationName("1:")
//		.setNumberOfFamilies("2 Family Residence")
//		.setBusinessActivity("Clerical Employee")
//		.setWatercraftType("Up to 50 Horsepower and 16-26 feet")
//
//
//
////		.checkOtherStructuresIncreasedCoverageRentedToOthers()
////		.checkScheduledPersonalProperty()
////		.checkScreenEnclosureHurricaneCoverage()
////		.checkSinkholeLossCoverage()
//		.next()
//		.quote();
//		//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//	public void SCH03AccountRenewalPOC()
//	{
//		int i= 0;
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Charleston")
//			.setState("South Carolina")
//			.setZipCode("29401")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("32 Legare St")
//			.setCity("Charleston")
//			.setState("South Carolina")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("South Carolina")
//
//			.setZipCode("29401")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//
//		// Initiate Manual Renewal
//		imr.setOrganization("Brown and Brown of Florida, Inc")
//		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("South Carolina")
//		.setProduct("Homeowners")
//		.setPolicyType("Homeowners")
//		.setLegacyPolicyNumber(policyNumHO3)
//		.setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017")
//		.setLastInspectionCompletionDate("03/21/2015")
//		.setInflationGuard("12%")
//		.clickExcludeLossOfUseCoverage("false")
//		.nextAndAccept()
//
//		// Offerings
//		.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular")
//		.next()
//
//		// Policy Info
//		.setOccupation("Twinkie Smuggler")
//		.setDoesInsuredOwnOtherResidenceWithFrontline("false")
//		.setNoPriorInsuranceSurcharge("false")
//		.setTermType("Annual")
//		//.setPolicyWriter()
//		.clickAddNewPerson()
//
//
//		// New Additional Named Insured
//		.setRelationshipToPrimary("Sugah Mama")
//
//		.setFirstName("Jelly")
//		.setLastName("Junior")
//		.setDateOfBirth("10/20/1986")
//		.setMaritalStatus("Married")
//		.setPrimaryPhone("Home")
//		.setHomePhone("456-987-6542")
//		.setWorkPhone("453-985-6325")
//		.setMobilePhone("323-254-8457")
//		.setFaxPhone("356-984-5478")
//		.setPrimaryEmail("jelly@jellymail.com")
//		.setSecondaryEmail("jiggla@jigglamail.com")
//		.setCountry("United States")
//		.setAddress1("2470 Wild Wood dr")
//		.setCity("Melbourne")
//		.setState("Florida")
//		.setZipCode("32935")
//		.clickVerifyAddress()
//		.selectAddressForNewAdditionalNamedInsured(2)
//		.setAddressType("Billing")
//		.setAddressDescription("Hideout")
//		.setLicenseNumber("156468465")
//		.setLicenseState("Florida")
//		.setSsn("598-99-6565")
//		.clickOk().next()
//
//		// Dwelling
//		.setLocationName("1:")
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setDistanceToFireStation("2100")
//		.setTerritoryCode("03S")
//		.setBCEG("02")
//		.setProtectionClassCode("2")
//		.setLocationType("In City Limits")
//		.setInTheWindpool("true")
//		.setWindpoolZone("Windpool Zone 1")
//		.setDistanceToCoast("2000")
//		.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setOwnedByOther("false")
//		.setOccupiedDaily("false")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setDwellingOccupancy("Owner Occupied")
//		.setSwimmingPool("true")
//		.setPoolLocation("In-Ground")
//		.setPoolFenced("true")
//		.setFenceType("Screen Enclosure")
//		.setDivingBoard("true")
//		.setPoolSlide("true")
//		.setTrampolineOnPremises("true")
//		.setSkateboardBicycleRampOnPremises("true")
//		.setAnimalsOrExoticPets("false")
//		.setGolfCarts("true")
//		.setRecreationalVehiclesOwned("true")
//		.setHousekeepingCondition("Good")
//
//
//
//
//		// Protection Details
//		.clickProtectionDetails()
//		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
//		.setBurglarAlarm("true")
//		.setLockedPrivacyFence("true")
//		.setBurglarBarsOnWindows("true")
//		.setCommunityGuarded("true")
//		.setGatedCommunity("true")
//		.setFireAlarm("true")
//		.setSmokeAlarm("true")
//		.setFireExtinguishers("true")
//		.setSprinklerSystem("true")
//		.setDeadbolts("true")
//		.setResidenceVisibleToNeighbors("true")
//		.safetyLatchesPresent("true")
//		.setFireAlarmType("Central Station")
//		.setSprinklerSystemType("Full")
//		.setBurglarAlarmType("Central Station")
//
//		// Additional Interests
//		.clickAdditionalInterests()
//		.clickAddNewPerson()
//		.setType("Additional Insured")
//		.setLoanNumber("747384")
//		.clickCertificateRequired("true")
//		.setFirstName("Jelly")
//		.setLastName("Junior")
//		.setDateOfBirth("10/20/1986")
//		.setMaritalStatus("Married")
//		.setPrimaryPhone("Home")
//		.setHomePhone("456-987-6542")
//		.setWorkPhone("453-985-6325")
//		.setMobilePhone("323-254-8457")
//		.setFaxPhone("356-984-5478")
//		.setPrimaryEmail("jelly@jellymail.com")
//		.setSecondaryEmail("jiggla@jigglamail.com")
//		.setCountry("United States")
//		.setAddress1("2470 Wild Wood dr")
//		.setCity("Melbourne")
//		.setState("Florida")
//		.setZipCode("32935")
//		.clickVerifyAddress()
//		.selectAddressForNewAdditionalInterests(2)
//		.setAddressType("Billing")
//		.setAddressDescription("Hideout")
//		.setLicenseNumber("156468465")
//		.setLicenseState("Florida")
//		.setSsn("598-99-6565")
//		.clickOk()
//		.next()
//
//		// Dwelling Construction
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setIsThereASecondaryHeatingSystem("true")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setRoofYear("2000")
//		.setConditionOfRoof("Good")
//		.setScreenEnclosureOnPremises("true")
//
//
//
//		.setPlumbingSystemHaveKnownLeaks("false")
//		.setBuildingRetrofittedForEarthquakes("false")
//		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
//		.setUncorrectedFireOrBuildingCodeViolations("false")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
//		.setLeadPaintHazard("false")
////		.setLeadPaintHazardDescription("best")
////		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
////		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")
//
//
//		// Wind Mitigation
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
////		.setTerrain("C")
////		.setRoofCover("FBC Equivalent")
////		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
////		.setRoofWallConnection("Clips")
//		.setSecondaryWaterResistance("true")
//		.setIsTheRoofCoverConstructionBuildingCodeCompliant("true")
//		.setIsTheRoofDeckAttachmentBuildingCodeCompliant("true")
//		.setIsTheRoofWallconnectionBuildingCodeCompliant("true")
//		.next()
//
//		// Coverages
//		.setDwellingLimit("300000")
//		.setOtherStructuresPercentage("5%")
//		//.setPersonalPropertyExcluded("false")
//		.setPersonalPropertyLimit("120000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value")
//		.setLossOfUseSelection("10,000")
//		//.setWindExcluded("false")
//		.setAllOtherPerils("5,000")
//		.setHurricane("5%")
//		.setPersonalLiabilityLimit("100,000")
//		//.setMedicalPaymentsLimit("5,000")
//		.clickPropertyEndorsements()
//
//
//
//
//
//		// Property Endorsements
//		.checkGuardianEndorsements()
//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.clickAddOtherStructures()
//		.setOtherStructuresDescription(1,"Arsalans' Skill")
//		.setOtherStructuresLimit(1,"9001")
//		.checkScheduledPersonalProperty()
//		.clickAddScheduledPersonalProperty()
//		.setPersonalPropertyArticleType(1,"Jewelry")
//		.setPersonalPropertyDescription(1,"schweggggg")
//		.setPersonalPropertyValue(1,"234342")
//		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
//		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")
//		//.checkPermittedIncidentalOccupancy()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkEarthquakeCoverage()
//		.checkEarthquakeLossAssessment()
//		//.checkSinkholeLossCoverage()
//
//		.setWhenSafeCreditPercentage("20%")
//		.setOccurrenceAggregateLimit("10,000 / 50,000")
//		.setLossAssessmentLimit("3000")
//		.setOrdinanceOrLawLimit("25%")
//		.setEarthquakeCoverageDeductiblePercentage("10%")
//		.setDoesExteriorMasonryVeneerExclusionApply("true")
//		.setEarthquakeLossAssessmentLimit("5,000")
//		.setPercentageOfAnnualIncrease("12%")
//		//.setSinkholeClaimsIndex("4500")
//		//.setSinkholeIndex("330")
//		.clickLiabilityEndorsements()
//
//		// Liability Endorsements
//		.checkPermittedIncidentalOccupancyLiability()
//		.checkAnimalLiability()
//		.checkAdditionalResidenceRentedToOthers()
//		.checkBusinessPursuits()
//		.checkWatercraftLiability()
//
//		.setLocationName("1:")
//		.setNumberOfFamilies("2 Family Residence")
//		.setBusinessActivity("Clerical Employee")
//		.setWatercraftType("Up to 50 Horsepower and 16-26 feet")
//
//
//
////		.checkOtherStructuresIncreasedCoverageRentedToOthers()
////		.checkScheduledPersonalProperty()
////		.checkScreenEnclosureHurricaneCoverage()
////		.checkSinkholeLossCoverage()
//		.next()
//		.quote();
//		//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//	public void NCHO3RenewalPOC()
//	{
//		int i= 0;
//		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Jacksonville")
//			.setState("North Carolina")
//			.setZipCode("28546")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("104 Baymeade Ct")
//			.setCity("Jacksonville")
//			.setState("North Carolina")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("North Carolina")
//
//			.setZipCode("28546")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("BB&T");
////			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//
//		// Initiate Manual Renewal
//		imr.setOrganization("BB&T")
////		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("North Carolina")
//		.setProduct("Homeowners")
//		.setPolicyType("Homeowners")
//		.setLegacyPolicyNumber(policyNumHO3)
//		.setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017")
//		.setLastInspectionCompletionDate("03/21/2015");
////		.setInflationGuard("12%")
////		.clickExcludeLossOfUseCoverage("false");
//		Offerings offerings = imr.nextAndAccept()
//
//		// Offerings
//		.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//
//		// Policy Info
//		pi.setOccupation("Twinkie Smuggler")
//		.setDoesInsuredOwnOtherResidenceWithFrontline("false")
//		.setTermType("Annual");
//		SearchAddressBook sab = pi
//		//.setPolicyWriter()
//		//.clickAddNewPerson()
//		.clickAddFromAddressBook();
//
//
//		// Search Address Book
//		sab
//		.setType("Person")
//		.setFirstName("fsadfasd")
//		.setLastName("fadsfasdfasdf")
//		.setCountry("United States")
//		.setCity("Melbourne")
//		.setState("Florida")
//		.setZipCode("32935")
//		.clickSearch();
//		if(sab.areThereSearchResults())
//			sab.selectFirstSearchResultPolicyInfo();
//		else
//		{
//			sab.clickReturnToPolicyInfo()
//			.clickAddNewPerson()
//			.setRelationshipToPrimary("Sugah Mama")
//
//			.setFirstName("Jelly")
//			.setLastName("Junior")
//			.setDateOfBirth("10/20/1986")
//			.setMaritalStatus("Married")
//			.setPrimaryPhone("Home")
//			.setHomePhone("456-987-6542")
//			.setWorkPhone("453-985-6325")
//			.setMobilePhone("323-254-8457")
//			.setFaxPhone("356-984-5478")
//			.setPrimaryEmail("jelly@jellymail.com")
//			.setSecondaryEmail("jiggla@jigglamail.com")
//			.setCountry("United States")
//			.setAddress1("104 Baymeade Ct")
//			.setCity("Jacksonville")
//			.setState("North Carolina")
//			.setZipCode("28546")
//			.clickVerifyAddress()
//			.selectAddressForNewAdditionalNamedInsured(2)
//			.setAddressType("Billing")
//			.setAddressDescription("Hideout")
//			.setLicenseNumber("156468465")
//			.setLicenseState("North Carolina")
//			.setSsn("598-99-6565")
//			.clickOk();
//
//		}
//
//
//
//		// New Additional Named Insured
//		Dwelling dwelling = pi.next();
//
//		// Dwelling
//		dwelling
//		.setLocationName("1:")
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setDistanceToFireStation("2100")
//		.setTerritoryCode("160")
////		.setBCEG("02")
//		.setProtectionClassCode("2")
//		.setLocationType("In City Limits")
////		.setInTheWindpool("true")
//		.setDistanceToCoast("2000")
//		.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setOwnedByOther("false")
//		.setOccupiedDaily("false")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setDwellingOccupancy("Owner Occupied")
//		.setSwimmingPool("true")
//		.setPoolLocation("In-Ground")
//		.setPoolFenced("true")
//		.setFenceType("Screen Enclosure")
//		.setDivingBoard("true")
//		.setPoolSlide("true")
//		.setTrampolineOnPremises("true")
//		.setSkateboardBicycleRampOnPremises("true")
//		.setAnimalsOrExoticPets("false")
//		.setGolfCarts("true")
//		.setRecreationalVehiclesOwned("true")
//		.setHousekeepingCondition("Excellent");
//
//
//
//		// Protection Details
//		Dwelling.ProtectionDetails pd = dwelling.clickProtectionDetails();
//		//sh.clickElement(By.xpath(".//*[text()= 'OK']"));
//		pd
//		.setBurglarAlarm("true")
//		.setLockedPrivacyFence("true")
//		.setBurglarBarsOnWindows("true")
//		.setCommunityGuarded("true")
//		.setGatedCommunity("true")
//		.setFireAlarm("true")
//		.setSmokeAlarm("true")
//		.setFireExtinguishers("true")
//		.setSprinklerSystem("true")
//		.setDeadbolts("true")
//		.setResidenceVisibleToNeighbors("true")
//		.safetyLatchesPresent("true")
//		.setFireAlarmType("Central Station")
//		.setSprinklerSystemType("Full")
//		.setBurglarAlarmType("Central Station")
//
//		// Additional Interests
//		.clickAdditionalInterests()
//		.clickAddNewPerson()
//		.setType("Additional Insured")
//		.setLoanNumber("747384")
//		.clickCertificateRequired("true")
//		.setFirstName("Jelly")
//		.setLastName("Junior")
//		.setDateOfBirth("10/20/1986")
//		.setMaritalStatus("Married")
//		.setPrimaryPhone("Home")
//		.setHomePhone("456-987-6542")
//		.setWorkPhone("453-985-6325")
//		.setMobilePhone("323-254-8457")
//		.setFaxPhone("356-984-5478")
//		.setPrimaryEmail("jelly@jellymail.com")
//		.setSecondaryEmail("jiggla@jigglamail.com")
//
//		.clickSameAddressAsPrimaryNamedInsured()
////		.setCountry("United States")
////		.setAddress1("2470 Wild Wood dr")
////		.setCity("Melbourne")
////		.setState("Florida")
////		.setZipCode("32935")
////		.clickVerifyAddress()
////		.selectAddressForNewAdditionalInterests(2)
////		.setAddressType("Billing")
////		.setAddressDescription("Hideout")
////		.setLicenseNumber("156468465")
////		.setLicenseState("Florida")
////		.setSsn("598-99-6565")
//		.clickOk()
//		.setType(1,"Trust")
//		.setEffectiveDate(1,"10/29/2017")
//		.next()
//
//		// Dwelling Construction
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setIsThereASecondaryHeatingSystem("true")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setRoofYear("2000")
//		.setConditionOfRoof("Good")
//		.setScreenEnclosureOnPremises("true")
//
//
//
//		.setPlumbingSystemHaveKnownLeaks("false")
//		.setBuildingRetrofittedForEarthquakes("false")
//		//.setBuildingRetrofittedForEarthquakesDescription("JellyJiggla")
//		.setUncorrectedFireOrBuildingCodeViolations("false")
//		.setStructureOriginallyBuiltForOtherThanPrivateResidence("false")
//		.setLeadPaintHazard("false")
////		.setLeadPaintHazardDescription("best")
////		.setUncorrectedFireOrBuildingCodeViolationsDescription("is")
////		.setStructureOriginallyBuiltForOtherThanPrivateResidenceDescription("the")
//
//
//		// Wind Mitigation
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
////		.setTerrain("C")
////		.setRoofCover("FBC Equivalent")
////		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
////		.setRoofWallConnection("Clips")
////		.setSecondaryWaterResistance("true")
//		.next()
//
//		// Coverages
//		.setDwellingLimit("300000")
////		.setOtherStructuresPercentage("5%")
////		.setPersonalPropertyExcluded("false")
//		.setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value")
////		.setLossOfUseSelection("5%")
////		.setWindExcluded("false")
//		.setAllOtherPerils("5,000")
////		.setHurricane("2%")
//		.setPersonalLiabilityLimit("500,000")
////		.setMedicalPaymentsLimit("5,000")
//
//
//
//
//
//		// Property Endorsements
//		.clickPropertyEndorsements()
////		.checkGuardianEndorsements()
//		.checkOtherStructuresIncreasedCoverageRentedToOthers()
//		.clickAddOtherStructures()
//		.setOtherStructuresDescription(1,"Arsalans' Skill")
//		.setOtherStructuresLimit(1,"9001")
//		.checkScheduledPersonalProperty()
//		.clickAddScheduledPersonalProperty()
//		.setPersonalPropertyArticleType(1,"Jewelry")
//		.setPersonalPropertyDescription(1,"schweggggg")
//		.setPersonalPropertyValue(1,"234342")
//		//.checkCreditCardFundTransferForgeryCounterfeitMoney()
//		//.checkPermittedIncidentalOccupancy()
//		.checkScreenEnclosureHurricaneCoverage()
//		.checkSinkholeLossCoverage()
//		//.setCreditCardFundTransferForgeryCounterfeitMoneyLimit("2,500")
//
//		.setWhenSafeCreditPercentage("20%")
//		.setOccurrenceAggregateLimit("10,000 / 50,000")
//		.setLossAssessmentLimit("3000")
//		.setOrdinanceOrLawLimit("25%")
//		.setPercentageOfAnnualIncrease("12%")
//		.setSinkholeClaimsIndex("4500")
//		.setSinkholeIndex("330")
//
//		// Liability Endorsements
//		.clickLiabilityEndorsements()
//		.checkPermittedIncidentalOccupancyLiability()
//		//.checkAnimalLiability()
//		.checkAdditionalResidenceRentedToOthers()
//		.checkBusinessPursuits()
//		.checkWatercraftLiability()
//
//		.setLocationName("1:")
//		.setNumberOfFamilies("2 Family Residence")
//		.setBusinessActivity("Clerical Employee")
//		.setWatercraftType("Up to 50 Horsepower and 16-26 feet")
//
//
//
////		.checkOtherStructuresIncreasedCoverageRentedToOthers()
////		.checkScheduledPersonalProperty()
////		.checkScreenEnclosureHurricaneCoverage()
////		.checkSinkholeLossCoverage()
//		.next()
//		.quote();
//		//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//	}
//	public void ALH03AccountRenewalPOC()
//	{
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Saraland")
//			.setState("Alabama")
//			.setZipCode("36571")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("5 Laredo Drive")
//			.setCity("Saraland")
//			.setState("Alabama")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Alabama")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("Alabama").setProduct("Homeowners").setPolicyType("Homeowners")
//		.setLegacyPolicyNumber(policyNumHO3).setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%")
//		.clickExcludeLossOfUseCoverage("true");
//		Offerings offerings = imr.nextAndAccept();
//		offerings.setPolicyType("Homeowners").setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//		pi.setOccupation("Twinkie Smuggler");
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
//		.setMarketValue("6000000").setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")//.setTerritoryCode("064")
//		//.setBCEG("02")
//		.setProtectionClassCode("2");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
//		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
//		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
//		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane");//.setTerrain("C")
//		//.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
//		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
//		.next().quote();//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//	public void FLDP3AccountRenewalPOC()
//	{
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Florida")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("Florida").setProduct("Homeowners").setPolicyType("Dwelling Fire")
//		.setLegacyPolicyNumber(policyNumDP3).setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage("true")
//		.setTheftCoverage("Limited");
//		Offerings offerings = imr.nextAndAccept();
//		offerings.setPolicyType("Dwelling Fire").setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//		pi.setOccupation("Twinkie Smuggler");
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
//		.setMarketValue("6000000").setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000").setDistanceToFireStation("2000").setTerritoryCode("064").setBCEG("02").setProtectionClassCode("2")
//		.setAtInceptionOfPolicyIsDeedOwnedByEntity("false");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
//		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
//		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
//		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane").setTerrain("C")
//		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
//		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
//		.next().quote();//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//	public void SCDP3AccountRenewalPOC()
//	{
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Charleston")
//			.setState("South Carolina")
//			.setZipCode("29401")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("32 Legare St")
//			.setCity("Charleston")
//			.setState("South Carolina")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("South Carolina")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//		imr.setOrganization("Brown and Brown of Florida, Inc").setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("South Carolina").setProduct("Homeowners").setPolicyType("Homeowners")
//		.setLegacyPolicyNumber(policyNumDP3).setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017").setLastInspectionCompletionDate("03/21/2015")//.setInflationGuard("12%").clickExcludeLossOfUseCoverage("true");
//		.setTheftCoverage("Limited");
//		Offerings offerings = imr.nextAndAccept();
//		offerings.setPolicyType("Dwelling Fire").setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//		pi.setOccupation("Twinkie Smuggler");
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000").setPurchasePrice("500000")
//		.setMarketValue("6000000").setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal").setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000").setDistanceToFireStation("2000").setTerritoryCode("064").setBCEG("02").setProtectionClassCode("2")
//		.setAtInceptionOfPolicyIsDeedOwnedByEntity("false");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000").setValuationType("Appraisal").setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior").setNumberOfUnits("11-50").setUnitsInFireWall("2").setNumberOfStories("2")
//		.setSquareFootage("3500").setFoundationType("Open").setPrimaryHeating("Gas").setPlumbing("Copper")
//		.setPlumbingYear("2003").setWaterHeaterYear("2004").setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker").setRoofType("Metal").setConditionOfRoof("Good")
//		.clickWindMitigation().setRoofShapeType("Hip").setOpeningProtectionType("Hurricane").setTerrain("C")
//		.setRoofCover("FBC Equivalent").setRoofDeckAttachment("B(8d @ 6\"/12\") Nails").setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000").setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value").setLossOfUseSelection("5%").setAllOtherPerils("5,000")
//		.setPersonalLiabilityLimit("500,000").setMedicalPaymentsLimit("5,000")
//		.next().quote();//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//	public void FFH3AccountRenewalPOC()
//	{
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Florida")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//		imr.setOrganization("Brown and Brown of Florida, Inc")
//		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("Florida").setProduct("Homeowners")
//		.setPolicyType("Homeowners")
//		.setLegacyPolicyNumber("FFH3-324237913")
//		.setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017")
//		.setLastInspectionCompletionDate("03/21/2015")
//		.setInflationGuard("12%")
//		.clickExcludeLossOfUseCoverage("true");
//		Offerings offerings = imr.nextAndAccept();
//		offerings.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//		pi.setOccupation("Twinkie Smuggler");
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setTerritoryCode("064")
//		.setBCEG("02")
//		.setProtectionClassCode("2");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000")
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setConditionOfRoof("Good")
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
//		.setTerrain("C")
//		.setRoofCover("FBC Equivalent")
//		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
//		.setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000")
//		.setPersonalPropertyLimit("150000")
//		.next()
//		.quote();//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//	public void FFH4AccountRenewalPOC()
//	{
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Florida")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//		// Policy Renewal
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		InitiateManualRenewal imr = accountFileSummary.westPanel.actions.convertManualPolicy();
//		imr.setOrganization("Brown and Brown of Florida, Inc")
//		.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division")
//		.setBaseState("Florida")
//		.setProduct("Homeowners")
//		.setPolicyType("Homeowners")
//		.setLegacyPolicyNumber("FFH3-324237913")
//		.setOriginalEffectiveDate("11/21/2016")
//		.setEffectiveDate("10/29/2017")
//		.setLastInspectionCompletionDate("03/21/2015")
//		.setInflationGuard("12%")
//		.clickExcludeLossOfUseCoverage("true");
//		Offerings offerings = imr.nextAndAccept();
//		offerings.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular");
//		PolicyInfo pi = offerings.next();
//		pi.setOccupation("Twinkie Smuggler");
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setTerritoryCode("064")
//		.setBCEG("02")
//		.setProtectionClassCode("2");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000")
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setConditionOfRoof("Good")
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
//		.setTerrain("C")
//		.setRoofCover("FBC Equivalent")
//		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
//		.setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000")
//		.setPersonalPropertyLimit("150000")
//		.next()
//		.quote();//.back().requestApproval().sendRequest();
//		//sh.waitForElementToAppear(By.id("RenewalWizard:PostQuoteWizardStepSet:RenewalWizard_QuoteScreen:ttlBar"));
//
//
//
//	}
//
//
//
//
//	public void FLHO3AccountPolicyCreatorPOC()
//	{
//
//		// Create Account
//
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		Actions build = new Actions(driver);
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
//		EnterAccountInformation enterAccountInfo = new EnterAccountInformation(sh);
//		System.out.println(new DateTime().toString());
//
//		log("Test new person account creation");
//		String firstName = "First" + dateString, lastName = "Last" + dateString;
//
//		enterAccountInfo
//			.setFirstName(firstName)
//			.setCompanyName("Jelly")
//			.setCountry("United States")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setZipCode("32935")
//			.setLastName(lastName)
//			.clickSearch();
//		CreateAccount createAccount = enterAccountInfo.CreatePersonAccount();
//
//		log("Creating new account: " + dateString);
//		createAccount
//			.setAddressLine1("2470 Wild Wood Dr")
//			.setCity("Melbourne")
//			.setState("Florida")
//			.setDateOfBirth("03/15/1987")
//			.setHomePhone("456-748-1503")
//			.setWorkPhone("958-562-1250")
//			.setMobilePhone("745-512-6590")
//			.setFaxPhone("487-963-8521")
//			.setPrimaryPhone("Work")
//			.setPrimaryEmail("djfklajs@gmail.com")
//			.setSecondaryEmail("jdklafj@hotmail.com")
//			.setState("Florida")
//
//			.setZipCode("32935")
//				.clickVerifyAddress()
//				.selectAddressForCreateAccount(2)
//			.setAddressType("Home")
//			.setDescription("Nerd Lair")
//			.setSsn("555-44-3333")
//			.setOrganization("Brown and Brown of Florida, Inc")
//			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
//			AccountFileSummary accountFileSummary = createAccount.clickUpdate();
//            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
//			", first name: " + firstName + ", last name: " + lastName);
//
//
//
//		// Create policy
//
//		log("Test simple homeowners policy submission");
//		String accountNumber = accountFileSummary.getAccountNumber();
//		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
//		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
//		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
//		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
//		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
//
//		accountFileSummary = new AccountFileSummary(sh);
//		NewSubmission submission = accountFileSummary.westPanel.actions.newSubmission();
//
//		log("Answering qualification questions");
//		Qualification qualification = submission.productTable.selectHomeowners();
//		String policyType = "Homeowners";
//		log("Policy Type: " + policyType);
//		qualification.setPolicyType("Homeowners")
//		.setOfferingSelection("Most Popular");
//
//		System.out.println(qualification.questionnaire.getQuestionText(1));
//		for(int i = 1; i<9; i++)
//			qualification.questionnaire.answerNo(i);
//		PolicyInfo pi = qualification.next();
//		pi.setOccupation("Twinkie Smuggler")
//		.setDoesInsuredOwnOtherResidenceWithFrontline("true")
//		.setTermType("Annual");
//		//.setEffectiveDate("11/14/2016").setOrganization().setProducerCode().setPolicyWriter().setUnderwritingCompanies();
//
//		Dwelling dwelling = pi.next();
//		dwelling.setPurchaseDate("01/25/2000")
//		.setPurchasePrice("500000")
//		.setMarketValue("6000000")
//		.setResidenceType("Duplex")
//		.setDwellingUsage("Seasonal")
//		.setHousekeepingCondition("Good");
//
//		log("Specifying dwelling details");
//		dwelling
//		.setYearBuilt("2000")
//		.setDistanceToFireHydrant("2000")
//		.setTerritoryCode("064")
//		.setBCEG("02")
//		.setProtectionClassCode("2")
//		.clickProtectionDetails()
//		.setBurglarAlarm("true")
//		.setLockedPrivacyFence("true")
//		.setBurglarBarsOnWindows("true")
//		.setCommunityGuarded("true")
//		.setGatedCommunity("true")
//		.setFireAlarm("true")
//		.setSmokeAlarm("true")
//		.setFireExtinguishers("true")
//		.setSprinklerSystem("true")
//		.setDeadbolts("true")
//		.setResidenceVisibleToNeighbors("true")
//		.safetyLatchesPresent("true")
//		.setFireAlarmType("Central Station")
//		.setSprinklerSystemType("Full")
//		.setBurglarAlarmType("Central Station");
//
//		DwellingConstruction dc = dwelling.next();
//
//		dc.setRoofYear("2000")
//		.setValuationType("Appraisal")
//		.setEstimatedReplacementCost("100000")
//		.setConstructionType("Superior")
//		.setNumberOfUnits("11-50")
//		.setUnitsInFireWall("2")
//		.setNumberOfStories("2")
//		.setSquareFootage("3500")
//		.setFoundationType("Open")
//		.setPrimaryHeating("Gas")
//		.setPlumbing("Copper")
//		.setPlumbingYear("2003")
//		.setWaterHeaterYear("2004")
//		.setWiring("Multi-Strand Aluminum")
//		.setElectricalSystem("Circuit Breaker")
//		.setRoofType("Metal")
//		.setConditionOfRoof("Good")
//		.clickWindMitigation()
//		.setRoofShapeType("Hip")
//		.setOpeningProtectionType("Hurricane")
//		.setTerrain("C")
//		.setRoofCover("FBC Equivalent")
//		.setRoofDeckAttachment("B(8d @ 6\"/12\") Nails")
//		.setRoofWallConnection("Clips");
//		Coverages co = dc.next();
//		co.setDwellingLimit("300000")
//		.setPersonalPropertyLimit("150000")
//		.setPersonalPropertyValuationMethod("Actual Cash Value")
//		.setLossOfUseSelection("5%")
//		.setAllOtherPerils("5,000")
//		.setPersonalLiabilityLimit("500,000")
//		.setMedicalPaymentsLimit("5,000")
//		.next()
//		.quote();
//		sh.waitForElementToAppear(By.id("SubmissionWizard:SubmissionWizard_QuoteScreen:ttlBar"));
//
//
//
//		log("Specifying dwelling protection details");
//		System.out.println("waiting");
//	}
}