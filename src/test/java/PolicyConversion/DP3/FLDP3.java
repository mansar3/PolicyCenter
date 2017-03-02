package PolicyConversion.DP3;

import DataProviders.AccountPolicyGenerator;
import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import com.opencsv.CSVWriter;
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
import pageobjects.FLDP3.*;
import pageobjects.Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by aansari on 2/23/17.
 */
public class FLDP3 extends BaseTest
{
	private String dateString;
	private String errorOutput;

	private String 	policyNumHO3 = "FPH3-324233601",
					policyNumDP3 = "FPD3-324237824";
	String 	//filePathBase = "\\\\FLHIFS1\\General\\ConversionData\\Error Report\\",
			filePathBase = "/Users/aansari/Desktop/",
			timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
	String filePath= filePathBase + "TestResult" + timeStamp + ".csv";

	@BeforeMethod
	public void beforeMethod()
	{
		DateTime date = new DateTime();
		dateString = date.toString("MMddhhmmss");

		System.out.println(new DateTime().toString());
		// users: conversion2,mcoad
		String user = userName, pwd = "";
		WebDriver driver = setupDriver(sessionInfo.gridHub, sessionInfo.capabilities);
		Login login = new Login(new CenterSeleniumHelper(driver), sessionInfo);
		login.load();
		login.isLoaded();
		login.login(user, pwd);
		log("Logged in as: " + user + "\nPassword: " + pwd);
	}
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult testResult, Object[] parameters)
	{
		LinkedHashMap<String, String> eai = (LinkedHashMap<String,String>) parameters[0];
		String[] headers = {"Result", "Account Number", "Legacy Policy Number", "Effective Date", "Premium Variation", "Year Built", "Construction Type", "Dwelling Limit",
					"Territory Code", "AOP Deductible", "WhenSafe Percentage", "Last Page Visited","Total Annualized Premium", "ScreenShot","Submitted for Approval", "GW Warnings"};
		WebDriver driver = LocalDriverManager.getDriver();
		if(testResult.getStatus() != ITestResult.SUCCESS)
		{


			String screenshotName = takeScreenShot(driver);
			String[] csvInput =  errorReportingInfo(eai,false).clone();
			csvInput[13] = screenshotName;

			CSVWriter writer;
			try
			{
				if(!new File(filePath).exists())
				{
					writer = new CSVWriter(new FileWriter(filePath));
					writer.writeNext(headers);
				}

				else
					writer = new CSVWriter(new FileWriter(filePath,true));
			}
			catch(IOException e)
			{
				writer = null;
				e.printStackTrace();
			}
			writer.writeNext(csvInput);
			try
			{
				writer.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			System.out.println("\n'" + testResult.getMethod().getMethodName() + "' Failed.\n");
		}
		else if(testResult.getStatus() == ITestResult.SUCCESS)
		{
			String[] csvInput =  errorReportingInfo(eai,true).clone();

			CSVWriter writer;
			try
			{
				if(!new File(filePath).exists())
				{
					writer = new CSVWriter(new FileWriter(filePath));
					writer.writeNext(headers);
				}

				else
					writer = new CSVWriter(new FileWriter(filePath,true));
			}
			catch(IOException e)
			{
				writer = null;
				e.printStackTrace();
			}
			writer.writeNext(csvInput);
			try
			{

				writer.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}

		if(driver != null)
			driver.quit();
	}
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "FLDP3Data")
	public void RenewalLoadTest2(LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		//***********************************************//*
		//*      Remove hardcoded org and prod code 	   *//*
		//***********************************************//*

		int i;


		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		FLDP3EnterAccountInformation enterAccountInfo = new FLDP3EnterAccountInformation(sh);


		log("Test new person account creation");

		//String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

		enterAccountInfo.setFirstName(firstName).setCountry("United States").setCity(eai.get("Mailing City")).setState(eai.get("Mailing State")).setZipCode(eai.get("Mailing Zip Code")).setLastName(lastName).clickSearch();
		FLDP3CreateAccount createAccount = enterAccountInfo.createPersonAccount();

		log("Creating new account: " + dateString);

		createAccount.setAddressLine1(eai.get("Mailing Address")).setCity(eai.get("Mailing City")).setState(eai.get("Mailing State")).setCounty(eai.getOrDefault("Mailing County", null)).setDateOfBirth(eai.get("Date of Birth")).setHomePhone(eai.get("Home Phone")).setWorkPhone(eai.getOrDefault("Work Phone", null)).setPrimaryEmail(eai.getOrDefault("Email Address", null)).setState(eai.getOrDefault("Mailing State", null)).setZipCode(eai.getOrDefault("Mailing Zip Code", null)).clickVerifyAddress().selectSuccessfulVerificationIfPossibleForCreateAccount().setAddressType(eai.getOrDefault("Address Type", "Home"))
		//.setDescription("Nerd Lair")
		.setSsn(eai.getOrDefault("SSN", null)).setOrganization("4 CORNERS INSURANCE").setProducerCode("8329736");

		FLDP3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
		log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() + ", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
		log("Test simple homeowners policy renewal");
		eai.put("Account Number", accountFileSummary.getAccountNumber());
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new FLDP3AccountFileSummary(sh);
		accountFileSummary.westPanel.actions.convertManualPolicy();
		FLDP3InitiateManualRenewal imr = new FLDP3InitiateManualRenewal(sh);
		// Initiate Manual Renewal
		imr//.setOrganization(eai.getOrDefault("Organization", null))
		//.setProducerCode(eai.getOrDefault("Producer Code", null))
		.setBaseState(eai.getOrDefault("Base State", null))
		.setProduct(eai.getOrDefault("Product", null))
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setLegacyPolicyNumber(eai.getOrDefault("Legacy Policy Number", null))
		.setOriginalEffectiveDate(eai.getOrDefault("Policy Original Effective Date",null))
		.setEffectiveDate(eai.getOrDefault("Effective Date",null))
		.setLastInspectionCompletionDate(eai.getOrDefault("Last Inspection Completion Date", null))
		.setTheftCoverage(eai.getOrDefault("Theft Coverage", null));
		FLDP3Offerings offerings = imr.nextAndAccept();

		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		FLDP3PolicyInfo pi = offerings.next();
		// Policy Info
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			FLDP3SearchAddressBook sab = pi.searchFromAddressBook();
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
			if(sab.areThereSearchResults() && !sab.areThereMoreThanOneSearchResult())
				sab.selectFirstSearchResultPolicyInfo();

			// No results, add person/company
			else
			{
				pi = sab.clickReturnToPolicyInfo();
				// Add a person
				if(person)
				{
					FLDP3NewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					FLDP3NewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		FLDP3Dwelling dwelling = pi.next();

		// Dwelling

		if(dwelling.getLocationName().equals("1: FL") || !eai.getOrDefault("Mailing Address","").equals(eai.get("Location Address")))
			dwelling = dwelling.addNewLocation()
			.setAddress1(eai.get("Location Address"))
			.setAddress2(eai.getOrDefault("Location Address - Unit", null))
			.setCity(eai.get("Location Address - City"))
			.setZipCode(eai.get("Location Address - Zip"))
			.setCounty(eai.get("Location Address - County"))
			.clickVerifyAddress()
			.selectSuccessfulVerificationIfPossibleForLocationInformation()
			.clickOk();
		// Left as is

		dwelling
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
		FLDP3Dwelling.FLDP3ProtectionDetails pd = dwelling.clickProtectionDetails();



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

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none") && !eai.get("Sprinkler System").toLowerCase().equals("false"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		FLDP3Dwelling.FLDP3AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			FLDP3SearchAddressBook sab = ai.clickFromAddressBook();
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
			if(sab.areThereSearchResults() && !sab.areThereMoreThanOneSearchResult())
			{
				ai = sab.selectFirstSearchResultAdditionalInterests();
				ai
				.setType(i+1,addInts.get(i).get("Type"))
				.setLoanNumber(i+1,addInts.get(i).getOrDefault("Loan Number", null));


			}
			else
			{

				ai = sab.clickReturnToDwelling();
				FLDP3NewAdditionalInterest nai =  ai.clickAddNewPerson();
				nai
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null))
				.setFirstName(fName)
				.setLastName(lName);
				if(addInts.get(i).get("Address") != null)
				{
					nai

					.setAddress1(addInts.get(i).get("Address"))
					.setCity(addInts.get(i).get("City"))
					.setState(addInts.get(i).get("State"))
					.setZipCode(addInts.get(i).get("Zip Code"))
					.clickVerifyAddress()
					.selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
					.setAddressType("Home");
				}
				else
					nai.clickSameAddressAsPrimaryNamedInsured();

				nai.clickOk();




			}


		}

		FLDP3DwellingConstruction dc = ai.next();

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
		.setPlumbing(eai.getOrDefault("Plumbing Type",null));
		if(eai.getOrDefault("Plumbing Type","none").toLowerCase().equals("other"))
			dc.setPlumbingDescribeOther("Other");
		dc
		.setPlumbingYear(eai.getOrDefault("Plumbing Year",null))
		.setWaterHeaterYear(eai.getOrDefault("Water Heater Year",null))
		.setWiring(eai.getOrDefault("Wiring", "Copper"))
		.setElectricalSystem(eai.getOrDefault("Electrical System","None"))
		.setRoofType(eai.get("Roof Type"));
		if(eai.get("Roof Type").toLowerCase().equals("other"))
			dc.setRoofTypeDescription("Other");
		dc
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
		FLDP3DwellingConstruction.FLDP3WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		FLDP3Coverages co;

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
			wm.setRoofCover(eai.getOrDefault("Roof Cover","<none>"));
			if(eai.get("Roof Deck Attachment") != null)
				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment") + "(");
			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"));
		//.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		 if(eai.get("Other Structures - Increased Limit") != null)
		 {
			 if(!co.isOtherStructuresIncreasedCoverageChecked())
				 co.clickOtherStructuresIncreasedCoverage()
				 .setOtherStructuresIncreasedCoverageLimit(eai.get("Other Structures - Increased Limit"));
			 else
			 	co.setOtherStructuresIncreasedCoverageLimit(eai.get("Other Structures - Increased Limit"));
		 }

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));
		co
//		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles - AOP"));

		if(eai.get("Wind Excluded").toLowerCase().equals("false") && eai.get("Wind Excluded") != null)
			co
			.setHurricane(eai.get("Section I Deductibles - Hurricane"));

		if(eai.get("How is the dwelling occupied").toLowerCase().equals("tenant occupied"))
		{
			if(eai.get("Premises Liability") != null)
				co.setPremisesLiabilityLimit(eai.get("Premises Liability"));
			else
				co.checkPremisesLiability();
		}
		else
		{
			if(eai.get("Personal Liability") != null)
				co.setPersonalLiabilityLimit(eai.get("Personal Liability"));
			else
				co.checkPersonalLiability();
		}
		//.setMedicalPaymentsLimit(eai.get("Medical Payments"));





		// Property Endorsements
		FLDP3Coverages.FLDP3PropertyEndorsements pe = co.clickPropertyEndorsements();


		if(eai.get("Whensafe - %") != null)
		{
			if(!pe.isWhenSafeChecked())
				pe.checkWhenSafe();

			pe.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));
		}
		else
		{
			if(pe.isWhenSafeChecked())
				pe.checkWhenSafe();
		}



		pe
		.setOccurrenceAggregateLimit(eai.get("Limited Fungi (Limit)"));


		if(eai.getOrDefault("Screen Enclosure Hurricane Coverage (Limit)",null) != null)
			pe
			.checkScreenEnclosureHurricaneCoverage()
			.setScreenEnclosureHurricaneCoverageLimit(eai.get("Screen Enclosure Hurricane Coverage (Limit)"));

		if(eai.get("Theft Coverage") == null)
			if(pe.isTheftCoverageChecked())
				pe.clickTheftCoverage();




//		if(eai.getOrDefault("Credit Card (Limit)", null) != null)
//			if(pe.isCreditCardCheckBoxAvailable())
//				pe
//				.checkCreditCardFundTransferForgeryCounterfeitMoney()
//				.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));

		if(eai.get("Water Back Up (Limit)") == null && pe.isWaterBackUpChecked())
				pe.checkWaterBackUp();



		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			pe
			.checkSinkholeLossCoverage()
			.setSinkholeClaimsIndex("4500")
			.setSinkholeIndex("330");

		// Liability Endorsements
		FLDP3RiskAnalysis ra = pe.next();
		FLDP3Quote quote;
		if(qualifiesForHurricaneProtection(eai))
			quote = ra.qualifiesForAdditionalProtectionQuote();
		else
			quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());

		if(eai.get("Consent to Rate") != null)
			quote
			.clickOverrideRating()
			.setTermAmount(eai.get("Consent to Rate"))
			.clickRerate();
	}
	
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "FLDP3Data")
	public void SubmissionLoadTest(LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		//***********************************************//*
		//*      Remove hardcoded org and prod code 	   *//*
		//***********************************************//*

		int i;



		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		FLDP3EnterAccountInformation enterAccountInfo = new FLDP3EnterAccountInformation(sh);


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
		FLDP3CreateAccount createAccount = enterAccountInfo.createPersonAccount();

		log("Creating new account: " + dateString);

		createAccount
			.setAddressLine1(eai.get("Mailing Address"))
			.setCity(eai.get("Mailing City"))
			.setState(eai.get("Mailing State"))
			.setCounty(eai.getOrDefault("Mailing County", null))
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
			.setOrganization("4 CORNERS INSURANCE")
			.setProducerCode("8329736");

			FLDP3AccountFileSummary accountFileSummary = createAccount.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
		log("Test simple homeowners policy renewal");
		String accountNumber = accountFileSummary.getAccountNumber();
		eai.put("Account Number", accountNumber);
		sh.wait(3).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));


		accountFileSummary.westPanel.actions.newSubmission();
		FLDP3NewSubmission submission = new FLDP3NewSubmission(sh);

		submission.setBaseState(eai.get("Base State"));
		FLDP3Qualification qualification = submission.productTable.selectHomeowners();

		qualification.setPolicyType(eai.get("Policy Type"));
		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		FLDP3PolicyInfo pi = qualification.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			FLDP3SearchAddressBook sab = pi.searchFromAddressBook();
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
			if(sab.areThereSearchResults() && !sab.areThereMoreThanOneSearchResult())
				sab.selectFirstSearchResultPolicyInfo();

			// No results, add person/company
			else
			{
				pi = sab.clickReturnToPolicyInfo();
				// Add a person
				if(person)
				{
					FLDP3NewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					FLDP3NewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		FLDP3Dwelling dwelling = pi.next();

		// Dwelling

		if(dwelling.getLocationName().equals("1: FL") || !eai.getOrDefault("Mailing Address","").equals(eai.get("Location Address")))
			dwelling = dwelling.addNewLocation()
			.setAddress1(eai.get("Location Address"))
			.setAddress2(eai.getOrDefault("Location Address - Unit", null))
			.setCity(eai.get("Location Address - City"))
			.setZipCode(eai.get("Location Address - Zip"))
			.setCounty(eai.get("Location Address - County"))
			.clickVerifyAddress()
			.selectSuccessfulVerificationIfPossibleForLocationInformation()
			.clickOk();
		// Left as is

		dwelling
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
		FLDP3Dwelling.FLDP3ProtectionDetails pd = dwelling.clickProtectionDetails();



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

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none") && !eai.get("Sprinkler System").toLowerCase().equals("false"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		FLDP3Dwelling.FLDP3AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			FLDP3SearchAddressBook sab = ai.clickFromAddressBook();
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
			if(sab.areThereSearchResults() && !sab.areThereMoreThanOneSearchResult())
			{
				ai = sab.selectFirstSearchResultAdditionalInterests();
				ai
				.setType(i+1,addInts.get(i).get("Type"))
				.setLoanNumber(i+1,addInts.get(i).getOrDefault("Loan Number", null));


			}
			else
			{

				ai = sab.clickReturnToDwelling();
				FLDP3NewAdditionalInterest nai =  ai.clickAddNewPerson();
				nai
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null))
				.setFirstName(fName)
				.setLastName(lName);
				if(addInts.get(i).get("Address") != null)
				{
					nai

					.setAddress1(addInts.get(i).get("Address"))
					.setCity(addInts.get(i).get("City"))
					.setState(addInts.get(i).get("State"))
					.setZipCode(addInts.get(i).get("Zip Code"))
					.clickVerifyAddress()
					.selectSuccessfulVerificationIfPossibleForNewAdditionalInterests()
					.setAddressType("Home");
				}
				else
					nai.clickSameAddressAsPrimaryNamedInsured();

				nai.clickOk();




			}


		}

		FLDP3DwellingConstruction dc = ai.next();

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
		.setPlumbing(eai.getOrDefault("Plumbing Type",null));
		if(eai.getOrDefault("Plumbing Type","none").toLowerCase().equals("other"))
			dc.setPlumbingDescribeOther("Other");
		dc
		.setPlumbingYear(eai.getOrDefault("Plumbing Year",null))
		.setWaterHeaterYear(eai.getOrDefault("Water Heater Year",null))
		.setWiring(eai.getOrDefault("Wiring", "Copper"))
		.setElectricalSystem(eai.getOrDefault("Electrical System","None"))
		.setRoofType(eai.get("Roof Type"));
		if(eai.get("Roof Type").toLowerCase().equals("other"))
			dc.setRoofTypeDescription("Other");
		dc
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
		FLDP3DwellingConstruction.FLDP3WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		FLDP3Coverages co;

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
			wm.setRoofCover(eai.getOrDefault("Roof Cover","<none>"));
			if(eai.get("Roof Deck Attachment") != null)
				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment") + "(");
			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"));
		//.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		 if(eai.get("Other Structures - Increased Limit") != null)
		 {
			 if(!co.isOtherStructuresIncreasedCoverageChecked())
				 co.clickOtherStructuresIncreasedCoverage()
				 .setOtherStructuresIncreasedCoverageLimit(eai.get("Other Structures - Increased Limit"));
			 else
			 	co.setOtherStructuresIncreasedCoverageLimit(eai.get("Other Structures - Increased Limit"));
		 }

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));
		co
//		.setLossOfUseSelection(eai.get("Loss of Use - %"))
		.setWindExcluded(eai.get("Wind Excluded"))
		.setAllOtherPerils(eai.get("Section I Deductibles - AOP"));

		if(eai.get("Wind Excluded").toLowerCase().equals("false") && eai.get("Wind Excluded") != null)
			co
			.setHurricane(eai.get("Section I Deductibles - Hurricane"));

		if(eai.get("How is the dwelling occupied").toLowerCase().equals("tenant occupied"))
		{
			if(eai.get("Premises Liability") != null)
				co.setPremisesLiabilityLimit(eai.get("Premises Liability"));
			else
				co.checkPremisesLiability();
		}
		else
		{
			if(eai.get("Personal Liability") != null)
				co.setPersonalLiabilityLimit(eai.get("Personal Liability"));
			else
				co.checkPersonalLiability();
		}
		//.setMedicalPaymentsLimit(eai.get("Medical Payments"));





		// Property Endorsements
		FLDP3Coverages.FLDP3PropertyEndorsements pe = co.clickPropertyEndorsements();


		if(eai.get("Whensafe - %") != null)
		{
			if(!pe.isWhenSafeChecked())
				pe.checkWhenSafe();

			pe.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));
		}
		else
		{
			if(pe.isWhenSafeChecked())
				pe.checkWhenSafe();
		}



		pe
		.setOccurrenceAggregateLimit(eai.get("Limited Fungi (Limit)"));


		if(eai.getOrDefault("Screen Enclosure Hurricane Coverage (Limit)",null) != null)
			pe
			.checkScreenEnclosureHurricaneCoverage()
			.setScreenEnclosureHurricaneCoverageLimit(eai.get("Screen Enclosure Hurricane Coverage (Limit)"));
		
		if(eai.get("Theft Coverage") == null)
			if(pe.isTheftCoverageChecked())
				pe.clickTheftCoverage();




//		if(eai.getOrDefault("Credit Card (Limit)", null) != null)
//			if(pe.isCreditCardCheckBoxAvailable())
//				pe
//				.checkCreditCardFundTransferForgeryCounterfeitMoney()
//				.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));

		if(eai.get("Water Back Up (Limit)") == null && pe.isWaterBackUpChecked())
				pe.checkWaterBackUp();



		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			pe
			.checkSinkholeLossCoverage()
			.setSinkholeClaimsIndex("4500")
			.setSinkholeIndex("330");

		// Liability Endorsements
		FLDP3RiskAnalysis ra = pe.next();
		FLDP3Quote quote;
		if(qualifiesForHurricaneProtection(eai))
			quote = ra.qualifiesForAdditionalProtectionQuote();
		else
			quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());

		if(eai.get("Consent to Rate") != null)
			quote
			.clickOverrideRating()
			.setTermAmount(eai.get("Consent to Rate"))
			.clickRerate();
//		String[] j = errorReportingInfo(itc.getCurrentXmlTest().getLocalParameters(),true);
////		System.out.println("In test result is ~~~~~" );
//		for(i = 0; i < j.length - 1; i++)
//		{
//				System.out.print(j[i] + "\t");
//
//		}
//		System.out.println();
		//.back().requestApproval().sendRequest();




	}
	private boolean qualifiesForHurricaneProtection(LinkedHashMap<String, String> eai)
	{
		String[] territoryList = new String[] {"043", "193", "393", "593", "596", "601", "603", "604", "605",
		"606", "607", "608", "609", "693", "721", "722", "723", "724", "725", "726", "737", "793", "931", "932",
		"934", "993"};

		if(eai.get("Location Address - State").toLowerCase().equals("florida")
		&& eai.get("Wind Borne Debris Region").toLowerCase().equals("true")
		&& !eai.getOrDefault("Opening Protection Type", "<none>").toLowerCase().equals("hurricane")
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
					&& !isInArray(territoryList,eai.get("Territory Code"))
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
					isInArray(territoryList, eai.get("Territory Code"))
					)

				)

			)
		))
			return true;
		return false;

	}
}