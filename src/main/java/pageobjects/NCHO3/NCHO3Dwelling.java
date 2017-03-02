package pageobjects.NCHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by aansari on 2/6/17.
 */
public class NCHO3Dwelling extends Dwelling<NCHO3Dwelling>
{
		public NCHO3Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public NCHO3DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new NCHO3DwellingConstruction(sh, path);
	}

	public String getdwellingErrorMessage()
	{
		return super.dwellingErrorMessage();
	}

	public NCHO3Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}
	public NCHO3Dwelling Enter(){
		return super.Enter();
	}
	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public NCHO3Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public NCHO3Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public NCHO3Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public NCHO3Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}

	public NCHO3Dwelling waitForProtectionClassCode(String val)
	{
		super.waitForProtectionClassToUpdate(val);
		return new NCHO3Dwelling(sh, path);
	}

	public NCHO3Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public NCHO3Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public NCHO3Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public NCHO3Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public NCHO3Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public NCHO3Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public NCHO3Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public NCHO3Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public NCHO3Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public NCHO3Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public NCHO3Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public NCHO3Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public NCHO3Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public NCHO3Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public NCHO3Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public NCHO3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public NCHO3ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new NCHO3ProtectionDetails(sh, path);
	}
	public NCHO3AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new NCHO3AdditionalInterests(sh, path);
	}
	public NCHO3Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public NCHO3Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public NCHO3Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public NCHO3Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}
	public NCHO3Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public NCHO3Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public NCHO3Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public NCHO3Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public NCHO3Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public NCHO3Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public NCHO3Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public NCHO3Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public NCHO3LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new NCHO3LocationInformation(sh, path);
	}
	public NCHO3LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new NCHO3LocationInformation(sh, path);
	}

	public class NCHO3ProtectionDetails extends ProtectionDetails<NCHO3ProtectionDetails>
	{
		public NCHO3ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public NCHO3AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new NCHO3AdditionalInterests(sh, path);

		}
		public NCHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new NCHO3Dwelling(sh, path);
		}
		public NCHO3DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new NCHO3DwellingConstruction(sh, path);
		}
		public NCHO3ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public NCHO3ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public NCHO3ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public NCHO3ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public NCHO3ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public NCHO3ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public NCHO3ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public NCHO3ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public NCHO3ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public NCHO3ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public NCHO3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public NCHO3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}
		public NCHO3ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public NCHO3ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public NCHO3ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public NCHO3ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class NCHO3AdditionalInterests extends AdditionalInterests<NCHO3AdditionalInterests>
	{
		public NCHO3AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public NCHO3ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new NCHO3ProtectionDetails(sh, path);
		}

		public NCHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new NCHO3Dwelling(sh, path);
		}
		public NCHO3AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public NCHO3NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new NCHO3NewAdditionalInterest(sh,path);
		}
		public NCHO3NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new NCHO3NewAdditionalInterest(sh,path);
		}
		public NCHO3SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new NCHO3SearchAddressBook(sh,path);
		}
		public NCHO3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public NCHO3AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public NCHO3AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public NCHO3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public NCHO3AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public NCHO3DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new NCHO3DwellingConstruction(sh, path);
		}
	}
}
