package PolicyConversion.HO3;

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
import pageobjects.Account.AccountFileSummary;
import pageobjects.FLHO3.*;
import pageobjects.NorthPanel;
import pageobjects.WizardPanelBase.CenterPanelBase;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by aansari on 2/8/17.
 */
public class FLHO3 extends BaseTest
{

	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "FLHO3Data",groups = "Renewal Test")
	public void RenewalLoadTest2( LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		//***************************************************************************//
		//    Remove hardcoded org, prod code, SpecificOtherStructuresDescription  //
		//***************************************************************************//

		int i;



		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		FLHO3EnterAccountInformation enterAccountInfo = new FLHO3EnterAccountInformation(sh);


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
		FLHO3CreateAccount createAccount = enterAccountInfo.createPersonAccount();

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

			FLHO3AccountFileSummary accountFileSummary = createAccount
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

		accountFileSummary = new FLHO3AccountFileSummary(sh);
		accountFileSummary.westPanel.actions.convertManualPolicy();
		FLHO3InitiateManualRenewal imr = new FLHO3InitiateManualRenewal(sh);
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
		if(!eai.getOrDefault("Inflation Guard", "none").toLowerCase().equals("none"))
			imr.setInflationGuard(eai.getOrDefault("Inflation Guard", null));
		if(!eai.get("Exclude Loss of Use Coverage").toLowerCase().equals("false"))
			imr.clickExcludedLossOfUseCoverage("true");
		else
			imr.clickExcludedLossOfUseCoverage("false");
		FLHO3Offerings offerings = imr.nextAndAccept();

		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		FLHO3PolicyInfo pi = offerings.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			FLHO3SearchAddressBook sab = pi.searchFromAddressBook();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.checkForDuplicatesAndReturn()
					.clickOk();

				}

			}
			i++;
		}


		FLHO3Dwelling dwelling = pi.next();

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
		FLHO3Dwelling.FLHO3ProtectionDetails pd = dwelling.clickProtectionDetails();



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
		.setFireExtinguishers(eai.getOrDefault("One or more fire extinguishers in the home?","false"));

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none") && !eai.get("Sprinkler System").toLowerCase().equals("false"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		FLHO3Dwelling.FLHO3AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			FLHO3SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
			{
				sab.setType("Company")
				.setCompanyName(addInts.get(i).get("Name"));
			}
			else
			{
				sab.setType("Person")
				.setFirstName(fName)
				.setLastName(lName);
			}
			sab
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
				FLHO3NewAdditionalInterest nai = null;
				if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
				{
					nai = ai.clickAddNewCompany();
					nai.setCompanyName(addInts.get(i).get("Name"));
				}
				else
				{
					nai = ai.clickAddNewPerson();
					nai
					.setFirstName(fName)
					.setLastName(lName);
				}
				nai
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

		FLHO3DwellingConstruction dc = ai.next();

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
		.setElectricalSystem(eai.getOrDefault("Electrical System","<None>"))
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
		FLHO3DwellingConstruction.FLHO3WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		FLHO3Coverages co;

		if(Integer.parseInt(eai.get("Year Built")) >= 2002)
		{
			wm
			.setRoofDeck(eai.getOrDefault("Roof Deck","<none>"))
			.setFbcWindSpeed(eai.getOrDefault("FBC Wind Speed","100 MPH"))
			.setInternalPressure(eai.getOrDefault("Internal Pressure", "<none>"))
			.setWindBorneDebris(eai.get("Wind Borne Debris Region"));
			co = wm.next();
		}
		else
		{
			wm.setRoofCover(eai.getOrDefault("Roof Cover","<none>"));
			if(eai.get("Roof Deck Attachment") != null)
				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment"));
			else
				wm.setRoofDeckAttachment("<none>");
			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
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
		FLHO3Coverages.FLHO3PropertyEndorsements pe = co.clickPropertyEndorsements();

		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(!pe.isWhenSafeChecked())
				pe.checkWhenSafe();

			pe.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));
		}
		else if(eai.get("Whensafe - %") == null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(pe.isWhenSafeChecked())
				pe.unCheckWhenSafe();
		}

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

		if(spp.size() > 0)
			pe.checkScheduledPersonalProperty();

		for(int j = 1; j <= spp.size();j++)
		{
			pe
			.clickAddScheduledPersonalProperty()
			.setPersonalPropertyArticleType(j,spp.get(j-1).get("Class"))
			.setPersonalPropertyDescription(j, spp.get(j-1).getOrDefault("Description", "Test"))
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
				pe
				.checkCreditCardFundTransferForgeryCounterfeitMoney()
				.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));

		if(eai.get("Water Back Up (Limit)") == null && eai.get("Guardian Endorsement") == null)
			if(pe.isWaterBackUpChecked())
				pe.unCheckWaterBackUp();

		if(eai.get("Inflation Guard").toLowerCase().equals("none"))
			if(pe.isInflationGuardChecked())
				pe.unCheckInflationGuard();

		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			if(!pe.isSinkholeLossCoverageChecked())
				pe.checkSinkholeLossCoverage();



		// Liability Endorsements
		FLHO3Coverages.FLHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();

		if(!eai.getOrDefault("Animal Liability","false").toLowerCase().equals("false") && eai.get("Guardian Endorsement") == null)
			le.checkAnimalLiability();

		if(eai.getOrDefault("Additional Residence Rented to Others - Number of families",null) != null)
		{
			le.checkAdditionalResidenceRentedToOthers()
			.setLocationName(eai.getOrDefault("Additional Residence Rented to Others - Number of families", "1:"));
			//.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
			le.addNewLocation()
			.setAddress1(eai.get("Location Address"))
			.setAddress2(eai.getOrDefault("Location Address - Unit", null))
			.setCity(eai.get("Location Address - City"))
			.setZipCode(eai.get("Location Address - Zip"))
			.setCounty(eai.get("Location Address - County"))
			.clickVerifyAddress()
			.selectSuccessfulVerificationIfPossibleForLocationInformation()
			.clickLiabilityOk()
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		}
		if(eai.getOrDefault("Business Pursuits - Business activity", null) != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(eai.getOrDefault("Watercraft Liablity - Watercraft Type",null) != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));
		if(!eai.getOrDefault("Permitted Incidental Occupancy - Liability","false").toLowerCase().equals("false"))
		{
			le.
			checkPermittedIncidentalOccupancyLiability();
			if(eai.get("Permitted Incidental Occupancy - Property (Limit)") != null)
				le.clickPropertyEndorsements()
				.checkPermittedIncidentalOccupancy()
				.setPermittedIncidentalOccupancyLimit(eai.get("Permitted Incidental Occupancy - Property (Limit)"))
				.clickLiabilityEndorsements();
		}


		FLHO3RiskAnalysis ra = le.next();
		FLHO3Quote quote;
		quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());
		FLHO3Payment payment;
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
			FLHO3RenewalBound rb = quote.renew();
			String title = rb.getTitle();
			rb.viewYourRenewal();
			eai.put("Submitted for Approval",title);
		}

		if(!eai.get("GoPaperless").toLowerCase().equals("false"))
		{
			FLHO3GoPaperless gp = quote.westPanel.goPaperless();
			if(gp.isEditButtonDisplayed())
				gp.clickEdit();

			gp
			.checkPaperless()
			.setEmailAddress(eai.get("Email Address"))
			.setConfirmEmailAddress(eai.get("Email Address"))
			.clickUpdate();
		}


	}
	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "FLHO3Data")
	public void SubmissionLoadTest(LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
				//**********************************************************************************************//
		//    Remove hardcoded org, prod code, SpecificOtherStructuresDescription  Policy Original Date //
		//**********************************************************************************************//

		int i;

		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1 , actionTab.getSize().getHeight()/2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		FLHO3EnterAccountInformation enterAccountInfo = new FLHO3EnterAccountInformation(sh);


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
		FLHO3CreateAccount createAccount = enterAccountInfo.createPersonAccount();

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

			FLHO3AccountFileSummary accountFileSummary = createAccount
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
		FLHO3NewSubmission submission = new FLHO3NewSubmission(sh);

		submission.setBaseState(eai.get("Base State"));
		FLHO3Qualification qualification = submission.productTable.selectHomeowners();

		qualification.setPolicyType(eai.get("Policy Type"));
		System.out.println(qualification.questionnaire.getQuestionText(1));
		for(i = 1; i<9; i++)
			qualification.questionnaire.answerNo(i);
		FLHO3PolicyInfo pi = qualification.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));
		//.setEffectiveDate("5/1/2017");

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			FLHO3SearchAddressBook sab = pi.searchFromAddressBook();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.checkForDuplicatesAndReturn()
					.clickOk();

				}

			}
			i++;
		}


		FLHO3Dwelling dwelling = pi.next();

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
		FLHO3Dwelling.FLHO3ProtectionDetails pd = dwelling.clickProtectionDetails();



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
		.setFireExtinguishers(eai.getOrDefault("One or more fire extinguishers in the home?","false"));

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none") && !eai.get("Sprinkler System").toLowerCase().equals("false"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		FLHO3Dwelling.FLHO3AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			FLHO3SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
			{
				sab.setType("Company")
				.setCompanyName(addInts.get(i).get("Name"));
			}
			else
			{
				sab.setType("Person")
				.setFirstName(fName)
				.setLastName(lName);
			}
			sab
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
				FLHO3NewAdditionalInterest nai = null;
				if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
				{
					nai = ai.clickAddNewCompany();
					nai.setCompanyName(addInts.get(i).get("Name"));
				}
				else
				{
					nai = ai.clickAddNewPerson();
					nai
					.setFirstName(fName)
					.setLastName(lName);
				}
				nai
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

		FLHO3DwellingConstruction dc = ai.next();

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
		.setElectricalSystem(eai.getOrDefault("Electrical System","<None>"))
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
		FLHO3DwellingConstruction.FLHO3WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		FLHO3Coverages co;

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
				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment"));
			else
				wm.setRoofDeckAttachment("<none>");
			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));

		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
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
		FLHO3Coverages.FLHO3PropertyEndorsements pe = co.clickPropertyEndorsements();

		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(!pe.isWhenSafeChecked())
				pe.checkWhenSafe();

			pe.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));
		}
		else if(eai.get("Whensafe - %") == null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(pe.isWhenSafeChecked())
				pe.unCheckWhenSafe();
		}

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
				pe
				.checkCreditCardFundTransferForgeryCounterfeitMoney()
				.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));

		if(eai.get("Water Back Up (Limit)") == null && eai.get("Guardian Endorsement") == null)
			if(pe.isWaterBackUpChecked())
				pe.unCheckWaterBackUp();

		if(eai.get("Inflation Guard").toLowerCase().equals("none"))
			if(pe.isInflationGuardChecked())
				pe.unCheckInflationGuard();

		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			if(!pe.isSinkholeLossCoverageChecked())
				pe.checkSinkholeLossCoverage();



		// Liability Endorsements
		FLHO3Coverages.FLHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();

		if(!eai.getOrDefault("Animal Liability","false").toLowerCase().equals("false") && eai.get("Guardian Endorsement") == null)
			le.checkAnimalLiability();

		if(eai.getOrDefault("Additional Residence Rented to Others - Number of families",null) != null)
		{
			le.checkAdditionalResidenceRentedToOthers()
			.setLocationName(eai.getOrDefault("Additional Residence Rented to Others - Number of families", "1:"));
			//.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
			le.addNewLocation()
			.setAddress1(eai.get("Location Address"))
			.setAddress2(eai.getOrDefault("Location Address - Unit", null))
			.setCity(eai.get("Location Address - City"))
			.setZipCode(eai.get("Location Address - Zip"))
			.setCounty(eai.get("Location Address - County"))
			.clickVerifyAddress()
			.selectSuccessfulVerificationIfPossibleForLocationInformation()
			.clickLiabilityOk()
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		}
		if(eai.getOrDefault("Business Pursuits - Business activity", null) != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(eai.getOrDefault("Watercraft Liablity - Watercraft Type",null) != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));

		if(!eai.getOrDefault("Permitted Incidental Occupancy - Liability","false").toLowerCase().equals("false"))
		{
			le.
			checkPermittedIncidentalOccupancyLiability();
			if(eai.get("Permitted Incidental Occupancy - Property (Limit)") != null)
				le.clickPropertyEndorsements()
				.checkPermittedIncidentalOccupancy()
				.setPermittedIncidentalOccupancyLimit(eai.get("Permitted Incidental Occupancy - Property (Limit)"))
				.clickLiabilityEndorsements();
		}

		FLHO3RiskAnalysis ra = le.next();
		FLHO3Quote quote;
		if(qualifiesForHurricaneProtection(eai))
			quote = ra.qualifiesForAdditionalProtectionQuote();
		else
			quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());

		FLHO3Payment payment;
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
		quote.clickIssuePolicy().acceptyes();
		eai.put("Submitted for Approval","Bound");

		
		if(!eai.get("GoPaperless").toLowerCase().equals("false"))
		{
			FLHO3GoPaperless gp = quote.westPanel.goPaperless();
			if(gp.isEditButtonDisplayed())
				gp.clickEdit();

			gp
			.checkPaperless()
			.setEmailAddress(eai.get("Email Address"))
			.setConfirmEmailAddress(eai.get("Email Address"))
			.clickUpdate();
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




	}
	@Test
	public void DBFailTest()
	{
		//**********************************************************************************************//
		//    Remove hardcoded org, prod code, SpecificOtherStructuresDescription  Policy Original Date //
		//**********************************************************************************************//



		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
		WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
		Actions build = new Actions(driver);
		build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
		sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
		FLHO3EnterAccountInformation enterAccountInfo = new FLHO3EnterAccountInformation(sh);


		log("Test new person account creation");

		//String[] insuredName = eai.get("Name Insured").split("\\s+");
		String firstName = "john", lastName = "smith";

		enterAccountInfo
		.setFirstName(firstName)
		.setCountry("United States")
		.setCity("Orlando")
		.setState("Florida")
		.setZipCode("32836")
		.setLastName(lastName + dateString);
		for(int i = 0; i<20; i++)
		{
			enterAccountInfo.clickSearch();
			takeScreenShot(driver);
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
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

	@Test(dataProviderClass = AccountPolicyGenerator.class, dataProvider = "FLHO3Rerun")
	public void rerunRenewalTest(LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp)
	{
		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);
		FLHO3AccountFileSummary afs;
		String accountNumber = eai.get("Account Number");
		// If there's an Account Number
		if(accountNumber != null)
		{
			AccountFileSummary as = new NorthPanel(sh).accountTab.setAccountSearch(accountNumber).clickAccountSearch();
			// If there is a Transaction Number and Account Number
			if(as.isTransactionNumberDisplayed())
			{
				afs = new FLHO3AccountFileSummary(sh);
				afs.clickTransactionNumber();
				rerunPolicy(eai, addInts, spp, true, true);
			}
			// If there is no Transaction number but an Account Number
			else
			{
				rerunPolicy(eai, addInts, spp, true, false);
			}
		}
		// If there is no Account Number
		else
			rerunPolicy(eai, addInts, spp,false,false);

//

	}

	public void rerunPolicy( LinkedHashMap<String, String> eai, ArrayList<LinkedHashMap<String, String>> addInts, ArrayList<LinkedHashMap<String, String>> spp, boolean accountNumberPresent, boolean transactionPresent)
	{
		//***************************************************************************//
		//    Remove hardcoded org, prod code, SpecificOtherStructuresDescription  //
		//***************************************************************************//

		int i;


		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);


		if(!accountNumberPresent)
		{
			sh.wait(30).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
			WebElement actionTab = driver.findElement(By.id("TabBar:AccountTab"));
			Actions build = new Actions(driver);
			build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
			sh.clickElement(By.id("TabBar:AccountTab:AccountTab_NewAccount-textEl"));
			FLHO3EnterAccountInformation enterAccountInfo = new FLHO3EnterAccountInformation(sh);


			log("Test new person account creation");

			//String[] insuredName = eai.get("Name Insured").split("\\s+");
			String firstName = eai.get("Name Insured First Name"), lastName = eai.get("Name Insured Last Name");

			enterAccountInfo.setFirstName(firstName).setCountry("United States").setCity(eai.get("Mailing City")).setState(eai.get("Mailing State")).setZipCode(eai.get("Mailing Zip Code")).setLastName(lastName).clickSearch();
			FLHO3CreateAccount createAccount = enterAccountInfo.createPersonAccount();

			log("Creating new account: " + dateString);

			createAccount.setAddressLine1(eai.get("Mailing Address")).setCity(eai.get("Mailing City")).setState(eai.get("Mailing State")).setCounty(eai.getOrDefault("Mailing County", null)).setDateOfBirth(eai.get("Date of Birth")).setHomePhone(eai.get("Home Phone")).setWorkPhone(eai.getOrDefault("Work Phone", null)).setPrimaryEmail(eai.getOrDefault("Email Address", null)).setState(eai.getOrDefault("Mailing State", null)).setZipCode(eai.getOrDefault("Mailing Zip Code", null)).clickVerifyAddress().selectSuccessfulVerificationIfPossibleForCreateAccount().setAddressType(eai.getOrDefault("Address Type", "Home"))
			//.setDescription("Nerd Lair")
			.setSsn(eai.getOrDefault("SSN", null));
			if(qaMain)
			{
				createAccount.setOrganization("Acentria, Inc").setProducerCode("523-23-21388 Acentria, Inc. (MAIN)");
			}
			else
			{
				createAccount.setOrganization(eai.get("Organization")).setProducerCode(eai.get("Producer Code"));
			}

			FLHO3AccountFileSummary accountFileSummary = createAccount.checkForDuplicatesAndReturn().clickUpdate();
			log("Account successfully created: accountNumber=" + accountFileSummary.getAccountNumber() + ", first name: " + firstName + ", last name: " + lastName);


			// Policy Renewal
			log("Test simple homeowners policy renewal");
			eai.put("Account Number", accountFileSummary.getAccountNumber());
			String accountNumber = accountFileSummary.getAccountNumber();
			sh.wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id("TabBar:AccountTab")));
			actionTab = driver.findElement(By.id("TabBar:AccountTab"));
			build.moveToElement(actionTab, actionTab.getSize().getWidth() - 1, actionTab.getSize().getHeight() / 2).click().build().perform();
			sh.setText(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem-inputEl"), accountNumber);
			sh.clickElement(By.id("TabBar:AccountTab:AccountTab_AccountNumberSearchItem_Button"));
		}
		FLHO3Offerings offerings;
		if(!transactionPresent)
		{
			new FLHO3AccountFileSummary(sh).westPanel.actions.convertManualPolicy();
			FLHO3InitiateManualRenewal imr = new FLHO3InitiateManualRenewal(sh);
			// Initiate Manual Renewal
			imr.setBaseState(eai.getOrDefault("Base State", null))
			.setProduct(eai.getOrDefault("Product", null))
			.setPolicyType(eai.getOrDefault("Policy Type", null))
			.setLegacyPolicyNumber(eai.getOrDefault("Legacy Policy Number", null))
			.setOriginalEffectiveDate(eai.getOrDefault("Policy Original Effective Date", null))
			.setEffectiveDate(eai.getOrDefault("Effective Date", null))
			.setLastInspectionCompletionDate(eai.getOrDefault("Last Inspection Completion Date", "06/01/2013"));

			if(!eai.getOrDefault("Inflation Guard", "none").toLowerCase().equals("none"))
				imr.setInflationGuard(eai.getOrDefault("Inflation Guard", null));
			if(!eai.get("Exclude Loss of Use Coverage").toLowerCase().equals("false"))
				imr.clickExcludedLossOfUseCoverage("true");
			else
				imr.clickExcludedLossOfUseCoverage("false");

			offerings = imr.nextAndAccept();
		}
		else
		{
			// Add standard tab func
			offerings = new FLHO3Offerings(sh, CenterPanelBase.Path.POLICYRENEWAL);
			offerings.westPanel.clickOfferings();
		}
		// Offerings
		offerings
		.setPolicyType(eai.getOrDefault("Policy Type", null))
		.setOfferingSelection(eai.getOrDefault("Offering Selection","Most Popular"));
		FLHO3PolicyInfo pi = offerings.next();
		// Policy Info
		pi
		.setDoesInsuredOwnOtherResidenceWithFrontline(eai.getOrDefault("Does the insured own any other residence that is insured with Frontline?", null));

		i=1;

		if(keyContainsValue(eai,"Additional Name Insured Last Name" ) || keyContainsValue(eai,"Additional Name Insured Company Name" ))
		{
			boolean person = false;
			FLHO3SearchAddressBook sab = pi.searchFromAddressBook();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewPerson();
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
					FLHO3NewAdditionalNamedInsured ani = pi.clickAddNewCompany();
					ani
					.setCompanyName(eai.getOrDefault("Additional Name Insured Company Name", null))
					.clickSameAddressAsPrimaryNamedInsured()
					.checkForDuplicatesAndReturn()
					.clickOk();

				}

			}
			i++;
		}


		FLHO3Dwelling dwelling = pi.next();

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
		FLHO3Dwelling.FLHO3ProtectionDetails pd = dwelling.clickProtectionDetails();



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
		.setFireExtinguishers(eai.getOrDefault("One or more fire extinguishers in the home?","false"));

		if(!eai.getOrDefault("Sprinkler System", "none").toLowerCase().equals("none") && !eai.get("Sprinkler System").toLowerCase().equals("false"))

			pd.
			setSprinklerSystem("true")
			.setSprinklerSystemType(eai.get("Sprinkler System"));
		pd
		.setDeadbolts(eai.get("Deadbolts"))
		.setResidenceVisibleToNeighbors(eai.getOrDefault("Residence Visible to neighbors","true"));






		// Additional Interests
		FLHO3Dwelling.FLHO3AdditionalInterests ai = pd.clickAdditionalInterests();
		for(i= 0; i <= addInts.size() -1;i++)
		{

			FLHO3SearchAddressBook sab = ai.clickFromAddressBook();
			String[] name =  addInts.get(i).get("Name").split("\\s+");
			String fName =  name[0], lName = getLastName(name);
			if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
			{
				sab.setType("Company")
				.setCompanyName(addInts.get(i).get("Name"));
			}
			else
			{
				sab.setType("Person")
				.setFirstName(fName)
				.setLastName(lName);
			}
			sab
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
				FLHO3NewAdditionalInterest nai = null;
				if(addInts.get(i).get("Type").toLowerCase().contains("mortgagee"))
				{
					nai = ai.clickAddNewCompany();
					nai.setCompanyName(addInts.get(i).get("Name"));
				}
				else
				{
					nai = ai.clickAddNewPerson();
					nai
					.setFirstName(fName)
					.setLastName(lName);
				}
				nai
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

		FLHO3DwellingConstruction dc = ai.next();

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
		.setElectricalSystem(eai.getOrDefault("Electrical System","<None>"))
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
		FLHO3DwellingConstruction.FLHO3WindMitigation wm = dc.clickWindMitigation();
		wm
		.setRoofShapeType(eai.getOrDefault("Roof Shape","Other"))
		.setOpeningProtectionType(eai.get("Opening Protection Type"))
		.setTerrain(eai.get("Terrain"))
		.setSecondaryWaterResistance(eai.getOrDefault("Secondary Water Resistance","false"));

		FLHO3Coverages co;

		if(Integer.parseInt(eai.get("Year Built")) >= 2002)
		{
			wm
			.setRoofDeck(eai.getOrDefault("Roof Deck","<none>"))
			.setFbcWindSpeed(eai.getOrDefault("FBC Wind Speed","100 MPH"))
			.setInternalPressure(eai.getOrDefault("Internal Pressure", "<none>"))
			.setWindBorneDebris(eai.get("Wind Borne Debris Region"));
			co = wm.next();
		}
		else
		{
			wm.setRoofCover(eai.getOrDefault("Roof Cover","<none>"));
			if(eai.get("Roof Deck Attachment") != null)
				wm.setRoofDeckAttachment(eai.get("Roof Deck Attachment"));
			else
				wm.setRoofDeckAttachment("<none>");
			wm.setRoofWallConnection(eai.get("Roof Wall Connection"));
			co = wm.next();
		}



		// Coverages
		co
		.setDwellingLimit(eai.get("Dwelling Limit"))
		.setOtherStructuresPercentage(eai.get("Other Structures - %"));
		if(!eai.get("Personal Property - Valuation Method").toLowerCase().equals(co.getPersonalPropertyValuationMethod().toLowerCase()))
			co
			.setPersonalPropertyValuationMethod(eai.get("Personal Property - Valuation Method"));

		if(eai.get("Personal Property - Limit") != null)
			co.setPersonalPropertyExcluded("false")
			.setPersonalPropertyLimit(eai.get("Personal Property - Limit"));
		else
			co.setPersonalPropertyExcluded("true");
		co
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
		FLHO3Coverages.FLHO3PropertyEndorsements pe = co.clickPropertyEndorsements();

		if(eai.get("Guardian Endorsement") != null)
			pe
			.checkGuardianEndorsements();

		if(eai.get("Whensafe - %") != null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(!pe.isWhenSafeChecked())
				pe.checkWhenSafe();

			pe.setWhenSafeCreditPercentage(eai.get("Whensafe - %"));
		}
		else if(eai.get("Whensafe - %") == null && eai.get("Wind Excluded").toLowerCase().equals("false"))
		{
			if(pe.isWhenSafeChecked())
				pe.unCheckWhenSafe();
		}

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

		if(spp.size() > 0)
			pe.checkScheduledPersonalProperty();

		for(int j = 1; j <= spp.size();j++)
		{
			pe
			.clickAddScheduledPersonalProperty()
			.setPersonalPropertyArticleType(j,spp.get(j-1).get("Class"))
			.setPersonalPropertyDescription(j, spp.get(j-1).getOrDefault("Description", "Test"))
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
				pe
				.checkCreditCardFundTransferForgeryCounterfeitMoney()
				.setCreditCardFundTransferForgeryCounterfeitMoneyLimit(eai.get("Credit Card (Limit)"));

		if(eai.get("Water Back Up (Limit)") == null && eai.get("Guardian Endorsement") == null)
			if(pe.isWaterBackUpChecked())
				pe.unCheckWaterBackUp();

		if(eai.get("Inflation Guard").toLowerCase().equals("none"))
			if(pe.isInflationGuardChecked())
				pe.unCheckInflationGuard();

		//.setPercentageOfAnnualIncrease("12%")
		if(!eai.getOrDefault("Sinkhole Loss Coverage","false").toLowerCase().equals("false"))
			if(!pe.isSinkholeLossCoverageChecked())
				pe.checkSinkholeLossCoverage();



		// Liability Endorsements
		FLHO3Coverages.FLHO3LiabilityEndorsements le = pe.clickLiabilityEndorsements();

		if(!eai.getOrDefault("Animal Liability","false").toLowerCase().equals("false") && eai.get("Guardian Endorsement") == null)
			le.checkAnimalLiability();

		if(eai.getOrDefault("Additional Residence Rented to Others - Number of families",null) != null)
		{
			le.checkAdditionalResidenceRentedToOthers()
			.setLocationName(eai.getOrDefault("Additional Residence Rented to Others - Number of families", "1:"));
			//.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
			le.addNewLocation()
			.setAddress1(eai.get("Location Address"))
			.setAddress2(eai.getOrDefault("Location Address - Unit", null))
			.setCity(eai.get("Location Address - City"))
			.setZipCode(eai.get("Location Address - Zip"))
			.setCounty(eai.get("Location Address - County"))
			.clickVerifyAddress()
			.selectSuccessfulVerificationIfPossibleForLocationInformation()
			.clickLiabilityOk()
			.setNumberOfFamilies(eai.get("Additional Residence Rented to Others - Number of families"));
		}
		if(eai.getOrDefault("Business Pursuits - Business activity", null) != null)
			le
			.checkBusinessPursuits()
			.setBusinessActivity(eai.get("Business Pursuits - Business activity"));
		if(eai.getOrDefault("Watercraft Liablity - Watercraft Type",null) != null)
			le
			.checkWatercraftLiability()
			.setWatercraftType(eai.get("Watercraft Liablity - Watercraft Type"));
		if(!eai.getOrDefault("Permitted Incidental Occupancy - Liability","false").toLowerCase().equals("false"))
		{
			le.
			checkPermittedIncidentalOccupancyLiability();
			if(eai.get("Permitted Incidental Occupancy - Property (Limit)") != null)
				le.clickPropertyEndorsements()
				.checkPermittedIncidentalOccupancy()
				.setPermittedIncidentalOccupancyLimit(eai.get("Permitted Incidental Occupancy - Property (Limit)"))
				.clickLiabilityEndorsements();
		}


		FLHO3RiskAnalysis ra = le.next();
		FLHO3Quote quote;
		quote = ra.quote();
		eai.put("Annualized Total Cost", quote.getAnnualizedTotalCost());
		FLHO3Payment payment;
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
			FLHO3RenewalBound rb = quote.renew();
			String title = rb.getTitle();
			rb.viewYourRenewal();
			eai.put("Submitted for Approval",title);
		}

		if(!eai.get("GoPaperless").toLowerCase().equals("false"))
		{
			FLHO3GoPaperless gp = quote.westPanel.goPaperless();
			if(gp.isEditButtonDisplayed())
				gp.clickEdit();

			gp
			.checkPaperless()
			.setEmailAddress(eai.get("Email Address"))
			.setConfirmEmailAddress(eai.get("Email Address"))
			.clickUpdate();
		}


	}

	@Test()
	public void prodTest()
	{
		WebDriver driver = LocalDriverManager.getDriver();
		CenterSeleniumHelper sh = new CenterSeleniumHelper(driver);

		new NorthPanel(sh)
		.accountTab
		.setAccountSearch("9442727246")
		.clickAccountSearch();
		new FLHO3AccountFileSummary(sh).westPanel.actions.convertManualPolicy();


	}

}
