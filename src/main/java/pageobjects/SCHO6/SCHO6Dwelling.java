package pageobjects.SCHO6;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by aansari on 2/6/17.
 */
public class SCHO6Dwelling extends Dwelling<SCHO6Dwelling>
{
		public SCHO6Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public SCHO6DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new SCHO6DwellingConstruction(sh, path);
	}
	public SCHO6Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}

	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public SCHO6Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public SCHO6Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public SCHO6Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public SCHO6Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}
	public SCHO6Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public SCHO6Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public SCHO6Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public SCHO6Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public SCHO6Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public SCHO6Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public SCHO6Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public SCHO6Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public SCHO6Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public SCHO6Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public SCHO6Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public SCHO6Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public SCHO6Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public SCHO6Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public SCHO6Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public SCHO6Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public SCHO6ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new SCHO6ProtectionDetails(sh, path);
	}
	public SCHO6AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new SCHO6AdditionalInterests(sh, path);
	}
	public SCHO6Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public SCHO6Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public SCHO6Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public SCHO6Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public SCHO6Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public SCHO6Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public SCHO6Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public SCHO6Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public SCHO6Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public SCHO6Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public SCHO6Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public SCHO6Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public SCHO6LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new SCHO6LocationInformation(sh, path);
	}
	public SCHO6LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new SCHO6LocationInformation(sh, path);
	}

	public class SCHO6ProtectionDetails extends ProtectionDetails<SCHO6ProtectionDetails>
	{
		public SCHO6ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public SCHO6AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new SCHO6AdditionalInterests(sh, path);

		}
		public SCHO6Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO6Dwelling(sh, path);
		}
		public SCHO6DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new SCHO6DwellingConstruction(sh, path);
		}
		public SCHO6ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public SCHO6ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public SCHO6ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public SCHO6ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public SCHO6ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public SCHO6ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public SCHO6ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public SCHO6ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public SCHO6ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public SCHO6ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public SCHO6ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public SCHO6ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public SCHO6ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public SCHO6ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public SCHO6ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class SCHO6AdditionalInterests extends AdditionalInterests<SCHO6AdditionalInterests>
	{
		public SCHO6AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public SCHO6ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new SCHO6ProtectionDetails(sh, path);
		}

		public SCHO6Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new SCHO6Dwelling(sh, path);
		}
		public SCHO6AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public SCHO6NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new SCHO6NewAdditionalInterest(sh,path);
		}
		public SCHO6NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new SCHO6NewAdditionalInterest(sh,path);
		}
		public SCHO6SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new SCHO6SearchAddressBook(sh,path);
		}
		public SCHO6AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public SCHO6AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public SCHO6AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public SCHO6AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public SCHO6AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public SCHO6DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new SCHO6DwellingConstruction(sh, path);
		}






	}

}
