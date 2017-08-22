package PolicyConversion.HOW;

import DataProviders.AccountPolicyGenerator;
import Helpers.CenterSeleniumHelper;
import base.BaseTest;
import base.LocalDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageobjects.NCHOW.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by aansari on 2/8/17.
 */
public class NCHOW extends BaseTest
{
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "NCHOWData",groups = "Renewal Test")
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
			.setSsn(eai.getOrDefault("SSN", null));
			if(qaMain)
			{
				createAccount
				.setOrganization(organization)
				.setProducerCode(prodCode);
			}
			else
			{
				createAccount
				.setOrganization(eai.get("Organization"))
				.setProducerCode(eai.get("Producer Code"));
			}
			//.setProducerCode("012-13-12345 ");
			NCHOWAccountFileSummary accountFileSummary = createAccount
			.checkForDuplicatesAndReturn()
			.clickUpdate();
            log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() +
			", first name: " + firstName + ", last name: " + lastName);


		// Policy Renewal
	log("Test simple homeowners policy renewal");
		eai.put("Account Number", accountFileSummary.getAccountNumber());
		String accountNumber = accountFileSummary.getAccountNumber();
		sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));

		accountFileSummary = new NCHOWAccountFileSummary(sh);
		accountFileSummary.westPanel.actions.convertManualPolicy();
		NCHOWInitiateManualRenewal imr = new NCHOWInitiateManualRenewal(sh);
		// Initiate Manual Renewal
		imr//.setOrganization(eai.getOrDefault("Organization", null))
		//.setProducerCode(eai.getOrDefault("Producer Code", null))
		.setBaseState(eai.getOrDefault("Base State", null))
		.setProduct(eai.getOrDefault("Product", null))
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setLegacyPolicyNumber(eai.getOrDefault("Legacy Policy Number", null))
		.setOriginalEffectiveDate(eai.getOrDefault("Policy Original Effective Date",null))
		.setEffectiveDate(eai.getOrDefault("Effective Date",null))
		.setLastInspectionCompletionDate(eai.get("Last Inspection Completion Date"));
//		if(!eai.getOrDefault("Inflation Guard", "none").toLowerCase().equals("none"))
//			imr.setInflationGuard(eai.getOrDefault("Inflation Guard", null));
//		if(eai.get("Exclude Loss of Use Coverage") == null)
//			imr.clickExcludedLossOfUseCoverage("true");
//		else
//			imr.clickExcludedLossOfUseCoverage("false");
		NCHOWOfferings offerings = imr.nextAndAccept();
		
		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		NCHOWPolicyInfo pi = offerings.next();

		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));
		//.setEffectiveDate(eai.getOrDefault("Effective Date",null));

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
					.checkForDuplicatesAndReturn()
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
					.checkForDuplicatesAndReturn()
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
			sab
			.setType("Company")
			.setCompanyName(addInts.get(i).get("Name"))
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
				NCHOWNewAdditionalInterest nai = null;
				nai = ai.clickAddNewCompany();
				nai
				.setCompanyName(addInts.get(i).get("Name"))
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null));
				if(addInts.get(i).get("Address") != null)
				{
					nai

					.setAddress1(addInts.get(i).get("Address"))
					.setCity(addInts.get(i).get("City"))
					.setState(addInts.get(i).get("State"))
					.setZipCode(addInts.get(i).get("Zip Code"))
					.clickVerifyAddress()
					.selectUserOverride()
					.setAddressType("Home");
				}
				else
					nai.clickSameAddressAsPrimaryNamedInsured();

				nai
				.checkForDuplicatesAndReturn()
				.clickOk();




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
		.setFortifiedHomeType(eai.getOrDefault("Fortified Home Type",null))
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
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		co
		.setWindHail(eai.get("Section I Deductibles - Wind/Hail"));
		if(!eai.get("Section I Deductibles - Wind/Hail").contains("%") && co.isNamedStormDisplayed())
		{
			co.setNamedStorm(eai.getOrDefault("Section I Deductibles - Named Storm", "<none>"));

		}

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
		if(!eai.get("Residence Held in Trust").toLowerCase().equals("false"))
			pe.checkResidenceHeldInTrust();
		if(eai.get("Specified Additional Amount of Coverage A").toLowerCase().equals("false"))
			pe.unCheckSpecificAdditionalAmountOfCoverageA();
		else
			pe.checkSpecificAdditionalAmountOfCoverageA();


		if(eai.get("Inflation Guard - Percent") == null)
			pe.unCheckInflationGuard();
		else
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
		NCHOWPayment payment;
		if(eai.get("Billing Contact (insured or mortgage)") != null || !eai.get("Payment Plan Schedule").toLowerCase().equals("fullpay"))
		{
			payment = quote.westPanel.payment();
			if(eai.get("Billing Contact (insured or mortgage)") != null)
				payment.selectMortgagePremiumFinance(0);

			if(eai.get("Payment Plan Schedule").equals("2Pay"))
				payment.clickTwoPay();

			else if(eai.get("Payment Plan Schedule").equals("4Pay"))
				payment.clickFourPay();

			quote = payment.westPanel.viewQuote();
		}
		if(eai.get("Consent to Rate") != null)
			quote
			.clickOverrideRating()
			.setTermAmount(eai.get("Consent to Rate"))
			.clickRerate();

		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());
		if(quote.isUnderWritingApprovalNeeded())
		{
			quote.backToPoliycReview().back().riskAnalysisRequestApproval().sendRequest().westPanel.viewQuote();
			eai.put("Submitted for Approval","Submitted for approval");
		}
		else
		{
			NCHOWRenewalBound rb = quote.renew();
			String title = rb.getTitle();
			rb.viewYourRenewal();
			eai.put("Submitted for Approval",title);
		}
		if(!eai.get("GoPaperless").toLowerCase().equals("false"))
		{
			NCHOWGoPaperless gp = quote.westPanel.goPaperless();
			if(gp.isEditButtonDisplayed())
				gp.clickEdit();

			gp
			.checkPaperless()
			.setEmailAddress(eai.get("Email Address"))
			.setConfirmEmailAddress(eai.get("Email Address"))
			.clickUpdate();
		}
		log("~~~~Policy Number :"+  eai.get("Legacy Policy Number") + " Entered Correctly~~~~\n"
		+ "~~~~Account Number is: " + eai.get("Account Number") + "~~~~");
		
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
			.setSsn(eai.getOrDefault("SSN", null));
			if(qaMain)
			{
				createAccount
				.setOrganization("Acentria, Inc")
				.setProducerCode("523-23-21388 Acentria, Inc. (MAIN)");
			}
			else
			{
				createAccount
				.setOrganization(eai.get("Organization"))
				.setProducerCode(eai.get("Producer Code"));
			}
			//.setProducerCode("012-13-12345 ");
			NCHOWAccountFileSummary accountFileSummary = createAccount
			.checkForDuplicatesAndReturn()
			.clickUpdate();
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
					.checkForDuplicatesAndReturn()
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
					.checkForDuplicatesAndReturn()
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
			sab
			.setType("Company")
			.setCompanyName(addInts.get(i).get("Name"))
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
				NCHOWNewAdditionalInterest nai = null;
				nai = ai.clickAddNewCompany();
				nai
				.setCompanyName(addInts.get(i).get("Name"))
				.setType(addInts.get(i).get("Type"))
				.setLoanNumber(addInts.get(i).getOrDefault("Loan Number",null));
				if(addInts.get(i).get("Address") != null)
				{
					nai

					.setAddress1(addInts.get(i).get("Address"))
					.setCity(addInts.get(i).get("City"))
					.setState(addInts.get(i).get("State"))
					.setZipCode(addInts.get(i).get("Zip Code"))
					.clickVerifyAddress()
					.selectUserOverride()
					.setAddressType("Home");
				}
				else
					nai.clickSameAddressAsPrimaryNamedInsured();

				nai
				.checkForDuplicatesAndReturn()
				.clickOk();




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
		.setFortifiedHomeType(eai.getOrDefault("Fortified Home Type",null))
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

		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		co
		.setWindHail(eai.get("Section I Deductibles - Wind/Hail"));
		if(!eai.get("Section I Deductibles - Wind/Hail").contains("%") && co.isNamedStormDisplayed())
		{
			co.setNamedStorm(eai.getOrDefault("Section I Deductibles - Named Storm", "<none>"));

		}

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
		if(!eai.get("Residence Held in Trust").toLowerCase().equals("false"))
			pe.checkResidenceHeldInTrust();
		if(eai.get("Specified Additional Amount of Coverage A").toLowerCase().equals("false"))
			pe.unCheckSpecificAdditionalAmountOfCoverageA();
		else
			pe.checkSpecificAdditionalAmountOfCoverageA();


		if(eai.get("Inflation Guard - Percent") == null)
			pe.unCheckInflationGuard();
		else
			pe.checkInflationGuard();
		// Liability Endorsements

		NCHOWRiskAnalysis ra = pe.next();
		NCHOWQuote quote;

		quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());

		NCHOWPayment payment;
		if(eai.get("Billing Contact (insured or mortgage)") != null || !eai.get("Payment Plan Schedule").toLowerCase().equals("fullpay"))
		{
			payment = quote.westPanel.payment();
			if(eai.get("Billing Contact (insured or mortgage)") != null)
				payment.selectMortgagePremiumFinance(0);

			if(eai.get("Payment Plan Schedule").equals("2Pay"))
				payment.clickTwoPay();

			else if(eai.get("Payment Plan Schedule").equals("4Pay"))
				payment.clickFourPay();

			quote = payment.westPanel.viewQuote();
		}
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

		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());
		quote.clickIssuePolicy().acceptyes();
		eai.put("Submitted for Approval","Bound");


		if(!eai.get("GoPaperless").toLowerCase().equals("false"))
		{
			NCHOWGoPaperless gp = quote.westPanel.goPaperless();
			if(gp.isEditButtonDisplayed())
				gp.clickEdit();

			gp
			.checkPaperless()
			.setEmailAddress(eai.get("Email Address"))
			.setConfirmEmailAddress(eai.get("Email Address"))
			.clickUpdate();
		}


	}

}
