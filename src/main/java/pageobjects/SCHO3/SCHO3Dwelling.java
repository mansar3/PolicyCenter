package pageobjects.SCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO3Dwelling extends Dwelling<SCHO3Dwelling>
{
		public SCHO3Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO3DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new SCHO3DwellingConstruction(sh, path);
	}
	public SCHO3Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}

	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public SCHO3Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public SCHO3Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public SCHO3Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public SCHO3Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}
	public SCHO3Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public SCHO3Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public SCHO3Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public SCHO3Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public SCHO3Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public SCHO3Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public SCHO3Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public SCHO3Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public SCHO3Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public SCHO3Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public SCHO3Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public SCHO3Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public SCHO3Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public SCHO3Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public SCHO3Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public SCHO3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public SCHO3ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new SCHO3ProtectionDetails(sh, path);
	}
	public SCHO3AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new SCHO3AdditionalInterests(sh, path);
	}
	public SCHO3Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public SCHO3Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public SCHO3Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public SCHO3Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public SCHO3Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public SCHO3Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public SCHO3Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public SCHO3Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public SCHO3Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public SCHO3Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public SCHO3Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public SCHO3Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public SCHO3LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new SCHO3LocationInformation(sh, path);
	}
	public SCHO3LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new SCHO3LocationInformation(sh, path);
	}

	public class SCHO3ProtectionDetails extends ProtectionDetails<SCHO3ProtectionDetails>
	{
		public SCHO3ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public SCHO3AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new SCHO3AdditionalInterests(sh, path);

		}
		public SCHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO3Dwelling(sh, path);
		}
		public SCHO3DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new SCHO3DwellingConstruction(sh, path);
		}
		public SCHO3ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public SCHO3ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public SCHO3ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public SCHO3ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public SCHO3ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public SCHO3ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public SCHO3ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public SCHO3ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public SCHO3ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public SCHO3ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public SCHO3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public SCHO3ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public SCHO3ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public SCHO3ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public SCHO3ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class SCHO3AdditionalInterests extends AdditionalInterests<SCHO3AdditionalInterests>
	{
		public SCHO3AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public SCHO3ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new SCHO3ProtectionDetails(sh, path);
		}

		public SCHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO3Dwelling(sh, path);
		}
		public SCHO3AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public SCHO3NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new SCHO3NewAdditionalInterest(sh,path);
		}
		public SCHO3NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new SCHO3NewAdditionalInterest(sh,path);
		}
		public SCHO3SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new SCHO3SearchAddressBook(sh,path);
		}
		public SCHO3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public SCHO3AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public SCHO3AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public SCHO3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public SCHO3AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public SCHO3DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new SCHO3DwellingConstruction(sh, path);
		}






	}

}
