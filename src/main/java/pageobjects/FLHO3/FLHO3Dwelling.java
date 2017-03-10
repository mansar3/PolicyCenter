package pageobjects.FLHO3;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.Dwelling;


/**
 * Created by aansari on 2/2/17.
 */
public class FLHO3Dwelling extends Dwelling<FLHO3Dwelling>
{
	public FLHO3Dwelling(CenterSeleniumHelper sh, Path path)
	{
		super(sh, path);
	}

	public FLHO3DwellingConstruction next()
	{
		super.DwellingConstructionNext();
		return new FLHO3DwellingConstruction(sh, path);
	}
	public FLHO3Dwelling setYearBuilt(String text)
	{
		return super.setYearBuilt(text);
	}
	public FLHO3Dwelling Enter(){
		return super.Enter();
	}

	public String getdwellingErrorMessage()
	{
		return super.dwellingErrorMessage();
	}

	public String getYearBuilt()
	{
		return super.getYearBuilt();
	}
	public FLHO3Dwelling setDistanceToFireHydrant(String text)
	{
		return super.setDistanceToFireHydrant(text);
	}

	public String getDistanceToFireHydrant()
	{
		return super.getDistanceToFireHydrant();
	}
	public FLHO3Dwelling setDistanceToFireStation(String text)
	{
		return super.setDistanceToFireStation(text);
	}

	public String getDistanceToFireStation()
	{
		return super.getDistanceToFireStation();
	}
	public FLHO3Dwelling setBCEG(String text)
	{
		return super.setBCEG(text);
	}

	public String getBCEG()
	{
		return super.getBCEG();
	}
	public FLHO3Dwelling setProtectionClassCode(String text)
	{
		return super.setProtectionClassCode(text);
	}

	public String getProtectionClassCode()
	{
		return super.getProtectionClassCode();
	}

	public FLHO3Dwelling waitForProtectionClassCode(String val)
	{
		super.waitForProtectionClassToUpdate(val);
		return new FLHO3Dwelling(sh, path);
	}

	public FLHO3Dwelling setTerritoryCode(String text)
	{
		return super.setTerritoryCode(text);
	}

	public String getTerritoryCode()
	{
		return super.getTerritoryCode();
	}
	public FLHO3Dwelling setLocationName(String text)
	{
		return super.setLocationName(text);
	}

	public String getLocationName()
	{
		return super.getLocationName();
	}
	public FLHO3Dwelling setLocalTaxJurisdiction(String text)
	{
		return super.setLocalTaxJurisdiction(text);
	}

	public String getLocalTaxJurisdiction()
	{
		return super.getLocalTaxJurisdiction();
	}
	public FLHO3Dwelling setLocationType(String text)
	{
		return super.setLocationType(text);
	}

	public String getLocationType()
	{
		return super.getLocationType();
	}
	public FLHO3Dwelling setDistanceToCoast(String text)
	{
		return super.setDistanceToCoast(text);
	}

	public String getDistanceToCoast()
	{
		return super.getDistanceToCoast();
	}
	public FLHO3Dwelling setPurchaseDate(String text)
	{
		return super.setPurchaseDate(text);
	}

	public String getPurchaseDate()
	{
		return super.getPurchaseDate();
	}
	public FLHO3Dwelling setPurchasePrice(String text)
	{
		return super.setPurchasePrice(text);
	}

	public String getPurchasePrice()
	{
		return super.getPurchasePrice();
	}
	public FLHO3Dwelling setMarketValue(String text)
	{
		return super.setMarketValue(text);
	}

	public String getMarketValue()
	{
		return super.getMarketValue();
	}
	public FLHO3Dwelling setResidenceType(String text)
	{
		return super.setResidenceType(text);
	}

	public String getResidenceType()
	{
		return super.getResidenceType();
	}
	public FLHO3Dwelling setDwellingUsage(String text)
	{
		return super.setDwellingUsage(text);
	}

	public String getDwellingUsage()
	{
		return super.getDwellingUsage();
	}
	public FLHO3Dwelling setDwellingOccupancy(String text)
	{
		return super.setDwellingOccupancy(text);
	}

	public String getDwellingOccupancy()
	{
		return super.getDwellingOccupancy();
	}
	public FLHO3Dwelling setHousekeepingCondition(String text)
	{
		return super.setHousekeepingCondition(text);
	}

	public String getHousekeepingCondition()
	{
		return super.getHousekeepingCondition();
	}
	public FLHO3Dwelling setInTheWindpool(String flag)
	{
		return super.setInTheWindpool(flag);
	}
	public FLHO3Dwelling setOwnedByOther(String flag)
	{
		return super.setOwnedByOther(flag);
	}
	public FLHO3Dwelling setOccupiedDaily(String flag)
	{
		return super.setOccupiedDaily(flag);
	}
	public FLHO3Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
	{
		return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
	}
	public FLHO3ProtectionDetails clickProtectionDetails()
	{
		super.clickProtectionDetailsTab();
		return new FLHO3ProtectionDetails(sh, path);
	}
	public FLHO3AdditionalInterests clickAdditionalInterests()
	{
		super.clickAdditionalInterestsTab();
		return new FLHO3AdditionalInterests(sh, path);
	}

	public FLHO3Dwelling setSwimmingPool(String flag)
	{
		return super.setSwimmingPool(flag);
	}
	public FLHO3Dwelling setTrampolineOnPremises(String flag)
	{
		return super.setTrampolineOnPremises(flag);
	}
	public FLHO3Dwelling setSkateboardBicycleRampOnPremises(String flag)
	{
		return super.setSkateboardBicycleRampOnPremises(flag);
	}
	public FLHO3Dwelling setAnimalsOrExoticPets(String flag)
	{
		return super.setAnimalsOrExoticPets(flag);
	}

	public FLHO3Dwelling setGolfCarts(String flag)
	{
		return super.setGolfCarts(flag);
	}
	public FLHO3Dwelling setRecreationalVehiclesOwned(String flag)
	{
		return super.setRecreationalVehiclesOwned(flag);
	}
	public FLHO3Dwelling setPoolFenced(String flag)
	{
		return super.setPoolFenced(flag);
	}
	public FLHO3Dwelling setDivingBoard(String flag)
	{
		return super.setDivingBoard(flag);
	}
	public FLHO3Dwelling setPoolSlide(String flag)
	{
		return super.setPoolSlide(flag);
	}
	public FLHO3Dwelling setPoolLocation(String text)
	{
		return super.setPoolLocation(text);
	}

	public String getPoolLocation()
	{
		return super.getPoolLocation();
	}
	public FLHO3Dwelling setFenceType(String text)
	{
		return super.setFenceType(text);
	}

	public String getFenceType()
	{
		return super.getFenceType();
	}
	public FLHO3Dwelling setWindpoolZone(String text)
	{
		return super.setWindpoolZone(text);
	}

	public String getWindpoolZone()
	{
		return super.getWindpoolZone();
	}
	public FLHO3LocationInformation addNewLocation()
	{
		super.addNewDwellingLocation();
		return new FLHO3LocationInformation(sh, path);
	}
	public FLHO3LocationInformation editLocation()
	{
		super.editDwellingLocation();
		return new FLHO3LocationInformation(sh, path);
	}

	public class FLHO3ProtectionDetails extends ProtectionDetails<FLHO3ProtectionDetails>
	{
		public FLHO3ProtectionDetails(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}
		public FLHO3AdditionalInterests clickAdditionalInterests()
		{
			super.clickAdditionalInterestsTab();
			return new FLHO3AdditionalInterests(sh, path);

		}
		public FLHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLHO3Dwelling(sh, path);
		}
		public FLHO3DwellingConstruction next()
		{
			dwellingConstructionNext();
			return new FLHO3DwellingConstruction(sh, path);
		}
		public FLHO3ProtectionDetails setBurglarAlarm(String flag)
		{
			return super.setBurglarAlarm(flag);
		}
		public FLHO3ProtectionDetails setLockedPrivacyFence(String flag)
		{
			return super.setLockedPrivacyFence(flag);
		}
		public FLHO3ProtectionDetails setBurglarBarsOnWindows(String flag)
		{
			return super.setBurglarBarsOnWindows(flag);
		}
		public FLHO3ProtectionDetails setCommunityGuarded(String flag)
		{
			return super.setCommunityGuarded(flag);
		}
		public FLHO3ProtectionDetails setGatedCommunity(String flag)
		{
			return super.setGatedCommunity(flag);
		}
		public FLHO3ProtectionDetails setFireAlarm(String flag)
		{
			return super.setFireAlarm(flag);
		}
		public FLHO3ProtectionDetails setSmokeAlarm(String flag)
		{
			return super.setSmokeAlarm(flag);
		}
		public FLHO3ProtectionDetails setFireExtinguishers(String flag)
		{
			return super.setFireExtinguishers(flag);
		}
		public FLHO3ProtectionDetails setSprinklerSystem(String flag)
		{
			return super.setSprinklerSystem(flag);
		}
		public FLHO3ProtectionDetails setDeadbolts(String flag)
		{
			return super.setDeadbolts(flag);
		}
		public FLHO3ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

		public FLHO3ProtectionDetails setResidenceVisibleToNeighbors(String flag)
		{
			return super.setResidenceVisibleToNeighbors(flag);
		}
		public FLHO3ProtectionDetails safetyLatchesPresent(String flag)
		{
			return super.safetyLatchesPresent(flag);
		}
		public FLHO3ProtectionDetails setBurglarAlarmType(String text)
		{
			return super.setBurglarAlarmType(text);
		}

		public String getBurglarAlarmType()
		{
			return super.getBurglarAlarmType();
		}
		public FLHO3ProtectionDetails setFireAlarmType(String text)
		{
			return super.setFireAlarmType(text);
		}

		public String getFireAlarmType()
		{
			return super.getFireAlarmType();
		}

		public FLHO3ProtectionDetails setSprinklerSystemType(String text)
		{
			return super.setSprinklerSystemType(text);
		}

		public String getSprinklerSystemType()
		{
			return super.getSprinklerSystemType();
		}

	}

	public class FLHO3AdditionalInterests extends AdditionalInterests<FLHO3AdditionalInterests>
	{
		public FLHO3AdditionalInterests(CenterSeleniumHelper sh, Path path)
		{
			super(sh, path);
		}


		public FLHO3ProtectionDetails clickProtectionDetails()
		{
			super.clickProtectionDetailsTab();
			return new FLHO3ProtectionDetails(sh, path);
		}

		public FLHO3Dwelling clickDetails()
		{
			super.clickDetailsTab();
			return new FLHO3Dwelling(sh, path);
		}
		public FLHO3AdditionalInterests clickRemove()
		{
			super.clickRemove();
			return this;
		}
		public FLHO3NewAdditionalInterest clickAddNewPerson()
		{
			addNewPerson();
			return new FLHO3NewAdditionalInterest(sh,path);
		}
		public FLHO3NewAdditionalInterest clickAddNewCompany()
		{
			addNewCompany();
			return new FLHO3NewAdditionalInterest(sh,path);
		}
		public FLHO3SearchAddressBook clickFromAddressBook()
		{
			fromAddressBook();
			return new FLHO3SearchAddressBook(sh,path);
		}
		public FLHO3AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
		{
			return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
		}
		public FLHO3AdditionalInterests selectRowInAdditionalInterestByName(String name)
		{
			return super.selectRowInAdditionalInterestByName(name);
		}
		public FLHO3AdditionalInterests setType(int row, String type)
		{
			return super.setType(row,type);
		}
		public FLHO3AdditionalInterests setEffectiveDate(int row, String effectiveDate)
		{
			return super.setEffectiveDate(row,effectiveDate);
		}
		public FLHO3AdditionalInterests setLoanNumber(int row, String loanNumber)
		{
			return super.setLoanNumber(row,loanNumber);
		}
		public FLHO3DwellingConstruction next()
		{
			super.dwellingConstructionNext();
			return new FLHO3DwellingConstruction(sh, path);
		}
	}
}
