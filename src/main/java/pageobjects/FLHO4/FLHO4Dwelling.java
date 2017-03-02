package pageobjects.FLHO4;

import Helpers.CenterSeleniumHelper;
import pageobjects.WizardPanelBase.CenterPanelBase;
import pageobjects.WizardPanelBase.Dwelling;

/**
 * Created by ssai on 3/2/2017.
 */
public class FLHO4Dwelling extends Dwelling<FLHO4Dwelling> {

    public FLHO4Dwelling(CenterSeleniumHelper sh, CenterPanelBase.Path path)
    {
        super(sh, path);
    }

    public FLHO4DwellingConstruction next()
    {
        super.DwellingConstructionNext();
        return new FLHO4DwellingConstruction(sh, path);
    }
    public FLHO4Dwelling setYearBuilt(String text)
    {
        return super.setYearBuilt(text);
    }
    public FLHO4Dwelling Enter(){
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
    public FLHO4Dwelling setDistanceToFireHydrant(String text)
    {
        return super.setDistanceToFireHydrant(text);
    }

    public String getDistanceToFireHydrant()
    {
        return super.getDistanceToFireHydrant();
    }
    public FLHO4Dwelling setDistanceToFireStation(String text)
    {
        return super.setDistanceToFireStation(text);
    }

    public String getDistanceToFireStation()
    {
        return super.getDistanceToFireStation();
    }
    public FLHO4Dwelling setBCEG(String text)
    {
        return super.setBCEG(text);
    }

    public String getBCEG()
    {
        return super.getBCEG();
    }
    public FLHO4Dwelling setProtectionClassCode(String text)
    {
        return super.setProtectionClassCode(text);
    }

    public String getProtectionClassCode()
    {
        return super.getProtectionClassCode();
    }

    public FLHO4Dwelling waitForProtectionClassCode(String val)
    {
        super.waitForProtectionClassToUpdate(val);
        return new FLHO4Dwelling(sh, path);
    }

    public FLHO4Dwelling setTerritoryCode(String text)
    {
        return super.setTerritoryCode(text);
    }

    public String getTerritoryCode()
    {
        return super.getTerritoryCode();
    }
    public FLHO4Dwelling setLocationName(String text)
    {
        return super.setLocationName(text);
    }

    public String getLocationName()
    {
        return super.getLocationName();
    }
    public FLHO4Dwelling setLocalTaxJurisdiction(String text)
    {
        return super.setLocalTaxJurisdiction(text);
    }

    public String getLocalTaxJurisdiction()
    {
        return super.getLocalTaxJurisdiction();
    }
    public FLHO4Dwelling setLocationType(String text)
    {
        return super.setLocationType(text);
    }

    public String getLocationType()
    {
        return super.getLocationType();
    }
    public FLHO4Dwelling setDistanceToCoast(String text)
    {
        return super.setDistanceToCoast(text);
    }

    public String getDistanceToCoast()
    {
        return super.getDistanceToCoast();
    }
    public FLHO4Dwelling setPurchaseDate(String text)
    {
        return super.setPurchaseDate(text);
    }

    public String getPurchaseDate()
    {
        return super.getPurchaseDate();
    }
    public FLHO4Dwelling setPurchasePrice(String text)
    {
        return super.setPurchasePrice(text);
    }

    public String getPurchasePrice()
    {
        return super.getPurchasePrice();
    }
    public FLHO4Dwelling setMarketValue(String text)
    {
        return super.setMarketValue(text);
    }

    public String getMarketValue()
    {
        return super.getMarketValue();
    }
    public FLHO4Dwelling setResidenceType(String text)
    {
        return super.setResidenceType(text);
    }

    public String getResidenceType()
    {
        return super.getResidenceType();
    }
    public FLHO4Dwelling setDwellingUsage(String text)
    {
        return super.setDwellingUsage(text);
    }

    public String getDwellingUsage()
    {
        return super.getDwellingUsage();
    }
    public FLHO4Dwelling setDwellingOccupancy(String text)
    {
        return super.setDwellingOccupancy(text);
    }

    public String getDwellingOccupancy()
    {
        return super.getDwellingOccupancy();
    }
    public FLHO4Dwelling setHousekeepingCondition(String text)
    {
        return super.setHousekeepingCondition(text);
    }

    public String getHousekeepingCondition()
    {
        return super.getHousekeepingCondition();
    }
    public FLHO4Dwelling setInTheWindpool(String flag)
    {
        return super.setInTheWindpool(flag);
    }
    public FLHO4Dwelling setOwnedByOther(String flag)
    {
        return super.setOwnedByOther(flag);
    }
    public FLHO4Dwelling setOccupiedDaily(String flag)
    {
        return super.setOccupiedDaily(flag);
    }
    public FLHO4Dwelling setAtInceptionOfPolicyIsDeedOwnedByEntity(String flag)
    {
        return super.setAtInceptionOfPolicyIsDeedOwnedByEntity(flag);
    }
    public FLHO4ProtectionDetails clickProtectionDetails()
    {
        super.clickProtectionDetailsTab();
        return new FLHO4ProtectionDetails(sh, path);
    }
    public FLHO4AdditionalInterests clickAdditionalInterests()
    {
        super.clickAdditionalInterestsTab();
        return new FLHO4AdditionalInterests(sh, path);
    }

    public FLHO4Dwelling setSwimmingPool(String flag)
    {
        return super.setSwimmingPool(flag);
    }
    public FLHO4Dwelling setTrampolineOnPremises(String flag)
    {
        return super.setTrampolineOnPremises(flag);
    }
    public FLHO4Dwelling setSkateboardBicycleRampOnPremises(String flag)
    {
        return super.setSkateboardBicycleRampOnPremises(flag);
    }
    public FLHO4Dwelling setAnimalsOrExoticPets(String flag)
    {
        return super.setAnimalsOrExoticPets(flag);
    }
    public FLHO4Dwelling setGolfCarts(String flag)
    {
        return super.setGolfCarts(flag);
    }
    public FLHO4Dwelling setRecreationalVehiclesOwned(String flag)
    {
        return super.setRecreationalVehiclesOwned(flag);
    }
    public FLHO4Dwelling setPoolFenced(String flag)
    {
        return super.setPoolFenced(flag);
    }
    public FLHO4Dwelling setDivingBoard(String flag)
    {
        return super.setDivingBoard(flag);
    }
    public FLHO4Dwelling setPoolSlide(String flag)
    {
        return super.setPoolSlide(flag);
    }
    public FLHO4Dwelling setPoolLocation(String text)
    {
        return super.setPoolLocation(text);
    }

    public String getPoolLocation()
    {
        return super.getPoolLocation();
    }
    public FLHO4Dwelling setFenceType(String text)
    {
        return super.setFenceType(text);
    }

    public String getFenceType()
    {
        return super.getFenceType();
    }
    public FLHO4Dwelling setWindpoolZone(String text)
    {
        return super.setWindpoolZone(text);
    }

    public String getWindpoolZone()
    {
        return super.getWindpoolZone();
    }
    public FLHO4LocationInformation addNewLocation()
    {
        super.addNewDwellingLocation();
        return new FLHO4LocationInformation(sh, path);
    }
    public FLHO4LocationInformation editLocation()
    {
        super.editDwellingLocation();
        return new FLHO4LocationInformation(sh, path);
    }

    public class FLHO4ProtectionDetails extends ProtectionDetails<FLHO4ProtectionDetails>
    {
        public FLHO4ProtectionDetails(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }
        public FLHO4AdditionalInterests clickAdditionalInterests()
        {
            super.clickAdditionalInterestsTab();
            return new FLHO4AdditionalInterests(sh, path);

        }
        public FLHO4Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new FLHO4Dwelling(sh, path);
        }
        public FLHO4DwellingConstruction next()
        {
            dwellingConstructionNext();
            return new FLHO4DwellingConstruction(sh, path);
        }
        public FLHO4ProtectionDetails setBurglarAlarm(String flag)
        {
            return super.setBurglarAlarm(flag);
        }
        public FLHO4ProtectionDetails setLockedPrivacyFence(String flag)
        {
            return super.setLockedPrivacyFence(flag);
        }
        public FLHO4ProtectionDetails setBurglarBarsOnWindows(String flag)
        {
            return super.setBurglarBarsOnWindows(flag);
        }
        public FLHO4ProtectionDetails setCommunityGuarded(String flag)
        {
            return super.setCommunityGuarded(flag);
        }
        public FLHO4ProtectionDetails setGatedCommunity(String flag)
        {
            return super.setGatedCommunity(flag);
        }
        public FLHO4ProtectionDetails setFireAlarm(String flag)
        {
            return super.setFireAlarm(flag);
        }
        public FLHO4ProtectionDetails setSmokeAlarm(String flag)
        {
            return super.setSmokeAlarm(flag);
        }
        public FLHO4ProtectionDetails setFireExtinguishers(String flag)
        {
            return super.setFireExtinguishers(flag);
        }
        public FLHO4ProtectionDetails setSprinklerSystem(String flag)
        {
            return super.setSprinklerSystem(flag);
        }
        public FLHO4ProtectionDetails setDeadbolts(String flag)
        {
            return super.setDeadbolts(flag);
        }
        public FLHO4ProtectionDetails clickProtectionDetailsenter(){return super.clickProtectionDetailsEnter();}

        public FLHO4ProtectionDetails setResidenceVisibleToNeighbors(String flag)
        {
            return super.setResidenceVisibleToNeighbors(flag);
        }
        public FLHO4ProtectionDetails safetyLatchesPresent(String flag)
        {
            return super.safetyLatchesPresent(flag);
        }
        public FLHO4ProtectionDetails setBurglarAlarmType(String text)
        {
            return super.setBurglarAlarmType(text);
        }

        public String getBurglarAlarmType()
        {
            return super.getBurglarAlarmType();
        }
        public FLHO4ProtectionDetails setFireAlarmType(String text)
        {
            return super.setFireAlarmType(text);
        }

        public String getFireAlarmType()
        {
            return super.getFireAlarmType();
        }

        public FLHO4ProtectionDetails setSprinklerSystemType(String text)
        {
            return super.setSprinklerSystemType(text);
        }

        public String getSprinklerSystemType()
        {
            return super.getSprinklerSystemType();
        }

    }

    public class FLHO4AdditionalInterests extends AdditionalInterests<FLHO4AdditionalInterests>
    {
        public FLHO4AdditionalInterests(CenterSeleniumHelper sh, Path path)
        {
            super(sh, path);
        }


        public FLHO4ProtectionDetails clickProtectionDetails()
        {
            super.clickProtectionDetailsTab();
            return new FLHO4ProtectionDetails(sh, path);
        }

        public FLHO4Dwelling clickDetails()
        {
            super.clickDetailsTab();
            return new FLHO4Dwelling(sh, path);
        }
        public FLHO4AdditionalInterests clickRemove()
        {
            super.clickRemove();
            return this;
        }
        public FLHO4NewAdditionalInterest clickAddNewPerson()
        {
            addNewPerson();
            return new FLHO4NewAdditionalInterest(sh,path);
        }
        public FLHO4NewAdditionalInterest clickAddNewCompany()
        {
            addNewCompany();
            return new FLHO4NewAdditionalInterest(sh,path);
        }
        public FLHO4SearchAddressBook clickFromAddressBook()
        {
            fromAddressBook();
            return new FLHO4SearchAddressBook(sh,path);
        }
        public FLHO4AdditionalInterests selectRowInAdditionalInterest(String typeEffectiveDateLoanNumber)
        {
            return super.selectRowInAdditionalInterest(typeEffectiveDateLoanNumber);
        }
        public FLHO4AdditionalInterests selectRowInAdditionalInterestByName(String name)
        {
            return super.selectRowInAdditionalInterestByName(name);
        }
        public FLHO4AdditionalInterests setType(int row, String type)
        {
            return super.setType(row,type);
        }
        public FLHO4AdditionalInterests setEffectiveDate(int row, String effectiveDate)
        {
            return super.setEffectiveDate(row,effectiveDate);
        }
        public FLHO4AdditionalInterests setLoanNumber(int row, String loanNumber)
        {
            return super.setLoanNumber(row,loanNumber);
        }
        public FLHO4DwellingConstruction next()
        {
            super.dwellingConstructionNext();
            return new FLHO4DwellingConstruction(sh, path);
        }
    }
}
