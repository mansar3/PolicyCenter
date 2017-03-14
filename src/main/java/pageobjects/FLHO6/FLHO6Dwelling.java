package pageobjects.FLHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;


/**
 * Created by aansari on 2/2/17.
 */
public class FLHO6Dwelling extends Dwelling<FLHO6Dwelling>
{
	public FLHO6Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO6DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new FLHO6DwellingConstruction(sh, path);
	}
	public FLHO6Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}

	public FLHO6Dwelling Enter(){
		return super.Enter();
	}
	public String getdwellingErrorMessage()
	{
		return super.dwellingErrorMessage();
	}
	public FLHO6Quote clickDwellingquote()
	{
		super.DwellingQuote();
		return new FLHO6Quote(sh, path);
	}

	public FLHO6PreQuoteIssues clickDwellingquoteissue()
	{
		super.DwellingQuote();
		return new FLHO6PreQuoteIssues(sh, path);
	}


	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public FLHO6Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public FLHO6Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public FLHO6Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public FLHO6Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}
	public FLHO6Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public FLHO6Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public FLHO6Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public FLHO6Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public FLHO6Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public FLHO6Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public FLHO6Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public FLHO6Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public FLHO6Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public FLHO6Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public FLHO6Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public FLHO6Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public FLHO6Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public FLHO6Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public FLHO6Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public FLHO6Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}

	public FLHO6Dwelling clickDwellingBack()
	{
		super.clickDwellingLeft();
		return new FLHO6Dwelling(sh, path);
	}

	public FLHO6ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new FLHO6ProtectionDetails(sh, path);
	}
	public FLHO6AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new FLHO6AdditionalInterests(sh, path);
	}
	public FLHO6Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public FLHO6Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public FLHO6Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public FLHO6Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public FLHO6Dwelling addexocticAnimal(){return super.addExoticAnimal();}
	public FLHO6Dwelling removeexoticAnimal(){return super.removeExoticAnimal();}
	public FLHO6Dwelling checkexoticAnimalRow(int rowNumber){return super.checkExoticAnimalRow(rowNumber);}
	public FLHO6Dwelling setexoticAnimalType(int rowNumber, String type ){return super.setExoticAnimalType(rowNumber, type);}
	public FLHO6Dwelling setexoticAnimalBreed(int rowNumber, String breed ){return super.setExoticAnimalBreed(rowNumber, breed);}
	public FLHO6Dwelling setexoticAnimalDescription(int rowNumber, String description ){return super.setExoticAnimalDescription(rowNumber, description);}
	public FLHO6Dwelling setexoticAnimalBiteHistory(int rowNumber, String flag ){return super.setExoticAnimalBiteHistory(rowNumber, flag);}
	public FLHO6Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public FLHO6Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public FLHO6Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public FLHO6Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public FLHO6Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public FLHO6Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public FLHO6Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public FLHO6Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public FLHO6LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new FLHO6LocationInformation(sh, path);
	}
	public FLHO6LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new FLHO6LocationInformation(sh, path);
	}

	public class FLHO6ProtectionDetails extends ProtectionDetails<FLHO6ProtectionDetails>
	{
		public FLHO6ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public FLHO6AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new FLHO6AdditionalInterests(sh, path);

		}
		public FLHO6Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLHO6Dwelling(sh, path);
		}
		public FLHO6DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new FLHO6DwellingConstruction(sh, path);
		}
		public FLHO6ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public FLHO6ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public FLHO6ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public FLHO6ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public FLHO6ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public FLHO6ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public FLHO6ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public FLHO6ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public FLHO6ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public FLHO6ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public FLHO6ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public FLHO6ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

		public FLHO6ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public FLHO6ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public FLHO6ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public FLHO6ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class FLHO6AdditionalInterests extends AdditionalInterests<FLHO6AdditionalInterests>
	{
		public FLHO6AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public FLHO6ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new FLHO6ProtectionDetails(sh, path);
		}

		public FLHO6Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLHO6Dwelling(sh, path);
		}
		public FLHO6AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public FLHO6NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new FLHO6NewAdditionalInterest(sh,path);
		}
		public FLHO6NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new FLHO6NewAdditionalInterest(sh,path);
		}
		public FLHO6SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new FLHO6SearchAddressBook(sh,path);
		}
		public FLHO6AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public FLHO6AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public FLHO6AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public FLHO6AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public FLHO6AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public FLHO6DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new FLHO6DwellingConstruction(sh, path);
		}






	}









}
