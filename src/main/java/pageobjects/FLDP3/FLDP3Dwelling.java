package pageobjects.FLDP3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;


/**
 * Created by aansari on 2/2/17.
 */
public class FLDP3Dwelling extends Dwelling<FLDP3Dwelling>
{
	public FLDP3Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLDP3DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new FLDP3DwellingConstruction(sh, path);
	}
	public FLDP3Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}


	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public FLDP3Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public FLDP3Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public FLDP3Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public FLDP3Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}
	public FLDP3Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public FLDP3Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public FLDP3Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public FLDP3Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public FLDP3Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public FLDP3Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public FLDP3Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public FLDP3Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public FLDP3Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public FLDP3Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public FLDP3Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public FLDP3Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public FLDP3Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public FLDP3Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public FLDP3Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public FLDP3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public FLDP3ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new FLDP3ProtectionDetails(sh, path);
	}
	public FLDP3AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new FLDP3AdditionalInterests(sh, path);
	}
	public FLDP3Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public FLDP3Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public FLDP3Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public FLDP3Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public FLDP3Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public FLDP3Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public FLDP3Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public FLDP3Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public FLDP3Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public FLDP3Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public FLDP3Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public FLDP3Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public FLDP3LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new FLDP3LocationInformation(sh, path);
	}
	public FLDP3LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new FLDP3LocationInformation(sh, path);
	}

	public class FLDP3ProtectionDetails extends ProtectionDetails<FLDP3ProtectionDetails>
	{
		public FLDP3ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public FLDP3AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new FLDP3AdditionalInterests(sh, path);

		}
		public FLDP3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLDP3Dwelling(sh, path);
		}
		public FLDP3DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new FLDP3DwellingConstruction(sh, path);
		}
		public FLDP3ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public FLDP3ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public FLDP3ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public FLDP3ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public FLDP3ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public FLDP3ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public FLDP3ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public FLDP3ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public FLDP3ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public FLDP3ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public FLDP3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public FLDP3ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public FLDP3ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public FLDP3ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public FLDP3ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class FLDP3AdditionalInterests extends AdditionalInterests<FLDP3AdditionalInterests>
	{
		public FLDP3AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public FLDP3ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new FLDP3ProtectionDetails(sh, path);
		}

		public FLDP3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLDP3Dwelling(sh, path);
		}
		public FLDP3AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public FLDP3NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new FLDP3NewAdditionalInterest(sh,path);
		}
		public FLDP3NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new FLDP3NewAdditionalInterest(sh,path);
		}
		public FLDP3SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new FLDP3SearchAddressBook(sh,path);
		}
		public FLDP3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public FLDP3AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public FLDP3AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public FLDP3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public FLDP3AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public FLDP3DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new FLDP3DwellingConstruction(sh, path);
		}






	}









}
