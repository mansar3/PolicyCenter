package PolicyConversion.HOW;

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
import pageobjects.Login;
import pageobjects.NCHOW.*;
import pageobjects.WizardPanelBase.AccountFileSummary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

/**
 * Created by aansari on 2/8/17.
 */
public class NCHOW extends BaseTest
{
	private String dateString;
	private String errorOutput;

	private AccountFileSummary accountFileSummary;
	private String 	policyNumHO3 = "FPH3-324233601",
					policyNumDP3 = "FPD3-324237824";
	String 	filePathBase = "\\\\FLHIFS1\\General\\ConversionData\\Error Report\\",
			//filePathBase = "/Users/aansari/Desktop/",
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
		String[] headers = {"Result", "Account Number", "Legacy Policy Number", "Effective Date", "Policy Type", "Base State","Premium Variation", "Year Built", "Construction Type", "Dwelling Limit",
					"Territory Code", "AOP Deductible", "WhenSafe Percentage", "Last Page Visited","Total Annualized Premium", "ScreenShot","Submitted for Approval", "GW Warnings"};
		WebDriver driver = LocalDriverManager.getDriver();
		if(testResult.getStatus() != ITestResult.SUCCESS)
		{


			String screenshotName = takeScreenShot(driver);
			String[] csvInput =  errorReportingInfo(eai,false).clone();
			csvInput[15] = screenshotName;

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

	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "NCHOWData")
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
		NCHOWEnterAccountInformation enterAccountInfo = new NCHOWEnterAccountInformation(sh);


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
		NCHOWCreateAccount createAccount = enterAccountInfo.createPersonAccount();

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
			.setOrganization("Brown")
			.setProducerCode("523-23-21297 Brown & Brown of Florida, Inc. - Miami Division");
			//.setProducerCode("012-13-12345 ");
			NCHOWAccountFileSummary accountFileSummary = createAccount.clickUpdate();
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
		NCHOWNewSubmission submission = new NCHOWNewSubmission(sh);

		submission.setBaseState(eai.get("Base State"));
		NCHOWQualification qualification = submission.productTable.selectHomeowners();

		qualification.setPolicyType(eai.get("Policy Type"));
		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		NCHOWPolicyInfo pi = qualification.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null))
		.setEffectiveDate(eai.getOrDefault("Effective Date",null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			NCHOWSearchAddressBook sab = pi.searchFromAddressBook();
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
					NCHOWNewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					NCHOWNewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.clickOk();

				}

			}
			i++;
		}


		NCHOWDwelling dwelling = pi.next();

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
		.setTerritoryCode(eai.getOrDefault("Territory Code", null));

//		/Users/aansari/Downloads/ConversionPolicies-20170206_165054/NCHOW-20170206_165309
		dwelling
		.setDistanceToCoast(eai.getOrDefault("Distance to Coast", null));

		// Protection Details
		NCHOWDwelling.NCHOWProtectionDetails pd = dwelling.clickProtectionDetails();


		pd
		.setLockedPrivacyFence(eai.getOrDefault("Is there a locked privacy fence","false"))
		.setCommunityGuarded(eai.getOrDefault("Is the community Guarded?", "false"))
		.setGatedCommunity(eai.getOrDefault("Is the community Gated?", "false"));








		// Additional Interests
		NCHOWDwelling.NCHOWAdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			NCHOWSearchAddressBook sab = ai.clickFromAddressBook();
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
				NCHOWNewAdditionalInterest nai =  ai.clickAddNewPerson();
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

		NCHOWDwellingConstruction dc = ai.next();

		// Dwelling Construction
		dc
		.setEstimatedReplacementCost(eai.get("Estimated Replacement Cost"))
		.setConstructionType(eai.get("Construction Type"))
		.setNumberOfStories(eai.get("Number of Stories"))
		.setSquareFootage(eai.get("Square Footage"))
		.setRoofType(eai.get("Roof Type"));
		if(eai.get("Roof Type").toLowerCase().equals("other"))
			dc.setRoofTypeDescription("Other");
		dc
		.setRoofYear(eai.getOrDefault("Roof Year",eai.get("Year Built")))
		.setUncorrectedFireOrBuildingCodeViolations(eai.getOrDefault("Any uncorrected fire or building code violations?","false"));


		// Wind Mitigation
		NCHOWDwellingConstruction.NCHOWWindMitigation wm = dc.clickWindMitigation();
		wm
		.setDiscountType(eai.get("Discount Type"))
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"));

		NCHOWCoverages co;

//		if(Integer.parseInt(eai.get("Year Built")) >= 2002)
//		{
//			wm
//			.setRoofDeck(eai.getOrDefault("Roof Deck","<none>"))
//			.setFbcWindSpeed(eai.getOrDefault("FBC Wind Speed","100 MPH"))
//			.setInternalPressure(eai.getOrDefault("Internal Pressure", "<none>"))
//			.setWindBorneDebris(eai.get("Wind Borne Debris Region"));
//			co = wm.next();
//		}
//		else
//		{
//			wm.setRoofCover(eai.get("Roof Cover"));
//			if(eai.get("Roof Deck Attachment") != null)
//				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment") + "(");
//			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
//			co = wm.next();
//		}
//		wm
//		.setIsTheRoofCoverConstructionBuildingCodeCompliant(eai.get("Is the roof cover construction building code compliant?"))
//		.setIsTheRoofDeckAttachmentBuildingCodeCompliant(eai.get("Is the roof deck attachment buiding code compliant?"))
//		.setIsTheRoofWallconnectionBuildingCodeCompliant(eai.get("Is the roof wall connection building code compliant?"));
		co = wm.next();


		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"));
		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		co
		.setNamedStorm(eai.get("Section I Deductibles - Named Storm"))
		.setWindHail(eai.get("Section I Deductibles - Wind/Hail"));


		NCHOWCoverages.NCHOWPropertyEndorsements pe = co.clickPropertyEndorsements();



		if(eai.get("Specific Other Structures - Limit" ) != null)
		{
			pe
			.checkSpecificOtherStructures()
			.addSpecificOtherStructures()
			.setSpecificOtherStructuresDescription(1,"test")
			.setSpecificOtherStructuresLimit(1,eai.get("Specific Other Structures - Limit"));
		}

		if(eai.get("Other Structures Increase Coverage - Rented to Others - Limit") != null)
		{
			pe
			.checkOtherStructuresIncreasedCoverageRentedToOthers()
			.addOtherStructures()
			.setOtherStructuresDescription(1, eai.getOrDefault("Other Structures Increase Coverage - Rented to Others - Description","Test"))
			.setOtherStructuresLimit(1, eai.get("Other Structures Increase Coverage - Rented to Others - Limit"));

		}
		if(!eai.getOrDefault("Residence Held in Trust", "False").toLowerCase().equals("false"))
			pe.checkResidenceHeldInTrust();
		if(eai.get("Specified Additional Amount of Coverage A").toLowerCase().equals("false"))
			if(pe.isSpecificAdditionalAmountOfCoverageAChecked())
				pe.checkSpecificAdditionalAmountOfCoverageA();
		else
			if(!pe.isSpecificAdditionalAmountOfCoverageAChecked())
				pe.checkSpecificAdditionalAmountOfCoverageA();


		if(eai.get("Inflation Guard - Percent") == null)
			if(pe.isInflationGuardChecked())
				pe.checkInflationGuard();
		// Liability Endorsements

		NCHOWRiskAnalysis ra = pe.next();
		NCHOWQuote quote;

		quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());
//		String[] j = errorReportingInfo(itc.getCurrentXmlTest().getLocalParameters(),true);
////		System.out.println("In test result is ~~~~~" );
//		for(i = 0; i < j.length - 1; i++)
//		{
//				System.out.print(j[i] + "\t");
//
//		}
//		System.out.println();
		//.back().requestApproval().sendRequest();
		if(eai.get("Consent to Rate") != null)
			quote
			.clickOverrideRating()
			.setTermAmount(eai.get("Consent to Rate"))
			.clickRerate();




	}



}
