package pageobjects.WizardPanelBase;

import Helpers.CenterSeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Dwelling<T extends Dwelling> extends CenterPanelBase
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
		System.out.println("Navigated to page: " + expectedPanelTitle);
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
				tabBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:";
				protectionDetailsBase = "PolicyChangeWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingProtectionDetailsHOEDV:";
				break;

		}
	}

	protected T DwellingConstructionNext()
	{
		sh.waitForNoMask(20);
		sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
		return (T)this;
	}


	protected T setYearBuilt(String yearBuilt)
	{
		sh.setText(by.yearBuilt, yearBuilt);
		sh.waitForNoMask();
		return (T)this;
	}

	protected  T Enter ()
    {
	      sh.driver.findElement(By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:HODwellingSingleHOEPanelSet:HODwellingDetailsHOEDV:YearBuilt-inputEl")).sendKeys(Keys.ENTER);
		  sh.waitForNoMask(10);
	return (T)this;
    }
	protected String getYearBuilt()
	{
		return sh.getValue(by.yearBuilt);
	}


	protected T setDistanceToFireHydrant(String distanceToFireHydrant)
	{
		sh.waitForNoMask();
		sh.setText(by.distanceToFireHydrant, distanceToFireHydrant);
		sh.tab();
		sh.waitForNoMask();
//		if(path != Path.POLICYRENEWAL)
//			sh.waitForValue(by.territoryCode,10);

		return (T)this;
	}

	protected String getDistanceToFireHydrant()
	{
		return sh.getValue(by.distanceToFireHydrant);
	}


	protected T clickDwellingLeft()
{
	sh.clickElement(by.dwellingLeftMenu);
	return (T)this;
}


	protected  T clickDwellingSaveDraft()
	{
		sh.clickElement(by.saveDraft);
		sh.waitForNoMask();
		return (T) this;

	}

	protected T setDistanceToFireStation(String distanceToFireStation)
	{
		sh.waitForNoMask();
		sh.setText(by.distanceToFireStation, distanceToFireStation);
		return (T)this;
	}
	protected String getDistanceToFireStation()
	{
		return sh.getValue(by.distanceToFireStation);
	}

	protected T setBCEG(String bceg)
	{

		sh.setText(by.bceg,bceg);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getBCEG()
	{
		return sh.getValue(by.bceg);
	}

	protected T setProtectionClassCode(String pcc)
	{
		sh.setText(by.protectionClassCode, pcc);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getProtectionClassCode()
	{
		return sh.getValue(by.protectionClassCode);
	}

	protected T setTerritoryCode(String code)
	{
		sh.setText(by.territoryCode, code);
		sh.tab();
		sh.waitForNoMask();

//		if(path != Path.POLICYRENEWAL)
//			if(sh.getText(by.bceg) == "")
//				sh.waitForValue(by.bceg,10);

		return (T)this;
	}

	protected T waitForProtectionClassToUpdate(String val)
	{
		sh.waitForValueToBeVal(by.protectionClassCode, val);
		return (T)this;
	}

	protected String getTerritoryCode()
	{
		return sh.getValue(by.territoryCode);
	}


	protected String getLocationName()
	{
		return sh.getValue(by.locationName);
	}

	protected T setLocationName(String locationName)
	{
		sh.setText(by.locationName, locationName);
		sh.tab();
		return (T)this;
	}

	protected String getLocalTaxJurisdiction()
	{
		return sh.getValue(by.localTaxJurisdiction);
	}

	protected T setLocalTaxJurisdiction(String localTaxJurisdiction)
	{
		sh.setText(by.localTaxJurisdiction, localTaxJurisdiction);
		return (T)this;
	}

	protected String getLocationType()
	{
		return sh.getValue(by.locationType);
	}

	protected T setLocationType(String locationType)
	{
		sh.setText(by.locationType, locationType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getDistanceToCoast()
	{
		return sh.getValue(by.distanceToCoast);
	}

	protected T setDistanceToCoast(String distanceToCoast)
	{
		sh.setText(by.distanceToCoast, distanceToCoast);
		return (T)this;
	}

	protected String getPurchaseDate()
	{
		return sh.getValue(by.purchaseDate);
	}

	protected T setPurchaseDate(String purchaseDate)
	{
		sh.setText(by.purchaseDate, purchaseDate);
		sh.tab();
		return (T)this;
	}

	protected String getPurchasePrice()
	{
		return sh.getValue(by.purchasePrice);
	}

	protected T setPurchasePrice(String purchasePrice)
	{
		sh.setText(by.purchasePrice, purchasePrice);
		return (T)this;
	}

	protected String getMarketValue()
	{
		return sh.getValue(by.marketValue);
	}

	protected T setMarketValue(String marketValue)
	{
		sh.setText(by.marketValue, marketValue);
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getResidenceType()
	{
		return sh.getValue(by.residenceType);
	}

	protected T setResidenceType(String residenceType)
	{
		sh.setText(by.residenceType, residenceType);
		sh.tab();
		return (T)this;
	}

	protected String getDwellingUsage()
	{
		return sh.getValue(by.dwellingUsage);
	}

	protected T setDwellingUsage(String dwellingUsage)
	{
		sh.setTextAndTab(by.dwellingUsage, dwellingUsage);
		//sh.tab();
		return (T)this;
	}

	protected String getDwellingOccupancy()
	{
		return sh.getValue(by.dwellingOccupancy);
	}

	protected T setDwellingOccupancy(String dwellingOccupancy)
	{
		sh.setText(by.dwellingOccupancy, dwellingOccupancy);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getHousekeepingCondition()
	{
		return sh.getValue(by.housekeepingCondition);
	}

	protected T setHousekeepingCondition(String housekeepingCondition)
	{
		sh.setText(by.housekeepingCondition, housekeepingCondition);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected String getMobileHomePark() {return sh.getValue(by.mobileHomePark);}

	protected  T setMobileHomePark(String mobileHomePark) {
		sh.setText(by.mobileHomePark, mobileHomePark );
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}

	protected T setInTheWindpool(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "IsInWindpool_fli_"+ flag.toLowerCase() + "-inputEl"));
		return (T)this;
	}
	protected T setOwnedByOther(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setOccupiedDaily(String flag)
	{

		sh.clickElement(By.id(dwellingBase + "IsOccupiedDaily_fli_" + flag.toLowerCase() + "-inputEl"));
		return (T)this;
	}
	protected T setPurchasedNew(String flag)
	{

		sh.clickElement(By.id(dwellingBase + "IsPurchasedNew_fli_" + flag.toLowerCase() + "-inputEl"));
		return (T)this;
	}


	protected T setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "IsRiskOwnedByLLC_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T clickProtectionDetailsTab()
	{
		sh.waitForNoMask();
		sh.clickElement(by.protectionDetails);
		sh.waitForNoMask();
		return (T)this;
	}


	protected T clickAdditionalInterestsTab()
	{
		sh.clickElement(by.additionalInterests);
		return (T)this;
	}
	protected T setSwimmingPool(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "SwimmingPoolExists_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}

	protected T setTrampolineOnPremises(String flag)
	{
		sh.waitForNoMask();
		sh.clickElement(By.id(dwellingBase + "TrampolineExists_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}

	protected T setSkateboardBicycleRampOnPremises(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasBikeRamp_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setAnimalsOrExoticPets(String flag)
	{
		//I am clicking here twice because this radio button is not clicking in one time.
		sh.clickElement(By.id(dwellingBase + "AnimalsInDwelling_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		sh.clickElement(By.id(dwellingBase + "AnimalsInDwelling_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setGolfCarts(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasOwnedGolfCarts_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setRecreationalVehiclesOwned(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasOwnedRecVehicles_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setPoolFenced(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "PropertyFenced_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setDivingBoard(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "DivingBoard_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected T setPoolSlide(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "HasSwimmingPoolSlide_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getPoolLocation()
	{
		return sh.getValue(by.poolLocation);
	}
	
	protected T setPoolLocation(String poolLocation)
	{
		sh.setText(by.poolLocation, poolLocation);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getFenceType()
	{
		return sh.getValue(by.fenceType);
	}
	
	protected T setFenceType(String fenceType)
	{
		sh.setText(by.fenceType, fenceType);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getWindpoolZone()
	{
		return sh.getValue(by.windpoolZone);
	}
	
	protected T setWindpoolZone(String windpoolZone)
	{
		sh.setText(by.windpoolZone, windpoolZone);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected T addNewDwellingLocation()
	{
		sh.clickElement(by.locationDropDown);
		sh.clickElement(by.newLocation);
		return (T)this;
	}
	protected T editDwellingLocation()
	{
		sh.clickElement(by.locationDropDown);
		sh.clickElement(by.editLocation);
		return (T)this;
	}
	protected String getMinimumRentalIncrement()
	{
		return sh.getValue(by.minimumRentalIncrement);
	}

	protected T setMinimumRentalIncrement(String minimumRentalIncrement)
	{
		sh.setText(by.minimumRentalIncrement, minimumRentalIncrement);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected T underContractWithRentalManagementCompany(String flag)
	{
		sh.clickElement(By.id(dwellingBase + "IsUnderRentalMgmtCompany_fli_" + flag.toLowerCase() + "-inputEl"));
		sh.waitForNoMask();
		return (T)this;
	}
	protected String getWeeksRentedAnnually()
	{
		return sh.getValue(by.weeksRentedAnnually);
	}

	protected String dwellingErrorMessage()

	{
		sh.waitForNoMask();
	    String Error=  sh.driver.findElement(By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:_msgs']//div")).getText();
		return  Error;
	}


	protected T setWeeksRentedAnnually(String weeksRentedAnnually)
	{
		sh.setText(by.weeksRentedAnnually, weeksRentedAnnually);
		sh.tab();
		sh.waitForNoMask();
		return (T)this;
	}
	protected T DwellingQuote(){
		sh.waitForNoMask();
		sh.clickElement(by.Quote);
		return (T) this;
	}
	protected T addExoticAnimal()
	{
		sh.clickElement(by.exoticAnimalTableAdd);
		sh.waitForNoMask();
		return (T)this;
	}
	protected T removeExoticAnimal()
	{
		sh.clickElement(by.exoticAnimalTableRemove);
		sh.waitForNoMask();
		return (T)this;
	}
	protected T checkExoticAnimalRow(int rowNumber)
	{
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[1]//img)[1]"));
		return (T)this;
	}

	protected T setExoticAnimalType(int rowNumber, String type)
	{
		sh.waitForNoMask();
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[2]//div)[1]"));
		sh.waitForElementToAppear(By.name("AnimalType"));
		sh.setText(By.name("AnimalType"), type);
		return (T)this;
	}

	protected T setExoticAnimalBreed(int rowNumber, String breed)
	{
		sh.waitForNoMask();
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[3]//div)[1]"));
		sh.waitForElementToAppear(By.name("AnimalBreed"));
		sh.setText(By.name("AnimalBreed"), breed);
		return (T)this;
	}

	protected T setExoticAnimalDescription(int rowNumber, String description)
	{
		sh.waitForNoMask();
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[2]//div)[1]"));
		// Description field will not change to an input field.
		return (T)this;
	}

	protected T setExoticAnimalBiteHistory(int rowNumber, String flag)
	{
		sh.waitForNoMask();
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[5]//input[@inputvalue = '" + flag.toLowerCase() + "'])[1]"));
		sh.waitForNoMask();
		sh.clickElement(By.xpath("(//*[@id = '" + dwellingBase + "AnimalListViewInput-tbody']//table[" + String.valueOf(rowNumber) + "]//td[5]//input[@inputvalue = '" + flag.toLowerCase() + "'])[1]"));
		return (T)this;
	}

	protected T editPolicyTransaction(){
		sh.waitForNoMask();
		sh.clickElement(by.editPolicyTransaction);
		return (T) this;
	}

	protected T accept()
	{
		sh.waitForElementToAppear(By.xpath(".//*[text()= 'OK']"));
		sh.clickElement(By.xpath(".//*[text()= 'OK']"));
		return (T) this;

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
		                        mobileHomePark = By.id(dwellingBase + "ManHomeParkCode_fli-inputEl"),
								allCheckBoxesYes = By.xpath(".//input[contains(@id, 'true')]"),
								poolLocation = By.id(dwellingBase + "SwimmingPoolType_fli-inputEl"),
								fenceType = By.id(dwellingBase + "SwimmingPoolFenceType_fli-inputEl"),
								exoticAnimalTableAdd = By.xpath("//*[@id ='" + dwellingBase + "AnimalListViewInput-tbody']//span[text() = 'A']"),
								exoticAnimalTableRemove = By.xpath("//*[@id ='" + dwellingBase + "AnimalListViewInput-tbody']//span[text() = 'R']"),
								windpoolZone = By.id(dwellingBase + "WindpoolType_fli-inputEl"),
								locationDropDown = By.id(dwellingBase + "HODwellingLocationHOEInputSet:HODwellingLocationInput:HODwellingLocationInputMenuIcon"),
								newLocation = By.id(dwellingBase + "HODwellingLocationHOEInputSet:HODwellingLocationInput:NewGarageLocation-itemEl"),
								editLocation = By.id(dwellingBase + "HODwellingLocationHOEInputSet:HODwellingLocationInput:EditDwellingLocation-itemEl"),
								weeksRentedAnnually = By.id(dwellingBase + "WeeksRentedAnually_fli-inputEl"),
								minimumRentalIncrement = By.id(dwellingBase + "RentalIncrementType_fli-inputEl"),
								dwellingLeftMenu = By.id("SubmissionWizard:Prev-btnInnerEl"),
                 				Quote = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:JobWizardToolbarButtonSet:QuoteOrReview-btnInnerEl"),
		                        editPolicyTransaction = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:JobWizardToolbarButtonSet:EditPolicy-btnInnerEl"),
                                saveDraft = By.id("SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:JobWizardToolbarButtonSet:Draft-btnInnerEl"),
		//	ErrorMessage = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:_msgs']//div"),


								// Protection Details
								protectionDetails = By.id(tabBase + "DwellingSingleProtectionIdTab-btnInnerEl"),






								// Additional Interests
								additionalInterests = By.id(tabBase + "DwellingAdditionalInterestIdTab-btnInnerEl");




	}


	public class ProtectionDetails<T extends ProtectionDetails> extends CenterPanelBase
	{
		private ProtectionDetailsBy by;
		public ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by= new ProtectionDetailsBy();
			System.out.println("Navigated to page: Protection Details");
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
				     	ErrorMessage = By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:_msgs']//div"),
			            detailsTab = By.id(tabBase + "DwellingDetailsSingleIDTab-btnInnerEl");

		}
		protected T clickAdditionalInterestsTab()
		{
			sh.clickElement(by.additionalInterests);
			return (T)this;
		}

		protected String dwellingProtectionErrorMessage()

		{
			sh.waitForNoMask();
			String Error=  sh.driver.findElement(By.xpath(".//*[@id='SubmissionWizard:LOBWizardStepGroup:LineWizardStepSet:HODwellingHOEScreen:_msgs']//div")).getText();
			return  Error;
		}

		protected T clickDetailsTab()
		{
			sh.clickElement(by.detailsTab);
			return (T)this;
		}
		protected T dwellingConstructionNext()
		{
			sh.waitForNoMask();
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return (T)this;
		}


		protected T dwellingBack()
		{
			sh.waitForNoMask();
			sh.clickElement(By.cssSelector("[id*='Prev-btnInnerEl']"));
			return (T)this;
		}

		protected  T clickProtectionDetailsEnter ()
		{
			sh.driver.findElement(By.id("centerPanel")).sendKeys(Keys.ENTER);
			sh.waitForNoMask(10);
			return (T)this;
		}

		protected T setBurglarAlarm(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "BurglarAlarm_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setLockedPrivacyFence(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasLockedPrivacyFence_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setBurglarBarsOnWindows(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasBurglarBars_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setCommunityGuarded(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasSecurityGuards_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setGatedCommunity(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "IsGatedCommunity_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setFireAlarm(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "FireAlarm_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setSmokeAlarm(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "SmokeAlarm_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setFireExtinguishers(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "FireExtinguishers_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setSprinklerSystem(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasSprinklerSystem_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected T setDeadbolts(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "Deadbolts_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}


		protected T setResidenceVisibleToNeighbors(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "VisibleToNeighbors_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}
		protected T safetyLatchesPresent(String flag)
		{
			sh.clickElement(By.id(protectionDetailsBase + "HasBurglarBarSafetyLatches_fli_" + flag.toLowerCase() + "-inputEl"));
			sh.waitForNoMask();
			return (T)this;
		}

		protected String getBurglarAlarmType()
		{
			return sh.getValue(by.alarmType);
		}

		protected T setBurglarAlarmType(String alarmType)
		{
			sh.setText(by.alarmType, alarmType);
			sh.tab();
			return (T)this;
		}

		protected String getFireAlarmType()
		{
			return sh.getValue(by.fireAlarmType);
		}

		protected T setFireAlarmType(String fireAlarmType)
		{
			sh.setText(by.fireAlarmType, fireAlarmType);
			sh.tab();
			return (T)this;
		}
		protected String getSprinklerSystemType()
		{
			return sh.getValue(by.sprinklerSystemType);
		}

		protected T setSprinklerSystemType(String sprinklerSystemType)
		{
 			sh.setText(by.sprinklerSystemType, sprinklerSystemType);
			sh.tab();
			return (T)this;
		}




	}

	public class AdditionalInterests<T extends AdditionalInterests> extends CenterPanelBase
	{
		private AdditionalInterestsBy by;

		public AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			this.sh = sh;
			this.path = path;
			setID(path);
			by = new AdditionalInterestsBy();
			System.out.println("Navigated to page: Additional Interests");
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
			final By add = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton-btnInnerEl"),
			newPerson = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:1:ContactType-textEl"),
			newCompany = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:0:ContactType-textEl"),
			fromAddressBook = By.id(aiBase + "AdditionalInterestLV_tb:AddContactsButton:AddFromSearch-textEl"),
			remove = By.id(aiBase + "AdditionalInterestLV_tb:Remove-btnInnerEl"),

			protectionDetails = By.id(tabBase + "DwellingSingleProtectionIdTab-btnInnerEl"),
			detailsTab = By.id(tabBase + "DwellingDetailsSingleIDTab-btnInnerEl");
		}
		
		protected T clickProtectionDetailsTab()
		{
			sh.clickElement(by.protectionDetails);
			sh.waitForNoMask();
			return (T)this;
		}
		protected T clickDetailsTab()
		{
			sh.clickElement(by.detailsTab);
			sh.waitForNoMask();
			return (T)this;
		}


		protected T clickRemove()
		{
			sh.clickElement(by.remove);
			return (T)this;
		}

		protected T addNewPerson()
		{

			System.out.println("~~~~~~Adding a New Person for New Additional Interest~~~~~~~~");
			for(int i = 0; i<10; i++)
			{
				sh.clickElement(by.add);
				if(sh.isDisplayed(by.newPerson))
					break;
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}

				sh.clickElement(by.newPerson);

			return (T)this;
		}

		protected T addNewCompany()
		{
			for(int i = 0; i<10; i++)
			{
				sh.clickElement(by.add);
				if(sh.isDisplayed(by.newCompany))
					break;
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			sh.clickElement(by.newCompany);
			return (T)this;
		}

		protected T fromAddressBook()
		{
			for(int i = 0; i<10; i++)
			{
				sh.clickElement(by.add);
				if(sh.isDisplayed(by.fromAddressBook))
					break;
				try
				{
					// Added in because selenium would click drop down too quickly
					// and menu would not appear.
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}

			sh.clickElement(by.fromAddressBook);
			return (T)this;
		}

		protected T selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			sh.clickElement(By.xpath("//*[@id='" + aiBase + "AdditionalInterestLV-body']//div[text()= '" + typeEffectiveDateLoanNumber + "']/../..//img"));
			return (T)this;
		}

		protected T selectRowInAdditionalInterestByName(String name)
		{
			sh.clickElement(By.xpath("//*[@id='" + aiBase + "AdditionalInterestLV-body']//a[text()= '" + name + "']/../../..//img"));
			return (T)this;
		}

		protected T setType(int row, String type)
		{
			sh.clickElement(By.xpath("//*[@id = '" + aiBase + "AdditionalInterestLV-body']//table[" + row + "]//td[3]//div"));
			sh.setText(By.name("Type"),type);
			return (T)this;
		}

		protected T setEffectiveDate(int row, String effectiveDate)
		{
			sh.clickElement(By.xpath("//*[@id = '" + aiBase + "AdditionalInterestLV-body']//table[" + row + "]//td[4]//div"));
			sh.setText(By.name("EffectiveDate"),effectiveDate);
			return (T)this;
		}

		protected T setLoanNumber(int row, String loanNumber)
		{
			sh.clickElement(By.xpath("//*[@id = '" + aiBase + "AdditionalInterestLV-body']//table[" + row + "]//td[5]//div"));
			sh.setText(By.name("ContractNumber"),loanNumber);
			return (T)this;
		}

		protected T dwellingConstructionNext()
		{
			sh.waitForNoMask();
			sh.clickElement(By.cssSelector("[id*='Next-btnInnerEl']"));
			return (T)this;
		}

	}

}
