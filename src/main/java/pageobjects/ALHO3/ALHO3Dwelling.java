package pageobjects.ALHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;


/**
 * Created by aansari on 2/2/17.
 */
public class ALHO3Dwelling extends Dwelling<ALHO3Dwelling>
{
	public ALHO3Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public ALHO3DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new ALHO3DwellingConstruction(sh, path);
	}
	public ALHO3Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}

	public ALHO3Dwelling Enter(){
		return super.Enter();
	}

	public String getdwellingErrorMessage()
	{
		return super.dwellingErrorMessage();
	}

	public ALHO3Quote clickDwellingquote()
	{
		super.DwellingQuote();
		return new ALHO3Quote(sh, path);
	}

	public ALHO3PreQuoteIssues clickDwellingquoteissue()
	{
		super.DwellingQuote();
		return new ALHO3PreQuoteIssues(sh, path);
	}


	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public ALHO3Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public ALHO3Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public ALHO3Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public ALHO3Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}

	public ALHO3Dwelling waitForProtectionClassCode(String val)
	{
		super.waitForProtectionClassToUpdate(val);
		return new ALHO3Dwelling(sh, path);
	}

	public ALHO3Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}


	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public ALHO3Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public ALHO3Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public ALHO3Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public ALHO3Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public ALHO3Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public ALHO3Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public ALHO3Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public ALHO3Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public ALHO3Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public ALHO3Dwelling clickDwellingLeftMenu()
	{
		super.clickDwellingLeft();
		return new ALHO3Dwelling(sh, path);
	}

	public ALHO3Dwelling clickDwellingBack()
	{
		super.clickDwellingLeft();
		return new ALHO3Dwelling(sh, path);
	}

	public ALHO3PolicyInfo back()
	{
		super.clickBack();
		return new ALHO3PolicyInfo(sh, path);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public ALHO3Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public ALHO3Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public ALHO3Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public ALHO3Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public ALHO3Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public ALHO3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public ALHO3ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new ALHO3ProtectionDetails(sh, path);
	}
	public ALHO3AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new ALHO3AdditionalInterests(sh, path);
	}
	public ALHO3Dwelling setMinimumRentalIncrement(String text)
	{
		return super.setMinimumRentalIncrement(text);
	}

	public String getMinimumRentalIncrement()
	{
		return super.getMinimumRentalIncrement();
	}
	public ALHO3Dwelling underContractWithRentalManagementCompany(String flag)
	{
		return super.underContractWithRentalManagementCompany(flag);
	}
	public ALHO3Dwelling setWeeksRentedAnnually(String text)
	{
		return super.setWeeksRentedAnnually(text);
	}

	public String getWeeksRentedAnnually()
	{
		return super.getWeeksRentedAnnually();
	}

	public ALHO3Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public ALHO3Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public ALHO3Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public ALHO3Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public ALHO3Dwelling addexocticAnimal(){return super.addExoticAnimal();}
	public ALHO3Dwelling removeexoticAnimal(){return super.removeExoticAnimal();}
	public ALHO3Dwelling checkexoticAnimalRow(int rowNumber){return super.checkExoticAnimalRow(rowNumber);}
	public ALHO3Dwelling setexoticAnimalType(int rowNumber, String type ){return super.setExoticAnimalType(rowNumber, type);}
	public ALHO3Dwelling setexoticAnimalBreed(int rowNumber, String breed ){return super.setExoticAnimalBreed(rowNumber, breed);}
	public ALHO3Dwelling setexoticAnimalDescription(int rowNumber, String description ){return super.setExoticAnimalDescription(rowNumber, description);}
	public ALHO3Dwelling setexoticAnimalBiteHistory(int rowNumber, String flag ){return super.setExoticAnimalBiteHistory(rowNumber, flag);}



	public ALHO3Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public ALHO3Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public ALHO3Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public ALHO3Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public ALHO3Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public ALHO3Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public ALHO3Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public ALHO3Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public ALHO3LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new ALHO3LocationInformation(sh, path);
	}
	public ALHO3LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new ALHO3LocationInformation(sh, path);
	}

	public class ALHO3ProtectionDetails extends ProtectionDetails<ALHO3ProtectionDetails>
	{
		public ALHO3ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public ALHO3AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new ALHO3AdditionalInterests(sh, path);

		}
		public ALHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new ALHO3Dwelling(sh, path);
		}
		public ALHO3DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new ALHO3DwellingConstruction(sh, path);
		}

		public String getProtectiondwellingErrorMessage()
		{
			return  super.dwellingProtectionErrorMessage();
		}
		public ALHO3ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public ALHO3ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public ALHO3ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public ALHO3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}
		public ALHO3ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public ALHO3ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public ALHO3ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public ALHO3ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public ALHO3ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public ALHO3ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public ALHO3ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public ALHO3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public ALHO3ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public ALHO3ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public ALHO3ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class ALHO3AdditionalInterests extends AdditionalInterests<ALHO3AdditionalInterests>
	{
		public ALHO3AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public ALHO3ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new ALHO3ProtectionDetails(sh, path);
		}

		public ALHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new ALHO3Dwelling(sh, path);
		}
		public ALHO3AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public ALHO3NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new ALHO3NewAdditionalInterest(sh,path);
		}
		public ALHO3NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new ALHO3NewAdditionalInterest(sh,path);
		}
		public ALHO3SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new ALHO3SearchAddressBook(sh,path);
		}
		public ALHO3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public ALHO3AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public ALHO3AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public ALHO3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public ALHO3AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public ALHO3DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new ALHO3DwellingConstruction(sh, path);
		}






	}









}
