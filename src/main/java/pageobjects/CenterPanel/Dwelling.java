package pageobjects.CenterPanel;

import Helpers.CenterSeleniumHelper;
import Helpers.TableBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Dwelling extends CenterPanelBase
{
	private DwellingBy by;
	public ProtectionDetails pd;
	public AdditionalInterests ai;
	protected String 	dwellingBase, tabBase,
						protectionDetailsBase,
						aiBase;
	public Dwelling(CenterSeleniumHelper sh,Path path)
	{
		this.sh = sh;
		this.path = path;
		expectedPanelTitle = "Dwelling";
		waitForTitle(sh);
		setID(path);
		by = new DwellingBy();
		pd = new ProtectionDetails(sh,path);
		ai = new AdditionalInterests(sh,path);
		System.out.println("Navigated to page: " + getTitle());
	}

	public void setID(Path path)
	{
		switch(path)
		{
			case SUBMISSION:
				dwellingBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
				protectionDetailsBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingProtectionDetailsHOEDV:";
				aiBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HOAdditionalInterestDetailsHOEDV:";
				break;
			case POLICYRENEWAL:
				dwellingBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
				protectionDetailsBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingProtectionDetailsHOEDV:";
				aiBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HOAdditionalInterestDetailsHOEDV:";
				break;
			case POLICYCHANGE:
				dwellingBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
				break;

		}
	}

	public DwellingConstruction next()
	{
		sh.waitForNoMask(20);
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return new DwellingConstruction(sh,path);
	}

	public Dwelling setYearBuilt(String yearBuilt)
	{
		sh.setText(by.yearBuilt, yearBuilt);
		sh.waitForNoMask();
		return this;
	}
	public String getYearBuilt()
	{
		return sh.getValue(by.yearBuilt);
	}

	public Dwelling setDistanceToFireHydrant(String distanceToFireHydrant)
	{
		sh.waitForNoMask();
		sh.setText(by.distanceToFireHydrant, distanceToFireHydrant);
		if(path != Path.POLICYRENEWAL)
			sh.waitForValue(by.territoryCode,10);

		return this;
	}

	public String getDistanceToFireHydrant()
	{
		return sh.getValue(by.distanceToFireHydrant);
	}


	public Dwelling setDistanceToFireStation(String distanceToFireStation)
	{
		sh.waitForNoMask(5);
		sh.setText(by.distanceToFireStation, distanceToFireStation);
		return this;
	}
	public String getDistanceToFireStation()
	{
		return sh.getValue(by.distanceToFireStation);
	}

	public Dwelling setBCEG(String bceg)
	{
		sh.setText(by.bceg,bceg);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getBCEG()
	{
		return sh.getValue(by.bceg);
	}

	public Dwelling setProtectionClassCode(String pcc)
	{
		sh.setText(by.protectionClassCode, pcc);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getProtectionClassCode()
	{
		return sh.getValue(by.protectionClassCode);
	}

	public Dwelling setTerritoryCode(String code)
	{
		sh.setText(by.territoryCode, code);
		if(path != Path.POLICYRENEWAL)
			sh.waitForValue(by.bceg,10);
		sh.waitForNoMask();
		return this;
	}
	public String getTerritoryCode()
	{
		return sh.getValue(by.territoryCode);
	}


	public String getLocationName()
	{
		return sh.getValue(by.locationName);
	}

	public Dwelling setLocationName(String locationName)
	{
		sh.setText(by.locationName, locationName);
		sh.tab();
		return this;
	}

	public String getLocalTaxJurisdiction()
	{
		return sh.getValue(by.localTaxJurisdiction);
	}

	public Dwelling setLocalTaxJurisdiction(String localTaxJurisdiction)
	{
		sh.setText(by.localTaxJurisdiction, localTaxJurisdiction);
		return this;
	}

	public String getLocationType()
	{
		return sh.getValue(by.locationType);
	}

	public Dwelling setLocationType(String locationType)
	{
		sh.setText(by.locationType, locationType);
		sh.tab();
		return this;
	}

	public String getDistanceToCoast()
	{
		return sh.getValue(by.distanceToCoast);
	}

	public Dwelling setDistanceToCoast(String distanceToCoast)
	{
		sh.setText(by.distanceToCoast, distanceToCoast);
		return this;
	}

	public String getPurchaseDate()
	{
		return sh.getValue(by.purchaseDate);
	}

	public Dwelling setPurchaseDate(String purchaseDate)
	{
		sh.setText(by.purchaseDate, purchaseDate);
		sh.tab();
		return this;
	}

	public String getPurchasePrice()
	{
		return sh.getValue(by.purchasePrice);
	}

	public Dwelling setPurchasePrice(String purchasePrice)
	{
		sh.setText(by.purchasePrice, purchasePrice);
		return this;
	}

	public String getMarketValue()
	{
		return sh.getValue(by.marketValue);
	}

	public Dwelling setMarketValue(String marketValue)
	{
		sh.setText(by.marketValue, marketValue);
		return this;
	}

	public String getResidenceType()
	{
		return sh.getValue(by.residenceType);
	}

	public Dwelling setResidenceType(String residenceType)
	{
		sh.setText(by.residenceType, residenceType);
		sh.tab();
		return this;
	}

	public String getDwellingUsage()
	{
		return sh.getValue(by.dwellingUsage);
	}

	public Dwelling setDwellingUsage(String dwellingUsage)
	{
		sh.setText(by.dwellingUsage, dwellingUsage);
		sh.tab();
		return this;
	}

	public String getDwellingOccupancy()
	{
		return sh.getValue(by.dwellingOccupancy);
	}

	public Dwelling setDwellingOccupancy(String dwellingOccupancy)
	{
		sh.setText(by.dwellingOccupancy, dwellingOccupancy);
		sh.tab();
		return this;
	}

	public String getHousekeepingCondition()
	{
		return sh.getValue(by.housekeepingCondition);
	}

	public Dwelling setHousekeepingCondition(String housekeepingCondition)
	{
		sh.setText(by.housekeepingCondition, housekeepingCondition);
		sh.tab();
		return this;
	}

	public Dwelling setInTheWindpool(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsInWindpool_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsInWindpool_fli_false-inputEl"));
		return this;
	}
	public Dwelling setOwnedByOther(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_false-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setOccupiedDaily(boolean flag)
	{
		if(flag)
			sh.clickElement(By.id(dwellingBase + "IsOccupiedDaily_fli_true-inputEl"));
		else
			sh.clickElement(By.id(dwellingBase + "IsOccupiedDaily_fli_false-inputEl"));
		return this;
	}
	public Dwelling selectYesForAllOptions()
	{
		List<WebElement> buttons = sh.driver.findElements(by.allCheckBoxesYes);
		for(WebElement box:buttons)
		{
			sh.waitForNoMask();
			sh.wait(5).until(ExpectedConditions.elementToBeClickable(box));
			box.click();
		}
		return this;
	}

	public Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(boolean flag)
	{
		if(flag)
			sh.clickElement(by.ownedByLLCYes);
		else
			sh.clickElement(by.ownedByLLCNo);
		sh.waitForNoMask();
		return this;
	}
	public ProtectionDetails clickProtectionDetails()
	{
		sh.clickElement(by.protectionDetails);
		sh.waitForNoMask();
		return new ProtectionDetails(sh,path);
	}


	public Dwelling clickAdditionalInterests()
	{
		sh.clickElement(by.additionalInterests);
		return this;
	}
	public Dwelling setSwimmingPool(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "SwimmingPoolExists_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}

	public Dwelling setTrampolineOnPremises(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "TrampolineExists_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}

	public Dwelling setSkateboardBicycleRampOnPremises(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasBikeRamp_fli_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setAnimalsOrExoticPets(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "AnimalsInDwelling_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setGolfCarts(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasOwnedGolfCarts_fli_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setRecreationalVehiclesOwned(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasOwnedRecVehicles_fli_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setPoolFenced(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "PropertyFenced_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setDivingBoard(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "DivingBoard_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public Dwelling setPoolSlide(boolean flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasSwimmingPoolSlide_fli_" + String.valueOf(flag) + "-inputEl"));
		sh.waitForNoMask();
		return this;
	}
	public String getPoolLocation()
	{
		return sh.getValue(by.poolLocation);
	}
	
	public Dwelling setPoolLocation(String poolLocation)
	{
		sh.setText(by.poolLocation, poolLocation);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}
	public String getFenceType()
	{
		return sh.getValue(by.fenceType);
	}
	
	public Dwelling setFenceType(String fenceType)
	{
		sh.setText(by.fenceType, fenceType);
		sh.tab();
		sh.waitForNoMask();
		return this;
	}


	public class DwellingBy{

							//*********************************************************************************//
							// Radio button locators are created and handled in their own individual methods.  //
							//*********************************************************************************//

		final By			locationName = By.id(dwellingBase + "HODwellingLocationHOEInputSet:HODwellingLocationInput-inputEl"),
								yearBuilt = By.id(dwellingBase + "YearBuilt-inputEl"),
								distanceToFireHydrant = By.id(dwellingBase + "DistanceToFireHydrant-inputEl"),
								distanceToFireStation = By.id(dwellingBase + "DistanceToFireStation-inputEl"),
								territoryCode = By.id(dwellingBase + "TerritoryCodeInputSet:0:TerritoryCode-inputEl"),
								localTaxJurisdiction = By.id(dwellingBase + "LocalTaxJurisdictionId-inputEl"),
								bceg = By.id(dwellingBase + "BCEG_fli-inputEl"),
								protectionClassCode = By.id(dwellingBase + "HOProtectionClassCode_fli-inputEl"),
								locationType = By.id(dwellingBase + "DwellingLocation-inputEl"),
								distanceToCoast = By.id(dwellingBase + "DistanceToCoast_fli-inputEl"),
								purchaseDate = By.id(dwellingBase + "PurchaseDate_fli-inputEl"),
								purchasePrice = By.id(dwellingBase + "PurchasePrice_fli-inputEl"),
								marketValue = By.id(dwellingBase + "MarketValue_fli-inputEl"),
								residenceType = By.id(dwellingBase + "ResidenceType-inputEl"),
								dwellingUsage = By.id(dwellingBase + "DwellingUsage-inputEl"),
								dwellingOccupancy = By.id(dwellingBase + "Occupancy-inputEl"),
								housekeepingCondition = By.id(dwellingBase + "HousekeepingCondition_fli-inputEl"),
								ownedByLLCYes = By.id(dwellingBase + "IsRiskOwnedByLLC_fli_true-inputEl"),
								ownedByLLCNo = By.id(dwellingBase + "IsRiskOwnedByLLC_fli_false-inputEl"),
								allCheckBoxesYes = By.xpath(".//input[contains(@id, 'true')]"),
								poolLocation = By.id(dwellingBase + "SwimmingPoolType_fli-inputEl"),
								fenceType = By.id(dwellingBase + "SwimmingPoolFenceType_fli-inputEl"),
								exoticAnimalTableID = By.id(dwellingBase + "1"),


								// Protection Details
								protectionDetails = By.id(tabBase + "DwellingSingleProtectionIdTab-btnInnerEl"),






								// Additional Interests
								additionalInterests = By.id(tabBase + "DwellingAdditionalInterestIdTab-btnInnerEl");




	}

	public class ExoticAnimalTable extends TableBase
	{
		private ExoticAnimalTable(CenterSeleniumHelper sh)
		{
			super(by.exoticAnimalTableID, sh);
		}

		public ExoticAnimalTable setType()
		{

			return this;
		}
	}

	public class ProtectionDetails extends CenterPanelBase
	{
		private ProtectionDetailsBy by;
		public ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by= new ProtectionDetailsBy();
		}

		public void setID(Path path)
		{
			switch(path)
			{
				case SUBMISSION:
					tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
					protectionDetailsBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingProtectionDetailsHOEDV:";
					break;
				case POLICYRENEWAL:
					tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
					protectionDetailsBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingProtectionDetailsHOEDV:";
					break;
				case POLICYCHANGE:
					dwellingBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:";
					break;

			}
		}
		public class ProtectionDetailsBy
		{
			final By	alarmType = By.id(protectionDetailsBase + "BurglarAlarmType-inputEl"),
						fireAlarmType = By.id(protectionDetailsBase + "FireAlarmType_fli-inputEl"),
						sprinklerSystemType = By.id(protectionDetailsBase + "SprinklerSystemType-inputEl"),
						additionalInterests = By.id(tabBase + "DwellingAdditionalInterestIdTab-btnInnerEl"),
						detailsTab = By.id(tabBase + "DwellingDetailsSingleIDTab-btnInnerEl");

		}
		public AdditionalInterests clickAdditionalInterests()
		{
			sh.clickElement(by.additionalInterests);
			return new AdditionalInterests(sh, path);
		}
		public Dwelling clickDetailsTab()
		{
			sh.clickElement(by.detailsTab);
			return new Dwelling(sh, path);
		}
		public DwellingConstruction next()
		{
			sh.waitForNoMask();
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return new DwellingConstruction(sh,path);
		}


		public ProtectionDetails setBurglarAlarm(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "BurglarAlarm_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setLockedPrivacyFence(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasLockedPrivacyFence_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setBurglarBarsOnWindows(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasBurglarBars_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setCommunityGuarded(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasSecurityGuards_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setGatedCommunity(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "IsGatedCommunity_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setFireAlarm(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "FireAlarm_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setSmokeAlarm(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "SmokeAlarm_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setFireExtinguishers(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "FireExtinguishers_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setSprinklerSystem(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasSprinklerSystem_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public ProtectionDetails setDeadbolts(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "Deadbolts_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}


		public ProtectionDetails setResidenceVisibleToNeighbors(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "VisibleToNeighbors_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}
		public ProtectionDetails safetyLatchesPresent(boolean flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasBurglarBarSafetyLatches_fli_" + String.valueOf(flag) + "-inputEl"));
			sh.waitForNoMask();
			return this;
		}

		public String getAlarmType()
		{
			return sh.getValue(by.alarmType);
		}

		public ProtectionDetails setAlarmType(String alarmType)
		{
			sh.setText(by.alarmType, alarmType);
			sh.tab();
			return this;
		}
		public String getFireAlarmType()
		{
			return sh.getValue(by.fireAlarmType);
		}

		public ProtectionDetails setFireAlarmType(String fireAlarmType)
		{
			sh.setText(by.fireAlarmType, fireAlarmType);
			sh.tab();
			return this;
		}
		public String getSprinklerSystemType()
		{
			return sh.getValue(by.sprinklerSystemType);
		}

		public ProtectionDetails setSprinklerSystemType(String sprinklerSystemType)
		{
			sh.setText(by.sprinklerSystemType, sprinklerSystemType);
			sh.tab();
			return this;
		}




	}

	public class AdditionalInterests extends CenterPanelBase
	{
		private AdditionalInterestsBy by;
		public AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new AdditionalInterestsBy();
		}

		public void setID(Path path)
		{
			switch(path)
			{
				case SUBMISSION:
					tabBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
					aiBase = "SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HOAdditionalInterestDetailsHOEDV:";
					break;
				case POLICYRENEWAL:
					tabBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
					aiBase = "RenewalWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HOAdditionalInterestDetailsHOEDV:";
					break;
				case POLICYCHANGE:
					break;

			}
		}

		public class AdditionalInterestsBy
		{
			final By 	add = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton-btnInnerEl"),
						newPerson = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:1:ContactType-textEl"),
						newCompany = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:0:ContactType-textEl"),
						fromAddressBook = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:AddFromSearch-textEl"),
						remove = By.id(aiBase + "AdditionalInterestLV_tb:Remove-btnInnerEl");
		}
		public NewAdditionalInterest clickAddNewPerson()
		{
			sh.clickElement(by.add);
			sh.clickElement(by.newPerson);
			return new NewAdditionalInterest(sh, path);
		}

		public NewAdditionalInterest clickAddNewCompany()
		{
			sh.clickElement(by.add);
			sh.clickElement(by.newCompany);
			return new NewAdditionalInterest(sh, path);
		}
		public AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			sh.clickElement(By.xpath(aiBase + "AdditionalInterestLV-body']//div[text()= '" + typeEffectiveDateLoanNumber + "']/../..//img"));
			return this;
		}
		public AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			sh.clickElement(By.xpath(aiBase + "AdditionalInterestLV-body']//a[text()= '" + name + "']/../../..//img"));
			return this;
		}

		public DwellingConstruction next()
		{
			sh.waitForNoMask(20);
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return new DwellingConstruction(sh,path);
		}

	}

}